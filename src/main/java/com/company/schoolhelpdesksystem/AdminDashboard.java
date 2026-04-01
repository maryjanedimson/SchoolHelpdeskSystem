package com.company.schoolhelpdesksystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

/**
 * Admin Dashboard for the School Helpdesk System
 */
public class AdminDashboard extends JFrame {

    private JTable tblAllTickets;
    private DefaultTableModel tableModel;
    private JButton btnResolve;

    public AdminDashboard() {
        initComponents();
        loadAllTickets();
    }

    private void initComponents() {
        setTitle("Admin Dashboard - School Helpdesk System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        // Label
        JLabel lblAllTickets = new JLabel("All Tickets");
        lblAllTickets.setBounds(50, 20, 150, 25);
        lblAllTickets.setFont(lblAllTickets.getFont().deriveFont(16.0f));
        add(lblAllTickets);

        // Table
        String[] columnNames = {"Ticket ID", "User ID", "Department", "Issue", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tblAllTickets = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblAllTickets);
        scrollPane.setBounds(50, 60, 600, 200);
        add(scrollPane);

        // Resolve Button
        btnResolve = new JButton("Mark as Resolved");
        btnResolve.setBounds(50, 280, 150, 30);
        btnResolve.addActionListener(this::btnResolveActionPerformed);
        add(btnResolve);
    }

    private void btnResolveActionPerformed(ActionEvent evt) {
        int selectedRow = tblAllTickets.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a ticket to resolve.");
            return;
        }

        // Get ticket ID from table
        String ticketIdStr = (String) tableModel.getValueAt(selectedRow, 0);
        ObjectId ticketId = new ObjectId(ticketIdStr);

        // Update in database
        TicketService ticketService = new TicketService();
        ticketService.updateTicketStatus(ticketId, "Resolved");

        // Update table
        tableModel.setValueAt("Resolved", selectedRow, 4);
        JOptionPane.showMessageDialog(this, "Ticket marked as resolved.");
    }

    private void loadAllTickets() {
        tableModel.setRowCount(0); // Clear existing rows
        TicketService ticketService = new TicketService();
        List<Ticket> tickets = ticketService.getAllTickets();
        for (Ticket ticket : tickets) {
            tableModel.addRow(new Object[]{
                ticket.getId().toString(),
                ticket.getUserId(),
                ticket.getDepartment(),
                ticket.getIssue(),
                ticket.getStatus()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminDashboard().setVisible(true));
    }
}