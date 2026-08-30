package dev.stevenscoville.jobtracker.ui;

import javax.swing.JFrame;

public class JobApplicationTrackerGUI {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Job Application Tracker");

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
