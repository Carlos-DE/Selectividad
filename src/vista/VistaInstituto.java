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
import java.util.ArrayList;

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
import controlador.ControladorInstituto;
import modelo.Alumno;
import modelo.Centro;
import modelo.Sede;

import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;

public class VistaInstituto extends JFrame implements ActionListener {
	
	
	private JButton bHome;
	private Controlador controlador;
	private ControladorInstituto controladorInstituto = new ControladorInstituto();
	private JButton bVicerrector;
	private JButton bGestorSede;
	private Panel menu_1;
	private JButton bAlumnos;
	private JButton bSedes;
	private JButton bAsignaturas;
	private JButton bResponsablesSedes;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton bInstitutos;
	private JButton bExamenes;
	private DefaultListModel listModel;

	private ConexionConBaseDeDatos conexionBD = ConexionBaseDatosJDBC.getInstance();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */

	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JComboBox comboBoxSedes;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel_5;
	private JLabel lblInstitutosAsignadosA;
	private JButton bCargarDatos;
//	private JButton bBorrarDatos;
	private JTextPane textPane;
	private JScrollPane scrollPane;
	private JList listInstitutos;
	
	java.util.List<Alumno> lista;
	java.util.List<Sede> listaSedes;
	java.util.List<String> listaNombreCentros = new ArrayList<String>(); 
	java.util.List<Centro> listaCentros;
	public VistaInstituto() {
		refresh();
		
		listaSedes = conexionBD.listaSedes();
		comboBoxSedes = new JComboBox();
		for(Sede s : listaSedes) {
			if(((DefaultComboBoxModel)comboBoxSedes.getModel()).getIndexOf(s.getNombre())==-1) {
				comboBoxSedes.addItem(s.getNombre());
			}
		}	
		
		lista = conexionBD.listaAlumnos();
		listModel = new DefaultListModel();
		for(Alumno a : lista) {
			if(!listModel.contains(a.getCentro())) {
				listModel.addElement(a.getCentro());
				listaNombreCentros.add(getName());
			}
	    	
	    }
	
		for(String c : listaNombreCentros) {
			int n = conexionBD.listaAlumnosDeUnCentro(c).size();
			Centro centro = new Centro(c,n);
			//listaCentros.add(centro);
		}
		
		initialize();
	}

	private void refresh() {
		lista = conexionBD.listaAlumnos();
		listModel = new DefaultListModel();
		for(Alumno a : lista) {
			if(!listModel.contains(a.getCentro())) {
				listModel.addElement(a.getCentro());
			}
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
		gbl_maingrid.rowHeights = new int[]{40, 30, 0, 30, 0, 45, 96, 0};
		gbl_maingrid.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0};
		gbl_maingrid.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
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
		bGestorSede.addActionListener(this);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "VICERRECTOR", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		menu_1 = new Panel();
		GridBagConstraints gbc_menu_1 = new GridBagConstraints();
		gbc_menu_1.fill = GridBagConstraints.BOTH;
		gbc_menu_1.gridwidth = 4;
		gbc_menu_1.insets = new Insets(0, 0, 0, 5);
		gbc_menu_1.gridx = 0;
		gbc_menu_1.gridy = 0;
		panel_2.add(menu_1, gbc_menu_1);
		menu_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		menu_1.setBackground(new Color(0, 64, 128));
		
		bAlumnos = new JButton("Alumnos");
		bAlumnos.addActionListener(this);
		menu_1.add(bAlumnos);
		
		bAsignaturas = new JButton("Asignaturas");
		bAsignaturas.addActionListener(this);
		menu_1.add(bAsignaturas);
		
		bExamenes = new JButton("Examenes");
		bExamenes.addActionListener(this);
		menu_1.add(bExamenes);
		
		bInstitutos = new JButton("Institutos");
		bInstitutos.addActionListener(this);
		menu_1.add(bInstitutos);
		
		bResponsablesSedes = new JButton("Responsables Sedes");
		bResponsablesSedes.addActionListener(this);
		menu_1.add(bResponsablesSedes);
		
		bSedes = new JButton("Sedes");
		menu_1.add(bSedes);
		bSedes.addActionListener(this);
		
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
		
		lblNewLabel = new JLabel("Institutos por asignar");
		panel_3.add(lblNewLabel);
		
//		comboBoxSedes = new JComboBox();
//		comboBoxSedes.setModel(new DefaultComboBoxModel(new String[] {"Sedes"}));
		GridBagConstraints gbc_comboBoxSedes = new GridBagConstraints();
		gbc_comboBoxSedes.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxSedes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSedes.gridx = 1;
		gbc_comboBoxSedes.gridy = 1;
		maingrid.add(comboBoxSedes, gbc_comboBoxSedes);
		
		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 3;
		gbc_panel_5.gridy = 1;
		maingrid.add(panel_5, gbc_panel_5);
		
		lblInstitutosAsignadosA = new JLabel("Institutos asignados a esa sede");
		panel_5.add(lblInstitutosAsignadosA);
		
		listInstitutos = new JList<String>(listModel);
		scrollPane = new JScrollPane(listInstitutos);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		maingrid.add(scrollPane, gbc_scrollPane);
		
		
	//	scrollPane.setViewportView(list);
		
//		JTextField txtAforo = new JTextField();
//		txtAforo.setText("Aforo: 100");
//		GridBagConstraints gbc_txtAforo = new GridBagConstraints();
//		gbc_txtAforo.insets = new Insets(0, 0, 5, 5);
//		gbc_txtAforo.fill = GridBagConstraints.HORIZONTAL;
//		gbc_txtAforo.gridx = 1;
//		gbc_txtAforo.gridy = 2;
//		maingrid.add(txtAforo, gbc_txtAforo);
//		txtAforo.setColumns(10);
		
		textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridheight = 2;
		gbc_textPane.insets = new Insets(0, 0, 5, 0);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 3;
		gbc_textPane.gridy = 2;
		maingrid.add(textPane, gbc_textPane);
		
		btnNewButton = new JButton("Asignar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		maingrid.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("Quitar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 4;
		maingrid.add(btnNewButton_1, gbc_btnNewButton_1);
		
		bCargarDatos= new JButton("Actualizar Lista");
		bCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 5;
		maingrid.add(bCargarDatos, gbc_btnNewButton_2);
		
//		bBorrarDatos = new JButton("Borrar datos");
//		GridBagConstraints gbc_bBorrarDatos = new GridBagConstraints();
//		gbc_bBorrarDatos.insets = new Insets(0, 0, 5, 5);
//		gbc_bBorrarDatos.gridx = 1;
//		gbc_bBorrarDatos.gridy = 5;
//		maingrid.add(bBorrarDatos, gbc_bBorrarDatos);
//		bBorrarDatos.addActionListener(this);
		
		
		
		
		JButton bDescargarLog = new JButton("DescargarLog");
		bDescargarLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_bDescargarLog = new GridBagConstraints();
		gbc_bDescargarLog.insets = new Insets(0, 0, 0, 5);
		gbc_bDescargarLog.gridx = 0;
		gbc_bDescargarLog.gridy = 6;
		maingrid.add(bDescargarLog, gbc_bDescargarLog);
		
		TextArea logText = new TextArea();
		GridBagConstraints gbc_logText = new GridBagConstraints();
		gbc_logText.fill = GridBagConstraints.BOTH;
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
        } else if (e.getSource()==bVicerrector) {
            controlador.mostrarAlumnos();
        } else if (e.getSource()==bGestorSede) {
            controlador.mostrarAulas();
		} else if (e.getSource()==bAlumnos) {
			controlador.mostrarAlumnos();
		} else if (e.getSource()==bAsignaturas) {
			controlador.mostrarAsignaturas();
		} else if (e.getSource()==bExamenes) {
			controlador.mostrarExamenes();
		} else if (e.getSource()==bInstitutos) {
			controlador.mostrarInstitutos();
		}else if (e.getSource()==bResponsablesSedes) {
			controlador.mostrarResponsables();
		} else if (e.getSource()==bSedes) {
			controlador.mostrarSedes();
		}
		else if (e.getSource()==bCargarDatos) {
			refresh();
			
		} 
//		else if (e.getSource()==bBorrarDatos) {
//			controladorInstituto.borrarDatos();
//			listModel.clear();
//		}
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
}
