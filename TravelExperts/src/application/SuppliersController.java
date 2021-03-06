package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Models.DBConnection;
import Models.Supplier;
import Models.SupplierDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.MenuBar;

import javafx.scene.control.ListView;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Menu;

public class SuppliersController implements Initializable {
	@FXML
	private MenuBar fxmenubar;
	@FXML
	private Menu fxDashboard;
	@FXML
	private Menu fxPackage;
	@FXML
	private Menu fxSupplier;
	@FXML
	private Menu fxProduct;
	@FXML
	private Menu fxBooking;
	@FXML
	private Menu fxCustomer;
	@FXML
	private Menu fxSendPromo;
	@FXML
	private ListView<Supplier> lvSuppliers;
	@FXML
	private TextField fxSupplierId;
	@FXML
	private TextField fxSupplierName;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnEdit;
	@FXML
	private Button btnAddSave;
	@FXML
	private Button btnSaveEdit;
	@FXML
	private Button btnDelete;
	
	private Connection conn;
	private ObservableList<Supplier>data;
	

	// Event Listener on MenuItem.onAction
	@FXML
	public void openDashboard(ActionEvent event) {
		// TODO Autogenerated
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
	// Event Listener on MenuItem.onAction
	@FXML
	public void openPackage(ActionEvent event) {
		// TODO Autogenerated
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
	// Event Listener on MenuItem.onAction
	@FXML
	public void openSupplier(ActionEvent event) {
		// TODO Autogenerated
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
	// Event Listener on MenuItem.onAction
	@FXML
	public void openProduct(ActionEvent event) {
		// TODO Autogenerated
		Stage main = (Stage) fxmenubar.getScene().getWindow();
        main.close();
    	try {      
    		
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Products.fxml"));
            Parent supp = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(supp));  
            stage.show();
                               
        } catch(Exception e) {
           e.printStackTrace();
        }
	}
	// Event Listener on MenuItem.onAction
	@FXML
	public void openBooking(ActionEvent event) {
		// TODO Autogenerated
		Stage main = (Stage) fxmenubar.getScene().getWindow();
        main.close();
    	try {      
    		
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Bookings.fxml"));
            Parent supp = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(supp));  
            stage.show();
                               
        } catch(Exception e) {
           e.printStackTrace();
        }
	}
	// Event Listener on MenuItem.onAction
	@FXML
	public void openCustomer(ActionEvent event) {
		// TODO Autogenerated
		Stage main = (Stage) fxmenubar.getScene().getWindow();
        main.close();
    	try {      
    		
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Customers.fxml"));
            Parent supp = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(supp));  
            stage.show();
                               
        } catch(Exception e) {
           e.printStackTrace();
        }
	}
	// Event Listener on MenuItem.onAction
	@FXML
	public void openSendPromo(ActionEvent event) {
		// TODO Autogenerated
		Stage main = (Stage) fxmenubar.getScene().getWindow();
        main.close();
    	try {      
    		
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SendPromotion.fxml"));
            Parent supp = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(supp));  
            stage.show();
                               
        } catch(Exception e) {
           e.printStackTrace();
        }
	}
	// Event Listener on ListView[#lvSuppliers].onMouseClicked
	@FXML
	public void selectSupplier(MouseEvent event) {
		// TODO Autogenerated
		Supplier sup = lvSuppliers.getSelectionModel().getSelectedItem();
		fxSupplierId.setText(sup.getSupplierId() + "");
		fxSupplierName.setText(sup.getSupName() + "");
		fxSupplierName.setEditable(false);
		btnEdit.setVisible(true);
		btnEdit.setDisable(false);
		btnAdd.setDisable(true);
		btnAdd.setVisible(true);
		btnAddSave.setVisible(false);
		btnSaveEdit.setVisible(false);
		btnDelete.setVisible(true);
		btnDelete.setDisable(false);
	}
	// Event Listener on Button[#btnAdd].onAction
	@FXML
	public void onAddSupplier(ActionEvent event) {
		// TODO Autogenerated
		int supplierId = SupplierDB.GetSupplierId();
		fxSupplierId.setText(supplierId + "");
		fxSupplierId.setDisable(true);
		fxSupplierName.setText("");
		fxSupplierName.setEditable(true);
		btnAdd.setVisible(false);
		btnAddSave.setVisible(true);
		btnEdit.setDisable(true);
		btnDelete.setVisible(false);
	}
	// Event Listener on Button[#btnEdit].onAction
	@FXML
	public void onEditSupplier(ActionEvent event) {
		// TODO Autogenerated
		btnEdit.setVisible(false);
		btnSaveEdit.setVisible(true);
		btnAdd.setVisible(false);
		btnDelete.setDisable(true);
		fxSupplierId.setDisable(true);
		fxSupplierName.setEditable(true);
	}
	// Event Listener on Button[#btnAddSave].onAction
	@FXML
	public void insertSupplier(ActionEvent event) throws ClassNotFoundException, SQLException {
		// TODO Autogenerated 
		int supplierId = Integer.parseInt(fxSupplierId.getText());
		String supName = fxSupplierName.getText();
		
		Supplier s = new Supplier();
		s.setSupplierId(supplierId);
		s.setSupName(supName);
		Boolean i = new SupplierDB().addSupplier(s);
		if(i) {
			System.out.println("Sucessfully Added");
			
		} else {
			System.out.println("Failed");
		}
		loadSupplierList();
		clearControls();
	}
	private void clearControls() {
		// TODO Auto-generated method stub
		fxSupplierName.setText("");
		fxSupplierId.setText("");
		btnAdd.setDisable(false);
		btnAdd.setVisible(true);
		btnAddSave.setVisible(false);
		btnSaveEdit.setVisible(false);
		btnEdit.setVisible(true);
		btnEdit.setDisable(true);	
		btnDelete.setVisible(false);
		
	}
	private void loadSupplierList() {
		// TODO Auto-generated method stub
		data = FXCollections.observableArrayList();
		new SupplierDB();
		ArrayList<Supplier> rs = SupplierDB.getSuppliers();

		for( Supplier sup: rs) {
			data.add(new Supplier(sup.getSupplierId(), sup.getSupName()));
		}
		
		lvSuppliers.setItems(data);
		
	}
	// Event Listener on Button[#btnSaveEdit].onAction
	@FXML
	public void updateSupplier(ActionEvent event) {
		// TODO Autogenerated
		String supName = fxSupplierName.getText();
		Integer SupplierId = lvSuppliers.getSelectionModel().getSelectedItem().getSupplierId();
		Supplier s = new Supplier();
		s.setSupplierId(SupplierId);
		s.setSupName(supName);
		Boolean i = new SupplierDB().updateSupplier(s);
		if(i) {
			System.out.println("Sucessfully Updated");
			
		} else {
			System.out.println("Failed");
		}
		loadSupplierList();
		clearControls();
	}
	// Event Listener on Button[#btnDelete].onAction
	@FXML
	public void deleteSupplier(ActionEvent event) {
		// TODO Autogenerated
		String supName = fxSupplierName.getText();
		Integer supplierId = lvSuppliers.getSelectionModel().getSelectedItem().getSupplierId();
		Supplier s = new Supplier();
		s.setSupplierId(supplierId);
		s.setSupName(supName);
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Delete Supplier Confirmation!");
		alert.setHeaderText("Delete Supplier '" + supName +"'");
		alert.setContentText("Are you sure, you want delete this supplier?");

		Optional<ButtonType> result = alert.showAndWait();
		
		if (result.get() == ButtonType.OK){
			Boolean i = new SupplierDB().deleteSupplier(s);
			if(i) {
				System.out.println("Sucessfully Deleted");
				
			} else {
				System.out.println("Failed");
			}
			loadSupplierList();
			clearControls();
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		btnAddSave.setVisible(false);
		btnDelete.setVisible(false);
		btnEdit.setDisable(true);
		btnSaveEdit.setVisible(false);
		try {
			conn = new DBConnection().getConnection();
			loadSupplierList();
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
}
