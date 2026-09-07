package dev.stevenscoville.jobtracker.manager;

import dev.stevenscoville.jobtracker.model.JobApplication;
import java.util.ArrayList;

/**
 * Manages the collection of job applications stored by the application.
 * Provides methods for adding, removing, retrieving, searching, and
 * displaying job applications.
 *
 * @author Steven Scoville
 * @version 1.0
 */
public class ApplicationManager {
    private ArrayList<JobApplication> applications;

    /**
     * Creates an ApplicationManager with an empty collection of applications.
     */
    public ApplicationManager() {
        applications = new ArrayList<>();
    }

    /**
     * Adds a job application to the collection.
     *
     * @param application the job application to add
     */
    public void addApplication(JobApplication application) {
        applications.add(application);
    }

    /**
     * Removes a job application from the collection.
     *
     * @param application the job application to remove
     */
    public void removeApplication(JobApplication application) {
        applications.remove(application);
    }

    /**
     * Returns the collection of job applications.
     *
     * @return the list of stored job applications
     */
    public ArrayList<JobApplication> getApplications() {
        return applications;
    }

    /**
     * Searches for the first application matching the specified company.
     *
     * @param company the company name to search for
     * @return the matching application, or null if no match is found
     */
    public JobApplication findApplication(String company) {
        for (JobApplication application : applications) {
            if (application.getCompany().equalsIgnoreCase(company)) {
                return application;
            }
        }
        return null;
    }

    /**
     * Searches for an application matching both the specified company
     * and position title.
     *
     * @param company the company name to search for
     * @param positionTitle the position title to search for
     * @return the matching application, or null if no match is found
     */
    public JobApplication findApplication(String company, String positionTitle) {
        for (JobApplication application : applications) {
            if (application.getCompany().equalsIgnoreCase(company) &&
                application.getPositionTitle().equalsIgnoreCase(positionTitle)) {
                return application;
            }
        }
        return null;
    }

    /**
     * Creates a formatted summary of all stored job applications.
     *
     * @return a string containing the summary of each application
     */
    public String displayApplications() {
        StringBuilder output = new StringBuilder();

        for (JobApplication application : applications)
        {
            output.append(application.getSummary());
            output.append("\n\n");
        }

        return output.toString();
    }
}