package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import Models.Customer;
import Models.DBConnection;
import Models.Product;
import Models.ProductDB;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.MenuBar;

import javafx.scene.control.ListView;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Menu;

public class ProductsController implements Initializable{
	@FXML
	private MenuBar fxmenubar;
	@FXML
	private Menu fxDashboard, fxPackage, fxSupplier, fxProduct, fxBooking, fxCustomer, fxSendPromo;
	@FXML
	private ListView<Product> lvProducts;
	@FXML
	private TextField fxProductId, fxProductName;
	@FXML
	private Label fxmsg;
	@FXML
	private Button btnAddSave, btnSaveEdit, btnDelete, btnAdd, btnEdit;
	private Connection conn;
	private ObservableList<Product>data;

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
	// Event Listener on ListView[#lvProducts].onMouseClicked
	@FXML
	public void selectProduct(MouseEvent event) {
		
		Product prod = lvProducts.getSelectionModel().getSelectedItem();
		fxProductId.setText(prod.getProductId() + "");
		fxProductName.setText(prod.getProdName());
		fxProductName.setEditable(false);
		btnEdit.setVisible(true);
		btnEdit.setDisable(false);
		btnAdd.setDisable(false);
		btnAdd.setVisible(true);
		btnAddSave.setVisible(false);
		btnSaveEdit.setVisible(false);
		btnDelete.setVisible(true);
		btnDelete.setDisable(false);
		fxmsg.setText("");
	}
	
	// Event Listener on Button[#btnAdd].onAction
	@FXML
	public void onAddProduct(ActionEvent event) {
		 fxProductId.setText("");
		 fxProductId.setDisable(true);
		 fxProductName.setText("");
		 fxProductName.setEditable(true);
		 btnAdd.setVisible(false);
		 btnAddSave.setVisible(true);
		 btnEdit.setDisable(true);
		 btnDelete.setDisable(true);
	}
	
	@FXML
	public void insertProduct(ActionEvent event) throws ClassNotFoundException, SQLException {
		String prodName = fxProductName.getText();
		if(prodName.isEmpty()) {
			fxmsg.setText("Please Enter the Product Name!");			
		} else {
			fxmsg.setText("");	
			Product p = new Product();
			p.setProdName(prodName);
			Boolean i = new ProductDB().addProduct(p);
			if(i.equals(true)) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Sucess!");
				alert.setHeaderText(null);
				alert.setContentText("Product Sucessfully Added!");
				alert.showAndWait();			
			} else {
				Alert err = new Alert(AlertType.ERROR);
				err.setTitle("Failed!");
				err.setHeaderText("Look, an Error Dialog");
				err.setContentText("Ooops, there was an error! Unable to add Product!");
			}
			loadProductList();
			clearControls();
		}
		
	}
	
	// Event Listener on Button[#btnEdit].onAction
	@FXML
	public void onEditProduct(ActionEvent event) {
		btnEdit.setVisible(false);
		btnSaveEdit.setVisible(true);
		btnAdd.setDisable(true);
		btnDelete.setDisable(true);
		fxProductId.setDisable(true);
		fxProductName.setEditable(true);
	}
	
	// Event Listener on Button[#btnSaveEdit].onAction
	@FXML
	public void updateProduct(ActionEvent event) {
		String prodName = fxProductName.getText();
		Integer ProductId = lvProducts.getSelectionModel().getSelectedItem().getProductId();
		if(prodName.isEmpty()) {
			fxmsg.setText("Please Enter the Product Name!");			
		} else {
			fxmsg.setText("");	
			Product p = new Product();
			p.setProductId(ProductId);
			p.setProdName(prodName);
			Boolean i = new ProductDB().updateProduct(p);
			if(i.equals(true)) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Sucess!");
				alert.setHeaderText(null);
				alert.setContentText("Product Sucessfully Updated!");
				alert.showAndWait();			
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Failed!");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Ooops, there was an error! Unable to update Product!");
			}
			loadProductList();
			clearControls();	
		}
	}
	
	// Event Listener on Button[#btnDelete].onAction
		@FXML
		public void deleteProduct(ActionEvent event) {
			String prodName = fxProductName.getText();
			Integer ProductId = lvProducts.getSelectionModel().getSelectedItem().getProductId();
			Product p = new Product();
			p.setProductId(ProductId);
			p.setProdName(prodName);
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Delete Product Confirmation!");
			alert.setHeaderText("Delete Product '" + prodName +"'");
			alert.setContentText("Are you sure, you want delete this product?");

			Optional<ButtonType> result = alert.showAndWait();
			
			if (result.get() == ButtonType.OK){
				Boolean i = new ProductDB().deleteProduct(p);
				if(i.equals(true)) {
					Alert alerts = new Alert(AlertType.INFORMATION);
					alerts.setTitle("Sucess!");
					alerts.setHeaderText(null);
					alerts.setContentText("Product Sucessfully Deleted!");
					alerts.showAndWait();			
				} else {
					Alert alertf = new Alert(AlertType.ERROR);
					alertf.setTitle("Failed!");
					alertf.setHeaderText("Look, an Error Dialog");
					alertf.setContentText("Ooops, there was an error! Unable to delete the Product!");
				}
				loadProductList();
				clearControls();
			} 
			
		}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btnAddSave.setVisible(false);
		btnDelete.setDisable(true);
		btnEdit.setDisable(true);
		btnSaveEdit.setVisible(false);
		try {
			conn = new DBConnection().getConnection();
			loadProductList();
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}		
		
	}
	private void loadProductList() {
		data = FXCollections.observableArrayList();
		new ProductDB();
		ArrayList<Product> rs = ProductDB.getProducts();

		for( Product prod: rs) {
			data.add(new Product(prod.getProductId(), prod.getProdName()));
		}
		
		lvProducts.setItems(data);	
	}
	
	private void clearControls() {
		fxProductName.setText("");
		fxProductId.setText("");
		btnAdd.setDisable(false);
		btnAdd.setVisible(true);
		btnAddSave.setVisible(false);
		btnSaveEdit.setVisible(false);
		btnEdit.setVisible(true);
		btnEdit.setDisable(true);	
		btnDelete.setDisable(true);
	}
}
