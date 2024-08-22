package abc.restaurant.Model;

/**
 * Model class for Offer.
 */
public class Offer {
    private int offerId;
    private String title;
    private String description;
    private String discountPercentage;
    private String validFrom;
    private String validTo;
    private String offerImg;

    // Default constructor
    public Offer() {
    }

    // Parameterized constructor
    public Offer(int offerId, String title, String description, String discountPercentage, String validFrom, String validTo, String offerImg) {
        this.offerId = offerId;
        this.title = title;
        this.description = description;
        this.discountPercentage = discountPercentage;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.offerImg = offerImg;
    }
    
    public Offer(int offerId, String title, String description, String discountPercentage,String offerImg) {
        this.offerId = offerId;
        this.title = title;
        this.description = description;
        this.discountPercentage = discountPercentage;
        this.offerImg = offerImg;
    }
    
    public Offer(int offerId, String title, String description,String offerImg) {
        this.offerId = offerId;
        this.title = title;
        this.description = description;
        this.offerImg = offerImg;
    }
    
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

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTo() {
        return validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public String getOfferImg() {
        return offerImg;
    }

    public void setOfferImg(String offerImg) {
        this.offerImg = offerImg;
    }

}
