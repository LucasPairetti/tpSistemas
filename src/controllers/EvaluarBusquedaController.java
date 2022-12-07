package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EvaluarBusquedaController {

    @FXML
    private TableView<?> CandidatoTableView;

    @FXML
    private Button agregarButton;

    @FXML
    private TableColumn<?, ?> apellidoBuscarColumn;

    @FXML
    private TableColumn<?, ?> apellidoColumn;

    @FXML
    private TextField apellidoTextField;

    @FXML
    private Button buscarButton;

    @FXML
    private TableView<?> buscarCandidatoTableView;

    @FXML
    private TableColumn<?, ?> nombreBuscarColumn;

    @FXML
    private TableColumn<?, ?> nombreColumn;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TableColumn<?, ?> nroBuscarColumn;

    @FXML
    private TextField nroTextField;

    @FXML
    private Button quitarButton;

    @FXML
    private Button salirButton;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Button siguienteButton;

    @FXML
    void agregarButtonClicked(ActionEvent event) {

    }

    @FXML
    void buscarButtonClicked(ActionEvent event) {

    }

    @FXML
    void quitarButtonClicked(ActionEvent event) {

    }

    @FXML
    void salirClicked(ActionEvent event) {

    }

    @FXML
    void siguienteButtonClicked(ActionEvent event) {

    	
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/alertaUsuariosEnCurso.fxml")));
			Stage window = (Stage)siguienteButton.getScene().getWindow();
			window.setTitle("Gestionar Puestos");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

}
