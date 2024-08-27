package abc.restaurant.Controller;

import abc.restaurant.Model.Gallery;
import abc.restaurant.Services.GalleryService;

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

@WebServlet("/gallery")
@MultipartConfig
public class GalleryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private GalleryService galleryService;

    public void init() throws ServletException {
        galleryService = new GalleryService();
    }

    private String getUploadPath() {
        Properties properties = new Properties();
        try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/classes/MenuItemFolderPath.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find GalleryFolderPath.properties");
            }
            properties.load(input);
            return properties.getProperty("image.upload.path");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error reading GalleryFolderPath.properties", ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.equals("list")) {
            listGalleries(request, response);
        } else if (action.equals("add")) {
            showAddForm(request, response);
        } else if (action.equals("delete")) {
            deleteGallery(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            addGallery(request, response);
        }
    }

    private void listGalleries(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Gallery> galleryList = new ArrayList<>();
        try {
            galleryList = galleryService.getAllGalleries();
            request.setAttribute("galleries", galleryList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/GalleryDashboard.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Error: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/addGallery.jsp");
        dispatcher.forward(request, response);
    }

    private void addGallery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        Gallery gallery = new Gallery();
        gallery.setGalleryImg(imageUrl);
        galleryService.addGallery(gallery);
        response.sendRedirect("gallery?action=list");
    }

   
    private void deleteGallery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        if (id == null || id.trim().isEmpty()) {
            response.sendRedirect("gallery?action=list");
            return;
        }

        int galleryId;
        try {
            galleryId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid gallery ID format.");
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            return;
        }

        Gallery gallery = galleryService.getGalleryById(galleryId);

        if (gallery == null) {
            request.setAttribute("errorMessage", "Gallery item not found.");
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            return;
        }

        String imageUrl = gallery.getGalleryImg();
        galleryService.deleteGallery(galleryId);

        if (imageUrl != null && !imageUrl.trim().isEmpty()) {
            String uploadPath = getUploadPath();
            File file = new File(uploadPath + File.separator + Paths.get(imageUrl).getFileName());

            if (file.exists() && !file.delete()) {
                throw new IOException("Failed to delete image file: " + file.getAbsolutePath());
            }
        }

        response.sendRedirect("gallery?action=list");
    }
}
