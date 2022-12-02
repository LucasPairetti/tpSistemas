package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entidades.Consultor;
import gestores.GestorDeAutenticacion;
import gestores.GestorDeConsultor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IngresoConsultorController implements Initializable {

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
    private TextField usuarioTextField;

    @FXML
    private Button volverButton;
    
    @FXML
    private Text errorPasswordText;

    @FXML
    private Text errorUsuarioText;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) { //este metodo que siempre está, es para inicializar la pantalla con datos o parametros
		// TODO Auto-generated method stub
    	errorUsuarioText.setOpacity(0);
    	errorPasswordText.setOpacity(0);
	}
  

    @FXML
    void ingresarButtonClicked(ActionEvent event) {
    	 
    	if(!validarCampos()) {
    		return;
    	}
    	
    	String password = passwordFieldHidden.getText();
    	String usuario = usuarioTextField.getText();
    	
    	if(passwordFieldShowed.getText().length() >= passwordFieldHidden.getText().length()) password = passwordFieldShowed.getText();
    	
    	GestorDeAutenticacion gestorDeAutenticacion = GestorDeAutenticacion.getInstance();
    	
    	if(!gestorDeAutenticacion.autenticarConsultor(usuario, password)) return;
    
    	//Salto a otra interfaz
    	Parent root;
		try {
			root = FXMLLoader.load((getClass().getResource("/views/UsuarioConsultor.fxml")));
			Stage window = (Stage)ingresarButton.getScene().getWindow();
			window.setTitle("Usuario consultor");
	    	window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
   	
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
	
     boolean validarCampos() { //esto revisa que los campos no esten incompletos
    	 Boolean flag = true;
    	 
    	 if(usuarioTextField.getText()=="") {
    		 flag=false;
    		 errorUsuarioText.setText("Complete este campo, es obligatorio.");
    		 errorUsuarioText.setOpacity(1);
    		 
    	 }else errorUsuarioText.setOpacity(0);
    		 
    	if ((passwordFieldShowed.getText()=="" && passwordFieldHidden.getText()=="")) {
    		flag=false;
    		errorPasswordText.setText("Complete este campo, es obligatorio.");
    		errorPasswordText.setOpacity(1);
    	 }else errorPasswordText.setOpacity(0);
    		
    	 return flag;
    	 
     }

}
