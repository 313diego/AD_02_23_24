/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_a_datos_tarea02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author diego
 */
public class Ejercicio_2 {
    
    public static void main(String[] args) {
        // Creamos la los objetos Path con las rutas y el nombre del directorio y del fichero
        Path directorio = Paths.get("direcnio");
        Path fichero = Paths.get("direcnio/fichero.txt");
        try{
            if(Files.exists(directorio)){ // Si el directorio existe
                System.out.println("El directorio direcnio ya existe");
                if(Files.exists(fichero)){ // Si el fichero existe
                    System.out.println("El archivo fichero.txt ya existe.");
                }
                Files.delete(fichero); // Borramos el fihero
                System.out.println("El archivo fichero.txt ha sido borrado");
                Files.delete(directorio); // Borramos el directorio
                System.out.println("El directorio direcnio ha sido borrado");
            }else{
                System.out.println("El directorio direcnio no existe"); 
                Files.createDirectory(directorio); // Creamos el directorio
                System.out.println("El directorio direcnio ha sido creado");

                Files.createFile(fichero); // Creamos el fichero
                System.out.println("El archivo fichero.txt ha sido creado");
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
