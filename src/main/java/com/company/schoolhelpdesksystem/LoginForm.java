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

package com.company.schoolhelpdesksystem;

import javax.swing.*;
import java.awt.*;
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
        setTitle("School Helpdesk System - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel with background color
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(240, 248, 255)); // Alice Blue
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Title label
        JLabel lblTitle = new JLabel("Welcome to Helpdesk", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(25, 25, 112)); // Midnight Blue
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblTitle);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Username panel
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usernamePanel.setBackground(new Color(240, 248, 255));
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        lblUsername.setPreferredSize(new Dimension(80, 25));
        txtUsername = new JTextField(20);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        usernamePanel.add(lblUsername);
        usernamePanel.add(txtUsername);
        mainPanel.add(usernamePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // Password panel
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.setBackground(new Color(240, 248, 255));
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        lblPassword.setPreferredSize(new Dimension(80, 25));
        txtPassword = new JPasswordField(20);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordPanel.add(lblPassword);
        passwordPanel.add(txtPassword);
        mainPanel.add(passwordPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 25)));

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(240, 248, 255));
        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.setBackground(new Color(25, 25, 112)); // Midnight Blue
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setPreferredSize(new Dimension(120, 35));
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        // Add hover effect
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(0, 0, 139)); // Dark Blue
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(25, 25, 112)); // Midnight Blue
            }
        });

        buttonPanel.add(btnLogin);
        mainPanel.add(buttonPanel);

        add(mainPanel);
    }

    private void btnLoginActionPerformed(ActionEvent evt) {
        // For now, just open UserDashboard
        // Later add logic for Admin vs User based on credentials
        new UserDashboard().setVisible(true);
        this.dispose();
    }
        // For now, just open UserDashboard
        // Later add logic for Admin vs User based on credentials
        new UserDashboard().setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}