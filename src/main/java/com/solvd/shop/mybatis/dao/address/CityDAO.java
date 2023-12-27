package com.solvd.shop.mybatis.dao.address;

import com.solvd.shop.interfaces.address.ICityDAO;
import com.solvd.shop.models.address.City;
import com.solvd.shop.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CityDAO implements ICityDAO<City> {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LogManager.getLogger(CityDAO.class);
    private static ICityDAO batisDAO;

    public CityDAO() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public void insert(City city) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICityDAO.class);
            batisDAO.insert(city);
            sqlSession.commit();
        }
    }


    @Override
    public void update(City city) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICityDAO.class);
            batisDAO.update(city);
            sqlSession.commit();
        }
    }
    @Override
    public void delete(City city) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICityDAO.class);
            batisDAO.delete(city);
            sqlSession.commit();
        }
    }

    @Override
    public City getByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICityDAO.class);
            return (City) batisDAO.getByID(id);
        }
    }

    @Override
    public List<City> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICityDAO.class);
            return batisDAO.getAll();
        }
    }

    @Override
    public City getByCityName(String cityName) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICityDAO.class);
            return (City) batisDAO.getByCityName(cityName);
        }
    }
}
