package MeasurableBankAccount;

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
	
	
	public double getCoinValue() {
		return coinValue;
	}
	public String getCoinName() {
		return coinName;
	}


	@Override
	public String toString() {
		return "Coin [coinName=" + coinName + "]";
	}


	double coinValue;
	String coinName;

}
