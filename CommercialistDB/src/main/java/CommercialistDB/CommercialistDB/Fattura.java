package CommercialistDB.CommercialistDB;

public class Fattura {
	private String Data;
	private double Importo;
	private static Integer ID =  getLastIDfattura.getID(); //KEY
	private int Id;
	public Fattura(String data, double importo) {
		super();
		Data = data;
		Importo = importo;
		Id = Fattura.ID.intValue();
		Fattura.ID++;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public double getImporto() {
		return Importo;
	}
	public void setImporto(double importo) {
		Importo = importo;
	}
	public void deleteFattura() {
		Fattura.ID--;
	}
	public int getId() {
		return this.Id;
	}
	

}
