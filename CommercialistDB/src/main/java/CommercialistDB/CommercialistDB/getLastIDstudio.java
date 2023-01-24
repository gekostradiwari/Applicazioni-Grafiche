package CommercialistDB.CommercialistDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getLastIDstudio {
	public static int getID() {
		Connection conn = getConnection.newConn();
		int id = 1;
		try {
			String query = "SELECT id FROM Studio";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);			
			while(rs.next()) {
				if(rs.getBoolean(1) == false)
					return id;
				else
					id = rs.getInt(id);
			}
			id++;
			return id;	
		} catch (SQLException e1) {
			e1.printStackTrace();
			return 0;
		}
	}

}
