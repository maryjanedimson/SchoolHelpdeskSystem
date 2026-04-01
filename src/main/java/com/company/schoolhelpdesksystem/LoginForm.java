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
        // Bring the login window to front for visibility
        setAlwaysOnTop(true);
        setAlwaysOnTop(false);
    }

    private void initComponents() {
        setTitle("School Helpdesk - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel root = new JPanel(new BorderLayout());

        // Left side (form)
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(500, 600));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        JLabel lblLoginTitle = new JLabel("Login");
        lblLoginTitle.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblLoginTitle.setForeground(new Color(33, 37, 41));
        lblLoginTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        leftPanel.add(lblLoginTitle);
        leftPanel.add(Box.createVerticalStrut(50));

        txtUsername = createField("Username");
        txtPassword = createPasswordField("Password");

        leftPanel.add(txtUsername);
        leftPanel.add(Box.createVerticalStrut(25));
        leftPanel.add(txtPassword);
        leftPanel.add(Box.createVerticalStrut(35));

        JLabel lblForgot = new JLabel("Forgot Password?");
        lblForgot.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblForgot.setForeground(new Color(102, 102, 102));
        lblForgot.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblForgot.setCursor(new Cursor(Cursor.HAND_CURSOR));
        leftPanel.add(lblForgot);
        leftPanel.add(Box.createVerticalStrut(25));

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(89, 33, 242));
        btnLogin.setFocusPainted(false);
        btnLogin.setBorder(BorderFactory.createEmptyBorder(12, 40, 12, 40));
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(73, 19, 242));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(89, 33, 242));
            }
        });

        leftPanel.add(btnLogin);
        leftPanel.add(Box.createVerticalStrut(25));

        JLabel lblSignUp = new JLabel("Don't have an account? Sign Up");
        lblSignUp.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblSignUp.setForeground(new Color(102, 102, 102));
        lblSignUp.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(lblSignUp);

        // Right side (graphics)
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(89, 33, 242));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setPreferredSize(new Dimension(500, 600));

        // Add spacing
        rightPanel.add(Box.createVerticalStrut(40));

        // School books icon
        JLabel books1 = new JLabel("📖");
        books1.setFont(new Font("Arial", Font.PLAIN, 50));
        books1.setHorizontalAlignment(SwingConstants.CENTER);
        books1.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(books1);

        // Main heading
        JLabel helpdeskText = new JLabel("School Helpdesk");
        helpdeskText.setFont(new Font("Segoe UI", Font.BOLD, 48));
        helpdeskText.setForeground(Color.WHITE);
        helpdeskText.setHorizontalAlignment(SwingConstants.CENTER);
        helpdeskText.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(helpdeskText);

        // Tagline
        JLabel tagline = new JLabel("Manage Issues Efficiently");
        tagline.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        tagline.setForeground(new Color(200, 200, 255));
        tagline.setHorizontalAlignment(SwingConstants.CENTER);
        tagline.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(Box.createVerticalStrut(30));
        rightPanel.add(tagline);

        // School icons row
        rightPanel.add(Box.createVerticalStrut(40));

        JPanel iconsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        iconsPanel.setBackground(new Color(89, 33, 242));
        iconsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel studentIcon = new JLabel("👨‍🎓");
        studentIcon.setFont(new Font("Arial", Font.PLAIN, 45));
        iconsPanel.add(studentIcon);

        JLabel booksIcon = new JLabel("📚");
        booksIcon.setFont(new Font("Arial", Font.PLAIN, 45));
        iconsPanel.add(booksIcon);

        JLabel helpIcon = new JLabel("🎓");
        helpIcon.setFont(new Font("Arial", Font.PLAIN, 45));
        iconsPanel.add(helpIcon);

        rightPanel.add(iconsPanel);

        root.add(leftPanel, BorderLayout.WEST);
        root.add(rightPanel, BorderLayout.EAST);

        add(root);
    }

    private JTextField createField(String placeholder) {
        JTextField field = new JTextField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBackground(new Color(245, 245, 245));
        field.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        field.setText(placeholder);
        field.setForeground(new Color(150, 150, 150));
        field.setPreferredSize(new Dimension(350, 50));
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(new Color(33, 37, 41));
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(new Color(150, 150, 150));
                }
            }
        });

        return field;
    }

    private JPasswordField createPasswordField(String placeholder) {
        JPasswordField field = new JPasswordField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBackground(new Color(245, 245, 245));
        field.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        field.setEchoChar((char)0);
        field.setText(placeholder);
        field.setForeground(new Color(150, 150, 150));
        field.setPreferredSize(new Dimension(350, 50));
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (new String(field.getPassword()).equals(placeholder)) {
                    field.setText("");
                    field.setEchoChar('\u2022');
                    field.setForeground(new Color(33, 37, 41));
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (new String(field.getPassword()).isEmpty()) {
                    field.setEchoChar((char)0);
                    field.setText(placeholder);
                    field.setForeground(new Color(150, 150, 150));
                }
            }
        });

        return field;
    }

    private void btnLoginActionPerformed(ActionEvent evt) {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || username.equals("Username") || password.isEmpty() || password.equals("Password")) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password.", "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Dummy auth flow
        if (username.equals("admin") && password.equals("admin123")) {
            new AdminDashboard().setVisible(true);
            this.dispose();
        } else {
            new UserDashboard().setVisible(true);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        System.out.println("LoginForm main: start");
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}