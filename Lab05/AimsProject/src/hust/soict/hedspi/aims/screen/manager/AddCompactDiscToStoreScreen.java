package AimsProject.src.hust.soict.hedspi.aims.screen.manager;

import AimsProject.src.hust.soict.hedspi.aims.media.CompactDisc;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        JPanel center = createCenter();
        center.add(new JLabel("Artist:"));
        tfArtist = new JTextField(20);
        center.add(tfArtist);
        getContentPane().add(center, BorderLayout.CENTER);
        setTitle("Add CD");
    }

    @Override
    void addMedia() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String artist = tfArtist.getText();
        CompactDisc cd = new CompactDisc(store.getItemsInStore().size() + 1, title, category, cost, artist);
        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "CD added successfully!");
        dispose();
        new StoreManagerScreen(store);
    }
}