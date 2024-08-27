package abc.restaurant.Services;

import abc.restaurant.Dao.GalleryDAO;
import abc.restaurant.Model.Gallery;

import java.sql.SQLException;
import java.util.List;

/**
 * Service class for managing gallery operations.
 */
public class GalleryService {

    private GalleryDAO galleryDAO;

    // Constructor to initialize the GalleryDAO
    public GalleryService() {
        this.galleryDAO = new GalleryDAO();
    }

    // Add a new gallery image
    public void addGallery(Gallery gallery) {
        galleryDAO.addGallery(gallery);
    }

    // Get all gallery images
    public List<Gallery> getAllGalleries() throws SQLException, ClassNotFoundException {
        return galleryDAO.getAllGalleries();
    }

    // Get gallery image by ID
    public Gallery getGalleryById(int galleryId) {
        return galleryDAO.getGalleryById(galleryId);
    }


    // Delete a gallery image by ID
    public void deleteGallery(int galleryId) {
        galleryDAO.deleteGallery(galleryId);
    }
}
