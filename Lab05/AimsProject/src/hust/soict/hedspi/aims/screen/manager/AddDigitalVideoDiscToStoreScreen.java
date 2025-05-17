package AimsProject.src.hust.soict.hedspi.aims.screen.manager;



import javax.swing.*;

import AimsProject.src.hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import java.awt.*;


public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
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
        JTextField lengthField = new JTextField();
        JTextField directorField = new JTextField();

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);
        panel.add(new JLabel("Length:"));
        panel.add(lengthField);
        panel.add(new JLabel("Director:"));
        panel.add(directorField);

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            int length = Integer.parseInt(lengthField.getText());
            String director = directorField.getText();

            store.addMedia(new DigitalVideoDisc(id, title, category, cost, length, director));
            JOptionPane.showMessageDialog(this, "DVD added successfully!");
        });

        panel.add(new JLabel());
        panel.add(addButton);

        return panel;
    }
}
