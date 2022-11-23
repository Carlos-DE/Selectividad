package vista;

import javax.swing.*;

import controlador.Controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaHome extends JFrame implements ActionListener{

	private Controlador controlador;
	
	private JButton bHome;
	private JButton bAlumnos;
	private JButton bAsignaturas;
	private JButton bSedes;
	private JButton bAulas;
	private JButton bResponsables;
	private JButton bInstitutos;
	private JButton bGenerar;
	
	/**
	 * Create the application.
	 */
	public VistaHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSize(960, 540);
		setTitle("PEVAU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	
		
		//alumno,asignatura, sede,aula,resp,inst,generar
		Panel menu = new Panel();
		menu.setFont(new Font("Dialog", Font.PLAIN, 14));
		menu.setBackground(new Color(0, 64, 128));
		getContentPane().add(menu, BorderLayout.NORTH);
		
		bHome = new JButton("Home");
		bHome.addActionListener(this);
		menu.add(bHome);
		
		bAlumnos = new JButton("Alumnos");
		bAlumnos.addActionListener(this);
		menu.add(bAlumnos);
		
		bSedes = new JButton("Sedes");
		bSedes.addActionListener(this);
		menu.add(bSedes);
		
		bAsignaturas = new JButton("Asignaturas");
		bAsignaturas.addActionListener(this);
		menu.add(bAsignaturas);
		
		
		
//		bAulas = new JButton("Aulas");
//		bAulas.addActionListener(this);
//		menu.add(bAulas);
		
		bResponsables = new JButton("Responsables");
		bResponsables.addActionListener(this);
		menu.add(bResponsables);
		
//		bInstitutos = new JButton("Institutos");
//		bInstitutos.addActionListener(this);
//		menu.add(bInstitutos);
		
//		bGenerar = new JButton("Generar");
//		bGenerar.addActionListener(this);
//		menu.add(bGenerar);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bHome) {
			controlador.mostrarHome();
		} else if (e.getSource()==bAlumnos) {
			controlador.mostrarAlumnos();
		} else if (e.getSource()==bAsignaturas) {
			controlador.mostrarAsignaturas();
		} else if (e.getSource()==bSedes) {
			controlador.mostrarSedes();
		} else if (e.getSource()==bAulas) {
			controlador.mostrarAulas();
		} else if (e.getSource()==bResponsables) {
			controlador.mostrarResponsables();
		} else if (e.getSource()==bInstitutos) {
			controlador.mostrarInstitutos();
		} else if (e.getSource()==bGenerar) {
			controlador.mostrarGenerar();
		} 
	}
	
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

}
