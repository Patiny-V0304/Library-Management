package com.ptit.librarymanagement.presentation.dialog;




import com.ptit.librarymanagement.presentation.dialog.component.ButtonCustom;
import com.ptit.librarymanagement.presentation.dialog.component.HeaderTitle;
import com.ptit.librarymanagement.presentation.dialog.component.InputDate;
import com.ptit.librarymanagement.presentation.dialog.component.InputForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ReplaceCategoryDialog extends JDialog {

    private com.ptit.librarymanagement.presentation.dialog.component.HeaderTitle titlePage;
    private JPanel main, bottom;

    private com.ptit.librarymanagement.presentation.dialog.component.ButtonCustom btnAdd, btnEdit, btnExit;
    private com.ptit.librarymanagement.presentation.dialog.component.InputForm name;
    private com.ptit.librarymanagement.presentation.dialog.component.InputForm phone;
    private com.ptit.librarymanagement.presentation.dialog.component.InputForm email;
    private com.ptit.librarymanagement.presentation.dialog.component.InputForm location;

    private ButtonGroup gender;
    private JRadioButton male;
    private JRadioButton female;

    private InputDate jcBd;

    public ReplaceCategoryDialog(Frame owner, boolean modal, String title, String type) {
        super(owner, title, modal);
        init(title, type);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void init(String title, String type) {

        this.setSize(new Dimension(370, 260));
        this.setLayout(new BorderLayout(0, 0));

        titlePage = new HeaderTitle(title.toUpperCase());

        // MAIN PANEL
        main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBackground(Color.white);

        name = new com.ptit.librarymanagement.presentation.dialog.component.InputForm("Tên nhà xuất bản");
        location = new com.ptit.librarymanagement.presentation.dialog.component.InputForm("Địa chỉ"); // field mới
        email = new com.ptit.librarymanagement.presentation.dialog.component.InputForm("Email");
        phone = new InputForm("Số điện thoại");

        // ADD TO MAIN
        main.add(name);
//        main.add(location);   // thêm field mới
//        main.add(email);
//        main.add(phone);

        // DATE (nếu muốn giữ)
        jcBd = new InputDate("Ngày sinh");
        // main.add(jcBd); // nếu cần

        // BOTTOM PANEL
        bottom = new JPanel(new FlowLayout());
        bottom.setBackground(Color.white);

        btnAdd = new com.ptit.librarymanagement.presentation.dialog.component.ButtonCustom("Thêm người dùng", "success", 14);
        btnEdit = new com.ptit.librarymanagement.presentation.dialog.component.ButtonCustom("Lưu thông tin", "success", 14);
        btnExit = new ButtonCustom("Thoát", "danger", 14);

        btnExit.addActionListener((ActionEvent e) -> dispose());

        switch (type) {
            case "create" -> bottom.add(btnAdd);
            case "update" -> bottom.add(btnEdit);
            case "detail" -> {
//                makeReadOnly();
//                firstName2.setDisable(); // disable luôn field mới
            }
        }

        bottom.add(btnExit);

        this.add(titlePage, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);
        this.add(bottom, BorderLayout.SOUTH);
    }


    // -------------- MAIN TEST UI -------------------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new ReplaceCategoryDialog(null, true,
                        "Thêm nhân viên",
                        "update")
        );
    }
}