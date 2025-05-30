package AimsProject.src.hust.soict.hedspi.test.screen.customer.store;

import AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {	
	private static Store store;
	private static Cart cart;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/AimsProject/src/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Store");
        primaryStage.show();
	}
	
	public static void main(String[] args) {
        store = new Store();
        cart = new Cart();
        
        store.addMedia(new DigitalVideoDisc(1, "The Shawshank Redemption", "Drama", 14.99f, "Frank Darabont", 142));
        store.addMedia(new DigitalVideoDisc(2, "The Matrix", "Sci-Fi", 19.99f, "Wachowskis", 136));
        store.addMedia(new DigitalVideoDisc(3, "The Godfather", "Crime", 12.99f, "Francis Ford Coppola", 175));
        store.addMedia(new DigitalVideoDisc(4, "Inception", "Sci-Fi", 14.99f, "Christopher Nolan", 148));
        store.addMedia(new DigitalVideoDisc(5, "Harry Potter and the Philosopher's Stone (2001)", "Fantasy", 9.99f, "Chris Columbus", 152));
        store.addMedia(new DigitalVideoDisc(6, "Harry Potter and the Chamber of Secrets (2002)", "Fantasy", 12.99f, "Chris Columbus", 161));
        store.addMedia(new DigitalVideoDisc(7, "Harry Potter and the Prisoner of Azkaban (2004)", "Fantasy", 14.99f, "Alfonso Cuarón", 142));
        store.addMedia(new DigitalVideoDisc(8, "Harry Potter and the Goblet of Fire (2005)", "Fantasy", 16.99f, "Mike Newell", 157));
        store.addMedia(new DigitalVideoDisc(9, "Harry Potter and the Order of the Phoenix (2007)", "Fantasy", 18.99f, "David Yates", 138));
        launch(args);
    }
}
