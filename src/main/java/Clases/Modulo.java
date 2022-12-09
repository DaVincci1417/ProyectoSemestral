package Clases;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Modulo extends Ramo{
    private String profesorAcargo;
    private ObservableList<Alumno> alumnos = FXCollections.observableArrayList();


    public Modulo(String nombre, String codigo, String profesor){
        super(nombre, codigo);
        setProfesorAcargo(profesor);
    }

    //Getters
    public String getProfesorAcargo() {
        return profesorAcargo;
    }
    public ObservableList<Alumno> getAlumnos() {
        return alumnos;
    }


    //Setters
    public void setProfesorAcargo(String profesorAcargo) {
        this.profesorAcargo = profesorAcargo;
    }
    public void setAlumnos(ObservableList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    //Agregar Alumnos
    public void agregarAlumno(Alumno alumno){
        alumnos.add(alumno);
    }
    public void eliminarAlumno(Alumno alumno){
        alumnos.remove(alumno);
    }
    public void eliminarAlumnos(){
        for(int i = 0; i < alumnos.size(); i++){
            alumnos.remove(i);
        }
    }

    //Validacion
    private void validacion(String numero){
        try {
            Integer.parseInt(numero);
        }catch (Exception e){
            System.out.println("Ingrese una fecha valida");
        }

    }

    @Override
    public String toString() {
        return
                "Ramo: " + nombre + "\n" +
                "Profesor: " + profesorAcargo + "\n" +
                "Codigo: " + codigo;
    }
}
