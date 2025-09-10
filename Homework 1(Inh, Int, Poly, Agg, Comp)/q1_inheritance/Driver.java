import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        // Salaried employees
        employees.add(new SalariedEmployee("Joe", "Jones", "111-11-1111", 2500.00));
        employees.add(new SalariedEmployee("Renwa", "Chanel", "555-55-5555", 1700.00));

        // Hourly employees
        employees.add(new HourlyEmployee("Stephanie", "Smith", "222-22-2222", 25.00, 32.0));
        employees.add(new HourlyEmployee("Mary", "Quinn", "333-33-3333", 19.00, 47.0));

        // Commission employees
        employees.add(new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000.00));
        employees.add(new CommissionEmployee("Mahnaz", "Vaziri", "777-77-7777", 0.22, 40000.00));

        // Base-salary-only employee
        employees.add(new BaseEmployee("Mike", "Davenport", "666-66-6666", 95000.00));

    }
}

