/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_a_datos_tarea02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Ejercicio_6 {

    public static void main(String[] args) {
        try {
            // Creamos el RandomAccessFile
            RandomAccessFile archivo;
            // Cadena a guardar en el archivo
            String cadena = "Apellido: \"FERNANDEZ\",\"LOPEZ\",\"GOMEZ\",\"CHEN\","
                    + "\"SERRANO\",\"CASILLAS\",\"ALONSO\"\n\nEdad: 17, 20, 18, 17, 19, 21, 20\n"
                    + "\nNota: 7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9";
            // Abrimos el archivo alumnos.dat en modo lectura y escritura
            archivo = new RandomAccessFile("Prueba/alumnos.dat", "rw");
            // Si el archivo ha sido abierto....
            if (archivo.length() <= 0) {
                System.out.println("El archivo ha sido creado");
                System.out.println("El archivo ha sido abierto");
                // Nos situamos la final del fichero
                archivo.seek(archivo.length());
                // Escribimos en el archivo
                archivo.writeBytes(cadena);
                System.out.println("Se ha escrito en el archivo:\n " + cadena);
                // Cerramos el archivo
                archivo.close();
                System.out.println("El archivo se ha cerrado");
            }else{
                System.out.println("El archivo ya existe");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio_6.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio_6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
