package abc.restaurant.Dao;

import abc.restaurant.Model.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class for interacting with the reservations table in the database.
 */
public class ReservationDAO {

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        return DBconnectionFactory.getConnection();
    }

    // Add a new reservation
    public void addReservation(Reservation reservation) {
        String query = "INSERT INTO reservations (userid, service_type, date, time, number_of_people, status) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection(); // Obtain a connection
            statement = connection.prepareStatement(query); // Prepare the SQL query
            statement.setInt(1, reservation.getUserId()); // Set parameters
            statement.setString(2, reservation.getServiceType());
            statement.setString(3, reservation.getDate());
            statement.setString(4, reservation.getTime());
            statement.setInt(5, reservation.getNumberOfPeople());
            statement.setString(6, reservation.getStatus());
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

    // Retrieve all reservations
    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservations ORDER BY reservationid DESC"; // Make sure the table name matches your database schema

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                reservations.add(mapResultSetToReservation(resultSet));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
        }

        return reservations;
    }

    // Retrieve a reservation by its ID
    public Reservation getReservationById(int reservationId) {
        String query = "SELECT * FROM reservations WHERE reservationid = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Reservation reservation = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, reservationId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                reservation = mapResultSetToReservation(resultSet);
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

        return reservation;
    }

    // Update an existing reservation
    public void updateReservation(Reservation reservation) {
        String query = "UPDATE reservations SET userid = ?, service_type = ?, date = ?, time = ?, number_of_people = ?, status = ? WHERE reservationid = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, reservation.getUserId());
            statement.setString(2, reservation.getServiceType());
            statement.setString(3, reservation.getDate());
            statement.setString(4, reservation.getTime());
            statement.setInt(5, reservation.getNumberOfPeople());
            statement.setString(6, reservation.getStatus());
            statement.setInt(7, reservation.getReservationId());
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

    // Delete a reservation
    public void deleteReservation(int reservationId) {
        String query = "DELETE FROM reservations WHERE reservationid = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, reservationId);
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

    // Map the ResultSet to a Reservation object
    private Reservation mapResultSetToReservation(ResultSet rs) throws SQLException {
        int reservationId = rs.getInt("reservationid");
        int userId = rs.getInt("userid");
        String serviceType = rs.getString("service_type");
        String date = rs.getString("date");
        String time = rs.getString("time");
        int numberOfPeople = rs.getInt("number_of_people");
        String status = rs.getString("status");

        return new Reservation(reservationId, userId, serviceType, date, time, numberOfPeople, status);
    }
}
