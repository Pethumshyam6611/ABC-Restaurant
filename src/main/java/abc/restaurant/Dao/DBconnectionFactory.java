package abc.restaurant.Dao;

import java.sql.Connection;

public class DBconnectionFactory {
	public static Connection getConnection() {
		
		return DBconnection.getInstance().getConnection();
		
	}
}
