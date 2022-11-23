/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenfinalfinal;

import static com.mycompany.examenfinalfinal.Connection.getConexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author willy
 */
public class CRUD_Piso {
    PreparedStatement ps;  b
            
     String sql;
    
        public static void insertarPiso(Connection conexion, Piso usu){
     
       PreparedStatement ps;  
     
        try {
            String sql = "Insert into Pisos values(?,?,?,?,?,?,?)";
             ps = (PreparedStatement) conexion.prepareStatement(sql);
             
            ps.setString(1,usu.getIdentificadorPiso());
            ps.setString(2,usu.getIdentificadorZona());
            ps.setString(3, usu.getMetroCuadrados());
            ps.setString(4, usu.getNombrePropietario());
            ps.setString(5, usu.getPrecio());
            ps.setString(6, usu.getTelefono());
              ps.setString(7, usu.getTipoOperacion());

            ps.executeUpdate();
            //javax.swing.JOptionPane.showMessageDialog(null, "Usuario Insertado CORRECTAMENTE"); //EN VEZ DE JOptionPane, SCENE BUILDER
            
        } catch (SQLException ex) {
            System.out.print("ERROR AL INSERTAR");
        }
        
    }
        
        public static void borrarpiso(Connection conexion,  int idPiso)
    {
      
       PreparedStatement ps;
  

     
        try{
            System.out.println("borrar piso ");
		String SQL = "DELETE from piso where Id_piso =" + idPiso+ ";";
                ps = (PreparedStatement) conexion.prepareStatement(SQL,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
		rs = ps.executeQuery();

        }
        catch(SQLException ex)
         {
      
            
         }
    }
          public static void reservar(Connection conexion,  int idPiso)
    {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Pisos SET Reservado=" + true +" WHERE Id_piso="   + idPiso);
            ResultSet rs = ps.executeQuery();
       
     
  

     
      
    }   catch(SQLException ex)
         {
      
            
         }
    }
            public static ObservableList<Piso> getPiso(int idPiso) {
        Connection con;
        con=getConexion();
        ObservableList <Piso> listaTabla;
        listaTabla = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * from Pisos WHERE Id_piso"   + idPiso);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaTabla.add(new Piso(rs.getInt("Id_piso"), rs.getInt("Metros"),rs.getString("Nombre_propietario"),rs.getInt("Telefono_propietario"),rs.getInt("Precio"),rs.getBollean("Reservado")));

            }
        } catch (SQLException ex) {
          
        }
        
        return listaTabla;
    }
            
        
        
}
