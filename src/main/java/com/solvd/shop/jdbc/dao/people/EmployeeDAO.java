package com.solvd.shop.jdbc.dao.people;

import com.solvd.shop.interafaces.people.IEmployeeDAO;
import com.solvd.shop.jdbc.dao.shop.PositionDAO;
import com.solvd.shop.models.people.Employee;
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

public class EmployeeDAO implements IEmployeeDAO<Employee> {

    private final ConnectionPool connectionPool;
    private static final Logger LOGGER = LogManager.getLogger(EmployeeDAO.class);
    private final PositionDAO positionDAO;

    public EmployeeDAO(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.positionDAO = new PositionDAO(connectionPool);
    }

    @Override
    public void insert(Employee employee) {
        String query = "INSERT INTO employees (name, id_position) VALUES ((?), (?))";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getPosition().getPositionId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void update(Employee employee) {
        String query = "UPDATE employees SET name = (?), id_position = (?) WHERE id_employee = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getPosition().getPositionId());
            statement.setInt(3, employee.getEmployeeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void delete(Employee employee) {
        String query = "DELETE FROM employees WHERE id_employee = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, employee.getEmployeeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public Employee getByID(int id) {
        String query = "SELECT * FROM employees WHERE id_employee = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Position position = positionDAO.getByID(resultSet.getInt("id_position"));
                    return new Employee(resultSet.getInt("id_employee"), resultSet.getString("name"), position);
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
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        String query = "SELECT * FROM employees";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Position position = positionDAO.getByID(resultSet.getInt("id_position"));
                    Employee employee = new Employee(resultSet.getInt("id_employee"), resultSet.getString("name"), position);
                    employeeList.add(employee);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
        return employeeList;
    }

    @Override
    public Employee getByName(String name) {
        String query = "SELECT * FROM employees WHERE name = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Position position = positionDAO.getByID(resultSet.getInt("id_position"));
                    return new Employee(resultSet.getInt("id_employee"), resultSet.getString("name"), position);
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
