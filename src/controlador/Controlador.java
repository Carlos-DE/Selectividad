package controlador;

import vista.*;

public class Controlador{

	ConexionConBaseDeDatos conexionBD;
	private VistaHome vistaHome;
	private VistaAlumnos vistaAlumnos;
	private VistaAsignaturas vistaAsignaturas;
	private VistaExamen vistaExamen;
	private VistaInstituto vistaInstituto;
	private VistaSedes vistaSedes;
	private VistaResponsablesSede vistaResponsables;
	
	private VistaResponsablesExamen vistaResponsablesExamen;
	private VistaAula vistaAula;
	

	
	
	public void setVistaHome(VistaHome vistaHome) {
		this.vistaHome = vistaHome;
	}
	public void setVistaAlumnos(VistaAlumnos vistaAlumnos){
		this.vistaAlumnos = vistaAlumnos;
	}
	public void setVistaAsignaturas(VistaAsignaturas vistaAsignaturas) {
		this.vistaAsignaturas = vistaAsignaturas;
	}
	public void setVistaExamen(VistaExamen vistaExamen) {
		this.vistaExamen = vistaExamen;

	}
	public void setVistaInstituto(VistaInstituto vistaInstituto) {
		this.vistaInstituto = vistaInstituto;
	}
	public void setVistaResponsables(VistaResponsablesSede vistaResponsables) {
		this.vistaResponsables = vistaResponsables;

	}	
	public void setVistaSedes(VistaSedes vistaSedes) {
		this.vistaSedes = vistaSedes;
	}
		

	public void setVistaAula(VistaAula vistaAula){
		this.vistaAula = vistaAula;
	}
	public void setVistaResponsablesExamen(VistaResponsablesExamen vistaResponsablesExamen) {
		this.vistaResponsablesExamen = vistaResponsablesExamen;
	}
	
	
	
	


	public void mostrarHome() {
		setVisibleFalse();
		vistaHome.setVisible(true);
	}

	
	public void mostrarAlumnos() {
		setVisibleFalse();
		vistaAlumnos.setVisible(true);

	}

	public void mostrarAsignaturas() {
		setVisibleFalse();
		vistaAsignaturas.setVisible(true);
	}

		
	public void mostrarExamenes() {
		setVisibleFalse();
		vistaExamen.setVisible(true);
	}

	public void mostrarInstitutos() {
		setVisibleFalse();
		vistaInstituto.setVisible(true);
	}
	
	public void mostrarResponsables() {
		setVisibleFalse();
		vistaResponsables.setVisible(true);
	}
	
	public void mostrarSedes() {
		setVisibleFalse();
		vistaSedes.setVisible(true);
	}

	
	
	public void mostrarAulas() {
		setVisibleFalse();
		vistaAula.setVisible(true);
	}

	public void mostrarResponsablesExamenes() {
		setVisibleFalse();
		vistaResponsablesExamen.setVisible(true);
	}

	
	public void mostrarGenerar() {
		setVisibleFalse();
		//vistaGenerar.setVisible(true);
	}

	
	public void setVisibleFalse(){
		vistaHome.setVisible(false);
		vistaAlumnos.setVisible(false);
		vistaAsignaturas.setVisible(false);
		vistaExamen.setVisible(false);
		vistaInstituto.setVisible(false);
		vistaSedes.setVisible(false);
		vistaResponsables.setVisible(false);
		
		vistaAula.setVisible(false);
		vistaResponsablesExamen.setVisible(false);

		//vistaGenerar.setVisible(false);
	
	}



}
