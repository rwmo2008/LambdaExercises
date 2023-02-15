package src;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Comparator;

public class Runner {

	public static void main(String[] args) {
		BankAccount account1 = new BankAccount(12345678, 987654, "Mr J Smith", "savings", 1.1, 25362.91);
		BankAccount account2 = new BankAccount(87654321, 234567, "Ms J Jones", "current/checking", 0.2, 550);
		BankAccount account3 = new BankAccount(74639572, 946284, "Dr T Williams", "savings", 1.1, 4763.32);
		BankAccount account4 = new BankAccount(94715453, 987654, "Ms S Taylor", "savings", 1.1, 10598.01);
		BankAccount account5 = new BankAccount(16254385, 234567, "Mr P Brown", "current/checking", 0.2, -195.74);
		BankAccount account6 = new BankAccount(38776543, 946284, "Ms F Davies", "current/checking", 0.2, -503.47);
		BankAccount account7 = new BankAccount(87609802, 987654, "Mr B Wilson", "savings", 1.1, 2.5);
		BankAccount account8 = new BankAccount(56483769, 234567, "Dr E Evans", "current/checking", 0.2, -947.72);
		
		//interfaces
		Function<BankAccount,String> getCustomerBalance = account -> account.getAccountHolder() + ": " + account.getBalance();
		System.out.println(getCustomerBalance.apply(account3));
		
		//Function<BankAccount,Double> calcInterest = account -> account.getBalance() * account.getInterestRate() / 100;
		Function<BankAccount,Double> calcInterest = account -> (account.getBalance() <= 0 ? 0: (account.getBalance() * account.getInterestRate() / 100));
		System.out.println(calcInterest.apply(account2));
		System.out.println(calcInterest.apply(account8));
		
		Predicate<BankAccount> isCurrent = account -> account.getAccountType() == "current/checking" ? true:false;
		System.out.println(isCurrent.test(account1));
		System.out.println(isCurrent.test(account6));
		
		Predicate<BankAccount> isOverdrawn = account -> account.getBalance() < 0 ? true: false;
		System.out.println(isOverdrawn.test(account5));
		System.out.println(isOverdrawn.test(account7));
		
		BinaryOperator<BankAccount> higherBalance = (a1, a2) -> a1.getBalance() > a2.getBalance() ? a1:a2;
		BankAccount higherBalanceAccount = higherBalance.apply(account3, account4);
		System.out.println(higherBalanceAccount.getAccountHolder() + ": " + higherBalanceAccount.getBalance());
		
		Consumer<BankAccount> deductFee = account-> 
		{
			double newBalance = 0;
			newBalance = account.getBalance() - 10;
			account.setBalance(newBalance);
		};
		//List<BankAccount> accounts = new ArrayList<>(Arrays.asList(account2, account6));
		//accounts.forEach(deductFee);
		deductFee.accept(account2);
		deductFee.accept(account6);
		System.out.println("account2 balance: "+account2.getBalance());
		System.out.println("account6 balance: "+account6.getBalance());
		
		BiConsumer<BankAccount, Integer> withdraw = (account, withdrawal) -> 
		{
			double newBalance = 0;
			newBalance = account.getBalance() - withdrawal;
			account.setBalance(newBalance);
		};
		withdraw.accept(account1, 100);
		withdraw.accept(account5, 50);
		System.out.println("account2 balance: "+account1.getBalance());
		System.out.println("account6 balance: "+account5.getBalance());
		
		
		//Lambda for List methods
		/*
		System.out.println("Question 1+2:");
		List<BankAccount> accounts = new ArrayList<>(Arrays.asList(account1, account2, account3, account4, account5, account6, account7, account8));
		accounts.forEach(account -> System.out.println(account.toString()));
		System.out.println("Question 3:");
		accounts.forEach(account -> {
			double newBalance = 0;
			newBalance = account.getBalance() - 10;
			account.setBalance(newBalance);
		});
		accounts.forEach(account -> System.out.println(account.toString()));
		System.out.println("Question 4:");
		accounts.removeIf(account -> (account.getBalance() < -500));
		accounts.forEach(account -> System.out.println(account.toString()));
		System.out.println("Question 5:");
		accounts.removeIf(account -> (account.getAccountType() == "savings"));
		accounts.forEach(account -> System.out.println(account.toString()));
		*/
		//Comparators
		System.out.println("Question 1: ");
		List<BankAccount> accounts = new ArrayList<>(Arrays.asList(account1, account2, account3, account4, account5, account6, account7, account8));
		Comparator <BankAccount> sortBalance = 
				(BankAccount one, BankAccount other) -> Double.compare(one.getBalance(), other.getBalance());
		accounts.sort(sortBalance);
		accounts.forEach(account -> System.out.println(account.toString()));
		
		System.out.println("Question 2: ");
		Comparator <BankAccount> sortByAccountType = 
				(BankAccount one, BankAccount other) -> one.getAccountType().compareTo(other.getAccountType());
		accounts.sort(sortByAccountType);
		accounts.forEach(account -> System.out.println(account.toString()));
		
		System.out.println("Question 3: ");
		Comparator <BankAccount> sortAccountNumber = 
				(BankAccount one, BankAccount other) -> Integer.compare(one.getAccountNumber(), other.getAccountNumber());
		accounts.sort(sortAccountNumber);
		accounts.forEach(account -> System.out.println(account.toString()));
		
		System.out.println("Question 4:");
		Comparator <BankAccount> sortAccountTypeBalance = (one, other) ->
		{
			//accounts.sort(sortByAccountType);
			//accounts.sort(sortBalance);
			int account_boolNum = one.getAccountType().compareTo(other.getAccountType());
			if (account_boolNum == 0)
				account_boolNum = Double.compare(one.getBalance(), other.getBalance());
			return account_boolNum;
		};
		accounts.sort(sortAccountTypeBalance);
		accounts.forEach(account -> System.out.println(account.toString()));
		
		//map.merge()
		//Map<Integer,Integer> NumOfAcctsPerBankCode = new HashMap<>();
		//BiFunction<BankAccount, Integer, Integer> banksPerCode = 
		
	}

}
