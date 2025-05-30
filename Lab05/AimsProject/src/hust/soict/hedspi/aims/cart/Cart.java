package AimsProject.src.hust.soict.hedspi.aims.cart;

import AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public void sortByTitle() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public void sortByCost() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	
	public void addMedia(Media media) {
		if(itemsOrdered.size() <= MAX_NUMBER_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("Media added: " + media.getTitle());
		} else {
			System.out.println("Cart is full");
		}
	}
	
	public void removeMedia(Media media) {
		if(itemsOrdered.remove(media)) {
			System.out.println("Media removed: " + media.getTitle());
		} else {
				System.out.println("Media not found");
		}
	}
	
	public float totalCost() {
		float total = 0.0f;
		for(Media media: itemsOrdered) {
			total += media.getCost();
		}
		return total;
	}
	
	public void displayItems() {
		int i=0;
		for(Media media: itemsOrdered) {
			i += 1;
			System.out.println(i + " id: " + media.getId() + "\t" + media.getTitle() 
					+ "\t" + media.getCost()) ;
		}
	}
	
	public void printCart() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i=0; i<itemsOrdered.size(); i++) {
			System.out.println((i+1) + ". " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
	
	public void searchById(int id) {
        boolean found = false;
        for (Media media: itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media: itemsOrdered) {
            if (media instanceof DigitalVideoDisc && ((DigitalVideoDisc) media).isMatch(title)) {
                System.out.println("Found: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title " + title);
        }
    }

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
}
