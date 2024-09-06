package abc.restaurant.Services;

import abc.restaurant.Dao.GalleryDAO;
import abc.restaurant.Model.Gallery;

import java.sql.SQLException;
import java.util.List;


public class GalleryService {

    private GalleryDAO galleryDAO;

    
    public GalleryService() {
        this.galleryDAO = new GalleryDAO();
    }

    
    public void addGallery(Gallery gallery) {
        galleryDAO.addGallery(gallery);
    }


    public List<Gallery> getAllGalleries() throws SQLException, ClassNotFoundException {
        return galleryDAO.getAllGalleries();
    }

   
    public Gallery getGalleryById(int galleryId) {
        return galleryDAO.getGalleryById(galleryId);
    }


    
    public void deleteGallery(int galleryId) {
        galleryDAO.deleteGallery(galleryId);
    }
}
