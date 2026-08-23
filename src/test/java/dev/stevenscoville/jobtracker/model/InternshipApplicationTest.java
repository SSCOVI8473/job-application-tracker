package dev.stevenscoville.jobtracker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class InternshipApplicationTest {
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
