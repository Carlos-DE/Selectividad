package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.swing.JFileChooser;

import modelo.Responsable;
import modelo.Sede;

public class ControladorResponsables {
	  public String ruta;
		public ConexionConBaseDeDatos conexionBD = ConexionBaseDatosJDBC.getInstance();

	    public  ControladorResponsables(){

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
	        String cadena;
	        FileReader f = new FileReader(ruta,StandardCharsets.UTF_8);
	        BufferedReader b = new BufferedReader(f);
	        b.readLine();
	        
	        while((cadena = b.readLine())!=null) {
				cadena = cadena.replace("\t", " ");
	            System.out.println(cadena);
	            var responsable = new Responsable(cadena);
	            conexionBD.insertarResponsable(responsable);
	            
				//conexionBaseDatosJDBC.insertarSede(sede);
	        }
	        conexionBD.listaSedes();
	        b.close();
	    }
		public void borrarDatos() {
			System.out.println("paso 1");
			conexionBD.borrarResponsables();
		}
	}