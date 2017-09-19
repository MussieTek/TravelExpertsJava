package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private TextField tfPassword;

    @FXML
    private Button btnLogin;

    @FXML
    void doLogin (ActionEvent event) throws Exception {
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
    @FXML
    void initialize() {
        assert tfUsername != null : "fx:id=\"tfUsername\" was not injected: check your FXML file 'Login.fxml'.";
        assert tfPassword != null : "fx:id=\"tfPassword\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
