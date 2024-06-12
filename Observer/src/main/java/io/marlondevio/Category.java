package io.marlondevio;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Category {
	CategoryType categoryType;
	Set<Categorizable> categorizationList;
	private String name;

	public Category(String name, CategoryType categoryType){
		this.categoryType = categoryType;
		this.name = name;
		this.categorizationList = new HashSet<>();
	}

	public void addToCategory(Categorizable categorizable){
		categorizationList.add(categorizable);
	}

	public void removeFromCategory(Categorizable categorizable){
		categorizationList.remove(categorizable);
	}

	public Set<Categorizable> getCategorizationList(){
		return categorizationList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Category category)) {
			return false;
		}
		return Objects.equals(name, category.name);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}
}
