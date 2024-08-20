package abc.restaurant.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import abc.restaurant.Model.Menu;

/**
 * DAO class for interacting with the menu table in the database.
 */
public class MenuDAO {

    
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        return DBconnectionFactory.getConnection();
    }
    
    
    public void addMenu(Menu menu) {
        String query = "INSERT INTO menu (category, name, description, price, product_img) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBconnectionFactory.getConnection(); // Obtain a connection
            statement = connection.prepareStatement(query); // Prepare the SQL query
            statement.setString(1, menu.getCategory()); // Set parameters
            statement.setString(2, menu.getProductName());
            statement.setString(3, menu.getDescription());
            statement.setDouble(4, menu.getPrice());
            statement.setString(5, menu.getImage());
            statement.executeUpdate(); // Execute the query
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }   finally
        {
        	try {
				statement.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
        }
    }


    public List<Menu> getAllMenus() throws SQLException {
        List<Menu> menus = new ArrayList<>();
        String query = "SELECT * FROM menu"; // Make sure the table name matches your database schema

        Connection connection = DBconnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        
        while (resultSet.next()) {
            int productID = resultSet.getInt("productid");
            String category = resultSet.getString("category");
            String productName = resultSet.getString("name");
            String description = resultSet.getString("description");
            double price = resultSet.getDouble("price");
            String image = resultSet.getString("product_img");

            Menu menu = new Menu(productID, category, productName, description, price, image);
            menus.add(menu);
        }
        
        resultSet.close();
        statement.close();
      
        return menus;
    }
    
    public Menu getMenuById(int menuId) {
        String query = "SELECT * FROM menu WHERE productid = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Menu menu = null;
 
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, menuId);
            resultSet = statement.executeQuery();
 
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                String category = resultSet.getString("category");
                String image = resultSet.getString("product_img");
                menu = new Menu(menuId, category, name, description, price, image);
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
 
        return menu;
    }

    public void updateMenu(Menu menu) {
        String query = "UPDATE menu SET name = ?, description = ?, price = ?, category = ?, product_img = ? WHERE productid = ?";
        Connection connection = null;
        PreparedStatement statement = null;
 
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, menu.getProductName());
            statement.setString(2, menu.getDescription());
            statement.setDouble(3, menu.getPrice());
            statement.setString(4, menu.getCategory());
            statement.setString(5, menu.getImage());
            statement.setInt(6, menu.getProductID()); // Ensure this matches your model's field name
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

    public void deleteMenu(int menuId) {
        String query = "DELETE FROM menu WHERE productid = ?";
        Connection connection = null;
        PreparedStatement statement = null;
 
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, menuId);
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
    
    
    
    
    
    private Menu mapResultSetToMenu(ResultSet rs) throws SQLException {
        int productID = rs.getInt("productid");
        String category = rs.getString("category");
        String productName = rs.getString("name");
        String description = rs.getString("description");
        double price = rs.getDouble("price");
        String image = rs.getString("product_img");

        return new Menu(productID, category, productName, description, price, image);
    }
}
