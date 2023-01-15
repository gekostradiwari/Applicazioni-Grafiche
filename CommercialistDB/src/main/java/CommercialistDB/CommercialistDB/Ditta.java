package CommercialistDB.CommercialistDB;

public class Ditta extends Cliente {
	private String Denominazione;
	private String PartitaIVA;
	private String Tipo;
	private String IscrizioneCameraCommercio;
	public Ditta(String codiceFiscale, String indirizzo,String den,String PartitaIVA,String tipo,String Iscrizione) {
		super(codiceFiscale, indirizzo);
		// TODO Auto-generated constructor stub
		this.Denominazione = den;
		this.PartitaIVA = PartitaIVA;
		this.Tipo = tipo;
		this.IscrizioneCameraCommercio = Iscrizione;
	}
	public String getDenominazione() {
		return Denominazione;
	}
	public void setDenominazione(String denominazione) {
		Denominazione = denominazione;
	}
	public String getPartitaIVA() {
		return PartitaIVA;
	}
	public void setPartitaIVA(String partitaIVA) {
		PartitaIVA = partitaIVA;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getIscrizioneCameraCommercio() {
		return IscrizioneCameraCommercio;
	}
	public void setIscrizioneCameraCommercio(String iscrizioneCameraCommercio) {
		IscrizioneCameraCommercio = iscrizioneCameraCommercio;
	}
	
	

}
