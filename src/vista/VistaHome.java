package vista;

import javax.swing.*;

import controlador.Controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaHome extends JFrame implements ActionListener{

	private Controlador controlador;

	private JButton bSedes;
	private JButton bHome;
	private JButton bAsignaturas;
	
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
		
		
		
		
		Panel menu = new Panel();
		menu.setFont(new Font("Dialog", Font.PLAIN, 14));
		menu.setBackground(new Color(0, 64, 128));
		getContentPane().add(menu, BorderLayout.NORTH);
		
		bHome = new JButton("Home");
		bHome.addActionListener(this);
		menu.add(bHome);
		
		bSedes = new JButton("Sedes");
		bSedes.addActionListener(this);
		menu.add(bSedes);
		
		bAsignaturas = new JButton("Asignaturas");
		bAsignaturas.addActionListener(this);
		menu.add(bAsignaturas);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bSedes) {
			controlador.mostrarSedes();
		} else if (e.getSource()==bHome) {
			controlador.mostrarHome();
		} else if (e.getSource()==bAsignaturas) {
			controlador.mostrarAsignaturas();
		}
	}
	
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

}
