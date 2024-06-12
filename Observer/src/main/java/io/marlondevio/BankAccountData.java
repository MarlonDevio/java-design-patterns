package io.marlondevio;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BankAccountData implements Subject {

	private final List<Observer> observers;
	private Set<Transaction> allTransactions;
	private Set<Transaction> allIncomeTransactions;
	private Set<Transaction> allExpenseTransactions;
	private double totalIncome;
	private double totalExpense;
	private double balance;

	public BankAccountData() {
		observers = new ArrayList<>();
	}

	public void setTransactions(Set<Category> categories) {
		allTransactions = categories.stream()
			.flatMap(category -> category.getCategorizationList().stream())
			.map(categorizable -> (Transaction) categorizable)
			.collect(
				Collectors.toSet());

		allIncomeTransactions = categories.stream()
			.filter(category -> category.categoryType == CategoryType.INCOME)
			.flatMap(category -> category.getCategorizationList().stream())
			.map(categorizable -> (Transaction) categorizable)
			.collect(
				Collectors.toSet());

		allExpenseTransactions = categories.stream()
			.filter(category -> category.categoryType == CategoryType.EXPENSE)
			.flatMap(category -> category.getCategorizationList().stream())
			.map(categorizable -> (Transaction) categorizable)
			.collect(
				Collectors.toSet());

		totalIncome = allIncomeTransactions.stream().mapToDouble(Transaction::getAmount).sum();
		totalExpense = allExpenseTransactions.stream().mapToDouble(Transaction::getAmount).sum();
		balance = totalIncome - totalExpense;
		transactionsChanged();
	}

	public Set<Transaction> getAllTransactions() {
		return this.allTransactions;
	}

	public Set<Transaction> getAllIncomeTransactions() {
		return this.allIncomeTransactions;
	}

	public Set<Transaction> getAllExpenseTransactions() {
		return this.allExpenseTransactions;
	}

	public double getTotalExpense() {
		return this.totalExpense;
	}

	public double getTotalIncome() {
		return this.totalIncome;
	}

	public double getBalance() {
		return this.balance;
	}

	public void transactionsChanged() {
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		this.observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		this.observers.forEach(observer -> observer.update(this));
		for (var o : this.observers) {
			if (o instanceof DisplayElement di) {
				di.display();
			}
		}

	}

}
