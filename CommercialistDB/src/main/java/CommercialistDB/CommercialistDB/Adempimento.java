package CommercialistDB.CommercialistDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Adempimento {
	private static Integer ID = Adempimento.getLastID();
	private int CodiceID;
	private String Descrizione;
	private double Prezzo;
	private String DataScadenza;
	private String DataInvio;
	public Adempimento(String descrizione, double prezzo, String dataScadenza, String dataInvio) {
		super();
		Descrizione = descrizione;
		Prezzo = prezzo;
		DataScadenza = dataScadenza;
		DataInvio = dataInvio;
		CodiceID = Adempimento.ID.intValue();
		Adempimento.ID++;
	}
	public int getCodiceID() {
		return CodiceID;
	}
	public void setCodiceID(int codiceID) {
		CodiceID = codiceID;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public double getPrezzo() {
		return Prezzo;
	}
	public void setPrezzo(double prezzo) {
		Prezzo = prezzo;
	}
	public String getDataScadenza() {
		return DataScadenza;
	}
	public void setDataScadenza(String dataScadenza) {
		DataScadenza = dataScadenza;
	}
	public String getDataInvio() {
		return DataInvio;
	}
	public void setDataInvio(String dataInvio) {
		DataInvio = dataInvio;
	}
	
	public static int getLastID() {
		Connection conn = getConnection.newConn();
		int id = 1;
		try {
			String query = "SELECT codiceIdentificativo FROM Adempimento";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);			
			if(!rs.next())
				return id;
			else {
				do {
					id = rs.getInt("codiceIdentificativo");
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