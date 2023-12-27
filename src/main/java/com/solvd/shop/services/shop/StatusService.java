package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.IStatusDAO;
import com.solvd.shop.models.shop.Status;
import com.solvd.shop.mybatis.dao.shop.StatusDAO;

import java.util.List;

public class StatusService implements IStatusDAO<Status> {

    private static final StatusDAO batisDAO = new StatusDAO();

    @Override
    public void insert(Status status) {
        batisDAO.insert(status);
    }

    @Override
    public void update(Status status) {
        batisDAO.update(status);
    }

    @Override
    public void delete(Status status) {
        batisDAO.delete(status);
    }

    @Override
    public Status getByID(int id) {
        return batisDAO.getByID(id);
    }

    @Override
    public List<Status> getAll() {
        return batisDAO.getAll();
    }

    @Override
    public Status getByStatusName(String name) {
        return batisDAO.getByStatusName(name);
    }
}
