package CommercialistDB.CommercialistDB;

public class Dipendente {
	private String CodiceFiscale;
	private String nome;
	private String cognome;
	private String DataAssunzione;
	private String TipoContratto;
	private String numeroDiTelefono;
	public Dipendente(String codiceFiscale, String nome, String cognome, String dataAssunzione, String tipoContratto,
			String numeroDiTelefono) {
		super();
		CodiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		DataAssunzione = dataAssunzione;
		TipoContratto = tipoContratto;
		this.numeroDiTelefono = numeroDiTelefono;
	}
	public String getCodiceFiscale() {
		return CodiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		CodiceFiscale = codiceFiscale;
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
	public String getDataAssunzione() {
		return DataAssunzione;
	}
	public void setDataAssunzione(String dataAssunzione) {
		DataAssunzione = dataAssunzione;
	}
	public String getTipoContratto() {
		return TipoContratto;
	}
	public void setTipoContratto(String tipoContratto) {
		TipoContratto = tipoContratto;
	}
	public String getNumeroDiTelefono() {
		return numeroDiTelefono;
	}
	public void setNumeroDiTelefono(String numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
	}
	

}
