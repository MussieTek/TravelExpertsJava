package application;

import java.awt.Window;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView fxPackages;

    @FXML
    private ImageView fxProducts;

    @FXML
    private ImageView fxBookings;

    @FXML
    private ImageView fxSendPromo;

    @FXML
    private ImageView fxCustomers;

    @FXML
    private ImageView fxSuppliers;

    @FXML
    private Button btnLogout;

    @FXML
    void doLogout(ActionEvent event) {

    }

    @FXML
    void openBookings(MouseEvent event) {
    	
    	 // close dashboard window
        Stage main = (Stage) fxBookings.getScene().getWindow();
        main.close();
    	
    	try {      
    		
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Bookings.fxml"));
            Parent book = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(book));  
            stage.show();
                               
        } catch(Exception e) {
           e.printStackTrace();
        }
    }

    @FXML
    void openCustomers(MouseEvent event) {
    	 // close dashboard window
    	Stage main = (Stage) fxCustomers.getScene().getWindow();
        main.close();
        
    	try {      
    		
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Customers.fxml"));
            Parent cust = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(cust));  
            stage.show();
                               
        } catch(Exception e) {
           e.printStackTrace();
        }
    }

    @FXML
    void openPackages(MouseEvent event) {
    	// close dashboard window
    	Stage main = (Stage) fxPackages.getScene().getWindow();
        main.close();
    	try {      
    		
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Packages.fxml"));
            Parent pack = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(pack));  
            stage.show();
                               
        } catch(Exception e) {
           e.printStackTrace();
        }
    }

    @FXML
    void openProducts(MouseEvent event) {
    	// close dashboard window
    	Stage main = (Stage) fxProducts.getScene().getWindow();
        main.close();
    	try {      
    		
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Products.fxml"));
            Parent prod = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(prod));  
            stage.show();
                               
        } catch(Exception e) {
           e.printStackTrace();
        }
    }

    @FXML
    void openSendPromo(MouseEvent event) {
    	// close dashboard window
    	Stage main = (Stage) fxSendPromo.getScene().getWindow();
        main.close();
		try {         		
		        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SendPromotion.fxml"));
		        Parent promo = (Parent) fxmlLoader.load();
		        Stage stage = new Stage();
		        stage.setScene(new Scene(promo));  
		        stage.show();
	                               
	        } catch(Exception e) {
	           e.printStackTrace();
	        }
    }

    @FXML
    void openSuppliers(MouseEvent event) {
    	// close dashboard window
    	Stage main = (Stage) fxSuppliers.getScene().getWindow();
        main.close();
    	try {      
    		
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Suppliers.fxml"));
            Parent supp = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(supp));  
            stage.show();
                               
        } catch(Exception e) {
           e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert fxPackages != null : "fx:id=\"fxPackages\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert fxProducts != null : "fx:id=\"fxProducts\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert fxBookings != null : "fx:id=\"fxBookings\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert fxSendPromo != null : "fx:id=\"fxSendPromo\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert fxCustomers != null : "fx:id=\"fxCustomers\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert fxSuppliers != null : "fx:id=\"fxSuppliers\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert btnLogout != null : "fx:id=\"btnLogout\" was not injected: check your FXML file 'Dashboard.fxml'.";

    }
}
