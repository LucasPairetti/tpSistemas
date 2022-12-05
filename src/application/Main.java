package application;
	

import java.util.Date;

import gestores.GestorDeCandidato;
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
		//Date fecha = new Date(2020,11,03);
		//GestorDeCandidato gestorDeCandidato = GestorDeCandidato.getInstance();
		//gestorDeCandidato.createCandidato(1234567, "ABCDEF123", null, "DNI", null, 1, "Lucas",
				//"Pairetti", fecha, "Argentina", "ljp@gmail.com", "secundario", false);
		
		launch(args);
		
		//GestorDeConsultor gestorDeConsultor = GestorDeConsultor.getInstance();
		//gestorDeConsultor.createConsultor("TomasDannunzio", "Ramona123");
		/*
		Competencia comp = new Competencia(345,"liderazgo","debe poder liderar su grupo de trabajo");
		GestorDeCompetencias.getInstance().createCompetencia(comp);
		List<ItemCompetencia> competencias = new ArrayList<ItemCompetencia>();
		Puesto puesto = new Puesto(123, "gerente", "McDonalds", "Se necesita para el 3/10", competencias);
		puesto.addItemCompetencia(new ItemCompetencia(comp, 10));
		GestorDePuesto.getInstance();
		GestorDePuesto.getDao().createPuesto(puesto);
		*/
	}
}
