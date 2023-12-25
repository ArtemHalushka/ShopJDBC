package com.solvd.shop.interfaces.shop;

import com.solvd.shop.interfaces.IBaseDAO;

public interface ICategoryDAO<Category> extends IBaseDAO<Category> {

    Category getByCategoryName(String name);
}
