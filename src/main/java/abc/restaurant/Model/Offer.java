package abc.restaurant.Model;

/**
 * Model class for Offer.
 */
public class Offer {
    private int offerId;
    private String title;
    private String description;
    private int price;
    private String offerImg;

    // Default constructor
    public Offer() {
    }

    // Parameterized constructor
    public Offer(int offerId, String title, String description,int price,String offerImg) {
        this.offerId = offerId;
        this.title = title;
        this.description = description;
        this.price= price;
        this.offerImg = offerImg;
    }
    
    
    // Parameterized constructor
    public Offer(int offerId, String title, String description,String offerImg) {
        this.offerId = offerId;
        this.title = title;
        this.description = description;
        this.offerImg = offerImg;
    }
    // Parameterized constructor
    public Offer(int offerId, String title,String offerImg) {
        this.offerId = offerId;
        this.title = title;
        this.offerImg = offerImg;
    }
    
    public Offer(int offerId, String title) {
        this.offerId = offerId;
        this.title = title;
    }
  
 
    // Getters and Setters
    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String getOfferImg() {
        return offerImg;
    }

    public void setOfferImg(String offerImg) {
        this.offerImg = offerImg;
    }

}
