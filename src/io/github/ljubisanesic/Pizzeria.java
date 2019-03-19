package io.github.ljubisanesic;

import java.util.ArrayList;

public class Pizzeria {
	
	private ArrayList<Pizza> listOfPizzas = new ArrayList<>();
	
	public Pizzeria() {
		
	}

	public Pizzeria(ArrayList<Pizza> listOfPizzas) {
		this.listOfPizzas = listOfPizzas;
	}
	
	public int getState() {
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
		System.out.println("\t\t\tNapravljene su " + numberOfMadePizzas + " pica/e i novo stanje je " + getState());
	}

	public void sellPizza(int numberOfSoldPizzas) {
		if (getState() < numberOfSoldPizzas) {
			System.out.println("Nema dovoljno pica za prodaju (" + getState() + " na stanju)");
			return;
		} else {
			for (int i = 0; i < numberOfSoldPizzas; i++) {
				removePizzaFromList();
			}
		}
		System.out.println("\t\t\tProdali ste " + numberOfSoldPizzas + " picu/e i novo stanje je " + getState());
	}
}
