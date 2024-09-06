package abc.restaurant.Services;

import abc.restaurant.Dao.OderDAO;
import abc.restaurant.Model.Oder;

import java.sql.SQLException;
import java.util.List;


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

    
    public void addOder(Oder oder) {
        oderDAO.addOder(oder);
    }

    
    public List<Oder> getAllOdersWithUsers() throws SQLException {
        return oderDAO.getAllOdersWithUsers();
    }

   
    public Oder getOderById(int oderId) {
        return oderDAO.getOderById(oderId);
    }


    public void updateOder(Oder oder) {
        oderDAO.updateOder(oder);
    }

   
    public void deleteOder(int oderId) {
        oderDAO.deleteOder(oderId);
    }
}
