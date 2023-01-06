package BankAccount;

public class DataSetTestBankAccount {

	public static void main(String[] args) {
		DataSetBankAccount bankData = new DataSetBankAccount();
		bankData.add(new BankAccount(0));
		bankData.add(new BankAccount(10000));
		bankData.add(new BankAccount(2000));
		System.out.println("Saldo medio = "+bankData.getAverage());
		System.out.println("Saldo piu alto = "+ bankData.getMaximum());

	}

}
