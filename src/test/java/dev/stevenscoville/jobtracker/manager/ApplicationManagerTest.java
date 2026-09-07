package dev.stevenscoville.jobtracker.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import dev.stevenscoville.jobtracker.model.JobApplication;

/**
 * Tests the functionality of the ApplicationManager class, including
 * adding, removing, searching for, retrieving, and displaying job
 * applications.
 *
 * @author Steven Scoville
 * @version 1.0
 */
public class ApplicationManagerTest {

    /**
     * Verifies that a newly created ApplicationManager contains no
     * applications.
     */
    @Test
    public void newManagerStartsEmpty() {
        ApplicationManager manager = new ApplicationManager();

        assertTrue(manager.getApplications().isEmpty());
    }

    /**
     * Verifies that an application can be added to the manager.
     */
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

    /**
     * Verifies that an application can be removed from the manager.
     */
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

    /**
     * Verifies that an application can be found by company name.
     */
    @Test
    public void findApplicationFindsByCompany() {
        ApplicationManager manager = new ApplicationManager();

        JobApplication application = new JobApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23)
        );

        manager.addApplication(application);

        JobApplication result =
            manager.findApplication("Microsoft");

        assertEquals(application, result);
    }

    /**
     * Verifies that an application can be found by both company name
     * and position title.
     */
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
            manager.findApplication(
                "Microsoft",
                "QA Engineer"
            );

        assertEquals(secondApplication, result);
    }

    /**
     * Verifies that a search returns null when no matching application
     * is found.
     */
    @Test
    public void findApplicationReturnsNullWhenNotFound() {
        ApplicationManager manager = new ApplicationManager();

        JobApplication application = new JobApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23)
        );

        manager.addApplication(application);

        JobApplication result =
            manager.findApplication("Google");

        assertNull(result);
    }

    /**
     * Verifies that the display output contains summaries for all
     * applications stored by the manager.
     */
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

        String result =
            manager.displayApplications();

        assertTrue(result.contains(application1.getSummary()));
        assertTrue(result.contains(application2.getSummary()));
    }
}