package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.IStatusDAO;
import com.solvd.shop.models.shop.Status;
import com.solvd.shop.mybatis.dao.shop.StatusDAO;

import java.util.List;

public class StatusService implements IStatusDAO<Status> {

    private static final StatusDAO statusDAO = new StatusDAO();

    @Override
    public void insert(Status status) {
        statusDAO.insert(status);
    }

    @Override
    public void update(Status status) {
        statusDAO.update(status);
    }

    @Override
    public void delete(Status status) {
        statusDAO.delete(status);
    }

    @Override
    public Status getByID(int id) {
        return statusDAO.getByID(id);
    }

    @Override
    public List<Status> getAll() {
        return statusDAO.getAll();
    }

    @Override
    public Status getByStatusName(String name) {
        return statusDAO.getByStatusName(name);
    }
}
