/* Expense Calculator by Irtaza Rizvi*/

import java.util.*;
import java.io.*;

public class Expenses {

	public static void main(String[] args) throws IOException {

		// Declare variables
		double totalexpenses = 0, food = 0, home = 0, print = 0, film = 0, bus = 0, metro = 0;
		int cursor1 = 0, cursor2 = 0, cursor3 = 0, i = 0;
		boolean end = false;

		// Get data input
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter month: ");
		String month = keyboard.nextLine();
		PrintStream writer = new PrintStream(month + ".txt");
		System.out.print("Enter expenses: ");
		String expenses = keyboard.nextLine().replaceAll(" ", "");
		writer.println("Expenses for " + month + ":-");

		// Parse input data to seperate each expense item
		while (!end) {
			cursor1 = i;
			while (expenses.charAt(i) < 'a' || expenses.charAt(i) > 'z') {
				i++;
			}
			cursor2 = i;
			while ((expenses.charAt(i) >= 'a' && expenses.charAt(i) <= 'z')
					&& i < expenses.length() - 1) {
				i++;
			}
			i--;
			cursor3 = i;
			i++;
			if (i == expenses.length() - 1) {
				end = true;
				cursor3++;
			}
			String amount = expenses.substring(cursor1, cursor2);
			String item = expenses.substring(cursor2, cursor3 + 1);
			double d = Double.parseDouble(amount);
			if (item.equals("food") || item.equals("f")) {
				food = food + d;
			} else if (item.equals("home")) {
				home = home + d;
			} else if (item.equals("print")) {
				print = print + d;
			} else if (item.equals("film")) {
				film = film + d;
			} else if (item.equals("bus")) {
				bus = bus + d;
			} else if (item.equals("metro")) {
				metro = metro + d;
			} else {
				totalexpenses = totalexpenses + d;
				writer.println(amount + " " + item);
			}
		}

		// Calculate total and output data in new file
		totalexpenses = totalexpenses + food + home + print + film + bus
				+ metro;
		if (food > 0) {
			writer.println(food + " food");
		}
		if (home > 0) {
			writer.println(home + " home");
		}
		if (print > 0) {
			writer.println(print + " print");
		}
		if (film > 0) {
			writer.println(film + " film");
		}
		if (bus > 0) {
			writer.println(bus + " bus");
		}
		if (metro > 0) {
			writer.println(metro + " metro");
		}
		writer.println("TOTAL: " + totalexpenses);
		writer.close();
	}
}
