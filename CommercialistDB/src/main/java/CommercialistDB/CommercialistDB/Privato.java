package CommercialistDB.CommercialistDB;

public class Privato extends Cliente {
	private String nome;
	private String cognome;
	private String RecapitoTelefonico;
	public Privato(String codiceFiscale, String indirizzo, String name, String surname, String recapito) {
		super(codiceFiscale, indirizzo);
		// TODO Auto-generated constructor stub
		this.nome = name;
		this.cognome = surname;
		this.RecapitoTelefonico = recapito;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getRecapitoTelefonico() {
		return RecapitoTelefonico;
	}
	public void setRecapitoTelefonico(String recapitoTelefonico) {
		RecapitoTelefonico = recapitoTelefonico;
	}
	
}
