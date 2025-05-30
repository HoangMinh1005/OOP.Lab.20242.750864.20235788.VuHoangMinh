//package hust.soict.hedspi.test.cart;
//
//import hust.soict.hedspi.aims.cart.Cart;
//import hust.soict.hedspi.aims.media.DigitalVideoDisc;
//
//public class CartTest {
//    public static void main(String[] args) {
//        Cart cart = new Cart();
//
//        // Add DVDs
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//        cart.addMedia(dvd1);
//        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
//        cart.addMedia(dvd2);
//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
//        cart.addMedia(dvd3);
//
//        // Test print
//        cart.printCart();
//
//        // Test search
//        cart.searchById(1);
//        cart.searchByTitle("King");
//        
//        // Test remove
//        cart.removeMedia(dvd1);
//        cart.removeMedia(dvd1);
//        cart.searchById(1);
//        cart.searchByTitle("King");
//    }
//}