package abc.restaurant.Model;


public class Reservation {
    private int reservationId;
    private int userId;
    private String message;
    private String date;
    private String time;
    private int numberOfPeople;
    private String status;

    
    
    private User userDetails;
    
    
    
    
    public Reservation() {
    }

   
    public Reservation(int reservationId, int userId, String message, String date, String time, int numberOfPeople, String status) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.message = message;
        this.date = date;
        this.time = time;
        this.numberOfPeople = numberOfPeople;
        this.status = status;
    }

   
    public Reservation(int reservationId, int userId, String message, String date, String time, String status) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.message = message;
        this.date = date;
        this.time = time;
        this.status = status;
    }
    
    public Reservation(int reservationId, int userId, String serviceType, String date, String status) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.message = serviceType;
        this.date = date;
        this.status = status;
    }
    
    
    public Reservation(int reservationId, int userId, String serviceType,String status) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.message = serviceType;
        this.status = status;
    }
    
    
    public Reservation(int reservationId, int userId,String status) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.status = status;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public User getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(User userDetails) {
        this.userDetails = userDetails;
    }
    
}
