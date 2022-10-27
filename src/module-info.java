module TPsistemas {
	requires javafx.controls;
	requires java.sql;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;
    
	opens application to javafx.graphics, javafx.fxml, javafx.base, org.hibernate.core, hibernate.jpa, jboss.annotations, jboss.jms.api,
	jboss.logging, jboss.transaction.api;
	opens entidades to javafx.base, org.hibernate.orm.core;
	opens controllers to javafx.fxml;
}
