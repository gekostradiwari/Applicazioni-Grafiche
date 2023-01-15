package CommercialistDB.CommercialistDB;

public class Albo {
	private String Quota;
	private String CodiceIscrizione;
	public Albo(String quota, String codiceIscrizione) {
		super();
		Quota = quota;
		CodiceIscrizione = codiceIscrizione;
	}
	public String getQuota() {
		return Quota;
	}
	public void setQuota(String quota) {
		Quota = quota;
	}
	public String getCodiceIscrizione() {
		return CodiceIscrizione;
	}
	public void setCodiceIscrizione(String codiceIscrizione) {
		CodiceIscrizione = codiceIscrizione;
	}
	

}
