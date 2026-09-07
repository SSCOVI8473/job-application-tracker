package dev.stevenscoville.jobtracker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

/**
 * Tests the JobApplication class, including default values,
 * constructor initialization, and formatted application summaries.
 *
 * @author Steven Scoville
 * @version 1.0
 */
public class JobApplicationTest {

    /**
     * Verifies that a new job application defaults to an
     * "Applied" status.
     */
    @Test
    public void constructorSetsDefaultStatusToApplied() {
        JobApplication application = new JobApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23)
        );

        assertEquals("Applied", application.getStatus());
    }

    /**
     * Verifies that a new job application defaults to an empty
     * notes field.
     */
    @Test
    public void constructorSetsDefaultNotesToEmptyString() {
        JobApplication application = new JobApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23)
        );

        assertEquals("", application.getNotes());
    }

    /**
     * Verifies that the full constructor correctly initializes
     * the application status and notes.
     */
    @Test
    public void fullConstructorSetsStatusAndNotes() {
        JobApplication application = new JobApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23),
            "Interviewing",
            "Second interview scheduled"
        );

        assertEquals("Interviewing", application.getStatus());
        assertEquals(
            "Second interview scheduled",
            application.getNotes()
        );
    }

    /**
     * Verifies that the formatted summary contains all general
     * job application information.
     */
    @Test
    public void getSummaryIncludesApplicationInformation() {
        JobApplication application = new JobApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23),
            "Interviewing",
            "Second interview scheduled"
        );

        String summary = application.getSummary();

        assertTrue(summary.contains("Microsoft"));
        assertTrue(summary.contains("Software Developer"));
        assertTrue(summary.contains("August 23, 2026"));
        assertTrue(summary.contains("Interviewing"));
        assertTrue(summary.contains("Second interview scheduled"));
    }
}