package abc.restaurant.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abc.restaurant.Model.Offer;

public class OfferDAO {
    private Connection connection;

    // Constructor to initialize the database connection
    public OfferDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to create a new offer
    public void addOffer(Offer offer) throws SQLException {
        String sql = "INSERT INTO offers (title, description, discount_precentage, valid_from, valid_to, offer_img) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, offer.getTitle());
            statement.setString(2, offer.getDescription());
            statement.setString(3, offer.getDiscountPercentage());
            statement.setString(4, offer.getValidFrom());
            statement.setString(5, offer.getValidTo());
            statement.setString(6, offer.getOfferImg());
            statement.executeUpdate();
        }
    }

    // Method to get an offer by ID
    public Offer getOfferById(int offerId) throws SQLException {
        Offer offer = null;
        String sql = "SELECT * FROM offers WHERE offerid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, offerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    offer = new Offer(
                        resultSet.getInt("offerid"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("discount_precentage"),
                        resultSet.getString("valid_from"),
                        resultSet.getString("valid_to"),
                        resultSet.getString("offer_img")
                    );
                }
            }
        }
        return offer;
    }

    // Method to get all offers
    public List<Offer> getAllOffers() throws SQLException {
        List<Offer> offers = new ArrayList<>();
        String sql = "SELECT * FROM offers";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Offer offer = new Offer(
                    resultSet.getInt("offerid"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getString("discount_precentage"),
                    resultSet.getString("valid_from"),
                    resultSet.getString("valid_to"),
                    resultSet.getString("offer_img")
                );
                offers.add(offer);
            }
        }
        return offers;
    }

    // Method to update an offer
    public void updateOffer(Offer offer) throws SQLException {
        String sql = "UPDATE offers SET title = ?, description = ?, discount_precentage = ?, valid_from = ?, valid_to = ?, offer_img = ? WHERE offerid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, offer.getTitle());
            statement.setString(2, offer.getDescription());
            statement.setString(3, offer.getDiscountPercentage());
            statement.setString(4, offer.getValidFrom());
            statement.setString(5, offer.getValidTo());
            statement.setString(6, offer.getOfferImg());
            statement.setInt(7, offer.getOfferId());
            statement.executeUpdate();
        }
    }

    // Method to delete an offer
    public void deleteOffer(int offerId) throws SQLException {
        String sql = "DELETE FROM offers WHERE offerid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, offerId);
            statement.executeUpdate();
        }
    }}