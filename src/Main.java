import java.util.Scanner;

class Expenses { // nagdeclare ako ng 4 variables na naka private since dapat may encapsulation sa program na ito, tsaka para di din sya magamit outside the class, 
    private String date;  // maaacess mo lang sya through constructor
    private String category;
    private String description;
    private double amount;

    public Expenses(String date, String category, String description, double amount){//Constructor, its role is to make, or make more expenses object like date, category, description, and amount
    this.date = date;                                                                //(para sya din yung nagbibigay ng access sa mga variables inside the class expenses at para magamit din ng )
    this.category = category;                                                        // add expenses method)
    this.description = description;
    this.amount = amount;
 }
    public String getDate() { 
          return date; 
    }
    public String getCategory() {
          return category; 
    }
    public String getDescription() {
         return description; 
    }
    public double getAmount() {
         return amount;
     }
}

class Foodexpense extends Expenses{// nag-gawa me ng 3 subclasses which is yung common expenses naman gaya ng food, transport and bills
    public Foodexpense(String date, String description, double amount){// na inherit nya yung properties or variables ng parent class, divided 
        super(date, "Food", description, amount);// sya sa tatlo na parang ang pinaka unique identifier nya is yung category, halimbawa
    }// gumawa ako ng object tapos ang nilagay kong category ay food so yung object na yun ay mapapapunta sa food expenses class, so on  and so on.
}

class Transportexpense extends Expenses{
    public Transportexpense(String date, String description, double amount){
        super(date, "Tranport", description, amount);
    }
}

class Billsexpense extends Expenses{
    public Billsexpense (String date, String description, double amount){
        super(date, "Bills", description, amount);
    }
}
class Addexpense{
    public static int addexpenses(Scanner scanner, Expenses[] expenseList, int count){
    if (count>=expenseList.length){
        System.out.println("cannot add more.");
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
     
    try{
        amount =Double.parseDouble(scanner.nextLine());
    }catch (NumberFormatException e){
        System.out.println("Invalid input. Please try again.");
        return count;
    }
    System.out.println("----------------------------");

     if (category.equalsIgnoreCase("Food")) {
            expenseList[count] = new Foodexpense(date, description, amount);
        } else if (category.equalsIgnoreCase("Transport")) {
            expenseList[count] = new Transportexpense(date, description, amount);
        } else if (category.equalsIgnoreCase("Bills")) {
            expenseList[count] = new Billsexpense(date, description, amount);
        } else {
            expenseList[count] = new Expenses(date, category, description, amount);
        }
        count++;
        System.out.println("Saved successfully.");
        return count;
    }

}

// Abstraction
interface ExpenseViewer {
    void view(Expenses[] list, int count);
}

// Polymorphism
class ConsoleExpenseViewer implements ExpenseViewer {// ito naman ay ginawa ko nang naka-table kumbaga minodify ko lang, since yung wireframe natin ay nakatable yung view expenses
    @Override
    public void view(Expenses[] list, int count) {
        System.out.println("====================================================================");
        System.out.println("                            VIEW EXPENSES                          ");
        System.out.println("====================================================================");

        if (count == 0) {
            System.out.println("No expenses recorded yet.");
            return;
        }
        System.out.printf("%-5s | %-12s | %-10s | %-20s | %-10s\n",
                "No.", "Date", "Category", "Description", "Amount");
        System.out.println("--------------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            Expenses e = list[i];
            System.out.printf("%-5d | %-12s | %-10s | %-20s | %10.2f\n",
                    i + 1,
                    e.getDate(),
                    e.getCategory(),
                    e.getDescription(),
                    e.getAmount());
        }
        System.out.println();
    }
}

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
            System.out.println("Enter your choice: ");

     try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        count = Addexpense.addexpenses(scanner, expenseList, count);
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
                        System.out.println("Invalid input. Choose 1-5 options only.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = 0;
            }
         } while (choice != 5);
        scanner.close();
    }

    
}
