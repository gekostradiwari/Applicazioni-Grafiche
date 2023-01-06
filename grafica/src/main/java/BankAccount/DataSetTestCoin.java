package BankAccount;

public class DataSetTestCoin {

	public static void main(String[] args) {
		DataSetCoin coinData = new DataSetCoin();
		coinData.add(new Coin(0.25,"quarter"));
		coinData.add(new Coin(0.1,"dime"));
		coinData.add(new Coin(0.05,"nickel"));
		System.out.println("Media dei valori delle monete = "+coinData.getAverage());
		System.out.println("Moneta con valore piu alto = "+coinData.getMaximum());

	}

}
