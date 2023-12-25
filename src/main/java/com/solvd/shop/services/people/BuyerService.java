package com.solvd.shop.services.people;

import com.solvd.shop.interfaces.people.IBuyerDAO;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BuyerService implements IBuyerDAO<Buyer> {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LogManager.getLogger(BuyerService.class);
    private static IBuyerDAO batisDAO;

    public BuyerService() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    }

    @Override
    public void insert(Buyer buyer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IBuyerDAO.class);
            batisDAO.insert(buyer);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Buyer buyer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IBuyerDAO.class);
            batisDAO.update(buyer);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Buyer buyer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IBuyerDAO.class);
            batisDAO.delete(buyer);
            sqlSession.commit();
        }
    }

    @Override
    public Buyer getByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            batisDAO = sqlSession.getMapper(IBuyerDAO.class);
            return (Buyer) batisDAO.getByID(id);
        }
    }

    @Override
    public List<Buyer> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IBuyerDAO.class);
            return batisDAO.getAll();
        }
    }

    @Override
    public Buyer getByName(String name) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IBuyerDAO.class);
            return (Buyer) batisDAO.getByName(name);
        }
    }
}
