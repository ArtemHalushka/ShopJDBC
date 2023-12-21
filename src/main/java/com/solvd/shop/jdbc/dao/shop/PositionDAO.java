package com.solvd.shop.jdbc.dao.shop;

import com.solvd.shop.interafaces.shop.IPositionDAO;
import com.solvd.shop.models.shop.Position;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO implements IPositionDAO<Position> {

    private final ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(PositionDAO.class);

    public PositionDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void insert(Position position) {
        String query = "INSERT INTO positions (position, salary) VALUES ((?), (?))";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, position.getPositionName());
            statement.setDouble(2, position.getSalary());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void update(Position position) {
        String query = "UPDATE positions SET position = (?), salary = (?) WHERE id_position = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, position.getPositionName());
            statement.setDouble(2, position.getSalary());
            statement.setInt(3, position.getIdPosition());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void delete(Position position) {
        String query = "DELETE FROM positions WHERE id_position = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, position.getIdPosition());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public Position getByID(int id) {
        String query = "SELECT * FROM positions WHERE id_position = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Position(resultSet.getInt("id_position"), resultSet.getString("position"), resultSet.getDouble("salary"));
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        return null;
    }

    @Override
    public List<Position> getAll() {
        List<Position> positionList = new ArrayList<>();
        String query = "SELECT * FROM positions";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {

                    Position position = new Position(resultSet.getInt("id_position"), resultSet.getString("position"), resultSet.getDouble("salary"));
                    positionList.add(position);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        return positionList;
    }

    @Override
    public Position getBySalary(double salary) {
        String query = "SELECT * FROM positions WHERE salary = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setDouble(1, salary);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Position(resultSet.getInt("id_position"), resultSet.getString("position"), resultSet.getDouble("salary"));
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        return null;
    }
}
