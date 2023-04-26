import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {

public static void main(String[] args) {


    while (true) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        int mountNumber = scanner.nextInt();

        if (userInput == 1) { //Считать все месячные отчёты
            MonthlyReport monthlyReport = new MonthlyReport();//путь месяца
            monthlyReport.loadFile("resorce/m.202101.csv");
            monthlyReport.loadFile("resorce/m.202102.csv");
            monthlyReport.loadFile("resorce/m.202103.csv");
            if (monthlyReport == null) {
                System.out.println("Месячные отчеты не считаны");
            }
        } else if (userInput == 2) {//Считать годовой отчёт
            YearlyReport yearlyReport = new YearlyReport("resorce/y.2021.csv");//пут года
            if (yearlyReport == null) {
                System.out.println(" Годовой отчет не считан");
            }
        } else if (userInput == 3) {//Сверить отчёты
            Checker checker = new Checker(YearlyReport, MonthlyReport);//завел чекер
            boolean answer = checker.check(mountNumber);//проверить
            System.out.println("Результат проверки " + answer);

        } else if (userInput == 4) {//Вывести информацию о всех месячных отчётах
            MonthlyReport.getTopProduct();
            MonthlyReport.getTopSpend();

        } else if (userInput == 5) {//Вывести информацию о годовом отчёте
            YearlyReport yearlyReport = new YearlyReport("resorce/y.2021.csv");
            for (YearlyReportItem item : yearlyReport.items) {
                System.out.println(item.month + "" + item.amount + "" + item.isExpense);

            }
            if (userInput == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }
}
         private static void  printMenu(){
            System.out.println("Что вы хотите сделать?");
            System.out.println("1. Считать все месячные отчёты");
            System.out.println("2. Считать годовой отчёт");
            System.out.println("3. Сверить отчёты");
            System.out.println("4. Вывести информацию о всех месячных отчётах");
            System.out.println("5. Вывести информацию о годовом отчёте");
            System.out.println("0. Выход");
        }
      }



