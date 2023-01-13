package CommercialistDB.CommercialistDB;

import java.util.ArrayList;

public class Commercialista {
	private String CodiceFiscale; //key
	private String Nome,Cognome;
	private ArrayList<String> numeriTelefono = new ArrayList<String>(3);
	private int numeroClienti = 0;
	public Commercialista(String codiceFiscale, String nome, String cognome, int numeroClienti, String... numeriTelefono) {
		super();
		this.CodiceFiscale = codiceFiscale;
		this.Nome = nome;
		this.Cognome = cognome;
		this.numeroClienti = numeroClienti;
		for(String i : numeriTelefono)
			this.numeriTelefono.add(i);
	}
	public Commercialista(String codiceFiscale, String nome, String cognome, String... numeriTelefono) {
		super();
		this.CodiceFiscale = codiceFiscale;
		this.Nome = nome;
		this.Cognome = cognome;
		for(String i : numeriTelefono)
			this.numeriTelefono.add(i);
	}
	public String getCodiceFiscale() {
		return CodiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		CodiceFiscale = codiceFiscale;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public ArrayList<String> getNumeriTelefono() {
		return numeriTelefono;
	}
	public void setNumeriTelefono(ArrayList<String> numeriTelefono) {
		this.numeriTelefono = numeriTelefono;
	}
	public int getNumeroClienti() {
		return numeroClienti;
	}
	public void setNumeroClienti(int numeroClienti) {
		this.numeroClienti = numeroClienti;
	}
	public void aggiuntaCliente() {
		this.numeroClienti++;
	}
	
	
}
