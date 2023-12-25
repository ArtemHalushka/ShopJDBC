package com.solvd.shop.services.people;

import com.solvd.shop.interfaces.people.IEmployeeDAO;
import com.solvd.shop.models.people.Employee;
import com.solvd.shop.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EmployeeService implements IEmployeeDAO<Employee> {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LogManager.getLogger(EmployeeService.class);
    private static IEmployeeDAO batisDAO;

    public EmployeeService() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public void insert(Employee employee) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IEmployeeDAO.class);
            batisDAO.insert(employee);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Employee employee) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IEmployeeDAO.class);
            batisDAO.update(employee);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Employee employee) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IEmployeeDAO.class);
            batisDAO.delete(employee);
            sqlSession.commit();
        }
    }

    @Override
    public Employee getByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IEmployeeDAO.class);
            return (Employee) batisDAO.getByID(id);
        }
    }

    @Override
    public List<Employee> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IEmployeeDAO.class);
            return batisDAO.getAll();
        }
    }

    @Override
    public Employee getByName(String name) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            batisDAO = sqlSession.getMapper(IEmployeeDAO.class);
            return (Employee) batisDAO.getByName(name);
        }
    }

}
