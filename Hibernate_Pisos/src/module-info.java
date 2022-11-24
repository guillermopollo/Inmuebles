module Hibernate_Pisos {
	requires javafx.controls;
	requires org.hibernate.orm.core;
	requires java.persistence;
	
	opens application to javafx.graphics, javafx.fxml;
}
