package Acceso_BBDD_MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Acceso {
    private Connection conexion;
    private Statement statement;
    private ResultSet resultSet;

    public Acceso() {
        this.conexion = null;
        this.statement = null;
        this.resultSet = null;
    }

    public void conectar() {

            // Loading class `com.mysql.jdbc.Driver'. This is deprecated. 
            //The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered
            // Class.forName("com.mysql.jdbc.Driver"); 

        // establecer los datos para la conexión
        String url = "jdbc:mysql://localhost:3306/aad";
        String usuario = "root";
        String contrasena = "";

        try {
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            statement = conexion.createStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void desconectar() {
        if (conexion != null)
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }

    public void realizarConsulta(String consulta) {
        try {
            resultSet = statement.executeQuery(consulta);
            boolean seguir = resultSet.next();
            while (seguir) {
                System.out.println(resultSet.getInt(1) + " " +
                        resultSet.getString(2) + " " +
                        resultSet.getString(3) + " " +
                        resultSet.getInt(4));
                seguir = resultSet.next();
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
