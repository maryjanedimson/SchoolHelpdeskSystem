package com.company.schoolhelpdesksystem;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Login Form for the School Helpdesk System
 */
public class LoginForm extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginForm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Login - School Helpdesk System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(null);

        // Username Label
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 50, 100, 25);
        add(lblUsername);

        // Username TextField
        txtUsername = new JTextField();
        txtUsername.setBounds(150, 50, 200, 25);
        add(txtUsername);

        // Password Label
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 100, 100, 25);
        add(lblPassword);

        // Password Field
        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 100, 200, 25);
        add(txtPassword);

        // Login Button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 150, 100, 30);
        btnLogin.addActionListener(this::btnLoginActionPerformed);
        add(btnLogin);
    }

    private void btnLoginActionPerformed(ActionEvent evt) {
        // For now, just open UserDashboard
        // Later add logic for Admin vs User based on credentials
        new UserDashboard().setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}