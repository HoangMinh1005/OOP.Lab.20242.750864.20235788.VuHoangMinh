package AimsProject.src.hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;

import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setLayout(new BorderLayout());
        add(createNorth(), BorderLayout.NORTH);
        setTitle("Add Item");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    protected JPanel createNorth() {
        // Copy menu bar logic from StoreManagerScreen
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new StoreManagerScreen(store).createMenuBar());
        return panel;
    }

    protected abstract JPanel createCenter();
}

