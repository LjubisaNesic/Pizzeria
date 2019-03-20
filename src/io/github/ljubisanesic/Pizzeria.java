package io.github.ljubisanesic;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
	
	private List<Pizza> listOfPizzas = new ArrayList<>();
	
	public Pizzeria() {
		
	}

	public Pizzeria(ArrayList<Pizza> listOfPizzas) {
		this.listOfPizzas = listOfPizzas;
	}
	
	public int getSize() {
		return listOfPizzas.size();
	}
	
	private void addPizzaToList() {
		Pizza pizza = new Pizza();
		this.listOfPizzas.add(pizza);
	}
	
	private void removePizzaFromList() {
		this.listOfPizzas.remove(listOfPizzas.size() - 1);
	}
	
	public void makePizzas(int numberOfMadePizzas) {
		for (int i = 0; i < numberOfMadePizzas; i++) {
			addPizzaToList();
		}
		System.out.println("\t\t\tNapravljene su " + numberOfMadePizzas + " pica/e i novo stanje je " + getSize());
	}

	public void sellPizza(int numberOfSoldPizzas) {
		if (getSize() < numberOfSoldPizzas) {
			System.out.println("Nema dovoljno pica za prodaju (" + getSize() + " na stanju)");
			return;
		} else {
			for (int i = 0; i < numberOfSoldPizzas; i++) {
				removePizzaFromList();
			}
		}
		System.out.println("\t\t\tProdali ste " + numberOfSoldPizzas + " picu/e i novo stanje je " + getSize());
	}
}
