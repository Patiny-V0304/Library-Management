package com.ptit.librarymanagement.presentation.viewpanel;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    public HomePanel() {
        this.setLayout(null);

        JLabel lblNewLabel = new JLabel("View trang chủ");
        lblNewLabel.setForeground(new Color(255, 20, 147));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(75, 41, 945, 185);
        this.add(lblNewLabel);

        this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));

    }

}
