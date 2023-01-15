package CommercialistDB.CommercialistDB;

public class Attestato {
	private String Ente;
	private String Data;
	public Attestato(String ente, String data) {
		super();
		Ente = ente;
		Data = data;
	}
	public String getEnte() {
		return Ente;
	}
	public void setEnte(String ente) {
		Ente = ente;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	

}
