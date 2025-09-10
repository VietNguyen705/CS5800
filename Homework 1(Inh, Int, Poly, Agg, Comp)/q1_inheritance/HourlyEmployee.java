public class HourlyEmployee extends Employee {
    private double hourlyWage;
    private double hoursWorked;

    public HourlyEmployee(String firstName, String lastName, String ssn, double hourlyWage, double hoursWorked) {
        super(firstName, lastName, ssn);
        setHourlyWage(hourlyWage);
        setHoursWorked(hoursWorked);
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
