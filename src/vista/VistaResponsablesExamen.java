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

public class VistaResponsablesExamen extends JFrame implements ActionListener{
	private JButton bHome;
	private JButton bSedes,bCargarDatos, bBorrarDatos;
	private JButton bAlumnos;
	private JButton bAsignaturas;
	private JButton bResponsables;
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
	public VistaResponsablesExamen() {
		java.util.List<Responsable> lista = conexionBD.listaResponsablesExamen();
		 listModel = new DefaultListModel();
		 for(Responsable r : lista) {
	            listModel.addElement(r.getNombre());
	        }
		
		initialize();
	}

	
	private void initialize() {
		setSize(960, 540);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("PEVAU");
		
		JPanel maingrid = new JPanel();
		getContentPane().add(maingrid, BorderLayout.CENTER);
		GridBagLayout gbl_maingrid = new GridBagLayout();
		gbl_maingrid.columnWidths = new int[]{0, 0, 164, -21, 0, 0, 0};
		gbl_maingrid.rowHeights = new int[]{40, 30, 30, 110, 40, 120, 113, 0, 81, 15, 0};
		gbl_maingrid.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_maingrid.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		
		bResponsables = new JButton("Responsables Sede");
		bResponsables.addActionListener(this);
		menu.add(bResponsables);
		
		JButton btnNewButton = new JButton("Responsables Examen");
		menu.add(btnNewButton);
		
		
		
		JLabel lblResponsables = new JLabel("Responsables por asignar");
		lblResponsables.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblResponsables = new GridBagConstraints();
		gbc_lblResponsables.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsables.gridx = 1;
		gbc_lblResponsables.gridy = 1;
		maingrid.add(lblResponsables, gbc_lblResponsables);
		
		JLabel lblNewLabel = new JLabel("Sede X");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		maingrid.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox cbSedes = new JComboBox();
		cbSedes.setModel(new DefaultComboBoxModel(new String[] {"Matematicas", "Lengua", "Latin"}));
		GridBagConstraints gbc_cbSedes = new GridBagConstraints();
		gbc_cbSedes.insets = new Insets(0, 0, 5, 5);
		gbc_cbSedes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSedes.gridx = 4;
		gbc_cbSedes.gridy = 1;
		maingrid.add(cbSedes, gbc_cbSedes);
		
		//List listNombre = new List();
		listaResponsables = new JList<String>(listModel);
		GridBagConstraints gbc_listNombre = new GridBagConstraints();
		gbc_listNombre.fill = GridBagConstraints.BOTH;
		gbc_listNombre.gridheight = 4;
		gbc_listNombre.insets = new Insets(0, 0, 5, 5);
		gbc_listNombre.gridx = 1;
		gbc_listNombre.gridy = 2;
		maingrid.add(listaResponsables, gbc_listNombre);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aula X1", "Aula X2"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		maingrid.add(comboBox, gbc_comboBox);
		
		JComboBox cbCargos = new JComboBox();
		cbCargos.setModel(new DefaultComboBoxModel(new String[] {"Vocal", "Vigilante"}));
		GridBagConstraints gbc_cbCargos = new GridBagConstraints();
		gbc_cbCargos.gridwidth = 2;
		gbc_cbCargos.insets = new Insets(0, 0, 5, 5);
		gbc_cbCargos.gridx = 2;
		gbc_cbCargos.gridy = 3;
		maingrid.add(cbCargos, gbc_cbCargos);
		
		JList listAulas = new JList();
		listAulas.setModel(new AbstractListModel() {
			String[] values = new String[] {"Pedro Ramirez,Vocal,Aula1", "Guillermo Canales,Vigilante,Aula2"};
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
		gbc_listAulas.gridy = 2;
		maingrid.add(listAulas, gbc_listAulas);
		
		JButton bAnadir = new JButton("Anadir");
		GridBagConstraints gbc_bAnadir = new GridBagConstraints();
		gbc_bAnadir.gridwidth = 2;
		gbc_bAnadir.insets = new Insets(0, 0, 5, 5);
		gbc_bAnadir.gridx = 2;
		gbc_bAnadir.gridy = 4;
		maingrid.add(bAnadir, gbc_bAnadir);
		
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
		bCargarDatos.addActionListener(this);
		maingrid.add(bCargarDatos, gbc_bCargarDatos);
		
		bBorrarDatos = new JButton("BorrarDatos");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 7;
		bBorrarDatos.addActionListener(this);

		maingrid.add(bBorrarDatos, gbc_btnNewButton);
		
		
		
		
		
		JButton bDescargarLog = new JButton("DescargarLog");
		GridBagConstraints gbc_bDescargarLog = new GridBagConstraints();
		gbc_bDescargarLog.anchor = GridBagConstraints.SOUTHEAST;
		gbc_bDescargarLog.insets = new Insets(0, 0, 5, 5);
		gbc_bDescargarLog.gridx = 1;
		gbc_bDescargarLog.gridy = 8;
		maingrid.add(bDescargarLog, gbc_bDescargarLog);
		
		TextArea logText = new TextArea();
		logText.setText("Log indicando fallos");
		GridBagConstraints gbc_logText = new GridBagConstraints();
		gbc_logText.anchor = GridBagConstraints.NORTH;
		gbc_logText.fill = GridBagConstraints.HORIZONTAL;
		gbc_logText.gridwidth = 2;
		gbc_logText.insets = new Insets(0, 0, 5, 5);
		gbc_logText.gridx = 3;
		gbc_logText.gridy = 8;
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
		}else if(e.getSource()==bCargarDatos) {
			System.out.println("llego al boton");
			try {
				controladorResponsables.abrirArchivo();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			System.out.println("llego al boton");
		} else if (e.getSource()==bBorrarDatos) {
			controladorResponsables.borrarDatos();
		}
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}

