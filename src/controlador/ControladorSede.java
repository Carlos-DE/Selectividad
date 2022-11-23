package controlador;

import javax.swing.*;

import modelo.Sede;

import java.io.*;

public class ControladorSede {
    public String ruta;
    public  ConexionBaseDatosJDBC conexionBaseDatosJDBC = new ConexionBaseDatosJDBC();
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
        	cadena = cadena.substring(6);
            System.out.println(cadena);
            var sede = new Sede(cadena);
 
			conexionBaseDatosJDBC.insertarSede(sede);
        }
        b.close();
    }
}
