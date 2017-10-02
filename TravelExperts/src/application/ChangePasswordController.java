package application;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Models.Identity;
import Models.IdentityDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChangePasswordController {

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtOldPwd;

    @FXML
    private PasswordField txtNewPwd;

    @FXML
    private Button btnChangePwd;

    @FXML
    void doChangePassword(ActionEvent event) {	
    	JFrame frame = new JFrame("Change Password"); 
    	String userName = txtUser.getText();
    	String oldPwd = txtOldPwd.getText();
    	String newPwd = txtNewPwd.getText(); 
    	
    	Identity ident = IdentityDB.getIdentity(userName);
    	
    	if(ident.changePassword(oldPwd, newPwd)){
    		//SUCCESS
    		JOptionPane.showMessageDialog(frame,
    		    "Password Change Successfull.",
    		    "Password Change",
    		    JOptionPane.PLAIN_MESSAGE);
    		
    		Stage change = (Stage) btnChangePwd.getScene().getWindow();
    		change.close();
    		
    	}
    	else {
    		//FAIL
    		JOptionPane.showMessageDialog(frame,
    		    "Password Change Unsucessful. Old Password incorrect. Please try again.",
    		    "Password Change",
    		    JOptionPane.PLAIN_MESSAGE);

    		
    	}

    }
}


