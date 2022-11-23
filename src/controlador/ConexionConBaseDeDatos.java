package controlador;

import java.util.List;

import modelo.Alumno;
import modelo.Materia;
import modelo.Sede;

public abstract class ConexionConBaseDeDatos {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "database-pevau.cobadwnzalab.eu-central-1.rds.amazonaws.com";
    static final String DB_SCHEMA = "grupo11DB";

    //  Database credentials
    static final String USER = "grupo11";
    static final String PASS = "xtDA3sPVFCE9BRhK";

    public abstract List<Materia> listaMaterias();
    public abstract List<Sede> listaSedes();
    public abstract List<Alumno> listaAlumnosDeUnCentro(String centro);
}