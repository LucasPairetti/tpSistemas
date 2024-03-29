package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAOS.ParametrosDaoImp;
import DTOS.BloqueDTO;
import gestores.GestorDeCuestionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResolverCuestionarioController implements Initializable{
	GestorDeCuestionario gestorCuestionario = GestorDeCuestionario.getInstance();

    @FXML
    private Button atrasButton;

    @FXML
    private Text nroBloqueText;

    @FXML
    private Text nroPreguntaText;

    @FXML
    private RadioButton opcion1radio;

    @FXML
    private RadioButton opcion2radio;

    @FXML
    private RadioButton opcion3radio;

    @FXML
    private RadioButton opcion4radio;

    @FXML
    private RadioButton opcion5radio;

    @FXML
    private RadioButton opcion6radio;

    @FXML
    private Text preguntaText;

    @FXML
    private Button salirButton;

    @FXML
    private Button siguienteButton;

    @FXML
    private Text tiempoRestanteText;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}    

    @FXML
    void atrasButtonClicked(ActionEvent event) {

    }

    @FXML
    void salirButtonClicked(ActionEvent event) {

    }

    @FXML
    void siguienteButtonClicked(ActionEvent event) {

    }



}
