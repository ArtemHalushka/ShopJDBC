package com.solvd.shop.mybatis.dao.shop;

import com.solvd.shop.interfaces.shop.IOrderDAO;
import com.solvd.shop.models.shop.Order;
import com.solvd.shop.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;

public class OrderDAO implements IOrderDAO<Order> {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);
    private static IOrderDAO batisDAO;

    public OrderDAO() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public void insert(Order order) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IOrderDAO.class);
            batisDAO.insert(order);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Order order) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IOrderDAO.class);
            batisDAO.update(order);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Order order) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IOrderDAO.class);
            batisDAO.delete(order);
            sqlSession.commit();
        }
    }

    @Override
    public Order getByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IOrderDAO.class);
            return (Order) batisDAO.getByID(id);
        }
    }

    @Override
    public List<Order> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IOrderDAO.class);
            return batisDAO.getAll();
        }
    }

    @Override
    public Order getByDate(Date date) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IOrderDAO.class);
            return (Order) batisDAO.getByDate(date);
        }
    }
}
