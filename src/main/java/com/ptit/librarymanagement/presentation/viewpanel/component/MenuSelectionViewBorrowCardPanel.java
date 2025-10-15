package com.ptit.librarymanagement.presentation.viewpanel.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;


public class MenuSelectionViewBorrowCardPanel extends JPanel {
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public MenuSelectionViewBorrowCardPanel (JButton button1, JButton button2, JButton button3) {
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;


    }


    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }
}
