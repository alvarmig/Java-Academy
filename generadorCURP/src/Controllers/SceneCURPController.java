/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Entidad;
import Beans.Genero;
import Persistencia.DataAdapters.catCURPAdapter;
import Persistencia.DataAdapters.catEntidadAdapter;
import Persistencia.DataAdapters.catGeneroAdapter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Miguel
 */
public class SceneCURPController implements Initializable {

    catCURPAdapter catcurpadapter = new catCURPAdapter();
    catGeneroAdapter catgeneroadapter = new catGeneroAdapter();
    catEntidadAdapter catentidadadapter = new catEntidadAdapter();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtApellidoPaterno;

    @FXML
    private TextField txtApellidoMaterno;

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtEntidad;

    @FXML
    private TextField txtFechaNacimiento;

    @FXML
    private ChoiceBox<Genero> choiceGenero;

    @FXML
    private Button btnObtener;

    @FXML
    private TextField txtCURP;

    @FXML
    private Button btnBorrar;

    @FXML
    private DatePicker dpFechaNacimiento;

    @FXML
    private ComboBox<Entidad> cmbEntidad;

    @FXML
    void btnBorrar_ActionPerformed(ActionEvent event) {
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtNombres.setText("");
        choiceGenero.getItems().clear();
        txtFechaNacimiento.setText("");

        //txtGenero.setText("");
        txtCURP.setText("");
    }

    @FXML
    void btnObtener_ActionPerformed(ActionEvent event) {

        if (validarCampos()) {
            StringBuilder sbCurp = new StringBuilder();
            sbCurp.append(txtApellidoPaterno.getText().substring(0, 2));
            sbCurp.append(txtApellidoMaterno.getText().substring(0, 1));

            sbCurp.append(validarNombre(txtNombres.getText()).substring(0, 1));
            sbCurp.append(dpFechaNacimiento.getValue().toString().replace("/", "").substring(2, 8));

            sbCurp.append(choiceGenero.getSelectionModel().getSelectedItem().getClave());
            /*if (choiceGenero.getValue().matches("(H?M?)")) {
                sbCurp.append(choiceGenero.getValue());
            }*/
            //sbCurp.append(txtGenero.getText());
            sbCurp.append(cmbEntidad.getSelectionModel().getSelectedItem().getID());

            txtCURP.setText(sbCurp.toString());

            if (JOptionPane.showConfirmDialog(null, "Desea guardar la informacion?", "Atencion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (catcurpadapter.Insert(txtCURP.getText(), txtApellidoPaterno.getText(), txtApellidoMaterno.getText(), txtNombres.getText(), "", "",
                        cmbEntidad.getSelectionModel().getSelectedItem().getID(), choiceGenero.getSelectionModel().getSelectedItem().getID())) {
                    JOptionPane.showMessageDialog(null, "Registro guardado");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Llenar campos de texto");
        }

    }

    @FXML
    void initialize() {
        assert txtApellidoPaterno != null : "fx:id=\"txtApellidoPaterno\" was not injected: check your FXML file 'sceneCURP.fxml'.";
        assert txtApellidoMaterno != null : "fx:id=\"txtApellidoMaterno\" was not injected: check your FXML file 'sceneCURP.fxml'.";
        assert txtNombres != null : "fx:id=\"txtNombres\" was not injected: check your FXML file 'sceneCURP.fxml'.";
        assert txtEntidad != null : "fx:id=\"txtEntidad\" was not injected: check your FXML file 'sceneCURP.fxml'.";
        assert btnObtener != null : "fx:id=\"btnObtener\" was not injected: check your FXML file 'sceneCURP.fxml'.";
        assert txtCURP != null : "fx:id=\"txtCURP\" was not injected: check your FXML file 'sceneCURP.fxml'.";
        assert btnBorrar != null : "fx:id=\"btnBorrar\" was not injected: check your FXML file 'sceneCURP.fxml'.";
        assert choiceGenero != null : "fx:id=\"choiceGenero\" was not injected: check your FXML file 'sceneCURP.fxml'.";
        assert dpFechaNacimiento != null : "fx:id=\"dpFechaNacimiento\" was not injected: check your FXML file 'sceneCURP.fxml'.";
        assert cmbEntidad != null : "fx:id=\"cmbEntidad\" was not injected: check your FXML file 'sceneCURP.fxml'.";

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loadChoiceBoxGenero();
        loadComboBoxEntidad();

        /* dpFechaNacimiento.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*$")) {
                    txtFechaNacimiento.setText(oldValue);
                }
            }
        });*/
    }

    private String validarNombre(String nombreDeOrigen) {

        if (nombreDeOrigen.contains("MARÍA") && nombreDeOrigen.length() > 6) {
            nombreDeOrigen.replace("MARÍA", "");
        }
        if (nombreDeOrigen.contains("JOSE") && nombreDeOrigen.length() > 6) {
            nombreDeOrigen.replace("JOSE", "");
        }

        return nombreDeOrigen;
    }

    private void loadChoiceBoxGenero() {
        choiceGenero.getItems().clear();
        ObservableList<Genero> categoryData = FXCollections.observableArrayList(catgeneroadapter.Select());

        choiceGenero.getItems().addAll(categoryData);
    }

    private void loadComboBoxEntidad() {
        cmbEntidad.getItems().clear();
        ObservableList<Entidad> categoryData = FXCollections.observableArrayList(catentidadadapter.Select());

        cmbEntidad.getItems().addAll(categoryData);
    }

    private boolean validarCampos() {
        boolean validado = true;

        if (txtApellidoPaterno.getText().isEmpty()) {
            validado = false;
        }
        if (txtApellidoMaterno.getText().isEmpty()) {
            validado = false;
        }
        if (txtNombres.getText().isEmpty()) {
            validado = false;
        }
        if (choiceGenero.getSelectionModel().getSelectedItem().getID() == 0) {
            validado = false;
        }
        if (dpFechaNacimiento.getValue() == null) {
            validado = false;
        }
        if (cmbEntidad.getSelectionModel().getSelectedIndex() == 0) {
            validado = false;
        }

        return validado;
    }

}
