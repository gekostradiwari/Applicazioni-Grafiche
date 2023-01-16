package CommercialistDB.CommercialistDB;

public class Albo {
	private double Quota;
	private String CodiceIscrizione;
	public Albo(double quota, String codiceIscrizione) {
		super();
		Quota = quota;
		CodiceIscrizione = codiceIscrizione;
	}
	public double getQuota() {
		return Quota;
	}
	public void setQuota(double quota) {
		Quota = quota;
	}
	public String getCodiceIscrizione() {
		return CodiceIscrizione;
	}
	public void setCodiceIscrizione(String codiceIscrizione) {
		CodiceIscrizione = codiceIscrizione;
	}
	

}
