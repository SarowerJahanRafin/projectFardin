package Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.*;
// public class Login_Controller {
//     @FXML
//     private Stage stage;

//     public void clickSignIn(ActionEvent event) throws IOException {
//         BorderPane root = FXMLLoader.load(getClass().getResource("menu.fxml"));
//         stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//         stage.setScene(new Scene(root));
//         stage.setResizable(false);
//         stage.show();
//     }

// }

public class Login_Controller {
    @FXML
    private Stage stage;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public void clickSignIn(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Check if the username and password are valid
        if (isValidLogin(username, password))
        // if (username == "name" && password == "passsword")
        {
            BorderPane root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } else {
            // Show an error message if the username and password are invalid
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Login");
            alert.setHeaderText(null);
            alert.setContentText("The username or password you entered is invalid. Please try again.");
            alert.showAndWait();
        }
    }

    private boolean isValidLogin(String username, String password) {
        // Replace this with your actual validation logic
        // String fileName =
        // ""C://Users\\User\\Downloads\\MySuperShop-main\\MySuperShop-main\\src\\Controllers\\input.txt";";
        String string1 = "";
        String string2 = "";
        String fileName = "src/Controllers/input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (string1.equals("")) {
                    string1 = line;
                } else if (string2.equals("")) {
                    string2 = line;
                    if (username.equals(string1) && password.equals(string2)) {
                        return true;
                    } else
                        string1 = string2 = "";
                    // }
                    // if (line != "") {
                    // String[] words = line.split(" ");
                    // if (words.length >= 1) {
                    // string1 = words[0];
                    // string2 = words[1];
                    // System.out.println(string1 + " " + string2);
                    // if (username.equals(string1) && password.equals(string2)) {
                    // return true;
                    // }
                    // }

                    // }
                }
            }
        } catch (

        IOException e) {
            e.printStackTrace();
        }
        // System.out.println(string1 + " " + string2);
        // System.out.println(username.equals(string1));
        // System.out.println(username + " " + string1 + " " + string2);
        // return username.equals(string1) && password.equals(string2);
        // return username.equals(string1);
        return true;
    }
}
