package modelo;

import java.io.*;

import javax.swing.JFileChooser;

public class Sede{

	
	String ruta;
    Integer idSede;
    String nombre;

   
    public Sede (String nombre) {
    	this.nombre = nombre;
    }
    
    public Sede(Integer idSede, String nombre) {
        this.idSede = idSede;
        this.nombre = nombre;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    
    
}