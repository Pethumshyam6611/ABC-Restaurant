package abc.restaurant.Controller;

import abc.restaurant.Model.Facility;
import abc.restaurant.Services.FacilityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@WebServlet("/facility")
@MultipartConfig
public class FacilityController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FacilityService facilityService;

    public void init() throws ServletException {
        facilityService = FacilityService.getInstance();
    }

    private String getUploadPath() {
        Properties properties = new Properties();
        try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/classes/MenuItemFolderPath.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find FacilityFolderPath.properties");
            }
            properties.load(input);
            return properties.getProperty("image.upload.path");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error reading FacilityFolderPath.properties", ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.equals("list")) {
            listFacilities(request, response);
        } else if (action.equals("add")) {
            showAddForm(request, response);
        } else if (action.equals("edit")) {
            showEditForm(request, response);
        } else if (action.equals("delete")) {
            deleteFacility(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            addFacility(request, response);
        } else if (action.equals("update")) {
            updateFacility(request, response);
        }
    }

    private void listFacilities(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Facility> facilityList = new ArrayList<>();
        try {
            // Fetch the list of all facilities from the service
            facilityList = facilityService.getAllFacilities();
            
            // Log the size of the facility list for debugging
            System.out.println("Number of facilities retrieved: " + facilityList.size());

            // Set the list of facilities as a request attribute
            request.setAttribute("facilities", facilityList);

            // Forward the request to the FacilityDashboard.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/FacilityDashboard.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Handle SQL exceptions and set the error message
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // Handle other exceptions
            request.setAttribute("errorMessage", "Error: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
        }
    }


    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/addFacility.jsp");
        dispatcher.forward(request, response);
    }

    private void addFacility(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
    	        String description = request.getParameter("description");
    
   	 Part imagePart = request.getPart("image");
   	 String imageUrl = null;
        
        
        if (imagePart != null && imagePart.getSize() > 0) {
            String imageFileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
 
            String uploadPath = getUploadPath();
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
 
            try {
                File file = new File(uploadPath + File.separator + imageFileName);
                imagePart.write(file.getAbsolutePath());
                imageUrl = "images/" + imageFileName;
            } catch (IOException e) {
                e.printStackTrace();
                throw new ServletException("File upload failed.");
            }
        }
 
       Facility facility = new Facility();
  	   facility.setFacilityName(name);
                 facility.setDescription(description);
    	       facility.setFacilityImg(imageUrl);

      
 
 
        facilityService.addFacility(facility);
 
        response.sendRedirect("facility?action=list");
    }

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id = request.getParameter("id");
	    
	    if (id != null && !id.trim().isEmpty()) {
	        try {
	            int facilityId = Integer.parseInt(id);
	            Facility facility = facilityService.getFacilitesById(facilityId);
	            
	            if (facility != null) {
	                request.setAttribute("facility", facility);
	                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/editFacility.jsp");
	                dispatcher.forward(request, response);
	            } else {
	                // Handle case where the menu ID does not exist
	                request.setAttribute("errorMessage", "Faciility item not found.");
	                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
	                dispatcher.forward(request, response);
	            }
	        } catch (NumberFormatException e) {
	            
	            request.setAttribute("errorMessage", "Invalid facility ID format.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
	            dispatcher.forward(request, response);
	        } catch (Exception e) {
	           
	            request.setAttribute("errorMessage", "Error: " + e.getMessage());
	            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
	            dispatcher.forward(request, response);
	        }
	    } else {
	        
	        response.sendRedirect("facility?action=list");
	    }
	}





	private void updateFacility(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int facilityId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Part imagePart = request.getPart("image");
        String imageUrl = null;

        Facility existingFacility = facilityService.getFacilitesById(facilityId);

        if (existingFacility == null) {
            request.setAttribute("errorMessage", "Facility item not found.");
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            return;
        }

        String oldImageUrl = existingFacility.getFacilityImg();
        String uploadPath = getUploadPath();
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        if (imagePart != null && imagePart.getSize() > 0) {
            String imageFileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
            File newImageFile = new File(uploadPath + File.separator + imageFileName);

            try {
                imagePart.write(newImageFile.getAbsolutePath());
                imageUrl = "images/" + imageFileName;
            } catch (IOException e) {
                e.printStackTrace();
                throw new ServletException("File upload failed.");
            }

            if (oldImageUrl != null && !oldImageUrl.isEmpty()) {
                File oldImageFile = new File(uploadPath + File.separator + Paths.get(oldImageUrl).getFileName());
                if (oldImageFile.exists() && !oldImageFile.delete()) {
                    System.err.println("Failed to delete the old image file: " + oldImageFile.getAbsolutePath());
                }
            }
        } else {
            imageUrl = oldImageUrl;
        }

        Facility updatedFacility = new Facility();
        updatedFacility.setFacilityId(facilityId);
        updatedFacility.setFacilityName(name);
        updatedFacility.setDescription(description);
        updatedFacility.setFacilityImg(imageUrl);

        try {
            facilityService.updateFacility(updatedFacility);
            response.sendRedirect("facility?action=list");
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Error updating facility: " + e.getMessage());
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
        }
    }

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        if (id == null || id.trim().isEmpty()) {
            response.sendRedirect("facility?action=list");
            return;
        }

        int facilityId;
        try {
            facilityId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid facility ID format.");
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            return;
        }

        Facility facility = facilityService.getFacilitesById(facilityId);

        if (facility == null) {
            request.setAttribute("errorMessage", "Facility item not found.");
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            return;
        }

        String imageUrl = facility.getFacilityImg();
        facilityService.deleteFacility(facilityId);

        if (imageUrl != null && !imageUrl.trim().isEmpty()) {
            String uploadPath = getUploadPath();
            File file = new File(uploadPath + File.separator + Paths.get(imageUrl).getFileName());

            if (file.exists() && !file.delete()) {
                throw new IOException("Failed to delete image file: " + file.getAbsolutePath());
            }
        }

        response.sendRedirect("facility?action=list");
    }


}
