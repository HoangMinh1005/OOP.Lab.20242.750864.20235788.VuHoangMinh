package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import javax.swing.*;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

public class MediaStore extends JPanel{
	private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);
        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> {
                JDialog playDialog = new JDialog();
                playDialog.setTitle("Playing: " + media.getTitle());
                playDialog.add(new JLabel("Playing " + media.getTitle(), SwingConstants.CENTER));
                playDialog.setSize(300, 150);
                playDialog.setLocationRelativeTo(null);
                playDialog.setVisible(true);
            });
            container.add(playButton);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}

