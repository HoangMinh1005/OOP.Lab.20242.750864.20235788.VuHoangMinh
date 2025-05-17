package AimsProject.src.hust.soict.hedspi.aims.screen.manager;


import javax.swing.*;

import AimsProject.src.hust.soict.hedspi.aims.disc.CompactDisc;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store) {
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
        JTextField artistField = new JTextField();

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
        panel.add(new JLabel("Artist:"));
        panel.add(artistField);

        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            int length = Integer.parseInt(lengthField.getText());
            String director = directorField.getText();
            String artist = artistField.getText();

            store.addMedia(new CompactDisc(id, title, category, cost, length, director, artist));
            JOptionPane.showMessageDialog(this, "CD added successfully!");
        });

        panel.add(new JLabel());
        panel.add(addButton);

        return panel;
    }
}
