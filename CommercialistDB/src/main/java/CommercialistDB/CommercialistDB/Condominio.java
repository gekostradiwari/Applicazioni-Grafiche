package CommercialistDB.CommercialistDB;

import java.util.ArrayList;

public class Condominio extends Cliente {
	private String Denominazione;
	private int unitaAbitative;
	private ArrayList<String> Fornitori = new ArrayList<String>();
	private double quoteCondominiali;
	private String Indirizzi;
	public Condominio(String codiceFiscale, String indirizzo, String den,int abitazioni,double quote, String indirizzi,String...forn) {
		super(codiceFiscale, indirizzo);
		// TODO Auto-generated constructor stub
		this.Denominazione = den;
		this.unitaAbitative = abitazioni;
		this.quoteCondominiali = quote;
		this.Indirizzi = indirizzi;
		for(String a : forn)
			Fornitori.add(a);
	}
	public String getDenominazione() {
		return Denominazione;
	}
	public void setDenominazione(String denominazione) {
		Denominazione = denominazione;
	}
	public int getUnitaAbitative() {
		return unitaAbitative;
	}
	public void setUnitaAbitative(int unitaAbitative) {
		this.unitaAbitative = unitaAbitative;
	}
	public void getFornitori() {
		for(String s : this.Fornitori)
			System.out.println(s);
	}
	public void setFornitori(String...s) {
		for(String a : s)
			this.Fornitori.add(a);
	}

	public double getQuoteCondominiali() {
		return quoteCondominiali;
	}
	public void setQuoteCondominiali(double quoteCondominiali) {
		this.quoteCondominiali = quoteCondominiali;
	}
	public String getIndirizzi() {
		return Indirizzi;
	}
	public void setIndirizzi(String indirizzi) {
		Indirizzi = indirizzi;
	}
}
