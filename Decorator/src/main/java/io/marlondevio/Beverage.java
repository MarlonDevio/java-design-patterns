package io.marlondevio;

public abstract class Beverage {

	String description = "Unknown Beverage";

	public abstract double cost();

	public String getDescription() {
		return this.description ;
	}
}
