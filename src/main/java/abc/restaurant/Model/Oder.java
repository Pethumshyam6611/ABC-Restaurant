package abc.restaurant.Model;


public class Oder {
    private int oderId;
    private String foodNamewithQT;
    private int userIdp;
    private String type;
    private double totalPrice;
    private String status;
    private String datetime;

   
    private User userDetails;

    
    public Oder(int oderId, String foodNamewithQT, int userIdp, String type, double totalPrice, String status, String datetime) {
        this.oderId = oderId;
        this.foodNamewithQT = foodNamewithQT;
        this.userIdp = userIdp;
        this.type = type;
        this.totalPrice = totalPrice;
        this.status = status;
        this.datetime = datetime;
    }

    
    public Oder(int oderId, String foodNamewithQT, int userIdp, String type, double totalPrice, String status, String datetime, User userDetails) {
        this.oderId = oderId;
        this.foodNamewithQT = foodNamewithQT;
        this.userIdp = userIdp;
        this.type = type;
        this.totalPrice = totalPrice;
        this.status = status;
        this.datetime = datetime;
        this.userDetails = userDetails;
    }

 
    public int getOderId() {
        return oderId;
    }

    public void setOderId(int oderId) {
        this.oderId = oderId;
    }

    public String getFoodNamewithQT() {
        return foodNamewithQT;
    }

    public void setFoodNamewithQT(String foodNamewithQT) {
        this.foodNamewithQT = foodNamewithQT;
    }

    public int getUserIdp() {
        return userIdp;
    }

    public void setUserIdp(int userIdp) {
        this.userIdp = userIdp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public User getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(User userDetails) {
        this.userDetails = userDetails;
    }
}
