/**
 * 
 */
package team4;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import workshop6.travelexperts.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
/**
 * @author KelseyShorten
 *
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.HTMLEditor;
import javafx.util.Callback;

public class EmailController implements Initializable{
	

    @FXML
    private Font x1;

    @FXML
    private Color x2;
    

    @FXML
    private ListView<?> lvPackages;

    @FXML
    private Font x11;

    @FXML
    private Color x21;

    @FXML
    private Button btnApply;

    @FXML
    private HTMLEditor htmlEdit;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSend;

    @FXML
    private TextArea txtaEmail;

    @FXML
    private Font x12;

    @FXML
    private Color x22;

    @FXML
    private Font x13;

    @FXML
    private Color x23;

    @FXML
    private Label lStatus;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    private Label rStatus;
    
    

    @FXML
    void applyTemplate(ActionEvent event) {
    	
    	// Get Template from drop down
    	
    	// Get packages from List View 
    	
    	// Put information into appropriate template text string
    	
    	// put text string into HTML editor

    }

    @FXML
    void editEmail(ActionEvent event) {
    	
    	//Check for button status 
    	//Enable / disable HTML Editor 
    	//Change button status  to Stop/start Editing 
    	
    	if (htmlEdit.isDisabled()) {
    		
    		htmlEdit.setDisable(false);
    		btnEdit.setText("Stop Editing");
    	}
    	else {
    		htmlEdit.setDisable(true);
    		btnEdit.setText("Edit");
    	
    	}
    	
    	
    	
    	

    }

    @FXML
    void sendEmail(ActionEvent event) {
    	// collect data from HTML editor 
    	
    	String body = htmlEdit.getHtmlText();
    	
    	// collect email addresses from Text area e-mails 
    	
    	String emails = txtaEmail.getText();
    		
    	// Double check with user
    	
    	// send to email server 
    	
    	// send confirmation 
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		// Fill in Template drop down
		// Fill in Package list with packages
			// get List of Packages
			ArrayList<Packages> p;// placeholder for get method
			ObservableList<?> observablePackages = FXCollections.observableArrayList(p);
			
			lvPackages.setItems(observablePackages);
			lvPackages.setCellFactory(packageListView -> new PackageListViewCell());
			
			
//			lvPackages.setCellFactory(new Callback<ListView<Packages>>, ListCell<Packages>>()  {
//
//				@Override
//				public ListCell<Packages> call(ListView<Packages> packageListView) {
//					// TODO Auto-generated method stub
//					return new PackageListViewCell();
//				}
//				
//				
//			});
			
			
			
			
			
		
		// Disable HTML editor 
		htmlEdit.setDisable(true);
	}
    	
    	
    }
