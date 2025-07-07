/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Hotel.Conexion;
import java.sql.*;

/**
 *
 * @author NIKO
 */



public class EmailEmpleadoDAO {

    public void insertar(int dni, String email) {
        String sql = "INSERT INTO EmailEmpleado VALUES (?, ?)";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ps.setString(2, email);
            ps.executeUpdate();
            System.out.println("Email agregado.");
        } catch (SQLException e) {
            System.out.println("Error al insertar email: " + e.getMessage());
        }
    }

    public void listarPorDNI(int dni) {
        String sql = "SELECT Email FROM EmailEmpleado WHERE DNIEmpleado = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            System.out.println("Emails del empleado " + dni + ":");
            while (rs.next()) {
                System.out.println("- " + rs.getString("Email"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar emails: " + e.getMessage());
        }
    }

    public void eliminar(int dni, String email) {
        String sql = "DELETE FROM EmailEmpleado WHERE DNIEmpleado = ? AND Email = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ps.setString(2, email);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Email eliminado.");
            } else {
                System.out.println("No se encontró ese email.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar email: " + e.getMessage());
        }
    }
}

