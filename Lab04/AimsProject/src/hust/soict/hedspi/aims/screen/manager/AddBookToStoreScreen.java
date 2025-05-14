package AimsProject.src.hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;

import AimsProject.src.hust.soict.hedspi.aims.book.Book;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import java.awt.*;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);
        add(createCenter(), BorderLayout.CENTER);
    }

    @Override
    protected JPanel createCenter() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField costField = new JTextField();
        JTextField authorsField = new JTextField();

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);
        panel.add(new JLabel("Authors (comma-separated):"));
        panel.add(authorsField);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
                int id = Integer.parseInt(idField.getText());
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                String[] authorNames = authorsField.getText().split(",");
                ArrayList<String> authors = new ArrayList<>();
                for (String name : authorNames) {
                    authors.add(name.trim());
                }

                store.addMedia(new Book(id, title, category, cost, authors));
                JOptionPane.showMessageDialog(this, "Book added successfully!");
        });

        panel.add(new JLabel());
        panel.add(addButton);

        return panel;
    }

}

