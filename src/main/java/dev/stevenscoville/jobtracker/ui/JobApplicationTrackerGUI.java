package dev.stevenscoville.jobtracker.ui;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.time.LocalDate;

import dev.stevenscoville.jobtracker.model.JobApplication;

public class JobApplicationTrackerGUI {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Job Application Tracker");

        JButton addButton;
        JButton clearButton;
        JButton editNotesButton;
        JButton removeButton;
        JButton searchButton;
        JButton updateStatusButton;

        JCheckBox remoteCheckBox;

        JComboBox<String> applicationTypeComboBox;
        JComboBox<String> internshipTypeComboBox;
        JComboBox<String> statusComboBox;

        JLabel applicationTypeLabel;
        JLabel applicationsListLabel;
        JLabel companyLabel;
        JLabel dateLabel;
        JLabel internshipTypeLabel;
        JLabel notesLabel;
        JLabel positionLabel;
        JLabel remoteLabel;
        JLabel salaryLabel;
        JLabel semesterLabel;
        JLabel statusLabel;

        JList<JobApplication> applicationsList;

        JTextArea notesArea;

        JTextField companyField;
        JTextField dateField;
        JTextField positionField;
        JTextField salaryField;
        JTextField semesterField;

        applicationTypeComboBox =
            new JComboBox<>(new String[] {"Internship", "Full-Time"});

        internshipTypeComboBox =
            new JComboBox<>(new String[] {"Paid", "Unpaid"});

        statusComboBox =
            new JComboBox<>(new String[] {
                "Applied",
                "Interview",
                "Offer",
                "Rejected",
                "Withdrawn"
            });

        remoteCheckBox = new JCheckBox();

        companyField = new JTextField();
        dateField = new JTextField(LocalDate.now().toString());
        positionField = new JTextField();
        salaryField = new JTextField();
        semesterField = new JTextField();

        notesArea = new JTextArea(3, 20);
        notesArea.setLineWrap(true);
        notesArea.setWrapStyleWord(true);

        applicationsList = new JList<>();

        addButton = new JButton("Add Application");
        clearButton = new JButton("Clear");
        editNotesButton = new JButton("Edit Notes");
        removeButton = new JButton("Remove");
        searchButton = new JButton("Search");
        updateStatusButton = new JButton("Update Status");

        editNotesButton.setEnabled(false);
        removeButton.setEnabled(false);
        updateStatusButton.setEnabled(false);

        applicationTypeLabel = new JLabel("Application Type:");
        applicationsListLabel = new JLabel("Applications:");
        companyLabel = new JLabel("Company:");
        dateLabel = new JLabel("Application Date (YYYY-MM-DD):");
        internshipTypeLabel = new JLabel("Internship Type:");
        notesLabel = new JLabel("Notes:");
        positionLabel = new JLabel("Position:");
        remoteLabel = new JLabel("Remote:");
        salaryLabel = new JLabel("Salary:");
        semesterLabel = new JLabel("Semester:");
        statusLabel = new JLabel("Status:");

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        inputPanel.add(applicationTypeLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        inputPanel.add(applicationTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        inputPanel.add(companyLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        inputPanel.add(companyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        inputPanel.add(positionLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        inputPanel.add(positionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        inputPanel.add(dateLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        inputPanel.add(dateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        inputPanel.add(internshipTypeLabel, gbc);
        inputPanel.add(salaryLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        inputPanel.add(internshipTypeComboBox, gbc);
        inputPanel.add(salaryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;
        inputPanel.add(semesterLabel, gbc);
        inputPanel.add(remoteLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        inputPanel.add(semesterField, gbc);
        inputPanel.add(remoteCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        inputPanel.add(statusLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        inputPanel.add(statusComboBox, gbc);

        JScrollPane notesScrollPane = new JScrollPane(notesArea);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        inputPanel.add(notesLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        inputPanel.add(notesScrollPane, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        
        salaryLabel.setVisible(false);
        salaryField.setVisible(false);
        remoteLabel.setVisible(false);
        remoteCheckBox.setVisible(false);

        applicationTypeComboBox.addActionListener(e -> {
            boolean isInternship =
                applicationTypeComboBox.getSelectedItem().equals("Internship");

            internshipTypeLabel.setVisible(isInternship);
            internshipTypeComboBox.setVisible(isInternship);
            semesterLabel.setVisible(isInternship);
            semesterField.setVisible(isInternship);

            salaryLabel.setVisible(!isInternship);
            salaryField.setVisible(!isInternship);
            remoteLabel.setVisible(!isInternship);
            remoteCheckBox.setVisible(!isInternship);
        });

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(inputPanel);
        frame.setVisible(true);
    }
}
