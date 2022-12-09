package Clases;

public abstract class Ramo{
    protected String nombre;
    protected String codigo;


    public Ramo(String nombre, String codigo){
        setNombre(nombre);
        setCodigo(codigo);
    }

    //Getters
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }

    //Setters
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Ramo{" +
                "Nombre: " + nombre + "\n" +
                "Codigo: " + codigo +  "}";
    }
}
