package io.marlondevio;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BankAccount bankAccount = BankAccount.getInstance();
		BankAccountData bankAccountData = bankAccount.getBankAccountData();

		Category winkeluitgaven = new ExpenseCategory("Winkeluitgaven");
		Category medicijnen = new ExpenseCategory("Medicijnen");
		Category loon = new IncomeCategory("Loon");
		Category freelanceWerk = new IncomeCategory("Freelance Werk");

		Transaction voedingTransactie = new Transaction(55);
		Transaction medicijnTransactie = new Transaction(105);
		Transaction wekelijksLoon = new Transaction(400);
		Transaction freelanceInkomst = new Transaction(899);
		Transaction nogFreelanceInkomst = new Transaction(399);

		winkeluitgaven.addToCategory(voedingTransactie);
		medicijnen.addToCategory(medicijnTransactie);
		loon.addToCategory(wekelijksLoon);
		freelanceWerk.addToCategory(freelanceInkomst);
		freelanceWerk.addToCategory(nogFreelanceInkomst);

		bankAccount.addCategories(winkeluitgaven);
		bankAccount.addCategories(medicijnen);
		bankAccount.addCategories(loon);
		bankAccount.addCategories(freelanceWerk);

		Observer view = new TransactionView();
		bankAccountData.registerObserver(view);

		while(true){
			Transaction tr;
			System.out.println("Amount: ");
			double amount = scanner.nextDouble();
			if(amount == 1){
				break;
			}
			tr = new Transaction(amount);
			loon.addToCategory(tr);
			bankAccountData.setTransactions(bankAccount.getCategories());
		}

	}

}
