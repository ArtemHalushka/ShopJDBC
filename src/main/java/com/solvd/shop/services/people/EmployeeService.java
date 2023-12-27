package com.solvd.shop.services.people;

import com.solvd.shop.interfaces.people.IEmployeeDAO;
import com.solvd.shop.models.people.Employee;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.shop.mybatis.dao.people.EmployeeDAO;

import java.util.List;

public class EmployeeService implements IEmployeeDAO<Employee> {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(EmployeeService.class);
    private static final EmployeeDAO batisDAO = new EmployeeDAO();


    @Override
    public void insert(Employee employee) {
        batisDAO.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        batisDAO.update(employee);
    }

    @Override
    public void delete(Employee employee) {
        batisDAO.delete(employee);
    }

    @Override
    public Employee getByID(int id) {
        return batisDAO.getByID(id);
    }

    @Override
    public List<Employee> getAll() {
        return batisDAO.getAll();
    }

    @Override
    public Employee getByName(String name) {
        return batisDAO.getByName(name);
    }
}
