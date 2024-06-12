package io.marlondevio;

public enum CategoryType {
	INCOME('+'), EXPENSE('-');

	private char shortName;

	CategoryType(char shortName) {
		this.shortName = shortName;
	}

	public char getShortName() {
		return this.shortName;
	}
}
