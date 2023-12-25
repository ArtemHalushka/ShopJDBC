package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.IPositionDAO;
import com.solvd.shop.models.shop.Position;
import com.solvd.shop.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.shop.mybatis.dao.shop.PositionDAO;

import java.util.List;

public class PositionService implements IPositionDAO<Position> {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LogManager.getLogger(PositionService.class);
    private static IPositionDAO batisDAO;

    public PositionService() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public void insert(Position position) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IPositionDAO.class);
            batisDAO.insert(position);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Position position) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IPositionDAO.class);
            batisDAO.update(position);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Position position) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IPositionDAO.class);
            batisDAO.delete(position);
            sqlSession.commit();
        }
    }

    @Override
    public Position getByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IPositionDAO.class);
            return (Position) batisDAO.getByID(id);
        }
    }

    @Override
    public List<Position> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IPositionDAO.class);
            return batisDAO.getAll();
        }
    }

    @Override
    public Position getBySalary(double salary) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IPositionDAO.class);
            return (Position) batisDAO.getBySalary(salary);
        }
    }
}
