package com.solvd.shop.interafaces.people;

import com.solvd.shop.interafaces.IBaseService;

public interface IEmployeeService<Employee> extends IBaseService<Employee> {

    Employee getByName(String name);
}