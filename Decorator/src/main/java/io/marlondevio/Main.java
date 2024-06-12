package io.marlondevio;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) {
		Beverage espresso = new Espresso();
		Beverage darkRoast = new DarkRoast();
		Beverage decaf = new Decaf();

		darkRoast = new Mocha(darkRoast);
		darkRoast = new Milk(darkRoast);
		darkRoast = new Soy(darkRoast);

		System.out.println(darkRoast.getDescription());
		System.out.println(darkRoast.cost());

	}

}
