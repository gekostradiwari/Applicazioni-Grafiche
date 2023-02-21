package CommercialistDB.CommercialistDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getLastIDfattura {
	public static int getID() {
		Connection conn = getConnection.newConn();
		int id = 1;
		try {
			CallableStatement cs = conn.prepareCall("SELECT numeroProgresivo FROM Fattura");
			ResultSet rs = cs.executeQuery();			
			if(!rs.next())
				return id;
			else {
				do {
					id = rs.getInt("numeroProgresivo");
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
