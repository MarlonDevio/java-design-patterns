package io.marlondevio;

public class Milk extends CondimentDecorator {

	public Milk(Beverage beverage){
		this.beverage = beverage;
	}

	@Override
	public double cost() {
		return beverage.cost() + .20;
	}

	@Override
	public String getDescription() {
		return this.beverage.getDescription() + ", Milk";
	}
}
