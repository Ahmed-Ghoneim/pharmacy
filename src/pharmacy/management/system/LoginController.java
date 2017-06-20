/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.management.system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author Ahmed
 */
public class LoginController implements Initializable, ControlledScreen {

    Connection conn = null;
    Statement stmt = null;
    TrayNotification notification;
    Encryption encryption;
    ScreensController myController;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private void login() throws Exception {
        String encPass = encryption.encrypt(password.getText());
        try {
            boolean found = false;
            String pass = "";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT username, email, password FROM employees;");
            
            while (rs.next()) {
                String user = rs.getString("username");
                String email = rs.getString("email");
                
                if ((username.getText().equals(user) || username.getText().equals(email))) {
                    found = true;
                    pass = rs.getString("password");
                    break;
                }
            }
            if (found&&encPass.equals(pass)) {
                goToManagerScreen();
//                notification = new TrayNotification("Welcome", "Logged in successfuly", NotificationType.SUCCESS);
//                notification.setAnimationType(AnimationType.POPUP);
//                notification.showAndDismiss(Duration.seconds(3));
                System.out.println("Hello\n");
            }else{
//                notification = new TrayNotification("Wrong", "username or password", NotificationType.ERROR);
//                notification.setAnimationType(AnimationType.POPUP);
//                notification.showAndDismiss(Duration.seconds(3));
                System.out.println("Try again\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void exitProgram() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:db/pharmacy.db");
            conn.setAutoCommit(false);
            
            encryption = new Encryption();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
    
    @FXML
    private void goToManagerScreen(){
       myController.setScreen(PharmacyManagementSystem.managerID);
    }
    
//    @FXML
//    private void goToEmployeeScreen(){
//       myController.setScreen(PharmacyManagementSystem.employeeID);
//    }

}
