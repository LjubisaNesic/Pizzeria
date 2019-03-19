package io.github.ljubisanesic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestPicerija {

	public static void main(String[] args) {

		Pizzeria pizzeria = new Pizzeria();
		pizzeria.makePizzas(3);
		pizzeria.sellPizza(2);

		Scanner input = new Scanner(System.in);
		int choice = -1;

		while (choice != 3) {
			try {
				System.out.println("1. Prodaja " + "\n2. Stanje " + "\n3. Zatvori program ");
				choice = input.nextInt();

				switch (choice) {
				case 1: 
					selling(pizzeria);
					break;
				case 2:
					state(pizzeria);
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
	public static void selling(Pizzeria pizzeria) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice = -1;

		while (choice != 3) {
			System.out.println("\t1. Napravi jelo " + "\n\t2. Prodaj " + "\n\t3. Nazad");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				makeAMeal(pizzeria);
				break;
			case 2:
				sellAMeal(pizzeria);
				break;
			case 3:
				break;
			default:
				System.out.println("Pogresan unos , pokusajte ponovo:");
				break;
			}
		}

	}

	private static void makeAMeal(Pizzeria pizzeria) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice = -1;

		while (choice != 2) {
			System.out.println("\t\t1. Pica " + "\n\t\t2. Nazad ");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				System.out.print("\t\t\tKoliko pica zelite da se napravi (" + pizzeria.getState() + " na stanju): ");
				int numberOfMadePizzas = input.nextInt();
				pizzeria.makePizzas(numberOfMadePizzas);
				break;
			case 2:
				break;
			default:
				System.out.println("Pogresan unos , pokusajte ponovo:");
				break;
			}
		}

	}

	private static void sellAMeal(Pizzeria pizzeria) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice = -1;

		while (choice != 2) {
			System.out.println("\t\t1. Pica " + "\n\t\t2. Nazad ");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				System.out.print("\t\t\tKoliko pica zelite da prodate (" + pizzeria.getState() + " na stanju): ");
				int numberOfSoldPizzas = input.nextInt();
				pizzeria.sellPizza(numberOfSoldPizzas);
				break;
			case 2:
				break;
			default:
				System.out.println("Pogresan unos , pokusajte ponovo:");
				break;
			}
		}

	}

	public static void state(Pizzeria pizzeria) {
		System.out.println("\tNa stanju " + pizzeria.getState() + " pice/a");
	}
}
