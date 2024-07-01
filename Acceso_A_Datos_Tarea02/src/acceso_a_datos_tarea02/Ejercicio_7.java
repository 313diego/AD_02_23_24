/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_a_datos_tarea02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Ejercicio_7 {

    public static void main(String[] args) {
        // Creamos el RandomAccessFile
        RandomAccessFile archivo;
        // Creamos un array de byte
        byte[] array;
        // Creamos la cadena que contendrá el texto leido
        String cadena;

        try {
            // Abrimos el archivo parasandole la ruta y el modo de acceso
            System.out.println("Abriendo el archivo");
            archivo = new RandomAccessFile("Prueba/alumnos.dat", "r");
            // Nos posicionamos al principio del archivo
            archivo.seek(0);
            // Indicamos al array la capacidad que tendrá
            System.out.println("Leyendo el fichero");
            array = new byte[(int) archivo.length()];
            // Leemos los byte el fichero y los almacenamos en el array
            archivo.readFully(array);
            // Convertimos los byte en string
            cadena = new String(array);
            // Mostramos por pantalla el contenido de cadena.
            System.out.println("El archivo contiene la siguiente cadena: " + "\n" + cadena);
            // Cerramos el DataInput, el ByteArray y el archivo.
            archivo.close();
            System.out.println("El archivo se ha cerrado");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio_7.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio_7.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
