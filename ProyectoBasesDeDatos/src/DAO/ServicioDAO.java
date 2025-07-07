/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Hotel.Conexion;
import Modelo.Servicio;
import java.sql.*;

/**
 *
 * @author NIKO
 */



public class ServicioDAO {

    public void insertar(Servicio s) {
        String sql = "INSERT INTO Servicio VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, s.getId());
            ps.setString(2, s.getNombre());
            ps.setString(3, s.getDetalle());
            ps.setInt(4, s.getPrecio());
            ps.executeUpdate();
            System.out.println("Servicio insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar servicio: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Servicio";
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("ID: %d | %s | $%d\nDescripción: %s\n\n",
                    rs.getInt("idServicio"),
                    rs.getString("nombreServicio"),
                    rs.getInt("precioServicio"),
                    rs.getString("detalleServicio")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al listar servicios: " + e.getMessage());
        }
    }

    public void actualizar(Servicio s) {
        String sql = "UPDATE Servicio SET nombreServicio = ?, detalleServicio = ?, precioServicio = ? WHERE idServicio = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getNombre());
            ps.setString(2, s.getDetalle());
            ps.setInt(3, s.getPrecio());
            ps.setInt(4, s.getId());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Servicio actualizado.");
            } else {
                System.out.println("Servicio no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM Servicio WHERE idServicio = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Servicio eliminado.");
            } else {
                System.out.println("Servicio no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
