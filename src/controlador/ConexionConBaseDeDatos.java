package controlador;

import java.util.List;

import modelo.Alumno;
import modelo.Aula;
import modelo.Materia;
import modelo.Responsable;
import modelo.ResponsableExamen;
import modelo.Sede;

public abstract class ConexionConBaseDeDatos {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://database-pevau.cobadwnzalab.eu-central-1.rds.amazonaws.com";
    static final String DB_SCHEMA = "grupo11DB";

    //  Database credentials
    static final String USER = "grupo11";
    static final String PASS = "xtDA3sPVFCE9BRhK";

    public abstract List<Materia> listaMaterias();
    public abstract List<Materia> verMaterias();
    public abstract List<Sede> listaSedes();
    public abstract List<Alumno> listaAlumnos();
    public abstract List<Alumno> listaAlumnosDeUnCentro(String centro);
    public abstract List<Responsable> listaResponsable();
    public abstract int insertarSede(Sede s);
    public abstract int actualizarSede(Sede s);
    public abstract int  borrarSede();
    public abstract int borrarAsignaturas();
	public abstract int insertarAsignaturas(Materia asignatura);
	public abstract int insertarAlumno(Alumno a);
    public abstract int borrarAlumno();
	public abstract int insertarResponsable(Responsable responsable);
    public abstract int borrarResponsables();
	public abstract List<ResponsableExamen> listaResponsablesExamen();
	public abstract int insertarResponsablesExamen(ResponsableExamen responsable);
	public abstract int insertarAula(Aula a);
    public abstract int actualizarAula(Aula a, int aforonuevo);
    public abstract int  borrarAula(Aula a);
    //public abstract List<Aula> listaAulas();
    public  abstract List<Aula> listaAulas();
    public abstract int asignarInstituto(String nombreInstituto, String nombreSede);


	}