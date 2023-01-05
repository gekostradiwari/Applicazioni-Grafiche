package BankAccount;

public class Coin implements Measurable {
	
	public Coin(double coinValue, String coinName) {
		super();
		this.coinValue = coinValue;
		this.coinName = coinName;
	}
	@Override
	public double getMeasure() {
		return coinValue;
	}
	
	double coinValue;
	String coinName;

}
