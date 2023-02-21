package CommercialistDB.CommercialistDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Paghe extends Adempimento {
	private int oreLavorative;
	private String CertificatiMalattia;
	private String DataCedolino;
	public Paghe(String descrizione, double prezzo, String dataScadenza, String dataInvio, int orelavoro, String certificatimalattia, String datacedolino) {
		super(descrizione, prezzo, dataScadenza, dataInvio);
		// TODO Auto-generated constructor stub
		this.oreLavorative = orelavoro;
		this.CertificatiMalattia = certificatimalattia;
		this.DataCedolino = datacedolino;
	}
	public int getOreLavorative() {
		return oreLavorative;
	}
	public void setOreLavorative(int oreLavorative) {
		this.oreLavorative = oreLavorative;
	}
	public String getCertificatiMalattia() {
		return CertificatiMalattia;
	}
	public void setCertificatiMalattia(String certificatiMalattia) {
		CertificatiMalattia = certificatiMalattia;
	}
	public String getDataCedolino() {
		return DataCedolino;
	}
	public void setDataCedolino(String dataCedolino) {
		DataCedolino = dataCedolino;
	}
	
	


}