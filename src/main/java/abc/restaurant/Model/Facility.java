package abc.restaurant.Model;

public class Facility {

    private int facilityId;
    private String facilityName;
    private String description;
    private String facilityImg; // Assuming this is a URL or file path to the image

    // Default constructor
    public Facility() {
    }

    // Parameterized constructor
    public Facility(int facilityId, String facilityName, String description, String facilityImg) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.description = description;
        this.facilityImg = facilityImg;
    }
    
    public Facility(int facilityId, String facilityName,String facilityImg) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityImg = facilityImg;
    }
    
    public Facility(int facilityId, String facilityName) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;

    }

 // Getter and Setter for FacilityId
    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int FacilityId) {
        this.facilityId = FacilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacilityImg() {
        return facilityImg;
    }

    public void setFacilityImg(String facilityImg) {
        this.facilityImg = facilityImg;
    }
}