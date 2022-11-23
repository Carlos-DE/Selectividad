package controlador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import controlador.ConexionConBaseDeDatos;
import modelo.Alumno;
import modelo.Materia;
import modelo.Responsable;
import modelo.Sede;

public class ConexionBaseDatosJDBC extends ConexionConBaseDeDatos {
	 PreparedStatement ps;
	 ResultSet rs;
	 ArrayList<Materia> lMaterias = new ArrayList<>();
    private Connection conn;

    private static ConexionBaseDatosJDBC instanciaInterfaz = null;

    public ConexionBaseDatosJDBC() {
    	
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e)
        {
            System.err.println("ERROR DE DRIVER");
        }
    	
        try {
            // create connection for database called DBB_SCHEMA in a server installed in
            // DB_URL, with a user USER with password PASS
            //conn = DriverManager.getConnection(DB_URL + "/" + DB_SCHEMA, USER, PASS);
        	conn = DriverManager.getConnection("jdbc:mysql://database-pevau.cobadwnzalab.eu-central-1.rds.amazonaws.com/grupo11DB", "grupo11", "xtDA3sPVFCE9BRhK");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ConexionBaseDatosJDBC getInstance() {
        if (instanciaInterfaz == null) {
            instanciaInterfaz = new ConexionBaseDatosJDBC();
        }
        return instanciaInterfaz;
    }
    public List<Alumno> listaAlumnosDeUnCentro(String centro){
        ArrayList<Alumno> lAlumno = new ArrayList<>();
        String selectQueryBody = "SELECT * FROM ALUMNO WHERE Centro=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            preparedStatement.setString(1, centro);
            ResultSet rs = preparedStatement.executeQuery();
            // position result to first
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String c = rs.getString(2);
                    String nombre = rs.getString(3);
                    String ap1 = rs.getString(4);
                    String ap2 = rs.getString(5);
                    //lAlumno.add(new Alumno(id, c, nombre, ap1, ap2));

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lAlumno;
    }

    public List<Materia> listaMaterias() {
        
        String selectQueryBody = "SELECT * FROM MATERIA";
        Statement querySt;
        try {
            querySt = conn.createStatement();
            ResultSet rs = querySt.executeQuery(selectQueryBody);
            // position result to first
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String id = rs.getString(1);
                    lMaterias.add(new Materia(id));
                    
                }
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lMaterias;        
    }
   
    
    
    public List<String> getListaMaterias() {
    	List<String> lista=null;
    	for (Materia m: lMaterias) {
          lista.add(m.getIdMateria());
        }
    	return lista;
    }
    public List<Sede> listaSedes() {
        ArrayList<Sede> lSedes = new ArrayList<>();
        String selectQueryBody = "SELECT * FROM SEDE";
        Statement querySt;
        try {
            querySt = conn.createStatement();
            ResultSet rs = querySt.executeQuery(selectQueryBody);
            // position result to first
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String nombre = rs.getString(2);
                    lSedes.add(new Sede(id, nombre));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lSedes;
    }

    public List<Responsable> listaResponsable() {
        ArrayList<Responsable> lResponsables = new ArrayList<>();
        String selectQueryBody = "SELECT * FROM RESPONSABLE";
        Statement querySt;
        try {
            querySt = conn.createStatement();
            ResultSet rs = querySt.executeQuery(selectQueryBody);
            // position result to first
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String nombre = rs.getString(1);
                    lResponsables.add(new Responsable(nombre));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lResponsables;
    }

    public int insertarSede(Sede s) {
        int sedeId = 0;
        String insertBody = "INSERT INTO " + "SEDE" + "(idSede, NombreSede) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertBody,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, s.getIdSede());
            preparedStatement.setString(2, s.getNombre());
            int res = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                sedeId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sedeId;
    }

    public int actualizarSede(Sede s) {
        PreparedStatement preparedStatement = null;
        String updateBody = null;
        int res = 0;
        try {
            updateBody = "UPDATE " + "SEDE" + " SET nombre = "+ s.getNombre() +" WHERE (idSede = "+ s.getIdSede() +")";
            preparedStatement = conn.prepareStatement(updateBody);
            if (s.getIdSede() == null) {
                preparedStatement.setNull(1, java.sql.Types.INTEGER);
            } else {
                preparedStatement.setInt(1, s.getIdSede());
            }
            preparedStatement.setString(2, s.getNombre());
            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public int borrarSede() {
        String deleteBody = "TRUNCATE TABLE SEDE";
        int res = 0;

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(deleteBody);
            System.out.println("paso 2");
            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    
    public int insertarAsignaturas(Materia m) {
        int materiaId = 0;
        String insertBody = "INSERT INTO " + "MATERIA" + "(IdMateria) VALUES (?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertBody,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, m.getIdMateria());
            int res = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                materiaId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materiaId;
    }
    
    
    public int borrarAsignaturas() {
        String deleteBody = "TRUNCATE TABLE MATERIA";
        int res = 0;

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(deleteBody);
            System.out.println("paso 2");
            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    public int borrarAlumno() {
        String deleteBody = "TRUNCATE TABLE ALUMNO";
        int res = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(deleteBody);
            System.out.println("paso 2");
            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    public int insertarAlumno(Alumno a) {
        int sedeId = 0;
        String insertBody = "INSERT INTO " + "ALUMNO" + "(DNI, Centro, Nombre, Apellido1, Apellido2,"
                + "DetalleMateria) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertBody,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, a.getDni());
            preparedStatement.setString(2, a.getCentro());
            preparedStatement.setString(3, a.getNombre());
            preparedStatement.setString(4, a.getApellido1());
            preparedStatement.setString(5, a.getApellido2());
            preparedStatement.setString(6, a.getDetalleMateria());
            int res = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                sedeId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sedeId;
    }
    
    public int insertarResponsable(Responsable a) {
        int responsableId = 0;
        String insertBody = "INSERT INTO " + "RESPONSABLE" + "(Nombre) VALUES (?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertBody,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            //preparedStatement.setInt(1, a.getIdResponsable());
            preparedStatement.setString(1, a.getNombre());
           // preparedStatement.setString(3, a.getApellido1());
           // preparedStatement.setString(4, a.getApellido2());
            int res = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                responsableId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return responsableId;
    }
    
    
    public int borrarResponsables() {
        String deleteBody = "TRUNCATE TABLE RESPONSABLE";
        int res = 0;

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(deleteBody);
            System.out.println("paso 2");
            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

	@Override
	public List<Materia> verMaterias() {
		// TODO Auto-generated method stub
		return null;
	}
    
}