package abc.restaurant.Controller;

import abc.restaurant.Model.Facility;
import abc.restaurant.Model.Gallery;
import abc.restaurant.Model.Menu;
import abc.restaurant.Model.Offer;
import abc.restaurant.Services.FacilityService;
import abc.restaurant.Services.GalleryService;
import abc.restaurant.Services.MenuService;
import abc.restaurant.Services.OfferService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/mainPage")
public class MainPageController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private OfferService offerService;
    private MenuService menuService;
    private FacilityService facilityService;
    private GalleryService galleryService; // Fixed typo from gelleryService to galleryService

    @Override
    public void init() throws ServletException {
        // Initialize the services
        offerService = OfferService.getInstance();
        menuService = MenuService.getInstance();
        facilityService = FacilityService.getInstance();
        galleryService = new GalleryService(); // Initialize GalleryService
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch the list of offers, menu items, facilities, and galleries, then forward them to the JSP
        List<Offer> offers;
        List<Menu> menuList;
        List<Facility> facilities;
        List<Gallery> galleries;
        try {
            offers = offerService.getAllOffers();
            menuList = menuService.getAllMenus();
            facilities = facilityService.getAllFacilities(); // Fetch facilities
            galleries = galleryService.getAllGalleries(); // Fetch galleries
            
            request.setAttribute("offers", offers); // Set offers as a request attribute
            request.setAttribute("menu", menuList); // Set menu items as a request attribute
            request.setAttribute("facility", facilities); // Set facilities as a request attribute
            request.setAttribute("gallery", galleries); // Set galleries as a request attribute
            
            // Retrieve error and success messages from session
            String errorMessage = (String) request.getSession().getAttribute("errorMessage");
            if (errorMessage != null) {
                request.setAttribute("errorMessage", errorMessage);
                // Remove error message from session
                request.getSession().removeAttribute("errorMessage");
            }
            
            String successMessage = (String) request.getSession().getAttribute("successMessage");
            if (successMessage != null) {
                request.setAttribute("successMessage", successMessage);
                // Remove success message from session
                request.getSession().removeAttribute("successMessage");
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}