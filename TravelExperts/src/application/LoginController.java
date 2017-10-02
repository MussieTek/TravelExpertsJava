package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Models.Identity;
import Models.IdentityDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private Button btnLogin;
    
    @FXML
    private Button btnChange;

    @FXML
    void initialize() {
        assert tfUsername != null : "fx:id=\"tfUsername\" was not injected: check your FXML file 'Login.fxml'.";
        assert tfPassword != null : "fx:id=\"tfPassword\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Login.fxml'.";

    }
   
// DO actions -------------------
    @FXML
    void doLogin (ActionEvent event) throws Exception {
    	//Verify Login
    	JFrame frame = new JFrame("Login"); 
    	String userName;
    	String password; 
    	if (tfUsername.getText().isEmpty()) userName = "";
    	else userName = tfUsername.getText();
    	
    	if (tfPassword.getText().isEmpty()) password = "";
    	else password = tfPassword.getText();
    	
    	if(userName.equals("") || VerifyLogin(userName, password)) {
    	
	    	// get a handle to the stage
	        Stage main = (Stage) btnLogin.getScene().getWindow();
	        // do what you have to do
	        main.close();
	        
	    	try {      
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root1));  
	            stage.show();
	                               
	        } catch(Exception e) {
	           e.printStackTrace();
	        }

    	}
    	else {
    		tfUsername.clear();
    		tfPassword.clear();
    		JOptionPane.showMessageDialog(frame,
        		    "User Name or Password is Incorrect. Please Try Again",
        		    "Login Fail",
        		    JOptionPane.PLAIN_MESSAGE);
    	}
    	
    }
    
    @FXML
    void doChangePwd(ActionEvent event) {
       	try {      
       		
 	       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChangePassword.fxml"));
            Parent cust = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(cust));  
            stage.show();
                               
        } catch(Exception e) {
           e.printStackTrace();
        }
    }
// Utility Functions 
    private boolean VerifyLogin(String userName, String password) {
		
    	Identity agt = IdentityDB.getIdentity(userName);
    	
    	if (agt.verify(password)) return true;
    	else return false;
	}
   } 

	
