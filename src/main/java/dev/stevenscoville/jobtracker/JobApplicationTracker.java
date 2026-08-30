package dev.stevenscoville.jobtracker;

import java.time.LocalDate;
import java.util.Scanner;

import dev.stevenscoville.jobtracker.manager.ApplicationManager;
import dev.stevenscoville.jobtracker.model.FullTimeApplication;
import dev.stevenscoville.jobtracker.model.InternshipApplication;
import dev.stevenscoville.jobtracker.model.JobApplication;

public class JobApplicationTracker 
{
    public static void main( String[] args )
    {
        Scanner scnr = new Scanner(System.in);
        ApplicationManager manager = new ApplicationManager();

        int choice = 0;

        while (choice != 7) {
            System.out.println("\nJob Application Tracker");
            System.out.println("1. Add Internship Application");
            System.out.println("2. Add Full-Time Application");
            System.out.println("3. View All Applications");
            System.out.println("4. Search for Application");
            System.out.println("5. Remove Application");
            System.out.println("6. Update Application Status/Notes");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = scnr.nextInt();
            scnr.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Company: ");
                    String internshipCompany = scnr.nextLine();

                    System.out.print("Position Title: ");
                    String internshipTitle = scnr.nextLine();

                    System.out.print("Application Date (YYYY-MM-DD): ");
                    LocalDate internshipDate = LocalDate.parse(scnr.nextLine());

                    System.out.print("Internship Type: ");
                    String internshipType = scnr.nextLine();

                    System.out.print("Semester: ");
                    String semester = scnr.nextLine();

                    InternshipApplication internship =
                        new InternshipApplication(
                            internshipCompany,
                            internshipTitle,
                            internshipDate,
                            internshipType,
                            semester
                        );

                    manager.addApplication(internship);
                    
                    System.out.println("Application added.");
                    
                    break;

                case 2:
                    System.out.print("Company: ");
                    String fullTimeCompany = scnr.nextLine();

                    System.out.print("Position Title: ");
                    String fullTimeTitle = scnr.nextLine();

                    System.out.print("Application Date (YYYY-MM-DD): ");
                    LocalDate fullTimeDate = LocalDate.parse(scnr.nextLine());

                    System.out.print("Salary: ");
                    double salary = scnr.nextDouble();

                    System.out.print("Remote? (true/false): ");
                    boolean remote = scnr.nextBoolean();
                    scnr.nextLine();

                    FullTimeApplication fullTime =
                        new FullTimeApplication(
                            fullTimeCompany,
                            fullTimeTitle,
                            fullTimeDate,
                            salary,
                            remote
                        );

                    manager.addApplication(fullTime);
                    
                    System.out.println("Application added.");
                    
                    break;

                case 3:
                    if (manager.getApplications().isEmpty()) {
                        System.out.println("No applications found.");
                    }
                    else {
                        manager.displayApplications();
                    }
                    break;

                case 4:
                    System.out.println("\nSearch Options");
                    System.out.println("1. Search by Company");
                    System.out.println("2. Search by Company and Position Title");
                    System.out.print("Enter choice: ");

                    int searchChoice = scnr.nextInt();
                    scnr.nextLine();

                    JobApplication foundApplication = null;

                    if (searchChoice == 1) {
                        System.out.print("Company: ");
                        String searchCompany = scnr.nextLine();

                        foundApplication = manager.findApplication(searchCompany);
                    }
                    else if (searchChoice == 2) {
                        System.out.print("Company: ");
                        String searchCompany = scnr.nextLine();

                        System.out.print("Position Title: ");
                        String searchTitle = scnr.nextLine();

                        foundApplication = manager.findApplication(searchCompany, searchTitle);
                    }
                    else {
                        System.out.println("Invalid search option.");
                        break;
                    }

                    if (foundApplication != null) {
                        System.out.println("\n" + foundApplication.getSummary());
                    }
                    else {
                        System.out.println("Application not found.");
                    }

                    break;

                case 5:
                    System.out.print("Company: ");
                    String removeCompany = scnr.nextLine();

                    System.out.print("Position Title: ");
                    String removeTitle = scnr.nextLine();

                    JobApplication applicationToRemove =
                        manager.findApplication(removeCompany, removeTitle);

                    if (applicationToRemove != null) {
                        manager.removeApplication(applicationToRemove);
                        System.out.println("Application removed.");
                    }
                    else {
                        System.out.println("Application not found.");
                    }
                    break;

                case 6:
                    System.out.print("Company: ");
                    String updateCompany = scnr.nextLine();

                    System.out.print("Position Title: ");
                    String updateTitle = scnr.nextLine();

                    JobApplication applicationToUpdate =
                        manager.findApplication(updateCompany, updateTitle);

                    if (applicationToUpdate != null) {
                        System.out.print("New Status: ");
                        String newStatus = scnr.nextLine();

                        applicationToUpdate.setStatus(newStatus);
                        System.out.println("Status updated.");

                        System.out.print("Add Notes: ");
                        String newNotes = scnr.nextLine();
                        applicationToUpdate.setNotes(newNotes);
                    }
                    else {
                        System.out.println("Application not found.");
                    }
                    break;

                case 7:
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scnr.close();
    }
}
