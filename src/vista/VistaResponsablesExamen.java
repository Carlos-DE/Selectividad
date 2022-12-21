package vista;


import javax.swing.*;

import controlador.ConexionBaseDatosJDBC;
import controlador.ConexionConBaseDeDatos;
import controlador.Controlador;
import controlador.ControladorResponsables;
import controlador.ControladorResponsablesExamen;
import controlador.ControladorSede;
import modelo.Alumno;
import modelo.Responsable;
import modelo.ResponsableExamen;
import modelo.Sede;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.border.TitledBorder;

public class VistaResponsablesExamen extends JFrame implements ActionListener{
	private JButton bCargarDatos, bBorrarDatos;
	private JButton bAlumnos;
	private Controlador controlador;
	private ControladorResponsablesExamen controladorResponsablesExamen = new ControladorResponsablesExamen();
	private ConexionConBaseDeDatos conexionBD = ConexionBaseDatosJDBC.getInstance();
	private JList<String> listaResponsables;
    private DefaultListModel listModel = new DefaultListModel();
	//private Controlador controlador;
	private JButton bAulas;
	private JButton bInstitutos;
	private JButton bGenerar;
	private JPanel panel;
	private Panel menu;
	//private JButton bAlumnos;
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
	java.util.List<ResponsableExamen> lista;


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public VistaResponsablesExamen() {
		
		lista = conexionBD.listaResponsablesExamen();
		 listModel = new DefaultListModel();
		 for(ResponsableExamen r : lista) {
	            listModel.addElement(r.getNombre());
	        }
		
		initialize();
	}

	private void refresh() {
		lista = conexionBD.listaResponsablesExamen();
		//listModel = new DefaultListModel();
		for(ResponsableExamen r : lista) {
				
			if(!listModel.contains(r.getNombre())) {
				listModel.addElement(r.getNombre());
			}
				
			
	    }
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
		gbl_maingrid.rowHeights = new int[]{40, 0, 30, 30, 110, 40, 120, 113, 0, 81, 15, 0};
		gbl_maingrid.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_maingrid.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		menu.add(bHome);
		bHome.addActionListener(this) ;
		
		bVicerrector = new JButton("VICERRECTOR");
		bVicerrector.addActionListener(this) ;
		menu.add(bVicerrector);
		
		bGestorSede = new JButton("GESTOR SEDE");
		menu.add(bGestorSede);
		bGestorSede.addActionListener(this) ;
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "GESTOR SEDE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		bAulas = new JButton("Aulas");
		menu_1.add(bAulas);
		bAulas.addActionListener(this);
		
		bResponsablesExamen = new JButton("Responsables Examen");
		menu_1.add(bResponsablesExamen);
		bResponsablesExamen.addActionListener(this);
		
		
		
		JLabel lblResponsables = new JLabel("Responsables por asignar");
		lblResponsables.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblResponsables = new GridBagConstraints();
		gbc_lblResponsables.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsables.gridx = 1;
		gbc_lblResponsables.gridy = 2;
		maingrid.add(lblResponsables, gbc_lblResponsables);
		
		JLabel lblNewLabel = new JLabel("Aulario Severo Ochoa");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		maingrid.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox cbSedes = new JComboBox();
		cbSedes.setModel(new DefaultComboBoxModel());
		GridBagConstraints gbc_cbSedes = new GridBagConstraints();
		gbc_cbSedes.insets = new Insets(0, 0, 5, 5);
		gbc_cbSedes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSedes.gridx = 4;
		gbc_cbSedes.gridy = 2;
		maingrid.add(cbSedes, gbc_cbSedes);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		maingrid.add(scrollPane, gbc_scrollPane);
		
		//List listNombre = new List();
		listaResponsables = new JList<String>(listModel);
		scrollPane.setViewportView(listaResponsables);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
		maingrid.add(comboBox, gbc_comboBox);
		
		JComboBox cbCargos = new JComboBox();
		cbCargos.setModel(new DefaultComboBoxModel(new String[] {"Vocal", "Vigilante"}));
		GridBagConstraints gbc_cbCargos = new GridBagConstraints();
		gbc_cbCargos.gridwidth = 2;
		gbc_cbCargos.insets = new Insets(0, 0, 5, 5);
		gbc_cbCargos.gridx = 2;
		gbc_cbCargos.gridy = 4;
		maingrid.add(cbCargos, gbc_cbCargos);
		
		JList listAulas = new JList();
		listAulas.setModel(new AbstractListModel() {
			String[] values = new String[] {};
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
		gbc_listAulas.gridy = 3;
		maingrid.add(listAulas, gbc_listAulas);
		
		JButton bAnadir = new JButton("Anadir");
		GridBagConstraints gbc_bAnadir = new GridBagConstraints();
		gbc_bAnadir.gridwidth = 2;
		gbc_bAnadir.insets = new Insets(0, 0, 5, 5);
		gbc_bAnadir.gridx = 2;
		gbc_bAnadir.gridy = 5;
		maingrid.add(bAnadir, gbc_bAnadir);
		
		JButton bQuitar = new JButton("Quitar");
		GridBagConstraints gbc_bQuitar = new GridBagConstraints();
		gbc_bQuitar.gridwidth = 2;
		gbc_bQuitar.insets = new Insets(0, 0, 5, 5);
		gbc_bQuitar.gridx = 2;
		gbc_bQuitar.gridy = 6;
		maingrid.add(bQuitar, gbc_bQuitar);
		
		
		
		
		
		bCargarDatos = new JButton("CargarDatos");
		GridBagConstraints gbc_bCargarDatos = new GridBagConstraints();
		gbc_bCargarDatos.insets = new Insets(0, 0, 5, 5);
		gbc_bCargarDatos.gridx = 1;
		gbc_bCargarDatos.gridy = 7;
		bCargarDatos.addActionListener(this);
		maingrid.add(bCargarDatos, gbc_bCargarDatos);
		
		bBorrarDatos = new JButton("BorrarDatos");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 8;
		bBorrarDatos.addActionListener(this);

		maingrid.add(bBorrarDatos, gbc_btnNewButton);
		
		
		
		
		
		JButton bDescargarLog = new JButton("DescargarLog");
		GridBagConstraints gbc_bDescargarLog = new GridBagConstraints();
		gbc_bDescargarLog.anchor = GridBagConstraints.SOUTHEAST;
		gbc_bDescargarLog.insets = new Insets(0, 0, 5, 5);
		gbc_bDescargarLog.gridx = 1;
		gbc_bDescargarLog.gridy = 9;
		maingrid.add(bDescargarLog, gbc_bDescargarLog);
		
		TextArea logText = new TextArea();
		logText.setText("Log indicando fallos");
		GridBagConstraints gbc_logText = new GridBagConstraints();
		gbc_logText.anchor = GridBagConstraints.NORTH;
		gbc_logText.fill = GridBagConstraints.HORIZONTAL;
		gbc_logText.gridwidth = 2;
		gbc_logText.insets = new Insets(0, 0, 5, 5);
		gbc_logText.gridx = 3;
		gbc_logText.gridy = 9;
		maingrid.add(logText, gbc_logText);
		logText.setEditable(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bHome) {
			controlador.mostrarHome();
        } else if (e.getSource()==bVicerrector) {
            controlador.mostrarAlumnos();
        } else if (e.getSource()==bGestorSede) {
            controlador.mostrarAulas();
		} else if (e.getSource()==bAulas) {
			controlador.mostrarAulas();
		}else if (e.getSource()==bResponsablesExamen) {
			controlador.mostrarResponsablesExamenes();
		}else if(e.getSource()==bCargarDatos) {
			
			System.out.println("llego al boton");
			try {
				controladorResponsablesExamen.abrirArchivo();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			refresh();
		}else if(e.getSource()==bBorrarDatos) {
			controladorResponsablesExamen.borrarDatos();
			listModel.clear();
		}
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}

