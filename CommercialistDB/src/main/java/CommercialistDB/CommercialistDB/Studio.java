package CommercialistDB.CommercialistDB;

public class Studio {
	private String nome;
	private String Indirizzo;
	private String RecapitoTelefonico; 
	private static Integer ID = 0; //KEY
	private int Id;
	public Studio(String indirizzo, String recapitoTelefonico, String name) {
		super();
		Indirizzo = indirizzo;
		RecapitoTelefonico = recapitoTelefonico;
		nome = name;
		Id = Studio.ID.intValue();
		Studio.ID++;
	}
	public String getIndirizzo() {
		return Indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}
	public String getRecapitoTelefonico() {
		return RecapitoTelefonico;
	}
	public void setRecapitoTelefonico(String recapitoTelefonico) {
		RecapitoTelefonico = recapitoTelefonico;
	}
	public int getID() {
		return Id;
	}
	public void setID(int iD) {
		Id = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void removeStudio() {
		Studio.ID--;
	}
	@Override
	public String toString() {
		System.out.println(this.getNome() + this.getIndirizzo() + this.getRecapitoTelefonico() + this.getID());
		return super.toString();
	}
	

}
