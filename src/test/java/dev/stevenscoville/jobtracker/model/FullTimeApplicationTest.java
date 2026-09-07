package dev.stevenscoville.jobtracker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class FullTimeApplicationTest {

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