module com.mycompany.examenfinalfinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.examenfinalfinal to javafx.fxml;
    exports com.mycompany.examenfinalfinal;
}
