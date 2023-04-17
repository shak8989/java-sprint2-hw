import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class YearlyReport {
    ArrayList<YearlyReportItem> items = new ArrayList<>();
    int month;// месяц номери
    double sum; //сумма
    boolean isExpense;//false - доход, true - расход//

    public YearlyReport(String path) {

        List<String> content = readFileContents(path);//
        //реобразование из array в обьект класса год или меяц
        for (int i = 1; i < content.size(); i++) {
            String line = content.get(i); //достоем нужную строч
            String[] lineContents = line.split(",");//разбеваем её методом сплит по запятым
            int month = Integer.parseInt(lineContents[0]);// месяц номери
            double sum = Double.parseDouble(lineContents[1]); //сумма
            boolean isExpense = Boolean.parseBoolean(lineContents[2]);//"false"--false настоящий


            YearlyReportItem yearlyReportItem = new YearlyReportItem(month, sum, isExpense);//в итоге на каждой строке у нас будет созвобаться обект sale и мы его будем складировать в список
            items.add(yearlyReportItem);
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


    public double getExpenseMount(int mountNumber) { //расходы по заданному номеру месяца number вернет сумму расходов за этот месяц
        for (YearlyReportItem item : items) {
            if (item.month == mountNumber && item.isExpense) {
                return item.amount;
            }
        }
        return 0;
    }

    public double getIncomeMount(int mountNumber) {// доходы по заданному месяцу
        for (YearlyReportItem item : items) {
            if (item.month == mountNumber && item.isExpense) {
                return item.amount;
            }
        }
        return 0;
    }

    public double averageExpenses() {
        int expenses = 0; // средний расход
        for (YearlyReportItem item : items) {
            if (item.isExpense) {
                expenses += item.amount;

            }
        }
        expenses = expenses / 30;
        return expenses;
    }

    public double averageIncomes() {
        int income = 0; // средний доход
        for (YearlyReportItem item : items) {
            if (item.isExpense) {
                income += item.amount;

            }
        }
        income = income / 30;
        return income;
    }

    public double getProfitForMonth(int mount) {
        for (YearlyReportItem item : items) {
            if (item.isExpense) {
                if (item.month) {
                } else {
                    return item.amount;

                }

            }
        }
        return 0;
    }
}
