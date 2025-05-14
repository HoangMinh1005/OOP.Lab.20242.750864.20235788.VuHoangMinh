package AimsProject.src.hust.soict.hedspi.aims;


import java.util.ArrayList;
import java.util.Scanner;

import AimsProject.src.hust.soict.hedspi.aims.book.Book;
import AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.disc.CompactDisc;
import AimsProject.src.hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import AimsProject.src.hust.soict.hedspi.aims.disc.Track;
import AimsProject.src.hust.soict.hedspi.aims.media.Media;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

public class Aims {
    static Scanner inp = new Scanner(System.in);
    static Store store = new Store();
    static Cart cart = new Cart();

    public static void main(String[] args) {
        loadExample();
        showMenu();
    }

    public static void loadExample() {
        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers"));
        store.addMedia(new DigitalVideoDisc(2, "Aladdin", "Animation", 24.99f, 90, "Ron Clements"));
        store.addMedia(new DigitalVideoDisc(3, "Toy Story", "Animation", 18.99f, 81, "John Lasseter"));
        store.addMedia(new DigitalVideoDisc(4, "Finding Nemo", "Animation", 22.50f, 100, "Andrew Stanton"));
        store.addMedia(new DigitalVideoDisc(5, "Cars", "Animation", 21.00f, 117, "John Lasseter"));

        store.addMedia(new CompactDisc(6, "Thriller", "Music", 74.3f, 42, "Quincy Jones", "Michael Jackson"));
        store.addMedia(new CompactDisc(7, "Bad", "Music", 60.5f, 48, "Quincy Jones", "Michael Jackson"));
        store.addMedia(new CompactDisc(8, "Thriller 25", "Music", 75.0f, 45, "Quincy Jones", "Michael Jackson"));
        store.addMedia(new CompactDisc(9, "Dangerous", "Music", 77.0f, 50, "Teddy Riley", "Michael Jackson"));
        store.addMedia(new CompactDisc(10, "History", "Music", 76.0f, 49, "Michael Jackson", "Michael Jackson"));

        store.addMedia(new Book(11, "The Lord of the Rings", "Fantasy", 50.0f, new ArrayList<>()));
        store.addMedia(new Book(12, "The Hobbit", "Fantasy", 30.0f, new ArrayList<>()));
        store.addMedia(new Book(13, "The Two Towers", "Fantasy", 40.0f, new ArrayList<>()));
        store.addMedia(new Book(14, "The Return of the King", "Fantasy", 45.0f, new ArrayList<>()));
        store.addMedia(new Book(15, "The Silmarillion", "Fantasy", 55.0f, new ArrayList<>()));

        ArrayList<Track> tracks1 = new ArrayList<>();
        tracks1.add(new Track("Shape of You", 4));
        tracks1.add(new Track("Perfect", 5));
        tracks1.add(new Track("Photograph", 4));

        CompactDisc edSheeranCD = new CompactDisc(16,"Divide", "Pop", 15.0f, 0,
                "Steve Mac", "Ed Sheeran", tracks1);

        ArrayList<Track> tracksMJ = new ArrayList<>();
        tracksMJ.add(new Track("Wanna Be Startin' Somethin'", 6));
        tracksMJ.add(new Track("Thriller", 6));
        tracksMJ.add(new Track("Beat It", 5));
        tracksMJ.add(new Track("Billie Jean", 7));

        CompactDisc thrillerCD = new CompactDisc(17, "Thriller", "Pop", 18.5f, 0,
                "Quincy Jones", "Michael Jackson", tracksMJ);

        ArrayList<Track> tracksAdele = new ArrayList<>();
        tracksAdele.add(new Track("Rolling in the Deep", 4));
        tracksAdele.add(new Track("Rumour Has It", 4));
        tracksAdele.add(new Track("Someone Like You", 5));

        CompactDisc adeleCD = new CompactDisc(18, "21", "Soul/Pop", 19.0f, 0,
                "Rick Rubin", "Adele", tracksAdele);

        store.addMedia(adeleCD);
        store.addMedia(edSheeranCD);
        store.addMedia(thrillerCD);
    }

    public static void showMenu() {
        while (true) {
            System.out.println("AIMS:");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3: ");

            int choice = inp.nextInt();
            inp.nextLine();
            switch (choice) {
                case 0: return;
                case 1: storeMenu(); break;
                case 2: updateStoreMenu(); break;
                case 3: cartMenu(); break;
                default: System.out.println("Error");
            }
        }
    }

    public static void storeMenu() {
        store.print();
        while (true) {
            System.out.println("Store Menu:");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");

            int choice = inp.nextInt();
            inp.nextLine();
            switch (choice) {
                case 0: return;
                case 1: seeMediaDetails(); break;
                case 2: addMediaToCart(); break;
                case 3: playMedia(); break;
                case 4: cartMenu(); break;
                default: System.out.println("Error");
            }
        }
    }

    public static void seeMediaDetails() {
        System.out.println("Enter the title: ");
        Media media = store.getMedia(inp.next());
        if (media != null) {
            System.out.println(media);
        } else {
            System.out.println("No such media !!!");
        }
        mediaDetailsMenu();
    }

    public static void mediaDetailsMenu() {
        while (true) {
            System.out.println("Media Details Menu:");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");

            int choice = inp.nextInt();
            inp.nextLine();
            switch (choice) {
                case 0: return;
                case 1: addMediaToCart(); break;
                case 2: playMedia(); break;
                default: System.out.println("Error");
            }
        }
    }

    public static void addMediaToCart() {
        System.out.print("Enter the title: ");
        Media media = store.getMedia(inp.nextLine());
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to the cart.");
        } else {
            System.out.println("No such media!");
        }
    }

    public static void playMedia() {
        System.out.print("Enter the title: ");
        Media media = store.getMedia(inp.nextLine());
        if (media != null) {
            if (media instanceof CompactDisc cd) {
                cd.play();
            } else if (media instanceof DigitalVideoDisc dvd) {
                dvd.play();
            } else {
                System.out.println("This media is not playable.");
            }
        } else {
            System.out.println("No such media!");
        }
    }

    public static void cartMenu() {
        cart.displayCart();
        while (true) {
            System.out.println("Cart Menu:");
            System.out.println("--------------------------------");
            System.out.println("1. Filter media in cart");
            System.out.println("2. Sort media in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");

            int choice = inp.nextInt();
            inp.nextLine();
            switch (choice) {
                case 0: return;
                case 1: filterMedia(); break;
                case 2: sortMedia(); break;
                case 3: removeMedia(); break;
                case 4: playMedia(); break;
                case 5:
                    System.out.println("Order has been placed!");
                    cart.empty();
                    break;
                default:
                    System.out.println("Error");
            }
        }
    }

    public static void filterMedia() {
        System.out.println("Filter by:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Choose an option: ");

        int choice = inp.nextInt();
        inp.nextLine();
        switch (choice) {
            case 0: return;
            case 1: filterMediaByID(); break;
            case 2: filterMediaByTitle(); break;
        }
    }

    public static void filterMediaByID() {
        System.out.print("Enter the ID: ");
        System.out.println(cart.idSearch(inp.nextInt()));
    }

    public static void filterMediaByTitle() {
        System.out.print("Enter the title: ");
        System.out.println(cart.titleSearch(inp.nextLine()));
    }

    public static void sortMedia() {
        System.out.println("Sort by:");
        System.out.println("--------------------------------");
        System.out.println("1. Title");
        System.out.println("2. Price");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Choose an option: ");

        int choice = inp.nextInt();
        inp.nextLine();
        switch (choice) {
            case 0: break;
            case 1:
                cart.sortByTitle();
                System.out.println("Sorted by title.");
                break;
            case 2:
                cart.sortByPrice();
                System.out.println("Sorted by price.");
                break;
        }
    }

    public static void removeMedia() {
        System.out.print("Enter the title: ");
        Media media = cart.titleSearch(inp.nextLine());
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media removed from the cart.");
        } else {
            System.out.println("No such media in the cart!");
        }
    }

    public static void updateStoreMenu() {
        while (true) {
            System.out.println("Update Store:");
            System.out.println("--------------------------------");
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Choose an option: ");

            int choice = inp.nextInt();
            inp.nextLine();
            switch (choice) {
                case 0: return;
                case 1: addMediaToStore(); break;
                case 2: removeMediaFromStore(); break;
            }
        }
    }

    public static void addMediaToStore() {
        System.out.print("Enter media type (1-DVD, 2-CD, 3-Book): ");
        int type = inp.nextInt();
        inp.nextLine();

        System.out.print("ID: ");
        int id = inp.nextInt();
        System.out.print("Title: ");
        String title = inp.nextLine();
        System.out.print("Category: ");
        String category = inp.nextLine();
        System.out.print("Cost: ");
        float cost = inp.nextFloat();
        inp.nextLine();

        Media media = null;
        switch (type) {
            case 1:
                System.out.print("Director: ");
                String director = inp.nextLine();
                System.out.print("Length: ");
                int length = inp.nextInt();
                inp.nextLine();
                media = new DigitalVideoDisc(id, title, category, cost, length, director);
                break;
            case 2:
                media = new CompactDisc(id, title, category, cost);
                break;
            case 3:
                media = new Book(id, title, category, cost, new ArrayList<>());
                break;
            default:
                System.out.println("Invalid media type!");
                return;
        }

        store.addMedia(media);
        System.out.println("Media added to store successfully!");
    }

    public static void removeMediaFromStore() {
        System.out.print("Enter the title of the media to remove: ");
        String title = inp.nextLine();
        Media media = store.getMedia(title);
        if (media != null) {
            store.removeMedia(title);
            System.out.println("Media removed from store successfully.");
        } else {
            System.out.println("No such media in store!");
        }
    }
}
