package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import controlador.Controlador;

import javax.swing.JButton;
import java.awt.BorderLayout;

public class VistaAsignaturas  extends JFrame implements ActionListener {
	
	private Controlador controlador;
	JButton bHome;
	public VistaAsignaturas() {
		initialize();
	}
	
	private void initialize() {
		setSize(960, 540);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("PEVAU");
		
		bHome = new JButton("Home");
		bHome.addActionListener(this);
		getContentPane().add(bHome, BorderLayout.CENTER);
		
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==bHome) {
			controlador.mostrarHome();
		}
	}
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}
