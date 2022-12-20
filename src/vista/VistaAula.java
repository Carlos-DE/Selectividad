package vista;




import javax.swing.*;

import controlador.ConexionBaseDatosJDBC;
import controlador.ConexionConBaseDeDatos;
import controlador.Controlador;
import controlador.ControladorAula;
import controlador.ControladorResponsables;
import controlador.ControladorSede;
import modelo.Alumno;
import modelo.Aula;
import modelo.Responsable;
import modelo.ResponsableExamen;
import modelo.Sede;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.border.TitledBorder;

public class VistaAula extends JFrame implements ActionListener{
	private JButton bAulas;
	private JButton bVicerrector;
	private JButton bGestorSede;
	private JButton bHome;
	private JButton bResponsablesExamen;
	private JButton bSedes;
	private JList list;
	private Controlador controlador;
	private JButton bAnadirAula , bBorrarAula, bActualizarAula;
	private ControladorAula controladorAula = new ControladorAula();
	private ConexionConBaseDeDatos conexionBD = ConexionBaseDatosJDBC.getInstance();
    private JTextField tCodigoAula;
    private JTextField tAforoAula;
	JScrollPane scrollPane = new JScrollPane();
	private DefaultListModel listModel;
	private JList<String> listAulas;
	java.util.List<Aula> lista;



	/**
	 * Launch the application.
	 */
	public VistaAula() {
		refresh();
		initialize();
	}


	/**
	 * Create the application.
	 */



	private void refresh() {
		lista = conexionBD.listaAulas();
		listModel = new DefaultListModel();
		for(Aula a : lista) {
			listModel.addElement(a.getId()+ " " + a.getAforo());
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
		gbl_maingrid.columnWidths = new int[]{210, 92, 178, 409, -21, 0};
		gbl_maingrid.rowHeights = new int[]{40, 0, 30, 0, 66, 0, 0, 0, 0, 0, 0, 81, 0};
		gbl_maingrid.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_maingrid.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		maingrid.setLayout(gbl_maingrid);
		
		Panel menu = new Panel();
		menu.setFont(new Font("Dialog", Font.PLAIN, 14));
		menu.setBackground(new Color(0, 64, 128));
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.fill = GridBagConstraints.BOTH;
		gbc_menu.gridwidth = 5;
		gbc_menu.insets = new Insets(0, 0, 5, 0);
		gbc_menu.gridx = 0;
		gbc_menu.gridy = 0;
		maingrid.add(menu, gbc_menu);
		
		bHome = new JButton("Home");
		menu.add(bHome);
		bHome.addActionListener(this);
		
		
		bVicerrector = new JButton("VICERRECTOR");
		bVicerrector.addActionListener(this);
		menu.add(bVicerrector);
		
		bGestorSede = new JButton("GESTOR SEDE");
		menu.add(bGestorSede);
		bGestorSede.addActionListener(this);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "GESTOR SEDE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 5;
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
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		maingrid.add(panel, gbc_panel);
		
		JLabel lblNewLabel = new JLabel("Nombre Sede");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		maingrid.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{30, 48, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo Aula");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tCodigoAula = new JTextField();
		GridBagConstraints gbc_tCodigoAula = new GridBagConstraints();
		gbc_tCodigoAula.anchor = GridBagConstraints.NORTH;
		gbc_tCodigoAula.fill = GridBagConstraints.HORIZONTAL;
		gbc_tCodigoAula.gridx = 0;
		gbc_tCodigoAula.gridy = 1;
		panel_1.add(tCodigoAula, gbc_tCodigoAula);
		tCodigoAula.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 4;
		maingrid.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{30, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Aforo Aula");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tAforoAula = new JTextField();
		GridBagConstraints gbc_tAforoAula = new GridBagConstraints();
		gbc_tAforoAula.fill = GridBagConstraints.HORIZONTAL;
		gbc_tAforoAula.gridx = 0;
		gbc_tAforoAula.gridy = 1;
		panel_3.add(tAforoAula, gbc_tAforoAula);
		tAforoAula.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridheight = 7;
		gbc_panel_4.gridwidth = 2;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 3;
		gbc_panel_4.gridy = 2;
		maingrid.add(panel_4, gbc_panel_4);
		
		
		
		
		listAulas = new JList<String>(listModel);
		listAulas.setVisibleRowCount(16);
		scrollPane.setViewportView(listAulas);
		panel_4.add(scrollPane);
		
		JLabel lblNewLabel_6 = new JLabel("CodigoAula; Aforo");
		scrollPane.setColumnHeaderView(lblNewLabel_6);

		
		JLabel lblNewLabel_3 = new JLabel("Dia 1");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		maingrid.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Dia 2");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		maingrid.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Dia 3");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 5;
		maingrid.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Tramo 1");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 6;
		maingrid.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Tramo 1");
		GridBagConstraints gbc_chckbxNewCheckBox_3 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_3.gridx = 1;
		gbc_chckbxNewCheckBox_3.gridy = 6;
		maingrid.add(chckbxNewCheckBox_3, gbc_chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Tramo 1");
		GridBagConstraints gbc_chckbxNewCheckBox_6 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_6.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_6.gridx = 2;
		gbc_chckbxNewCheckBox_6.gridy = 6;
		maingrid.add(chckbxNewCheckBox_6, gbc_chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Tramo 2");
		GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_1.gridx = 0;
		gbc_chckbxNewCheckBox_1.gridy = 7;
		maingrid.add(chckbxNewCheckBox_1, gbc_chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Tramo 2");
		GridBagConstraints gbc_chckbxNewCheckBox_4 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_4.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_4.gridx = 1;
		gbc_chckbxNewCheckBox_4.gridy = 7;
		maingrid.add(chckbxNewCheckBox_4, gbc_chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("Tramo 2");
		GridBagConstraints gbc_chckbxNewCheckBox_7 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_7.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_7.gridx = 2;
		gbc_chckbxNewCheckBox_7.gridy = 7;
		maingrid.add(chckbxNewCheckBox_7, gbc_chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Tramo 3");
		GridBagConstraints gbc_chckbxNewCheckBox_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_2.gridx = 0;
		gbc_chckbxNewCheckBox_2.gridy = 8;
		maingrid.add(chckbxNewCheckBox_2, gbc_chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Tramo 3");
		GridBagConstraints gbc_chckbxNewCheckBox_5 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_5.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_5.gridx = 1;
		gbc_chckbxNewCheckBox_5.gridy = 8;
		maingrid.add(chckbxNewCheckBox_5, gbc_chckbxNewCheckBox_5);
		
		JCheckBox chckbxTramo = new JCheckBox("Tramo 3");
		GridBagConstraints gbc_chckbxTramo = new GridBagConstraints();
		gbc_chckbxTramo.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxTramo.gridx = 2;
		gbc_chckbxTramo.gridy = 8;
		maingrid.add(chckbxTramo, gbc_chckbxTramo);
		
		JCheckBox chckbxTramo_1 = new JCheckBox("Tramo 4");
		GridBagConstraints gbc_chckbxTramo_1 = new GridBagConstraints();
		gbc_chckbxTramo_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxTramo_1.gridx = 2;
		gbc_chckbxTramo_1.gridy = 9;
		maingrid.add(chckbxTramo_1, gbc_chckbxTramo_1);
		
		JCheckBox chckbxTramo_2 = new JCheckBox("Tramo 5");
		GridBagConstraints gbc_chckbxTramo_2 = new GridBagConstraints();
		gbc_chckbxTramo_2.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxTramo_2.gridx = 2;
		gbc_chckbxTramo_2.gridy = 10;
		maingrid.add(chckbxTramo_2, gbc_chckbxTramo_2);
		
		bAnadirAula = new JButton("Añadir aula");
		bAnadirAula.addActionListener(this);
		GridBagConstraints gbc_bAnadirAula = new GridBagConstraints();
		gbc_bAnadirAula.insets = new Insets(0, 0, 0, 5);
		gbc_bAnadirAula.gridx = 0;
		gbc_bAnadirAula.gridy = 11;
		maingrid.add(bAnadirAula, gbc_bAnadirAula);
		
		bActualizarAula = new JButton("Actualizar aula");
		bActualizarAula.addActionListener(this);
		GridBagConstraints gbc_bActualizarAula = new GridBagConstraints();
		gbc_bActualizarAula.insets = new Insets(0, 0, 0, 5);
		gbc_bActualizarAula.gridx = 1;
		gbc_bActualizarAula.gridy = 11;
		maingrid.add(bActualizarAula, gbc_bActualizarAula);
		
		bBorrarAula = new JButton("Borrar aula");
		bBorrarAula.addActionListener(this);
		GridBagConstraints gbc_bBorrarAula = new GridBagConstraints();
		gbc_bBorrarAula.insets = new Insets(0, 0, 0, 5);
		gbc_bBorrarAula.gridx = 2;
		gbc_bBorrarAula.gridy = 11;
		maingrid.add(bBorrarAula, gbc_bBorrarAula);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bHome){
			controlador.mostrarHome();
		}else if(e.getSource()==bVicerrector){
			controlador.mostrarAlumnos();
		}else if(e.getSource()==bGestorSede){
			controlador.mostrarAulas();
		}else if (e.getSource()==bAulas){
			controlador.mostrarAulas();
		}else if (e.getSource()==bResponsablesExamen){
			controlador.mostrarResponsablesExamenes();
		}else if(e.getSource()==bAnadirAula){
			System.out.println("Añadir aula");
			var aula = controladorAula.crearAula(tCodigoAula.getText(),tAforoAula.getText());
			controladorAula.anadirAula(aula);
			refresh();
			vaciarCampos();

		}
	}
	

	public void vaciarCampos(){
		tCodigoAula.setText("");
		tAforoAula.setText("");
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}

