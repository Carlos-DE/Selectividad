package vista;

import javax.swing.*;

import controlador.Controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;

public class VistaHome extends JFrame implements ActionListener{

	private Controlador controlador;
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
	
	/**
	 * Create the application.
	 */
	public VistaHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSize(960, 540);
		setTitle("PEVAU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "HOME", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		menu_2 = new Panel();
		menu_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		menu_2.setBackground(new Color(0, 64, 128));
		GridBagConstraints gbc_menu_2 = new GridBagConstraints();
		gbc_menu_2.fill = GridBagConstraints.BOTH;
		gbc_menu_2.gridwidth = 4;
		gbc_menu_2.insets = new Insets(0, 0, 5, 0);
		gbc_menu_2.gridx = 0;
		gbc_menu_2.gridy = 0;
		panel.add(menu_2, gbc_menu_2);
		
		bHome = new JButton("Home");
		menu_2.add(bHome);
		bHome.addActionListener(this);
		
		bVicerrector = new JButton("VICERRECTOR");
		menu_2.add(bVicerrector);
		bVicerrector.addActionListener(this);
		
		bGestorSede = new JButton("GESTOR SEDE");
		menu_2.add(bGestorSede);
		bGestorSede.addActionListener(this);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "VICERRECTOR", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 4;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		menu_1 = new Panel();
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
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "GESTOR SEDE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		menu = new Panel();
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.gridwidth = 4;
		gbc_menu.fill = GridBagConstraints.BOTH;
		gbc_menu.insets = new Insets(0, 0, 0, 5);
		gbc_menu.gridx = 0;
		gbc_menu.gridy = 0;
		panel_1.add(menu, gbc_menu);
		menu.setFont(new Font("Dialog", Font.PLAIN, 14));
		menu.setBackground(new Color(0, 64, 128));
		
		bAulas = new JButton("Aulas");
		menu.add(bAulas);
		bAulas.addActionListener(this);
		
		bResponsablesExamen = new JButton("Responsables Examen");
		menu.add(bResponsablesExamen);
		bResponsablesExamen.addActionListener(this);
		
		
//		bInstitutos = new JButton("Institutos");
//		bInstitutos.addActionListener(this);
//		menu.add(bInstitutos);
		
//		bGenerar = new JButton("Generar");
//		bGenerar.addActionListener(this);
//		menu.add(bGenerar);
		
		
		
	}
	
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
			//controlador.mostrarExamenes();
		}else if (e.getSource()==bInstitutos){
			controlador.mostrarInstitutos();
		}else if (e.getSource()==bResponsablesSedes){
			controlador.mostrarResponsables();
		}else if (e.getSource()==bSedes){
			controlador.mostrarSedes();
		}else if (e.getSource()==bAulas){
			controlador.mostrarAulas();
		}else if (e.getSource()==bResponsablesExamen){
			controlador.mostrarResponsablesExamenes();
		}
	}
	
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

}
