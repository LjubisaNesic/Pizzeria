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
	
	private void addPizzaToList(Pizza pizza) {
		this.listOfPizzas.add(pizza);
	}
	
	private void removePizzaFromList() {
		this.listOfPizzas.remove(listOfPizzas.size() - 1);
	}
	
	public void makePizzas(int numberOfMadePizzas, Pizza pizza) {
		for (int i = 0; i < numberOfMadePizzas; i++) {
			addPizzaToList(pizza);
		}
		System.out.println("\t\t\tNapravljene su " + numberOfMadePizzas + " pica/e i novo stanje je " + getSize());
	}

	public void sellPizza(int numberOfSoldPizzas, Pizza pizza) {
		if (getNumberOfPizzasByType(pizza) < numberOfSoldPizzas) {
			System.out.println("Nema dovoljno " + pizza.getName() + " za prodaju (" + getSize() + " na stanju)");
			return;
		} else {
			for (int i = 0; i < numberOfSoldPizzas; i++) {
				removePizzaFromList();
			}
		}
		System.out.println("\t\t\tProdali ste " + numberOfSoldPizzas + " picu/e i novo stanje je " + getSize());
	}
	
	private int getNumberOfPizzasByType(Pizza pizza) {
		int numberOfPizzasByType = 0;
		
		for (int i = 0; i < this.listOfPizzas.size(); i++) {
			if(pizza.getName().equals(listOfPizzas.get(i).getName())) {
				numberOfPizzasByType++;
			}
		}
		
		return numberOfPizzasByType;
	}
}
