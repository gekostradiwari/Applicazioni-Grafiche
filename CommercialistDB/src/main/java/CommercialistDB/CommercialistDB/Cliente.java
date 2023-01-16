package CommercialistDB.CommercialistDB;

public class Cliente {
	private static Integer ID = 0;
	private String CodiceFiscale;
	private String Indirizzo;
	private int id;
	public Cliente(String codiceFiscale, String indirizzo) {
		super();
		CodiceFiscale = codiceFiscale;
		Indirizzo = indirizzo;
		this.id = Cliente.getID();
		ID++;
	}
	private static int getID() {
		return ID.intValue();
	}
	public int getId() {
		return this.id;
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
