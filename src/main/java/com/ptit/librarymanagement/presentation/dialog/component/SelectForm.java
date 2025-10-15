package com.ptit.librarymanagement.presentation.dialog.component;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Getter
public class SelectForm<T> extends JPanel {
    private JLabel lblTitle;
    private JComboBox<T> cbb;
    private final Function<T, String> toDisplay; // chuyển T -> String hiển thị

    /**
     * Constructor với mảng items
     * @param title text label
     * @param items mảng T
     * @param toDisplay function chuyển T -> String hiển thị
     */
    public SelectForm(String title, T[] items, Function<T, String> toDisplay) {
        this.toDisplay = Objects.requireNonNull(toDisplay);
        initUi(title);
        cbb = new JComboBox<>(items);
        setRenderer();
        this.add(cbb);
    }

    /**
     * Constructor với List items
     */
    public SelectForm(String title, List<T> items, Function<T, String> toDisplay) {
        this(title, items.toArray((T[]) new Object[0]), toDisplay);
    }

    private void initUi(String title) {
        this.setLayout(new GridLayout(2, 1));
        this.setBackground(Color.white);
        this.setBorder(new EmptyBorder(0, 10, 5, 10));

        lblTitle = new JLabel(title);
        this.add(lblTitle);
    }

    private void setRenderer() {
        cbb.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                String text = value == null ? "" : toDisplay.apply((T) value);
                return super.getListCellRendererComponent(list, text, index, isSelected, cellHasFocus);
            }
        });
    }

    public void setItems(T[] items) {
        cbb.setModel(new DefaultComboBoxModel<>(items));
    }

    public void setItems(List<T> items) {
        cbb.setModel(new DefaultComboBoxModel<>(items.toArray((T[]) new Object[0])));
    }

    public T getSelectedItem() {
        return (T) cbb.getSelectedItem();
    }

    public int getSelectedIndex() {
        return cbb.getSelectedIndex();
    }

    public void setSelectedIndex(int i) {
        cbb.setSelectedIndex(i);
    }

    public void setSelectedItem(T item) {
        cbb.setSelectedItem(item);
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(JLabel lblTitle) {
        this.lblTitle = lblTitle;
    }

    public JComboBox<T> getCbb() {
        return cbb;
    }

    public void setCbb(JComboBox<T> cbb) {
        this.cbb = cbb;
        setRenderer();
    }

    public void setDisable() {
        cbb.setEnabled(false);
    }
}
