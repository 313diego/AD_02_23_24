/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_a_datos_tarea02;

import java.io.File;

/**
 *
 * @author diego
 */
public class Ejercicio_1 {

    public static void main(String[] args) {

        try {
            // Listar los archivos del directorio
            // Creamos el File con la ruta hasta el directorio
            File ruta = new File("/Users/diego/NetBeansProjects/Acceso_A_Datos_Tarea02");
            String[] listaArchivos = ruta.list(); // Creamos el array y añadimos el contenido del objeto File

            if (listaArchivos.length == 0) { // Si el array esta vacio...
                System.out.println("No se han encontrado archivos en el directorio");
            } else {
                for (int i = 0; i < listaArchivos.length; i++) { 
                    System.out.println(listaArchivos[i]); // Mostramos lo contenido en el array
                }
            }
            
            // Crear un directorio, si no exsite
            // Creamos la ruta donde se guardará y su nombre
            String directorio = "Prueba";
            // Creamos el directorio
            boolean existo = (new File(directorio).mkdir());

            if (existo) { // Si se ha creado...
                System.out.println("Directorio ha sido creado");
            } else {
                System.out.println("El directorio prueba ya existe");
            }

        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }
}
