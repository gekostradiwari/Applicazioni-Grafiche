package ParametricBankAccount;

public class CheckingAccount extends BankAccount{

	public CheckingAccount(double initialBalance) {
		super(initialBalance);
		transactionCount = 0;
	}

	@Override
	public void deposit(double amount) {
		transactionCount++;
		super.deposit(amount);
	}

	@Override
	public void withdraw(double amount) {
		transactionCount++;
		super.withdraw(amount);
	}
	
	public void deductFees() {
		if(transactionCount > FREE_TRANSACTIONS) {
			double fees = TRANSACTION_FEE * (transactionCount - FREE_TRANSACTIONS);
			super.withdraw(fees);
		}
		transactionCount = 0;
	}
	
	private int transactionCount;
	private static final int FREE_TRANSACTIONS = 3;
	private static final double TRANSACTION_FEE = 2.0;
}
