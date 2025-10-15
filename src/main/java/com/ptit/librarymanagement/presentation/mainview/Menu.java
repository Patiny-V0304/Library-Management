package com.ptit.librarymanagement.presentation.mainview;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    private JLabel libraryLabel;
    private JLabel titleLabel;
    private JLabel homeLabel;
    private JLabel bookLabel;
    private JLabel readerLabel;
    private JLabel categoryLabel;
    private JLabel authorLabel;
    private JLabel publisherLabel;
    private JLabel bookShelveLabel;
    private JLabel recycleBinLabel;
    private JLabel logoutLabel;
    private JLabel staffLabel;
    private JLabel borrowSlipLabel;

    public Menu() {
        this.setBounds(0, 33, 187, 734);
        this.setBackground(new Color(64, 64, 64));
        this.setLayout(null);
        initLabelMenu();
    }

    private void initLabelMenu () {
        titleLabel = new JLabel("  Thư Viện");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        titleLabel.setIcon(new ImageIcon("img\\iconthuvien.png"));
        titleLabel.setBounds(0, 13, 187, 40);
        this.add(titleLabel);

        libraryLabel = new JLabel("");
        libraryLabel.setBackground(new Color(255, 127, 80));
        libraryLabel.setOpaque(true);
        libraryLabel.setIcon(null);
        libraryLabel.setBounds(0, 0, 187, 62);
        this.add(libraryLabel);
        //-------------//

        homeLabel = new JLabel("   Trang chủ");
        homeLabel.setBackground(new Color(64, 64, 64));
        homeLabel.setOpaque(true);
        homeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        homeLabel.setIcon(new ImageIcon(
                "C:\\Users\\ASUS\\Pictures\\14-145167_home-icon-home-icon-png-green-removebg-preview.png"));
        homeLabel.setForeground(Color.WHITE);
        homeLabel.setBounds(0, 74, 187, 46);

//        this.add(homeLabel);

        bookLabel = new JLabel("   Sách");
        bookLabel.setIcon(new ImageIcon("img\\bookicon.png"));
        bookLabel.setBackground(new Color(64, 64, 64));
        bookLabel.setOpaque(true);
        bookLabel.setForeground(Color.WHITE);
        bookLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        bookLabel.setBounds(0, 133, 187, 46);

//        this.add(bookLabel);

        readerLabel = new JLabel("   Độc giả");
        readerLabel.setIcon(new ImageIcon("img\\Readericon.png"));
        readerLabel.setBackground(new Color(64, 64, 64));
        readerLabel.setOpaque(true);
        readerLabel.setForeground(Color.WHITE);
        readerLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        readerLabel.setBounds(0, 192, 187, 46);

        this.add(readerLabel);

        categoryLabel = new JLabel("   Danh mục");
        categoryLabel.setIcon(new ImageIcon("img\\Tacgia.png"));
        categoryLabel.setBackground(new Color(64, 64, 64));
        categoryLabel.setOpaque(true);
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        categoryLabel.setBounds(0, 251, 187, 46);

        this.add(categoryLabel);

        authorLabel = new JLabel("   Tác giả");
        authorLabel.setIcon(new ImageIcon("img\\Company.png"));
        authorLabel.setBackground(new Color(64, 64, 64));
        authorLabel.setOpaque(true);
        authorLabel.setForeground(Color.WHITE);
        authorLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        authorLabel.setBounds(0, 310, 187, 46);

        this.add(authorLabel);

        publisherLabel = new JLabel("   Nhà xuất bản");
        publisherLabel.setIcon(new ImageIcon("img\\Staff.png"));
        publisherLabel.setBackground(new Color(64, 64, 64));
        publisherLabel.setOpaque(true);
        publisherLabel.setForeground(Color.WHITE);
        publisherLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        publisherLabel.setBounds(0, 369, 187, 46);

        this.add(publisherLabel);

        bookShelveLabel = new JLabel("   Kệ sách");
        bookShelveLabel.setIcon(new ImageIcon("img\\Note.png"));
        bookShelveLabel.setOpaque(true);
        bookShelveLabel.setForeground(Color.WHITE);
        bookShelveLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        bookShelveLabel.setBackground(Color.DARK_GRAY);
        bookShelveLabel.setBounds(0, 428, 187, 46);
        this.add(bookShelveLabel);

        borrowSlipLabel = new JLabel("   Phiếu mượn");
        borrowSlipLabel.setIcon(new ImageIcon("img\\phieunhap.png"));
        borrowSlipLabel.setOpaque(true);
        borrowSlipLabel.setForeground(Color.WHITE);
        borrowSlipLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        borrowSlipLabel.setBackground(Color.DARK_GRAY);
        borrowSlipLabel.setBounds(0, 487, 187, 46);
        this.add(borrowSlipLabel);

        staffLabel = new JLabel("   Nhân viên");
        staffLabel.setIcon(new ImageIcon("img\\Combo Chart.png"));
        staffLabel.setOpaque(true);
        staffLabel.setForeground(Color.WHITE);
        staffLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        staffLabel.setBackground(Color.DARK_GRAY);
        staffLabel.setBounds(0, 542, 187, 46);
        this.add(staffLabel);

        recycleBinLabel = new JLabel("   Thùng rác");
        recycleBinLabel.setIcon(new ImageIcon("img\\chungpng.png"));
        recycleBinLabel.setOpaque(true);
        recycleBinLabel.setForeground(Color.WHITE);
        recycleBinLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        recycleBinLabel.setBackground(Color.DARK_GRAY);
        recycleBinLabel.setBounds(0, 601, 187, 46);
        this.add(recycleBinLabel);

        logoutLabel = new JLabel("   Đăng xuất");
       // logoutLabel.setIcon(new ImageIcon("img\\Exit.png"));
        logoutLabel.setOpaque(true);
        logoutLabel.setForeground(Color.WHITE);
        logoutLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        logoutLabel.setBackground(Color.DARK_GRAY);
        logoutLabel.setBounds(0, 675, 187, 46);
        this.add(logoutLabel);




    }

    public JLabel getLibraryLabel() {
        return libraryLabel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JLabel getHomeLabel() {
        return homeLabel;
    }

    public JLabel getBookLabel() {
        return bookLabel;
    }

    public JLabel getReaderLabel() {
        return readerLabel;
    }

    public JLabel getCategoryLabel() {
        return categoryLabel;
    }

    public JLabel getAuthorLabel() {
        return authorLabel;
    }

    public JLabel getPublisherLabel() {
        return publisherLabel;
    }

    public JLabel getBookShelveLabel() {
        return bookShelveLabel;
    }

    public JLabel getRecycleBinLabel() {
        return recycleBinLabel;
    }

    public JLabel getLogoutLabel() {
        return logoutLabel;
    }

    public JLabel getStaffLabel() {
        return staffLabel;
    }

    public JLabel getBorrowSlipLabel() {
        return borrowSlipLabel;
    }

}
