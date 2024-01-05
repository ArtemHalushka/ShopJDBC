package com.solvd.shop.jdbc.dao.people;

import com.solvd.shop.interfaces.people.ISupplierDAO;
import com.solvd.shop.jdbc.dao.address.AddressDAO;
import com.solvd.shop.models.address.Address;
import com.solvd.shop.models.people.Supplier;
import com.solvd.shop.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO implements ISupplierDAO<Supplier> {

    private static final Logger LOGGER = LogManager.getLogger(SupplierDAO.class);

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final AddressDAO addressDAO = new AddressDAO();

    @Override
    public void insert(Supplier supplier) {
        String query = "INSERT INTO suppliers (supplier, id_address) VALUES ((?), (?))";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, supplier.getSupplierName());
            statement.setInt(2, supplier.getAddress().getAddressId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void update(Supplier supplier) {
        String query = "UPDATE suppliers SET supplier = (?), id_address = (?) WHERE id_supplier = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, supplier.getSupplierName());
            statement.setInt(2, supplier.getAddress().getAddressId());
            statement.setInt(3, supplier.getSupplierId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void delete(Supplier supplier) {
        String query = "DELETE FROM suppliers WHERE id_supplier = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, supplier.getSupplierId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public Supplier getByID(int id) {
        String query = "SELECT * FROM suppliers WHERE id_supplier = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Address address = addressDAO.getByID(resultSet.getInt("id_address"));
                    return new Supplier(resultSet.getInt("id_supplier"), resultSet.getString("supplier"), address);
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
    public List<Supplier> getAll() {
        List<Supplier> supplierList = new ArrayList<>();
        String query = "SELECT * FROM suppliers";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Address address = addressDAO.getByID(resultSet.getInt("id_address"));
                    Supplier supplier = new Supplier(resultSet.getInt("id_supplier"), resultSet.getString("supplier"), address);
                    supplierList.add(supplier);
                }
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            connectionPool.releaseConnection(conn);
        }
        return supplierList;
    }

    @Override
    public Supplier getByName(String name) {
        String query = "SELECT * FROM suppliers WHERE supplier = (?)";
        Connection conn = connectionPool.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Address address = addressDAO.getByID(resultSet.getInt("id_address"));
                    return new Supplier(resultSet.getInt("id_supplier"), resultSet.getString("supplier"), address);
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
