package CommercialistDB.CommercialistDB;

public class Fattura {
	private static Integer Id = 0;
	private String Data;
	private double Importo;
	private int id;
	public Fattura(String data, double importo) {
		super();
		Data = data;
		Importo = importo;
		id = Fattura.Id.intValue();
		Id++;
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
		Id--;
	}
	public int getId() {
		return this.id;
	}
	

}
