package AimsProject.src.hust.soict.dsai.test.store;

import AimsProject.src.hust.soict.dsai.aims.disc.DigitalVideoDisc;
import AimsProject.src.hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers"));
        store.addMedia(new DigitalVideoDisc(2, "Aladdin", "Animation", 24.99f, 90, "Ron Clements"));
        store.addMedia(new DigitalVideoDisc(3, "Toy Story", "Animation", 18.99f, 81, "John Lasseter"));
        store.addMedia(new DigitalVideoDisc(4, "Finding Nemo", "Animation", 22.50f, 100, "Andrew Stanton"));
        store.addMedia(new DigitalVideoDisc(5, "Cars", "Animation", 21.00f, 117, "John Lasseter"));


        store.print();

        store.removeMedia(store.getMedia("The Lion King"));
        store.print();
    }
}