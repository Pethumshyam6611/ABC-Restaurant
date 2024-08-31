package abc.restaurant.Controller;

import abc.restaurant.Model.Facility;
import abc.restaurant.Model.Menu;
import abc.restaurant.Model.Offer;
import abc.restaurant.Services.FacilityService;
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


    @Override
    public void init() throws ServletException {
        // Initialize the OfferService and MenuService
        offerService = OfferService.getInstance();
        menuService = MenuService.getInstance();
        facilityService= FacilityService.getInstance();        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch the list of offers and menu items and forward them to the JSP
        List<Offer> offers;
        List<Menu> menuList;
        List<Facility>facilities;
        try {
            offers = offerService.getAllOffers();
            menuList = menuService.getAllMenus();
            facilities= facilityService.getAllFacilities();// Fetch menu items
            request.setAttribute("offers", offers); // Set offers as a request attribute
            request.setAttribute("menu", menuList);
            request.setAttribute("facility", facilities);// Set menu items as a request attribute
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
