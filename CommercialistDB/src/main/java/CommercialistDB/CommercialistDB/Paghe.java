package CommercialistDB.CommercialistDB;

public class Paghe extends Adempimento {
	private int oreLavorative;
	private int CertificatiMalattia;
	private String DataCedolino;
	public Paghe(String codiceID, String descrizione, double prezzo, String dataScadenza, String dataInvio, int orelavoro, int certificatimalattia, String datacedolino) {
		super(codiceID, descrizione, prezzo, dataScadenza, dataInvio);
		// TODO Auto-generated constructor stub
		this.oreLavorative = orelavoro;
		this.CertificatiMalattia = certificatimalattia;
		this.DataCedolino = datacedolino;
	}
	public int getOreLavorative() {
		return oreLavorative;
	}
	public void setOreLavorative(int oreLavorative) {
		this.oreLavorative = oreLavorative;
	}
	public int getCertificatiMalattia() {
		return CertificatiMalattia;
	}
	public void setCertificatiMalattia(int certificatiMalattia) {
		CertificatiMalattia = certificatiMalattia;
	}
	public String getDataCedolino() {
		return DataCedolino;
	}
	public void setDataCedolino(String dataCedolino) {
		DataCedolino = dataCedolino;
	}
	

}
