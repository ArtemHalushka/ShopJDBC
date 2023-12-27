package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.IPositionDAO;
import com.solvd.shop.models.shop.Position;
import com.solvd.shop.mybatis.dao.shop.PositionDAO;

import java.util.List;

public class PositionService implements IPositionDAO<Position> {

    private static final PositionDAO batisDAO = new PositionDAO();

    @Override
    public void insert(Position position) {
        batisDAO.insert(position);
    }

    @Override
    public void update(Position position) {
        batisDAO.update(position);
    }

    @Override
    public void delete(Position position) {
        batisDAO.delete(position);
    }

    @Override
    public Position getByID(int id) {
        return batisDAO.getByID(id);
    }

    @Override
    public List<Position> getAll() {
        return batisDAO.getAll();
    }

    @Override
    public Position getBySalary(double salary) {
        return batisDAO.getBySalary(salary);
    }
}
