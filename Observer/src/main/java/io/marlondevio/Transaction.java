package io.marlondevio;

import java.time.LocalDate;
import java.util.logging.Logger;

public class Transaction implements Categorizable {

	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private double amount;
	private LocalDate date = LocalDate.now();

	public Transaction(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
