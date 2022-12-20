package controlador;
import modelo.Sede;
import vista.*;

public class Main {

	public static void main(String[] args) {
		VistaAula vistaAula = new VistaAula();

		new Main().iniciar(vistaAula);

	}
	
	private void iniciar(VistaAula vistaAula) {
		ConexionConBaseDeDatos accesoBD;
        accesoBD = ConexionBaseDatosJDBC.getInstance();
		Controlador controlador = new Controlador();
		VistaHome vistaHome = new VistaHome();
		VistaAlumnos vistaAlumnos = new VistaAlumnos();
		VistaAsignaturas vistaAsignaturas = new VistaAsignaturas();
		VistaSedes vistaSedes = new VistaSedes();
//		VistaAulas vistaAulas = new VistaAulas();
		VistaResponsablesSede vistaResponsables = new VistaResponsablesSede();
		VistaInstituto vistaInstituto = new VistaInstituto();
//		VistaGenerar vistaGenerar = new VistaGenerar();
		VistaResponsablesExamen vistaResponsablesExamen = new VistaResponsablesExamen();
		VistaExamen vistaExamen = new VistaExamen();
		
		
		
		
		vistaHome.setControlador(controlador);
		vistaAlumnos.setControlador(controlador);
		vistaSedes.setControlador(controlador);
		vistaAsignaturas.setControlador(controlador);
		vistaResponsables.setControlador(controlador);
		vistaResponsablesExamen.setControlador(controlador);
		vistaExamen.setControlador(controlador);
		vistaAula.setControlador(controlador);
		vistaInstituto.setControlador(controlador);


		controlador.setVistaHome(vistaHome);
		controlador.setVistaAlumnos(vistaAlumnos);
		controlador.setVistaAsignaturas(vistaAsignaturas);
		controlador.setVistaSedes(vistaSedes);
		controlador.setVistaAula(vistaAula);
		controlador.setVistaResponsables(vistaResponsables);
		controlador.setVistaInstituto(vistaInstituto);
//		controlador.setVistaGenerar(vistaGenerar);
		controlador.setVistaResponsablesExamen(vistaResponsablesExamen);
		controlador.setVistaExamen(vistaExamen);



		controlador.mostrarHome();
	}

}
//alumno,asignatura, sede,aula,resp,inst,generar