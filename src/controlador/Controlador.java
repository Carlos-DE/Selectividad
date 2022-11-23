package controlador;

import vista.*;

public class Controlador{

	private VistaHome vistaHome;
	private VistaSedes vistaSedes;
	private VistaAsignaturas vistaAsignaturas;
	
	public void setVistaHome(VistaHome vistaHome) {
		this.vistaHome = vistaHome;
	}
	
	public void setVistaSedes(VistaSedes vistaSedes) {
		this.vistaSedes = vistaSedes;
	}

	public void setVistaAsignaturas(VistaAsignaturas vistaAsignaturas) {
		this.vistaAsignaturas = vistaAsignaturas;
	}
	
	public void mostrarHome() {
		vistaHome.setVisible(true);
		vistaAlumnos.setVisible(false);
		vistaAsignaturas.setVisible(false);
		vistaSedes.setVisible(false);
		//vistaAulas.setVisible(false);
		vistaResponsables.setVisible(false);
		//vistaInstitutos.setVisible(false);
		//vistaGenerar.setVisible(false);
	}
	
	public void mostrarAlumnos() {
		vistaHome.setVisible(false);
		vistaAlumnos.setVisible(true);
		vistaAsignaturas.setVisible(false);
		vistaSedes.setVisible(false);
		//vistaAulas.setVisible(false);
		vistaResponsables.setVisible(false);
		//vistaInstitutos.setVisible(false);
		//vistaGenerar.setVisible(false);
	}
	
	public void mostrarAsignaturas() {
		vistaHome.setVisible(false);
		vistaAlumnos.setVisible(false);
		vistaAsignaturas.setVisible(true);
		vistaSedes.setVisible(false);
		//vistaAulas.setVisible(false);
		vistaResponsables.setVisible(false);
		//vistaInstitutos.setVisible(false);
		//vistaGenerar.setVisible(false);
	}

	public void mostrarSedes() {
		vistaHome.setVisible(false);
		vistaAlumnos.setVisible(false);
		vistaAsignaturas.setVisible(false);
		vistaSedes.setVisible(true);
		//vistaAulas.setVisible(false);
		vistaResponsables.setVisible(false);
		//vistaInstitutos.setVisible(false);
		//vistaGenerar.setVisible(false);
	}
	
	public void mostrarAulas() {
		vistaHome.setVisible(false);
		vistaAlumnos.setVisible(false);
		vistaAsignaturas.setVisible(false);
		vistaSedes.setVisible(false);
		//vistaAulas.setVisible(true);
		vistaResponsables.setVisible(false);
		//vistaInstitutos.setVisible(false);
		//vistaGenerar.setVisible(false);
	}
	
	public void mostrarResponsables() {
		vistaHome.setVisible(false);
		vistaAlumnos.setVisible(false);
		vistaAsignaturas.setVisible(false);
		vistaSedes.setVisible(false);
		//vistaAulas.setVisible(false);
		vistaResponsables.setVisible(true);
		//vistaInstitutos.setVisible(false);
		//vistaGenerar.setVisible(false);
	}
	
	public void mostrarInstitutos() {
		vistaHome.setVisible(false);
		vistaAlumnos.setVisible(false);
		vistaAsignaturas.setVisible(false);
		vistaSedes.setVisible(false);
		//vistaAulas.setVisible(false);
		vistaResponsables.setVisible(false);
		//vistaInstitutos.setVisible(true);
		//vistaGenerar.setVisible(false);
	}
	
	public void mostrarGenerar() {
		vistaHome.setVisible(false);
		vistaAlumnos.setVisible(false);
		vistaAsignaturas.setVisible(false);
		vistaSedes.setVisible(false);
		//vistaAulas.setVisible(false);
		vistaResponsables.setVisible(false);
		//vistaInstitutos.setVisible(false);
		//vistaGenerar.setVisible(true);
	}
}
