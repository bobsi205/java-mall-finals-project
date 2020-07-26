package menu;

import java.util.Scanner;

public abstract class Menu {

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
