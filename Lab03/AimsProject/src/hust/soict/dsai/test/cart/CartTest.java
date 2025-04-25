package AimsProject.src.hust.soict.dsai.test.cart;

import AimsProject.src.hust.soict.dsai.aims.cart.Cart;
import AimsProject.src.hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"The Lion King",
                "Animation", 19.95f, 87, "Roger Allers");
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars",
                "Science Fiction", 24.95f, 87, "George Lucas");
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3,"Aladin",
                "Animation", 18.99f);
        cart.addMedia(dvd3);

        // Test the print method
        cart.displayCart();

        // To-do: Test the search methods here
        System.out.println(cart.idSearch(1).toString());
        System.out.println(cart.titleSearch("The Lion King").toString());
    }
}
