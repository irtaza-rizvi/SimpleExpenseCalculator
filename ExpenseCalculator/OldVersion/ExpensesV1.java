/* Expense Calculator by Irtaza Rizvi*/

import java.util.*;
import java.io.*;

public class Expenses {

	public static void main(String[] args) throws IOException {

		// Declare variables
		double food = 0;
		double totalExpense = 0;
		boolean end = false;

		// Get data input
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter month: ");
		String path = keyboard.nextLine();
		PrintStream writer = new PrintStream(path + ".txt");
		System.out.print("Enter expense: ");
		String expense = keyboard.nextLine();
		if (expense.equals("")) {
			end = true;
		}

		// Parse input data to seperate amount and item name for each expense
		while (!end) {
			if (expense.charAt(expense.length() - 1) == 'f') {
				String amount = expense.substring(0, expense.length() - 1);
				double d = Double.parseDouble(amount);
				food = food + d;
			} else {
				writer.println(expense);
				int i = 1;
				while (expense.charAt(expense.length() - i) != '0'
						&& expense.charAt(expense.length() - i) != '1'
						&& expense.charAt(expense.length() - i) != '2'
						&& expense.charAt(expense.length() - i) != '3'
						&& expense.charAt(expense.length() - i) != '4'
						&& expense.charAt(expense.length() - i) != '5'
						&& expense.charAt(expense.length() - i) != '6'
						&& expense.charAt(expense.length() - i) != '7'
						&& expense.charAt(expense.length() - i) != '8'
						&& expense.charAt(expense.length() - i) != '9') {
					i++;
				}
				i--;
				String amount = expense.substring(0, expense.length() - i);
				double d = Double.parseDouble(amount);
				totalExpense = totalExpense + d;
			}
			System.out.print("Enter expense: ");
			expense = keyboard.nextLine();
			if (expense.equals("")) {
				end = true;
			}
		}

		// Calculate total and output data in new file
		totalExpense = totalExpense + food;
		writer.println(food + "food");
		writer.println("TOTAL: " + totalExpense);
		writer.close();
	}
}
