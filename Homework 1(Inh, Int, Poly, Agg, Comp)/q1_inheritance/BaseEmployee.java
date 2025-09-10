public class BaseEmployee extends Employee {
    private double baseSalary;

    public BaseEmployee(String firstName, String lastName, String ssn, double baseSalary) {
        super(firstName, lastName, ssn);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}
