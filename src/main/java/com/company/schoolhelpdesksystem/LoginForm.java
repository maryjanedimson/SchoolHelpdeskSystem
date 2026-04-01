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
        setTitle("School Helpdesk - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(860, 520);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel root = new JPanel(new BorderLayout());

        // Left side (form)
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(420, 520));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JLabel lblLoginTitle = new JLabel("Login");
        lblLoginTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblLoginTitle.setForeground(new Color(33, 37, 41));
        lblLoginTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(Box.createVerticalStrut(70));
        leftPanel.add(lblLoginTitle);
        leftPanel.add(Box.createVerticalStrut(40));

        txtUsername = createField("Username");
        txtPassword = createPasswordField("Password");

        leftPanel.add(txtUsername);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(txtPassword);
        leftPanel.add(Box.createVerticalStrut(15));

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
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(new Color(89, 33, 242));

        JLabel illustration = new JLabel();
        illustration.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/school_helpdesk_illustration.png")).getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
        illustration.setHorizontalAlignment(SwingConstants.CENTER);
        rightPanel.add(illustration, BorderLayout.CENTER);

        root.add(leftPanel, BorderLayout.WEST);
        root.add(rightPanel, BorderLayout.EAST);

        add(root);
    }

    private JTextField createField(String placeholder) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 25));

        JTextField field = new JTextField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        field.setBackground(new Color(248, 249, 250));
        field.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        field.setText(placeholder);
        field.setForeground(new Color(140, 140, 140));

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
                    field.setForeground(new Color(140, 140, 140));
                }
            }
        });

        return field;
    }

    private JPasswordField createPasswordField(String placeholder) {
        JPasswordField field = new JPasswordField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        field.setBackground(new Color(248, 249, 250));
        field.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        field.setEchoChar((char)0);
        field.setText(placeholder);
        field.setForeground(new Color(140, 140, 140));

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
                    field.setForeground(new Color(140, 140, 140));
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
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}