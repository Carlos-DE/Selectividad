package controlador;
import modelo.Sede;
import vista.*;

public class Main {

	public static void main(String[] args) {

		new Main().iniciar();

	}
	
	private void iniciar() {
		Controlador controlador = new Controlador();
		VistaHome vistaHome = new VistaHome();
		VistaAlumnos vistaAlumnos = new VistaAlumnos();
		VistaAsignaturas vistaAsignaturas = new VistaAsignaturas();
		VistaSedes vistaSedes = new VistaSedes();
//		VistaAulas vistaAulas = new VistaAulas();
		VistaResponsables vistaResponsables = new VistaResponsables();
//		VistaInstitutos vistaInstitutos = new VistaInstitutos();
//		VistaGenerar vistaGenerar = new VistaGenerar();
		
		
		
		
		vistaHome.setControlador(controlador);
		vistaSedes.setControlador(controlador);
		vistaAsignaturas.setControlador(controlador);
		
		controlador.setVistaHome(vistaHome);
		controlador.setVistaAlumnos(vistaAlumnos);
		controlador.setVistaAsignaturas(vistaAsignaturas);
		controlador.setVistaSedes(vistaSedes);
//		controlador.setVistaAulas(vistaAulas);
		controlador.setVistaResponsables(vistaResponsables);
//		controlador.setVistaInstitutos(vistaInstitutos);
//		controlador.setVistaGenerar(vistaGenerar);
		
		
		
		
		controlador.mostrarHome();
	}

}
//alumno,asignatura, sede,aula,resp,inst,generar