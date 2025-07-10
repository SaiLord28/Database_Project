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


public class TelefonoEmpleadoDAO {

    public void insertar(int dni, String telefono) {
        String sql = "INSERT INTO TelefonoEmpleado VALUES (?, ?)";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ps.setString(2, telefono);
            ps.executeUpdate();
            System.out.println("\nTeléfono agregado.");
        } catch (SQLException e) {
            System.out.println("\nError al insertar teléfono: " + e.getMessage());
        }
    }

    public void listarPorDNI(int dni) {
        String sql = "SELECT telefonoEmpleado FROM TelefonoEmpleado WHERE DNIEmpleado = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            System.out.println("\nTeléfonos del empleado " + dni + ":");
            while (rs.next()) {
                System.out.println("- " + rs.getString("telefonoEmpleado"));
            }
        } catch (SQLException e) {
            System.out.println("\nError al listar teléfonos: " + e.getMessage());
        }
    }

    public void eliminar(int dni, String telefono) {
        String sql = "DELETE FROM TelefonoEmpleado WHERE DNIEmpleado = ? AND telefonoEmpleado = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ps.setString(2, telefono);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("\nTeléfono eliminado.");
            } else {
                System.out.println("\nNo se encontró ese teléfono.");
            }
        } catch (SQLException e) {
            System.out.println("\nError al eliminar teléfono: " + e.getMessage());
        }
    }
}

