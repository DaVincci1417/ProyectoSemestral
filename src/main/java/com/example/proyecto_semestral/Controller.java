package com.example.proyecto_semestral;

import Clases.Alumno;
import Clases.Modulo;
import Clases.Ramo;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import manejo.de.datos.ManejoArchivo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //Imagenes
    @FXML private ImageView logoUfro, flechaRegistroHoras, flechaBuscar, flechaRegistroAlumno, flechaEditar;

    //Paneles
    @FXML private AnchorPane panelPrincipal, pestañas, panelRegistroHoras, panelBuscar, panelRegistroAlumno, panelEditar, panelDatosAlumnos,panelLista;

    //Cosas panel Registro Horas
    @FXML private ComboBox<String> comboBoxHorasRealizadas;
    @FXML private TextField txtMatricula, txtCodigoRamoRegistroHora;
    @FXML private DatePicker fechaRegistroHora;

    //Cosas Panel Buscar
    @FXML private TextField numMatriculaBuscar, codigoRamoBuscar, txtCodigoRamoListAlum;

    //Cosas Panel Mostrar Alumno
    @FXML private ListView<Alumno> lstAlumno;

    //Cosas Panel Mostrar Lista Alumnos
    @FXML private ListView<Alumno> lstAlumnos;

    //Cosas Panel Registro Alumno
    @FXML private TextField nombreCompleto, numMatricula;
    @FXML private ComboBox<Modulo> comboBoxPrecalculoUno, comboBoxPrecalculoDos, comboBoxIntAlg;
    @FXML private ComboBox<String> comboBoxCarreras;
    @FXML private ComboBox<Modulo> comboBoxAlgebra, comboBoxCalculoDif, comboBoxCalculoInt;
    @FXML private Button botonRegistrarAlumno;

    //Cosas Panel Eliminar
    @FXML private TextField txtCodRamoElimnarAlum, txtCodRamoElimnarHrs;

    //Contenido de los ComboBox
    ObservableList<String> contenidoHorasRealizadas =
            FXCollections.observableArrayList(
                    "Una hora",
                    "Dos horas"
            );


    ObservableList<String> contenidoCarrera =
            FXCollections.observableArrayList(
                    "Ingeniería Civil",
                    "Ingeniería Civil Industrial",
                    "Ingeniería Civil Quimica",
                    "Ingeniería Civil Fisica",
                    "Ingeniería Civil Plan Común",
                    "Ingeniería Civil Mecánica",
                    "Ingeniería Civil Ambiental",
                    "Ingeniería Civil Eléctrica",
                    "Ingeniería Civil Electrónica",
                    "Ingeniería Civil Informática",
                    "Ingeniería Civil Matemática",
                    "Ingeniería Civil Telemática",
                    "Ingeniería Civil Biotecnología"
            );


    private ObservableList<Modulo> precalculoUno, precalculoDos, intAlgebra, algebra, calculoDif, calculoInt, modulos;
    private ObservableList<Alumno> alumnosListaIndividual, alumnosLista, todosLosAlumnos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modulos = FXCollections.observableArrayList();
        precalculoUno = FXCollections.observableArrayList();
        precalculoDos = FXCollections.observableArrayList();
        intAlgebra = FXCollections.observableArrayList();
        algebra = FXCollections.observableArrayList();
        calculoDif = FXCollections.observableArrayList();
        calculoInt = FXCollections.observableArrayList();
        Modulo modulo11 = new Modulo("Precalculo l", "IME027-1", "M. Molina");
        precalculoUno.add(modulo11);
        Modulo modulo12 = new Modulo("Precalculo l", "IME027-2", "Y. Marin");
        precalculoUno.add(modulo12);
        Modulo modulo13 = new Modulo("Precalculo l", "IME027-3", "L. Sandoval");
        precalculoUno.add(modulo13);
        Modulo modulo21 = new Modulo("Precalculo ll", "IME029-1", "E. Milman");
        precalculoDos.add(modulo21);
        Modulo modulo22 = new Modulo("Precalculo ll", "IME029-2", "J. Molina");
        precalculoDos.add(modulo22);
        Modulo modulo23 = new Modulo("Precalculo ll", "IME029-3", "D. Lagos");
        precalculoDos.add(modulo23);
        Modulo modulo31 = new Modulo("Int. Algreba", "IME028-1", "R. Leal");
        intAlgebra.add(modulo31);
        Modulo modulo32 = new Modulo("Int. Algreba", "IME028-2", "M. Moraga");
        intAlgebra.add(modulo32);
        Modulo modulo33 = new Modulo("Int. Algreba", "IME028-3", "V. Vargas");
        intAlgebra.add(modulo33);
        Modulo modulo34 = new Modulo("Int. Algreba", "IME028-4", "M. Molina");
        intAlgebra.add(modulo34);
        Modulo modulo35 = new Modulo("Int. Algreba", "IME028-5", "A. Calfiqueo");
        intAlgebra.add(modulo35);
        Modulo modulo36 = new Modulo("Int. Algreba", "IME028-6", "A. Ceballos");
        intAlgebra.add(modulo36);
        Modulo modulo41 = new Modulo("Algebra", "IME030-1", "E. Milman");
        algebra.add(modulo41);
        Modulo modulo42 = new Modulo("Algebra", "IME030-2", "J. Molina");
        algebra.add(modulo42);
        Modulo modulo51 = new Modulo("Calculo Dif", "IME045-1", "A. Calfiqueo");
        calculoDif.add(modulo51);
        Modulo modulo52 = new Modulo("Calculo Dif", "IME045-2", "M. Muñoz");
        calculoDif.add(modulo52);
        Modulo modulo61 = new Modulo("Calculo Int", "IME048-1", "R. Leal");
        calculoInt.add(modulo61);
        Modulo modulo62 = new Modulo("Calculo Int", "IME048-2", "V. Vargas");
        calculoInt.add(modulo62);


        //Inicializo las listas
        alumnosListaIndividual = FXCollections.observableArrayList();
        alumnosLista = FXCollections.observableArrayList();
        todosLosAlumnos = FXCollections.observableArrayList();

        //Le agregamos contenido a los comboBox del panel Registro Horas
        comboBoxHorasRealizadas.setItems(contenidoHorasRealizadas);

        //Le agregamos contenido a los comboBox del panel Registro Alumno
        comboBoxCarreras.setItems(contenidoCarrera);
        comboBoxPrecalculoUno.setItems(precalculoUno);
        comboBoxPrecalculoDos.setItems(precalculoDos);
        comboBoxIntAlg.setItems(intAlgebra);
        comboBoxAlgebra.setItems(algebra);
        comboBoxCalculoDif.setItems(calculoDif);
        comboBoxCalculoInt.setItems(calculoInt);
    }

    //Registrar Alumno
    public void registrarAlumno(){
        ArrayList<Ramo> ramos = listaDeRamos();
        Alumno alumno = new Alumno(
                        nombreCompleto.getText(),
                        comboBoxCarreras.getSelectionModel().getSelectedItem(),
                        numMatricula.getText()
                );
        alumno.setRamosCursando(ramos);
        todosLosAlumnos.add(alumno);
        agregarAlumnoAModulos(alumno);
        ManejoArchivo Bd = new ManejoArchivo();
        Bd.registrarAlumno(alumno);
    }

    public void cargarAlumnos(){
        ManejoArchivo BDalumnos = new ManejoArchivo();
        for(int i = 0; i < BDalumnos.obtenerAlumnos().size(); i++){
            todosLosAlumnos.add(BDalumnos.obtenerAlumnos().get(i));
        }
    }

    private ArrayList<Ramo> listaDeRamos(){
        ArrayList<Ramo> ramos = new ArrayList<>();
        if(comboBoxAlgebra.getSelectionModel().getSelectedItem()!=null){
            ramos.add(comboBoxAlgebra.getSelectionModel().getSelectedItem());
        }
        if(comboBoxIntAlg.getSelectionModel().getSelectedItem()!=null){
            ramos.add(comboBoxIntAlg.getSelectionModel().getSelectedItem());
        }

        if(comboBoxPrecalculoUno.getSelectionModel().getSelectedItem()!=null){
            ramos.add(comboBoxPrecalculoUno.getSelectionModel().getSelectedItem());
        }
        if(comboBoxPrecalculoDos.getSelectionModel().getSelectedItem()!=null){
            ramos.add(comboBoxPrecalculoDos.getSelectionModel().getSelectedItem());
        }
        if(comboBoxCalculoDif.getSelectionModel().getSelectedItem()!=null){
            ramos.add(comboBoxCalculoDif.getSelectionModel().getSelectedItem());
        }
        if(comboBoxCalculoInt.getSelectionModel().getSelectedItem()!=null){
            ramos.add(comboBoxCalculoInt.getSelectionModel().getSelectedItem());
        }
        return ramos;
    }
    private void agregarAlumnoAModulos(Alumno alumno){
        if(comboBoxPrecalculoUno.getSelectionModel().getSelectedItem()!=null){
            switch (comboBoxPrecalculoUno.getSelectionModel().getSelectedItem().getCodigo()){
                case "IME027-1":
                    for(int i = 0; i < precalculoUno.size(); i++){
                        if(precalculoUno.get(i).getCodigo().equalsIgnoreCase("IME027-1")){
                            precalculoUno.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME027-2":
                    for(int i = 0; i < precalculoUno.size(); i++){
                        if(precalculoUno.get(i).getCodigo().equalsIgnoreCase("IME027-2")){
                            precalculoUno.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME027-3":
                    for(int i = 0; i < precalculoUno.size(); i++){
                        if(precalculoUno.get(i).getCodigo().equalsIgnoreCase("IME027-3")){
                            precalculoUno.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        if(comboBoxPrecalculoDos.getSelectionModel().getSelectedItem()!=null){
            switch (comboBoxPrecalculoDos.getSelectionModel().getSelectedItem().getCodigo()){
                case "IME029-1":
                    for(int i = 0; i < precalculoDos.size(); i++){
                        if(precalculoDos.get(i).getCodigo().equalsIgnoreCase("IME029-1")){
                            precalculoDos.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME029-2":
                    for(int i = 0; i < precalculoDos.size(); i++){
                        if(precalculoDos.get(i).getCodigo().equalsIgnoreCase("IME029-2")){
                            precalculoDos.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME029-3":
                    for(int i = 0; i < precalculoDos.size(); i++){
                        if(precalculoDos.get(i).getCodigo().equalsIgnoreCase("IME029-3")){
                            precalculoDos.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                default:
                    break;
            }
        }


        if(comboBoxAlgebra.getSelectionModel().getSelectedItem()!=null){
            switch (comboBoxAlgebra.getSelectionModel().getSelectedItem().getCodigo()){
                case "IME030-1":
                    for(int i = 0; i < algebra.size(); i++){
                        if(algebra.get(i).getCodigo().equalsIgnoreCase("IME030-1")){
                            calculoDif.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME030-2":
                    for(int i = 0; i < algebra.size(); i++){
                        if(algebra.get(i).getCodigo().equalsIgnoreCase("IME030-2")){
                            algebra.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        if(comboBoxIntAlg.getSelectionModel().getSelectedItem()!=null){
            switch (comboBoxIntAlg.getSelectionModel().getSelectedItem().getCodigo()){
                case "IME028-1":
                    for(int i = 0; i < intAlgebra.size(); i++){
                        if(intAlgebra.get(i).getCodigo().equalsIgnoreCase("IME028-1")){
                            intAlgebra.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME028-2":
                    for(int i = 0; i < intAlgebra.size(); i++){
                        if(intAlgebra.get(i).getCodigo().equalsIgnoreCase("IME028-2")){
                            intAlgebra.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME028-3":
                    for(int i = 0; i < intAlgebra.size(); i++){
                        if(intAlgebra.get(i).getCodigo().equalsIgnoreCase("IME028-3")){
                            intAlgebra.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME028-4":
                    for(int i = 0; i < intAlgebra.size(); i++){
                        if(intAlgebra.get(i).getCodigo().equalsIgnoreCase("IME028-4")){
                            intAlgebra.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME028-5":
                    for(int i = 0; i < intAlgebra.size(); i++){
                        if(intAlgebra.get(i).getCodigo().equalsIgnoreCase("IME028-5")){
                            intAlgebra.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME028-6":
                    for(int i = 0; i < intAlgebra.size(); i++){
                        if(intAlgebra.get(i).getCodigo().equalsIgnoreCase("IME028-6")){
                            intAlgebra.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                default:
                    break;
            }
        }


        if(comboBoxCalculoInt.getSelectionModel().getSelectedItem()!=null){
            switch (comboBoxCalculoInt.getSelectionModel().getSelectedItem().getCodigo()){
                case "IME048-1":
                    for(int i = 0; i < calculoInt.size(); i++){
                        if(calculoInt.get(i).getCodigo().equalsIgnoreCase("IME048-1")){
                            calculoInt.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME048-2":
                    for(int i = 0; i < calculoInt.size(); i++){
                        if(calculoInt.get(i).getCodigo().equalsIgnoreCase("IME048-2")){
                            calculoInt.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME048-3":
                    for(int i = 0; i < calculoInt.size(); i++){
                        if(calculoInt.get(i).getCodigo().equalsIgnoreCase("IME048-3")){
                            calculoInt.get(i).agregarAlumno(alumno);
                        }
                    }
                default:
                    break;
            }
        }
        if(comboBoxCalculoDif.getSelectionModel().getSelectedItem()!=null){
            switch (comboBoxCalculoDif.getSelectionModel().getSelectedItem().getCodigo()){
                case "IME045-1":
                    for(int i = 0; i < calculoDif.size(); i++){
                        if(calculoDif.get(i).getCodigo().equalsIgnoreCase("IME045-1")){
                            calculoDif.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME045-2":
                    for(int i = 0; i < calculoDif.size(); i++){
                        if(calculoDif.get(i).getCodigo().equalsIgnoreCase("IME045-2")){
                            calculoDif.get(i).agregarAlumno(alumno);
                        }
                    }
                    break;
                case "IME045-3":
                    for(int i = 0; i < calculoDif.size(); i++){
                        if(calculoDif.get(i).getCodigo().equalsIgnoreCase("IME045-3")){
                            calculoDif.get(i).agregarAlumno(alumno);
                        }
                    }
                default:
                    break;
            }
        }
    }

    //Registrar Horas
    public void registrarHoraRealizada(MouseEvent evento){
        for(int i = 0; i < todosLosAlumnos.size(); i++){
            if(todosLosAlumnos.get(i).getNumeroMatricula().equalsIgnoreCase(txtMatricula.getText())){
                if(comboBoxHorasRealizadas.getSelectionModel().equals("Una hora")){
                    todosLosAlumnos.get(i).agregarHorasRealizadas(txtCodigoRamoRegistroHora.getText(), 1);
                }
                if(comboBoxHorasRealizadas.getSelectionModel().equals("Dos horas")){
                    todosLosAlumnos.get(i).agregarHorasRealizadas(txtCodigoRamoRegistroHora.getText(), 2);
                }
            }
        }
    }

    //Eliminar Lista Alumnos por Modulo
    public void eliminarAlumnos(MouseEvent evento){
        encontrarModulo().eliminarAlumnos();
    }

    //Metodo ocupado para hacer que el usuario salga del programa
    public void salir(MouseEvent evento){
        Platform.exit();
        System.exit(0);
    }

    //Metodo para Ingresar al programa
    public void ingresarPrograma(MouseEvent evento){
        if(panelPrincipal.isVisible()){
            panelPrincipal.setVisible(false);
        }
        flechaRegistroHoras.setVisible(true);
        panelRegistroHoras.setVisible(true);
        logoUfro.setVisible(true);
        pestañas.setVisible(true);
    }

    //Metodos ocupados para poder cambiar de pestaña
    public void ingresarRegistrarHoras(MouseEvent evento){
        if(panelRegistroHoras.isVisible()){
            flechaRegistroHoras.setVisible(false);
            panelRegistroHoras.setVisible(false);
            logoUfro.setVisible(false);
            return;
        }

        flechaRegistroHoras.setVisible(true);
        panelRegistroHoras.setVisible(true);
        logoUfro.setVisible(true);


        flechaBuscar.setVisible(false);
        panelBuscar.setVisible(false);

        flechaRegistroAlumno.setVisible(false);
        panelRegistroAlumno.setVisible(false);

        flechaEditar.setVisible(false);
        panelEditar.setVisible(false);
    }
    public void ingresarBuscar(MouseEvent evento){
        if(panelBuscar.isVisible()){
            flechaBuscar.setVisible(false);
            panelBuscar.setVisible(false);
            logoUfro.setVisible(false);
            return;
        }

        panelBuscar.setVisible(true);
        flechaBuscar.setVisible(true);
        logoUfro.setVisible(true);

        flechaRegistroHoras.setVisible(false);
        panelRegistroHoras.setVisible(false);

        flechaEditar.setVisible(false);
        panelEditar.setVisible(false);

        flechaRegistroAlumno.setVisible(false);
        panelRegistroAlumno.setVisible(false);
    }
    public void ingresarRegistrarAlumno(MouseEvent evento){
        if(panelRegistroAlumno.isVisible()){
            flechaRegistroAlumno.setVisible(false);
            panelRegistroAlumno.setVisible(false);
            logoUfro.setVisible(false);
            return;
        }

        panelBuscar.setVisible(false);
        flechaBuscar.setVisible(false);

        flechaRegistroHoras.setVisible(false);
        panelRegistroHoras.setVisible(false);

        flechaEditar.setVisible(false);
        panelEditar.setVisible(false);

        flechaRegistroAlumno.setVisible(true);
        panelRegistroAlumno.setVisible(true);
        logoUfro.setVisible(true);
    }
    public void ingresarEditar(MouseEvent evento){
        if(panelEditar.isVisible()){
            flechaEditar.setVisible(false);
            panelEditar.setVisible(false);
            logoUfro.setVisible(false);
            return;
        }

        panelBuscar.setVisible(false);
        flechaBuscar.setVisible(false);

        flechaRegistroHoras.setVisible(false);
        panelRegistroHoras.setVisible(false);

        flechaEditar.setVisible(true);
        panelEditar.setVisible(true);
        logoUfro.setVisible(true);

        flechaRegistroAlumno.setVisible(false);
        panelRegistroAlumno.setVisible(false);
    }
    public void ingresarDatosAlumno(MouseEvent evento) {
        if (panelBuscar.isVisible()) {
            panelBuscar.setVisible(false);
            flechaBuscar.setVisible(false);
            logoUfro.setVisible(false);
            pestañas.setVisible(false);
        }
        panelDatosAlumnos.setVisible(true);
        alumnosListaIndividual.add(filtroAlumno(encontrarAlumno()));
        lstAlumnos.setItems(alumnosListaIndividual);
    }
    public void salirPanelDatosAlumno(MouseEvent evento) {
        if (panelDatosAlumnos.isVisible()) {
            panelDatosAlumnos.setVisible(false);
        }
        panelBuscar.setVisible(true);
        flechaBuscar.setVisible(true);
        logoUfro.setVisible(true);
        pestañas.setVisible(true);

        eliminarDatosLista(alumnosListaIndividual);
    }
    public void ingresarListaAlumnos(MouseEvent evento) {
        if (panelBuscar.isVisible()) {
            panelBuscar.setVisible(false);
            flechaBuscar.setVisible(false);
            logoUfro.setVisible(false);
            pestañas.setVisible(false);
        }
        panelLista.setVisible(true);
        alumnosLista = modulo();
        lstAlumnos.setItems(alumnosLista);
    }
    public void salirListaAlumnos(MouseEvent evento) {
        if (panelLista.isVisible()) {
            panelLista.setVisible(false);
        }
        panelBuscar.setVisible(true);
        flechaBuscar.setVisible(true);
        logoUfro.setVisible(true);
        pestañas.setVisible(true);

        eliminarDatosLista(alumnosLista);
    }

    //Metodo Auxiliar
    private Alumno filtroAlumno(Alumno alumno){
        if(!alumno.encontrarHorasRealizadasSegunRamo(txtCodigoRamoListAlum.getText()).equals(null)){
            return alumno;
        }
        return null;
    }
    private Alumno encontrarAlumno() {
        int posicion = -1;
        for (int i = 0; i < this.todosLosAlumnos.size(); i++) {
            if (this.todosLosAlumnos.get(i).getNumeroMatricula() == numMatriculaBuscar.getText()) {
                posicion = i;
            }
        }
        if (posicion != -1) {
            return this.todosLosAlumnos.get(posicion);
        } else {
            return null;
        }
    }
    private Modulo encontrarModulo() {
        int posicion = -1;
        for (int i = 0; i < this.todosLosAlumnos.size(); i++) {
            if (this.modulos.get(i).getCodigo().equals(txtCodRamoElimnarAlum.getText())){
                posicion = i;
            }
        }
        if (posicion != -1) {
            return this.modulos.get(posicion);
        }
        return null;
    }
    private void eliminarDatosLista(ObservableList<Alumno> lista){
        for(int i = 0; i < lista.size(); i++){
            lista.remove(i);
        }
    }
    public ObservableList<Alumno> modulo(){
        switch(txtCodigoRamoListAlum.getText()){
            case "IME027-1":
                for(int i = 0; i < precalculoUno.size(); i++){
                    if(precalculoUno.get(i).getCodigo().equalsIgnoreCase("IME027-1")){
                        return precalculoUno.get(i).getAlumnos();
                    }
                }
                break;
            case "IME027-2":
                for(int i = 0; i < precalculoUno.size(); i++){
                    if(precalculoUno.get(i).getCodigo().equalsIgnoreCase("IME027-2")){
                        return precalculoUno.get(i).getAlumnos();
                    }
                }
                break;
            case "IME027-3":
                for(int i = 0; i < precalculoUno.size(); i++){
                    if(precalculoUno.get(i).getCodigo().equalsIgnoreCase("IME027-3")){
                        return precalculoUno.get(i).getAlumnos();
                    }
                }
                break;
            case "IME028-1":
                for(int i = 0; i < intAlgebra.size(); i++){
                    if(intAlgebra.get(i).getCodigo().equalsIgnoreCase("IME028-1")){
                        return intAlgebra.get(i).getAlumnos();
                    }
                }
                break;
            case "IME028-2":
                for(int i = 0; i < intAlgebra.size(); i++){
                    if(intAlgebra.get(i).getCodigo().equalsIgnoreCase("IME028-2")){
                        return intAlgebra.get(i).getAlumnos();
                    }
                }
                break;
            case "IME028-3":
                for(int i = 0; i < intAlgebra.size(); i++){
                    if(intAlgebra.get(i).getCodigo().equalsIgnoreCase("IME028-3")){
                        return intAlgebra.get(i).getAlumnos();
                    }
                }
                break;
            case "IME028-4":
                for(int i = 0; i < intAlgebra.size(); i++){
                    if(intAlgebra.get(i).getCodigo().equalsIgnoreCase("IME028-4")){
                        return intAlgebra.get(i).getAlumnos();
                    }
                }
                break;
            case "IME028-5":
                for(int i = 0; i < intAlgebra.size(); i++){
                    if(intAlgebra.get(i).getCodigo().equalsIgnoreCase("IME028-5")){
                        return intAlgebra.get(i).getAlumnos();
                    }
                }
                break;
            case "IME028-6":
                for(int i = 0; i < intAlgebra.size(); i++){
                    if(intAlgebra.get(i).getCodigo().equalsIgnoreCase("IME028-6")){
                        return intAlgebra.get(i).getAlumnos();
                    }
                }
                break;
            case "IME029-1":
                for(int i = 0; i < precalculoDos.size(); i++){
                    if(precalculoDos.get(i).getCodigo().equalsIgnoreCase("IME029-1")){
                        return precalculoDos.get(i).getAlumnos();
                    }
                }
                break;
            case "IME029-2":
                for(int i = 0; i < precalculoDos.size(); i++){
                    if(precalculoDos.get(i).getCodigo().equalsIgnoreCase("IME029-2")){
                        return precalculoDos.get(i).getAlumnos();
                    }
                }
                break;
            case "IME029-3":
                for(int i = 0; i < precalculoDos.size(); i++){
                    if(precalculoDos.get(i).getCodigo().equalsIgnoreCase("IME029-3")){
                        return precalculoDos.get(i).getAlumnos();
                    }
                }
                break;
            case "IME030-1":
                for(int i = 0; i < algebra.size(); i++){
                    if(algebra.get(i).getCodigo().equalsIgnoreCase("IME030-1")){
                        return algebra.get(i).getAlumnos();
                    }
                }
                break;
            case "IME030-2":
                for(int i = 0; i < algebra.size(); i++){
                    if(algebra.get(i).getCodigo().equalsIgnoreCase("IME030-2")){
                        return algebra.get(i).getAlumnos();
                    }
                }
                break;
            case "IME045-1":
                for(int i = 0; i < algebra.size(); i++){
                    if(algebra.get(i).getCodigo().equalsIgnoreCase("IME045-1")){
                        return algebra.get(i).getAlumnos();
                    }
                }
                break;
            case "IME045-2":
                for(int i = 0; i < calculoDif.size(); i++){
                    if(calculoDif.get(i).getCodigo().equalsIgnoreCase("IME045-2")){
                        return calculoDif.get(i).getAlumnos();
                    }
                }
                break;
            case "IME048-1":
                for(int i = 0; i < calculoInt.size(); i++){
                    if(calculoInt.get(i).getCodigo().equalsIgnoreCase("IME048-1")){
                        return calculoInt.get(i).getAlumnos();
                    }
                }
                break;
            case "IME048-2":
                for(int i = 0; i < calculoInt.size(); i++){
                    if(calculoInt.get(i).getCodigo().equalsIgnoreCase("IME048-2")){
                        return calculoInt.get(i).getAlumnos();
                    }
                }
                break;
        }
        return null;
    }

}