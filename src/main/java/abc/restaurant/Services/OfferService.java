package abc.restaurant.Services;

import abc.restaurant.Dao.OfferDAO;
import abc.restaurant.Model.Offer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Service class for managing offers.
 */
public class OfferService {

    private static OfferService instance;
    private OfferDAO offerDAO;

    // Private constructor to initialize the OfferDAO
    private OfferService(Connection connection) {
        this.offerDAO = new OfferDAO(connection);
    }

    // Singleton pattern to get the instance of OfferService
    public static OfferService getInstance(Connection connection) {
        if (instance == null) {
            synchronized (OfferService.class) {
                if (instance == null) {
                    instance = new OfferService(connection);
                }
            }
        }
        return instance;
    }

    // Method to add a new offer
    public void addOffer(Offer offer) {
        try {
            offerDAO.addOffer(offer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get all offers
    public List<Offer> getAllOffers() throws SQLException {
        return offerDAO.getAllOffers();
    }

    // Method to get an offer by its ID
    public Offer getOfferById(int offerId) {
        try {
            return offerDAO.getOfferById(offerId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to update an existing offer
    public void updateOffer(Offer offer) {
        try {
            offerDAO.updateOffer(offer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete an offer by its ID
    public void deleteOffer(int offerId) {
        try {
            offerDAO.deleteOffer(offerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}