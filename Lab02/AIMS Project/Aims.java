public class Aims {
    public static void main(String[] args) {

        Cart shoppingCart = new Cart();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
            "The Lion King", "Animation", "Roger Allers", 87, 19.95f
        );
        shoppingCart.addDisc(dvd1);


        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
            "Star Wars", "Science Fiction", "George Lucas", 82, 24.95f
        );
        shoppingCart.addDisc(dvd2);


        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
            "Aladin", "Animation", 18.99f
        );
        shoppingCart.addDisc(dvd3);


        System.out.println("Total cost is: " + shoppingCart.getTotalCost());

        // Step 6: Add a new DVD
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(
            "Doraemon", "Animation", "Nippon TV", 100, 30.00f
        );
        shoppingCart.addDisc(dvd4);

        //Remove a DVD
        System.out.println("Removing disc...");
        shoppingCart.removeDisc(dvd4);

        //Display the total number of DVD objects created so far
        System.out.println("Total discs created: " + DigitalVideoDisc.getNbDigitalVideoDisc());
    }
}
