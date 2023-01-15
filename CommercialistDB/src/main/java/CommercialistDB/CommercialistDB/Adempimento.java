package CommercialistDB.CommercialistDB;

public class Adempimento {
	private String CodiceID;
	private String Descrizione;
	private double Prezzo;
	private String DataScadenza;
	private String DataInvio;
	public Adempimento(String codiceID, String descrizione, double prezzo, String dataScadenza, String dataInvio) {
		super();
		CodiceID = codiceID;
		Descrizione = descrizione;
		Prezzo = prezzo;
		DataScadenza = dataScadenza;
		DataInvio = dataInvio;
	}
	public String getCodiceID() {
		return CodiceID;
	}
	public void setCodiceID(String codiceID) {
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
	

}
