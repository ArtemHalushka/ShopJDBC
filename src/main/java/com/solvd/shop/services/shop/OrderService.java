package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.IOrderDAO;
import com.solvd.shop.interfaces.shop.IOrderHasProductDAO;
import com.solvd.shop.jdbc.dao.shop.OrderDAO;
import com.solvd.shop.models.shop.Order;
import com.solvd.shop.util.ConnectionPool;
import com.solvd.shop.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class OrderService implements IOrderDAO<Order> {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LogManager.getLogger(OrderService.class);
    private static IOrderDAO batisDAO;

    public OrderService() {
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
