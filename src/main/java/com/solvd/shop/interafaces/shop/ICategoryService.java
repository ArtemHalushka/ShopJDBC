package com.solvd.shop.interafaces.shop;


import com.solvd.shop.interafaces.IBaseService;

public interface ICategoryService<Category> extends IBaseService<Category> {

    Category getByCategoryName(String name);
}