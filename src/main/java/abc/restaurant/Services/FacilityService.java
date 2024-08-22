package abc.restaurant.Services;

import abc.restaurant.Dao.FacilityDAO;
import abc.restaurant.Model.Facility;

import java.sql.SQLException;
import java.util.List;

/**
 * Service class for managing facilities.
 */
public class FacilityService {
	
	private static FacilityService instance;
    private FacilityDAO facilityDAO;

    private FacilityService() {
        this.facilityDAO = new FacilityDAO();
    }

    public static FacilityService getInstance() {
        if (instance == null) {
            synchronized (FacilityService.class) {
                if (instance == null) {
                    instance = new FacilityService();
                }
            }
        }
        return instance;
    }

    public void addFacility(Facility facility) {
      	facilityDAO.addFacility(facility);
    }

    public List<Facility> getAllFacilities() throws SQLException {
        return facilityDAO.getAllFacilities();
    }
    
  
    
    public Facility getFacilitesById(int facilityId) {
        return facilityDAO.getFacilitiesById(facilityId);
    }
    
    public void updateFacility(Facility facility) {
        facilityDAO.updateFacility(facility);
    }
 
    public void deleteFacility(int facilityId) {
        facilityDAO.deleteFacility(facilityId);
        
    }
}
