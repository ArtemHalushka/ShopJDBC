package com.solvd.shop.services.people;

import com.solvd.shop.interfaces.people.IEmployeeDAO;
import com.solvd.shop.jdbc.dao.people.EmployeeDAO;
import com.solvd.shop.models.people.Employee;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeDAO<Employee> {

    private static ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(EmployeeService.class);

    private static final EmployeeDAO employeeDAO = new EmployeeDAO(connectionPool);

    static {
        try {
            connectionPool = ConnectionPool.getInstance();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void insert(Employee employee) {
        employeeDAO.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeDAO.delete(employee);
    }

    @Override
    public Employee getByID(int id) {
        return employeeDAO.getByID(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    public Employee getByName(String name) {
        return employeeDAO.getByName(name);
    }
}
