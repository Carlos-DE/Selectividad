package controlador;

import vista.*;

public class Controlador{

	ConexionConBaseDeDatos conexionBD;
	private VistaHome vistaHome;
	private VistaSedes vistaSedes;
	private VistaAsignaturas vistaAsignaturas;
	private VistaAlumnos vistaAlumnos;
	private VistaResponsablesSede vistaResponsables;
	private VistaResponsablesExamen vistaResponsablesExamen;
	private VistaExamen vistaExamen;

	public void setVistaHome(VistaHome vistaHome) {
		this.vistaHome = vistaHome;
	}

	public void setVistaSedes(VistaSedes vistaSedes) {
		this.vistaSedes = vistaSedes;
	}

	public void setVistaAsignaturas(VistaAsignaturas vistaAsignaturas) {
		this.vistaAsignaturas = vistaAsignaturas;
	}

	public void setVistaAlumnos(VistaAlumnos vistaAlumnos){
		this.vistaAlumnos = vistaAlumnos;
	}

	public void setVistaResponsables(VistaResponsablesSede vistaResponsables) {
		this.vistaResponsables = vistaResponsables;

	}
	public void setVistaResponsablesExamen(VistaResponsablesExamen vistaResponsablesExamen) {
		this.vistaResponsablesExamen = vistaResponsablesExamen;

	}
	public void setVistaExamen(VistaExamen vistaExamen) {
		this.vistaExamen = vistaExamen;

	}
	


	public void mostrarHome() {
		setVisibleFalse();
		vistaHome.setVisible(true);

	}

	public void mostrarExamenes() {
		setVisibleFalse();
		vistaExamen.setVisible(true);

	}

	public void mostrarAlumnos() {
		setVisibleFalse();
		vistaAlumnos.setVisible(true);

	}

	public void mostrarAsignaturas() {
		setVisibleFalse();
		vistaAsignaturas.setVisible(true);
	}

	public void mostrarSedes() {
		setVisibleFalse();
		vistaSedes.setVisible(true);
	}

	public void mostrarAulas() {
		setVisibleFalse();
		//vistaAulas.setVisible(true);
	}

	public void mostrarResponsables() {
		setVisibleFalse();
		vistaResponsables.setVisible(true);
	}

	public void mostrarInstitutos() {
		setVisibleFalse();
		//vistaInstitutos.setVisible(true);
	}

	public void mostrarGenerar() {
		setVisibleFalse();
		//vistaGenerar.setVisible(true);
	}

	public void mostrarResponsablesExamenes() {
		setVisibleFalse();
		vistaResponsablesExamen.setVisible(true);

	}

	public void setVisibleFalse(){
		vistaHome.setVisible(false);
		
		vistaAlumnos.setVisible(false);
		vistaAsignaturas.setVisible(false);
		vistaSedes.setVisible(false);
		
		vistaResponsables.setVisible(false);
		//vistaInstitutos.setVisible(false);
		//vistaGenerar.setVisible(false);

		//vistaAulas.setVisible(false);
		vistaResponsablesExamen.setVisible(false);


	
	}


}
