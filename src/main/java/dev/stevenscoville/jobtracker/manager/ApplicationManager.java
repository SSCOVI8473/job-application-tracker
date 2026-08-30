package dev.stevenscoville.jobtracker.manager;
import dev.stevenscoville.jobtracker.model.JobApplication;
import java.util.ArrayList;

public class ApplicationManager {
    private ArrayList<JobApplication> applications;

    public ApplicationManager() {
        applications = new ArrayList<>();
    }

    public void addApplication(JobApplication application) {
        applications.add(application);
    }

    public void removeApplication(JobApplication application) {
        applications.remove(application);
    }

    public ArrayList<JobApplication> getApplications() {
        return applications;
    }

    public JobApplication findApplication(String company) {
        for (JobApplication application : applications) {
            if (application.getCompany().equalsIgnoreCase(company)) {
                return application;
            }
        }
        return null; // Return null if not found
    }

    public JobApplication findApplication(String company, String positionTitle) {
        for (JobApplication application : applications) {
            if (application.getCompany().equalsIgnoreCase(company) && 
                application.getPositionTitle().equalsIgnoreCase(positionTitle)) {
                return application;
            }
        }
        return null; // Return null if not found
    }

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