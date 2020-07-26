package menu;

import java.util.Scanner;

import center.Chain;

public abstract class Menu {

	public static Chain[] addChainToArray(Chain[] chains, Chain newChain) {
		Chain[] tempChains = null;
		if (chains != null) {
			int i = 0, j = 0;
			Boolean flag = false;
			tempChains = new Chain[chains.length + 1];
			for (; i < chains.length; i++) {
				if (flag || chains[j].getName().compareToIgnoreCase(newChain.getName()) <= 0) {
					tempChains[i] = chains[j++];
				} else {
					tempChains[i] = newChain;
					flag = true;
				}
			}
			if (flag) {
				tempChains[i] = chains[j];
			} else {
				tempChains[i] = newChain;
			}
		} else {
			tempChains = new Chain[1];
			tempChains[0] = newChain;
		}
		return tempChains;
	}

	public static java.lang.Double scanDouble(String type, String name, Scanner sc) {
		double input;
		System.out.println("\nEnter " + name + " " + type + ": ");
		try {
			input = Double.parseDouble(sc.nextLine());
		} catch (Exception e) {
			return null;
		}
		return input;

	}

	public static java.lang.Integer scanInt(String type, String name, Scanner sc) {
		int input;
		System.out.println("\nEnter " + name + " " + type + ": ");
		try {
			input = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			return null;
		}
		return input;

	}

	public static java.lang.Float scanFloat(String type, String name, Scanner sc) {
		float input;
		System.out.println("\nEnter " + name + " " + type + ": ");
		try {
			input = Float.parseFloat(sc.nextLine());
		} catch (Exception e) {
			return null;
		}
		return input;

	}

	public static java.lang.Long scanLong(String type, String name, Scanner sc) {
		long input;
		System.out.println("\nEnter " + name + " " + type + ": ");
		try {
			input = Long.parseLong(sc.nextLine());
		} catch (Exception e) {
			return null;
		}
		return input;

	}

	public static String scanString(String type, String name, Scanner sc) {
		String input = "";
		System.out.println("\nEnter " + name + " " + type + ": ");
		try {
			input = sc.nextLine();
		} catch (Exception e) {
			return null;
		}
		if (input.equals(""))
			return null;
		return input;

	}

	public static void successMessage(String funcName) {

		System.out.println("\n\n\n\n\n\n\n\n\n\n" + funcName + " was seccessfull" + "\n");
	}
}
