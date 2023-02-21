package CommercialistDB.CommercialistDB;

public class DDR extends Adempimento {
	private double Detrazioni;
	private double RedditoDaFabbricati;
	private double Reddito;
	public DDR(String descrizione, double prezzo, String dataScadenza, String dataInvio,double detrazioni,double redditodafabbricati,double reddito) {
		super(descrizione, prezzo, dataScadenza, dataInvio);
		// TODO Auto-generated constructor stub
		this.Detrazioni = detrazioni; 
		this.RedditoDaFabbricati = redditodafabbricati;
		this.Reddito = reddito;
	}
	public double getDetrazioni() {
		return Detrazioni;
	}
	public void setDetrazioni(double detrazioni) {
		Detrazioni = detrazioni;
	}
	public double getRedditoDaFabbricati() {
		return RedditoDaFabbricati;
	}
	public void setRedditoDaFabbricati(double redditoDaFabbricati) {
		RedditoDaFabbricati = redditoDaFabbricati;
	}
	public double getReddito() {
		return Reddito;
	}
	public void setReddito(double reddito) {
		Reddito = reddito;
	}
	

	

}
