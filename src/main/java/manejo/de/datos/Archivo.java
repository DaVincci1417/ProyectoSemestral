package manejo.de.datos;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

public class Archivo {
    private String nombre;

    public Archivo(String nombre){
        this.nombre = nombre;
    }

    private File obtnerArchivo(){
        try {
            URL url = getClass().getClassLoader().getResource("archivos/"+nombre);
            return new File(url.toURI());
        }catch (URISyntaxException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public LinkedList<String> obtenerTextoArchivo(){
        LinkedList<String> lineasDeTexto = null;
        try{
            File archivo = obtnerArchivo();
            if(archivo.exists()){
                lineasDeTexto = new LinkedList<>();
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea = br.readLine()) != null){
                    lineasDeTexto.add(linea);
                }
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lineasDeTexto;
    }

    public Boolean escribirTextoArchivo(String linea){
        File archivo = obtnerArchivo();
        try {
            if(archivo.exists()) {
                FileWriter fw = new FileWriter(archivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(linea);
                pw.flush();
                pw.close();
                return true;
            }else{
                return false;
            }
        }catch (IOException e){
            return false;
        }
    }
}
