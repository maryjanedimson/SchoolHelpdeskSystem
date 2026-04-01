package com.company.schoolhelpdesksystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

/**
 * User Dashboard for the School Helpdesk System
 */
public class UserDashboard extends JFrame {

    private JButton btnSubmitIssue;
    private JTable tblTickets;
    private DefaultTableModel tableModel;

    public UserDashboard() {
        initComponents();
        loadTickets();
    }

    private void initComponents() {
        setTitle("User Dashboard - School Helpdesk System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        // Label
        JLabel lblYourTickets = new JLabel("Your Tickets");
        lblYourTickets.setBounds(50, 20, 150, 25);
        lblYourTickets.setFont(lblYourTickets.getFont().deriveFont(16.0f));
        add(lblYourTickets);

        // Table
        String[] columnNames = {"Ticket ID", "Department", "Issue", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tblTickets = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblTickets);
        scrollPane.setBounds(50, 60, 500, 200);
        add(scrollPane);

        // Submit Issue Button
        btnSubmitIssue = new JButton("Submit Issue");
        btnSubmitIssue.setBounds(50, 280, 150, 30);
        btnSubmitIssue.addActionListener(this::btnSubmitIssueActionPerformed);
        add(btnSubmitIssue);
    }

    private void btnSubmitIssueActionPerformed(ActionEvent evt) {
        new SubmitIssueForm().setVisible(true);
        // Don't dispose, user might want to go back
        // TODO: Refresh table after submitting
    }

    private void loadTickets() {
        tableModel.setRowCount(0); // Clear existing rows
        TicketService ticketService = new TicketService();
        List<Ticket> tickets = ticketService.getTicketsByUser("user1"); // TODO: Get actual userId
        for (Ticket ticket : tickets) {
            tableModel.addRow(new Object[]{
                ticket.getId().toString(),
                ticket.getDepartment(),
                ticket.getIssue(),
                ticket.getStatus()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserDashboard().setVisible(true));
    }
}