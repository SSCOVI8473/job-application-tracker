package dev.stevenscoville.jobtracker.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import dev.stevenscoville.jobtracker.model.JobApplication;

public class ApplicationManagerTest {
    @Test
    public void newManagerStartsEmpty() {
        ApplicationManager manager = new ApplicationManager();

        assertTrue(manager.getApplications().isEmpty());
    }

    @Test
    public void addApplicationAddsApplication() {
        ApplicationManager manager = new ApplicationManager();

        JobApplication application = new JobApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23)
        );

        manager.addApplication(application);

        assertEquals(1, manager.getApplications().size());
        assertTrue(manager.getApplications().contains(application));
    }

    @Test
    public void removeApplicationRemovesApplication() {
        ApplicationManager manager = new ApplicationManager();

        JobApplication application = new JobApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23)
        );

        manager.addApplication(application);
        manager.removeApplication(application);

        assertTrue(manager.getApplications().isEmpty());
    }

    @Test
    public void findApplicationFindsByCompany() {
        ApplicationManager manager = new ApplicationManager();

        JobApplication application = new JobApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23)
        );

        manager.addApplication(application);

        JobApplication result = manager.findApplication("Microsoft");

        assertEquals(application, result);
    }

    @Test
    public void findApplicationFindsByCompanyAndPositionTitle() {
        ApplicationManager manager = new ApplicationManager();

        JobApplication firstApplication = new JobApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23)
        );

        JobApplication secondApplication = new JobApplication(
            "Microsoft",
            "QA Engineer",
            LocalDate.of(2026, 8, 24)
        );

        manager.addApplication(firstApplication);
        manager.addApplication(secondApplication);

        JobApplication result =
            manager.findApplication("Microsoft", "QA Engineer");

        assertEquals(secondApplication, result);
    }

    @Test
    public void findApplicationReturnsNullWhenNotFound() {
        ApplicationManager manager = new ApplicationManager();

        JobApplication application = new JobApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23)
        );

        manager.addApplication(application);

        JobApplication result = manager.findApplication("Google");

        assertNull(result);
    }

    @Test
    public void displayApplicationsReturnsAllApplicationSummaries() {
        JobApplication application1 = new JobApplication(
            "Microsoft", 
            "Software Developer", 
            LocalDate.of(2026, 8, 23)
        );

        JobApplication application2 = new JobApplication(
            "Google", 
            "QA Engineer", 
            LocalDate.of(2026, 8, 24)
        );

        ApplicationManager manager = new ApplicationManager();
        manager.addApplication(application1);
        manager.addApplication(application2);

        String result = manager.displayApplications();

        assertTrue(result.contains(application1.getSummary()));
        assertTrue(result.contains(application2.getSummary()));
    }
}
