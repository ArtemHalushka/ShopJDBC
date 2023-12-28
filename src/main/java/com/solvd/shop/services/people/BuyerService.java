package com.solvd.shop.services.people;

import com.solvd.shop.interfaces.people.IBuyerDAO;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.mybatis.dao.people.BuyerDAO;
<<<<<<< HEAD
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
=======
>>>>>>> 7ed9824819492cd35c8780fa4bb8b827efd99675

import java.util.List;

public class BuyerService implements IBuyerDAO<Buyer> {

<<<<<<< HEAD

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(BuyerService.class);
=======
>>>>>>> 7ed9824819492cd35c8780fa4bb8b827efd99675
    private static final BuyerDAO batisDAO = new BuyerDAO();

    @Override
    public void insert(Buyer buyer) {
        batisDAO.insert(buyer);
    }

    @Override
    public void update(Buyer buyer) {
        batisDAO.update(buyer);
    }

    @Override
    public void delete(Buyer buyer) {
        batisDAO.delete(buyer);
    }

    @Override
    public Buyer getByID(int id) {
        return batisDAO.getByID(id);
    }

    @Override
    public List<Buyer> getAll() {
        return batisDAO.getAll();
    }

    @Override
    public Buyer getByName(String name) {
        return batisDAO.getByName(name);
    }
}
