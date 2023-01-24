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
			if(!rs.next())
				return id;
			else {
				do {
					id = rs.getInt(id);
				}while(rs.next());
				id++;
				return id;
			}
		
		} catch (SQLException e1) {
			e1.printStackTrace();
			return 0;
		}
	}

}
