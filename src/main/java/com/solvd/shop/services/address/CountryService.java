package com.solvd.shop.services.address;

import com.solvd.shop.interfaces.address.ICountryDAO;
import com.solvd.shop.models.address.Country;
import com.solvd.shop.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CountryService implements ICountryDAO<Country> {

    private static final Logger LOGGER = LogManager.getLogger(CountryService.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static ICountryDAO batisDAO;

    public CountryService() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            this.batisDAO = sqlSession.getMapper(ICountryDAO.class);
        }
    }

    @Override
    public void insert(Country country) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICountryDAO.class);
            batisDAO.insert(country);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Country country) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICountryDAO.class);
            batisDAO.update(country);
            sqlSession.commit();
        }
    }


    @Override
    public void delete(Country country) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICountryDAO.class);
            batisDAO.delete(country);
            sqlSession.commit();
        }
    }


    @Override
    public Country getByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICountryDAO.class);
            return (Country) batisDAO.getByID(id);
        }
    }



    @Override
    public List<Country> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICountryDAO.class);
            return batisDAO.getAll();
        }
    }

    @Override
    public Country getByCountryName(String countryName) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(ICountryDAO.class);
            return (Country) batisDAO.getByCountryName(countryName);
        }
    }
}
