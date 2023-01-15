package CommercialistDB.CommercialistDB;

public class Cliente {
	private static int ID = 0;
	private String CodiceFiscale;
	private String Indirizzo;
	public Cliente(String codiceFiscale, String indirizzo) {
		super();
		CodiceFiscale = codiceFiscale;
		Indirizzo = indirizzo;
		ID++;
	}
	public static int getID() {
		return ID;
	}
	public String getCodiceFiscale() {
		return CodiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		CodiceFiscale = codiceFiscale;
	}
	public String getIndirizzo() {
		return Indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}
	public void eliminaCliente() {
		ID--;
	}
}
