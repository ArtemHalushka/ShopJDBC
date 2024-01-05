package com.solvd.shop.services.people;

import com.solvd.shop.factory.ConnectionDAOException;
import com.solvd.shop.factory.ConnectionDAOFactory;
import com.solvd.shop.factory.DBConnectionType;
import com.solvd.shop.interfaces.people.IBuyerDAO;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.mybatis.dao.people.BuyerDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BuyerService implements IBuyerDAO<Buyer> {

    private static final Logger LOGGER = LogManager.getLogger(BuyerService.class);

    private static BuyerDAO buyerDAO = null;

    static {
        try {
            buyerDAO = (BuyerDAO) new ConnectionDAOFactory().getDAOFactory(DBConnectionType.MYBATIS).getDAO("buyers");
        } catch (ConnectionDAOException e) {
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
