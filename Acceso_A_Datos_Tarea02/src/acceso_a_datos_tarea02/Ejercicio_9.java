/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_a_datos_tarea02;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author diego
 */
public class Ejercicio_9 {

    public static void main(String[] args) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Alumnos.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Alumnos alumnos = (Alumnos) unmarshaller.unmarshal(new File("Prueba/alumnos.xml"));

        ArrayList<Alumno> Alumnos = alumnos.getAlumnos();

        for (Alumno a : Alumnos) {
            System.out.println("Alumno: Apellido: " + a.getApellido() + ". " + "Edad " + a.getEdad()
                    + ". " + "Nota " + a.getNota());
        }

    }

    @XmlRootElement(name = "alumnos")
    public static class Alumnos {

        private ArrayList<Alumno> alumnos = new ArrayList();

        public Alumnos() {
        }

        @XmlElement(name = "alumno")
        public ArrayList<Alumno> getAlumnos() {
            return alumnos;
        }

        public void setAlumnos(ArrayList<Alumno> alumnos) {
            this.alumnos = alumnos;
        }

    }

    @XmlRootElement(name = "alumno")
    @XmlType(propOrder = {"apellido", "edad", "nota"})
    public static class Alumno {

        private String apellido;
        private int edad;
        private double nota;

        public Alumno() {
        }

        @XmlElement(name = "apellido")
        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        @XmlElement(name = "edad")
        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        @XmlElement(name = "nota")
        public double getNota() {
            return nota;
        }

        public void setNota(double nota) {
            this.nota = nota;
        }

    }

}
