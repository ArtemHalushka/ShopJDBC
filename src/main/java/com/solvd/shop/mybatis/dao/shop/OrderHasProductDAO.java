package com.solvd.shop.mybatis.dao.shop;

import com.solvd.shop.interfaces.shop.IOrderHasProductDAO;
import com.solvd.shop.models.shop.OrderHasProduct;
import com.solvd.shop.models.shop.Product;
import com.solvd.shop.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OrderHasProductDAO implements IOrderHasProductDAO<OrderHasProduct, Product> {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LogManager.getLogger(OrderHasProductDAO.class);
    private static IOrderHasProductDAO batisDAO;

    public OrderHasProductDAO() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }


    @Override
    public void insert(OrderHasProduct orderHasProduct) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IOrderHasProductDAO.class);
            batisDAO.insert(orderHasProduct);
            sqlSession.commit();
        }
    }

    @Override
    public void update(OrderHasProduct orderHasProduct) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IOrderHasProductDAO.class);
            batisDAO.update(orderHasProduct);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(OrderHasProduct orderHasProduct) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IOrderHasProductDAO.class);
            batisDAO.delete(orderHasProduct);
            sqlSession.commit();
        }
    }

    @Override
    public OrderHasProduct getByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IOrderHasProductDAO.class);
            return (OrderHasProduct) batisDAO.getByID(id);
        }
    }

    @Override
    public List<OrderHasProduct> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IOrderHasProductDAO.class);
            return batisDAO.getAll();
        }
    }

    @Override
    public List<Product> getAllByOrderId(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IOrderHasProductDAO.class);
            return batisDAO.getAllByOrderId(id);
        }
    }
}