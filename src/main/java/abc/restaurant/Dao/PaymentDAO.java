package abc.restaurant.Dao;

import abc.restaurant.Model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class for interacting with the payment table in the database.
 */
public class PaymentDAO {

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        return DBconnectionFactory.getConnection();
    }

    // Add a new payment
    public void addPayment(Payment payment) {
        String query = "INSERT INTO payment (oderid, paymentdatetime, method) VALUES (?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection(); // Obtain a connection
            statement = connection.prepareStatement(query); // Prepare the SQL query
            statement.setInt(1, payment.getOderId()); // Set parameters
            statement.setString(2, payment.getPaymentDateTime());
            statement.setString(3, payment.getMethod());
            statement.executeUpdate(); // Execute the query
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        } finally {
            try {
                if (statement != null) statement.close(); // Close statement
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Retrieve all payments
    public List<Payment> getAllPayments() throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT * FROM payment ORDER BY paymentid DESC"; // Make sure the table name matches your database schema

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                payments.add(mapResultSetToPayment(resultSet));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
        }

        return payments;
    }

    // Retrieve a payment by its ID
    public Payment getPaymentById(int paymentId) {
        String query = "SELECT * FROM payment WHERE paymentid = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Payment payment = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, paymentId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                payment = mapResultSetToPayment(resultSet);
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

        return payment;
    }

    // Update an existing payment
    public void updatePayment(Payment payment) {
        String query = "UPDATE payment SET oderid = ?, paymentdatetime = ?, method = ? WHERE paymentid = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, payment.getOderId());
            statement.setString(2, payment.getPaymentDateTime());
            statement.setString(3, payment.getMethod());
            statement.setInt(4, payment.getPaymentId());
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

    // Delete a payment
    public void deletePayment(int paymentId) {
        String query = "DELETE FROM payment WHERE paymentid = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, paymentId);
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

    // Map the ResultSet to a Payment object
    private Payment mapResultSetToPayment(ResultSet rs) throws SQLException {
        int paymentId = rs.getInt("paymentid");
        int oderId = rs.getInt("oderid");
        String paymentDateTime = rs.getString("paymentdatetime");
        String method = rs.getString("method");

        return new Payment(paymentId, oderId, paymentDateTime, method);
    }
}
