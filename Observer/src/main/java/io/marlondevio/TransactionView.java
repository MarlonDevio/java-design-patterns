package io.marlondevio;

import java.util.Set;

public class TransactionView implements Observer, DisplayElement{
	Set<Transaction> transactionSet;

	@Override
	public void display() {
		if(transactionSet != null)	{
			transactionSet.forEach(transaction -> System.out.println(transaction.getAmount()));
		}
	}

	@Override
	public void update(Subject subject) {
		if(subject instanceof BankAccountData bankAccountData){
			this.transactionSet = bankAccountData.getAllTransactions();
		}
	}
}
