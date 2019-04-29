package io.github.ljubisanesic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Pizzeria {

	private Connection connect;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;

	public Pizzeria() throws Exception {

		Properties properties = new Properties();
		properties.load(new FileInputStream("demo.properties"));

		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String dburl = properties.getProperty("dburl");
		String timeZone = properties.getProperty("timeZoneSetings");
		String url = dburl + timeZone;
		this.connect = DriverManager.getConnection(url, user, password);
		connect.createStatement();
		System.out.println("Baza podataka uspjesno povezana sa: " + dburl);
	}

	public void showAllPizzas() throws Exception {

		preparedStatement = connect.prepareStatement("SELECT pizza_id, pizza_name, size FROM sur_pikado.pizza");

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.printf("%3d. %-13svelicina %-6s\n", resultSet.getInt("pizza_id"),
					resultSet.getString("pizza_name"), resultSet.getString("size"));
		}
	}

	public void showAllPizzasOnStock() throws Exception {

		preparedStatement = connect.prepareStatement("SELECT * FROM sur_pikado.pizza WHERE stock > ?");
		preparedStatement.setInt(1, 0);

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.printf("%3d. %-13svelicina %-6s na stanju %2d\n", resultSet.getInt("pizza_id"),
					resultSet.getString("pizza_name"), resultSet.getString("size"), resultSet.getInt("stock"));
		}

	}

	public void makePizzas(int numberOfMadePizzas, int pizzaID) throws Exception {

		int newStock = getNumberOfPizzasByID(pizzaID) + numberOfMadePizzas;

		preparedStatement = connect.prepareStatement("UPDATE sur_pikado.pizza SET stock =? WHERE pizza_id =?");
		preparedStatement.setInt(1, newStock);
		preparedStatement.setInt(2, pizzaID);

		preparedStatement.executeUpdate();

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

			preparedStatement = connect.prepareStatement("UPDATE sur_pikado.pizza SET stock =? WHERE pizza_id =? ");
			preparedStatement.setInt(1, newStock);
			preparedStatement.setInt(2, pizzaID);

			preparedStatement.executeUpdate();
		}

		System.out.println("\t\t\tProdali ste " + numberOfSoldPizzas + " " + getPizzaNameByIndex(pizzaID)
				+ " i novo stanje je " + getNumberOfPizzasByID(pizzaID));
	}

	public String getPizzaNameByIndex(int pizzaID) throws Exception {

		String pizzaName = "";

		preparedStatement = connect.prepareStatement("SELECT pizza_name FROM sur_pikado.pizza WHERE pizza_id=?");
		preparedStatement.setInt(1, pizzaID);

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			pizzaName = resultSet.getString("pizza_name");
		}

		return pizzaName;
	}

	public String getPizzaSizeByIndex(int pizzaID) throws Exception {

		String size = "";

		preparedStatement = connect.prepareStatement("SELECT size FROM sur_pikado.pizza WHERE pizza_id=?");
		preparedStatement.setInt(1, pizzaID);

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			size = resultSet.getString("size");
		}

		return size;
	}

	public int getNumberOfPizzasByID(int pizzaID) throws Exception {

		int numberOfPizzasByType = 0;

		preparedStatement = connect.prepareStatement("SELECT stock FROM sur_pikado.pizza WHERE pizza_id=?");
		preparedStatement.setInt(1, pizzaID);

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			numberOfPizzasByType = resultSet.getInt("stock");
		}

		return numberOfPizzasByType;
	}

	public int getNumberOfAllPizzas() throws Exception {

		int numberOfPizzas = 0;

		preparedStatement = connect.prepareStatement("select count(*) from pizza");

		resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			numberOfPizzas = resultSet.getInt(1);
		}

		return numberOfPizzas;
	}
	
	public void close() {
		try {
			if(connect != null) {
				connect.close();
			}
			
			if (resultSet != null) {
				resultSet.close();
			}
			
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			
		} catch (Exception e) {
		}
		
	}

}
