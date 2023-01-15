package CommercialistDB.CommercialistDB;

public class CorsoFormazione {
	private String Descrizione;
	private String Data;
	private String Luogo;
	private boolean Pagamento;
	public CorsoFormazione(String descrizione, String data, String luogo, boolean pagamento) {
		super();
		Descrizione = descrizione;
		Data = data;
		Luogo = luogo;
		Pagamento = pagamento;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public String getLuogo() {
		return Luogo;
	}
	public void setLuogo(String luogo) {
		Luogo = luogo;
	}
	public boolean isPagamento() {
		return Pagamento;
	}
	public void setPagamento(boolean pagamento) {
		Pagamento = pagamento;
	} 
	
	

}
