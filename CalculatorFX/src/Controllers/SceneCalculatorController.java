/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Miguel
 */
public class SceneCalculatorController implements Initializable {

    StringBuilder operacion = new StringBuilder();

    int resultado = 0;
    // <editor-fold desc="Definicion de variables globales">
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtPantallaCalculo;

    @FXML
    private Button btnUno;

    @FXML
    private Button btnDos;

    @FXML
    private Button btnTres;

    @FXML
    private Button btnCuatro;

    @FXML
    private Button btnCinco;

    @FXML
    private Button btnSeis;

    @FXML
    private Button btnSiete;

    @FXML
    private Button btnOcho;

    @FXML
    private Button btnNueve;

    @FXML
    private Button btnCero;

    @FXML
    private Button btnIgual;

    @FXML
    private Button btnSuma;

    @FXML
    private Button btnResta;

    @FXML
    private Button btnClear;

    // </editor-fold>
    // <editor-fold desc="Definicion de eventos">
    @FXML
    void btnCero_ActionPerformed(ActionEvent event) {
        operacion.append("0");
        mostrarEnPantalla();
    }

    @FXML
    void btnCinco_ActionPerformed(ActionEvent event) {
        operacion.append("5");
        mostrarEnPantalla();
    }

    @FXML
    void btnClear_ActionPerformed(ActionEvent event) {
        operacion.setLength(0);
        mostrarEnPantalla();
    }

    @FXML
    void btnCuatro_ActionPerformed(ActionEvent event) {
        operacion.append("4");
        mostrarEnPantalla();
    }

    @FXML
    void btnDos_ActionPerformed(ActionEvent event) {
        operacion.append("2");
        mostrarEnPantalla();
    }

    @FXML
    void btnIgual_ActionPerformed(ActionEvent event) {
        String operacionSuma = String.valueOf(operacion.indexOf("+"));
        String operacionResta = String.valueOf(operacion.indexOf("-"));

        boolean operadorSuma = false;
        if (operacionSuma != "-1") {
            operadorSuma = true;
            realizarOperacion(operacionSuma, operadorSuma);
        } else if (operacionResta != "-1") {
            realizarOperacion(operacionResta, operadorSuma);

        } else {
            JOptionPane.showMessageDialog(null, "Elige una operacón");
        }

    }

    @FXML
    void btnNueve_ActionPerformed(ActionEvent event) {
        operacion.append("9");
        mostrarEnPantalla();
    }

    @FXML
    void btnOcho_ActionPerformed(ActionEvent event) {
        operacion.append("8");
        mostrarEnPantalla();
    }

    @FXML
    void btnResta_ActionPerformed(ActionEvent event) {
        operacion.append("-");
        mostrarEnPantalla();
    }

    @FXML
    void btnSeis_ActionPerformed(ActionEvent event) {
        operacion.append("6");
        mostrarEnPantalla();
    }

    @FXML
    void btnSiete_ActionPerformed(ActionEvent event) {
        operacion.append(7);
        mostrarEnPantalla();
    }

    @FXML
    void btnSuma_ActionPerformed(ActionEvent event) {
        operacion.append("+");
        mostrarEnPantalla();
    }

    @FXML
    void btnTres_ActionPerformed(ActionEvent event) {
        operacion.append("3");
        mostrarEnPantalla();
    }

    @FXML
    void btnUno_ActionPerformed(ActionEvent event) {
        operacion.append("1");
        mostrarEnPantalla();
    }
    // </editor-fold>

    @FXML
    void initialize() {
        assert txtPantallaCalculo != null : "fx:id=\"txtPantallaCalculo\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnUno != null : "fx:id=\"btnUno\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnDos != null : "fx:id=\"btnDos\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnTres != null : "fx:id=\"btnTres\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnCuatro != null : "fx:id=\"btnCuatro\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnCinco != null : "fx:id=\"btnCinco\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnSeis != null : "fx:id=\"btnSeis\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnSiete != null : "fx:id=\"btnSiete\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnOcho != null : "fx:id=\"btnOcho\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnNueve != null : "fx:id=\"btnNueve\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnCero != null : "fx:id=\"btnCero\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnIgual != null : "fx:id=\"btnIgual\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnSuma != null : "fx:id=\"btnSuma\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnResta != null : "fx:id=\"btnResta\" was not injected: check your FXML file 'sceneCalculator.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'sceneCalculator.fxml'.";

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void mostrarEnPantalla() {
        txtPantallaCalculo.setText("");
        txtPantallaCalculo.setText(operacion.toString());
    }

    private void realizarOperacion(String operacionSuma, boolean esSuma) throws NumberFormatException {
        int operando;
        int operador;

        operando = Integer.parseInt(operacion.substring(0, Integer.parseInt(operacionSuma)));
        operador = Integer.parseInt(operacion.substring(Integer.parseInt(operacionSuma), operacion.length()));

        if (esSuma) {
            operando = operando + operador;

        } else {
            operando = operando - operador;

        }
        operacion.setLength(0);
        operacion.append(operando);

        mostrarEnPantalla();
    }

}
