package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entidades.*;
import gestores.GestorDeCompetencias;
import gestores.GestorDePuesto;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AltaPuestoController implements Initializable {
	GestorDePuesto gestorPuesto = GestorDePuesto.getInstance();
	GestorDeCompetencias gestorCompetencias = GestorDeCompetencias.getInstance();

    @FXML
    private Button AceptarButton;

    @FXML
    private Button agregarItemButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private TextField codigoTextField;

    @FXML
    private TableColumn<Competencia, String> competenciaColumn;

    @FXML
    private TableColumn<ItemCompetencia, String> competenciaItemColumn;

    @FXML
    private TableView<Competencia> competenciasTableView;

    @FXML
    private TextArea descripcionTextArea;

    @FXML
    private Button eliminarItemButton;

    @FXML
    private TextField empresaTextField;

    @FXML
    private TableView<ItemCompetencia> itemCompetenciatableView;

    @FXML
    private TableColumn<ItemCompetencia, Integer> ponderacionColumn;

    @FXML
    private TextField ponderacionTextField;

    @FXML
    private TextField puestoTextField;
    
    @FXML
    private Text ponderacionErrorText;
    
    @FXML
    private Text nombreErrorText;
    
    @FXML
    private Text empresaErrorText;
    
    @FXML
    private Text codigoErrorText;
    
    private List<ItemCompetencia> listadoDeCompetencias = new ArrayList<ItemCompetencia>();
    
    
    ObservableList<ItemCompetencia> listaItemCompetencia = FXCollections.observableArrayList();  
    ObservableList<Competencia> listaCompetencias= FXCollections.observableArrayList(); 
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {	
    	
    	//escondo los mensajes de error
    	nombreErrorText.setOpacity(0);
    	codigoErrorText.setOpacity(0);
    	empresaErrorText.setOpacity(0);
    	ponderacionErrorText.setOpacity(0);
    	
    	
    	
        // TODO Auto-generated method stub
        //buscar todas las competencias y agregarlas a listaCompetencias
        listaCompetencias.addAll(gestorCompetencias.getAllCompetencia());
        //formatear tablas
        ObservableList<ItemCompetencia> listaItemCompetencia = FXCollections.observableArrayList();
        //ObservableList<Competencia> listaCompetencias= FXCollections.observableArrayList(); 


        competenciaColumn.setCellValueFactory(new PropertyValueFactory<>("nombreCompetencia"));



        competenciaItemColumn.setCellValueFactory(data ->{
            ItemCompetencia itemcompetencia = data.getValue();
            Competencia competencia = itemcompetencia.getCompetencia();
            String nombreCompetencia = competencia.getNombreCompetencia();
            return new ReadOnlyStringWrapper(nombreCompetencia);

        });



        ponderacionColumn.setCellValueFactory(new PropertyValueFactory<>("ponderacion"));

        //Competencia pruebaCompetencia = new Competencia(1234,"Lealtad", "prueba de lealtad");
        //listaCompetencias.addAll(listaCompetencias);

        //mostrarlas
        competenciasTableView.setItems(listaCompetencias);

    }

   

    @FXML
    void AceptarButtonClicked(ActionEvent event) {

        if(checkearCamposPuesto()) {

            if( gestorPuesto.getPuestoByCodigo(Integer.parseInt(codigoTextField.getText()))!=null)  {
            	Alert alerta= new Alert(Alert.AlertType.WARNING);
            	alerta.setTitle("puesto existente");
            	alerta.setContentText("ya existe un puesto con este codigo");
            	alerta.showAndWait();
            }
            else if(gestorPuesto.getPuestoByNombre(puestoTextField.getText())!=null ) {
            	Alert alerta= new Alert(Alert.AlertType.WARNING);
            	alerta.setTitle("puesto existente");
            	alerta.setContentText("ya existe un puesto con este nombre");
            	alerta.showAndWait();
            	
            }else if(listadoDeCompetencias.isEmpty()) {
            	
            	Alert alerta= new Alert(Alert.AlertType.WARNING);
            	alerta.setTitle("Faltan competencias");
            	alerta.setContentText("Debe agregar al menos una competencia");
            	alerta.showAndWait();
            	
            	
            }
            
            
            
            else {
            	 Puesto puesto = gestorPuesto.createPuesto(Integer.parseInt(codigoTextField.getText()), puestoTextField.getText(), empresaTextField.getText(), descripcionTextArea.getText(), listadoDeCompetencias);
                 gestorPuesto.createPuesto(puesto);
                
                 Parent root;
                 try {
                     root = FXMLLoader.load((getClass().getResource("/views/GestionarPuesto.fxml")));
                     Stage window = (Stage)AceptarButton.getScene().getWindow();
                     window.setTitle("Gestionar Puestos");
                     window.setScene(new Scene(root));
                 } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                 }
           
            }

      
        
        }
    }
    
    @FXML
    void agregarItemButtonClicked(ActionEvent event) {
    	if(checkearCamposCompetencia()) {
    		Boolean flagRepetido=true;
    	Competencia competenciaElegida = competenciasTableView.getSelectionModel().getSelectedItem();
    	for(ItemCompetencia item: listaItemCompetencia) {
    		if(item.getCompetencia().equals(competenciaElegida))flagRepetido=false;
    		
    	}
    	
    	if(flagRepetido) {
    		ItemCompetencia nuevoItemCompetencia = new ItemCompetencia (competenciaElegida, Integer.parseInt(ponderacionTextField.getText()));
        	listadoDeCompetencias.add(nuevoItemCompetencia);
        	listaItemCompetencia.add(nuevoItemCompetencia);
        	itemCompetenciatableView.setItems(listaItemCompetencia);
    		
    	}
    		
    	
    	
    	}
    	

    }

  

    @FXML
    void cancelarButtonClicked(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/GestionarPuesto.fxml")));
			Stage window = (Stage)cancelarButton.getScene().getWindow();
			window.setTitle("Gestionar puesto");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void eliminarItemButtonClicked(ActionEvent event) {
    	ItemCompetencia itemCompetencia = itemCompetenciatableView.getSelectionModel().getSelectedItem();
        listadoDeCompetencias.remove(itemCompetencia);
        listaItemCompetencia.remove(itemCompetencia);
        itemCompetenciatableView.setItems(listaItemCompetencia);
    }
    
    public Boolean checkearCamposPuesto() { //validos =true, incompletos o con error setea los textos y retorna false
    	Boolean flag = true;
    	
    	
    	
    	
    	
    	if(codigoTextField.getText()=="") {
    		
    		flag = false;
    		codigoErrorText.setText("complete este campo obligatorio");
    		
    		codigoErrorText.setOpacity(1);
    	}else codigoErrorText.setOpacity(0);
    		
    		
    	if(empresaTextField.getText()=="") {
    		flag = false;
    		empresaErrorText.setText("complete este campo obligatorio");
    		
    		empresaErrorText.setOpacity(1);
    	}else empresaErrorText.setOpacity(0);
    	
    	if(puestoTextField.getText()=="") {
    		flag = false;
    		nombreErrorText.setText("complete este campo obligatorio");
    		
    		nombreErrorText.setOpacity(1);
    	}else nombreErrorText.setOpacity(0);
    	
    	try {
    		if(flag) {
    		Integer.parseInt(codigoTextField.getText());
    		}
    		
    		return flag;
    		
    	}catch(Exception e) {
    		
    		codigoErrorText.setText("caracteres invalidos, solo se aceptan numericos");
    		
    		codigoErrorText.setOpacity(1);
    		return false;
    	}
    	
    	
    	
    	
    	
    }
    
    public Boolean checkearCamposCompetencia() {
    	Boolean flag= true;
    	
    	
    	if(ponderacionTextField.getText()=="") {
    		flag =false;
    		ponderacionErrorText.setText("complete este campo obligatorio");
    		
    		ponderacionErrorText.setOpacity(1);
    		
    		
    	}else if(competenciasTableView.getSelectionModel().getSelectedItem()==null) {
    		flag=false;
    		ponderacionErrorText.setText("seleccione una competencia");
    		
    		ponderacionErrorText.setOpacity(1);	
    		
    	}else ponderacionErrorText.setOpacity(0);
    	
    	try {
    		if(flag) {
    			Integer.parseInt(ponderacionTextField.getText());
    		}
    		
    		return flag;
    		
    	}catch (Exception e) {
    		
    		ponderacionErrorText.setText("caracteres invalidos\nsolo se aceptan numericos");
    		
    		ponderacionErrorText.setOpacity(1);
    		return false;
    		
    	}
    	
  
	
    }
    
	

}
