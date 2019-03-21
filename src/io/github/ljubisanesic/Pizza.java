package io.github.ljubisanesic;

public class Pizza {

	private String name;
	private double price;
	private String sizeOfPizza;

	public Pizza() {

	}

	public Pizza(String name, double price, String sizeOfPizza) {
		this.name = name;
		this.price = price;
		this.sizeOfPizza = sizeOfPizza;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSizeOfPizza() {
		return sizeOfPizza;
	}

	public void setSizeOfPizza(String sizeOfPizza) {
		this.sizeOfPizza = sizeOfPizza;
	}


}
