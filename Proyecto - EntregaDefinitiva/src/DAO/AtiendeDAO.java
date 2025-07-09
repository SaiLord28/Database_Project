/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Hotel.Conexion;
import Modelo.Atiende;
import java.sql.*;
import java.time.LocalDateTime;


/**
 *
 * @author NIKO
 */
public class AtiendeDAO {

    public void insertar(Atiende a) {
        String sql = "INSERT INTO Atiende (DNI, DNIEmpleado, IdArea, idHabitacion, idServicio, fechaLlegada, fechaUso) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, a.getDNI());
            ps.setInt(2, a.getDNIEmpleado());
            ps.setInt(3, a.getIdArea());
            ps.setInt(4, a.getIdHabitacion());
            ps.setInt(5, a.getIdServicio());
            ps.setTimestamp(6, Timestamp.valueOf(a.getFechaLlegada()));
            ps.setTimestamp(7, Timestamp.valueOf(a.getFechaUso()));
            ps.executeUpdate();
            System.out.println("\nAtención registrada correctamente.");
        } catch (SQLException e) {
            System.out.println("\nError al registrar atención: " + e.getMessage());
        }
    }

    public void listar() {
        String sql = """
            SELECT a.*, e.primerNombre, s.nombreServicio, ar.nombreArea
            FROM Atiende a
            JOIN Empleado e ON a.DNIEmpleado = e.DNIEmpleado
            JOIN Servicio s ON a.idServicio = s.idServicio
            JOIN Area ar ON a.idArea = ar.idArea
            ORDER BY a.fechaLlegada
        """;
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("Cliente %d | Empleado %s | Área: %s | Servicio: %s | Habitación %d | %s a %s\n",
                        rs.getInt("DNI"),
                        rs.getString("primerNombre"),
                        rs.getString("nombreArea"),
                        rs.getString("nombreServicio"),
                        rs.getInt("idHabitacion"),
                        rs.getTimestamp("fechaLlegada").toLocalDateTime(),
                        rs.getTimestamp("fechaUso").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            System.out.println("\nError al listar atenciones: " + e.getMessage());
        }
    }

    public void eliminar(int dni, int empleado, LocalDateTime fechaInicio) {
        String sql = "DELETE FROM Atiende WHERE DNI = ? AND DNIEmpleado = ? AND fechaLlegada = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ps.setInt(2, empleado);
            ps.setTimestamp(3, Timestamp.valueOf(fechaInicio));
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("\nAtención eliminada.");
            } else {
                System.out.println("\nNo se encontró la atención.");
            }
        } catch (SQLException e) {
            System.out.println("\nError al eliminar atención: " + e.getMessage());
        }
    }
}

