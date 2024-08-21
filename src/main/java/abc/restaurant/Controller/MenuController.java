package abc.restaurant.Controller;

import abc.restaurant.Model.Menu;
import abc.restaurant.Services.MenuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@WebServlet("/menu")
@MultipartConfig

public class MenuController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private MenuService menuService;
    
	public void init() throws ServletException {
        menuService = MenuService.getInstance();
    }
	
	private String getUploadPath() {
        Properties properties = new Properties();
        try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/classes/MenuItemFolderPath.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find config.properties");
            }
            properties.load(input);
            return properties.getProperty("image.upload.path");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error reading config.properties", ex);
        }
    }
	
	
	
	

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");
	        if (action == null || action.equals("list")) {
	            listMenus(request, response);
	        } else if (action.equals("add")) {
	            showAddForm(request, response);
	        } else if (action.equals("edit")) {
	            showEditForm(request, response);
	        } else if (action.equals("delete")) {
	            deleteMenu(request, response);
	        }
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");
	        if (action.equals("add")) {
	            addMenu(request, response);
	        } else if (action.equals("update")) {
	            updateMenu(request, response);
	        }
	    }

	

	private void listMenus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	List<Menu> menuList = new ArrayList<Menu>();
		try {
			menuList = menuService.getAllMenus();
			request.setAttribute("menu", menuList);
		} catch ( SQLException e) {
			request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            return;
		}
    	
        request.getRequestDispatcher("WEB-INF/view/MenuDashboard.jsp").forward(request, response);
    }

	

		private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("WEB-INF/view/addMenu.jsp").forward(request, response);
	    }


		
		
		
		
		private void addMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String productName = request.getParameter("productName");
	        String description = request.getParameter("description");
	        double price = Double.parseDouble(request.getParameter("price"));
	        String category = request.getParameter("category");
	        
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
	 
	        Menu menu = new Menu();
	        menu.setProductName(productName);
	        menu.setDescription(description);
	        menu.setPrice(price);
	        menu.setCategory(category);
	        menu.setImage(imageUrl);
	 
	 
	        menuService.addMenu(menu);
	 
	        response.sendRedirect("menu?action=list");
	    }
	
		private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String id = request.getParameter("id");
		    
		    if (id != null && !id.trim().isEmpty()) {
		        try {
		            int menuId = Integer.parseInt(id);
		            Menu menu = menuService.getMenuById(menuId);
		            
		            if (menu != null) {
		                request.setAttribute("menu", menu);
		                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/editMenu.jsp");
		                dispatcher.forward(request, response);
		            } else {
		                // Handle case where the menu ID does not exist
		                request.setAttribute("errorMessage", "Menu item not found.");
		                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
		                dispatcher.forward(request, response);
		            }
		        } catch (NumberFormatException e) {
		            
		            request.setAttribute("errorMessage", "Invalid menu ID format.");
		            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
		            dispatcher.forward(request, response);
		        } catch (Exception e) {
		           
		            request.setAttribute("errorMessage", "Error: " + e.getMessage());
		            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
		            dispatcher.forward(request, response);
		        }
		    } else {
		        
		        response.sendRedirect("menu?action=list");
		    }
		}
		private void updateMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    // Retrieve menu item details from request parameters
		    int menuId = Integer.parseInt(request.getParameter("id"));
		    String name = request.getParameter("name");
		    String description = request.getParameter("description");
		    double price = Double.parseDouble(request.getParameter("price"));
		    String category = request.getParameter("category");

		    // Retrieve the image part from the request
		    Part imagePart = request.getPart("image");
		    String imageUrl = null;  // Default image URL to null

		    // Fetch the existing menu item
		    Menu existingMenu = menuService.getMenuById(menuId);

		    if (existingMenu == null) {
		        // Handle case where menu item does not exist
		        request.setAttribute("errorMessage", "Menu item not found.");
		        request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
		        return;
		    }

		    // Get the old image URL
		    String oldImageUrl = existingMenu.getImage();

		    // Define the upload directory
		    String uploadPath = getUploadPath();
		    File uploadDir = new File(uploadPath);

		    // Ensure the upload directory exists
		    if (!uploadDir.exists()) {
		        uploadDir.mkdirs();
		    }

		    if (imagePart != null && imagePart.getSize() > 0) {
		        // New image is being uploaded
		        String imageFileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
		        File newImageFile = new File(uploadPath + File.separator + imageFileName);

		        try {
		            // Save the new image file
		            imagePart.write(newImageFile.getAbsolutePath());
		            imageUrl = "images/" + imageFileName;  // Set the new image URL
		            System.out.println("Uploaded new image to: " + newImageFile.getAbsolutePath());
		        } catch (IOException e) {
		            e.printStackTrace();
		            throw new ServletException("File upload failed.");
		        }

		        // Delete the old image file if it exists
		        if (oldImageUrl != null && !oldImageUrl.isEmpty()) {
		            File oldImageFile = new File(uploadPath + File.separator + Paths.get(oldImageUrl).getFileName());
		            if (oldImageFile.exists()) {
		                boolean deleted = oldImageFile.delete();
		                if (!deleted) {
		                    System.err.println("Failed to delete the old image file: " + oldImageFile.getAbsolutePath());
		                } else {
		                    System.out.println("Successfully deleted old image file: " + oldImageFile.getAbsolutePath());
		                }
		            } else {
		                System.out.println("Old image file does not exist: " + oldImageFile.getAbsolutePath());
		            }
		        }
		    } else {
		        // No new image is uploaded, retain the old image URL
		        imageUrl = oldImageUrl;
		    }

		    // Update the menu item with the new image URL
		    Menu updatedMenu = new Menu();
		    updatedMenu.setProductID(menuId);
		    updatedMenu.setCategory(category);
		    updatedMenu.setProductName(name);
		    updatedMenu.setDescription(description);
		    updatedMenu.setPrice(price);
		    updatedMenu.setImage(imageUrl);

		    try {
		        menuService.updateMenu(updatedMenu);
		        response.sendRedirect("menu?action=list");
		    } catch (Exception e) {
		        request.setAttribute("errorMessage", "Error updating menu: " + e.getMessage());
		        request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
		    }
		}







	 private void deleteMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String id = request.getParameter("id");
		    if (id != null) {
		        try {
		            int menuId = Integer.parseInt(id);
		            
		           
		            Menu menu = menuService.getMenuById(menuId);
		            if (menu != null) {
		             
		                String imageUrl = menu.getImage();

		               
		                menuService.deleteMenu(menuId);
		                
		              
		                if (imageUrl != null && !imageUrl.trim().isEmpty()) {
		                   
		                    String uploadPath = getUploadPath();
		                    File file = new File(uploadPath + File.separator + Paths.get(imageUrl).getFileName());

		                    if (file.exists()) {
		                        boolean deleted = file.delete(); 
		                        if (!deleted) {
		                            throw new IOException("Failed to delete image file: " + file.getAbsolutePath());
		                        }
		                    }
		                }

		                
		                response.sendRedirect("menu?action=list");
		            } else {
		               
		                request.setAttribute("errorMessage", "Menu item not found.");
		                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
		                dispatcher.forward(request, response);
		            }
		        } catch (NumberFormatException e) {
		            request.setAttribute("errorMessage", "Invalid menu ID format.");
		            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
		            dispatcher.forward(request, response);
		        } catch (Exception e) {
		            request.setAttribute("errorMessage", "Error: " + e.getMessage());
		            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
		            dispatcher.forward(request, response);
		        }
		    } else {
		        response.sendRedirect("menu?action=list");
		    }
		}
	}
