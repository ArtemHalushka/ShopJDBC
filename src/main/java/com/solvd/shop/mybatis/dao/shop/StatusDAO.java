package com.solvd.shop.mybatis.dao.shop;

import com.solvd.shop.interfaces.shop.IStatusDAO;
import com.solvd.shop.models.shop.Status;
import com.solvd.shop.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class StatusDAO implements IStatusDAO<Status> {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LogManager.getLogger(StatusDAO.class);
    private static IStatusDAO batisDAO;

    public StatusDAO() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }
    @Override
    public void insert(Status status) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IStatusDAO.class);
            batisDAO.insert(status);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Status status) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IStatusDAO.class);
            batisDAO.update(status);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Status status) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IStatusDAO.class);
            batisDAO.delete(status);
            sqlSession.commit();
        }
    }

    @Override
    public Status getByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IStatusDAO.class);
            return (Status) batisDAO.getByID(id);
        }
    }

    @Override
    public List<Status> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IStatusDAO.class);
            return batisDAO.getAll();
        }
    }

    @Override
    public Status getByStatusName(String name) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IStatusDAO.class);
            return (Status) batisDAO.getByStatusName(name);
        }
    }
}
