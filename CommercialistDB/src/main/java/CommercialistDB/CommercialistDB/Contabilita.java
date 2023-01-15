package CommercialistDB.CommercialistDB;

public class Contabilita extends Adempimento {
	private double IVA;
	private double PagamentoTasse;
	private double Contributi;
	private double PagamentiFornitori;
	private double IncassiCliente;
	

	public Contabilita(String codiceID, String descrizione, double prezzo, String dataScadenza, String dataInvio, double IVA,double tasse,double contributi,double pagamentiFornitori,double incassiCliente) {
		super(codiceID, descrizione, prezzo, dataScadenza, dataInvio);
		// TODO Auto-generated constructor stub
		this.IVA = IVA;
		this.PagamentoTasse = tasse;
		this.Contributi = contributi;
		this.PagamentiFornitori = pagamentiFornitori;
		this.IncassiCliente = incassiCliente;
	}


	public double getIVA() {
		return IVA;
	}


	public void setIVA(double iVA) {
		IVA = iVA;
	}


	public double getPagamentoTasse() {
		return PagamentoTasse;
	}


	public void setPagamentoTasse(double pagamentoTasse) {
		PagamentoTasse = pagamentoTasse;
	}


	public double getContributi() {
		return Contributi;
	}


	public void setContributi(double contributi) {
		Contributi = contributi;
	}


	public double getPagamentiFornitori() {
		return PagamentiFornitori;
	}


	public void setPagamentiFornitori(double pagamentiFornitori) {
		PagamentiFornitori = pagamentiFornitori;
	}


	public double getIncassiCliente() {
		return IncassiCliente;
	}


	public void setIncassiCliente(double incassiCliente) {
		IncassiCliente = incassiCliente;
	}
	
	
	

}
