package com.ptit.librarymanagement.presentation.dialog.component;

import com.formdev.flatlaf.FlatLightLaf;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Generic MultiSelectForm<T>
 * - Hiển thị textField readonly (chuỗi các mục đã chọn, join bằng ", ")
 * - Khi click mở JDialog chứa JList<T> cho phép multi-selection
 * - Lưu selected as Set<T> (LinkedHashSet giữ thứ tự)
 * - Dùng Function<T,String> để hiển thị text cho từng item
 */
@Getter
@Setter
public class MultiSelectForm<T> extends JPanel {
    private HeaderTitle titlePanel;
    private JTextField textField;
    private JDialog dialog;
    private DefaultListModel<T> listModel;
    private JList<T> list;
    private JButton okButton, cancelButton, createButton;
    private T[] items;
    private final Function<T, String> toDisplay;
    // lưu trạng thái đã chọn (dùng để gán lại khi mở dialog nhiều lần)
    private final Set<T> selectedSet = new LinkedHashSet<>();



    /**
     * Constructor với mảng
     *
     * @param title     title (không dùng hiển thị trong panel hiện tại, chỉ dùng trong dialog)
     * @param items     mảng items (có thể null)
     * @param toDisplay function chuyển T -> String để hiển thị
     */
    public MultiSelectForm(String title, T[] items, Function<T, String> toDisplay) {
        this.items = items == null ? (T[]) new Object[0] : items;
        this.toDisplay = Objects.requireNonNull(toDisplay);
        createButton = new JButton("Thêm");
        titlePanel = new HeaderTitle(title);
        initUi(title);
    }

    /**
     * Constructor với List
     */
    public MultiSelectForm(String title, List<T> items, Function<T, String> toDisplay) {
        this(title, items == null ? null : (T[]) items.toArray(), toDisplay);
    }
    private boolean single = false;

    private void initUi(String title) {
        setLayout(new BorderLayout(5, 5));
        setBackground(Color.WHITE);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBackground(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        add(textField, BorderLayout.CENTER);

        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showListDialog(title);
            }
        });

    }

    private void showListDialog(String title) {
        // --- Thêm vào showListDialog trước khi dialog.add(buttonPanel, BorderLayout.SOUTH); ---
        JButton btnAdd = new JButton("Thêm");
        btnAdd.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(dialog, "Nhập tên mục mới:", "Thêm mục", JOptionPane.PLAIN_MESSAGE);
            if (input != null && !input.trim().isEmpty()) {
                // Tạo item mới: giả sử items là T[] (cần convert), bạn có thể cung cấp factory function nếu T không phải String
                // Ở đây tạm giả sử T là String để demo
                T newItem = (T) input.trim();

                // Cập nhật mảng items gốc
                List<T> tempList = new ArrayList<>(Arrays.asList(items));
                tempList.add(newItem);
                items = (T[]) tempList.toArray();

                // Cập nhật listModel và giữ selection
                listModel.addElement(newItem);
                applySelectedToList();
            }
        });
        if (dialog == null) {
            Window owner = SwingUtilities.getWindowAncestor(this);
            Frame frame = null;
            if (owner instanceof Frame) frame = (Frame) owner;

            dialog = new JDialog(frame, title == null ? "Chọn mục" : title, true);
            dialog.setSize(300, 400);
            dialog.setLayout(new BorderLayout(10, 10));
            dialog.setLocationRelativeTo(this);

            listModel = new DefaultListModel<>();
            for (T item : items) {
                listModel.addElement(item);
            }

            list = new JList<>(listModel);
            list.setSelectionMode(single ? ListSelectionModel.SINGLE_SELECTION : ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

            // custom renderer: hiển thị toDisplay.apply(value)
            list.setCellRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                              boolean isSelected, boolean cellHasFocus) {
                    String text = value == null ? "" : toDisplay.apply((T) value);
                    return super.getListCellRendererComponent(list, text, index, isSelected, cellHasFocus);
                }
            });

            // nếu đã có selected trước đó, thiết lập selection trên JList
            applySelectedToList();

            JScrollPane scroll = new JScrollPane(list);

            // --- Tạo panel tìm kiếm ---
            JPanel searchPanel = new JPanel(new BorderLayout(5, 5));
            JLabel searchLabel = new JLabel("Tìm kiếm:");
            JTextField searchField = new JTextField();
            searchPanel.add(titlePanel, BorderLayout.NORTH);
            searchPanel.add(searchLabel, BorderLayout.WEST);
            searchPanel.add(searchField, BorderLayout.CENTER);

            // Thêm listener cho tìm kiếm
            searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                private void update() {
                    String text = searchField.getText().trim().toLowerCase();
                    listModel.clear();
                    for (T item : items) {
                        String display = toDisplay.apply(item).toLowerCase();
                        if (display.contains(text)) {
                            listModel.addElement(item);
                        }
                    }
                    applySelectedToList(); // giữ selection
                }

                @Override
                public void insertUpdate(javax.swing.event.DocumentEvent e) { update(); }
                @Override
                public void removeUpdate(javax.swing.event.DocumentEvent e) { update(); }
                @Override
                public void changedUpdate(javax.swing.event.DocumentEvent e) { update(); }
            });



            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            okButton = new JButton("OK");
            cancelButton = new JButton("Hủy");


            buttonPanel.add(createButton);
            buttonPanel.add(okButton);
            buttonPanel.add(cancelButton);

            okButton.addActionListener(e -> {
                List<T> selected = list.getSelectedValuesList();
                selectedSet.clear();
                selectedSet.addAll(selected);
                String text = selected.stream().map(toDisplay).collect(Collectors.joining(", "));
                textField.setText(text);
                dialog.dispose();
            });

            cancelButton.addActionListener(e -> dialog.dispose());



            // --- Thêm vào dialog ---
            JPanel centerPanel = new JPanel(new BorderLayout(5,5));
            centerPanel.add(searchPanel, BorderLayout.NORTH);
            centerPanel.add(scroll, BorderLayout.CENTER);

            dialog.add(centerPanel, BorderLayout.CENTER);
            dialog.add(buttonPanel, BorderLayout.SOUTH);

        } else {
            // nếu dialog đã được tạo trước đó, đồng bộ selection hiện tại
            applySelectedToList();
        }


        dialog.setVisible(true);
    }

    public void setActionCreateButton (ActionListener actionCreateButton) {
        this.createButton.addActionListener(actionCreateButton);

    }



    // áp dụng selectedSet hiện tại lên JList (khi mở lại dialog)
    private void applySelectedToList() {
        if (listModel == null || list == null) return;
        // build list of indices to select
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            T element = listModel.getElementAt(i);
            if (selectedSet.contains(element)) {
                indices.add(i);
            }
        }
        int[] idxArray = indices.stream().mapToInt(Integer::intValue).toArray();
        list.setSelectedIndices(idxArray);
    }

    // Trả về danh sách đã chọn (order giữ theo selectedSet insertion order)
    public List<T> getSelectedItems() {
        return new ArrayList<>(selectedSet);
    }

    // Cho phép set selected từ bên ngoài (đối tượng phải là chính xác instance hoặc equals() phải đúng)
    public void setSelectedItems(Collection<T> items) {
        selectedSet.clear();
        if (items != null) selectedSet.addAll(items);
        // cập nhật textField hiển thị
        String text = selectedSet.stream().map(toDisplay).collect(Collectors.joining(", "));
        textField.setText(text);
    }

    // Set toàn bộ items mới (thay đổi nguồn dữ liệu)
    public void setItems(T[] items) {
        this.items = items == null ? (T[]) new Object[0] : items;
        if (listModel != null) {
            listModel.clear();
            for (T item : this.items) listModel.addElement(item);
            applySelectedToList();
        }
        // cập nhật text nếu cần
        String text = selectedSet.stream().map(toDisplay).collect(Collectors.joining(", "));
        textField.setText(text);
    }

    public void setItems(List<T> items) {
        setItems(items == null ? null : (T[]) items.toArray());
    }

    // Lấy text hiển thị
    public String getText() {
        return textField.getText();
    }


    // Test main demo với class Book
    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test MultiSelectForm Generic");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 300);
            frame.setLayout(new FlowLayout());

            // sample class Book
            class Book {
                private final int id;
                private final String name;

                Book(int id, String name) { this.id = id; this.name = name; }
                public int getId() { return id; }
                public String getName() { return name; }
                @Override
                public String toString() { return "Book(" + id + ") " + name; }
                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (!(o instanceof Book)) return false;
                    Book book = (Book) o;
                    return id == book.id;
                }
                @Override
                public int hashCode() { return Integer.hashCode(id); }
            }

            Book[] books = {
                    new Book(1, "Java Core"),
                    new Book(2, "Effective Java"),
                    new Book(3, "Clean Code"),
                    new Book(4, "Java Core") // trùng tên nhưng khác id
            };

            // MultiSelectForm hiển thị Book::getName
            MultiSelectForm<Book> multiSelect = new MultiSelectForm<>("Chọn sách", books, Book::getName);
            multiSelect.setPreferredSize(new Dimension(400, 60));

            JButton show = new JButton("In kết quả");
            show.addActionListener(e -> {
                List<Book> selected = multiSelect.getSelectedItems();
                System.out.println("Selected objects:");
                for (Book b : selected) {
                    System.out.println("id=" + b.getId() + ", name=" + b.getName());
                }
                System.out.println("Displayed text: " + multiSelect.getText());
            });

            frame.add(multiSelect);
            frame.add(show);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
