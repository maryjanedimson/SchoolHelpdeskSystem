/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.company.schoolhelpdesksystem;

import javax.swing.SwingUtilities;

/**
 *
 * @author User
 */
public class SchoolHelpdeskSystem {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}
