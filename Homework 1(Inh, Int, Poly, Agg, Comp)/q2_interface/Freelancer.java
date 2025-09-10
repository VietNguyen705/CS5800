public class Freelancer implements Payable {
    private String firstName;
    private String lastName;
    private double hourlyRate;
    private double hoursWorked;

    public Freelancer(String firstName, String lastName, double hourlyRate, double hoursWorked) {
        this.firstName = firstName;
        this.lastName = lastName;
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) throw new IllegalArgumentException("Hourly rate must be non-negative");
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) throw new IllegalArgumentException("Hours worked must be non-negative");
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePayment() {
        double regularHours = Math.min(40.0, hoursWorked);
        double overtimeHours = Math.max(0.0, hoursWorked - 40.0);
        return regularHours * hourlyRate + overtimeHours * hourlyRate * 1.5;
    }

    @Override
    public String getPayeeName() {
        return firstName + " " + lastName;
    }

    public void print() {
        System.out.printf("Freelancer: %s, Payment: $%.2f%n", getPayeeName(), calculatePayment());
    }
}

