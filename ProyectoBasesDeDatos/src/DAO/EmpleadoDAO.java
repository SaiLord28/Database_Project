/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Hotel.Conexion;
import Modelo.Empleado;
import java.sql.*;

/**
 *
 * @author NIKO
 */
public class EmpleadoDAO {

    public void insertar(Empleado e) {
        String sql = "INSERT INTO Empleado (DNIEmpleado, primerNombre, segundoNombre, primerApellido, segundoApellido, calle, carrera, numero, cargo, idArea) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, e.getDni());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getSegundoNombre());
            ps.setString(4, e.getPrimerApellido());
            ps.setString(5, e.getSegundoApellido());
            ps.setString(6, e.getCalle());
            ps.setString(7, e.getCarrera());
            ps.setString(8, e.getNumero());
            ps.setString(9, e.getCargo());
            ps.setInt(10, e.getIdArea());
            ps.executeUpdate();
            System.out.println("Empleado insertado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar empleado: " + ex.getMessage());
        }
    }

    public void listar() {
        String sql = "SELECT * FROM Empleado";
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("%d - %s %s %s %s - %s (Área %d)\n",
                        rs.getInt("DNIEmpleado"),
                        rs.getString("primerNombre"),
                        rs.getString("segundoNombre") == null ? "" : rs.getString("segundoNombre"),
                        rs.getString("primerApellido"),
                        rs.getString("segundoApellido"),
                        rs.getString("cargo"),
                        rs.getInt("idArea")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        }
    }

    public void eliminar(int dni) {
        String sql = "DELETE FROM Empleado WHERE DNIEmpleado = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Empleado eliminado.");
            } else {
                System.out.println("Empleado no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
