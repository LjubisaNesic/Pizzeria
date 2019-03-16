package io.github.ljubisanesic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestPicerija {

	public static void main(String[] args) {

	
		Pizzeria pizzeria = new Pizzeria();
		pizzeria.napraviPicu(3);
		pizzeria.prodajPicu(2);

		Scanner input = new Scanner(System.in);

		int choice = -1;

		while (choice != 3) {
			try {
				System.out.println("1. Prodaja " + "\n2. Stanje " + "\n3. Zatvori program ");
				choice = input.nextInt();

				if (choice == 1) {
					System.out.println("\t1. Napravi jelo " + "\n\t2. Prodaj " + "\n\t3. Nazad");
					choice = input.nextInt();
					
					if (choice == 1) {
						System.out.println("\t\t1. Pica " + "\n\t\t2. Nazad ");
						choice = input.nextInt();
						
						if (choice == 1) {
							System.out.print("\t\t\tKoliko pica zelite da se napravi (" + pizzeria.getState() + " na stanju): ");
							int brojNapravljenihPica = input.nextInt();
							pizzeria.napraviPicu(brojNapravljenihPica);
						} else if (choice == 2) {
							continue;
						} else {
							System.out.print("Pogresan izbor, izaberite ponovo: ");
							choice = input.nextInt();
						}
						
					} else if (choice == 2) {
						System.out.println("\t\t1. Pica " + "\n\t\t2. Nazad ");
						choice = input.nextInt();
						
						if (choice == 1) {
							System.out.print("\t\t\tKoliko pica zelite da prodate (" + pizzeria.getState() + " na stanju): ");
							int brojProdatihPica = input.nextInt();
							pizzeria.prodajPicu(brojProdatihPica);
						} else if (choice == 2) {
							continue;
						} else {
							System.out.print("Pogresan izbor, izaberite ponovo: ");
							choice = input.nextInt();
						}
					} else if (choice == 3) {
						continue;
					} else {
						System.out.print("Pogresan izbor, izaberite ponovo: ");
						choice = input.nextInt();
					}
					
				} else if (choice == 2) {
					stanje(pizzeria);
				} else if (choice == 3) {
					continue;
				} else {
					System.out.println("Unijeli ste pogresan izbor, unesite novi: ");
					choice = input.nextInt();
				}

			} catch (InputMismatchException e) {
				System.out.println("Pogresan unos, unesite ponovo: ");
				input.nextLine();
			}

		}

		input.close();
		System.out.println("Kraj programa!");
		System.exit(0);
	}

	public static void stanje(Pizzeria pizzeria) {
		System.out.println("\tNa stanju " + pizzeria.getState() + " pice/a");
	}
}
