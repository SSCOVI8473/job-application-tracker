package dev.stevenscoville.jobtracker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

/**
 * Tests the FullTimeApplication class, including initialization of
 * full-time-specific fields and inclusion of those fields in the
 * formatted application summary.
 *
 * @author Steven Scoville
 * @version 1.0
 */
public class FullTimeApplicationTest {

    /**
     * Verifies that the constructor correctly initializes the salary
     * and remote-work fields.
     */
    @Test
    public void constructorSetsFullTimeFields() {
        FullTimeApplication application = new FullTimeApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23),
            75000.0,
            true
        );

        assertEquals(75000.0, application.getSalary());
        assertTrue(application.isRemote());
    }

    /**
     * Verifies that the formatted summary contains the full-time
     * application salary and remote-work information.
     */
    @Test
    public void getSummaryIncludesFullTimeInformation() {
        FullTimeApplication application = new FullTimeApplication(
            "Microsoft",
            "Software Developer",
            LocalDate.of(2026, 8, 23),
            75000.0,
            false
        );

        String summary = application.getSummary();

        assertTrue(summary.contains("$75,000.00"));
        assertTrue(summary.contains("No"));
        assertFalse(application.isRemote());
    }
}