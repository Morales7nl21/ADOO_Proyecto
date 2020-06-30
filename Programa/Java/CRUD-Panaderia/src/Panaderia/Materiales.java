/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panaderia;

/**
 *
 * @author dvhda
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Materiales 
{
    private String ID;
   private String nombre;
   private String precio;
   private String cantidad;
   private String imagen;
   public Materiales()
   {
   }
   
   public Materiales(String ID,String nombre, String precio, String cantidad, String imagen)
   {
       this.ID = ID;
       this.nombre= nombre;
       this.cantidad = cantidad;
       this.precio = precio  ;
       this.imagen = imagen;
    }
    // Metodos get
       public String getID()
       {
        return ID;  
       }
       public String getNombre()
       {
           return nombre;
       }
       public String getPrecio()
       {
           return precio;
       }
       public String getCantidad()
       {
           return cantidad;
       }
       public String getImagen()
       {
           return imagen;
       }
       //metodos Set
       public void setID(String ID)
       {
           this.ID = ID;
       }
       public void setNombre(String nombre)
       {
           this.nombre = nombre;
       }
       public void setPrecio(String precio)
       {
           this.precio = precio;
       }
       public void setCantidad(String cantidad)
       {
           this.cantidad = cantidad;
       }
       public void setImagen(String imagen)
       {
           this.imagen = imagen;
       }
       public static Materiales getMaterialesFromDB(String Catalogo, Properties prop)
   {
       Materiales material = new Materiales();
       try
       {
          String driver = prop.getProperty("dbdriver");
                String host   = prop.getProperty("dbhost");
                String user   = prop.getProperty("dbuser");
                String password = prop.getProperty("dbpassword");
                String name     = prop.getProperty("dbname");
                String url = host + name  + "?user=" + user + "&password=" + password+"&useSSL=false";
                System.out.println("Conexion a la BD: " + url);


                Class.forName(driver);     // Carga el driver


                Connection con = DriverManager.getConnection(url); // Crea una conexion a la BD

                PreparedStatement ps = con.prepareStatement("SELECT * FROM MATERIALES WHERE ID = ?");
                ps.setString(1,Catalogo);
                boolean ok = ps.execute();
                ResultSet rs = ps.getResultSet();

                if(rs!=null && rs.next())
                {
                    String ID=rs.getString("ID");
                    String nombre = rs.getString("Nombre");
                    String precio = rs.getString("Precio");
                    String cantidad = rs.getString("Cantidad");
                    String imagen = rs.getString("Imagen");
                    
                    material.setID(ID);
                    material.setNombre(nombre);
                    material.setPrecio(precio);
                    material.setCantidad(cantidad);
                    material.setImagen(imagen);
                    
                    
                    con.close();
                    return material;
                }

	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	    } 
       
        return null;
   }
        public boolean Registro(Properties prop)
	{
            boolean exito = false;
            
            try
	    {

                String driver = prop.getProperty("dbdriver");
                String host   = prop.getProperty("dbhost");
                String user   = prop.getProperty("dbuser");
                String password = prop.getProperty("dbpassword");
                String name     = prop.getProperty("dbname");
                String url = host + name  + "?user=" + user + "&password=" + password+"&useSSL=false";
                System.out.println("Conexion a la BD: " + url);


                Class.forName(driver);     // Carga el driver


                Connection con = DriverManager.getConnection(url); // Crea una conexion a la BD

                PreparedStatement ps = con.prepareStatement("INSERT INTO MATERIALES (ID, NOMBRE,PRECIO,CANTIDAD,IMAGEN) VALUES (?,?,?,?,?)");
                ps.setString(1, this.ID); 
                ps.setString(2, this.nombre); 
                ps.setString(3, this.precio); 
                ps.setString(4, this.cantidad); 
                ps.setString(5, this.imagen);
                
                                
                exito = ps.executeUpdate() > 0;
                con.close();
               
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    return exito;
	}
   
    public boolean cambiar(Properties prop)
	{
            boolean exito = false;
            
            try
	    {

                String driver = prop.getProperty("dbdriver");
                String host   = prop.getProperty("dbhost");
                String user   = prop.getProperty("dbuser");
                String password = prop.getProperty("dbpassword");
                String name     = prop.getProperty("dbname");
                String url = host + name  + "?user=" + user + "&password=" + password+"&useSSL=false";
                System.out.println("Conexion a la BD: " + url);


                Class.forName(driver);     // Carga el driver


                Connection con = DriverManager.getConnection(url); // Crea una conexion a la BD

                PreparedStatement ps = con.prepareStatement("UPDATE MATERIALES SET  NOMBRE= ?, PRECIO = ?, CANTIDAD = ?, IMAGEN = ? WHERE ID = ? ");
                                
                 // El titulo que llega de la Vista
                ps.setString(1, this.nombre);
                ps.setString(2, this.precio);
                ps.setString(3, this.cantidad);
                ps.setString(4, this.imagen);
                ps.setString(5, this.ID);
                
               
                exito = ps.executeUpdate() > 0;
                con.close();
               
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    return exito;
	}
    
    public boolean borrar(Properties prop)
	{
            boolean exito = false;
            
            try
	    {

                String driver = prop.getProperty("dbdriver");
                String host   = prop.getProperty("dbhost");
                String user   = prop.getProperty("dbuser");
                String password = prop.getProperty("dbpassword");
                String name     = prop.getProperty("dbname");
                String url = host + name  + "?user=" + user + "&password=" + password+"&useSSL=false";
                System.out.println("Conexion a la BD: " + url);


                Class.forName(driver);     // Carga el driver


                Connection con = DriverManager.getConnection(url); // Crea una conexion a la BD

                PreparedStatement ps = con.prepareStatement("DELETE FROM MATERIALES WHERE ID = ?");
                ps.setString(1, this.ID);
                exito = ps.executeUpdate() > 0;
                con.close();
               
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    return exito;
	}

       
    
}
