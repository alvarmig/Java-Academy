/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorcurp;

import java.io.IOException;
import java.util.logging.Level;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Miguel
 */
public class GeneradorCURP extends Application {

    @Override
    public void start(Stage window) {
        try {

            Parent root; //Defino padre o raiz del documento

            //Cargo ventana al escenario o raiz del documento
            root = FXMLLoader.load(getClass().getResource("/Resources/Views/sceneCURP.fxml"));

            //Creo un nuevo escenario y le asigno la raiz
            Scene scene = new Scene(root);

            //A la ventana que estoy creando por parametros le asigno el escenario
            window.setScene(scene);

            //Asigno el titulo de la ventana
            window.setTitle("Control de divisas");
            //TODO: Manejar tamanos de ventanas

            //Muestro la ventana
            window.show();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(GeneradorCURP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //JOptionPane.

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
