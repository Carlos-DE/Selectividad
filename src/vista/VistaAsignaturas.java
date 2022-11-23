package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Controlador;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;

public class VistaAsignaturas  extends JFrame implements ActionListener {
	
	private JButton bHome;
	private JButton bAlumnos;
	private JButton bSedes;
	private JButton bResponsables;
	private JButton bAsignaturas;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public VistaAsignaturas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSize(960, 540);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("PEVAU");
		
		JPanel maingrid = new JPanel();
		getContentPane().add(maingrid, BorderLayout.CENTER);
		GridBagLayout gbl_maingrid = new GridBagLayout();
		gbl_maingrid.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_maingrid.rowHeights = new int[]{40, 30, 30, 200, 15, 30, 45, 60, 15, 0};
		gbl_maingrid.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_maingrid.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		maingrid.setLayout(gbl_maingrid);
		
		
		
		Panel menu = new Panel();
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.fill = GridBagConstraints.BOTH;
		gbc_menu.gridwidth = 6;
		gbc_menu.insets = new Insets(0, 0, 5, 0);
		gbc_menu.gridx = 0;
		gbc_menu.gridy = 0;
		maingrid.add(menu, gbc_menu);
		menu.setFont(new Font("Dialog", Font.PLAIN, 14));
		menu.setBackground(new Color(0, 64, 128));
		
		bHome = new JButton("Home");
		bHome.addActionListener(this);
		menu.add(bHome);
		
		bAlumnos = new JButton("Alumnos");
		bAlumnos.addActionListener(this);
		menu.add(bAlumnos);
		
		bSedes = new JButton("Sedes");
		bSedes.addActionListener(this);
		menu.add(bSedes);
		
		bResponsables = new JButton("Responsables");
		bResponsables.addActionListener(this);
		menu.add(bResponsables);

		bAsignaturas = new JButton("Asignaturas");
		bAsignaturas.addActionListener(this);
		menu.add(bAsignaturas);
		
				
	
			
		
		
		JLabel lblNombreSede = new JLabel("Nombre Asignaturas");
		GridBagConstraints gbc_lblNombreSede = new GridBagConstraints();
		gbc_lblNombreSede.fill = GridBagConstraints.BOTH;
		gbc_lblNombreSede.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreSede.gridx = 3;
		gbc_lblNombreSede.gridy = 1;
		maingrid.add(lblNombreSede, gbc_lblNombreSede);
		
		
		
		
		
		JButton bCargarDatos = new JButton("CargarDatos");
		GridBagConstraints gbc_bCargarDatos = new GridBagConstraints();
		gbc_bCargarDatos.insets = new Insets(0, 0, 5, 5);
		gbc_bCargarDatos.gridx = 1;
		gbc_bCargarDatos.gridy = 2;
		maingrid.add(bCargarDatos, gbc_bCargarDatos);
		
		List listNombre = new List();
		GridBagConstraints gbc_listNombre = new GridBagConstraints();
		gbc_listNombre.fill = GridBagConstraints.BOTH;
		gbc_listNombre.gridheight = 2;
		gbc_listNombre.insets = new Insets(0, 0, 5, 5);
		gbc_listNombre.gridx = 3;
		gbc_listNombre.gridy = 2;
		maingrid.add(listNombre, gbc_listNombre);
		
		JButton bBorrarDatos = new JButton("BorrarDatos");
		GridBagConstraints gbc_bBorrarDatos = new GridBagConstraints();
		gbc_bBorrarDatos.anchor = GridBagConstraints.NORTH;
		gbc_bBorrarDatos.insets = new Insets(0, 0, 5, 5);
		gbc_bBorrarDatos.gridx = 1;
		gbc_bBorrarDatos.gridy = 3;
		maingrid.add(bBorrarDatos, gbc_bBorrarDatos);
		
		
		
		
		
		JPanel panelCRUD = new JPanel();
		GridBagConstraints gbc_panelCRUD = new GridBagConstraints();
		gbc_panelCRUD.anchor = GridBagConstraints.EAST;
		gbc_panelCRUD.gridwidth = 2;
		gbc_panelCRUD.insets = new Insets(0, 0, 5, 5);
		gbc_panelCRUD.gridx = 3;
		gbc_panelCRUD.gridy = 6;
		maingrid.add(panelCRUD, gbc_panelCRUD);
		
		
		
		
		
		JButton bDescargarLog = new JButton("DescargarLog");
		GridBagConstraints gbc_bDescargarLog = new GridBagConstraints();
		gbc_bDescargarLog.anchor = GridBagConstraints.NORTH;
		gbc_bDescargarLog.insets = new Insets(0, 0, 5, 5);
		gbc_bDescargarLog.gridx = 1;
		gbc_bDescargarLog.gridy = 7;
		maingrid.add(bDescargarLog, gbc_bDescargarLog);
		
		TextArea logText = new TextArea();
		GridBagConstraints gbc_logText = new GridBagConstraints();
		gbc_logText.anchor = GridBagConstraints.NORTH;
		gbc_logText.fill = GridBagConstraints.HORIZONTAL;
		gbc_logText.gridwidth = 2;
		gbc_logText.insets = new Insets(0, 0, 5, 5);
		gbc_logText.gridx = 3;
		gbc_logText.gridy = 7;
		maingrid.add(logText, gbc_logText);
		logText.setEditable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bSedes) {
			controlador.mostrarSedes();
		} else if (e.getSource()==bHome) {
			controlador.mostrarHome();
		} else if (e.getSource()==bAsignaturas){
			controlador.mostrarAsignaturas();
		}else if (e.getSource()==bAlumnos){
			controlador.mostrarAlumnos();
		}else if (e.getSource()==bResponsables){
			controlador.mostrarResponsables();
		}
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}
