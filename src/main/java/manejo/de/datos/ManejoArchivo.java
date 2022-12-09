package manejo.de.datos;

import Clases.Alumno;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class ManejoArchivo {

    public LinkedList<Alumno> obtenerAlumnos(){
        LinkedList<Alumno> alumnos = null;
        Archivo archivo = new Archivo("alumnos.txt");
        LinkedList<String> lineas = archivo.obtenerTextoArchivo();
        if(lineas != null){
            alumnos = new LinkedList<>();
            for(int i = 0; i < lineas.size(); i++){
                String linea = lineas.get(i);
                StringTokenizer tokens = new StringTokenizer(linea, ",");
                String nombreCompleto = tokens.nextToken();
                String numeroMatricula = tokens.nextToken();
                String carrera = tokens.nextToken();
                alumnos.add(new Alumno(nombreCompleto, carrera, numeroMatricula));
            }
            return alumnos;
        };
        return null;
    }

    public boolean registrarAlumno(Alumno alumno){
        Archivo archivo = new Archivo("alumnos.txt");
        return archivo.escribirTextoArchivo(
                alumno.getNombreCompleto()+","+
                        alumno.getNumeroMatricula()+","+
                        alumno.getCarrera());
    }
}
