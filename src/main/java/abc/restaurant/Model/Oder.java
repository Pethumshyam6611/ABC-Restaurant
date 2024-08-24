package abc.restaurant.Model;

public class Oder {
    private int oderId;
    private int productId;
    private int userIdp;
    private String type;
    private double totalPrice;
    private String status;

    // Default constructor
    public Oder() {}

    // Parameterized constructor
    public Oder(int oderId, int productId, int userIdp, String type, double totalPrice, String status) {
        this.oderId = oderId;
        this.productId = productId;
        this.userIdp = userIdp;
        this.type = type;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    // Parameterized constructor
    public Oder(int oderId, int productId, int userIdp, String type, String status) {
        this.oderId = oderId;
        this.productId = productId;
        this.userIdp = userIdp;
        this.type = type;
        this.status = status;
    }
    // Parameterized constructor
    public Oder(int oderId, int productId, int userIdp,String status) {
        this.oderId = oderId;
        this.productId = productId;
        this.userIdp = userIdp;
        this.status = status;
    }
    
    
    // Getters and Setters
    public int getOderId() {
        return oderId;
    }

    public void setOderId(int oderId) {
        this.oderId = oderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
}
