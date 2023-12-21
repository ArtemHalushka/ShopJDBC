package com.solvd.shop.jdbc.dao.address;

import com.solvd.shop.interafaces.address.IAddressDAO;
import com.solvd.shop.models.address.Address;
import com.solvd.shop.models.address.City;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements IAddressDAO<Address> {

    private final ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);

    public AddressDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void insert(Address address) {
        String query = "INSERT INTO addresses (first_line, second_line, zip_code, id_city) VALUES ((?), (?), (?), (?))";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, address.getFirstLine());
            statement.setString(2, address.getSecondLine());
            statement.setString(3, address.getZipCode());
            statement.setInt(4,address.getIdCity().getIdCity());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void update(Address address) {
        String query = "UPDATE addresses SET first_line = (?), second_line = (?), zip_code = (?), id_city = (?) WHERE id_address = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, address.getFirstLine());
            statement.setString(2, address.getSecondLine());
            statement.setString(3, address.getZipCode());
            statement.setInt(4, address.getIdCity().getIdCity());
            statement.setInt(5, address.getIdAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void delete(Address address) {
        String query = "DELETE FROM addresses WHERE id_address = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, address.getIdAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public Address getByID(int id) {
        String query = "SELECT * FROM addresses WHERE id_address = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    City city = new City();
                    city.setIdCity(resultSet.getInt("id_city"));
                    return new Address(resultSet.getInt("id_address"), resultSet.getString("first_line"),
                            resultSet.getString("second_line"), resultSet.getString("zip_code"), city);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        return null;
    }

    @Override
    public List<Address> getAll() {
        List<Address> addressList = new ArrayList<>();
        String query = "SELECT * FROM addresses";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    City city = new City();
                    city.setIdCity(resultSet.getInt("id_city"));
                    Address address = new Address(resultSet.getInt("id_address"), resultSet.getString("first_line"),
                            resultSet.getString("second_line"), resultSet.getString("zip_code"), city);
                    addressList.add(address);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        return addressList;
    }

    @Override
    public Address getByFirstLine(String firstLine) {
        String query = "SELECT * FROM addresses WHERE first_line = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, firstLine);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    City city = new City();
                    city.setIdCity(resultSet.getInt("id_city"));
                    return new Address(resultSet.getInt("id_address"), resultSet.getString("first_line"),
                            resultSet.getString("second_line"), resultSet.getString("zip_code"), city);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        return null;
    }
}
