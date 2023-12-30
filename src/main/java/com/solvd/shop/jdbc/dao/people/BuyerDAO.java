package com.solvd.shop.jdbc.dao.people;

import com.solvd.shop.interfaces.people.IBuyerDAO;
import com.solvd.shop.jdbc.dao.address.AddressDAO;
import com.solvd.shop.models.address.Address;
import com.solvd.shop.models.people.Buyer;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyerDAO implements IBuyerDAO<Buyer> {

    private final ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(BuyerDAO.class);
    private final AddressDAO addressDAO;

    public BuyerDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.addressDAO = new AddressDAO(connectionPool);
    }

    @Override
    public void insert(Buyer buyer) {
        String query = "INSERT INTO buyers (name, phone_number, id_address) VALUES ((?), (?), (?))";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, buyer.getName());
            statement.setString(2, buyer.getPhoneNumber());
            statement.setInt(3, buyer.getAddress().getAddressId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void update(Buyer buyer) {
        String query = "UPDATE buyers SET name = (?), phone_number = (?), id_address = (?) WHERE id_buyer = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, buyer.getName());
            statement.setString(2, buyer.getPhoneNumber());
            statement.setInt(3, buyer.getAddress().getAddressId());
            statement.setInt(4, buyer.getBuyerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void delete(Buyer buyer) {
        String query = "DELETE FROM buyers WHERE id_buyer = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, buyer.getBuyerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public Buyer getByID(int id) {
        String query = "SELECT * FROM buyers WHERE id_buyer = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Address address = addressDAO.getByID(resultSet.getInt("id_address"));
                    return new Buyer(resultSet.getInt("id_buyer"), resultSet.getString("name"), resultSet.getString("phone_number"), address);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
        return null;
    }

    @Override
    public List<Buyer> getAll() {
        List<Buyer> buyerList = new ArrayList<>();
        String query = "SELECT * FROM buyers";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Address address = addressDAO.getByID(resultSet.getInt("id_address"));
                    Buyer buyer = new Buyer(resultSet.getInt("id_buyer"), resultSet.getString("name"), resultSet.getString("phone_number"), address);
                    buyerList.add(buyer);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
        return buyerList;
    }

    @Override
    public Buyer getByName(String name) {
        String query = "SELECT * FROM buyers WHERE name = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Address address = addressDAO.getByID(resultSet.getInt("id_address"));
                    return new Buyer(resultSet.getInt("id_buyer"), resultSet.getString("name"), resultSet.getString("phone_number"), address);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
        return null;
    }
}
