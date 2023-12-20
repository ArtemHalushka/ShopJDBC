package com.solvd.shop.interafaces.people;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.models.people.Employee;

import java.util.List;

public interface IEmployeeDAO extends IBaseDAO {

    Employee getByName(String name);

    @Override
    Employee getByID(int id);

    @Override
    List<Employee> getAll();
}
