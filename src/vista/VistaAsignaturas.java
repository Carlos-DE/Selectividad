package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.TitledBorder;

import controlador.ConexionBaseDatosJDBC;
import controlador.ConexionConBaseDeDatos;
import controlador.Controlador;
import controlador.ControladorAsignaturas;
import modelo.Materia;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;

public class VistaAsignaturas  extends JFrame implements ActionListener {
	
	private JButton bHome;
	private JButton bAlumnos, bCargarDatos,bBorrarDatos;
	private JButton bSedes;
	private JButton bResponsables;
	private JButton bAsignaturas;
	private Controlador controlador;
	private ControladorAsignaturas controladorAsignaturas= new ControladorAsignaturas();
	private static ConexionConBaseDeDatos conexionBD = ConexionBaseDatosJDBC.getInstance();
	private JList<String> listaMaterias;
    private DefaultListModel listModel= new DefaultListModel();;
	private JButton bVicerrector;
	private JButton bGestorSede;
	private JPanel panel;
	private Panel menu_1;
	private JButton bResponsablesSedes;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton bInstitutos;
	private JButton bExamenes;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	java.util.List<Materia> lista;


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */

	 
	public VistaAsignaturas() {
		refresh();
		initialize();
	
	}

	public void refresh(){
		lista = conexionBD.listaMaterias();
		//listModel = new DefaultListModel();
		for(Materia a : lista) {
	        listModel.addElement(a.getIdMateria());
	    }
		
	}
	
		
	

	private void cargaLista(){
		refresh();
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
		gbl_maingrid.columnWidths = new int[]{0, 0};
		gbl_maingrid.rowHeights = new int[]{40, 30, 30, 200};
		gbl_maingrid.columnWeights = new double[]{1.0, 1.0};
		gbl_maingrid.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		maingrid.setLayout(gbl_maingrid);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 2;
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
		bVicerrector.addActionListener(this);
		menu.add(bVicerrector);

		bGestorSede = new JButton("GESTOR SEDE");
		bGestorSede.addActionListener(this);
		menu.add(bGestorSede);

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

		
		////////////////////////////////////////////////////////
		
		
				
				
						
			
					
				
				
				JLabel lblNombreSede = new JLabel("Nombre Asignaturas");
				GridBagConstraints gbc_lblNombreSede = new GridBagConstraints();
				gbc_lblNombreSede.fill = GridBagConstraints.BOTH;
				gbc_lblNombreSede.insets = new Insets(0, 0, 5, 0);
				gbc_lblNombreSede.gridx = 1;
				gbc_lblNombreSede.gridy = 1;
				maingrid.add(lblNombreSede, gbc_lblNombreSede);
		
		
		
		
		
		bCargarDatos = new JButton("CargarDatos");
		GridBagConstraints gbc_bCargarDatos = new GridBagConstraints();
		gbc_bCargarDatos.insets = new Insets(0, 0, 5, 5);
		gbc_bCargarDatos.gridx = 0;
		gbc_bCargarDatos.gridy = 2;
		bCargarDatos.addActionListener(this);
		maingrid.add(bCargarDatos, gbc_bCargarDatos);
		
		bBorrarDatos = new JButton("BorrarDatos");
		GridBagConstraints gbc_bBorrarDatos = new GridBagConstraints();
		gbc_bBorrarDatos.anchor = GridBagConstraints.NORTH;
		gbc_bBorrarDatos.insets = new Insets(0, 0, 5, 0);
		gbc_bBorrarDatos.gridx = 1;
		gbc_bBorrarDatos.gridy = 2;
		bBorrarDatos.addActionListener(this);
		maingrid.add(bBorrarDatos, gbc_bBorrarDatos);
		
		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 3;
		maingrid.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{200, 45, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		//java.util.List<Materia> lista = conexionBD.listaMaterias();
		//JList listNombre = new JList((ListModel) conexionBD.listaMaterias());
		listaMaterias = new JList<String>(listModel);
		scrollPane = new JScrollPane( listaMaterias );
		GridBagConstraints gbc_listaMaterias = new GridBagConstraints();
		gbc_listaMaterias.fill = GridBagConstraints.BOTH;
		gbc_listaMaterias.gridheight = 2;
		gbc_listaMaterias.insets = new Insets(0, 0, 5, 0);
		gbc_listaMaterias.gridx = 0;
		gbc_listaMaterias.gridy = 0;
		panel_3.add(scrollPane, gbc_listaMaterias);
		//listaMaterias.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		
		
		
		
		
		JButton bDescargarLog = new JButton("DescargarLog");
		GridBagConstraints gbc_bDescargarLog = new GridBagConstraints();
		gbc_bDescargarLog.anchor = GridBagConstraints.NORTH;
		gbc_bDescargarLog.insets = new Insets(0, 0, 0, 5);
		gbc_bDescargarLog.gridx = 0;
		gbc_bDescargarLog.gridy = 4;
		maingrid.add(bDescargarLog, gbc_bDescargarLog);
		
		TextArea logText = new TextArea();
		GridBagConstraints gbc_logText = new GridBagConstraints();
		gbc_logText.anchor = GridBagConstraints.NORTH;
		gbc_logText.fill = GridBagConstraints.HORIZONTAL;
		gbc_logText.gridx = 1;
		gbc_logText.gridy = 4;
		maingrid.add(logText, gbc_logText);
		logText.setEditable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bHome){
			controlador.mostrarHome();
		}else if(e.getSource()==bVicerrector){
			controlador.mostrarAlumnos();
		}else if(e.getSource()==bGestorSede){
			controlador.mostrarAulas();
		}else if (e.getSource()==bAlumnos){
			controlador.mostrarAlumnos();
		}else if (e.getSource()==bAsignaturas){
			controlador.mostrarAsignaturas();
		}else if (e.getSource()==bExamenes){
			controlador.mostrarExamenes();
		}else if (e.getSource()==bInstitutos){
			controlador.mostrarInstitutos();
		}else if (e.getSource()==bResponsablesSedes){
			controlador.mostrarResponsables();
		}else if (e.getSource()==bSedes){
			controlador.mostrarSedes();
		} else if(e.getSource()==bCargarDatos) {
			System.out.println("llego al boton");
			try {
				controladorAsignaturas.abrirArchivo();
                cargaLista();


			} catch (IOException ex) {
				ex.printStackTrace();
			}

			System.out.println("llego al boton");
			refresh();
			
		} else if (e.getSource()==bBorrarDatos) {
			listModel.clear();
			controladorAsignaturas.borrarDatos();
		}
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	public void addlista(String s) {
		
	}
}
