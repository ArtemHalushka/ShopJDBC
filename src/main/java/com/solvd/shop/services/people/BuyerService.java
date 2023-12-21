package com.solvd.shop.services.people;

import com.solvd.shop.interafaces.people.IBuyerService;
import com.solvd.shop.jdbc.dao.people.BuyerDAO;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class BuyerService implements IBuyerService<Buyer> {

    private static ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(BuyerService.class);

    private static final BuyerDAO buyerDAO = new BuyerDAO(connectionPool);

    static {
        try {
            connectionPool = ConnectionPool.getInstance();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void insert(Buyer buyer) {
        buyerDAO.insert(buyer);
    }

    @Override
    public void update(Buyer buyer) {
        buyerDAO.update(buyer);
    }

    @Override
    public void delete(Buyer buyer) {
        buyerDAO.delete(buyer);
    }

    @Override
    public Buyer getByID(int id) {
        return buyerDAO.getByID(id);
    }

    @Override
    public List<Buyer> getAll() {
        return buyerDAO.getAll();
    }

    @Override
    public Buyer getByName(String name) {
        return buyerDAO.getByName(name);
    }
}
