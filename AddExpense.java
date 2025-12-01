import java.util.Scanner;

public class AddExpense {

    public static int addExpenses(Scanner scanner, Expenses[] expenseList, int count) {
        if (count >= expenseList.length) {
            System.out.println("Cannot add more.");
            return count;
        }

        System.out.println("===========================");
        System.out.println("       ADD EXPENSES        ");
        System.out.println("===========================");

        System.out.print("Date: ");
        String date = scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Amount: ");
        double amount = 0;

        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
            return count;
        }

        System.out.println("----------------------------");

        if (category.equalsIgnoreCase("Food")) {
            expenseList[count] = new FoodExpense(date, description, amount);
        } else if (category.equalsIgnoreCase("Transport")) {
            expenseList[count] = new TransportExpense(date, description, amount);
        } else if (category.equalsIgnoreCase("Bills")) {
            expenseList[count] = new BillsExpense(date, description, amount);
        } else {
            expenseList[count] = new Expenses(date, category, description, amount);
        }

        System.out.println("Saved successfully.");
        return count + 1;
    }
}

