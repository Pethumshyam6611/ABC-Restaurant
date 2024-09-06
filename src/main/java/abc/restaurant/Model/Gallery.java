package abc.restaurant.Model;

public class Gallery {
	
	 private int galleryId;
	    private String galleryImg;

	   
	    public Gallery() {
	    }

	    
	    public Gallery(int galleryId, String galleryImg) {
	        this.galleryId = galleryId;
	        this.galleryImg = galleryImg;
	    }

	   
	    public int getGalleryId() {
	        return galleryId;
	    }

	    public void setGalleryId(int galleryId) {
	        this.galleryId = galleryId;
	    }

	    public String getGalleryImg() {
	        return galleryImg;
	    }

	    public void setGalleryImg(String galleryImg) {
	        this.galleryImg = galleryImg;
	    }

	
}
