package dev.stevenscoville.jobtracker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class JobApplicationTest {
    @Test
    public void constructorSetsDefaultStatusToApplied() {
        JobApplication application = new JobApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23)
        );

        assertEquals("Applied", application.getStatus());
    }

    @Test
    public void constructorSetsDefaultNotesToEmptyString() {
        JobApplication application = new JobApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23)
        );

        assertEquals("", application.getNotes());
    }

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
        assertEquals("Second interview scheduled", application.getNotes());
    }

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
