/* Expense Calculator by Irtaza Rizvi*/

import java.util.*;
import java.io.*;

public class Expenses {

	public static void main(String[] args) throws IOException {

		// Get data input
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter expenses: ");
		String[] expenses = keyboard.nextLine().replaceAll(" ", "").split("-");

		// Check for valid input
		if (expenses.length != 0 && (expenses.length % 2) == 0) {
			// Loop for each month
			for (int k = 0; k < expenses.length; k = k + 2) {
				// Reset variables
				double totalexpenses = 0, food = 0, home = 0, print = 0, film = 0, bus = 0, metro = 0, uber = 0;
				int cursor1 = 0, cursor2 = 0, cursor3 = 0, i = 0;
				boolean end = false;
				ArrayList<String> other = new ArrayList<String>();

				// Check again for valid input
				if (expenses[k].matches("[a-zA-Z]*")
						&& expenses[k + 1].matches("[0-9][a-z0-9.]*[a-z]")
						&& !(expenses[k + 1].contains("..")
								|| expenses[k + 1].matches(".*[.][a-f].*") || expenses[k + 1]
								.matches(".*[a-f][.].*"))) {
					// Make new file
					PrintStream writer = new PrintStream(expenses[k] + ".txt");
					writer.println("Expenses for " + expenses[k]);
					writer.println("----------------------");

					// Parse input data to seperate each expense item
					while (!end) {
						cursor1 = i;
						while (expenses[k + 1].charAt(i) < 'a'
								|| expenses[k + 1].charAt(i) > 'z') {
							i++;
						}
						cursor2 = i;
						while ((expenses[k + 1].charAt(i) >= 'a' && expenses[k + 1]
								.charAt(i) <= 'z')
								&& i < expenses[k + 1].length() - 1) {
							i++;
						}
						i--;
						cursor3 = i;
						i++;
						if (i == expenses[k + 1].length() - 1) {
							end = true;
							cursor3++;
						}
						String amount = expenses[k + 1].substring(cursor1,
								cursor2);
						String item = expenses[k + 1].substring(cursor2,
								cursor3 + 1);
						double d = Double.parseDouble(amount);
						if (item.endsWith("x")) {
							other.add(amount + " "
									+ item.substring(0, item.length() - 1));
						} else if (item.equals("food") || item.equals("f")) {
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
						} else if (item.equals("uber")) {
							uber = uber + d;
						} else {
							totalexpenses = totalexpenses + d;
							writer.println(amount + " " + item);
						}
					}

					// Calculate total and output data in new file
					totalexpenses = totalexpenses + food + home + print + film
							+ bus + metro + uber;
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
					if (uber > 0) {
						writer.println(uber + " uber");
					}

					writer.println("_____________");
					writer.println("TOTAL: " + totalexpenses);

					if (!other.isEmpty()) {
						writer.println("");
						writer.println("Other:-");
						for (int j = 0; j < other.size(); j++) {
							writer.println(other.get(j));
						}
					}

					writer.close();
					System.out.println("Expenses for " + expenses[k]
							+ " calculated successfully!");
				}

				else {
					System.out.println("Error! Check input formatting for "
							+ expenses[k] + " expenses and try again.");
				}
			}
		}

		else {
			System.out.println("Error! Check input formatting and try again.");
		}
	}
}
