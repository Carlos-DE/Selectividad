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
   /* public List<Alumno> listaAlumnosDeUnCentro(String centro){
        ArrayList<Alumno> lEquipos = new ArrayList<>();
        String selectQueryBody = "SELECT * FROM JUGADOR WHERE idEquipo=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(selectQueryBody);
            preparedStatement.setInt(1, idEq);
            ResultSet rs = preparedStatement.executeQuery();
            // position result to first
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int edad = rs.getInt(3);
                    int idEquipo = rs.getInt(4);
                    lEquipos.add(new Jugador(id, name, edad, idEquipo));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lEquipos;
    }*/
}