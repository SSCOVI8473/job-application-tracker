package dev.stevenscoville.jobtracker.model;

import java.text.NumberFormat;
import java.time.LocalDate;

/**
 * Represents a full-time job application.
 * Extends JobApplication with salary and remote-work information
 * specific to full-time positions.
 *
 * @author Steven Scoville
 * @version 1.0
 */
public class FullTimeApplication extends JobApplication {
    private double salary;
    private boolean remote;

    /**
     * Creates a full-time application with the specified job information.
     * The default status and notes are initialized by the parent class.
     *
     * @param company the company offering the position
     * @param positionTitle the title of the position
     * @param applicationDate the date the application was submitted
     * @param salary the salary associated with the position
     * @param remote whether the position is remote
     */
    public FullTimeApplication(
        String company,
        String positionTitle,
        LocalDate applicationDate,
        double salary,
        boolean remote
    ) {
        super(company, positionTitle, applicationDate);
        this.salary = salary;
        this.remote = remote;
    }

    /**
     * Creates a full-time application with all application information.
     *
     * @param company the company offering the position
     * @param positionTitle the title of the position
     * @param applicationDate the date the application was submitted
     * @param status the current application status
     * @param notes notes associated with the application
     * @param salary the salary associated with the position
     * @param remote whether the position is remote
     */
    public FullTimeApplication(
        String company,
        String positionTitle,
        LocalDate applicationDate,
        String status,
        String notes,
        double salary,
        boolean remote
    ) {
        super(
            company,
            positionTitle,
            applicationDate,
            status,
            notes
        );

        this.salary = salary;
        this.remote = remote;
    }

    /**
     * Returns the salary associated with the position.
     *
     * @return the position salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Returns whether the position is remote.
     *
     * @return true if the position is remote; otherwise false
     */
    public boolean isRemote() {
        return remote;
    }

    /**
     * Sets the salary associated with the position.
     *
     * @param salary the new position salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Sets whether the position is remote.
     *
     * @param remote true if the position is remote; otherwise false
     */
    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    /**
     * Returns a formatted summary of the full-time application,
     * including the salary and remote-work information.
     *
     * @return the formatted application summary
     */
    @Override
    public String getSummary() {
        return super.getSummary() + "\n" +
               "Salary: " +
               NumberFormat.getCurrencyInstance().format(salary) + "\n" +
               "Remote: " + (remote ? "Yes" : "No");
    }
}