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
        // Test MongoDB connection before starting the app
        if (!DatabaseConnection.testConnection()) {
            JOptionPane.showMessageDialog(null,
                "Failed to connect to MongoDB. Please check your connection string in DatabaseConnection.java",
                "Connection Error",
                JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}
