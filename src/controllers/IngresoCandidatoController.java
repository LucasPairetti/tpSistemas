package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gestores.GestorDeAutenticacion;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IngresoCandidatoController implements Initializable {

    @FXML
    private Button ingresarButton;

    @FXML
    private CheckBox mostrarContraseñaCheck;

    @FXML
    private PasswordField passwordFieldHidden;

    @FXML
    private TextField passwordFieldShowed;

    @FXML
    private Button salirButton;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private ComboBox<String> tipoDocComboBox;

    @FXML
    private TextField usuarioTextField;

    @FXML
    private Button volverButton;
    
    @FXML
    private Text errorClaveText;

    @FXML
    private Text errorDocText;

    @FXML
    private Text errorNumText;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	tipoDocComboBox.setItems(FXCollections.observableArrayList("DNI","Pasaporte"));
    	errorDocText.setOpacity(0);
    	errorNumText.setOpacity(0);
    	errorClaveText.setOpacity(0);
	}

    @FXML
    void MostrarContraseña(ActionEvent event) {

    	if(mostrarContraseñaCheck.isSelected()) {
    		passwordFieldShowed.setText(passwordFieldHidden.getText());
    		passwordFieldHidden.setVisible(false);
    		passwordFieldShowed.setVisible(true);
    		
    	}else {
    		passwordFieldHidden.setText(passwordFieldShowed.getText());
    		passwordFieldShowed.setVisible(false);
    		passwordFieldHidden.setVisible(true);
    	
    	}
    }

    @FXML
    void ingresarButtonClicked(ActionEvent event) {
    	if(!checkearCampos()) {
    		return;
    	}
    	String tipoDoc= tipoDocComboBox.getSelectionModel().getSelectedItem();
    	int  nroDoc=Integer.parseInt(usuarioTextField.getText());
    	String clave;
    	if(passwordFieldHidden.getText().length()>=passwordFieldShowed.getText().length()) { //este if lo pongo xq como son dos textfield, no se cual es el completo (asumo que es el que tiene mas caracteres)
    		clave = passwordFieldHidden.getText(); 
    	}else {
    		clave = passwordFieldShowed.getText(); 
    	}
    	
    	
    	GestorDeAutenticacion gestorDeAutenticacion = GestorDeAutenticacion.getInstance();
    	
    	if(!gestorDeAutenticacion.autenticarCandidato(tipoDoc, nroDoc, clave)) {
    		System.out.println("Los datos ingresados no son válidos o no existe un cuestionario para el Candidato"); 
    		return;}
    	
    	/*
    	 * tenes tipoDoc, nroDoc y clave para como atributos para hacer la validacion
    	 * misma logica que en validar consultor, solo que aun no tengo pensada la interfaz que le sigue a esto
    	 * 
    	 */
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/CompletarCuestionario.fxml")));
			Stage window = (Stage)ingresarButton.getScene().getWindow();
			window.setTitle("Usuario consultor");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }

    @FXML
    void salirButtonClicked(ActionEvent event) {
    	Stage stage = (Stage) scenePane.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void volverButtonClicked(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/PantallaIngreso.fxml")));
			Stage window = (Stage)volverButton.getScene().getWindow();
			window.setTitle("Ingreso al sistema");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	
    
    Boolean checkearCampos() {
    	Boolean flag=true;
    	
    	if(tipoDocComboBox.getSelectionModel().getSelectedItem()==null) {
    		flag=false;
    		errorDocText.setText("Elija un tipo de documento.");
    		errorDocText.setOpacity(1);
    		
    	}else errorDocText.setOpacity(0);
    	if(usuarioTextField.getText()=="") {
    		 flag=false;
    		 errorNumText.setText("Complete este campo, es obligatorio.");
    		 errorNumText.setOpacity(1);
    	}else errorNumText.setOpacity(0);
    	if ((passwordFieldShowed.getText()==""&&passwordFieldHidden.getText()=="")) {
    		flag=false;
    		errorClaveText.setText("Complete este campo, es obligatorio.");
    		errorClaveText.setOpacity(1);
    	 }else errorClaveText.setOpacity(0);
    	
    	
    	try {
    		if(flag) {
    		Integer.parseInt(usuarioTextField.getText());
    		}
    		

    		
    	}catch(Exception e) {
    		
    		errorNumText.setText("Caracteres inválidos, solo se aceptan numéricos.");
    		
    		errorNumText.setOpacity(1);
    		return false;
    	}
    	
    	/*try {
    		if(flag &&passwordFieldHidden.getText()!="" ) {
    		Integer.parseInt(passwordFieldHidden.getText());
    		}else if(flag &&passwordFieldShowed.getText()!="" ) {
        		Integer.parseInt(passwordFieldShowed.getText());
        		}
    		
    		//Controlar largo
    		
    	}catch(Exception e) {
    		
    		errorClaveText.setText("Caracteres inválidos, solo se aceptan numéricos.");
    		
    		errorClaveText.setOpacity(1);
    		return false;
    	}*/
    	
    	
    	return flag;
    }
    
    
    
    
    
    
    
    
    

    }


