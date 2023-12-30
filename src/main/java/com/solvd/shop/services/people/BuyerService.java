package com.solvd.shop.services.people;

import com.solvd.shop.interfaces.people.IBuyerDAO;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.mybatis.dao.people.BuyerDAO;

import java.util.List;

public class BuyerService implements IBuyerDAO<Buyer> {

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
