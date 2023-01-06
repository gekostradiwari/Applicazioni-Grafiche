package ParametricBankAccount;

public class AccounTest {

	public static void main(String[] args) {
		BankAccount momsSavings = new SavingsAccount(0.5);
		BankAccount harrysChecking = new CheckingAccount(100);
		momsSavings.deposit(10000);
		momsSavings.transfer(2000, harrysChecking);
		harrysChecking.withdraw(1500);
		harrysChecking.withdraw(80);
		momsSavings.transfer(1000, harrysChecking);
		harrysChecking.withdraw(400);
		((SavingsAccount)momsSavings).addInterest();
		((CheckingAccount) harrysChecking).deductFees();
		System.out.println("Mom's savings balance = $" + momsSavings.getBalance());
		System.out.println("Harry's checking account = $" + harrysChecking.getBalance());
		
	}
}
