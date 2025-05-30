package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector, tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        JPanel center = createCenter();
        center.add(new JLabel("Director:"));
        tfDirector = new JTextField(20);
        center.add(tfDirector);
        center.add(new JLabel("Length:"));
        tfLength = new JTextField(20);
        center.add(tfLength);
        getContentPane().add(center, BorderLayout.CENTER);
        setTitle("Add DVD");
    }

    @Override
    void addMedia() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());
        DigitalVideoDisc dvd = new DigitalVideoDisc(store.getItemsInStore().size() + 1, title, category, cost, director, length);
        store.addMedia(dvd);
        JOptionPane.showMessageDialog(this, "DVD added successfully!");
        dispose();
        new StoreManagerScreen(store);
    }
}