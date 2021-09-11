package entities;

public class Account {

	private Integer number;
	private String holder;
	private double balance;
	private double withdrdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, double balance, double withdrdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrdrawLimit = withdrdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getWithdrdrawLimit() {
		return withdrdrawLimit;
	}

	public void setWithdrdrawLimit(double withdrdrawLimit) {
		this.withdrdrawLimit = withdrdrawLimit;
	}
	
	public void deposit(double  amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		validateWithdraw(amount);
		balance -= amount;
	}
	
	private void validateWithdraw(double amount) {
		if (amount > getWithdrdrawLimit()) {
			throw new BusinessException("Withdraw error: The amount exceeds withdraw limit");
		}
		if (amount > getBalance()) {
			throw new BusinessException("Withdraw error: Not enough balance");
		}
	}
}
