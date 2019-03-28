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
	
	public int  getSize() {
		return listOfPizzas.size();
	}
	
	private void addPizzaToList(Pizza pizza) {
		this.listOfPizzas.add(pizza);
	}
	
	private void removePizzaFromList(Pizza pizza) {
		for (int i = 0; i < this.listOfPizzas.size(); i++) {
			if (this.listOfPizzas.get(i).getName().equals(pizza.getName())) {
				this.listOfPizzas.remove(i);
				return;
			}
		}
	}
	
	public void makePizzas(int numberOfMadePizzas, Pizza pizza) {
		for (int i = 0; i < numberOfMadePizzas; i++) {
			addPizzaToList(pizza);
		}
		System.out.println("\t\t\tNapravljene su " + numberOfMadePizzas + " " +  pizza.getName() + " i novo stanje je " + getNumberOfPizzasByType(pizza));
	}

	public void sellPizza(int numberOfSoldPizzas, Pizza pizza) {
		if (getNumberOfPizzasByType(pizza) < numberOfSoldPizzas) {
			System.out.println("Nema dovoljno " + pizza.getName() + " za prodaju (" + getNumberOfPizzasByType(pizza) + " na stanju)");
			return;
		} else {
			for (int i = 0; i < numberOfSoldPizzas; i++) {
				removePizzaFromList(pizza);
			}
		}
		System.out.println("\t\t\tProdali ste " + numberOfSoldPizzas + " " + pizza.getName() + " i novo stanje je " + getNumberOfPizzasByType(pizza));
	}
	
	public int getNumberOfPizzasByType(Pizza pizza) {
		int numberOfPizzasByType = 0;
		
		for (int i = 0; i < this.listOfPizzas.size(); i++) {
			if(pizza.getName().equals(listOfPizzas.get(i).getName())) {
				numberOfPizzasByType++;
			}
		}
		
		return numberOfPizzasByType;
	}
	
}
