public class ConsoleExpenseViewer implements ExpenseViewer {

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
                    i + 1, e.getDate(), e.getCategory(),
                    e.getDescription(), e.getAmount());
        }
        System.out.println();
    }
}
