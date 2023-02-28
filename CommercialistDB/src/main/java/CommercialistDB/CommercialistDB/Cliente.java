package CommercialistDB.CommercialistDB;

public class Cliente {
	private static Integer ID = getLastIDcliente.getID();
	private String CodiceFiscale;
	private String Indirizzo;
	private int id;
	public Cliente(String codiceFiscale, String indirizzo) {
		super();
		CodiceFiscale = codiceFiscale;
		Indirizzo = indirizzo;
		this.id = Cliente.ID.intValue();
		Cliente.ID++;
	}
	public int getId() {
		return id;
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
