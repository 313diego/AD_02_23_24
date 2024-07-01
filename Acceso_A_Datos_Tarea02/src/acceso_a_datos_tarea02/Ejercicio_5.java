/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_a_datos_tarea02;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Ejercicio_5 {
    public static void main(String[] args) {
        try {
            // Creamos el FileInput
            FileInputStream fileIn = new FileInputStream ("empleados.dat");
            // Creamos el inputStream con el archivo
            DataInputStream inputStream = new DataInputStream (fileIn);
            // Creamos un buffer para contener la cadena
            StringBuffer cadenaLeida = new StringBuffer();
            // Mientras queden digitos que leer...
            while (inputStream.available()>0){
                System.out.println("Leyendo el archivo");
                // Guardamos en la cadena lo que vamos leyendo
                cadenaLeida.append(inputStream.readUTF());
                // Mostramos por pantalla lo que hemos leido
                System.out.println(cadenaLeida);
            }
            // Cerramos el DataInputStream
            inputStream.close();
            // Cerramos el FileInputStream
            fileIn.close();
            System.out.println("El archivo se ha cerrado");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio_5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio_5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
