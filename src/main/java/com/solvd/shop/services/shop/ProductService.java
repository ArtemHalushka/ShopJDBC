package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.IProductDAO;
import com.solvd.shop.models.shop.Product;
import com.solvd.shop.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.shop.mybatis.dao.shop.ProductDAO;

import java.util.List;

public class ProductService implements IProductDAO<Product> {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LogManager.getLogger(ProductService.class);
    private static IProductDAO batisDAO;

    public ProductService() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public void insert(Product product) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IProductDAO.class);
            batisDAO.insert(product);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Product product) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IProductDAO.class);
            batisDAO.update(product);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Product product) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IProductDAO.class);
            batisDAO.delete(product);
            sqlSession.commit();
        }
    }

    @Override
    public Product getByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IProductDAO.class);
            return (Product) batisDAO.getByID(id);
        }
    }

    @Override
    public List<Product> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IProductDAO.class);
            return batisDAO.getAll();
        }
    }

    @Override
    public Product getByProductName(String name) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IProductDAO.class);
            return (Product) batisDAO.getByProductName(name);
        }
    }
}