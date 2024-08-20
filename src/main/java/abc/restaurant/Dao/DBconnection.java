package abc.restaurant.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/abc_restaurant";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Yashodya6611";

	private static DBconnection instance;
	private Connection connection;

	private DBconnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBconnection getInstance() {
		if (instance == null) {
			synchronized (DBconnection.class) {
				if (instance == null) {
					instance = new DBconnection();
				}
			}
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}
}
