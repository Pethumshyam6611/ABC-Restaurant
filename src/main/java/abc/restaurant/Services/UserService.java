package abc.restaurant.Services;

import abc.restaurant.Dao.UserDAO;
import abc.restaurant.Model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Service class for managing user operations.
 */
public class UserService {

    private static UserService instance;
    private UserDAO userDAO;

    private UserService() {
        this.userDAO = new UserDAO();
    }

    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    instance = new UserService();
                }
            }
        }
        return instance;
    }

    // Add a new user
    public void addUser(User user) throws SQLException {
        userDAO.addUser(user);
    }

    // Get a user by ID
    public User getUserById(int userId) throws SQLException {
        return userDAO.getUserById(userId);
    }

    // Get all users
    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    // Update an existing user
    public void updateUser(User user) throws SQLException {
        userDAO.updateUser(user);
    }

    // Delete a user by ID
    public void deleteUser(int userId) throws SQLException {
        userDAO.deleteUser(userId);
    }

    // Authenticate a user by username and password
    public User authenticateUser(String username, String password) throws SQLException {
        return userDAO.authenticate(username, password);
    }

    // Additional methods for specific business logic can be added here
    // For example, user authentication or role-based access control
}
