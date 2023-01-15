package CommercialistDB.CommercialistDB;

public class Condominio extends Cliente {
	private String Denominazione;
	private int unitaAbitative;
	private String Fornitori;
	private double quoteCondominiali;
	private String Indirizzi;
	public Condominio(String codiceFiscale, String indirizzo, String den,int abitazioni,String fornito,double quote, String indirizzi) {
		super(codiceFiscale, indirizzo);
		// TODO Auto-generated constructor stub
		this.Denominazione = den;
		this.unitaAbitative = abitazioni;
		this.Fornitori = fornito;
		this.quoteCondominiali = quote;
		this.Indirizzi = indirizzi;
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
	public String getFornitori() {
		return Fornitori;
	}
	public void setFornitori(String fornitori) {
		Fornitori = fornitori;
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
