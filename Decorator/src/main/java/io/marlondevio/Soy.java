package io.marlondevio;

public class Soy extends CondimentDecorator {

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public double cost() {
		return beverage.cost() + .50;
	}

	@Override
	public String getDescription() {
		return this.beverage.getDescription() + ", Soy";
	}
}
