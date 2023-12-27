package com.solvd.shop.mybatis.dao.people;

import com.solvd.shop.interfaces.people.ISupplierDAO;
import com.solvd.shop.models.people.Supplier;
import com.solvd.shop.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SupplierDAO implements ISupplierDAO<Supplier> {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LogManager.getLogger(SupplierDAO.class);
    private static ISupplierDAO batisDAO;

    public SupplierDAO() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public void insert(Supplier supplier) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ISupplierDAO.class);
            batisDAO.insert(supplier);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Supplier supplier) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ISupplierDAO.class);
            batisDAO.update(supplier);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Supplier supplier) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ISupplierDAO.class);
            batisDAO.delete(supplier);
            sqlSession.commit();
        }
    }

    @Override
    public Supplier getByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ISupplierDAO.class);
            return (Supplier) batisDAO.getByID(id);
        }
    }

    @Override
    public List<Supplier> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ISupplierDAO.class);
            return batisDAO.getAll();
        }
    }

    @Override
    public Supplier getByName(String name) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ISupplierDAO.class);
            return (Supplier) batisDAO.getByName(name);
        }
    }
}
