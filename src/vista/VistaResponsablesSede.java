package vista;


import javax.swing.*;

import controlador.ConexionBaseDatosJDBC;
import controlador.ConexionConBaseDeDatos;
import controlador.Controlador;
import controlador.ControladorResponsables;
import controlador.ControladorSede;
import modelo.Responsable;
import modelo.Sede;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.border.TitledBorder;

public class VistaResponsablesSede extends JFrame implements ActionListener{
	private JButton bCargarDatos, bBorrarDatos;
	private JButton bAulas;
	private JButton bInstitutos;
	private JButton bGenerar;
	private JPanel panel;
	private Panel menu;
	private JButton bAlumnos;
	private JButton bResponsablesExamen;
	private JPanel panel_1;
	private Panel menu_2;
	private JButton bHome;
	private JButton bVicerrector;
	private JButton bGestorSede;
	private JPanel panel_2;
	private Panel menu_1;
	//private JButton bAlumnos;
	private JButton bAsignaturas;
	private JButton bExamenes;
	//private JButton bInstitutos;
	private JButton bResponsablesSedes;
	private JButton bSedes;
	private Controlador controlador;
	private ControladorResponsables controladorResponsables = new ControladorResponsables();
	private ConexionConBaseDeDatos conexionBD = ConexionBaseDatosJDBC.getInstance();
	private JList<String> listaResponsables;
    private DefaultListModel listModel;


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public VistaResponsablesSede() {
		java.util.List<Responsable> lista = conexionBD.listaResponsable();
		 listModel = new DefaultListModel();
		 for(Responsable r : lista) {
	            listModel.addElement(r.getNombre());
	        }
		
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
		getContentPane().add(maingrid, BorderLayout.NORTH);
		GridBagLayout gbl_maingrid = new GridBagLayout();
		gbl_maingrid.columnWidths = new int[]{0, 0, 164, -21, 0, 0, 0};
		gbl_maingrid.rowHeights = new int[]{40, 0, 0, 30, 30, 110, 40, 120, 113, 0, 81, 15, 0};
		gbl_maingrid.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_maingrid.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		maingrid.setLayout(gbl_maingrid);
		
		Panel menu = new Panel();
		menu.setFont(new Font("Dialog", Font.PLAIN, 14));
		menu.setBackground(new Color(0, 64, 128));
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.fill = GridBagConstraints.BOTH;
		gbc_menu.gridwidth = 6;
		gbc_menu.insets = new Insets(0, 0, 5, 0);
		gbc_menu.gridx = 0;
		gbc_menu.gridy = 0;
		maingrid.add(menu, gbc_menu);
		
		bHome = new JButton("Home");
		bHome.addActionListener(this);
		menu.add(bHome);
		
		 bVicerrector = new JButton("VICERRECTOR");
		menu.add(bVicerrector);
		bVicerrector.addActionListener(this);
		
		 bGestorSede = new JButton("GESTOR SEDE");
		menu.add(bGestorSede);
		bGestorSede.addActionListener(this);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "VICERRECTOR", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 6;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		maingrid.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		Panel menu_1 = new Panel();
		menu_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		menu_1.setBackground(new Color(0, 64, 128));
		GridBagConstraints gbc_menu_1 = new GridBagConstraints();
		gbc_menu_1.insets = new Insets(0, 0, 0, 5);
		gbc_menu_1.fill = GridBagConstraints.BOTH;
		gbc_menu_1.gridwidth = 4;
		gbc_menu_1.gridx = 0;
		gbc_menu_1.gridy = 0;
		panel_2.add(menu_1, gbc_menu_1);
		
		 bAlumnos = new JButton("Alumnos");
		menu_1.add(bAlumnos);
		bAlumnos.addActionListener(this);
		
		 bAsignaturas = new JButton("Asignaturas");
		menu_1.add(bAsignaturas);
		bAsignaturas.addActionListener(this);
		
		 bExamenes = new JButton("Examenes");
		menu_1.add(bExamenes);
		bExamenes.addActionListener(this);
		
		 bInstitutos = new JButton("Institutos");
		menu_1.add(bInstitutos);
		bInstitutos.addActionListener(this);
		
		 bResponsablesSedes = new JButton("Responsables Sedes");
		menu_1.add(bResponsablesSedes);
		bResponsablesSedes.addActionListener(this);
		
		 bSedes = new JButton("Sedes");
		menu_1.add(bSedes);
		bSedes.addActionListener(this);
		
		
		
		JLabel lblResponsables = new JLabel("Responsables por asignar");
		lblResponsables.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblResponsables = new GridBagConstraints();
		gbc_lblResponsables.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsables.gridx = 1;
		gbc_lblResponsables.gridy = 3;
		maingrid.add(lblResponsables, gbc_lblResponsables);
		
		//List listNombre = new List();
		listaResponsables = new JList<String>(listModel);
		GridBagConstraints gbc_listNombre = new GridBagConstraints();
		gbc_listNombre.fill = GridBagConstraints.BOTH;
		gbc_listNombre.gridheight = 4;
		gbc_listNombre.insets = new Insets(0, 0, 5, 5);
		gbc_listNombre.gridx = 1;
		gbc_listNombre.gridy = 4;
		maingrid.add(listaResponsables, gbc_listNombre);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sede1", "Sede2", "Sede3"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 4;
		maingrid.add(comboBox, gbc_comboBox);
		
		JList listAulas = new JList();
		listAulas.setModel(new AbstractListModel() {
			String[] values = new String[] {"Maria Ramirez,Sede1", "Isabel Canales,Sede2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listAulas.setToolTipText("Pedro Ramirez,Vocal,Aula1\r\nGuillermo Canales,Vigilante,Aula2");
		GridBagConstraints gbc_listAulas = new GridBagConstraints();
		gbc_listAulas.gridheight = 4;
		gbc_listAulas.insets = new Insets(0, 0, 5, 5);
		gbc_listAulas.fill = GridBagConstraints.BOTH;
		gbc_listAulas.gridx = 4;
		gbc_listAulas.gridy = 4;
		maingrid.add(listAulas, gbc_listAulas);
		
		JButton bAnadir = new JButton("Anadir");
		GridBagConstraints gbc_bAnadir = new GridBagConstraints();
		gbc_bAnadir.gridwidth = 2;
		gbc_bAnadir.insets = new Insets(0, 0, 5, 5);
		gbc_bAnadir.gridx = 2;
		gbc_bAnadir.gridy = 6;
		maingrid.add(bAnadir, gbc_bAnadir);
		
		JButton bQuitar = new JButton("Quitar");
		GridBagConstraints gbc_bQuitar = new GridBagConstraints();
		gbc_bQuitar.gridwidth = 2;
		gbc_bQuitar.insets = new Insets(0, 0, 5, 5);
		gbc_bQuitar.gridx = 2;
		gbc_bQuitar.gridy = 7;
		maingrid.add(bQuitar, gbc_bQuitar);
		
		
		
		
		
		bCargarDatos = new JButton("CargarDatos");
		GridBagConstraints gbc_bCargarDatos = new GridBagConstraints();
		gbc_bCargarDatos.insets = new Insets(0, 0, 5, 5);
		gbc_bCargarDatos.gridx = 1;
		gbc_bCargarDatos.gridy = 8;
		bCargarDatos.addActionListener(this);
		maingrid.add(bCargarDatos, gbc_bCargarDatos);
		
		bBorrarDatos = new JButton("BorrarDatos");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 9;
		bBorrarDatos.addActionListener(this);

		maingrid.add(bBorrarDatos, gbc_btnNewButton);
		
		
		
		
		
		JButton bDescargarLog = new JButton("DescargarLog");
		GridBagConstraints gbc_bDescargarLog = new GridBagConstraints();
		gbc_bDescargarLog.anchor = GridBagConstraints.SOUTHEAST;
		gbc_bDescargarLog.insets = new Insets(0, 0, 5, 5);
		gbc_bDescargarLog.gridx = 1;
		gbc_bDescargarLog.gridy = 10;
		maingrid.add(bDescargarLog, gbc_bDescargarLog);
		
		TextArea logText = new TextArea();
		logText.setText("Log indicando fallos");
		GridBagConstraints gbc_logText = new GridBagConstraints();
		gbc_logText.anchor = GridBagConstraints.NORTH;
		gbc_logText.fill = GridBagConstraints.HORIZONTAL;
		gbc_logText.gridwidth = 2;
		gbc_logText.insets = new Insets(0, 0, 5, 5);
		gbc_logText.gridx = 3;
		gbc_logText.gridy = 10;
		maingrid.add(logText, gbc_logText);
		logText.setEditable(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bHome){
			controlador.mostrarHome();
		}else if(e.getSource()==bVicerrector){
			controlador.mostrarAlumnos();
		}else if(e.getSource()==bGestorSede){
			//controlador.mostrarAulas();
		}else if (e.getSource()==bAlumnos){
			controlador.mostrarAlumnos();
		}else if (e.getSource()==bAsignaturas){
			controlador.mostrarAsignaturas();
		}else if (e.getSource()==bExamenes){
			//controlador.mostrarExamenes();
		}else if (e.getSource()==bInstitutos){
			controlador.mostrarInstitutos();
		}else if (e.getSource()==bResponsablesSedes){
			controlador.mostrarResponsables();
		}else if(e.getSource()==bSedes){
			controlador.mostrarSedes();
		}else if(e.getSource()==bCargarDatos) {
			System.out.println("llego al boton");
			try {
				controladorResponsables.abrirArchivo();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}
