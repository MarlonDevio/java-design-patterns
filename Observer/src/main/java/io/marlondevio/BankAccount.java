package io.marlondevio;

import java.util.HashSet;
import java.util.Set;

public class BankAccount {

	private static BankAccount instance;
	private final Set<Category> categories;
	private BankAccountData bankAccountData;

	private BankAccount() {
		this.categories = new HashSet<>();
		this.bankAccountData = new BankAccountData();
	}

	public static BankAccount getInstance() {
		if (instance == null) {
			instance = new BankAccount();
			return instance;
		}
		return instance;
	}

	public BankAccountData getBankAccountData() {
		return bankAccountData;
	}

	public void addCategories(Category category) {
		this.categories.add(category);
	}

	public void removeCategorie(Category category) {
		this.categories.remove(category);
	}

	public Set<Category> getCategories(){
		return this.categories;
	}

}
