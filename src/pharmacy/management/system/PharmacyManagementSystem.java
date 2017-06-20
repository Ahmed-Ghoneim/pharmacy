/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.management.system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed
 */
//background  #5fc5fc
public class PharmacyManagementSystem extends Application {
    
    public static String loginID = "main";
    public static String loginFile = "Login.fxml";
    public static String managerID = "screen2";
    public static String managerFile = "Manager.fxml";
    public static String employeeID = "screen3";
    public static String employeeFile = "Employee.fxml";
    
    static Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(PharmacyManagementSystem.loginID, PharmacyManagementSystem.loginFile);
        mainContainer.loadScreen(PharmacyManagementSystem.managerID, PharmacyManagementSystem.managerFile);
//        mainContainer.loadScreen(PharmacyManagementSystem.employeeID, PharmacyManagementSystem.employeeFile);
        
        mainContainer.setScreen(PharmacyManagementSystem.loginID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        
        stage.setTitle("Pharmacy Management System");
        stage.setMaximized(true);
        stage.getIcons().add(new Image("images/pharma logo.png"));
        stage.setOpacity(.97);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
