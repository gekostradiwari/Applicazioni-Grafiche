package CommercialistDB.CommercialistDB;

public class IMU extends Adempimento {
	private int unitaImmobiliari;
	private int Terreni;

	public IMU(String codiceID, String descrizione, double prezzo, String dataScadenza, String dataInvio, int unitaImmo, int Terr) {
		super(codiceID, descrizione, prezzo, dataScadenza, dataInvio);
		// TODO Auto-generated constructor stub
		this.unitaImmobiliari = unitaImmo;
		this.Terreni = Terr;
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
	

}
