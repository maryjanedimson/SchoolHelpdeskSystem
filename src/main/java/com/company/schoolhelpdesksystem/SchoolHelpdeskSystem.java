/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.company.schoolhelpdesksystem;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author User
 */
public class SchoolHelpdeskSystem {

    public static void main(String[] args) {
        System.out.println("SchoolHelpdeskSystem main start");

        // Test MongoDB connection before starting the app
        if (!DatabaseConnection.testConnection()) {
            System.err.println("Warning: MongoDB connection failed - starting UI anyway for local testing.");
            JOptionPane.showMessageDialog(null,
                "Failed to connect to MongoDB. UI continues in demo mode.",
                "Connection Warning",
                JOptionPane.WARNING_MESSAGE);
        } else {
            System.out.println("MongoDB connection OK");
        }

        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}
