package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.property.FloatProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
		private Cart cart;
		private Store store;
		private FilteredList<Media> filteredMedia;
		private FloatProperty totalCost = new SimpleFloatProperty(0);
		
		public CartController(Store store, Cart cart) {
	        this.store = store;
	        this.cart = cart;
	    }
		
	    @FXML
	    private Label costLabel;

	    @FXML
	    private TableView<Media> tblMedia;

	    @FXML
	    private ToggleGroup filterCategory;

	    @FXML
	    private Button btnPlay;

	    @FXML
	    private Button btnRemove;
	    
	    @FXML
	    private TableColumn<Media, Integer> colMediaId;

	    @FXML
	    private TableColumn<Media, String> colMediaTitle;

	    @FXML
	    private TableColumn<Media, String> colMediaCategory;
	    
	    @FXML
	    private TableColumn<Media, Float> colMediaCost;

	    @FXML
	    private TextField tfFilter;

	    @FXML
	    private RadioButton radioBtnFilterId;

	    @FXML
	    private RadioButton radioBtnFilterTitle;
	    
	    @FXML
	    public void initialize() {
	        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
	        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
	        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
	        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
	        if (cart.getItemsOrdered() != null) {
	            filteredMedia = new FilteredList<>(cart.getItemsOrdered(), p -> true);
	            tblMedia.setItems(filteredMedia);
	            
	            totalCost.set(cart.totalCost());
	            costLabel.textProperty().bind(totalCost.asString("$%.2f"));

	            cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener<Media>) change -> {
	                while (change.next()) {
	                    if (change.wasAdded() || change.wasRemoved()) {
	                        float newTotal = cart.totalCost();
	                        totalCost.set(newTotal);
	                        System.out.println("Cart updated. New total cost: " + newTotal);
	                    }
	                }
	            });
	        }
	        
//	        tfFilter.textProperty().addListener(new ChangeListener<String>() {
//	            @Override
//	            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//	                showFilteredMedia(newValue);
//	            }
//	        });
	    }
	    
//	    void showFilteredMedia(String filterString) {
//	        filteredMedia.setPredicate(media -> {
//	            if (filterString == null || filterString.isEmpty()) {
//	                return true;
//	            }
//	            String lowerCaseFilter = filterString.toLowerCase();
//	            if (radioBtnFilterId.isSelected()) {
//	                return String.valueOf(media.getId()).contains(lowerCaseFilter);
//	            } else if (radioBtnFilterTitle.isSelected()) {
//	                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
//	            }
//	            return false;
//	        });
//	    }

	    @FXML
	    void btnRemovePressed(ActionEvent event) {
	        Media media = tblMedia.getSelectionModel().getSelectedItem();
	        cart.removeMedia(media);
	    }

	    @FXML
	    void btnViewStorePressed(ActionEvent event) {
	        try {
	            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
	            fxmlLoader.setController(new ViewStoreController(store, cart));
	            Parent root = fxmlLoader.load();
	            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
	            stage.setScene(new Scene(root));
	            stage.setTitle("Store");            
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @FXML
	    void btnPlayPressed(ActionEvent event) {
	        Media media = tblMedia.getSelectionModel().getSelectedItem();
	        if (media instanceof Playable) {
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("Playing Media");
	            alert.setHeaderText(null);
	            alert.setContentText("Playing: " + media.getTitle());
	            alert.showAndWait();
	        }
	    }

	    @FXML
	    void btnPlaceOrderPressed(ActionEvent event) {
	        cart.getItemsOrdered().clear();
	        totalCost.set(0);
	        Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Order Placed");
	        alert.setHeaderText(null);
	        alert.setContentText("Your order has been placed successfully!");
	        alert.showAndWait();
	    }

}
