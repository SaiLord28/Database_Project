/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Hotel.Conexion;
import Modelo.Habitacion;
import java.sql.*;


/**
 *
 * @author NIKO
 */


public class HabitacionDAO {

    public void insertar(Habitacion h) {
        String sql = "INSERT INTO Habitacion VALUES (?, ?)";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, h.getIdHabitacion());
            ps.setInt(2, h.getIdCategoria());
            ps.executeUpdate();
            System.out.println("\nHabitación insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("\nError al insertar habitación: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT h.idHabitacion, h.idCategoria, c.nombreCategoria, c.precioCategoria FROM Habitacion h JOIN Categoria c ON h.idCategoria = c.idCategoria ORDER BY h.idHabitacion";
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("Habitación %d | Categoría: %s | Precio: $%d\n\n",
                    rs.getInt("idHabitacion"),
                    rs.getString("nombreCategoria"),
                    rs.getInt("precioCategoria")
                );
            }
        } catch (SQLException e) {
            System.out.println("\nError al listar habitaciones: " + e.getMessage());
        }
    }

    public void eliminar(int idHabitacion) {
        String sql = "DELETE FROM Habitacion WHERE idHabitacion = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idHabitacion);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("\nHabitación eliminada.");
            } else {
                System.out.println("\nHabitación no encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("\nError al eliminar habitación: " + e.getMessage());
        }
    }
}

