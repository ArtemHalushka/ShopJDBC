package com.solvd.shop.services.shop;

import com.solvd.shop.interfaces.shop.IStatusDAO;
import com.solvd.shop.jdbc.dao.shop.StatusDAO;
import com.solvd.shop.models.shop.Status;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class StatusService implements IStatusDAO<Status> {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(StatusService.class);
    private static final StatusDAO statusDAO = new StatusDAO(connectionPool);

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
