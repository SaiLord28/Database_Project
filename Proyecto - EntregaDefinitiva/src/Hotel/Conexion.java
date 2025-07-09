/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Hotel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author NIKO
 */


public class Conexion {
    public static Connection getConexion() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/hotel?currentSchema=hotel";
        String user = "postgres";
        String password = "|3etHo|)s";

        return DriverManager.getConnection(url, user, password);
    }
}

