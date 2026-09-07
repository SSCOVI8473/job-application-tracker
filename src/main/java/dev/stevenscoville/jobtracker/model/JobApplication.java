package dev.stevenscoville.jobtracker.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a general job application and stores information common
 * to all application types, including the company, position, application
 * date, status, and notes.
 *
 * @author Steven Scoville
 * @version 1.0
 */
public class JobApplication {
    private String company;
    private String positionTitle;
    private LocalDate applicationDate;
    private String status;
    private String notes;

    private static final DateTimeFormatter DATE_FORMATTER =
        DateTimeFormatter.ofPattern("MMMM d, yyyy");

    /**
     * Creates a job application with the specified company, position,
     * and application date. The status defaults to "Applied" and the
     * notes are initialized as an empty string.
     *
     * @param company the company offering the position
     * @param positionTitle the title of the position
     * @param applicationDate the date the application was submitted
     */
    public JobApplication(
        String company,
        String positionTitle,
        LocalDate applicationDate
    ) {
        this.company = company;
        this.positionTitle = positionTitle;
        this.applicationDate = applicationDate;
        this.status = "Applied";
        this.notes = "";
    }

    /**
     * Creates a job application with all application information.
     *
     * @param company the company offering the position
     * @param positionTitle the title of the position
     * @param applicationDate the date the application was submitted
     * @param status the current application status
     * @param notes notes associated with the application
     */
    public JobApplication(
        String company,
        String positionTitle,
        LocalDate applicationDate,
        String status,
        String notes
    ) {
        this.company = company;
        this.positionTitle = positionTitle;
        this.applicationDate = applicationDate;
        this.status = status;
        this.notes = notes;
    }

    /**
     * Returns the company associated with the application.
     *
     * @return the company name
     */
    public String getCompany() {
        return company;
    }

    /**
     * Returns the title of the position.
     *
     * @return the position title
     */
    public String getPositionTitle() {
        return positionTitle;
    }

    /**
     * Returns the date the application was submitted.
     *
     * @return the application date
     */
    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    /**
     * Returns the current application status.
     *
     * @return the application status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Returns the notes associated with the application.
     *
     * @return the application notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the company associated with the application.
     *
     * @param company the new company name
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Sets the title of the position.
     *
     * @param positionTitle the new position title
     */
    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    /**
     * Sets the date the application was submitted.
     *
     * @param applicationDate the new application date
     */
    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    /**
     * Sets the current application status.
     *
     * @param status the new application status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sets the notes associated with the application.
     *
     * @param notes the new application notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Returns a formatted summary containing the application's
     * company, position, date, status, and notes.
     *
     * @return the formatted application summary
     */
    public String getSummary() {
        return "Company: " + company + "\n" +
               "Position Title: " + positionTitle + "\n" +
               "Application Date: " +
               applicationDate.format(DATE_FORMATTER) + "\n" +
               "Status: " + status + "\n" +
               "Notes: " + notes;
    }

    /**
     * Returns a compact representation of the application for display
     * in the graphical interface's application list.
     *
     * @return the company, position title, and current status
     */
    @Override
    public String toString()
    {
        return company + " - " + positionTitle + " - " + status;
    }
}