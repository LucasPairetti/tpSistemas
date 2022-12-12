package controllers;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import DTOS.*;
import entidades.Candidato;
import entidades.Competencia;
import entidades.ItemCompetencia;
import entidades.Puesto;
import gestores.GestorDeCompetencias;
import gestores.GestorDePuesto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class EvaluarFuncionesController implements Initializable{
	GestorDePuesto gestorPuesto = GestorDePuesto.getInstance();
	GestorDeCompetencias gestorCompetencias = GestorDeCompetencias.getInstance();
	

    @FXML
    private TableView<Candidato> CandidatoTableView;

    @FXML
    private TableColumn<Candidato, String> apellidoColumn;

    @FXML
    private Button cancelarButton;

    @FXML
    private TableColumn<Candidato, String> claveIngresoColumn;

    @FXML
    private TableColumn<ItemCompetencia, String> competenciaColumn;

    @FXML
    private TableView<ItemCompetencia> competenciasTableView;

    @FXML
    private TableColumn<PuestoDTO, String> empresaPuestoColumn;

    @FXML
    private Button finalizarButton;

    @FXML
    private TableColumn<Candidato, String> nombreColumn;

    @FXML
    private TableColumn<PuestoDTO, String> nombrePuestoColumn;

    @FXML
    private TableColumn<Candidato, Integer> numeroDocColumn;

    @FXML
    private TableColumn<ItemCompetencia, Integer> ponderacionColumn;

    @FXML
    private TableView<PuestoDTO> puestoTableView;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Button seleccionarButton;

    @FXML
    private Button siguienteButton;

    @FXML
    private TableColumn<Candidato, String> tipoDocColumn;
    
    
    private List<Candidato> candidatos;
    ObservableList<Candidato> listaCandidatosSeleccionados = FXCollections.observableArrayList(); 
    ObservableList<PuestoDTO> listaPuestos = FXCollections.observableArrayList();
    ObservableList<ItemCompetencia> listaItemCompetencia = FXCollections.observableArrayList();
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
    	
    	nombrePuestoColumn.setCellValueFactory(new PropertyValueFactory<>("nombrePuesto"));
    	empresaPuestoColumn.setCellValueFactory(new PropertyValueFactory<>("empresa"));
    	
    	apellidoColumn.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    	nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	numeroDocColumn.setCellValueFactory(new PropertyValueFactory<>("numeroDocumento"));
    	claveIngresoColumn.setCellValueFactory(new PropertyValueFactory<>("clave"));
    	tipoDocColumn.setCellValueFactory(new PropertyValueFactory<>("tipoDocumento"));
    	
    	competenciaColumn.setCellValueFactory(data ->{
            ItemCompetencia itemcompetencia = data.getValue();
            Competencia competencia = itemcompetencia.getCompetencia();
            String nombreCompetencia = competencia.getNombreCompetencia();
            return new ReadOnlyStringWrapper(nombreCompetencia);
            
            
            

        });
        ponderacionColumn.setCellValueFactory(new PropertyValueFactory<>("ponderacion"));
    	
    	
				
				List<PuestoDTO> listaPuestos = gestorPuesto.getAllpuestosDTO();
				puestoTableView.setItems((ObservableList<PuestoDTO>) listaPuestos);

		
	}

    @FXML
    void cancelarButtonClicked(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/EvaluarBusquedaCandidatos.fxml")));
			Stage window = (Stage)cancelarButton.getScene().getWindow();
			window.setTitle("Gestionar Puestos");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void finalizarButtonClicked(ActionEvent event) {
    	//aca se genera por cada candidato un cuestionario?
    	
    	
    	
    }

    @FXML
    void seleccionarButtonClicked(ActionEvent event) {
    	if(puestoTableView.getSelectionModel().getSelectedItem()==null) return;
    	PuestoDTO puesto = puestoTableView.getSelectionModel().getSelectedItem();
    	if(!gestorPuesto.validarFactores(puesto)) {
    		List<CompetenciaDTO> lista = new ArrayList<CompetenciaDTO>();
    		for(ItemCompetencia item: puesto.getCompetencias()) {
    			lista.add(gestorCompetencias.getCompetenciaDTO(item.getCompetencia()));
    		}
    		
    		alertaCompetencias(lista); 
    }else {
    	listaItemCompetencia.addAll(puesto.getCompetencias());
    	competenciasTableView.setItems(listaItemCompetencia);
    	
    	
    }
    
    }

    @FXML
    void siguienteButtonClicked(ActionEvent event) {
    	listaCandidatosSeleccionados.addAll(candidatos);
    	CandidatoTableView.setItems(listaCandidatosSeleccionados);
    	
    }

	
	
    void alertaCompetencias(List<CompetenciaDTO> listaCompetencias) {
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/views/alertaCompetenciaEvaluar.fxml"));
    	
    	Stage alertaStage = new Stage();
    	Parent root;
		try {
			loader.load();
			AlertaCompetenciasController display = loader.getController();
			display.agregarCompetencias(listaCompetencias);
			
			root = FXMLLoader.load((getClass().getResource("/views/alertaCompetenciaEvaluar.fxml")));
			Scene scene = new Scene(root);
			alertaStage.setTitle("Candidatos en curso");
			alertaStage.setScene(scene);
			alertaStage.show();
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    public void setCandidatos(List<Candidato> lista) {
    	candidatos= lista;
    }

}

