/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.management.system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */

public class ManagerController implements Initializable, ControlledScreen {

    /**
     * Initializes the controller class.
     */
    
    ScreensController myController;
    TextField searchBox;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @Override
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

//    
//    private void goToScreen1(){
//       myController.setScreen(ScreensFramework.screen1ID);
//    }
//    
//    private void goToScreen3(ActionEvent event){
//       myController.setScreen(ScreensFramework.screen3ID);
//    }
    
}
