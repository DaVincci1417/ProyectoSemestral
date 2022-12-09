package Clases;

import java.util.ArrayList;

public class Alumno extends Persona{
    private String numeroMatricula;
    private String carrera;
    private ArrayList<Ramo> ramosCursando;
    private ArrayList<HoraRealizada> horasRealizadas;

    //Constructor
    public Alumno(String nombreCompleto,String carrera,String numeroMatricula){
        super(nombreCompleto);
        setNumeroMatricula(numeroMatricula);
        setCarrera(carrera);
    }

    //Getters
    public String getNumeroMatricula() {
        return numeroMatricula;
    }
    public String getCarrera() {
        return carrera;
    }
    public ArrayList<Ramo> getRamosCursando(){
        return this.ramosCursando;
    }


    //Setters
    private void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    private void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
    public void setRamosCursando(ArrayList<Ramo> ramosCursando){
        this.ramosCursando = ramosCursando;
    }


    //Agregar, Quitar y encontrar Ramos Cursando
    public Ramo agragarRamosCursando(String codigoRamo){
        if(encontrarRamo(codigoRamo)!=null){
            return null;
        }
        this.ramosCursando.add(encontrarRamo(codigoRamo));
        return encontrarRamo(codigoRamo);
    }
    public Ramo quitarRamosCursando(String codigoRamo){
        if(encontrarRamo(codigoRamo)!=null){
            this.ramosCursando.remove(encontrarRamo(codigoRamo));
            return encontrarRamo(codigoRamo);
        }
        return null;
    }
    public Ramo encontrarRamo(String codigoRamo) {
        int posicion = -1;
        for (int i = 0; i < this.ramosCursando.size(); i++) {
            if (this.ramosCursando.get(i).getCodigo().equalsIgnoreCase(codigoRamo)){
                posicion = i;
            }
        }
        if (posicion != -1) {
            return this.ramosCursando.get(posicion);
        } else {
            return null;
        }
    }

    //Agregar y Borra horas
    public boolean agregarHorasRealizadas(String codigoRamo, int horasRealizadas){
        if(encontrarRamo(codigoRamo) == null){
            return false;
        }
        if(encontrarRamo(codigoRamo) != null){
            encontrarHorasRealizadasSegunRamo(codigoRamo).añadirHoras(horasRealizadas);
        }
        return true;
    }
    public boolean borrarHorasRealizadas(String codigoRamo){
        if(encontrarRamo(codigoRamo) == null){
            return false;
        }
        if(encontrarRamo(codigoRamo)!=null){
            encontrarHorasRealizadasSegunRamo(codigoRamo).borrarHoras();
        }
        return true;
    }


    //Este metodo encuentra el indice que queremos agregarles horas o borrarlas
    public HoraRealizada encontrarHorasRealizadasSegunRamo(String codigoRamo){
        int posicion = -1;
        for (int i = 0; i < this.ramosCursando.size(); i++) {
            if (this.horasRealizadas.get(i).getRamo().getCodigo().equalsIgnoreCase(codigoRamo)){
                posicion = i;
            }
        }
        if (posicion != -1) {
            return this.horasRealizadas.get(posicion);
        }
        return null;
    }


    //Validacion de Matricula
    private void validarMatricula(String numeroMatricula) throws Exception{
        String matriculaLimpia = quitarPuntosYGuion(numeroMatricula);
        String mensajeError = "Ingrese un número de matricula valido.";

        if (matriculaLimpia.length() > 11){
            throw new Exception(mensajeError);
        }

        if(!matriculaLimpia.substring(8,9).equalsIgnoreCase("k")){
            try {
                Integer.parseInt(numeroMatricula.substring(8,9));
            }catch (Exception e){
                throw new Exception(mensajeError);
            }
        }

        try {
            Integer.parseInt(matriculaLimpia.substring(0,11));
        }catch (Exception e){
            throw new Exception(mensajeError);
        }
    }
    private String quitarPuntosYGuion(String numeroMatricula){
        String matriculaSinPuntos;
        matriculaSinPuntos = numeroMatricula.replace(".", "");
        String matriculaSinPuntosNiGuion = matriculaSinPuntos.replace("-", "");
        String matriculaLimpia = matriculaSinPuntosNiGuion.replace(" ", "");
        return matriculaLimpia;
    }


    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + "\n" +
                "Numero Matricula: " + numeroMatricula + "\n"+
                "Carrera: " + carrera+ "\n"+
                "Horas Realizadas: " + horasRealizadas + "}";

    }
}
