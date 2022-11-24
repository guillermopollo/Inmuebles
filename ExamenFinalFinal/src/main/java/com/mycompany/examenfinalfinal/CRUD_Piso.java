/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenfinalfinal;

import static com.mycompany.examenfinalfinal.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author willy
 */
public class CRUD_Piso {
  
          
    
        public static void insertarPiso(Piso usu) {
Connection con = Conexion.getConexion();
        PreparedStatement ps;

        try {
            String sqlPiso = "INSERT into pisos(Id_Zona,Tipo_Operacion,Metros,Nombre_propietario,Telefono_contacto,Precio,Reservado) values(?,?,?,?,?,?,?)";
          
            ps = (PreparedStatement) con.prepareStatement(sqlPiso);

       
      
            ps.setString(2, usu.getTipoOperacion());
            ps.setInt(3, usu.getMetroCuadrados());
         ps.setString(4, usu.getNombrePropietario());
            ps.setInt(5, usu.getTelefono());
                ps.setInt(6, usu.getPrecio());
            ps.setBoolean(7, usu.isReservado());

            ps.executeUpdate();
           

        } catch (SQLException ex) {
            System.out.print("ERROR AL INSERTAR");
        }

    }
      public static void borrarpiso( int idPiso)
    {
      Connection con = Conexion.getConexion();
       PreparedStatement ps;
  

     
        try{
            System.out.println("borrar piso ");
		String SQL = "DELETE from piso where Id_piso =" + idPiso+ ";";
                ps = (PreparedStatement) con.prepareStatement(SQL,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
		 ps.executeQuery();

        }
        catch(SQLException ex)
         {
      
            
         }
    }
        
          public static void reservar(int idPiso)
    {
        Connection con = Conexion.getConexion();
       PreparedStatement ps;
  
        try {
            
          ps = con.prepareStatement("UPDATE pisos SET Reservado=" + true +" WHERE Id_piso="   + idPiso);
            ResultSet rs = ps.executeQuery();
       
     
  

     
      
    }   catch(SQLException ex)
         {
      
            
         }
    }
            public static ObservableList<Piso> getPiso(int idPiso) {
           Connection con = Conexion.getConexion();
        ObservableList <Piso> listaTabla;
        listaTabla = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * from Pisos WHERE Id_piso"   + idPiso);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             listaTabla.add(new Piso(rs.getInt("Id_piso"),rs.getString("Tipo_Operacion"),rs.getInt("Metros"),rs.getString("Nombre_propietario"),rs.getInt("Telefono"),rs.getInt("Precio"),rs.getBoolean("Reservado")));

            }
        } catch (SQLException ex) {
          
        }
        
        return listaTabla;
    }
            
        
        
}
