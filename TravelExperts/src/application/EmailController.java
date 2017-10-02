package application;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.awt.Window;
import javafx.scene.control.Button;

import Models.*;
import Models.Package;

public class EmailController implements Initializable {
	@FXML
	private MenuBar fxmenubar;
	@FXML
	private Menu fxDashboard, fxPackage, fxSupplier, fxProduct, fxBooking, fxCustomer, fxSendPromo;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private ComboBox<String> cbTemplates;

    @FXML
    private ListView<Package> lvPackage;

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
    private Button btnTo;

    @FXML
    private Label rStatus;
    
    @FXML
    private static ImageView fxCustomers;
    
    //-------------------------Basic menu code
    
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
		// close dash board window
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
//------------------------------

    @FXML
    void applyTemplate(ActionEvent event) {

        String templateText;
        Package pkg;
        // Get Template from drop down

        String templateFile = cbTemplates.getSelectionModel().getSelectedItem();

        templateText = readLineByLine("templates/" + templateFile);

        // Get selected package from List View. If no package  selected, use default blank package
        if (lvPackage.getSelectionModel().getSelectedItems() != null) {
            pkg = lvPackage.getSelectionModel().getSelectedItem();
        } else {
            Date today = new Date();
            pkg = new Package(0, "", today, today, "", 0.0, 0.0);
        }

        // Put information into appropriate template text string
        String bodyText = addTemplateData(templateText, pkg );

        // put text string into HTML editor
       htmlEdit.setHtmlText(bodyText);
    }

    @FXML
    void editEmail(ActionEvent event) {

        //Check for button status
        //Enable / disable HTML Editor
        //Change button status  to Stop/start Editing

        if (htmlEdit.isDisabled()) {

            htmlEdit.setDisable(false);
            btnEdit.setText("Stop Editing");
        } else {
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
        System.out.println(emails);
        System.out.println(body);
        // send confirmation
    }
    
    @FXML
    void getEmails(MouseEvent event) {
    	openCustomers(event);
    	
    	
    }
//    
    void openCustomers(MouseEvent event) {
   	 // close dashboard window
   	//Stage main = (Stage) btnTo.getScene().getWindow();
       //main.close();
       
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<String> templateList = FXCollections.observableArrayList();

        //get the templates from the directory
        File[] files = new File("templates").listFiles();

        // add to observable template list
        for (File file : files) {
            if (file.isFile()) {
                templateList.add(file.getName());
            }
        }

        cbTemplates.setItems(templateList);

        ArrayList<Package> p = PackageDB.getPackages(); // placeholder for get method
        ObservableList<Package> observablePackage = FXCollections.observableArrayList(p);

        lvPackage.setItems(observablePackage);
        lvPackage.setCellFactory(packageListView -> (new PackageListViewCell()));


        // Disable HTML editor
        htmlEdit.setDisable(true);
    }


    private static String readLineByLine(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    private static String addTemplateData(String template, Package pkg) {
        // Tag List
        String newTemplate = "";
        ArrayList<String> tags = new ArrayList<String>(Arrays.asList(
                "packageId",
                "pkgName",
                "pkgStartDate",
                "pkgEndDate",
                "pkgDesc",
                "totalPrice",
                "discountTen",
                "discountFifty"
                    ));


        // For each tag, do a regex search in the HTML and replace with the appropriate parameter in Package

        for (String tag : tags) {
            newTemplate = template.replaceAll( "(\\[("+ tag +")\\])" , pkg.getItemByTag(tag));
            template = newTemplate;
            System.out.println(pkg.getItemByTag(tag));
        }

        return newTemplate;
    }
    

}

