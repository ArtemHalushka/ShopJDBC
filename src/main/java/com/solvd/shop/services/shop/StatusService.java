package com.solvd.shop.services.shop;

import com.solvd.shop.factory.ConnectionDAOException;
import com.solvd.shop.factory.ConnectionDAOFactory;
import com.solvd.shop.factory.DBConnectionType;
import com.solvd.shop.interfaces.shop.IStatusDAO;
import com.solvd.shop.models.shop.Status;
import com.solvd.shop.mybatis.dao.shop.StatusDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class StatusService implements IStatusDAO<Status> {

    private static final Logger LOGGER = LogManager.getLogger(StatusService.class);

    private static StatusDAO statusDAO = null;

    static {
        try {
            statusDAO = (StatusDAO) new ConnectionDAOFactory().getDAOFactory(DBConnectionType.MYBATIS).getDAO("statuses");
        } catch (ConnectionDAOException e) {
            LOGGER.info(e);
        }
    }

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
