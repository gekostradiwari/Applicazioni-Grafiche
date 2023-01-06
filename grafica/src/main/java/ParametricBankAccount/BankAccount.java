package ParametricBankAccount;

public class BankAccount implements Measurable{
	public BankAccount() {
		balance = 0;
	}
	
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void transfer(double amount, BankAccount other) {
		this.withdraw(amount);
		other.deposit(amount);
	}
	
	private double balance;

	@Override
	public double getMeasure() {
		return this.balance;
	}
}
