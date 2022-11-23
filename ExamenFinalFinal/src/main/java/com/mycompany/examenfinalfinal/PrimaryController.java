package com.mycompany.examenfinalfinal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable {
    
    @FXML
      private TableView <Piso> tablapiso;
       @FXML
    private TableColumn <Piso,String> col1;
       @FXML
        private TableColumn <Piso,String> col2;
       @FXML
          private TableColumn <Piso,String> col3;
       @FXML
        private TableColumn <Piso,String> col4;
       @FXML
          private TableColumn <Piso,String> col5;
       @FXML
        private TableColumn <Piso,String> col6;
      @FXML
    private TextField idzona;
    
    @FXML
    private TextField Metros;
    
    @FXML
    private TextField Nombre;
    
    
    @FXML
    private TextField Telefono;
        
    @FXML
    private TextField Precio;
            
    @FXML
    private TextField IDpiso;
        @FXML
    private ComboBox TipoOperacion ;
                @FXML
    private ComboBox Reservado ;
                
                ObservableList<String> TiposOperaciones = FXCollections.observableArrayList("Alquiler ","Venta");
                
   ObservableList<String> Reservados = FXCollections.observableArrayList("Si ","No");
   private Connection con;

 public static boolean validarTelefono(String telefono) {
        return telefono.matches("[1-9]\\d{8}");
    }
    @FXML
    private void Guardar() throws IOException {

        
       if (Telefono.getText().matches("[0-9]*")){
        int metros = Integer.parseInt(Metros.getText());
         int telefono = Integer.parseInt(Telefono.getText());
          int precio = Integer.parseInt(Precio.getText());
          Boolean reservado ;
          if (Reservado.getValue()=="SI")
          {
              reservado =true;
          }
          else {
              reservado=false;
                      }
        Piso p1 = new Piso(idzona.getText(),IDpiso.getText(),TipoOperacion.getValue().toString(),metros,Nombre.getText(),telefono,precio,reservado);
       CRUD_Piso.insertarPiso(con, p1);
       }
       else {
           System.out.println("el telefono es incorrecto");
       }
     
    }
        @FXML
    private void Borrar() throws IOException {
      
     int idpiso = Integer.parseInt(IDpiso.getText());
       CRUD_Piso.borrarpiso(con, idpiso);
    }
      @FXML
    private void Mostrar() throws IOException {
        
   int id_piso = Integer.parseInt(IDpiso.getText());
       id_piso = VariablesLogin.getId_piso();
        tablapiso.setItems(CRUD_Piso.getPiso(id_piso));
         col1.setCellValueFactory(new PropertyValueFactory<Piso ,String> ("dni"));
         col2.setCellValueFactory(new PropertyValueFactory<Piso ,String> ("tipoprenda"));
          col3.setCellValueFactory(new PropertyValueFactory<Piso ,String> ("dni"));
         col4.setCellValueFactory(new PropertyValueFactory<Piso ,String> ("tipoprenda"));
           col5.setCellValueFactory(new PropertyValueFactory<Piso ,String> ("dni"));
         col6.setCellValueFactory(new PropertyValueFactory<Piso ,String> ("tipoprenda"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
         TipoOperacion.getItems().addAll(TiposOperaciones);
           Reservado.getItems().addAll(Reservados);
    }
}
