package abc.restaurant.Controller;
import abc.restaurant.Model.Offer;
import abc.restaurant.Services.OfferService;

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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@WebServlet("/offer")
@MultipartConfig
public class OfferController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private OfferService offerService;

    @Override
    public void init() throws ServletException {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        offerService = OfferService.getInstance(connection);
    }

    private String getUploadPath() {
        Properties properties = new Properties();
        try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/classes/MenuItemFolderPath.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find OfferImagePath.properties");
            }
            properties.load(input);
            return properties.getProperty("image.upload.path");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error reading OfferImagePath.properties", ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.equals("list")) {
            listOffers(request, response);
        } else if (action.equals("add")) {
            showAddForm(request, response);
        } else if (action.equals("edit")) {
            showEditForm(request, response);
        } else if (action.equals("delete")) {
            deleteOffer(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            addOffer(request, response);
        } else if (action.equals("update")) {
            updateOffer(request, response);
        }
    }

    private void listOffers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Offer> offerList = new ArrayList<>();
        try {
            offerList = offerService.getAllOffers();
            request.setAttribute("offers", offerList);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("WEB-INF/view/OfferDashboard.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/addOffer.jsp").forward(request, response);
    }

    private void addOffer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String discountPercentage = request.getParameter("discountPercentage");
        String validFrom = request.getParameter("validFrom");
        String validTo = request.getParameter("validTo");
        
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

        Offer offer = new Offer();
        offer.setTitle(title);
        offer.setDescription(description);
        offer.setDiscountPercentage(discountPercentage);
        offer.setValidFrom(validFrom);
        offer.setValidTo(validTo);
        offer.setOfferImg(imageUrl);

        offerService.addOffer(offer);

        response.sendRedirect("offer?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        if (id != null && !id.trim().isEmpty()) {
            try {
                int offerId = Integer.parseInt(id);
                Offer offer = offerService.getOfferById(offerId);

                if (offer != null) {
                    request.setAttribute("offer", offer);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/editOffer.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("errorMessage", "Offer not found.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Invalid offer ID format.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                request.setAttribute("errorMessage", "Error: " + e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("offer?action=list");
        }
    }

    private void updateOffer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int offerId = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String discountPercentage = request.getParameter("discountPercentage");
        String validFrom = request.getParameter("validFrom");
        String validTo = request.getParameter("validTo");

        Part imagePart = request.getPart("image");
        String imageUrl = null;

        Offer existingOffer = offerService.getOfferById(offerId);

        if (existingOffer == null) {
            request.setAttribute("errorMessage", "Offer not found.");
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            return;
        }

        String oldImageUrl = existingOffer.getOfferImg();

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
                if (oldImageFile.exists()) {
                    boolean deleted = oldImageFile.delete();
                    if (!deleted) {
                        System.err.println("Failed to delete the old image file: " + oldImageFile.getAbsolutePath());
                    }
                }
            }
        } else {
            imageUrl = oldImageUrl;
        }

        Offer updatedOffer = new Offer();
        updatedOffer.setOfferId(offerId);
        updatedOffer.setTitle(title);
        updatedOffer.setDescription(description);
        updatedOffer.setDiscountPercentage(discountPercentage);
        updatedOffer.setValidFrom(validFrom);
        updatedOffer.setValidTo(validTo);
        updatedOffer.setOfferImg(imageUrl);

        try {
            offerService.updateOffer(updatedOffer);
            response.sendRedirect("offer?action=list");
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Error updating offer: " + e.getMessage());
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
        }
    }

    private void deleteOffer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            try {
                int offerId = Integer.parseInt(id);
                Offer offer = offerService.getOfferById(offerId);
                if (offer != null) {
                    String imageUrl = offer.getOfferImg();
                    offerService.deleteOffer(offerId);

                    if (imageUrl != null && !imageUrl.trim().isEmpty()) {
                        String uploadPath = getUploadPath();
                        File file = new File(uploadPath + File.separator + Paths.get(imageUrl).getFileName());
                        if (file.exists() && !file.delete()) {
                            throw new IOException("Failed to delete image file: " + file.getAbsolutePath());
                        }
                    }

                    response.sendRedirect("offer?action=list");
                } else {
                    request.setAttribute("errorMessage", "Offer not found.");
                    request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Invalid offer ID format.");
                request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("errorMessage", "Error: " + e.getMessage());
                request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("offer?action=list");
        }
    }}