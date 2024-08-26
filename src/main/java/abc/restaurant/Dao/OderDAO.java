package abc.restaurant.Dao;

import abc.restaurant.Model.Oder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class for interacting with the oder table in the database.
 */
public class OderDAO {

    // Method to get a database connection
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        return DBconnectionFactory.getConnection(); // Replace with your actual connection logic
    }

    // Add a new order
    public void addOder(Oder oder) {
        String query = "INSERT INTO oder (productid, useridp, type, total_price, status) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, oder.getProductId());
            statement.setInt(2, oder.getUserIdp());
            statement.setString(3, oder.getType());
            statement.setDouble(4, oder.getTotalPrice());
            statement.setString(5, oder.getStatus());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Retrieve all orders
    public List<Oder> getAllOders() throws SQLException {
        List<Oder> oders = new ArrayList<>();
        String query = "SELECT * FROM oder ORDER BY oderid DESC"; // Ensure the table name matches your database schema

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                oders.add(mapResultSetToOder(resultSet));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
        }

        return oders;
    }

    // Retrieve an order by its ID
    public Oder getOderById(int oderId) {
        String query = "SELECT * FROM oder WHERE oderid = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Oder oder = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, oderId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                oder = mapResultSetToOder(resultSet);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return oder;
    }

    // Update an existing order
    public void updateOder(Oder oder) {
        String query = "UPDATE oder SET productid = ?, useridp = ?, type = ?, total_price = ?, status = ? WHERE oderid = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, oder.getProductId());
            statement.setInt(2, oder.getUserIdp());
            statement.setString(3, oder.getType());
            statement.setDouble(4, oder.getTotalPrice());
            statement.setString(5, oder.getStatus());
            statement.setInt(6, oder.getOderId());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Delete an order
    public void deleteOder(int oderId) {
        String query = "DELETE FROM oder WHERE oderid = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, oderId);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Map the ResultSet to an Oder object
    private Oder mapResultSetToOder(ResultSet rs) throws SQLException {
        int oderId = rs.getInt("oderid");
        int productId = rs.getInt("productid");
        int userIdp = rs.getInt("useridp");
        String type = rs.getString("type");
        double totalPrice = rs.getDouble("total_price");
        String status = rs.getString("status");

        return new Oder(oderId, productId, userIdp, type, totalPrice, status);
    }
}