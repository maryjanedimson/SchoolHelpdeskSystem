package com.company.schoolhelpdesksystem;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Submit Issue Form for the School Helpdesk System
 */
public class SubmitIssueForm extends JFrame {

    private JComboBox<String> cmbDepartment;
    private JTextArea txtIssue;
    private JButton btnSubmit;

    public SubmitIssueForm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Submit Issue - School Helpdesk System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        // Select Department Label
        JLabel lblDepartment = new JLabel("Select Department:");
        lblDepartment.setBounds(50, 20, 150, 25);
        add(lblDepartment);

        // Department ComboBox
        cmbDepartment = new JComboBox<>(new String[]{"IT", "Maintenance", "Registrar"});
        cmbDepartment.setBounds(50, 50, 150, 25);
        add(cmbDepartment);

        // Describe Issue Label
        JLabel lblIssue = new JLabel("Describe Your Issue:");
        lblIssue.setBounds(50, 90, 150, 25);
        add(lblIssue);

        // Issue TextArea
        txtIssue = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(txtIssue);
        scrollPane.setBounds(50, 120, 300, 100);
        add(scrollPane);

        // Submit Button
        btnSubmit = new JButton("Submit Ticket");
        btnSubmit.setBounds(50, 240, 150, 30);
        btnSubmit.addActionListener(this::btnSubmitActionPerformed);
        add(btnSubmit);
    }

    private void btnSubmitActionPerformed(ActionEvent evt) {
        String department = (String) cmbDepartment.getSelectedItem();
        String issue = txtIssue.getText();
        if (issue.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please describe your issue.");
            return;
        }
        // For now, just show a message
        JOptionPane.showMessageDialog(this, "Ticket submitted to " + department + " department.");
        // Later, add to database or update table
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SubmitIssueForm().setVisible(true));
    }
}