package controllers;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import DTOS.*;
import entidades.Competencia;
import entidades.ItemCompetencia;
import entidades.Puesto;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class EvaluarFuncionesController implements Initializable{

    @FXML
    private TableView<CandidatoDTO> CandidatoTableView;

    @FXML
    private TableColumn<CandidatoDTO, String> apellidoColumn;

    @FXML
    private Button cancelarButton;

    @FXML
    private TableColumn<CandidatoDTO, String> claveIngresoColumn;

    @FXML
    private TableColumn<ItemCompetencia, String> competenciaColumn;

    @FXML
    private TableView<ItemCompetencia> competenciasTableView;

    @FXML
    private TableColumn<PuestoDTO, String> empresaPuestoColumn;

    @FXML
    private Button finalizarButton;

    @FXML
    private TableColumn<CandidatoDTO, String> nombreColumn;

    @FXML
    private TableColumn<PuestoDTO, String> nombrePuestoColumn;

    @FXML
    private TableColumn<CandidatoDTO, String> numeroDocColumn;

    @FXML
    private TableColumn<ItemCompetencia, String> ponderacionColumn;

    @FXML
    private TableView<PuestoDTO> puestoTableView;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Button seleccionarButton;

    @FXML
    private Button siguienteButton;

    @FXML
    private TableColumn<CandidatoDTO, String> tipoDocColumn;

    @FXML
    void cancelarButtonClicked(ActionEvent event) {

    }

    @FXML
    void finalizarButtonClicked(ActionEvent event) {

    }

    @FXML
    void seleccionarButtonClicked(ActionEvent event) {
    	
    	GestorDePuesto gestorPuesto = GestorDePuesto.getInstance();
    	if(!gestorPuesto.validarFactores(puestoDTO) {alertaCompetencias(null); return;}
    	
    	//Se muestran itemCompetencia


    }

    @FXML
    void siguienteButtonClicked(ActionEvent event) {
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				GestorDePuesto gestorPuesto = GestorDePuesto.getInstance();
				List<Puesto> listaPuestos = gestorPuesto.getAllPuestos();

				
				//hay que setear lo mismo que AltaPuesto sobre itemCompetencia para mostrar el STRING de la competencia en item competencia
		
	}
	
    void alertaCompetencias(List<Competencia> listaCompetencias) {
    	Stage alertaStage = new Stage();
    	Parent root;
		try {
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


}
