import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Expenses[] expenseList = new Expenses[50];
        int count = 0;
        int choice;

        do {
            System.out.println("\n");
            System.out.println("=====================================");
            System.out.println("     PERSONAL EXPENSES TRACKER");
            System.out.println("=====================================");
            System.out.println("1. Add Expenses");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Expenses");
            System.out.println("4. Filter By Category");
            System.out.println("5. Exit Program.");
            System.out.println("-------------------------------------");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        count = AddExpense.addExpenses(scanner, expenseList, count);
                        break;

                    case 2:
                        ExpenseViewer viewer = new ConsoleExpenseViewer();
                        viewer.view(expenseList, count);
                        break;

                    case 3:
                        System.out.println("Total Expenses not implemented yet.");
                        break;

                    case 4:
                        System.out.println("Filter By Category not implemented yet.");
                        break;

                    case 5:
                        System.out.println("Exiting program.");
                        break;

                    default:
                        System.out.println("Invalid input. Choose 1–5 options only.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = 0;
            }

        } while (choice != 5);

        scanner.close();
    }
}
