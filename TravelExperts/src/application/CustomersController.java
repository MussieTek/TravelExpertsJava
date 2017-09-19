package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Statement;

import Models.DBConnection;
import Models.CustomerDB;
import Models.Customer;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;

public class CustomersController implements Initializable {
	@FXML
	private MenuBar fxmenubar;
	@FXML
	private Menu fxDashboard, fxPackage, fxSupplier, fxProduct, fxBooking, fxCustomer, fxSendPromo;
	@FXML
	private TableView<Customer> custLists;
	@FXML
	private TableColumn<Customer, String> custName;
	@FXML
	private TableColumn<Customer, String> custEmail;
	@FXML
	private TableColumn<Customer, String> custPhone;
	@FXML
	private TableColumn<Customer, String> custCity;
	@FXML
	private TableColumn<Customer, Boolean> sendEmail;
	private Connection conn;
	private ObservableList<Customer>data;
	
	
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
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {		   	    
		try {
				            
			conn = new DBConnection().getConnection();
			loadCustomerList();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
    }

	private void loadCustomerList() throws SQLException {
		// TODO Auto-generated method stub
		
		data = FXCollections.observableArrayList();
		try {
			ResultSet rs = conn.createStatement().executeQuery("select custFirstName, custEmail, custHomePhone, custCity from customers");
			while (rs.next())
			{
				data.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		custName.setCellValueFactory(new PropertyValueFactory<>("custFirstName"));
		custEmail.setCellValueFactory(new PropertyValueFactory<>("custEmail"));
		custPhone.setCellValueFactory(new PropertyValueFactory<>("custHomePhone"));
		custCity.setCellValueFactory(new PropertyValueFactory<>("custCity"));
		
		
				
		sendEmail.setCellValueFactory(c -> new SimpleBooleanProperty(c.getValue().getIsDefault())); 
		sendEmail.setCellFactory(tc -> new CheckBoxTableCell<>());
		
		
		custLists.setItems(data);
		
	}
   
}
