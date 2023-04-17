public class Checker {

    public YearlyReport yearlyReport;
    public MonthlyReport monthlyReport;

    public Checker(YearlyReport yearlyReport, MonthlyReport monthlyReport) {// конструктор
        this.yearlyReport = yearlyReport;
        this.monthlyReport = monthlyReport;
    }

    public boolean check(int mountNumber) {
        for (int i = 1; i < 4; i++) {
            if ((yearlyReport.getExpenseMount(mountNumber i)) == monthlyReport.getExpensesSum(mountNumber i)) {
                return true;
            }else {
                System.out.println("Найдена ошибка");
                return false;
            } if ((yearlyReport.getIncomeMount(mountNumber i)) == monthlyReport.getIncomeSum(mountNumber i)) {
                return true;
            }else{
                System.out.println("Найдена ошибка");
                return false;
            }
        }
         return false;
    }
}