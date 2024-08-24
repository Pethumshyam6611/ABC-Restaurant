package abc.restaurant.Model;

import java.time.LocalDateTime;

public class Payment {
    private int paymentId;
    private int oderId;
    private String paymentDateTime;
    private String method;

    // Constructors
    public Payment() {}

    public Payment(int paymentId, int oderId, String paymentDateTime, String method) {
        this.paymentId = paymentId;
        this.oderId = oderId;
        this.paymentDateTime = paymentDateTime;
        this.method = method;
    }
    public Payment(int paymentId, int oderId,String method) {
        this.paymentId = paymentId;
        this.oderId = oderId;
        this.method = method;
    }

    
    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOderId() {
        return oderId;
    }

    public void setOderId(int oderId) {
        this.oderId = oderId;
    }

    public String getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(String paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
  
}
