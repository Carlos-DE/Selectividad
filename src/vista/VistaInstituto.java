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
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.event.ListSelectionEvent;


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
	private DefaultListModel listModel = new DefaultListModel();
	private DefaultListModel listModel2 = new DefaultListModel();

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
	private JButton bAsignar;
	private JButton bQuitar;
	private JPanel panel_5;
	private JLabel lblInstitutosAsignadosA;
	private JButton bActualizarLista;
	private JScrollPane scrollPane;
	private JList listInstitutos;

	private String nombreInstituto;
	private String nombreSede;

	private String nombreInstitutoSeleccionado;
	private String nombreSedeSeleccioanada;
	
	java.util.List<Alumno> lista = new ArrayList<Alumno>();
	java.util.List<String> lista2 = new ArrayList<String>();
	java.util.List<Sede> listaSedes;
	java.util.List<String> listaNombreCentros = new ArrayList<String>(); 
	java.util.List<Centro> listaCentros = new ArrayList<Centro>();
	private JList listAsginados;
	private JScrollPane scrollPane_1;
	public VistaInstituto() {
		refresh();
		refresh2();
		listaSedes = conexionBD.listaSedes();
		comboBoxSedes = new JComboBox();
		comboBoxSedes.addItem("");
		for(Sede s : listaSedes) {
			if(((DefaultComboBoxModel)comboBoxSedes.getModel()).getIndexOf(s.getNombre())==-1) {
				comboBoxSedes.addItem(s.getNombre());
				refresh();
			}
		}
		comboBoxSedes.setSelectedIndex(0);	

		comboBoxSedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombreSede = (String) comboBoxSedes.getSelectedItem();
				System.out.println(nombreSede);
				refresh();
				refresh2();
			}
		});
		

		
		lista = conexionBD.listaAlumnosSinSede();
		listModel = new DefaultListModel();
		for(Alumno a : lista) {
			if(!listModel.contains(a.getCentro())) {
				listModel.addElement(a.getCentro());
				listaNombreCentros.add(a.getCentro());
				
			}
	    	
	    }
		for(String c : listaNombreCentros) {
			
			int n = conexionBD.listaAlumnosDeUnCentro(c).size();
			Centro centro = new Centro(c,n);
			listaCentros.add(centro);
		}

		listModel.clear();

		for(Centro c : listaCentros){
			//listModel.addElement(c.getNombre() + " - " + c.getnAlumnosString());
			listModel.addElement(c.getNombre());
		}
		
		initialize();
	}



	private void refresh() {
		lista.clear();
		lista = conexionBD.listaAlumnosSinSede();
		listModel.clear();
		//listModel = new DefaultListModel();
		for(Alumno a : lista) {
			if(!listModel.contains(a.getCentro())) {
				listModel.addElement(a.getCentro());
			}
	    }
	}

	private void refresh2() {
		
		listModel2.clear();
		lista2 = conexionBD.listaInstitutosAsginados(nombreSede);
		//listModel = new DefaultListModel();
		for(String s : lista2) {
			if(!listModel2.contains(s)) {
				listModel2.addElement(s);
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
		gbl_maingrid.columnWidths = new int[]{0, 0, 0};
		gbl_maingrid.rowHeights = new int[]{40, 30, 0, 30, 0, 45, 96, 0};
		gbl_maingrid.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_maingrid.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		maingrid.setLayout(gbl_maingrid);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 3;
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
		gbc_panel_5.gridx = 2;
		gbc_panel_5.gridy = 1;
		maingrid.add(panel_5, gbc_panel_5);
		
		lblInstitutosAsignadosA = new JLabel("Institutos asignados a esa sede");
		panel_5.add(lblInstitutosAsignadosA);
		
		listInstitutos = new JList<String>(listModel);
		scrollPane = new JScrollPane(listInstitutos);
		listInstitutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listInstitutos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					try {
						String[] instituto = ((String) listInstitutos.getSelectedValue()).split(" -");
						nombreInstituto = instituto[0];
						System.out.println(nombreInstituto);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					
				}
			}
		});

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		maingrid.add(scrollPane, gbc_scrollPane);
		
		bAsignar = new JButton("Asignar");
		bAsignar.addActionListener(this);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 2;
		maingrid.add(scrollPane_1, gbc_scrollPane_1);
		
		listAsginados = new JList<String>(listModel2);
		scrollPane_1.setViewportView(listAsginados);
		listAsginados.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					try {
						String[] instituto = ((String) listAsginados.getSelectedValue()).split(" -");
						nombreInstitutoSeleccionado = instituto[0];
						System.out.println(nombreInstitutoSeleccionado);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					
				}
			}
		});
		


		GridBagConstraints gbc_bAsignar = new GridBagConstraints();
		gbc_bAsignar.insets = new Insets(0, 0, 5, 5);
		gbc_bAsignar.gridx = 1;
		gbc_bAsignar.gridy = 3;
		maingrid.add(bAsignar, gbc_bAsignar);
		
		bQuitar = new JButton("Quitar");
		GridBagConstraints gbc_bQuitar = new GridBagConstraints();
		gbc_bQuitar.insets = new Insets(0, 0, 5, 5);
		gbc_bQuitar.gridx = 1;
		gbc_bQuitar.gridy = 4;
		maingrid.add(bQuitar, gbc_bQuitar);
		bQuitar.addActionListener(this);
		
		bActualizarLista= new JButton("Actualizar Lista");
		bActualizarLista.addActionListener(this);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 5;
		maingrid.add(bActualizarLista, gbc_btnNewButton_2);
		
//		bBorrarDatos = new JButton("Borrar datos");
//		GridBagConstraints gbc_bBorrarDatos = new GridBagConstraints();
//		gbc_bBorrarDatos.insets = new Insets(0, 0, 5, 5);
//		gbc_bBorrarDatos.gridx = 1;
//		gbc_bBorrarDatos.gridy = 5;
//		maingrid.add(bBorrarDatos, gbc_bBorrarDatos);
//		bBorrarDatos.addActionListener(this);
		
		
		
		
		JButton bDescargarLog = new JButton("DescargarLog");
		bDescargarLog.addActionListener(this);
		GridBagConstraints gbc_bDescargarLog = new GridBagConstraints();
		gbc_bDescargarLog.insets = new Insets(0, 0, 0, 5);
		gbc_bDescargarLog.gridx = 0;
		gbc_bDescargarLog.gridy = 6;
		maingrid.add(bDescargarLog, gbc_bDescargarLog);
		
		TextArea logText = new TextArea();
		GridBagConstraints gbc_logText = new GridBagConstraints();
		gbc_logText.fill = GridBagConstraints.BOTH;
		gbc_logText.gridwidth = 2;
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
		} else if (e.getSource()==bInstitutos) {
			controlador.mostrarInstitutos();
		}else if (e.getSource()==bResponsablesSedes) {
			controlador.mostrarResponsables();
		} else if (e.getSource()==bSedes) {
			controlador.mostrarSedes();
		}
		else if (e.getSource()==bActualizarLista) {
			//Consulta si la lista en la BD esta vacia
			if(controladorInstituto.consultarListaInstitutos()){
				//si está vacía la pone vacía
				listModel.clear();
			}else{
				//si tiene contenido invoca al metodo refresh()
				listModel.clear();
				refresh();
				refresh2();
			}
				
			
		}else if (e.getSource()==bAsignar){
			
			controladorInstituto.asignarInstituto(nombreInstituto, nombreSede);
			refresh();
			refresh2();

		} else if (e.getSource()==bQuitar) {

			assert nombreInstitutoSeleccionado != null;
			assert nombreSede != null;
			
			controladorInstituto.conexionBD.quitarInstituto(nombreInstitutoSeleccionado, nombreSede);
			System.out.println("paso 1");
			refresh();
			System.out.println("paso 2");
			refresh2();
			System.out.println("paso 3");
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
