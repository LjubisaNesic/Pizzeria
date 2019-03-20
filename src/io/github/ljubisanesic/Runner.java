package io.github.ljubisanesic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		Pizzeria pizzeria = new Pizzeria();

		Scanner input = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("1. Prodaja " + "\n2. Stanje " + "\n3. Zatvori program ");
				int choice = input.nextInt();

				switch (choice) {
				case 1: 
					showSellingMenu(pizzeria);
					break;
				case 2:
					showOnStock(pizzeria);
					break;
				case 3:
					input.close();
					System.out.println("Kraj programa!");
					System.exit(0);
				default : 
						System.out.println("Pogresan unos pokusajte ponovo: ");
				}

			} catch (InputMismatchException e) {
				System.out.println("Unijeli ste pogresan karakter pokusajte ponovo: ");
				input.nextLine();
			}

		}

	}

	/** Method for making and selling of articles */
	private static void showSellingMenu(Pizzeria pizzeria) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("\t1. Napravi jelo " + "\n\t2. Prodaj " + "\n\t3. Nazad");
			int choice = input.nextInt();

			switch (choice) {
			case 1:
				makeAMeal(pizzeria);
				break;
			case 2:
				sellAMeal(pizzeria);
				break;
			case 3:
				return;
			default:
				System.out.println("Pogresan unos , pokusajte ponovo:");
				break;
			}
		}

	}

	private static void makeAMeal(Pizzeria pizzeria) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("\t\t1. Pica " + "\n\t\t2. Nazad ");
			int choice = input.nextInt();

			switch (choice) {
			case 1:
				System.out.print("\t\t\tKoliko pica zelite da se napravi (" + pizzeria.getSize() + " na stanju): ");
				int numberOfMadePizzas = input.nextInt();
				pizzeria.makePizzas(numberOfMadePizzas);
				break;
			case 2:
				return;
			default:
				System.out.println("Pogresan unos , pokusajte ponovo:");
				break;
			}
		}

	}

	private static void sellAMeal(Pizzeria pizzeria) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("\t\t1. Pica " + "\n\t\t2. Nazad ");
			int choice = input.nextInt();

			switch (choice) {
			case 1:
				System.out.print("\t\t\tKoliko pica zelite da prodate (" + pizzeria.getSize() + " na stanju): ");
				int numberOfSoldPizzas = input.nextInt();
				pizzeria.sellPizza(numberOfSoldPizzas);
				break;
			case 2:
				return;
			default:
				System.out.println("Pogresan unos , pokusajte ponovo:");
				break;
			}
		}

	}

	private static void showOnStock(Pizzeria pizzeria) {
		System.out.println("\tNa stanju " + pizzeria.getSize() + " pice/a");
	}
}
