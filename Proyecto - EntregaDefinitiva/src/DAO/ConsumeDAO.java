/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Hotel.Conexion;
import Modelo.Consume;
import java.sql.*;
import java.time.LocalDateTime;

/**
 *
 * @author NIKO
 */


public class ConsumeDAO {

    public void insertar(Consume c) {
        String sql = "INSERT INTO Consume VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getIdServicio());
            ps.setTimestamp(2, Timestamp.valueOf(c.getFechaLlegada()));
            ps.setInt(3, c.getDNI());
            ps.setInt(4, c.getIdHabitacion());
            ps.setTimestamp(5, Timestamp.valueOf(c.getFechaUso()));
            ps.executeUpdate();
            System.out.println("\nConsumo registrado correctamente.");
        } catch (SQLException e) {
            System.out.println("\nError al registrar consumo: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = """
            SELECT c.idServicio, s.nombreServicio, c.fechaLlegada, c.DNI, c.idHabitacion, c.fechaUso
            FROM Consume c
            JOIN Servicio s ON c.idServicio = s.idServicio
            ORDER BY c.fechaUso
        """;
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("");
            while (rs.next()) {
                System.out.printf("Cliente %d | Habitación %d | Servicio: %s | Consumo: %s\n",
                        rs.getInt("DNI"),
                        rs.getInt("idHabitacion"),
                        rs.getString("nombreServicio"),
                        rs.getTimestamp("fechaUso").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            System.out.println("\nError al listar consumos: " + e.getMessage());
        }
    }

    public void eliminar(int idServicio, LocalDateTime fechaReserva, int dni, int habitacion) {
        String sql = "DELETE FROM Consume WHERE idServicio = ? AND fechaLlegada = ? AND DNI = ? AND idHabitacion = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idServicio);
            ps.setTimestamp(2, Timestamp.valueOf(fechaReserva));
            ps.setInt(3, dni);
            ps.setInt(4, habitacion);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("\nConsumo eliminado.");
            } else {
                System.out.println("\nNo se encontró el consumo.");
            }
        } catch (SQLException e) {
            System.out.println("\nError al eliminar consumo: " + e.getMessage());
        }
    }
}

