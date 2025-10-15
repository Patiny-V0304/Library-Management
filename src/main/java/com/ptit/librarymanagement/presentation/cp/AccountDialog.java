package com.ptit.librarymanagement.presentation.cp;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class AccountDialog extends JDialog {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel changeUserNamePanel;
    private JPanel changePasswordPanel;

    public AccountDialog(JFrame owner, JPanel changeUserNamePanel, JPanel changePasswordPanel) {
        super(owner, "Quản lý tài khoản", true); // true = modal
        this.changeUserNamePanel = changeUserNamePanel;
        this.changePasswordPanel = changePasswordPanel;

        initComponent();
        pack();
        setLocationRelativeTo(owner); // căn giữa theo frame cha
    }

    private void initComponent() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 300));

        // ======= MENU BAR =======
        JMenuBar menuBar = new JMenuBar();

        JButton btnView1 = new JButton("Đổi tên đăng nhập");
        JButton btnView2 = new JButton("Đổi mật khẩu");

        menuBar.add(btnView1);
        menuBar.add(btnView2);

        add(menuBar, BorderLayout.NORTH);

        // ======= CARD PANEL =======
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // View 1
        changeUserNamePanel.setBackground(Color.CYAN);

        // View 2
        changePasswordPanel.setBackground(Color.ORANGE);

        // Add vào CardLayout
        cardPanel.add(changeUserNamePanel, "VIEW_1");
        cardPanel.add(changePasswordPanel, "VIEW_2");

        add(cardPanel, BorderLayout.CENTER);

        // ======= EVENTS =======
        btnView1.addActionListener(e -> cardLayout.show(cardPanel, "VIEW_1"));
        btnView2.addActionListener(e -> cardLayout.show(cardPanel, "VIEW_2"));
    }

    // Test nhanh dialog
    public static void main(String[] args) {
        FlatLightLaf.setup();

        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Form đổi tên"));

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Form đổi mật khẩu"));

        new AccountDialog(frame, panel1, panel2).setVisible(true);
    }
}
