package BankAccount;

public class DataSetBankAccount {

	public DataSetBankAccount() {
		sum = 0;
		count = 0;
		minimum = null;
		maximum = null;
	}
	
	public double getAverage() {
		if(count == 0)
			return 0;
		else
			return sum/count;
	}
	
	public BankAccount getMaximum() {
		return maximum;
	}
	
	public BankAccount getMinimum() {
		return minimum;
	}
	
	public void add(BankAccount x) {
		sum = sum + x.getBalance();
		if(count == 0 || minimum.getBalance() > x.getBalance())
			minimum = x;
		if(count == 0 || maximum.getBalance() < x.getBalance())
			maximum = x;
		count++;
	}
	private double sum;
	private BankAccount minimum;
	private BankAccount maximum;
	private int count;

}
