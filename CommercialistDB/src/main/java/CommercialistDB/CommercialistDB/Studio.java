package CommercialistDB.CommercialistDB;

public class Studio {
	private String nome;
	private String Indirizzo;
	private String RecapitoTelefonico; 
	private static int ID = 0; //KEY
	public Studio(String indirizzo, String recapitoTelefonico, String name) {
		super();
		Indirizzo = indirizzo;
		RecapitoTelefonico = recapitoTelefonico;
		nome = name;
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
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		System.out.println(this.getNome() + this.getIndirizzo() + this.getRecapitoTelefonico() + this.getID());
		return super.toString();
	}
	

}
