package com.solvd.shop.services.shop;

import com.solvd.shop.factory.ConnectionDAOException;
import com.solvd.shop.factory.ConnectionDAOFactory;
import com.solvd.shop.factory.DBConnectionType;
import com.solvd.shop.interfaces.shop.IPositionDAO;
import com.solvd.shop.models.shop.Position;
import com.solvd.shop.mybatis.dao.shop.PositionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PositionService implements IPositionDAO<Position> {

    private static final Logger LOGGER = LogManager.getLogger(PositionService.class);

    private static PositionDAO positionDAO = null;

    static {
        try {
            positionDAO = (PositionDAO) new ConnectionDAOFactory().getDAOFactory(DBConnectionType.MYBATIS).getDAO("positions");
        } catch (ConnectionDAOException e) {
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
