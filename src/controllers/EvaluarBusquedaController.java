package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import DTOS.CompetenciaDTO;
import entidades.Candidato;
import gestores.GestorDeCandidato;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EvaluarBusquedaController implements Initializable {
	
	//public List<Candidato> listaCandidatos;
	GestorDeCandidato gestorCandidatos = GestorDeCandidato.getInstance();
	
    @FXML
    private TableView<Candidato> CandidatoTableView;

    @FXML
    private Button agregarButton;

    @FXML
    private TableColumn<Candidato, String> apellidoBuscarColumn;

    @FXML
    private TableColumn<Candidato, String> apellidoColumn;

    @FXML
    private TextField apellidoTextField;

    @FXML
    private Button buscarButton;

    @FXML
    private TableView<Candidato> buscarCandidatoTableView;

    @FXML
    private TableColumn<Candidato, String> nombreBuscarColumn;

    @FXML
    private TableColumn<Candidato, String> nombreColumn;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TableColumn<Candidato, Integer> nroBuscarColumn;
    @FXML
    private TableColumn<Candidato, Integer> nroCandidatoColumn;

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
    
    ObservableList<Candidato> listaCandidatosBuscados = FXCollections.observableArrayList(); 
    ObservableList<Candidato> listaCandidatosSeleccionados = FXCollections.observableArrayList(); 
    
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	// TODO Auto-generated method stub
    	listaCandidatosBuscados.addAll(gestorCandidatos.getAllCandidato());
    	buscarCandidatoTableView.setItems(listaCandidatosBuscados);
    	
    }
    
    
    

    @FXML
    void agregarButtonClicked(ActionEvent event) {
    	listaCandidatosSeleccionados.add(buscarCandidatoTableView.getSelectionModel().getSelectedItem());
    	CandidatoTableView.setItems(listaCandidatosBuscados);
    	
    }

    @FXML
    void buscarButtonClicked(ActionEvent event) {
    	
    	int nroCandidato;
    	if(nroTextField.equals("")) nroCandidato = -1; else nroCandidato = Integer.parseInt(nroTextField.getText());
    	List<Candidato> candidatosEncontrados = 
    			gestorCandidatos.buscarCandidatos(apellidoTextField.getText(), 
    			nombreTextField.getText(), 
    			nroCandidato);
    	buscarCandidatoTableView.setItems((ObservableList<Candidato>) candidatosEncontrados);
    	
    }

    @FXML
    void quitarButtonClicked(ActionEvent event) {
    	if(CandidatoTableView.getSelectionModel().getSelectedItem()!=null) {
    		listaCandidatosSeleccionados.remove(CandidatoTableView.getSelectionModel().getSelectedItem());
    		CandidatoTableView.setItems(listaCandidatosSeleccionados);
    	}
    	
    }

    @FXML
    void salirClicked(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/UsuarioConsultor.fxml")));
			Stage window = (Stage)salirButton.getScene().getWindow();
			window.setTitle("Usuario consultor");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void siguienteButtonClicked(ActionEvent event) {
    	
    	/*
    	GestorDeCandidato gestorCandidato = GestorDeCandidato.getInstance();
    	if(gestorCandidato.validarCuestionarios(listaCandidatos)) llamo interfaz;
    	//else IncluirAlerta()*/
    	EvaluarFuncionInterfaz(listaCandidatosSeleccionados);

    }
    
    
    void alertaUsuarioEnCurso(List<Candidato> listaEnCurso) {
    	
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/views/alertaUsuariosEnCurso.fxml"));
    
    	Stage alertaStage = new Stage();
    	Parent root;
		try {
			loader.load();
			
			AlertaUsuariosEnCursoController display = loader.getController();
			display.setCandidatosEnCurso(listaEnCurso);
			
			
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
