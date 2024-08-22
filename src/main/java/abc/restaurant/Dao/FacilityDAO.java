package abc.restaurant.Dao;

import abc.restaurant.Model.Facility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class for interacting with the facilities table in the database.
 */
public class FacilityDAO {

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        return DBconnectionFactory.getConnection();
    }

    public void addFacility(Facility facility) {
        String query = "INSERT INTO facilities (facility_name, description, facility_img) VALUES (?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
        	 connection = DBconnectionFactory.getConnection(); // Obtain a connection
            statement = connection.prepareStatement(query); // Prepare the SQL query
            statement.setString(1, facility.getFacilityName()); // Set parameters
            statement.setString(2, facility.getDescription());
            statement.setString(3, facility.getFacilityImg());
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

    public List<Facility> getAllFacilities() throws SQLException {
        List<Facility> facilities = new ArrayList<>();
        String query = "SELECT * FROM facilities"; // Make sure the table name matches your database schema

        Connection connection = DBconnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        
        while (resultSet.next()) {
            int facilityId = resultSet.getInt("facilitiyid");
            String facilityName = resultSet.getString("facility_name");
            String description = resultSet.getString("description");
            String facilityImg = resultSet.getString("facility_img");

            Facility facility = new Facility(facilityId, facilityName, description, facilityImg);
            facilities.add(facility);
        }
        
        resultSet.close();
        statement.close();
      
        return facilities;
    }

    public Facility getFacilitiesById(int facilityId) {
        String query = "SELECT * FROM facilities WHERE facilitiyid = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Facility facility = null;
 
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, facilityId);
            resultSet = statement.executeQuery();
 
            if (resultSet.next()) {
               String facilityName = resultSet.getString("facility_name");
               String description = resultSet.getString("description");
               String facilityImg = resultSet.getString("facility_img");

               facility= new Facility(facilityId, facilityName, description, facilityImg);
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
 
        return facility;
    }

    public void updateFacility(Facility facility) {
        String query = "UPDATE facilities SET  facility_name= ?, description = ?, facility_img = ? WHERE facilitiyid = ?";
        Connection connection = null;
        PreparedStatement statement = null;
 
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, facility.getFacilityName());
            statement.setString(2, facility.getDescription());
            statement.setString(3, facility.getFacilityImg());
            statement.setInt(4, facility.getFacilityId()); // Ensure this matches your model's field name
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

    public void deleteFacility(int facilityId) {
        String query = "DELETE FROM facilities WHERE facilitiyid = ?";
        Connection connection = null;
        PreparedStatement statement = null;
 
        try {
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, facilityId);
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

    private Facility mapResultSetToFacility(ResultSet rs) throws SQLException {
        int facilityId = rs.getInt("facilitiyid");
        String facilityName = rs.getString("facility_name");
        String description = rs.getString("description");
        String facilityImg = rs.getString("facility_img");

        return new Facility(facilityId, facilityName, description, facilityImg);
    }
}
