public class MonthlyReportItem {

        public String item_name;//название товара
        public boolean is_expense;//TRUE или FALSE. Обозначает, является ли запись тратой (TRUE) или доходом (FALSE)     int quantity;//оличество закупленного или проданного товара
        public  int sum_of_one;//стоимость одной единицы товара.
        public int quantity;

        public MonthlyReportItem (String item_name, boolean is_expense, int sum_of_one, int quantity) {
            this.item_name = item_name;
            this.is_expense = is_expense;
            this.sum_of_one = sum_of_one;
            this.quantity = quantity;
        }
}
