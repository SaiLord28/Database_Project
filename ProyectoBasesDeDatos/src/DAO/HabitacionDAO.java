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
            ps.setInt(1, h.getNumero());
            ps.setInt(2, h.getIdCategoria());
            ps.executeUpdate();
            System.out.println("Habitación insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar habitación: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT h.Numero, h.IDCategoria, c.NombreCategoria, c.Precio FROM Habitacion h JOIN Categoria c ON h.IDCategoria = c.IDCategoria ORDER BY h.Numero";
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("Habitación %d | Categoría: %s | Precio: $%d\n",
                    rs.getInt("Numero"),
                    rs.getString("NombreCategoria"),
                    rs.getInt("Precio")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al listar habitaciones: " + e.getMessage());
        }
    }

    public void eliminar(int numero) {
        String sql = "DELETE FROM Habitacion WHERE Numero = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numero);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Habitación eliminada.");
            } else {
                System.out.println("Habitación no encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar habitación: " + e.getMessage());
        }
    }
}

