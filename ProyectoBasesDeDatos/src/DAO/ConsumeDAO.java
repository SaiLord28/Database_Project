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
            ps.setTimestamp(2, Timestamp.valueOf(c.getFechaReserva()));
            ps.setInt(3, c.getDni());
            ps.setInt(4, c.getNumHabitacion());
            ps.setTimestamp(5, Timestamp.valueOf(c.getFechaHoraConsumo()));
            ps.executeUpdate();
            System.out.println("Consumo registrado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar consumo: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = """
            SELECT c.idServicio, s.nombreServicio, c.fechaReserva, c.DNI, c.NumHabitacion, c.fechaHoraConsumo
            FROM Consume c
            JOIN Servicio s ON c.idServicio = s.idServicio
            ORDER BY c.fechaHoraConsumo
        """;
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("Cliente %d | Habitación %d | Servicio: %s | Consumo: %s\n",
                        rs.getInt("DNI"),
                        rs.getInt("NumHabitacion"),
                        rs.getString("nombreServicio"),
                        rs.getTimestamp("fechaHoraConsumo").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al listar consumos: " + e.getMessage());
        }
    }

    public void eliminar(int idServicio, LocalDateTime fechaReserva, int dni, int habitacion) {
        String sql = "DELETE FROM Consume WHERE idServicio = ? AND fechaReserva = ? AND DNI = ? AND NumHabitacion = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idServicio);
            ps.setTimestamp(2, Timestamp.valueOf(fechaReserva));
            ps.setInt(3, dni);
            ps.setInt(4, habitacion);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Consumo eliminado.");
            } else {
                System.out.println("No se encontró el consumo.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar consumo: " + e.getMessage());
        }
    }
}

