package CommercialistDB.CommercialistDB;

public class CU {
	private double ValoreCertificazione;
	private static Integer lasTnumeroCertificazione = getLastIDCU.getID();
	private int idCU;
	public CU(double valoreCertificazione) {
		super();
		this.ValoreCertificazione = valoreCertificazione;
		this.idCU = CU.lasTnumeroCertificazione.intValue();
		CU.lasTnumeroCertificazione++;
	}
	public double getValoreCertificazione() {
		return ValoreCertificazione;
	}
	public void setValoreCertificazione(double valoreCertificazione) {
		ValoreCertificazione = valoreCertificazione;
	}
	public int getNumeroCertificazione() {
		return idCU;
	}

	
	
	

}
