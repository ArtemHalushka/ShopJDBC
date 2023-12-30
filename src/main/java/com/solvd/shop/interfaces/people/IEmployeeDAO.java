package com.solvd.shop.interfaces.people;

import com.solvd.shop.interfaces.IBaseDAO;

public interface IEmployeeDAO<Employee> extends IBaseDAO<Employee> {

    Employee getByName(String name);
}
