package abc.restaurant.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import abc.restaurant.Dao.DBconnection;

public class TestDBconnection {
	public static void main(String[] args) {
	    try {
	        Connection connection = DBconnectionFactory.getConnection();
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM menu");
	        
	        while (rs.next()) {
	            System.out.println("Product ID: " + rs.getInt("productid"));
	            System.out.println("Category: " + rs.getString("category"));
	            System.out.println("Name: " + rs.getString("name"));
	            System.out.println("Description: " + rs.getString("description"));
	            System.out.println("Price: " + rs.getDouble("price"));
	            System.out.println("Image: " + rs.getString("product_img"));
	        }
	        
	        rs.close();
	        stmt.close();
	        connection.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
