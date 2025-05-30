package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<>();
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void setItemsInStore(ArrayList<Media> itemsInStore) {
		this.itemsInStore = itemsInStore;
	}

	public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Media added to store: " + media.getTitle());
    }

    public void removeMedia(Media media) {
    	if (itemsInStore.remove(media)) {
            System.out.println("Media removed from store: " + media.getTitle());
        } else {
            System.out.println("Media not found in store");
        }
    }
}
