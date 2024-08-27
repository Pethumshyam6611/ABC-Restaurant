package abc.restaurant.Dao;

import abc.restaurant.Model.Gallery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class for interacting with the gallery table in the database.
 */
public class GalleryDAO {

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        return DBconnectionFactory.getConnection();
    }

    // Add a new gallery image
    public void addGallery(Gallery gallery) {
        String query = "INSERT INTO gallery (gallery_img) VALUES (?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection(); // Obtain a connection
            statement = connection.prepareStatement(query); // Prepare the SQL query
            statement.setString(1, gallery.getGalleryImg()); // Set parameters
            statement.executeUpdate(); // Execute the query
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        } finally {
            try {
                if (statement != null) statement.close();
               
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Get all gallery images
    public List<Gallery> getAllGalleries() throws SQLException, ClassNotFoundException {
        List<Gallery> galleries = new ArrayList<>();
        String query = "SELECT * FROM gallery"; // Make sure the table name matches your database schema

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int galleryId = resultSet.getInt("galleryid");
            String galleryImg = resultSet.getString("gallery_img");

            Gallery gallery = new Gallery(galleryId, galleryImg);
            galleries.add(gallery);
        }

        resultSet.close();
        statement.close();
      

        return galleries;
    }

    // Get gallery image by ID
    public Gallery getGalleryById(int galleryId) {
        String query = "SELECT * FROM gallery WHERE galleryid = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Gallery gallery = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, galleryId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String galleryImg = resultSet.getString("gallery_img");
                gallery = new Gallery(galleryId, galleryImg);
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

        return gallery;
    }

    

    // Delete a gallery image by ID
    public void deleteGallery(int galleryId) {
        String query = "DELETE FROM gallery WHERE galleryid = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, galleryId);
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

    // Helper method to map a ResultSet to a Gallery object
    private Gallery mapResultSetToGallery(ResultSet rs) throws SQLException {
        int galleryId = rs.getInt("galleryid");
        String galleryImg = rs.getString("gallery_img");

        return new Gallery(galleryId, galleryImg);
    }
}
