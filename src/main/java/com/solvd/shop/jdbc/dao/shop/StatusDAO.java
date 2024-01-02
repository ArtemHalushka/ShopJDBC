package com.solvd.shop.jdbc.dao.shop;

import com.solvd.shop.interfaces.shop.IStatusDAO;
import com.solvd.shop.models.shop.Status;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO implements IStatusDAO<Status> {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(StatusDAO.class);

    @Override
    public void insert(Status status) {
        String query = "INSERT INTO statuses (status) VALUES ((?))";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, status.getStatusName());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void update(Status status) {
        String query = "UPDATE statuses SET status = (?) WHERE id_status = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, status.getStatusName());
            statement.setInt(2, status.getStatusId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void delete(Status status) {
        String query = "DELETE FROM statuses WHERE id_status = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, status.getStatusId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public Status getByID(int id) {
        String query = "SELECT * FROM statuses WHERE id_status = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Status(resultSet.getInt("id_status"), resultSet.getString("status"));
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
    public List<Status> getAll() {
        List<Status> statusList = new ArrayList<>();
        String query = "SELECT * FROM statuses";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {

                    Status status = new Status(resultSet.getInt("id_status"), resultSet.getString("status"));
                    statusList.add(status);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
        return statusList;
    }

    @Override
    public Status getByStatusName(String name) {
        String query = "SELECT * FROM statuses WHERE status = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Status(resultSet.getInt("id_status"), resultSet.getString("status"));
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
