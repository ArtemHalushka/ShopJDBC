package com.solvd.shop.services.people;

import com.solvd.shop.interfaces.people.IBuyerDAO;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.mybatis.dao.people.BuyerDAO;

import java.util.List;

public class BuyerService implements IBuyerDAO<Buyer> {

    private static final BuyerDAO buyerDAO = new BuyerDAO();

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
