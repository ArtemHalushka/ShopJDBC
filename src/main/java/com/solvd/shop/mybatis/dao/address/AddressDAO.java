package com.solvd.shop.mybatis.dao.address;

import com.solvd.shop.interfaces.address.IAddressDAO;
import com.solvd.shop.models.address.Address;
import com.solvd.shop.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AddressDAO implements IAddressDAO<Address> {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);
    private static IAddressDAO batisDAO;

    public AddressDAO() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    }

    @Override
    public void insert(Address address) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IAddressDAO.class);
            batisDAO.insert(address);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Address address) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IAddressDAO.class);
            batisDAO.update(address);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Address address) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IAddressDAO.class);
            batisDAO.delete(address);
            sqlSession.commit();
        }
    }

    @Override
    public Address getByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IAddressDAO.class);
            return (Address) batisDAO.getByID(id);
        }
    }

    @Override
    public List<Address> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IAddressDAO.class);
            return batisDAO.getAll();
        }
    }

    @Override
    public Address getByFirstLine(String firstLine) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IAddressDAO.class);
            return (Address) batisDAO.getByFirstLine(firstLine);
        }
    }
}
