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
	
	private void zaduziPicu() {
		Pizza pizza = new Pizza();
		this.listOfPizzas.add(pizza);
	}
	
	private void razduziPicu() {
		this.listOfPizzas.remove(listOfPizzas.size() - 1);
	}
	
	public void napraviPicu(int brojNapravljenihPica) {
		for (int i = 0; i < brojNapravljenihPica; i++) {
			zaduziPicu();
		}
		System.out.println("\t\t\tNapravljene su " + brojNapravljenihPica + " pica/e i novo stanje je " + getState());
	}

	public void prodajPicu(int brojProdatihPica) {
		if (getState() < brojProdatihPica) {
			System.out.println("Nema dovoljno pica za prodaju (" + getState() + " na stanju)");
			return;
		} else {
			for (int i = 0; i < brojProdatihPica; i++) {
				razduziPicu();
			}
		}
		System.out.println("\t\t\tProdali ste " + brojProdatihPica + " picu/e i novo stanje je " + getState());
	}
}
