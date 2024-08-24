package abc.restaurant.Services;

import abc.restaurant.Dao.PaymentDAO;
import abc.restaurant.Model.Payment;

import java.sql.SQLException;
import java.util.List;

/**
 * Service class for managing payments.
 */
public class PaymentService {

    private static PaymentService instance;
    private PaymentDAO paymentDAO;

    // Private constructor to prevent direct instantiation
    private PaymentService() {
        this.paymentDAO = new PaymentDAO();
    }

    // Singleton pattern to ensure a single instance of PaymentService
    public static PaymentService getInstance() {
        if (instance == null) {
            synchronized (PaymentService.class) {
                if (instance == null) {
                    instance = new PaymentService();
                }
            }
        }
        return instance;
    }

    // Method to add a new payment
    public void addPayment(Payment payment) {
        paymentDAO.addPayment(payment);
    }

    // Method to retrieve all payments
    public List<Payment> getAllPayments() throws SQLException {
        return paymentDAO.getAllPayments();
    }

    // Method to retrieve a payment by its ID
    public Payment getPaymentById(int paymentId) {
        return paymentDAO.getPaymentById(paymentId);
    }

    // Method to update an existing payment
    public void updatePayment(Payment payment) {
        paymentDAO.updatePayment(payment);
    }

    // Method to delete a payment by its ID
    public void deletePayment(int paymentId) {
        paymentDAO.deletePayment(paymentId);
    }
}
