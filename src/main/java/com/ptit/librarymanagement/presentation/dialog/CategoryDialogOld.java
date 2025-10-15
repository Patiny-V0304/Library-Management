package com.ptit.librarymanagement.presentation.dialog;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Getter
public class CategoryDialogOld extends JDialog /*implements ActionListener*/ {

    private JPanel pnmain, pnbottom;
    private JButton btnThem, btnCapNhat, btnHuyBo;
    private JTextField categoryField;

    private boolean isUpdate = false;

    public CategoryDialogOld(JFrame owner, String title, boolean modal, String type) {
        super(owner, title, modal);
        if (type.equals("update")) isUpdate = true;
        initComponents(title, type);
    }

    public void initComponents(String title, String type) {
        this.setSize(new Dimension(450, 200)); // giảm chiều cao
        this.setLayout(new BorderLayout(0, 0));

        JLabel lblTitle = new JLabel(title.toUpperCase(), SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBorder(new EmptyBorder(10, 0, 10, 0));

        pnmain = new JPanel(new GridLayout(1, 2, 15, 10)); // còn 1 dòng
        pnmain.setBorder(new EmptyBorder(20, 20, 20, 20));
        pnmain.setBackground(Color.white);

        pnmain.add(new JLabel("Tên danh mục:"));
        categoryField = new JTextField();
        pnmain.add(categoryField);

        pnbottom = new JPanel(new FlowLayout());
        pnbottom.setBorder(new EmptyBorder(10, 0, 10, 0));
        pnbottom.setBackground(Color.white);

        btnThem = new JButton("Thêm danh mục");
        btnCapNhat = new JButton("Lưu thông tin");
        btnHuyBo = new JButton("Hủy bỏ");

//        btnThem.addActionListener(this);
//        btnCapNhat.addActionListener(this);
//        btnHuyBo.addActionListener(this);

        if (!isUpdate) {
            pnbottom.add(btnThem);
        } else {
            pnbottom.add(btnCapNhat);
        }
        pnbottom.add(btnHuyBo);

        this.add(lblTitle, BorderLayout.NORTH);
        this.add(pnmain, BorderLayout.CENTER);
        this.add(pnbottom, BorderLayout.SOUTH);

        this.setLocationRelativeTo(null);

    }


}
