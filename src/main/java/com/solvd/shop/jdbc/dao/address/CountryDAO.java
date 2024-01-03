package com.solvd.shop.jdbc.dao.address;

import com.solvd.shop.interfaces.address.ICountryDAO;
import com.solvd.shop.models.address.Country;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements ICountryDAO<Country> {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(CountryDAO.class);

    @Override
    public void insert(Country country) {
        String query = "INSERT INTO countries (country) VALUES ((?))";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, country.getCountryName());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }


    @Override
    public void update(Country country) {
        String query = "UPDATE countries SET country = (?) WHERE id_country = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, country.getCountryName());
            statement.setInt(2, country.getCountryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void delete(Country country) {
        String query = "DELETE FROM countries WHERE id_country = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, country.getCountryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public Country getByID(int id) {
        String query = "SELECT * FROM countries WHERE id_country = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Country(resultSet.getInt("id_country"), resultSet.getString("country"));
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
    public List<Country> getAll() {
        List<Country> countryList = new ArrayList<>();
        String query = "SELECT * FROM countries";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Country country =  new Country(resultSet.getInt("id_country"), resultSet.getString("country"));
                    countryList.add(country);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
        return countryList;
    }

    @Override
    public Country getByCountryName(String countryName) {
        String query = "SELECT * FROM countries WHERE country = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, countryName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Country(resultSet.getInt("id_country"), resultSet.getString("country"));
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
