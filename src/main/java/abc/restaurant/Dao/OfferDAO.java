package abc.restaurant.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import abc.restaurant.Model.Offer;

/**
 * DAO class for interacting with the offers table in the database.
 */
public class OfferDAO {

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        return DBconnectionFactory.getConnection();
    }

    public void addOffer(Offer offer) {
        String query = "INSERT INTO offers (title, description, price, offer_img) VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection(); // Obtain a connection
            statement = connection.prepareStatement(query); // Prepare the SQL query
            statement.setString(1, offer.getTitle()); // Set parameters
            statement.setString(2, offer.getDescription());
            statement.setInt(3, offer.getPrice());
            statement.setString(4, offer.getOfferImg());
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

    public List<Offer> getAllOffers() {
        List<Offer> offers = new ArrayList<>();
        String query = "SELECT * FROM offers"; // Make sure the table name matches your database schema

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Offer offer = mapResultSetToOffer(resultSet);
                offers.add(offer);
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

        return offers;
    }

    public Offer getOfferById(int offerId) {
        String query = "SELECT * FROM offers WHERE offerid = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Offer offer = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, offerId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                offer = mapResultSetToOffer(resultSet);
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

        return offer;
    }

    public void updateOffer(Offer offer) {
        String query = "UPDATE offers SET title = ?, description = ?, price = ?, offer_img = ? WHERE offerid = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, offer.getTitle());
            statement.setString(2, offer.getDescription());
            statement.setInt(3, offer.getPrice());
            statement.setString(4, offer.getOfferImg());
            statement.setInt(5, offer.getOfferId());
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

    public void deleteOffer(int offerId) {
        String query = "DELETE FROM offers WHERE offerid = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, offerId);
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

    private Offer mapResultSetToOffer(ResultSet rs) throws SQLException {
        int offerId = rs.getInt("offerid");
        String title = rs.getString("title");
        String description = rs.getString("description");
        int price = rs.getInt("price");
        String offerImg = rs.getString("offer_img");

        return new Offer(offerId, title, description, price, offerImg);
    }
}
