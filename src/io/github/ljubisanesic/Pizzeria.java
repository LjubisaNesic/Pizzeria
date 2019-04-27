package io.github.ljubisanesic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Pizzeria {

	private Connection connect;
	private Statement statement;
	private ResultSet resultSet;
	
	public Pizzeria() throws Exception {

		Properties properties = new Properties();
		properties.load(new FileInputStream("demo.properties"));

		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String dburl = properties.getProperty("dburl");
		String timeZone = properties.getProperty("timeZoneSetings");
		String url = dburl + timeZone;
		this.connect = DriverManager.getConnection(url, user, password);
		this.statement = connect.createStatement();
		System.out.println("Baza podataka uspjesno povezana sa: " + dburl);
	}

	public void showAllPizzas() throws Exception {
		resultSet = statement.executeQuery("SELECT pizza_id, pizza_name, size FROM sur_pikado.pizza");

		while (resultSet.next()) {
			System.out.printf("%3d. %-13svelicina %-6s\n", resultSet.getInt("pizza_id"),
					resultSet.getString("pizza_name"), resultSet.getString("size"));
		}
	}

	public void showAllPizzasOnStock() throws Exception {
		resultSet = statement.executeQuery("SELECT * FROM sur_pikado.pizza WHERE stock > 0");

		while (resultSet.next()) {
			System.out.printf("%3d. %-13svelicina %-6s na stanju %2d\n", resultSet.getInt("pizza_id"),
					resultSet.getString("pizza_name"), resultSet.getString("size"), resultSet.getInt("stock"));
		}

	}

	public void makePizzas(int numberOfMadePizzas, int pizzaID) throws Exception {
		int newStock = getNumberOfPizzasByID(pizzaID) + numberOfMadePizzas;

		String sql = "UPDATE sur_pikado.pizza SET stock = " + newStock + " WHERE pizza_id = " + pizzaID;
		statement.executeUpdate(sql);

		System.out.println("\t\t\tNapravljene su " + numberOfMadePizzas + " " + getPizzaNameByIndex(pizzaID)
				+ " i novo stanje je " + getNumberOfPizzasByID(pizzaID));
	}

	public void sellPizza(int numberOfSoldPizzas, int pizzaID) throws Exception {
		if (getNumberOfPizzasByID(pizzaID) < numberOfSoldPizzas) {
			System.out.println("Nema dovoljno " + getPizzaNameByIndex(pizzaID) + " za prodaju ("
					+ getNumberOfPizzasByID(pizzaID) + " na stanju)");
			return;
		} else {
			int newStock = getNumberOfPizzasByID(pizzaID) - numberOfSoldPizzas;
			String sql = "UPDATE sur_pikado.pizza SET stock = " + newStock + " WHERE pizza_id = " + pizzaID;
			statement.executeUpdate(sql);

		}
		System.out.println("\t\t\tProdali ste " + numberOfSoldPizzas + " " + getPizzaNameByIndex(pizzaID)
				+ " i novo stanje je " + getNumberOfPizzasByID(pizzaID));
	}

	public String getPizzaNameByIndex(int pizzaID) throws Exception {
		String pizzaName = "";
		
		String sql = "SELECT pizza_name FROM sur_pikado.pizza WHERE pizza_id= " + pizzaID;
		resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			pizzaName = resultSet.getString("pizza_name");
		}
		return pizzaName;

	}
	
	public String getPizzaSizeByIndex(int pizzaID) throws Exception {
		String size = "";
		
		String sql = "SELECT size FROM sur_pikado.pizza WHERE pizza_id = " + pizzaID;
		resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			size = resultSet.getString("size");
		}
		return size;

	}

	public int getNumberOfPizzasByID(int pizzaID) throws Exception {
		int numberOfPizzasByType = 0;
		
		String sql = "SELECT stock FROM sur_pikado.pizza WHERE pizza_id= " + pizzaID;
		resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			numberOfPizzasByType = resultSet.getInt("stock");
		}

		return numberOfPizzasByType;
	}

	public int getNumberOfAllPizzas() throws Exception {
		int numberOfPizzas = 0;

		resultSet = statement.executeQuery("select count(*) from pizza");
		while (resultSet.next()) {
			numberOfPizzas = resultSet.getInt(1);
		}

		return numberOfPizzas;

	}

}
