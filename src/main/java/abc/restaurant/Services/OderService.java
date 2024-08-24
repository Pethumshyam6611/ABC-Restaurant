package abc.restaurant.Services;

import abc.restaurant.Dao.OderDAO;
import abc.restaurant.Model.Oder;

import java.sql.SQLException;
import java.util.List;

/**
 * Service class for managing orders (Oders).
 */
public class OderService {
    private static OderService instance;
    private OderDAO oderDAO;

    private OderService() {
        oderDAO = new OderDAO();
    }

    public static OderService getInstance() {
        if (instance == null) {
            instance = new OderService();
        }
        return instance;
    }

    // Add a new order
    public void addOder(Oder oder) {
        oderDAO.addOder(oder);
    }

    // Retrieve all orders
    public List<Oder> getAllOders() throws SQLException {
        return oderDAO.getAllOders();
    }

    // Retrieve an order by its ID
    public Oder getOderById(int oderId) {
        return oderDAO.getOderById(oderId);
    }

    // Update an existing order
    public void updateOder(Oder oder) {
        oderDAO.updateOder(oder);
    }

    // Delete an order
    public void deleteOder(int oderId) {
        oderDAO.deleteOder(oderId);
    }
}
