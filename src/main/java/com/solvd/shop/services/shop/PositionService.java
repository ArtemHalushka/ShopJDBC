package com.solvd.shop.services.shop;

import com.solvd.shop.interafaces.shop.IPositionDAO;
import com.solvd.shop.jdbc.dao.shop.PositionDAO;
import com.solvd.shop.models.shop.Position;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class PositionService implements IPositionDAO<Position> {

    private static ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(PositionService.class);

    private static final PositionDAO positionDAO = new PositionDAO(connectionPool);

    static {
        try {
            connectionPool = ConnectionPool.getInstance();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void insert(Position position) {
        positionDAO.insert(position);
    }

    @Override
    public void update(Position position) {
        positionDAO.update(position);
    }

    @Override
    public void delete(Position position) {
        positionDAO.delete(position);
    }

    @Override
    public Position getByID(int id) {
        return positionDAO.getByID(id);
    }

    @Override
    public List<Position> getAll() {
        return positionDAO.getAll();
    }

    @Override
    public Position getBySalary(double salary) {
        return positionDAO.getBySalary(salary);
    }
}
