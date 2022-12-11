package controllers;

import java.io.IOException;
import java.util.List;
import entidades.Candidato;
import gestores.GestorDeCandidato;
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
	
	//public List<Candidato> listaCandidatos;
	
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
    	GestorDeCandidato gestorCandidatos = GestorDeCandidato.getInstance();
    	int nroCandidato;
    	if(nroTextField.equals("")) nroCandidato = -1; else nroCandidato = Integer.parseInt(nroTextField.getText());
    	List<Candidato> candidatosEncontrados = 
    			gestorCandidatos.buscarCandidatos(apellidoTextField.getText(), 
    			nombreTextField.getText(), 
    			nroCandidato);
    	
    }

    @FXML
    void quitarButtonClicked(ActionEvent event) {
    	
    }

    @FXML
    void salirClicked(ActionEvent event) {

    }

    @FXML
    void siguienteButtonClicked(ActionEvent event) {
    	
    	/*
    	GestorDeCandidato gestorCandidato = GestorDeCandidato.getInstance();
    	if(gestorCandidato.validarCuestionarios(listaCandidatos)) llamo interfaz;
    	//else IncluirAlerta()*/
    	EvaluarFuncionInterfaz(null);

    }
    
    
    void alertaUsuarioEnCurso(List<Candidato> listaEnCurso) {
    
    	Stage alertaStage = new Stage();
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/alertaUsuariosEnCurso.fxml")));
			Scene scene = new Scene(root);
			alertaStage.setTitle("Candidatos en curso");
			alertaStage.setScene(scene);
			alertaStage.show();
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
    
   void EvaluarFuncionInterfaz(List<Candidato> listaCandidatos) {
	   
		Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/EvaluarFuncionesCandidatos.fxml")));
			Stage window = (Stage)siguienteButton.getScene().getWindow();
			window.setTitle("Evaluar Candidatos");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   
	   
	   
   }

}
