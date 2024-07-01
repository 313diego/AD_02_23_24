/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_a_datos_tarea02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author diego
 */
public class Ejercicio_3 {

    public static void main(String[] args) {
        try {
            // Creamos el fichero
            File archivo = new File ("Prueba/FichTexto.txt");
            System.out.println("El fichero ha sido creado");
            // Creamos el filewriter 
            FileWriter fw = new FileWriter(archivo, true);
            // Creamos el bufferedwriter
            BufferedWriter escribir = new BufferedWriter(fw);
            // Creamos la cadena de texto que vamos a escribir en el fichero
            String texto = "Ejemplo de escritura en un fichero de texto o txt";
            // Leemos el fichero par ver si contiene algo escrito
            FileReader fr = new FileReader("Prueba/FichTexto.txt");
            // Creamos el bufferedReader
            BufferedReader archivoLeido = new BufferedReader(fr);
            // Creamos el string donde guardar el contenido leido del fichero e inicializamos a null
            String cadenaLeida = "";
            // Leemos el fichero y guardamos en la variable lo leido
            cadenaLeida = archivoLeido.readLine();
            // Si no leemos nada (esta vacio) escribimos en el la cadena, hacemos flush y cerramos el fichero
            if(cadenaLeida == null){
                System.out.println("Escribiendo en el archivo");
                escribir.write(texto);
                escribir.flush();
                escribir.close();
                System.out.println("El archivo ha sido cerrado"); 
            }
            // Leemos de nuevo el fichero para ver si contiene algo escribo
            fr = new FileReader("Prueba/FichTexto.txt");
            System.out.println("Leyendo el fichero");
            archivoLeido = new BufferedReader(fr);
            // Leemos lo que contiene y lo guardamos
            cadenaLeida = archivoLeido.readLine();
            // Mostramos por consola el contenido
            System.out.println(cadenaLeida);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
