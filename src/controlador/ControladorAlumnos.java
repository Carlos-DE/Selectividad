package controlador;

import javax.swing.*;

import modelo.Alumno;
import modelo.Sede;

import java.io.*;
import java.util.Scanner;

public class ControladorAlumnos {
	public String ruta;
	public ConexionConBaseDeDatos conexionBD = ConexionBaseDatosJDBC.getInstance();;
    public  ControladorAlumnos(){

    }
    public void abrirArchivo() throws IOException {
        System.out.println("llego 1");

        JFileChooser jf = new JFileChooser();
        System.out.println("llego 2");

        jf.showOpenDialog(jf);
        System.out.println("llego 3");
        File archivo = jf.getSelectedFile();
        if(archivo !=null) {
            ruta = archivo.getAbsolutePath();
            carga(ruta);
        }
    }
    private void carga(String ruta) throws FileNotFoundException, IOException {     
        String x;
        Alumno a = new Alumno();;
        String[] partes = new String[5];
    	Scanner sc = new Scanner(new File(ruta),"UTF-8");
        //parsing a CSV file into the constructor of Scanner class 
        sc.useDelimiter("\\r?\\n|\\r");
        sc.nextLine();
        //setting comma as delimiter pattern
        while (sc.hasNext()) {
        int cont=0;
          x = sc.next();
          partes = x.split(";");
          
          try {
            a.setCentro(partes[0]);
            a.setNombre(partes[1]);
            a.setApellido1(partes[2]);
            a.setApellido2(partes[3]);
            a.setDni(partes[4]); 
            a.setDetalleMateria(partes[5]);
            conexionBD.insertarAlumno(a);
            
            System.out.println(a);
            System.out.println("Linea" + cont + " leida");

          } catch (Exception e) {
            System.out.println("error al leer linea " + cont +" del csv");
            e.printStackTrace();
          }
          cont=cont+1;
          
        }
        sc.close();
        
}
	public void borrarDatos() {
		System.out.println("paso 1");
		conexionBD.borrarAlumno();
	}
	public void refresh() {
        
	}
}