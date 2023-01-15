package CommercialistDB.CommercialistDB;

public class CU {
	private String ValoreCertificazione;
	private int numeroCertificazione;
	public CU(String valoreCertificazione, int numeroCertificazione) {
		super();
		this.ValoreCertificazione = valoreCertificazione;
		this.numeroCertificazione = numeroCertificazione;
	}
	public String getValoreCertificazione() {
		return ValoreCertificazione;
	}
	public void setValoreCertificazione(String valoreCertificazione) {
		ValoreCertificazione = valoreCertificazione;
	}
	public int getNumeroCertificazione() {
		return numeroCertificazione;
	}
	public void setNumeroCertificazione(int numeroCertificazione) {
		this.numeroCertificazione = numeroCertificazione;
	}
	
	
	

}
