package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import DTOS.CandidatoDTO;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EvaluarBusquedaController implements Initializable {
	
	//public List<Candidato> listaCandidatos;
	GestorDeCandidato gestorCandidatos = GestorDeCandidato.getInstance();
	
    @FXML
    private TableView<CandidatoDTO> CandidatoTableView;

    @FXML
    private Button agregarButton;

    @FXML
    private TableColumn<CandidatoDTO, String> apellidoBuscarColumn;

    @FXML
    private TableColumn<CandidatoDTO, String> apellidoColumn;

    @FXML
    private TextField apellidoTextField;

    @FXML
    private Button buscarButton;

    @FXML
    private TableView<CandidatoDTO> buscarCandidatoTableView;

    @FXML
    private TableColumn<CandidatoDTO, String> nombreBuscarColumn;

    @FXML
    private TableColumn<CandidatoDTO, String> nombreColumn;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TableColumn<CandidatoDTO, Integer> nroBuscarColumn;
    @FXML
    private TableColumn<CandidatoDTO, Integer> nroCandidatoColumn;

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
    
    ObservableList<CandidatoDTO> listaCandidatosBuscados = FXCollections.observableArrayList(); 
    ObservableList<CandidatoDTO> listaCandidatosSeleccionados = FXCollections.observableArrayList(); 
    List<CandidatoDTO> candidatosSiguienteInterfaz = new ArrayList<CandidatoDTO>();
    
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	// TODO Auto-generated method stub
    	
    	apellidoBuscarColumn.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    	nombreBuscarColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	nroBuscarColumn.setCellValueFactory(new PropertyValueFactory<>("numeroDocumento"));
    	
    	apellidoColumn.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    	nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	nroCandidatoColumn.setCellValueFactory(new PropertyValueFactory<>("numeroDocumento"));
    	
    	
    	
    	listaCandidatosBuscados.addAll(gestorCandidatos.getAllCandidatosDTO());
    	buscarCandidatoTableView.setItems(listaCandidatosBuscados);
    	
    }
    
    
    

    @FXML
    void agregarButtonClicked(ActionEvent event) {
    	if(!listaCandidatosSeleccionados.contains(buscarCandidatoTableView.getSelectionModel().getSelectedItem())) {
    	listaCandidatosSeleccionados.add(buscarCandidatoTableView.getSelectionModel().getSelectedItem());
    	candidatosSiguienteInterfaz.add(buscarCandidatoTableView.getSelectionModel().getSelectedItem());
    	CandidatoTableView.setItems(listaCandidatosSeleccionados);
    	}
    }

    @FXML
    void buscarButtonClicked(ActionEvent event) {
    	List<CandidatoDTO> candidatosDTOencontrados= new ArrayList<CandidatoDTO> ();
    	int nroCandidato;
    	if(nroTextField.equals("")) nroCandidato = -1; else nroCandidato = Integer.parseInt(nroTextField.getText());
    	List<Candidato> candidatosEncontrados = 
    			gestorCandidatos.buscarCandidatos(apellidoTextField.getText(), 
    			nombreTextField.getText(), 
    			nroCandidato);
    	for(Candidato c: candidatosEncontrados) {
    		candidatosDTOencontrados.add(gestorCandidatos.getCandidatoDTO(c));
    	}
    	buscarCandidatoTableView.setItems((ObservableList<CandidatoDTO>) candidatosDTOencontrados);
    	
    }

    @FXML
    void quitarButtonClicked(ActionEvent event) {
    	if(CandidatoTableView.getSelectionModel().getSelectedItem()!=null) {
    		listaCandidatosSeleccionados.remove(CandidatoTableView.getSelectionModel().getSelectedItem());
    		candidatosSiguienteInterfaz.remove(CandidatoTableView.getSelectionModel().getSelectedItem());
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
    	EvaluarFuncionInterfaz(candidatosSiguienteInterfaz);

    }
    
    
    void alertaUsuarioEnCurso(List<CandidatoDTO> listaEnCurso) {
    	
    	
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
    
   void EvaluarFuncionInterfaz(List<CandidatoDTO> listaCandidatosSeleccionados2) {
	   	System.out.println(listaCandidatosSeleccionados2.get(0).getNombre());
	   	Parent root;
	   	FXMLLoader loader = new FXMLLoader((getClass().getResource("/views/EvaluarFuncionesCandidatos.fxml")));
		try {
			loader.setLocation((getClass().getResource("/views/EvaluarFuncionesCandidatos.fxml")));
			root = loader.load();
			
			
			EvaluarFuncionesController display = loader.getController();
			display.setCandidatos(listaCandidatosSeleccionados2);
			
			Stage window = (Stage)siguienteButton.getScene().getWindow();
			window.setTitle("Evaluar Candidatos");
	    	window.setScene(new Scene(loader.getRoot()));
	    	window.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   
	   
	   
   }



}
