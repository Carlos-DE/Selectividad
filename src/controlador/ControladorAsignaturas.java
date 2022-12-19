package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

import modelo.Materia;
import modelo.Sede;
import vista.VistaAsignaturas;

public class ControladorAsignaturas {
	public String ruta;
	public ConexionConBaseDeDatos conexionBD = ConexionBaseDatosJDBC.getInstance();

    public  ControladorAsignaturas(){

    }
    public void abrirArchivo() throws IOException {
        //System.out.println("llego 1");

        JFileChooser jf = new JFileChooser();
        //System.out.println("llego 2");

        jf.showOpenDialog(jf);
        //System.out.println("llego 3");
        File archivo = jf.getSelectedFile();
        if(archivo !=null) {
            ruta = archivo.getAbsolutePath();
            carga(ruta);
        }
    }
    private void carga(String ruta) throws FileNotFoundException, IOException {
        String cadena;
        //FileReader f = new FileReader(ruta);
        InputStream f = new FileInputStream(ruta);
        InputStreamReader i = new InputStreamReader(f, StandardCharsets.UTF_8);
        BufferedReader b = new BufferedReader(i);
        b.readLine();
        
        while((cadena = b.readLine())!=null) {
        	//int id = Integer.parseInt(cadena);
            System.out.println(cadena);
            var asignatura = new Materia(cadena);
            conexionBD.insertarAsignaturas(asignatura);
			//conexionBaseDatosJDBC.insertarSede(sede);
        }
        conexionBD.listaSedes();
        b.close();
        System.out.println("");
        conexionBD.listaMaterias();
     

    }
	public void borrarDatos() {
		System.out.println("paso 1");
		conexionBD.borrarAsignaturas();
		conexionBD.listaSedes().clear();
    }

    

    

}
