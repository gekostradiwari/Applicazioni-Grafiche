package MeasurableBankAccount;

public class DataSetTest {

	public static void main(String[] args) {
		DataSet ds = new DataSet();
		ds.add(new BankAccount(0));
		ds.add(new BankAccount(10000));
		ds.add(new BankAccount(2000));
		System.out.println("Saldo medio = " + ds.getAverage());
		Measurable max = ds.getMaximum();
		System.out.println("Saldo piu alto = " + max.getMeasure());
		DataSet coinData = new DataSet();
		coinData.add(new Coin(0.25,"quarter"));
		coinData.add(new Coin(0.1,"dime"));
		coinData.add(new Coin(0.05,"nickel"));
		System.out.println("Valore medio delle monete = " + coinData.getAverage());
		max = coinData.getMaximum();
		System.out.println("Valore max delle monete = "+max.getMeasure());

	}

}
