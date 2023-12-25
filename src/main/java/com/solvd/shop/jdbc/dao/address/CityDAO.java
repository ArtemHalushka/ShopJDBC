package com.solvd.shop.jdbc.dao.address;

import com.solvd.shop.interfaces.address.ICityDAO;
import com.solvd.shop.models.address.City;
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

public class CityDAO implements ICityDAO<City> {

    private final ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(CityDAO.class);

    public CityDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void insert(City city) {
        String query = "INSERT INTO cities (city, id_contry) VALUES ((?), (?))";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, city.getCityName());
            statement.setInt(2, city.getCountry().getCountryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void update(City city) {
        String query = "UPDATE cities SET city = (?), id_country = (?) WHERE id_city = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, city.getCityName());
            statement.setInt(2, city.getCountry().getCountryId());
            statement.setInt(3, city.getCityId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void delete(City city) {
        String query = "DELETE FROM cities WHERE id_city = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, city.getCityId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public City getByCityName(String cityName) {
        String query = "SELECT * FROM cities WHERE city = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, cityName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Country country = new Country();
                    country.setCountryId(resultSet.getInt("id_country"));
                    return new City(resultSet.getInt("id_city"), resultSet.getString("city"), country);
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
    public City getByID(int id) {
        String query = "SELECT * FROM cities WHERE id_city = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Country country = new Country();
                    country.setCountryId(resultSet.getInt("id_country"));
                    return new City(resultSet.getInt("id_city"), resultSet.getString("city"), country);
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
    public List<City> getAll() {
        List<City> cityList = new ArrayList<>();
        String query = "SELECT * FROM cities";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Country country = new Country();
                    country.setCountryId(resultSet.getInt("id_country"));
                    City city =  new City(resultSet.getInt("id_city"), resultSet.getString("city"), country);
                    cityList.add(city);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
        return cityList;
    }
}
