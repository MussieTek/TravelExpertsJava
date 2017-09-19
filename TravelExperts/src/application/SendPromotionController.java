package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;

import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;

public class SendPromotionController {
	@FXML
	private MenuBar fxmenubar;
	@FXML
	private Menu fxDashboard, fxPackage, fxSupplier, fxProduct, fxBooking, fxCustomer, fxSendPromo;

	// Event Listener on Menu[#fxDashboard].onAction
		@FXML
		public void openDashboard(ActionEvent event) {
			// close current window
	    	Stage main = (Stage) fxmenubar.getScene().getWindow();
	        main.close();
	    	try {      
	    		
		        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
	            Parent dash = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(dash));  
	            stage.show();
	                               
	        } catch(Exception e) {
	           e.printStackTrace();
	        }
		}
		// Event Listener on Menu[#fxPackage].onAction
		@FXML
		public void openPackage(ActionEvent event) {
			// close current window
	    	Stage main = (Stage) fxmenubar.getScene().getWindow();
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
		// Event Listener on Menu[#fxSupplier].onAction
		@FXML
		public void openSupplier(ActionEvent event) {
			//close current window
			Stage main = (Stage) fxmenubar.getScene().getWindow();
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
		// Event Listener on Menu[#fxProduct].onAction
		@FXML
		public void openProduct(ActionEvent event) {
			// close current window
	    	Stage main = (Stage) fxmenubar.getScene().getWindow();
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
		// Event Listener on Menu[#fxBooking].onAction
		@FXML
		public void openBooking(ActionEvent event) {
			 // close current window
	        Stage main = (Stage) fxmenubar.getScene().getWindow();
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
		// Event Listener on Menu[#fxCustomer].onAction
		@FXML
		public void openCustomer(ActionEvent event) {
			
			 // close dashboard window
	    	Stage main = (Stage) fxmenubar.getScene().getWindow();
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
		// Event Listener on Menu[#fxSendPromo].onAction
		@FXML
		public void openSendPromo(ActionEvent event) {
			// close dashboard window
	    	Stage main = (Stage) fxmenubar.getScene().getWindow();
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
}
