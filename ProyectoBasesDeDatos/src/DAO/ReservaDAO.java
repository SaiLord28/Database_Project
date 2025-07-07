/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Hotel.Conexion;
import Modelo.Reserva;
import java.sql.*;
import java.time.LocalDateTime;

/**
 *
 * @author NIKO
 */



public class ReservaDAO {

    public void insertar(Reserva r) {
        String sql = "INSERT INTO Reserva VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, r.getDniCliente());
            ps.setInt(2, r.getNumHabitacion());
            ps.setTimestamp(3, Timestamp.valueOf(r.getFechaEntrada()));
            ps.setTimestamp(4, Timestamp.valueOf(r.getFechaSalida()));
            ps.executeUpdate();
            System.out.println("Reserva insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar reserva: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Reserva ORDER BY FechaEntrada";
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("Cliente %d | Habitación %d | Entrada: %s | Salida: %s\n",
                    rs.getInt("DNI"),
                    rs.getInt("NumHabitacion"),
                    rs.getTimestamp("FechaEntrada").toLocalDateTime(),
                    rs.getTimestamp("FechaSalida").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al listar reservas: " + e.getMessage());
        }
    }

    public void eliminar(int dni, int habitacion, LocalDateTime entrada) {
        String sql = "DELETE FROM Reserva WHERE DNI = ? AND NumHabitacion = ? AND FechaEntrada = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ps.setInt(2, habitacion);
            ps.setTimestamp(3, Timestamp.valueOf(entrada));
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Reserva eliminada.");
            } else {
                System.out.println("Reserva no encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar reserva: " + e.getMessage());
        }
    }
}

