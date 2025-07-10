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

public class EmailClienteDAO {

    public void insertar(int dni, String email) {
        String sql = "INSERT INTO EmailCliente VALUES (?, ?)";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ps.setString(2, email);
            ps.executeUpdate();
            System.out.println("\nEmail agregado.");
        } catch (SQLException e) {
            System.out.println("\nError al insertar email: " + e.getMessage());
        }
    }

    public void listarPorDNI(int dni) {
        String sql = "SELECT Email FROM EmailCliente WHERE DNI = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            System.out.println("\nEmails del cliente " + dni + ":");
            while (rs.next()) {
                System.out.println("- " + rs.getString("Email"));
            }
        } catch (SQLException e) {
            System.out.println("\nError al listar emails: " + e.getMessage());
        }
    }

    public void eliminar(int dni, String email) {
        String sql = "DELETE FROM EmailCliente WHERE DNI = ? AND Email = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ps.setString(2, email);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("\nEmail eliminado.");
            } else {
                System.out.println("\nNo se encontró ese email.");
            }
        } catch (SQLException e) {
            System.out.println("\nError al eliminar email: " + e.getMessage());
        }
    }
}
