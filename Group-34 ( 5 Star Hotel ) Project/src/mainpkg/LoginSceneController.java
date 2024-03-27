/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gouto
 */
public class LoginSceneController implements Initializable {

    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private ComboBox<String> userComboBox;
    @FXML
    private Label labelTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      userComboBox.getItems().addAll("CEO", "IT Manager", "Sales Manager", "Revenue Manager",
                "Restaurant Manager", "Accountant", "Hotel Receptionist",
                "Security Manager", "Customer", "Staff");
    }   
    Stage stage;

    @FXML
    private void onMouseClicked(MouseEvent event)  {
        labelTextField.setText("");
    }
    @FXML
    private void onMouseClickedpass(MouseEvent event) {
         labelTextField.setText("");
    }

    @FXML
    private void loginButton(ActionEvent event) throws IOException {
                boolean found = false;
        String userEmail = "";
        String userPassword ="";
        String userRole="";
        
        try {
           File file = new File("G:\\Spring\\CSE213\\Group-34-5-Star-Hotel-Project\\Group-34 ( 5 Star Hotel ) Project\\src\\files\\LoginUserInfo.txt");
            Scanner x = new Scanner(file);
            x.useDelimiter("[;\n]");
            
                while(x.hasNext() && !found){
                userEmail = x.next();
                userPassword = x.next();
                userRole = x.next();
                
                              
               if(userComboBox.getValue().equals("CEO")){
                    if(emailTextField.getText().equals(userEmail)
                        && passwordTextField.getText().equals(userPassword) 
                        && userComboBox.getValue().equals(userRole) ){
                        
                                            
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Login Confirmation");
                    alert.setHeaderText("Login Successfully");
                    alert.setContentText("Do you want to LogIn ? If not then click Cancel");
            
//            alert.show();
                    if(alert.showAndWait().get()==ButtonType.OK){
                        Parent homepage = FXMLLoader.load(getClass().getResource("/ceo/CEODashboardScene.fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show(); 
                    }

                    return;
                    
                }
               }
               
                              else if(userComboBox.getValue().equals("IT Manager")){
                   if(emailTextField.getText().equals(userEmail) 
                        && passwordTextField.getText().equals(userPassword)
                        && userComboBox.getValue().equals(userRole)){
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Login Confirmation");
                    alert.setHeaderText("Login Successfully");
                    alert.setContentText("Do you want to LogIn ? If not then click Cancel");
            
//            alert.show();
                    if(alert.showAndWait().get()==ButtonType.OK){
                        Parent homepage = FXMLLoader.load(getClass().getResource("/it_manager/IT_ManagerDashBoardScene.fxml"));
                        Scene scene = new Scene(homepage);
                        Stage addStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show();
                        
                    }

                    

                    return ;
                    
                }
               
               }
                    }
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No User Found");
            alert.setContentText("SIGN UP FIRST or (GIVEN THE ACCURATE INFORMATION)");
            alert.showAndWait();
                
                      
        }catch (Exception e) {
            System.out.println(e);
            labelTextField.setText("Enter Email and Password");
        }
    

    }

    @FXML
    private void singupButton(ActionEvent event) throws IOException {
       Parent singup=FXMLLoader.load(getClass().getResource("SingUp.fxml"));
        Scene newScene=new Scene(singup);
        Stage stg1= (Stage)((Node)event.getSource()).getScene().getWindow();
        stg1.setScene(newScene);
        stg1.show();
    }
    
}
