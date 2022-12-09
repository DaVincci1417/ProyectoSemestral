package Clases;

public abstract class Persona{
    protected String nombreCompleto;

    //Generador
    public Persona(String nombreCompleto) {
        setNombreCompleto(nombreCompleto);
    }

    //Sett
    private void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    //Get
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    //toString
    @Override
    public String toString() {
        return "Persona{" +
                "Nombre: " + nombreCompleto + "}";
    }
}
