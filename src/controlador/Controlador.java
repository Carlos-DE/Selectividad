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

	public void mostrarHome() {
		vistaHome.setVisible(true);
		vistaSedes.setVisible(false);
		vistaAsignaturas.setVisible(false);
	}

	public void mostrarSedes() {
		vistaHome.setVisible(false);
		vistaSedes.setVisible(true);
		vistaAsignaturas.setVisible(false);
		
	}

	public void setVistaAsignaturas(VistaAsignaturas vistaAsignaturas) {
		this.vistaAsignaturas = vistaAsignaturas;
	}

	public void mostrarAsignaturas() {
		vistaHome.setVisible(false);
		vistaSedes.setVisible(false);
		vistaAsignaturas.setVisible(true);
	}
}
