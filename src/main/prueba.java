package main;
import java.util.List;


public class prueba{


public static void main(String[] args) {
        ConexionConBasedeDatos accesoBD;

        accesoBD = ConexionBaseDatosJDBC.getInstance();


        List<Alumno> lista = accesoBD.listaAlumnosDeUnCentro("c1");

        }


}