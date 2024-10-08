package abc.restaurant.Dao;

import abc.restaurant.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    
    private Connection connection;

    public UserDAO() {
        this.connection = DBconnection.getInstance().getConnection();
    }

    
    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO user (username, password, role, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setString(4, user.getEmail());
            stmt.setInt(5, user.getPhone());
            stmt.executeUpdate();
        }
    }

    
    public User getUserById(int userId) throws SQLException {
        String query = "SELECT * FROM user WHERE userid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToUser(rs);
                }
            }
        }
        return null;
    }

    // Get all users
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                users.add(mapRowToUser(rs));
            }
        }
        return users;
    }

    // Update a user
    public void updateUser(User user) throws SQLException {
        String query = "UPDATE user SET username = ?, password = ?, role = ?, email = ?, phone = ? WHERE userid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setString(4, user.getEmail());
            stmt.setInt(5, user.getPhone());
            stmt.setInt(6, user.getUserId());
            stmt.executeUpdate();
        }
    }

    // Delete a user by ID
    public void deleteUser(int userId) throws SQLException {
        String query = "DELETE FROM user WHERE userid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        }
    }

    // Map ResultSet to User object
    private User mapRowToUser(ResultSet rs) throws SQLException {
        return new User(
            rs.getInt("userid"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("role"),
            rs.getString("email"),
            rs.getInt("phone")
        );
    }
    public User authenticate(String username, String password) throws SQLException {
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToUser(rs);
                }
            }
        }
        return null;
    }
    // Check if email or phone number already exists
    public boolean isEmailOrPhoneExists(String email, int phone) throws SQLException {
        String query = "SELECT COUNT(*) FROM user WHERE email = ? OR phone = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setInt(2, phone);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    
    
    
}
