package controlador;

import javax.swing.JOptionPane;

import modelo.Aula;

public class ControladorAula {

    public ConexionConBaseDeDatos conexionBD = ConexionBaseDatosJDBC.getInstance();;


    public void anadirAula(Aula aula) {
        assert aula != null;
        conexionBD.insertarAula(aula);

        System.out.println("aula insertada");
        JOptionPane.showMessageDialog(null, "Añadida con éxito");

    }


    public Aula crearAula(String codigo, String aforo) {
        assert codigo != null;
        assert aforo != null;
        return new Aula(codigo, Integer.parseInt(aforo));
    }

}
