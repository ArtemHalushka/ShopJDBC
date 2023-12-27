package com.solvd.shop.mybatis.dao.shop;

import com.solvd.shop.interfaces.shop.ICategoryDAO;
import com.solvd.shop.models.shop.Category;
import com.solvd.shop.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CategoryDAO implements ICategoryDAO<Category> {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LogManager.getLogger(CategoryDAO.class);
    private static ICategoryDAO batisDAO;

    public CategoryDAO() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public void insert(Category category) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICategoryDAO.class);
            batisDAO.insert(category);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Category category) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICategoryDAO.class);
            batisDAO.update(category);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Category category) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICategoryDAO.class);
            batisDAO.delete(category);
            sqlSession.commit();
        }
    }

    @Override
    public Category getByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICategoryDAO.class);
            return (Category) batisDAO.getByID(id);
        }
    }

    @Override
    public List<Category> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICategoryDAO.class);
            return batisDAO.getAll();
        }
    }

    @Override
    public Category getByCategoryName(String name) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICategoryDAO.class);
            return (Category) batisDAO.getByCategoryName(name);
        }
    }
}
