package CommercialistDB.CommercialistDB;

public class IMU extends Adempimento {
	private int unitaImmobiliari;
	private int Terreni;
	private double renditaCatastale;

	public IMU(String codiceID, String descrizione, double prezzo, String dataScadenza, String dataInvio, int unitaImmo, int Terr, double rend) {
		super(codiceID, descrizione, prezzo, dataScadenza, dataInvio);
		// TODO Auto-generated constructor stub
		this.unitaImmobiliari = unitaImmo;
		this.Terreni = Terr;
		this.setRenditaCatastale(rend);
	}

	public int getUnitaImmobiliari() {
		return unitaImmobiliari;
	}

	public void setUnitaImmobiliari(int unitaImmobiliari) {
		this.unitaImmobiliari = unitaImmobiliari;
	}

	public int getTerreni() {
		return Terreni;
	}

	public void setTerreni(int terreni) {
		Terreni = terreni;
	}

	public double getRenditaCatastale() {
		return renditaCatastale;
	}

	public void setRenditaCatastale(double renditaCatastale) {
		this.renditaCatastale = renditaCatastale;
	}
	

}
