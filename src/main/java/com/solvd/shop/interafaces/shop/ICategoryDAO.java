package com.solvd.shop.interafaces.shop;

import com.solvd.shop.interafaces.IBaseDAO;
import com.solvd.shop.models.shop.Category;

import java.util.List;

public interface ICategoryDAO extends IBaseDAO {

    Category getByCategoryName(String name);

    @Override
    Category getByID(int id);

    @Override
    List<Category> getAll();
}
