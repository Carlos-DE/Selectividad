package vista;


import javax.swing.*;

import controlador.Controlador;
import controlador.ControladorResponsables;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VistaResponsables extends JFrame implements ActionListener{
	private JButton bHome;
	private JButton bSedes;
	private JButton bAlumnos,bCargarDatos, bBorrarDatos;
	private JButton bAsignaturas;
	private JButton bResponsables;
	private Controlador controlador;
	private ControladorResponsables controladorResponsables;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public VistaResponsables() {
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
		gbl_maingrid.rowHeights = new int[]{40, 30, 30, 110, 15, 120, 113, 81, 15, 0};
		gbl_maingrid.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_maingrid.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
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
		
		bAsignaturas = new JButton("Asignaturas");
		bAsignaturas.addActionListener(this);
		menu.add(bAsignaturas);
		
		bResponsables = new JButton("Responsables");
		bResponsables.addActionListener(this);
		menu.add(bResponsables);
		
		
		
		JLabel lblResponsables = new JLabel("Responsables por cargar");
		lblResponsables.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblResponsables = new GridBagConstraints();
		gbc_lblResponsables.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsables.gridx = 1;
		gbc_lblResponsables.gridy = 1;
		maingrid.add(lblResponsables, gbc_lblResponsables);
		
		JComboBox cbSedes = new JComboBox();
		GridBagConstraints gbc_cbSedes = new GridBagConstraints();
		gbc_cbSedes.insets = new Insets(0, 0, 5, 5);
		gbc_cbSedes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSedes.gridx = 4;
		gbc_cbSedes.gridy = 1;
		maingrid.add(cbSedes, gbc_cbSedes);
		
		List listNombre = new List();
		GridBagConstraints gbc_listNombre = new GridBagConstraints();
		gbc_listNombre.fill = GridBagConstraints.BOTH;
		gbc_listNombre.gridheight = 4;
		gbc_listNombre.insets = new Insets(0, 0, 5, 5);
		gbc_listNombre.gridx = 1;
		gbc_listNombre.gridy = 2;
		maingrid.add(listNombre, gbc_listNombre);
		
		JComboBox cbCargos = new JComboBox();
		cbCargos.setModel(new DefaultComboBoxModel(new String[] {"Vocal", "Vigilante"}));
		GridBagConstraints gbc_cbCargos = new GridBagConstraints();
		gbc_cbCargos.gridwidth = 2;
		gbc_cbCargos.insets = new Insets(0, 0, 5, 5);
		gbc_cbCargos.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCargos.gridx = 2;
		gbc_cbCargos.gridy = 3;
		maingrid.add(cbCargos, gbc_cbCargos);
		
		JList listAulas = new JList();
		GridBagConstraints gbc_listAulas = new GridBagConstraints();
		gbc_listAulas.gridheight = 2;
		gbc_listAulas.insets = new Insets(0, 0, 5, 5);
		gbc_listAulas.fill = GridBagConstraints.BOTH;
		gbc_listAulas.gridx = 4;
		gbc_listAulas.gridy = 2;
		maingrid.add(listAulas, gbc_listAulas);
		
		JButton bAnadir = new JButton("Anadir");
		GridBagConstraints gbc_bAnadir = new GridBagConstraints();
		gbc_bAnadir.gridwidth = 2;
		gbc_bAnadir.insets = new Insets(0, 0, 5, 5);
		gbc_bAnadir.gridx = 2;
		gbc_bAnadir.gridy = 4;
		maingrid.add(bAnadir, gbc_bAnadir);
		
		JList listResponsableYCargos = new JList();
		GridBagConstraints gbc_listResponsableYCargos = new GridBagConstraints();
		gbc_listResponsableYCargos.gridheight = 2;
		gbc_listResponsableYCargos.insets = new Insets(0, 0, 5, 5);
		gbc_listResponsableYCargos.fill = GridBagConstraints.BOTH;
		gbc_listResponsableYCargos.gridx = 4;
		gbc_listResponsableYCargos.gridy = 4;
		maingrid.add(listResponsableYCargos, gbc_listResponsableYCargos);
		
		JButton bQuitar = new JButton("Quitar");
		GridBagConstraints gbc_bQuitar = new GridBagConstraints();
		gbc_bQuitar.gridwidth = 2;
		gbc_bQuitar.insets = new Insets(0, 0, 5, 5);
		gbc_bQuitar.gridx = 2;
		gbc_bQuitar.gridy = 5;
		maingrid.add(bQuitar, gbc_bQuitar);
		
		
		
		
		
		bCargarDatos = new JButton("CargarDatos");
		GridBagConstraints gbc_bCargarDatos = new GridBagConstraints();
		gbc_bCargarDatos.insets = new Insets(0, 0, 5, 5);
		gbc_bCargarDatos.gridx = 1;
		gbc_bCargarDatos.gridy = 6;
		maingrid.add(bCargarDatos, gbc_bCargarDatos);
		
		
		
		
		
		JButton bDescargarLog = new JButton("DescargarLog");
		GridBagConstraints gbc_bDescargarLog = new GridBagConstraints();
		gbc_bDescargarLog.anchor = GridBagConstraints.SOUTHEAST;
		gbc_bDescargarLog.insets = new Insets(0, 0, 5, 5);
		gbc_bDescargarLog.gridx = 1;
		gbc_bDescargarLog.gridy = 7;
		maingrid.add(bDescargarLog, gbc_bDescargarLog);
		
		TextArea logText = new TextArea();
		logText.setText("Log indicando fallos");
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
		}else if (e.getSource()==bAlumnos){
			controlador.mostrarAlumnos();
		}else if (e.getSource()==bAsignaturas){
			controlador.mostrarAsignaturas();
		}else if(e.getSource()==bResponsables){
			controlador.mostrarResponsables();
		} else if(e.getSource()==bCargarDatos) {
			System.out.println("llego al boton");
			try {
				controladorResponsables.abrirArchivo();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			System.out.println("llego al boton");
		}
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}
