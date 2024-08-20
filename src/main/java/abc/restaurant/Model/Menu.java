package abc.restaurant.Model;

public class Menu {
	private int productID;
	private String category;
	private String productName;
	private String description;
	private double price;
	private String image;

	public Menu(int productID,String category,String productName, String description, double price,String image) {
		
		this.productID = productID;
		this.category = category;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.image = image;
	}

	public Menu(int productID,String category,String productName, String description, double price) {
		
		this.productID = productID;
		this.category = category;
		this.productName = productName;
		this.description = description;
		this.price = price;

		
	}
	
	public Menu(int productID,String category,String productName, double price) {
		
		this.productID = productID;
		this.category = category;
		this.productName = productName;
		this.price = price;

		
	}

	
	public Menu() {
		
	}
	
	
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	
	
}
