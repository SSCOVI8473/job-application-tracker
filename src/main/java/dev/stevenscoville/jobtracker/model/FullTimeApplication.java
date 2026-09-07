package dev.stevenscoville.jobtracker.model;

import java.text.NumberFormat;
import java.time.LocalDate;

public class FullTimeApplication extends JobApplication {
    private double salary;
    private boolean remote;

    public FullTimeApplication(String company, String positionTitle, LocalDate applicationDate, double salary, boolean remote) {
        super(company, positionTitle, applicationDate);
        this.salary = salary;
        this.remote = remote;
    }

    public FullTimeApplication(String company, String positionTitle, LocalDate applicationDate, String status, String notes, double salary, boolean remote) {
        super(company, positionTitle, applicationDate, status, notes);
        this.salary = salary;
        this.remote = remote;
    }

    // Getters
    public double getSalary() {
        return salary;
    }

    public boolean isRemote() {
        return remote;
    }

    // Setters
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    @Override
    public String getSummary() {
        return super.getSummary() + "\n" +
               "Salary: " + NumberFormat.getCurrencyInstance().format(salary) + "\n" +
               "Remote: " + (remote ? "Yes" : "No");
    }
}
