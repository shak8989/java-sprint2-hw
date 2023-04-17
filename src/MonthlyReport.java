import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MonthlyReport {//ежемесячный отчет
    public ArrayList<MonthlyReportItem> items = new ArrayList<>();
    int mountNumber;

    public void loadFile(String path) {
        List<String> content = readFileContents(path);

        for (int i = 1; i < content.size(); i++) {
            String line = content.get(i); //достоем нужную строч
            String[] lineContents = line.split(",");
            String item_name = lineContents[0];

            boolean is_expense = Boolean.parseBoolean(lineContents[1]);
            int quantity = Integer.parseInt(lineContents[2]);
            int sum_of_one = Integer.parseInt(lineContents[3]);

            MonthlyReportItem monthlyReportItem = new MonthlyReportItem(item_name, is_expense, quantity, sum_of_one);
            items.add(monthlyReportItem);

        }
    }

    static List<String> readFileContents(String path) {// дано как считывать файл
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом.Возможно не файл находитьсяв нужной директории ");
            return Collections.emptyList();
        }
    }


    public int getExpensesSum(int mountNumber) {//расходы
        int expensesSum = 0;
        for (MonthlyReportItem item : items) {
            if (item.is_expense)
                expensesSum += item.quantity * item.sum_of_one;
        }
        return expensesSum;
    }

    public int getIncomeSum(int mountNumber) { //доходы
        int incomeSum = 0;
        for (MonthlyReportItem item : items) {
            if (item.is_expense)
                incomeSum += item.quantity * item.sum_of_one;
        }
        return incomeSum;

    }


    public int getTopProduct(int mountNumber) {  // самый прибыльный товар/максимальная трата
        String itemname = "";
        int maxProfit = 0;
        HashMap<String, Integer> sum = new HashMap<>();
        for (MonthlyReportItem item : items) {//по всем товарам
            if (item.is_expense) {
                int profit = item.quantity * item.sum_of_one;
                if (profit > maxProfit) {
                    maxProfit = profit;
                    itemname = item.item_name;
                }
            }
        }
        System.out.println("Максимальный товар :" + itemname);
              return maxProfit;
    }


    public int getTopSpend(int mountNumber) {// самая бльшая трата/минимальная трата
        String nameItem = "";
        int sumSpend = 0;
        HashMap<String, Integer> sum = new HashMap<>();
        for (MonthlyReportItem item : items) {//по всем товарам
            if (item.is_expense) {
                int spend = item.quantity * item.sum_of_one;
                if (spend < sumSpend) {
                    sumSpend = spend;
                    nameItem = item.item_name;
                }
            }
        }
        System.out.println("Максимальный трата :" + nameItem);
        return sumSpend;
    }
}