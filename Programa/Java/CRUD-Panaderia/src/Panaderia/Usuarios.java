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
import java.sql.*;
import java.util.*;
public class Usuarios 
{
   private String nombre;
   private String contraseña;
   private String tipo;
   private String dinero;
   
   public Usuarios()
   {
   }
   
   public Usuarios(String nombre,String contraseña, String tipo)
   {
       this.nombre = nombre;
       this.contraseña= contraseña;
       this.tipo = tipo;
    }
    // Metodos get
   public String getNombre()
   {
     return nombre;  
   }
   
   public String getContraseña()
   {
       return contraseña;
   }
   public String getTipo()
   {
       return tipo;
   }
   //Metodos set
   public void setNombre(String nombre)
   {
       this.nombre = nombre;
   }
   public void setContraseña(String contraseña)
   {
       this.contraseña = contraseña;
   }
   public void setTipo(String tipo)
   {
       this.tipo = tipo;
   }
   
   public static Usuarios getUsuarioFromDB(String Usuario, Properties prop)
   {
       Usuarios usuario = new Usuarios();
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

                PreparedStatement ps = con.prepareStatement("SELECT * FROM USUARIOS WHERE NOMBRE = ?");
                ps.setString(1,Usuario);
                boolean ok = ps.execute();
                ResultSet rs = ps.getResultSet();

                if(rs!=null && rs.next())
                {
                    
                    String nombre = rs.getString("Nombre");
                    String contraseña = rs.getString("Contraseña");
                    String tipo = rs.getString("Tipo");
                    
                    
                    
                    usuario.setNombre(nombre);
                    usuario.setContraseña(contraseña);
                    usuario.setTipo(tipo);
                    
                    
                    con.close();
                    return usuario;
                }

	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	    } 
       
        return null;
   }
    public static Usuarios Login (String Usuario, Properties prop)
   {
       Usuarios usuario = new Usuarios();
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

                PreparedStatement ps = con.prepareStatement("SELECT * FROM USUARIOS WHERE NOMBRE = ?");
                ps.setString(1,Usuario);
                boolean ok = ps.execute();
                ResultSet rs = ps.getResultSet();

                if(rs!=null && rs.next())
                {
                    String tipo=rs.getString("Tipo");
                    String usuario1 = rs.getString("Nombre");
                    String contraseña = rs.getString("Contraseña");
                    
                    
                    usuario.setNombre(usuario1);
                    usuario.setContraseña(contraseña);
                    usuario.setTipo(tipo);
                    
                    
                    con.close();
                    return usuario;
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

                PreparedStatement ps = con.prepareStatement("INSERT INTO USUARIOS (NOMBRE, CONTRASEÑA, TIPO) VALUES (?,?,?)");
                ps.setString(1, this.nombre); 
                ps.setString(2, this.contraseña); 
                ps.setString(3, this.tipo);
                                
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

                PreparedStatement ps = con.prepareStatement("UPDATE USUARIOS SET CONTRASEÑA = ?, TIPO = ? WHERE NOMBRE = ? ");
                                
                 // El titulo que llega de la Vista
                ps.setString(3, this.nombre);
                ps.setString(1, this.contraseña);
                ps.setString(2, this.tipo);
                
               
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

                PreparedStatement ps = con.prepareStatement("DELETE FROM USUARIOS WHERE NOMBRE = ?");
                ps.setString(1, this.nombre);
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
