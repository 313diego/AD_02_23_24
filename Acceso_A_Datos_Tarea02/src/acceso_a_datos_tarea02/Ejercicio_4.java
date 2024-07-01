/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_a_datos_tarea02;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Ejercicio_4 {
    
    public static void main(String[] args) {
        
        try {
            // Creamos el archvio
            FileOutputStream archivo = new FileOutputStream ("empleados.dat");
            System.out.println("Se ha creado el archivo empleados.dat");
            // Creamos el DataOutputStream
            DataOutputStream escribir = new DataOutputStream(archivo);
            //Creamos la cadena que vamos a escribir en el archivo
            String cadena = "Departamento \"Contabilidad\",\"Informática\",\"Dirección\",\"Análisis\","
                    + "\"Finanzas\",\"Hardware\"\nNº Empleados 3,10,2,5,4,8";
            // Escribimos la cadena en el fichero
            escribir.writeUTF(cadena); 
            System.out.println("Se ha escrito en el archivo la cadena " + cadena);
            // Cerramos el fichero
            escribir.close();
            archivo.close();
            System.out.println("El archivo se ha cerrado");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio_4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio_4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
