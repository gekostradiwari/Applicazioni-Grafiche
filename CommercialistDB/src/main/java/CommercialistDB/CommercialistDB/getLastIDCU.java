package CommercialistDB.CommercialistDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getLastIDCU {
	public static int getID() {
		Connection conn = getConnection.newConn();
		int id = 1;
		try {
			CallableStatement cs = conn.prepareCall("SELECT numeroCertificazione FROM CertificazioneUnica");
			ResultSet rs = cs.executeQuery();			
			if(!rs.next())
				return id;
			else {
				do {
					id = rs.getInt("numeroCertificazione");
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
