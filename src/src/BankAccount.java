package src;

public class BankAccount {
	private int accountNumber;
	private int bankCode;
	private String accountHolder;
	private String accountType;
	private double interestRate;
	private double balance;
	public BankAccount(int accountNumber, int bankCode, String accountHolder, String accountType, double interestRate,
			double balance) {
		super();
		this.accountNumber = accountNumber;
		this.bankCode = bankCode;
		this.accountHolder = accountHolder;
		this.accountType = accountType;
		this.interestRate = interestRate;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", bankCode=" + bankCode + ", accountHolder="
				+ accountHolder + ", accountType=" + accountType + ", interestRate=" + interestRate + ", balance="
				+ balance + "]";
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBankCode() {
		return bankCode;
	}
	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
