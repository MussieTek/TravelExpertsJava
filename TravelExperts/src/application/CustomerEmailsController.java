package application;


import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Models.Customer;
import Models.CustomerDB;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CustomerEmailsController implements Initializable {
	
    @FXML
    private TableView<Customer> custLists;

    @FXML
    private TableColumn<Customer, String> firstNameCol;

    @FXML
    private TableColumn<Customer, String> lastNameCol;

    @FXML
    private TableColumn<Customer, String> cityCol;
    
    @FXML
    private TableColumn<Customer, String> emailCol;

    @FXML
    private TableColumn<Customer, Boolean> selectedCol;
    
    @FXML
    private Button btnSelect;

	JFrame frame = new JFrame("Message"); 
	static String emails; 
    

	public void CreateStage() {
		try {      

		       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomersEmails.fxml"));
	           Parent cust = (Parent) fxmlLoader.load();
	           Stage stage = new Stage();
	           stage.setScene(new Scene(cust));  
	           stage.initModality(Modality.APPLICATION_MODAL);
	           stage.showAndWait();
	                              
	       } catch(Exception e) {
	          e.printStackTrace();
	       }
		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		  ObservableList<Customer> custList = CustomerDB.getObservableCustomers();

	      emailCol.setCellValueFactory(new PropertyValueFactory<>("custEmail"));
	      firstNameCol.setCellValueFactory(new PropertyValueFactory<>("custFirstName"));
	      lastNameCol.setCellValueFactory(new PropertyValueFactory<>("custLastName"));
	      cityCol.setCellValueFactory(new PropertyValueFactory<>("custCity"));
	      
	      selectedCol.setCellValueFactory(new Callback<CellDataFeatures<Customer, Boolean>, ObservableValue<Boolean>>() {
				@Override
				public ObservableValue<Boolean> call(CellDataFeatures<Customer, Boolean> param) {
					Customer customer = param.getValue();
					 
	                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(customer.selectedProperty());
	 
	                booleanProp.addListener(new ChangeListener<Boolean>() {
	 
	                    @Override
	                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
	                            Boolean newValue) {
	                        customer.setSelected(newValue);
	                    }
	                });
	                return booleanProp;
				}
	        });
	 
	        selectedCol.setCellFactory(new Callback<TableColumn<Customer, Boolean>, //
	        TableCell<Customer, Boolean>>() {
	            @Override
	            public TableCell<Customer, Boolean> call(TableColumn<Customer, Boolean> p) {
	                CheckBoxTableCell<Customer, Boolean> cell = new CheckBoxTableCell<Customer, Boolean>();
	                cell.setAlignment(Pos.CENTER);
	                return cell;
	            }
	        });
   
	      custLists.setItems(custList);
	      custLists.setEditable(true);
	      

	}
	
    @FXML
    void addToEmails(ActionEvent event) {
    	
    	StringBuilder sb = new StringBuilder();
    	
		for (Customer customer : custLists.getItems()) {
			if (customer.getSelected()) {
				sb.append(customer.getCustEmail().trim() + ", ");
			}
		}
		
		emails = sb.toString();
		int n = JOptionPane.showConfirmDialog(frame , "Add the following Customers? \n \n " + sb,
				"Add Customer Emails", JOptionPane.YES_NO_OPTION);

		if (n < 1) {
			
			emails = sb.toString();
			System.out.println("emails1" + emails);
    		Stage stage = (Stage) btnSelect.getScene().getWindow();
    		stage.close();
    		System.out.println("emails1a" + emails);
		}
		else {
			emails = "";
		}
		
	}

    public String getEmails() {
		System.out.println(" emails2 " + emails);
    	return emails; 
    }
    	
}
    

	 

	

