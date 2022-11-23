package controlador;

import javax.swing.*;

import modelo.Sede;

import java.io.*;

public class ControladorSede {
    public String ruta;
	public ConexionConBaseDeDatos conexionBD = ConexionBaseDatosJDBC.getInstance();
;

    public  ControladorSede(){

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
        FileReader f = new FileReader(ruta);
        BufferedReader b = new BufferedReader(f);
        b.readLine();
        
        while((cadena = b.readLine())!=null) {
        	String cadenaId = cadena.substring(3,5);
        	String cadenaNombre = cadena.substring(6);
        	int id = Integer.parseInt(cadenaId);
            System.out.println(cadena);
            var sede = new Sede(id,cadenaNombre);
            conexionBD.insertarSede(sede);
			//conexionBaseDatosJDBC.insertarSede(sede);
        }
        conexionBD.listaSedes();
        b.close();
    }
	public void borrarDatos() {
		System.out.println("paso 1");
		conexionBD.borrarSede();
		
	}
}
