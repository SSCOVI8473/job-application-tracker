package dev.stevenscoville.jobtracker.model;

import java.time.LocalDate;

/**
 * Represents an internship job application.
 * Extends JobApplication with internship type and semester information
 * specific to internship positions.
 *
 * @author Steven Scoville
 * @version 1.0
 */
public class InternshipApplication extends JobApplication {
    private String internshipType;
    private String semester;

    /**
     * Creates an internship application with the specified job information.
     * The default status and notes are initialized by the parent class.
     *
     * @param company the company offering the position
     * @param positionTitle the title of the position
     * @param applicationDate the date the application was submitted
     * @param internshipType the type of internship
     * @param semester the semester associated with the internship
     */
    public InternshipApplication(
        String company,
        String positionTitle,
        LocalDate applicationDate,
        String internshipType,
        String semester
    ) {
        super(company, positionTitle, applicationDate);
        this.internshipType = internshipType;
        this.semester = semester;
    }

    /**
     * Creates an internship application with all application information.
     *
     * @param company the company offering the position
     * @param positionTitle the title of the position
     * @param applicationDate the date the application was submitted
     * @param status the current application status
     * @param notes notes associated with the application
     * @param internshipType the type of internship
     * @param semester the semester associated with the internship
     */
    public InternshipApplication(
        String company,
        String positionTitle,
        LocalDate applicationDate,
        String status,
        String notes,
        String internshipType,
        String semester
    ) {
        super(
            company,
            positionTitle,
            applicationDate,
            status,
            notes
        );

        this.internshipType = internshipType;
        this.semester = semester;
    }

    /**
     * Returns the internship type.
     *
     * @return the internship type
     */
    public String getInternshipType() {
        return internshipType;
    }

    /**
     * Returns the semester associated with the internship.
     *
     * @return the internship semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Sets the internship type.
     *
     * @param internshipType the new internship type
     */
    public void setInternshipType(String internshipType) {
        this.internshipType = internshipType;
    }

    /**
     * Sets the semester associated with the internship.
     *
     * @param semester the new internship semester
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Returns a formatted summary of the internship application,
     * including the internship type and semester.
     *
     * @return the formatted application summary
     */
    @Override
    public String getSummary() {
        return super.getSummary() + "\n" +
               "Internship Type: " + internshipType + "\n" +
               "Semester: " + semester;
    }
}