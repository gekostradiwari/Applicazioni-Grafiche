package CommercialistDB.CommercialistDB;

public class Fattura {
	static private int Id = 0;
	private String Data;
	private double Importo;
	public Fattura(String data, double importo) {
		super();
		Data = data;
		Importo = importo;
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
	

}
