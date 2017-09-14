package team4;


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
        import javafx.fxml.Initializable;
        import javafx.scene.control.*;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextArea;
        import javafx.scene.paint.Color;
        import javafx.scene.text.Font;
        import javafx.scene.web.HTMLEditor;
        import travelexperts.Packages;

public class EmailController implements Initializable {


    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private ComboBox<String> cbTemplates;

    @FXML
    private ListView<Packages> lvPackages;

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

        String templateText;
        Packages pkg;
        // Get Template from drop down

        String templateFile = cbTemplates.getSelectionModel().getSelectedItem();

        templateText = readLineByLine("templates/" + templateFile);

        // Get selected package from List View. If no package  selected, use default blank package
        if (lvPackages.getSelectionModel().getSelectedItems() != null) {
            pkg = lvPackages.getSelectionModel().getSelectedItem();
        } else {
            Date today = new Date();
            pkg = new Packages(0, "", today, today, "", 0.0, 0.0);
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        //
        // *********Fill in Template drop down**********

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

        //************ Fill in Package list with packages *****************
        // get List of Packages
        PackageDB pkgDB = new PackageDB();
        ArrayList<Packages> p = pkgDB.getPackages(); // placeholder for get method
        ObservableList<Packages> observablePackages = FXCollections.observableArrayList(p);

        lvPackages.setItems(observablePackages);
        lvPackages.setCellFactory(packageListView -> (new PackageListViewCell()));


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

    private static String addTemplateData(String template, Packages pkg) {
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

