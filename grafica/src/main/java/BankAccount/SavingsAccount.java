package BankAccount;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(double rate) {
		interestRate = rate;
	}
	
	public void addInterest() {
		double interest = this.getBalance() * interestRate / 100;
		this.deposit(interest);
	}
	private double interestRate;
}
