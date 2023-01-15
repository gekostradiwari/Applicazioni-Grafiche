package CommercialistDB.CommercialistDB;

public class DDIVA extends Adempimento {
	private double ImportoIVAacquisti;
	private double ImportoIVAvendite;
	public DDIVA(String codiceID, String descrizione, double prezzo, String dataScadenza, String dataInvio,double IVAacquisti, double IVAvendite) {
		super(codiceID, descrizione, prezzo, dataScadenza, dataInvio);
		// TODO Auto-generated constructor stub
		this.ImportoIVAacquisti = IVAacquisti;
		this.ImportoIVAvendite = IVAvendite;
	}
	public double getImportoIVAacquisti() {
		return ImportoIVAacquisti;
	}
	public void setImportoIVAacquisti(double importoIVAacquisti) {
		ImportoIVAacquisti = importoIVAacquisti;
	}
	public double getImportoIVAvendite() {
		return ImportoIVAvendite;
	}
	public void setImportoIVAvendite(double importoIVAvendite) {
		ImportoIVAvendite = importoIVAvendite;
	}
	
	

}
