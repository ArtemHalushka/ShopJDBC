package com.solvd.shop.interafaces.people;

import com.solvd.shop.interafaces.IBaseDAO;

public interface IEmployeeDAO<Employee> extends IBaseDAO<Employee> {

    Employee getByName(String name);
}
