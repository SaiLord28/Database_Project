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

public class TelefonoClienteDAO {

    public void insertar(int dni, String telefono) {
        String sql = "INSERT INTO TelefonoCliente VALUES (?, ?)";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ps.setString(2, telefono);
            ps.executeUpdate();
            System.out.println("Teléfono agregado.");
        } catch (SQLException e) {
            System.out.println("Error al insertar teléfono: " + e.getMessage());
        }
    }

    public void listarPorDNI(int dni) {
        String sql = "SELECT Telefono FROM TelefonoCliente WHERE DNI = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            System.out.println("Teléfonos del cliente " + dni + ":");
            while (rs.next()) {
                System.out.println("- " + rs.getString("Telefono"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar teléfonos: " + e.getMessage());
        }
    }

    public void eliminar(int dni, String telefono) {
        String sql = "DELETE FROM TelefonoCliente WHERE DNI = ? AND Telefono = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ps.setString(2, telefono);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Teléfono eliminado.");
            } else {
                System.out.println("No se encontró ese teléfono.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar teléfono: " + e.getMessage());
        }
    }
}

