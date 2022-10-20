module TPsistemas {
	requires javafx.controls;
	requires java.sql;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;
	
	
	
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
	opens entidades to javafx.base;
	opens controllers to javafx.fxml;
}
