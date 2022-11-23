package controlador;
import vista.*;

public class Main {

	public static void main(String[] args) {

		new Main().iniciar();

	}
	
	private void iniciar() {
		Controlador controlador = new Controlador();
		VistaHome vistaHome = new VistaHome();
		VistaSedes vistaSedes = new VistaSedes();
		VistaAsignaturas vistaAsignaturas = new VistaAsignaturas();
		
		
		vistaHome.setControlador(controlador);
		vistaSedes.setControlador(controlador);
		vistaAsignaturas.setControlador(controlador);
		
		controlador.setVistaHome(vistaHome);
		controlador.setVistaSedes(vistaSedes);
		controlador.setVistaAsignaturas(vistaAsignaturas);
		
		
		
		controlador.mostrarHome();
	}

}
//alumno,asignatura, sede,aula,resp,inst,generar