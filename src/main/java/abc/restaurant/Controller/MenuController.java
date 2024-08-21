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
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/menu")
@MultipartConfig

public class MenuController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private MenuService menuService;
    
	public void init() throws ServletException {
        menuService = MenuService.getInstance();
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
		    // Retrieve form parameters
		    String name = request.getParameter("name");
		    String description = request.getParameter("description");
		    double price = Double.parseDouble(request.getParameter("price"));
		    String category = request.getParameter("category");
		    
		    // Handling file upload
		    Part imagePart = request.getPart("image");
		    String imageUrl = null;
		    
		    if (imagePart != null && imagePart.getSize() > 0) {
		        // Get the original file name
		        String imageFileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
		        
		        // Define the path for saving the image files
		        String uploadPath = getServletContext().getRealPath("/images");
		        File uploadDir = new File(uploadPath);
		        if (!uploadDir.exists()) {
		            uploadDir.mkdirs(); // Create the directory if it doesn't exist
		        }
		        
		        // Save the uploaded file
		        try {
		            File file = new File(uploadPath + File.separator + imageFileName);
		            imagePart.write(file.getAbsolutePath());
		            imageUrl = "images/" + imageFileName; // Save URL relative to the web root
		        } catch (IOException e) {
		            e.printStackTrace();
		            throw new ServletException("File upload failed.");
		        }
		    }
		    
		    // Create and populate Menu object
		    Menu menu = new Menu();
		    menu.setProductName(name);
		    menu.setDescription(description);
		    menu.setPrice(price);
		    menu.setCategory(category);
		    menu.setImage(imageUrl); // Set the image URL or path
		    
		    // Add Menu to the service
		    menuService.addMenu(menu);
		    
		    // Redirect to list page
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
		                // Handle case where the menu ID does not exist in the database
		                request.setAttribute("errorMessage", "Menu item not found.");
		                request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
		            }
		        } catch (NumberFormatException e) {
		            // Handle invalid ID format
		            request.setAttribute("errorMessage", "Invalid menu ID format.");
		            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
		        } catch (Exception e) {
		            // Handle any other exceptions
		            request.setAttribute("errorMessage", "Error: " + e.getMessage());
		            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
		        }
		    } else {
		        // Redirect to the list page if ID is missing
		        response.sendRedirect("menu?action=list");
		    }
		}

	 
	 
	 private void updateMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String id = request.getParameter("id");
		    String category = request.getParameter("category");
		    String productName = request.getParameter("productName");
		    String description = request.getParameter("description");
		    double price = Double.parseDouble(request.getParameter("price"));
		    String imageUrl = request.getParameter("image"); // This is the existing image URL

		    // Handling file upload
		    Part imagePart = request.getPart("image");
		    if (imagePart != null && imagePart.getSize() > 0) {
		        // Get the original file name
		        String imageFileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();

		        // Define the path for saving the image files
		        String uploadPath = getServletContext().getRealPath("/images");
		        File uploadDir = new File(uploadPath);
		        if (!uploadDir.exists()) {
		            uploadDir.mkdirs(); // Create the directory if it doesn't exist
		        }

		        // Save the uploaded file
		        try {
		            File file = new File(uploadPath + File.separator + imageFileName);
		            imagePart.write(file.getAbsolutePath());
		            imageUrl = "images/" + imageFileName; // Save URL relative to the web root
		        } catch (IOException e) {
		            e.printStackTrace();
		            throw new ServletException("File upload failed.");
		        }
		    }

		    if (id != null) {
		        try {
		            int menuId = Integer.parseInt(id);
		            Menu menu = new Menu();
		            menu.setProductID(menuId);
		            menu.setCategory(category);
		            menu.setProductName(productName);
		            menu.setDescription(description);
		            menu.setPrice(price);
		            menu.setImage(imageUrl); // Update image URL or path

		            menuService.updateMenu(menu);
		            response.sendRedirect("menu?action=list");
		        } catch (NumberFormatException e) {
		            request.setAttribute("errorMessage", "Invalid menu ID format.");
		            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
		        } catch (Exception e) {
		            request.setAttribute("errorMessage", "Error: " + e.getMessage());
		            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
		        }
		    } else {
		        response.sendRedirect("menu?action=list");
		    }
		}
	 private void deleteMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String id = request.getParameter("id");
		    if (id != null) {
		        try {
		            int menuId = Integer.parseInt(id);
		            
		            // Fetch the menu item to get the image URL
		            Menu menu = menuService.getMenuById(menuId);
		            if (menu != null) {
		                // Get the image URL
		                String imageUrl = menu.getImage();

		                // Delete the menu item from the database
		                menuService.deleteMenu(menuId);
		                
		                // Delete the associated image file from the server
		                if (imageUrl != null && !imageUrl.trim().isEmpty()) {
		                    // Construct the file path
		                    String uploadPath = getServletContext().getRealPath("/images");
		                    File file = new File(uploadPath + File.separator + imageUrl);

		                    if (file.exists()) {
		                        boolean deleted = file.delete(); // Delete the file
		                        if (!deleted) {
		                            throw new IOException("Failed to delete image file: " + file.getAbsolutePath());
		                        }
		                    }
		                }

		                // Redirect to the list page
		                response.sendRedirect("menu?action=list");
		            } else {
		                // Handle case where the menu ID does not exist
		                request.setAttribute("errorMessage", "Menu item not found.");
		                request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
		            }
		        } catch (NumberFormatException e) {
		            request.setAttribute("errorMessage", "Invalid menu ID format.");
		            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
		        } catch (Exception e) {
		            request.setAttribute("errorMessage", "Error: " + e.getMessage());
		            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
		        }
		    } else {
		        response.sendRedirect("menu?action=list");
		    }
		}

	}
