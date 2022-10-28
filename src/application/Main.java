package application;
	

import java.util.ArrayList;
import java.util.List;

import entidades.Competencia;
import entidades.ItemCompetencia;
import entidades.Puesto;
import gestores.GestorDePuesto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			Parent root = FXMLLoader.load((getClass().getResource("/views/PantallaIngreso.fxml")));
			
			Scene scene = new Scene(root);
			primaryStage.setTitle("Ingreso al sistema");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		launch(args);
		/*Competencia comp = new Competencia(345,"liderazgo","debe poder liderar su grupo de trabajo");
		List<ItemCompetencia> competencias = new ArrayList<ItemCompetencia>();
		Puesto puesto = new Puesto(123, "gerente", "McDonalds", "Se necesita para el 3/10", competencias);
		puesto.addItemCompetencia(new ItemCompetencia(puesto, comp, 10));
		GestorDePuesto.getInstance();
		GestorDePuesto.getDao().createPuesto(puesto);*/
	}
}
