package dev.stevenscoville.jobtracker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

/**
 * Tests the InternshipApplication class, including initialization of
 * internship-specific fields and inclusion of those fields in the
 * formatted application summary.
 *
 * @author Steven Scoville
 * @version 1.0
 */
public class InternshipApplicationTest {

    /**
     * Verifies that the constructor correctly initializes the internship
     * type and semester fields.
     */
    @Test
    public void constructorSetsInternshipFields() {
        InternshipApplication application = new InternshipApplication(
            "Microsoft",
            "Software Engineering Intern",
            LocalDate.of(2026, 8, 23),
            "Paid",
            "Fall 2026"
        );

        assertEquals("Paid", application.getInternshipType());
        assertEquals("Fall 2026", application.getSemester());
    }

    /**
     * Verifies that the formatted summary contains the internship type
     * and semester information.
     */
    @Test
    public void getSummaryIncludesInternshipInformation() {
        InternshipApplication application = new InternshipApplication(
            "Microsoft",
            "Software Engineering Intern",
            LocalDate.of(2026, 8, 23),
            "Paid",
            "Fall 2026"
        );

        String summary = application.getSummary();

        assertTrue(summary.contains("Paid"));
        assertTrue(summary.contains("Fall 2026"));
    }
}