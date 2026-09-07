package dev.stevenscoville.jobtracker.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;

import dev.stevenscoville.jobtracker.model.JobApplication;
import dev.stevenscoville.jobtracker.manager.ApplicationManager;
import dev.stevenscoville.jobtracker.model.FullTimeApplication;
import dev.stevenscoville.jobtracker.model.InternshipApplication;

public class JobApplicationTrackerGUI {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Job Application Tracker");
        ApplicationManager applicationManager = new ApplicationManager();

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
        JLabel selectedApplicationLabel;
        JLabel semesterLabel;
        JLabel statusLabel;

        JList<JobApplication> applicationsList;

        JTextArea notesArea;
        JTextArea selectedApplicationArea;

        JTextField companyField;
        JTextField dateField;
        JTextField positionField;
        JTextField salaryField;
        JTextField semesterField;

        Color backgroundColor = new Color(18, 24, 32);
        Color panelColor = new Color(27, 36, 48);
        Color fieldColor = new Color(38, 49, 64);
        Color textColor = new Color(230, 235, 240);
        Color accentColor = new Color(66, 135, 181);

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

        selectedApplicationArea = new JTextArea();
        selectedApplicationArea.setEditable(false);
        selectedApplicationArea.setLineWrap(true);
        selectedApplicationArea.setWrapStyleWord(true);

        DefaultListModel<JobApplication> applicationsListModel =
            new DefaultListModel<>();

        applicationsList = new JList<>(applicationsListModel);

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
        applicationsListLabel =
            new JLabel("Applications", SwingConstants.CENTER);
        companyLabel = new JLabel("Company:");
        dateLabel = new JLabel("Application Date (YYYY-MM-DD):");
        internshipTypeLabel = new JLabel("Internship Type:");
        notesLabel = new JLabel("Notes:");
        positionLabel = new JLabel("Position:");
        remoteLabel = new JLabel("Remote:");
        salaryLabel = new JLabel("Salary:");
        selectedApplicationLabel =
            new JLabel("Selected Application", SwingConstants.CENTER);
        semesterLabel = new JLabel("Semester:");
        statusLabel = new JLabel("Status:");

        applicationsListLabel.setFont(
            new Font("SansSerif", Font.BOLD, 18)
        );

        selectedApplicationLabel.setFont(
            new Font("SansSerif", Font.BOLD, 16)
        );

        applicationTypeLabel.setForeground(textColor);
        applicationsListLabel.setForeground(textColor);
        companyLabel.setForeground(textColor);
        dateLabel.setForeground(textColor);
        internshipTypeLabel.setForeground(textColor);
        notesLabel.setForeground(textColor);
        positionLabel.setForeground(textColor);
        remoteLabel.setForeground(textColor);
        salaryLabel.setForeground(textColor);
        selectedApplicationLabel.setForeground(textColor);
        semesterLabel.setForeground(textColor);
        statusLabel.setForeground(textColor);

        companyField.setBackground(fieldColor);
        companyField.setForeground(textColor);
        companyField.setCaretColor(textColor);

        dateField.setBackground(fieldColor);
        dateField.setForeground(textColor);
        dateField.setCaretColor(textColor);

        positionField.setBackground(fieldColor);
        positionField.setForeground(textColor);
        positionField.setCaretColor(textColor);

        salaryField.setBackground(fieldColor);
        salaryField.setForeground(textColor);
        salaryField.setCaretColor(textColor);

        semesterField.setBackground(fieldColor);
        semesterField.setForeground(textColor);
        semesterField.setCaretColor(textColor);

        notesArea.setBackground(fieldColor);
        notesArea.setForeground(textColor);
        notesArea.setCaretColor(textColor);

        selectedApplicationArea.setBackground(fieldColor);
        selectedApplicationArea.setForeground(textColor);

        applicationsList.setBackground(fieldColor);
        applicationsList.setForeground(textColor);

        remoteCheckBox.setBackground(panelColor);

        addButton.setBackground(accentColor);
        addButton.setForeground(textColor);

        clearButton.setBackground(accentColor);
        clearButton.setForeground(textColor);

        searchButton.setBackground(accentColor);
        searchButton.setForeground(textColor);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        JPanel applicationsPanel = new JPanel(new BorderLayout(5, 5));
        JPanel selectedPanel = new JPanel(new BorderLayout(5, 5));
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        inputPanel.setBackground(panelColor);
        applicationsPanel.setBackground(panelColor);
        selectedPanel.setBackground(panelColor);
        mainPanel.setBackground(backgroundColor);

        inputPanel.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(accentColor),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            )
        );

        applicationsPanel.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(accentColor),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            )
        );

        selectedPanel.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(accentColor),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            )
        );

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

        JPanel formButtonPanel = new JPanel();
        formButtonPanel.setBackground(panelColor);
        formButtonPanel.add(addButton);
        formButtonPanel.add(clearButton);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(formButtonPanel, gbc);

        JScrollPane applicationsScrollPane =
            new JScrollPane(applicationsList);

        applicationsPanel.add(
            applicationsListLabel,
            BorderLayout.NORTH
        );

        applicationsPanel.add(
            applicationsScrollPane,
            BorderLayout.CENTER
        );

        JScrollPane selectedApplicationScrollPane =
            new JScrollPane(selectedApplicationArea);

        JPanel selectedButtonPanel = new JPanel(new GridBagLayout());
        selectedButtonPanel.setBackground(panelColor);

        GridBagConstraints buttonGbc = new GridBagConstraints();

        buttonGbc.gridx = 0;
        buttonGbc.weightx = 1;
        buttonGbc.fill = GridBagConstraints.HORIZONTAL;
        buttonGbc.insets = new Insets(4, 4, 4, 4);

        buttonGbc.gridy = 0;
        selectedButtonPanel.add(searchButton, buttonGbc);

        buttonGbc.gridy = 1;
        selectedButtonPanel.add(removeButton, buttonGbc);

        buttonGbc.gridy = 2;
        selectedButtonPanel.add(updateStatusButton, buttonGbc);

        buttonGbc.gridy = 3;
        selectedButtonPanel.add(editNotesButton, buttonGbc);

        selectedPanel.add(
            selectedApplicationLabel,
            BorderLayout.NORTH
        );

        selectedPanel.add(
            selectedApplicationScrollPane,
            BorderLayout.CENTER
        );

        selectedPanel.add(
            selectedButtonPanel,
            BorderLayout.SOUTH
        );

        inputPanel.setPreferredSize(new Dimension(340, 500));
        applicationsPanel.setPreferredSize(new Dimension(320, 500));
        selectedPanel.setPreferredSize(new Dimension(260, 500));

        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        mainPanel.add(inputPanel, BorderLayout.WEST);
        mainPanel.add(applicationsPanel, BorderLayout.CENTER);
        mainPanel.add(selectedPanel, BorderLayout.EAST);

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

        addButton.addActionListener(e -> {
            String company = companyField.getText().trim();
            String positionTitle = positionField.getText().trim();
            String notes = notesArea.getText().trim();

            if (company.isEmpty() || positionTitle.isEmpty())
            {
                JOptionPane.showMessageDialog(
                    frame,
                    "Company and position are required.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            LocalDate applicationDate;

            try
            {
                applicationDate =
                    LocalDate.parse(dateField.getText().trim());
            }
            catch (DateTimeParseException exception)
            {
                JOptionPane.showMessageDialog(
                    frame,
                    "Enter the application date as YYYY-MM-DD.",
                    "Invalid Date",
                    JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            String status =
                (String) statusComboBox.getSelectedItem();

            if (applicationTypeComboBox
                .getSelectedItem()
                .equals("Internship"))
            {
                String internshipType =
                    (String) internshipTypeComboBox.getSelectedItem();

                String semester = semesterField.getText().trim();

                if (semester.isEmpty())
                {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Semester is required for an internship.",
                        "Missing Information",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                InternshipApplication application =
                    new InternshipApplication(
                        company,
                        positionTitle,
                        applicationDate,
                        status,
                        notes,
                        internshipType,
                        semester
                    );

                applicationManager.addApplication(application);
            }
            else
            {
                double salary;

                try
                {
                    salary =
                        Double.parseDouble(salaryField.getText().trim());
                }
                catch (NumberFormatException exception)
                {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Salary must be a valid number.",
                        "Invalid Salary",
                        JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }

                boolean remote = remoteCheckBox.isSelected();

                FullTimeApplication application =
                    new FullTimeApplication(
                        company,
                        positionTitle,
                        applicationDate,
                        status,
                        notes,
                        salary,
                        remote
                    );

                applicationManager.addApplication(application);
            }

            ArrayList<JobApplication> sortedApplications =
                new ArrayList<>(applicationManager.getApplications());

            sortedApplications.sort(
                Comparator
                    .comparing(
                        JobApplication::getCompany,
                        String.CASE_INSENSITIVE_ORDER
                    )
                    .thenComparing(
                        JobApplication::getPositionTitle,
                        String.CASE_INSENSITIVE_ORDER
                    )
            );

            applicationsListModel.clear();

            for (JobApplication application : sortedApplications)
            {
                applicationsListModel.addElement(application);
            }

            JOptionPane.showMessageDialog(
                frame,
                "Application added successfully.",
                "Application Added",
                JOptionPane.INFORMATION_MESSAGE
            );

            applicationTypeComboBox.setSelectedIndex(0);
            companyField.setText("");
            positionField.setText("");
            dateField.setText(LocalDate.now().toString());
            internshipTypeComboBox.setSelectedIndex(0);
            semesterField.setText("");
            salaryField.setText("");
            remoteCheckBox.setSelected(false);
            statusComboBox.setSelectedIndex(0);
            notesArea.setText("");
        });

        clearButton.addActionListener(e -> {
            applicationTypeComboBox.setSelectedIndex(0);
            companyField.setText("");
            positionField.setText("");
            dateField.setText(LocalDate.now().toString());
            internshipTypeComboBox.setSelectedIndex(0);
            semesterField.setText("");
            salaryField.setText("");
            remoteCheckBox.setSelected(false);
            statusComboBox.setSelectedIndex(0);
            notesArea.setText("");
        });

        applicationsList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting())
            {
                JobApplication selectedApplication =
                    applicationsList.getSelectedValue();

                boolean hasSelection =
                    selectedApplication != null;

                removeButton.setEnabled(hasSelection);
                updateStatusButton.setEnabled(hasSelection);
                editNotesButton.setEnabled(hasSelection);

                if (hasSelection)
                {
                    selectedApplicationArea.setText(
                        selectedApplication.getSummary()
                    );

                    selectedApplicationArea.setCaretPosition(0);
                }
                else
                {
                    selectedApplicationArea.setText("");
                }
            }
        });

        searchButton.addActionListener(e -> {
            JTextField searchCompanyField = new JTextField();
            JTextField searchPositionField = new JTextField();

            JPanel searchPanel = new JPanel(new GridBagLayout());
            GridBagConstraints searchGbc = new GridBagConstraints();

            searchGbc.insets = new Insets(5, 5, 5, 5);
            searchGbc.fill = GridBagConstraints.HORIZONTAL;

            searchGbc.gridx = 0;
            searchGbc.gridy = 0;
            searchGbc.weightx = 0;
            searchPanel.add(new JLabel("Company:"), searchGbc);

            searchGbc.gridx = 1;
            searchGbc.weightx = 1;
            searchPanel.add(searchCompanyField, searchGbc);

            searchGbc.gridx = 0;
            searchGbc.gridy = 1;
            searchGbc.weightx = 0;
            searchPanel.add(new JLabel("Position (optional):"), searchGbc);

            searchGbc.gridx = 1;
            searchGbc.weightx = 1;
            searchPanel.add(searchPositionField, searchGbc);

            int result = JOptionPane.showConfirmDialog(
                frame,
                searchPanel,
                "Search Applications",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );

            if (result != JOptionPane.OK_OPTION)
            {
                return;
            }

            String company = searchCompanyField.getText().trim();
            String positionTitle = searchPositionField.getText().trim();

            if (company.isEmpty())
            {
                JOptionPane.showMessageDialog(
                    frame,
                    "Company is required to search.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            JobApplication foundApplication;

            if (positionTitle.isEmpty())
            {
                foundApplication =
                    applicationManager.findApplication(company);
            }
            else
            {
                foundApplication =
                    applicationManager.findApplication(
                        company,
                        positionTitle
                    );
            }

            if (foundApplication == null)
            {
                JOptionPane.showMessageDialog(
                    frame,
                    "No matching application was found.",
                    "Application Not Found",
                    JOptionPane.INFORMATION_MESSAGE
                );

                return;
            }

            applicationsList.setSelectedValue(
                foundApplication,
                true
            );
        });

        updateStatusButton.addActionListener(e -> {
            JobApplication selectedApplication =
                applicationsList.getSelectedValue();

            if (selectedApplication == null)
            {
                return;
            }

            JComboBox<String> newStatusComboBox =
                new JComboBox<>(new String[] {
                    "Applied",
                    "Interview",
                    "Offer",
                    "Rejected",
                    "Withdrawn"
                });

            newStatusComboBox.setSelectedItem(
                selectedApplication.getStatus()
            );

            int result = JOptionPane.showConfirmDialog(
                frame,
                newStatusComboBox,
                "Update Status",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );

            if (result != JOptionPane.OK_OPTION)
            {
                return;
            }

            String newStatus =
                (String) newStatusComboBox.getSelectedItem();

            selectedApplication.setStatus(newStatus);

            int selectedIndex =
                applicationsList.getSelectedIndex();

            applicationsListModel.set(
                selectedIndex,
                selectedApplication
            );

            applicationsList.setSelectedIndex(selectedIndex);

            selectedApplicationArea.setText(
                selectedApplication.getSummary()
            );

            selectedApplicationArea.setCaretPosition(0);
        });

        editNotesButton.addActionListener(e -> {
            JobApplication selectedApplication =
                applicationsList.getSelectedValue();

            if (selectedApplication == null)
            {
                return;
            }

            JTextArea editNotesArea = new JTextArea(
                selectedApplication.getNotes(),
                8,
                30
            );

            editNotesArea.setLineWrap(true);
            editNotesArea.setWrapStyleWord(true);

            JScrollPane editNotesScrollPane =
                new JScrollPane(editNotesArea);

            int result = JOptionPane.showConfirmDialog(
                frame,
                editNotesScrollPane,
                "Edit Notes",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );

            if (result != JOptionPane.OK_OPTION)
            {
                return;
            }

            selectedApplication.setNotes(
                editNotesArea.getText().trim()
            );

            selectedApplicationArea.setText(
                selectedApplication.getSummary()
            );

            selectedApplicationArea.setCaretPosition(0);
        });

        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
}