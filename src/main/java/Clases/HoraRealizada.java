package Clases;

public class HoraRealizada {
    private Ramo ramo;
    private int horasRealizadas;

    public HoraRealizada(Ramo ramo, int horasRealizadas){

    }

    public Ramo getRamo() {
        return ramo;
    }
    public int getHorasRealizadas() {
        return horasRealizadas;
    }

    public void setRamo(Ramo ramo) {
        this.ramo = ramo;
    }
    public void setHorasRealizadas(int horasRealizadas) {
        this.horasRealizadas = horasRealizadas;
    }

    //Añadir y Borrar horas
    public void añadirHoras(int horasRealizadas){
        this.horasRealizadas = getHorasRealizadas() + horasRealizadas;
    }
    public void borrarHoras(){
        this.horasRealizadas = 0;
    }

    @Override
    public String toString() {
      return "Horas Realizadas{" +
                "Ramo: " + ramo + "\n" +
                "Horas Realizadas: " + horasRealizadas + "}";
    }
}
