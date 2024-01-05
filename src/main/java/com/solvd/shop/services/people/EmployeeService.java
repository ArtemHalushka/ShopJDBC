package com.solvd.shop.services.people;

import com.solvd.shop.factory.ConnectionDAOException;
import com.solvd.shop.factory.ConnectionDAOFactory;
import com.solvd.shop.factory.DBConnectionType;
import com.solvd.shop.interfaces.people.IEmployeeDAO;
import com.solvd.shop.models.people.Employee;
import com.solvd.shop.mybatis.dao.people.EmployeeDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EmployeeService implements IEmployeeDAO<Employee> {

    private static final Logger LOGGER = LogManager.getLogger(EmployeeService.class);

    private static EmployeeDAO employeeDAO = null;

    static {
        try {
            employeeDAO = (EmployeeDAO) new ConnectionDAOFactory().getDAOFactory(DBConnectionType.MYBATIS).getDAO("employees");
        } catch (ConnectionDAOException e) {
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
