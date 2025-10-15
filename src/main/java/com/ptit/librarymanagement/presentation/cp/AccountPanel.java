package com.ptit.librarymanagement.presentation.cp;



import com.formdev.flatlaf.FlatLightLaf;
import com.ptit.librarymanagement.dto.AccountDTO;
import com.ptit.librarymanagement.presentation.dialog.component.ButtonCustom;
import com.ptit.librarymanagement.presentation.dialog.component.HeaderTitle;
import com.ptit.librarymanagement.presentation.dialog.component.InputForm;
import lombok.Getter;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

@Getter
public class AccountPanel extends JPanel {

    private HeaderTitle titlePage;
    private JPanel mainPanel, bottomPanel;
    private ButtonCustom createButton, updateButton, cancelButton;
    private InputForm userNameInput;
    private InputForm oldPasswordInput;
    private InputForm newPasswordInput;
    private JTextField idInput;

    private Runnable onCancel;   // callback để đóng dialog hoặc đổi view

    public void setOnCancel(Runnable onCancel) {
        this.onCancel = onCancel;
    }

    public AccountDTO getObjectInField() {
        String id = idInput.getText();
        String oldPass = oldPasswordInput.getText();
        String newPass = newPasswordInput.getText();
        String userName = userNameInput.getText();

        return AccountDTO.builder()
                .id(id.isBlank() ? null : Integer.parseInt(id))
                .password(newPass)
                .userName(userName)
                .build();
    }

    public void setDefaultTextInField(AccountDTO accountDTO) {
        idInput.setText(String.valueOf(accountDTO.getId()));
        userNameInput.setText(accountDTO.getUserName());
    }

    public AccountPanel(String title, String type) {
        init(title, type);
    }

    public void init(String title, String type) {

        setLayout(new BorderLayout(0, 0));
        setBackground(Color.white);

        idInput = new JTextField("");

        titlePage = new HeaderTitle(title.toUpperCase());

        // MAIN PANEL
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.white);

        userNameInput = new InputForm("UserName");
        oldPasswordInput = new InputForm("Mật khẩu cũ");
        newPasswordInput = new InputForm("Mật khẩu mới");

        // BOTTOM PANEL
        bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.setBackground(Color.white);

        createButton = new ButtonCustom("Thêm người dùng", "success", 14);
        updateButton = new ButtonCustom("Lưu thông tin", "success", 14);
        cancelButton = new ButtonCustom("Thoát", "danger", 14);

        cancelButton.addActionListener((ActionEvent e) -> {
            if (onCancel != null) onCancel.run();
        });

        switch (type) {
            case "changeUserName" -> {
                mainPanel.add(userNameInput);
                bottomPanel.add(updateButton);
            }
            case "changePassword" -> {
                mainPanel.add(oldPasswordInput);
                mainPanel.add(newPasswordInput);
                bottomPanel.add(updateButton);
            }
        }

        bottomPanel.add(cancelButton);

        add(titlePage, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // Test nhanh dưới dạng JFrame
    public static void main(String[] args) {
        FlatLightLaf.setup();



        AccountPanel panel1 = new AccountPanel("Sửa thông tin tài khoản", "changePassword");
        AccountPanel panel2 = new AccountPanel("Sửa thông tin tài khoản", "changeUserName");


        AccountDialog accountDialog = new AccountDialog(null, panel2, panel1);
        accountDialog.setVisible(true);
    }
}
