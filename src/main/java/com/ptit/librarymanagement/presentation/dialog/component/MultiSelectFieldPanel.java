package com.ptit.librarymanagement.presentation.dialog.component;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Function;

/**
 * Generic MultiSelectFieldPanel<T>
 * - Hiển thị label + MultiSelectForm<T>
 * - API trả về Set<T> giữ thứ tự chèn (LinkedHashSet)
 */
@Getter
public class MultiSelectFieldPanel<T> extends JPanel {

    private JLabel label;
    private MultiSelectForm<T> field; // generic MultiSelectForm
    private final Function<T, String> toDisplay;

    /**
     * Constructor với mảng items
     *
     * @param labelText  text cho label
     * @param items      mảng items (T[])
     * @param toDisplay  function chuyển T -> String để hiển thị
     */
    public MultiSelectFieldPanel(String labelText, T[] items, Function<T, String> toDisplay) {
        this.toDisplay = Objects.requireNonNull(toDisplay);

        initUi(labelText);
        this.field = new MultiSelectForm<>(labelText, items, toDisplay);
        field.setBackground(Color.WHITE);
        field.setBorder(new EmptyBorder(0, 10, 5, 10)); // màu viền xám giống InputForm
        field.setOpaque(true);
        this.add(field);
    }


    /**
     * Constructor với List items
     *
     * @param labelText  text cho label
     * @param items      List<T>
     * @param toDisplay  function chuyển T -> String để hiển thị
     */
    public MultiSelectFieldPanel(String labelText, List<T> items, Function<T, String> toDisplay) {
        this.toDisplay = Objects.requireNonNull(toDisplay);
        initUi(labelText);
        this.field = new MultiSelectForm<>(labelText, items, toDisplay);



        field.setOpaque(true);
        this.add(field);
    }

    private void initUi(String labelText) {
        this.setLayout(new GridLayout(2, 1));
        this.setBackground(Color.white);
        this.setBorder(new EmptyBorder(0, 10, 5, 10));
        this.setPreferredSize(new Dimension(100, 100));

        label = new JLabel(labelText);
        this.add(label);
        // field sẽ được thêm sau khi khởi tạo trong constructor
    }

    /**
     * Lấy Set<T> đã chọn (giữ thứ tự chèn)
     */
    public Set<T> getSelectedItems() {
        List<T> list = field.getSelectedItems();
        return new LinkedHashSet<>(list);
    }

    /**
     * Set selected từ collection bên ngoài
     */
    public void setSelectedItems(Collection<T> items) {
        field.setSelectedItems(items);
    }

    /**
     * Thay toàn bộ items hiển thị (thay đổi nguồn dữ liệu)
     */
    public void setItems(T[] items) {
        // lưu các item đã chọn hiện tại
        Set<T> selected = getSelectedItems();
        // đổi danh sách item
        field.setItems(items);
        // chọn lại những item còn tồn tại
        field.setSelectedItems(selected);
    }

    public void setItems(List<T> items) {
        Set<T> selected = getSelectedItems();
        field.setItems(items);
        field.setSelectedItems(selected);
    }

    /**
     * Đổi tiêu đề label nếu cần
     */
    public void setLabelText(String text) {
        label.setText(text);
        // nếu muốn đổi title dialog cũng có thể gọi method trên field nếu bạn thêm
        // ví dụ: field.setDialogTitle(text);
    }


    // Ví dụ sử dụng:
    // MultiSelectFieldPanel<Author> panel = new MultiSelectFieldPanel<>("Tác giả", authorsList, Author::getName);
    // Set<Author> chosen = panel.getSelectedItems();
    // panel.setSelectedItems(Set.of(authorsList.get(0), authorsList.get(2)));
}
