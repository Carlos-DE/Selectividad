package vista;

import javax.swing.*;

import controlador.ConexionBaseDatosJDBC;
import controlador.ConexionConBaseDeDatos;
import controlador.Controlador;
import controlador.ControladorSede;
import modelo.Materia;
import modelo.Sede;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VistaSedes extends JFrame implements ActionListener{

	private JButton bHome;
	private JButton bSedes, bCargarDatos, bBorrarDatos;
	private JButton bAlumnos;
	private JButton bAsignaturas;
	private JButton bAulas;
	private JButton bResponsables;
	private JButton bInstitutos;
	private JButton bGenerar;
	private JTextField fieldDireccion;
	private Controlador controlador;
	private ControladorSede controladorSede = new ControladorSede();
	private ConexionConBaseDeDatos conexionBD = ConexionBaseDatosJDBC.getInstance();
	private JList<String> listaSedes;
    private DefaultListModel listModel;
    private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public VistaSedes() {
		
		java.util.List<Sede> lista = conexionBD.listaSedes();
		 listModel = new DefaultListModel();
		 for(Sede s : lista) {
	            listModel.addElement(s.getNombre());
	        }
		initialize();
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
		gbl_maingrid.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		
	
		
		
		
		JLabel lblNombreSede = new JLabel("Nombre Sede");
		GridBagConstraints gbc_lblNombreSede = new GridBagConstraints();
		gbc_lblNombreSede.fill = GridBagConstraints.BOTH;
		gbc_lblNombreSede.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreSede.gridx = 3;
		gbc_lblNombreSede.gridy = 1;
		maingrid.add(lblNombreSede, gbc_lblNombreSede);
		
		JLabel lblDireccion = new JLabel("Direccion");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.fill = GridBagConstraints.BOTH;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 4;
		gbc_lblDireccion.gridy = 1;
		maingrid.add(lblDireccion, gbc_lblDireccion);
		
		
		
		
		
		bCargarDatos = new JButton("CargarDatos");
		GridBagConstraints gbc_bCargarDatos = new GridBagConstraints();
		gbc_bCargarDatos.insets = new Insets(0, 0, 5, 5);
		gbc_bCargarDatos.gridx = 1;
		gbc_bCargarDatos.gridy = 2;
		bCargarDatos.addActionListener(this);
		maingrid.add(bCargarDatos, gbc_bCargarDatos);
		
		//List listNombre = new List();
		listaSedes = new JList<String>(listModel);
		GridBagConstraints gbc_listNombre = new GridBagConstraints();
		gbc_listNombre.fill = GridBagConstraints.BOTH;
		gbc_listNombre.gridheight = 2;
		gbc_listNombre.insets = new Insets(0, 0, 5, 5);
		gbc_listNombre.gridx = 3;
		gbc_listNombre.gridy = 2;
		maingrid.add(listaSedes, gbc_listNombre);
		
		List listDireccion = new List();
		GridBagConstraints gbc_listDireccion = new GridBagConstraints();
		gbc_listDireccion.fill = GridBagConstraints.BOTH;
		gbc_listDireccion.gridheight = 2;
		gbc_listDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_listDireccion.gridx = 4;
		gbc_listDireccion.gridy = 2;
		maingrid.add(listDireccion, gbc_listDireccion);
		
		bBorrarDatos = new JButton("BorrarDatos");
		GridBagConstraints gbc_bBorrarDatos = new GridBagConstraints();
		gbc_bBorrarDatos.anchor = GridBagConstraints.NORTH;
		gbc_bBorrarDatos.insets = new Insets(0, 0, 5, 5);
		gbc_bBorrarDatos.gridx = 1;
		gbc_bBorrarDatos.gridy = 3;
		bBorrarDatos.addActionListener(this);
		maingrid.add(bBorrarDatos, gbc_bBorrarDatos);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 3;
		gbc_table.gridy = 4;
		maingrid.add(table, gbc_table);
		
		
		
		
		
		JFormattedTextField fieldNombre = new JFormattedTextField();
		fieldNombre.setColumns(4);
		GridBagConstraints gbc_fieldNombre = new GridBagConstraints();
		gbc_fieldNombre.insets = new Insets(1, 1, 5, 5);
		gbc_fieldNombre.fill = GridBagConstraints.BOTH;
		gbc_fieldNombre.gridx = 3;
		gbc_fieldNombre.gridy = 5;
		
		maingrid.add(fieldNombre, gbc_fieldNombre);
		
		fieldDireccion = new JTextField();
		GridBagConstraints gbc_fieldDireccion = new GridBagConstraints();
		gbc_fieldDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_fieldDireccion.fill = GridBagConstraints.BOTH;
		gbc_fieldDireccion.gridx = 4;
		gbc_fieldDireccion.gridy = 5;
		maingrid.add(fieldDireccion, gbc_fieldDireccion);
		fieldDireccion.setColumns(10);
		
		
		
		
		
		JPanel panelCRUD = new JPanel();
		GridBagConstraints gbc_panelCRUD = new GridBagConstraints();
		gbc_panelCRUD.anchor = GridBagConstraints.EAST;
		gbc_panelCRUD.gridwidth = 2;
		gbc_panelCRUD.insets = new Insets(0, 0, 5, 5);
		gbc_panelCRUD.gridx = 3;
		gbc_panelCRUD.gridy = 6;
		maingrid.add(panelCRUD, gbc_panelCRUD);
		
		JButton bEditarSede = new JButton("EditarSede");
		panelCRUD.add(bEditarSede);
		
		JButton bCrearSede = new JButton("CrearSede");
		panelCRUD.add(bCrearSede);
		
		JButton bBorrarSede = new JButton("BorrarSede");
		panelCRUD.add(bBorrarSede);
		
		
		
		
		
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
		} else if(e.getSource()==bCargarDatos) {
			System.out.println("llego al boton");
			try {
				controladorSede.abrirArchivo();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			System.out.println("llego al boton");
		} else if (e.getSource()==bBorrarDatos) {
			controladorSede.borrarDatos();
		}
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

}
