package abc.restaurant.Dao;

import abc.restaurant.Model.Oder;
import abc.restaurant.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class for interacting with the 'oder' table in the database.
 */
public class OderDAO {

    // Method to get a database connection
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        return DBconnectionFactory.getConnection(); // Replace with your actual connection logic
    }

    // Add a new order
    public void addOder(Oder oder) {
        String query = "INSERT INTO oder (food_names_with_qt, useridp, type, total_price, status, datetime) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, oder.getFoodNamewithQT());
            statement.setInt(2, oder.getUserIdp());
            statement.setString(3, oder.getType());
            statement.setDouble(4, oder.getTotalPrice());
            statement.setString(5, oder.getStatus());
            statement.setString(6, oder.getDatetime());
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

    // Retrieve all orders with user details
    public List<Oder> getAllOdersWithUsers() throws SQLException {
        List<Oder> oders = new ArrayList<>();
        String query = "SELECT o.oderid, o.food_names_with_qt, o.useridp, o.type, o.total_price, o.status, o.datetime, "
                     + "u.username, u.email, u.phone "
                     + "FROM oder o "
                     + "JOIN user u ON o.useridp = u.userid "
                     + "ORDER BY o.oderid DESC";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Oder oder = mapResultSetToOderWithUser(resultSet);
                oders.add(oder);
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
        String query = "UPDATE oder SET food_names_with_qt = ?, useridp = ?, type = ?, total_price = ?, status = ?, datetime = ? WHERE oderid = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, oder.getFoodNamewithQT());
            statement.setInt(2, oder.getUserIdp());
            statement.setString(3, oder.getType());
            statement.setDouble(4, oder.getTotalPrice());
            statement.setString(5, oder.getStatus());
            statement.setString(6, oder.getDatetime());
            statement.setInt(7, oder.getOderId());
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
        String foodnamewithQt = rs.getString("food_names_with_qt");
        int userIdp = rs.getInt("useridp");
        String type = rs.getString("type");
        double totalPrice = rs.getDouble("total_price");
        String status = rs.getString("status");
        String datetime = rs.getString("datetime");

        return new Oder(oderId, foodnamewithQt, userIdp, type, totalPrice, status, datetime);
    }

    private Oder mapResultSetToOderWithUser(ResultSet rs) throws SQLException {
        int oderId = rs.getInt("oderid");
        String foodNamewithQt = rs.getString("food_names_with_qt");
        int userIdp = rs.getInt("useridp");
        String type = rs.getString("type");
        double totalPrice = rs.getDouble("total_price");
        String status = rs.getString("status");
        String datetime = rs.getString("datetime");

        // User details
        String username = rs.getString("username");
        String email = rs.getString("email");  // Ensure email is being retrieved correctly
        int phone = rs.getInt("phone");

        Oder oder = new Oder(oderId, foodNamewithQt, userIdp, type, totalPrice, status, datetime);
        User user = new User(userIdp, username, email, phone);
        oder.setUserDetails(user);

        return oder;
    }

}
