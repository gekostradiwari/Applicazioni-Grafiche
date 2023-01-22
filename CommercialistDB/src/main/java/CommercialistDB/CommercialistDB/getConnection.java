package CommercialistDB.CommercialistDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class getConnection {
	public static Connection newConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.1.189:3306/BuisnessConsultantDB?user=remoteAdmin&password=toor");
			System.out.println("Succesfully connected to the database.");
			return conn;
		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		return null;

	}

}
