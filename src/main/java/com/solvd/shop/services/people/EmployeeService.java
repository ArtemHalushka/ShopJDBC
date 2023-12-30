package com.solvd.shop.services.people;

import com.solvd.shop.interfaces.people.IEmployeeDAO;
import com.solvd.shop.models.people.Employee;
import com.solvd.shop.mybatis.dao.people.EmployeeDAO;

import java.util.List;

public class EmployeeService implements IEmployeeDAO<Employee> {

    private static final EmployeeDAO employeeDAO = new EmployeeDAO();

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
