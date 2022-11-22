package src;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexionBaseDatosJDBC extends ConexionConBasedeDatos {

    private Connection conn;

    private static ConexionBaseDatosJDBC instanciaInterfaz = null;

    private ConexionBaseDatosJDBC() {
        try {
            // create connection for database called DBB_SCHEMA in a server installed in
            // DB_URL, with a user USER with password PASS
            conn = DriverManager.getConnection(DB_URL + "/" + DB_SCHEMA, USER, PASS);
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
            preparedStatement.setString(1, Centro);
            ResultSet rs = preparedStatement.executeQuery();
            // position result to first
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String centro = rs.getString(2);
                    String nombre = rs.getString(3);
                    String ap1 = rs.getString(4);
                    String ap2 = rs.getString(5);
                    lAlumno.add(new Alumno(id, centro, nombre, ap1, ap2));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lAlumno;
    }

    public List<Materia> listaMaterias() {
        ArrayList<Materia> lMaterias = new ArrayList<>();
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
                    int id = rs.getint(1);
                    String nombre = rs.getString(2);
                    lSedess.add(new Sede(id, nombre));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lSedes;
    }
}