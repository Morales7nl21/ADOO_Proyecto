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
public class Caja 
{
   private String ID;
   private String Dinero;
   
   public Caja()
   {
   }
   
   public Caja(String  id, String dinero)
   {
       this.ID = id;
       this.Dinero = dinero;
       
    }
    // Metodos get
   public String getID()
   {
     return ID;  
   }
   
   public String getDinero()
   {
       return Dinero;
   }
   //Metodos set
   public void setID(String id)
   {
       this.ID = id;
   }
   public void setDinero(String dinero)
   {
       this.Dinero = dinero;
   }
   public static Caja getCajaFromDB(String Caja, Properties prop)
   {
       Caja usuario = new Caja();
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

                PreparedStatement ps = con.prepareStatement("SELECT * FROM CAJA WHERE ID = ?");
                ps.setString(1,Caja);
                boolean ok = ps.execute();
                ResultSet rs = ps.getResultSet();

                if(rs!=null && rs.next())
                {
                    
                    String id = rs.getString("ID");
                    String dinero = rs.getString("Dinero");
                                     
                    
                    
                    usuario.setID(id);
                    usuario.setDinero(dinero);
                    
                    
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
    public static Caja Login (String Caja, Properties prop)
   {
       Caja usuario = new Caja();
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

                PreparedStatement ps = con.prepareStatement("SELECT * FROM CAJA WHERE ID = ?");
                ps.setString(1,Caja);
                boolean ok = ps.execute();
                ResultSet rs = ps.getResultSet();

                if(rs!=null && rs.next())
                {
                    String dinero = rs.getString("Dinero");
                    String id = rs.getString("ID");
                    
                    
                    usuario.setDinero(dinero);
                    usuario.setID(id);
                    
                    
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

                PreparedStatement ps = con.prepareStatement("INSERT INTO CAJA (ID, DINERO) VALUES (?,?)");
                ps.setString(1, this.ID); 
                ps.setString(2, this.Dinero); 
                                
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

                PreparedStatement ps = con.prepareStatement("UPDATE CAJA SET DINERO = ? WHERE ID = ? ");
                                
                 // El titulo que llega de la Vista
                ps.setString(1, this.Dinero);
                ps.setString(2, this.ID);
                
               
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

                PreparedStatement ps = con.prepareStatement("DELETE FROM CAJA WHERE ID = ?");
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
