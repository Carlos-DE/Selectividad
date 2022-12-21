package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import modelo.Alumno;

public class ControladorInstituto {
	public String ruta;
	public ConexionConBaseDeDatos conexionBD = ConexionBaseDatosJDBC.getInstance();;
    public  ControladorInstituto(){

    }
    public void cargarInstitutos(){
    	
    }
    
//	public void borrarDatos() {
//		System.out.println("paso 1");
//		//conexionBD.borrarAlumno();
//		
//	}
	public void refresh() {
        
	}

    public void asignarInstituto(String nombreInstituto, String nombreSede){
        assert nombreInstituto != null;
        assert nombreSede != null;

        conexionBD.asignarInstituto(nombreInstituto, nombreSede);
        
    }

    public void quitarInstituto(String nombreInstituto, String nombreSede){
        assert nombreInstituto != null;
        assert nombreSede != null;

        conexionBD.quitarInstituto(nombreInstituto, nombreSede);
        
    }

    public boolean consultarListaInstitutos() {
        return conexionBD.consultarListaInstitutos();
    }

}
