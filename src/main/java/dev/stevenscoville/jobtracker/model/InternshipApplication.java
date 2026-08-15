package dev.stevenscoville.jobtracker.model;

import java.time.LocalDate;

public class InternshipApplication extends JobApplication {
    private String internshipType;
    private String semester;

    public InternshipApplication(String company, String positionTitle, LocalDate applicationDate, String internshipType, String semester) {
        super(company, positionTitle, applicationDate);
        this.internshipType = internshipType;
        this.semester = semester;
    }

    public InternshipApplication(String company, String positionTitle, LocalDate applicationDate, String status, String notes, String internshipType, String semester) {
        super(company, positionTitle, applicationDate, status, notes);
        this.internshipType = internshipType;
        this.semester = semester;
    }

    // Getters
    public String getInternshipType() {
        return internshipType;
    }

    public String getSemester() {
        return semester;
    }

    // Setters
    public void setInternshipType(String internshipType) {
        this.internshipType = internshipType;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String getSummary() {
        return super.getSummary() + "\n" +
               "Internship Type: " + internshipType + "\n" +
               "Semester: " + semester;
    }
}