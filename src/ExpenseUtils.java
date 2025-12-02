public class ExpenseUtils {

    public static double totalExpenses(Expenses[] list, int count) {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            if (list[i] != null) {
                total += list[i].getAmount();
            }
        }
        return total;
    }

    public static Expenses[] filterByCategory(Expenses[] list, int count, String category) {
        if (category == null) return new Expenses[0];
        Expenses[] temp = new Expenses[count];
        int idx = 0;
        for (int i = 0; i < count; i++) {
            Expenses e = list[i];
            if (e == null) continue;
            String cat = e.getCategory();
            if (cat != null && cat.equalsIgnoreCase(category)) {
                temp[idx++] = e;
            }
        }
        Expenses[] result = new Expenses[idx];
        System.arraycopy(temp, 0, result, 0, idx);
        return result;
    }
}
