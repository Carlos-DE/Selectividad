package vista;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controlador.ConexionBaseDatosJDBC;
import controlador.ConexionConBaseDeDatos;
import controlador.Controlador;
import controlador.ControladorAlumnos;
import modelo.Alumno;

import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JList;

public class VistaExamen extends JFrame implements ActionListener {
	
	
	private JButton bHome;
	private Controlador controlador;
	private ControladorAlumnos controladorAlumnos = new ControladorAlumnos();
	private JButton bVicerrector;
	private JButton bGestorSede;
	private JPanel panel_1;
	private DefaultListModel listModel;

	private ConexionConBaseDeDatos conexionBD = ConexionBaseDatosJDBC.getInstance();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */

	java.util.List<Alumno> lista;
	private JPanel panel;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JList list;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JList list_1;
	private JList list_2;
	private JPanel panel_1_1;
	private Panel menu_1;
	private JButton bAulas;
	private JButton bExamenes;
	private JButton bResponsablesExamen;
	public VistaExamen() {
		refresh();
		initialize();
	}

	private void refresh() {
		lista = conexionBD.listaAlumnos();
		listModel = new DefaultListModel();
		for(Alumno a : lista) {
	        listModel.addElement(a.getDni() + " " + a.getNombre() +" "+ a.getApellido1() +" "+ a.getApellido2());
	    }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		////////////////HEADER////////////////////////////////////////
		
		setSize(960, 540);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("PEVAU");
		
		JPanel maingrid = new JPanel();
		getContentPane().add(maingrid, BorderLayout.CENTER);
		GridBagLayout gbl_maingrid = new GridBagLayout();
		gbl_maingrid.columnWidths = new int[]{0, 0, 0, 0};
		gbl_maingrid.rowHeights = new int[]{40, 30, 0, 30, 0, 45, 60, 0};
		gbl_maingrid.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0};
		gbl_maingrid.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		maingrid.setLayout(gbl_maingrid);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		maingrid.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{40, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		
		
		Panel menu = new Panel();
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.fill = GridBagConstraints.BOTH;
		gbc_menu.insets = new Insets(0, 0, 5, 0);
		gbc_menu.gridx = 0;
		gbc_menu.gridy = 0;
		panel_1.add(menu, gbc_menu);
		FlowLayout flowLayout_1 = (FlowLayout) menu.getLayout();
		menu.setFont(new Font("Dialog", Font.PLAIN, 14));
		menu.setBackground(new Color(0, 64, 128));
		
		bHome = new JButton("Home");
		bHome.addActionListener(this);
		menu.add(bHome);
		
		bVicerrector = new JButton("VICERRECTOR");
		menu.add(bVicerrector);
		bVicerrector.addActionListener(this);
		
		bGestorSede = new JButton("GESTOR SEDE");
		menu.add(bGestorSede);
		
		panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(null, "GESTOR SEDE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1_1 = new GridBagConstraints();
		gbc_panel_1_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1_1.gridx = 0;
		gbc_panel_1_1.gridy = 1;
		panel_1.add(panel_1_1, gbc_panel_1_1);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1_1.rowHeights = new int[]{0, 0};
		gbl_panel_1_1.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1_1.setLayout(gbl_panel_1_1);
		
		menu_1 = new Panel();
		menu_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		menu_1.setBackground(new Color(0, 64, 128));
		GridBagConstraints gbc_menu_1 = new GridBagConstraints();
		gbc_menu_1.insets = new Insets(0, 0, 0, 5);
		gbc_menu_1.fill = GridBagConstraints.BOTH;
		gbc_menu_1.gridwidth = 4;
		gbc_menu_1.gridx = 0;
		gbc_menu_1.gridy = 0;
		panel_1_1.add(menu_1, gbc_menu_1);
		
		bAulas = new JButton("Aulas");
		menu_1.add(bAulas);
		bAulas.addActionListener(this);
		
		 bExamenes = new JButton("Examenes");
		menu_1.add(bExamenes);
		bExamenes.addActionListener(this);
		
		bResponsablesExamen = new JButton("Responsables Examen");
		menu_1.add(bResponsablesExamen);
		bResponsablesExamen.addActionListener(this);
		
		GridBagConstraints gbc_scrollpane = new GridBagConstraints();
		gbc_scrollpane.fill=GridBagConstraints.HORIZONTAL;
		gbc_scrollpane.fill = GridBagConstraints.VERTICAL;
		gbc_scrollpane.gridheight = 2;
		gbc_scrollpane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollpane.gridx = 1;
		gbc_scrollpane.gridy = 2;
		
		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		maingrid.add(panel_3, gbc_panel_3);
		
		lblNewLabel = new JLabel("NombreSede");
		panel_3.add(lblNewLabel);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		maingrid.add(panel, gbc_panel);
		
		list = new JList();
		panel.add(list);
		
		panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridheight = 2;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 3;
		maingrid.add(panel_4, gbc_panel_4);
		
		list_1 = new JList();
		panel_4.add(list_1);
		
		btnNewButton = new JButton("Asignar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 3;
		maingrid.add(btnNewButton, gbc_btnNewButton);
		
		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridheight = 2;
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 3;
		gbc_panel_5.gridy = 3;
		maingrid.add(panel_5, gbc_panel_5);
		
		list_2 = new JList();
		panel_5.add(list_2);
		
		btnNewButton_1 = new JButton("Quitar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 4;
		maingrid.add(btnNewButton_1, gbc_btnNewButton_1);
		
		
		
		
		
		JPanel panelCRUD = new JPanel();
		GridBagConstraints gbc_panelCRUD = new GridBagConstraints();
		gbc_panelCRUD.anchor = GridBagConstraints.EAST;
		gbc_panelCRUD.gridwidth = 3;
		gbc_panelCRUD.insets = new Insets(0, 0, 5, 0);
		gbc_panelCRUD.gridx = 1;
		gbc_panelCRUD.gridy = 5;
		maingrid.add(panelCRUD, gbc_panelCRUD);
		
		
		
		
		
		JButton bDescargarLog = new JButton("DescargarLog");
		GridBagConstraints gbc_bDescargarLog = new GridBagConstraints();
		gbc_bDescargarLog.anchor = GridBagConstraints.NORTH;
		gbc_bDescargarLog.insets = new Insets(0, 0, 0, 5);
		gbc_bDescargarLog.gridx = 0;
		gbc_bDescargarLog.gridy = 6;
		maingrid.add(bDescargarLog, gbc_bDescargarLog);
		
		TextArea logText = new TextArea();
		GridBagConstraints gbc_logText = new GridBagConstraints();
		gbc_logText.anchor = GridBagConstraints.NORTH;
		gbc_logText.fill = GridBagConstraints.HORIZONTAL;
		gbc_logText.gridwidth = 3;
		gbc_logText.gridx = 1;
		gbc_logText.gridy = 6;
		maingrid.add(logText, gbc_logText);
		logText.setEditable(false);
		
		
		////////////////////////////////////////////////////////

		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bHome) {
			controlador.mostrarHome();
		}else if(e.getSource()==bVicerrector){
				controlador.mostrarAlumnos();
		}else if(e.getSource()==bGestorSede){
				controlador.mostrarAulas();
		} else if (e.getSource()==bAulas) {
			controlador.mostrarAulas();
		} else if (e.getSource()==bResponsablesExamen ) {
			controlador.mostrarResponsablesExamenes();
		} else if (e.getSource()==bExamenes) {
			controlador.mostrarExamenes();
		
		}
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
}
