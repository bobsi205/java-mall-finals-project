import java.util.Scanner;

import center.Chain;
import center.Mall;
import center.Store;
import center.chain_types.Book_chain;
import center.chain_types.Clothing_chain;
import center.chain_types.Fast_food_chain;
import center.chain_types.Food_chain;
import menus.Menu;
import menus.MenuOne;
import menus.MenuThree;
import menus.MenuTwo;

public class Main {

	public static void main(String[] args) {
		// program init
		Scanner sc = new Scanner(System.in);
		Integer menu = 1, choice = null;

		Mall[] malls = { new Mall(212, "Hilel"), new Mall(432, "Hasharon") };
		Chain[] chains = { new Clothing_chain("Bastro", "Moshe"), new Food_chain("Columbus", 3),
				new Fast_food_chain("George", 3, 35, 0.25f), new Book_chain("Shuper", "C++ programing is fun") };
		// mall Hilel
		Store s1 = new Store(2, "Shuper");
		Store s2 = new Store(43, "George");
		malls[0].addStore(s1);
		malls[0].addStore(s2);

		// mall Hasharon
		Store s3 = new Store(12, "Columbus");
		Store s4 = new Store(65, "Bastro");
		Store s5 = new Store(81, "George");
		malls[1].addStore(s3);
		malls[1].addStore(s4);
		malls[1].addStore(s5);

		// add stores to chains
		chains[0].addStoreToChain(s4);
		chains[1].addStoreToChain(s3);
		chains[2].addStoreToChain(s2);
		chains[2].addStoreToChain(s5);
		chains[3].addStoreToChain(s1);

		// menues

		while (menu != null) {
			if (menu == 1) {
				// menu one
				choice = Menu.scanInt("one choice", "menu", sc);
				if (choice == null) {
					System.out.println("input ERROR");
					continue;
				}

				switch (choice) {
					case 1:
						chains = MenuOne.addChain(chains, sc);
						break;
					case 2:
						MenuOne.addEmployee(chains, sc);
						break;
					case 3:
						MenuOne.removeEmployee(chains, sc);
						break;
					case 4:
						MenuOne.getSumShopping(chains, sc);
						break;
					case 5:
						MenuOne.getSumSalaries(chains, sc);
						break;
					case 6:
						MenuOne.print(chains, sc);
						break;
					case 7:
						menu = 2;
						break;
					case 8:
						menu = 3;
						break;
					case 9:
						menu = null;
						break;
					default:
						System.out.println("input ERROR");
						break;
				}

			} else if (menu == 2) {
				// menu two
				choice = Menu.scanInt("two choice", "menu", sc);
				if (choice == null) {
					System.out.println("input ERROR");
					continue;
				}

				switch (choice) {
					case 1:
						malls = MenuTwo.addCenter(malls, sc);
						break;
					case 2:
						MenuTwo.addStore(malls, chains, sc);
						break;
					case 3:
						MenuTwo.getSumShopping(malls, sc);
						break;
					case 4:
						MenuTwo.shiftStore(malls, chains, sc);
						break;
					case 5:
						MenuTwo.print(malls, sc);
						break;
					case 6:
						menu = 1;
						break;
					case 7:
						menu = 3;
						break;
					case 8:
						menu = null;
						break;
					default:
						System.out.println("input ERROR");
						break;
				}

			} else if (menu == 3) {
				// menu three
				choice = Menu.scanInt("three choice", "menu", sc);
				if (choice == null) {
					System.out.println("input ERROR");
					continue;
				}

				switch (choice) {
					case 1:
						MenuThree.getSumSalaries(chains, sc);
						break;
					case 2:
						MenuThree.getSumShopping(chains, sc);
						break;
					case 3:
						MenuThree.shopping(chains, sc);
						break;
					case 4:
						MenuThree.returningItemp(chains, sc);
						break;
					case 5:
						MenuThree.shiftEmployee(chains, sc);
						break;
					case 6:
						MenuThree.print(chains, sc);
						break;
					case 7:
						MenuThree.printEmployee(chains, sc);
						break;
					case 8:
						menu = 1;
						break;
					case 9:
						menu = 2;
						break;
					case 10:
						menu = null;
						break;
					default:
						System.out.println("input ERROR");
						break;
				}
			}

		}
	}

}
