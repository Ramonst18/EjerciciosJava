package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Rene Navarro
 */
public class Database {

    private Connection con;

    //URL que identifica a la base de datos que nos queremos conectar
    private final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    //Driver de JDBC que vamos a usar para conectarnos a la base de datos
    private final String DRIVER = "org.postgresql.Driver";
    private static Database DB = null;
    private Database() {
        super();
    }
    
    

    //abre la conexion con la base de datos
    private Database(String user, String password) {
        super();
        con = null;
        try {

            // Cargar el driver
            Class.forName(DRIVER);
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            // Abrir una conexion a la base de datos
            con = DriverManager.getConnection(DB_URL, props);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Codigo : " + ex.getErrorCode());
            
            //adiciones por Ramon Lopez
            JOptionPane.showMessageDialog(null, "Error en el usuario y/o contraseña");
        }
    }

    // Abrir la conexión y regresar objeto Database
    public static Database getDatabase(String user, String pass) {
        if (DB == null) {
            DB = new Database(user, pass);
        }
        if (DB.con == null) {
            DB = null;
        }
        return DB;
    }

    //enviamos el comando sql y recibimos el resultado de la consulta
    public ResultSet query(String sql) throws SQLException {

        ResultSet rs = null;
        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        rs = statement.executeQuery(sql);

        return rs;
    }

    //para ver si se pueden mover hacia adelante y hacia atras
    public ResultSet query(String sql, int scroll, int concur) throws SQLException {

        ResultSet rs = null;

        Statement statement = con.createStatement(scroll, concur);
        rs = statement.executeQuery(sql);

        return rs;
    }

    //nos sirve para actualizar la tabla señanala
    public int update(String sql) throws SQLException {
        int result = -1;

        Statement statement = con.createStatement( ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_UPDATABLE );
        result = statement.executeUpdate(sql);
        return result;
    }
}
