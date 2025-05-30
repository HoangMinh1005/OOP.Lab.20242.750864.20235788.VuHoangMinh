package AimsProject.src.hust.soict.hedspi.aims.screen.manager;

import AimsProject.src.hust.soict.hedspi.aims.media.Book;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors;
    public AddBookToStoreScreen(Store store) {
        super(store);
        JPanel center = createCenter();
        center.add(new JLabel("Authors:"));
        tfAuthors = new JTextField(20);
        center.add(tfAuthors);
        getContentPane().add(center, BorderLayout.CENTER);
        setTitle("Add Book");
    }
    @Override
    void addMedia() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String authors = tfAuthors.getText();
        Book book = new Book(store.getItemsInStore().size() + 1, title, category, cost);
        for (String author : authors.split(",")) {
            book.addAuthor(author.trim());
        }
        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Book added successfully!");
        dispose();
        new StoreManagerScreen(store);
    }
}