/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panaderia;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author dvhda
 */
public class Panaderia 
{
  public static void main(String[] args) 
    {
       
       
        String carpetaTrabajo = System.getProperty("use.dir");
        System.out.println("La carpeta de trabajo es " + carpetaTrabajo);
        new vista();
    }   
}
