package abc.restaurant.Services;

import abc.restaurant.Dao.ReservationDAO;
import abc.restaurant.Model.Reservation;

import java.sql.SQLException;
import java.util.List;

/**
 * Service class for managing reservations.
 */
public class ReservationService {

    private static ReservationService instance;
    private ReservationDAO reservationDAO;

    // Private constructor to prevent direct instantiation
    private ReservationService() {
        this.reservationDAO = new ReservationDAO();
    }

    // Singleton pattern to ensure a single instance of ReservationService
    public static ReservationService getInstance() {
        if (instance == null) {
            synchronized (ReservationService.class) {
                if (instance == null) {
                    instance = new ReservationService();
                }
            }
        }
        return instance;
    }

    // Method to add a new reservation
    public void addReservation(Reservation reservation) {
        reservationDAO.addReservation(reservation);
    }

    // Method to retrieve all reservations
    public List<Reservation> getAllReservations() throws SQLException {
        return reservationDAO.getAllReservations();
    }

    // Method to retrieve a reservation by its ID
    public Reservation getReservationById(int reservationId) {
        return reservationDAO.getReservationById(reservationId);
    }

    // Method to update an existing reservation
    public void updateReservation(Reservation reservation) {
        reservationDAO.updateReservation(reservation);
    }

    // Method to delete a reservation by its ID
    public void deleteReservation(int reservationId) {
        reservationDAO.deleteReservation(reservationId);
    }
}
