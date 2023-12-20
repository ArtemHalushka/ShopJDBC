package com.solvd.shop.interafaces;

import java.util.List;

public interface IBaseDAO<Entity> {

    void insert(Entity entity);

    void update(Entity entity);

    void delete(Entity entity);

    Entity getByID(int id);

    List<Entity> getAll();
}
