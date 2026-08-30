package dev.stevenscoville.jobtracker.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JobApplication {
    private String company;
    private String positionTitle;
    private LocalDate applicationDate;
    private String status;
    private String notes;
    private static final DateTimeFormatter DATE_FORMATTER =
        DateTimeFormatter.ofPattern("MMMM d, yyyy");

    public JobApplication(String company, String positionTitle, LocalDate applicationDate) {
        this.company = company;
        this.positionTitle = positionTitle;
        this.applicationDate = applicationDate;
        this.status = "Applied";
        this.notes = "";
    }

    public JobApplication (String company, String positionTitle, LocalDate applicationDate, String status, String notes) {
        this.company = company;
        this.positionTitle = positionTitle;
        this.applicationDate = applicationDate;
        this.status = status;
        this.notes = notes;
    }

    // Getters
    public String getCompany() {
        return company;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    // Setters
    public void setCompany(String company) {
        this.company = company;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSummary() {
        return "Company: " + company + "\n" +
               "Position Title: " + positionTitle + "\n" +
               "Application Date: " + applicationDate.format(DATE_FORMATTER) + "\n" +
               "Status: " + status + "\n" +
               "Notes: " + notes;
    }
}
