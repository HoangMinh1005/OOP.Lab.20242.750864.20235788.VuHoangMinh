package AimsProject.src.hust.soict.hedspi.aims;

import AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;
import AimsProject.src.hust.soict.hedspi.aims.media.*;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.util.Scanner;

public class Aims extends Application {
	@Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/AimsProject/src/hust/soict/hedspi/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        Store store = new Store();
        Cart cart = new Cart();
        store.addMedia(new DigitalVideoDisc(1, "The Matrix", "Sci-Fi", 19.99f, "Wachowskis", 136));
        store.addMedia(new DigitalVideoDisc(2, "Invalid DVD", "Test", 9.99f, "Unknown", 0));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "Invalid DVD", "Test", 9.99f, "Unknown", 0);
        store.addMedia(dvd);
        try {
            dvd.play();
        } catch (PlayerException e) {
            System.err.println(e.getMessage());
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Player Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        launch(args);
    }
}
