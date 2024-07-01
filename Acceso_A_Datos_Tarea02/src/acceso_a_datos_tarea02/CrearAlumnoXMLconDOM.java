/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_a_datos_tarea02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author diego
 */
public class CrearAlumnoXMLconDOM {

    public static void main(String[] args) {
        
        /**
         * Creamos el código para recuperar el archivo binario y pasarlo a
         * string (copiado tal cual del ejercicio 7) Creamos el RandomAccessFile
         */
        RandomAccessFile archivo;
        // Creamos un array de byte
        byte[] array;
        // Creamos la cadena que contendrá el texto leido
        String cadena = null;
        try {
            // Abrimos el archivo parasandole la ruta y el modo de acceso
            //System.out.println("Abriendo el archivo");
            archivo = new RandomAccessFile("Prueba/alumnos.dat", "r");
            // Nos posicionamos al principio del archivo
            archivo.seek(0);
            // Indicamos al array la capacidad que tendrá
            //System.out.println("Leyendo el fichero");
            array = new byte[(int) archivo.length()];
            // Leemos los byte el fichero y los almacenamos en el array
            archivo.readFully(array);
            // Convertimos los byte en string
            cadena = new String(array);
            // Mostramos por pantalla el contenido de cadena.
            //System.out.println("El archivo contiene la siguiente cadena: " + "\n" + cadena);
            // Cerramos el DataInput, el ByteArray y el archivo.
            archivo.close();
            //System.out.println("El archivo se ha cerrado");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        /**
         * Ahora vamos a separar las palabras del string en un array, asi
         * podremos conocer la posción de cada dato dentro del string
         */
        String[] textoSepPrinc = cadena.split(",|:|\\\n");
        //El array contiene
        /**for (int i = 0; i < textoSepPrinc.length; i++) {
         *   System.out.println("Posicion " + i + " " + textoSepPrinc[i]);
         *}
         */
        /** Como ya conocemos la posción de cada dato, vamos a crear un array
         *solo con los apellidos
         */
        String[] textoApe = new String[7];
        int j = 0;
        for(int i = 1; i <= 7; i++){
            textoApe[j] = textoSepPrinc[i];
            j++;
            
        }
        /**for(int i = 0; i < textoApe.length; i++){
         *   System.out.println("Posicion " + i + " " + textoApe[i]);
         *}
         */
        // Ahora vamos a hacer lo mismo pero para la edad
        String[] textoEdad = new String [7];
        int k = 0;
        for (int i = 10; i <= 16; i++){
            textoEdad [k] = textoSepPrinc[i];
            k++;
        }
        /**for (int i = 0; i < textoEdad.length; i++){
         *   System.out.println("Posicion " + i + " " + textoEdad[i]);
         *}
         */
        // Ahora vamos a hacer lo mismo pero para la nota
        String[] textoNota = new String [7];
        int l = 0;
        for (int i = 19; i <= 25; i++){
            textoNota[l] = textoSepPrinc[i];
            l++;
        }
        /**for (int i = 0; i < textoNota.length; i++){
         *   System.out.println("Posicion " + i + " " + textoNota[i]);
         *}
         */
        
        // Creamos la factoria, el builder y el document
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factoria.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            System.out.println(ex.toString());
        }
        // Creamos el documento
        Document documento = builder.newDocument();
        // Creamos el elemento raiz
        Element alumnos = documento.createElement("alumnos");
        documento.appendChild(alumnos);
        // Creamos cada uno de los alumnos
        for (int i = 0; i < 7; i++) {
            // Creamos cada alumno
            Element alumno = documento.createElement("alumno");
            alumnos.appendChild(alumno);
            // Creamos el apellido
            Element apellido = documento.createElement("apellido");
            apellido.setTextContent(textoApe[i]);
            alumno.appendChild(apellido);
            // Creamos la edad
            Element edad = documento.createElement("edad");
            edad.setTextContent(textoEdad[i]);
            alumno.appendChild(edad);
            // Creamos la nota
            Element nota = documento.createElement("nota");
            nota.setTextContent(textoNota[i]);
            alumno.appendChild(nota);
        }
        // Escribimos en el xml
        TransformerFactory transformerfactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerfactory.newTransformer();
        } catch (TransformerConfigurationException ex) {
            System.out.println(ex.toString());
        }
        DOMSource dom = new DOMSource(documento);
        StreamResult sr = new StreamResult("Prueba/alumnos.xml");
        try {
            transformer.transform(dom, sr);
        } catch (TransformerException ex) {
            System.out.println(ex.toString());
        }
        System.out.println("El fichero se creado correctamente");

    }

}
