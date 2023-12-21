package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;

public interface ICategoryDAO<Category> extends IBaseDAO<Category> {

    Category getByCategoryName(String name);
}
