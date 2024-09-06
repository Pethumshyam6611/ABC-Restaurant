package abc.restaurant.Dao;

import abc.restaurant.Model.Reservation;
import abc.restaurant.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ReservationDAO {

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        return DBconnectionFactory.getConnection();
    }

   
    public void addReservation(Reservation reservation) {
        String query = "INSERT INTO reservations (userid, message, date, time, number_of_people, status) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection(); 
            statement = connection.prepareStatement(query); 
            statement.setInt(1, reservation.getUserId()); 
            statement.setString(2, reservation.getMessage());
            statement.setString(3, reservation.getDate());
            statement.setString(4, reservation.getTime());
            statement.setInt(5, reservation.getNumberOfPeople());
            statement.setString(6, reservation.getStatus());
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

    
    public List<Reservation> getAllReservationsWithUsers() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT r.reservationid, r.userid, r.message, r.date, r.time, r.number_of_people, r.status, "
                     + "u.username, u.email, u.phone "
                     + "FROM reservations r "
                     + "JOIN user u ON r.userid = u.userid "
                     + "ORDER BY r.reservationid DESC";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = mapResultSetToReservationWithUser(resultSet);
                reservations.add(reservation);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
        }

        return reservations;
    }


  
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

    
    public void updateReservation(Reservation reservation) {
        String query = "UPDATE reservations SET userid = ?, message = ?, date = ?, time = ?, number_of_people = ?, status = ? WHERE reservationid = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, reservation.getUserId());
            statement.setString(2, reservation.getMessage());
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


    
    private Reservation mapResultSetToReservation(ResultSet rs) throws SQLException {
        int reservationId = rs.getInt("reservationid");
        int userId = rs.getInt("userid");
        String message = rs.getString("message");
        String date = rs.getString("date");
        String time = rs.getString("time");
        int numberOfPeople = rs.getInt("number_of_people");
        String status = rs.getString("status");

        return new Reservation(reservationId, userId, message, date, time, numberOfPeople, status);
    }

 
    private Reservation mapResultSetToReservationWithUser(ResultSet rs) throws SQLException {
        int reservationId = rs.getInt("reservationid");
        int userId = rs.getInt("userid");
        String message = rs.getString("message");
        String date = rs.getString("date");
        String time = rs.getString("time");
        int numberOfPeople = rs.getInt("number_of_people");
        String status = rs.getString("status");

        // User details
        String username = rs.getString("username");
        String email = rs.getString("email");
        int phone = rs.getInt("phone");

        Reservation reservation = new Reservation(reservationId, userId, message, date, time, numberOfPeople, status);
        User user = new User(userId, username, email, phone);
        reservation.setUserDetails(user);

        return reservation;
    }

}
