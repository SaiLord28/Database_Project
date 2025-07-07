/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Hotel.Conexion;
import Hotel.Input;
import Modelo.Cliente;
import java.sql.*;
import java.util.*;

/**
 *
 * @author NIKO
 */

public class ClienteDAO {

    public void insertar() {
        int dni = Input.leerEntero("DNI: ");
        String primerNombre = Input.leerTexto("Primer nombre: ");
        String segundoNombre = Input.leerTexto("Segundo nombre: ");
        String primerApellido = Input.leerTexto("Primer apellido: ");
        String segundoApellido = Input.leerTexto("Segundo apellido: ");
        String calle = Input.leerTexto("Calle: ");
        String carrera = Input.leerTexto("Carrera: ");
        String numero = Input.leerTexto("Número: ");

        String sql = "INSERT INTO Cliente (DNI, primerNombre, segundoNombre, primerApellido, segundoApellido, calle, carrera, numero) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ps.setString(2, primerNombre);
            ps.setString(3, segundoNombre.isEmpty() ? null : segundoNombre);
            ps.setString(4, primerApellido);
            ps.setString(5, segundoApellido);
            ps.setString(6, calle);
            ps.setString(7, carrera);
            ps.setString(8, numero);
            ps.executeUpdate();
            System.out.println("Cliente insertado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
        }
    }

    public void listarTodos() {
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                mostrarCliente(rs);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
    }

    public void buscarPorDNI(int dni) {
        String sql = "SELECT * FROM Cliente WHERE DNI = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mostrarCliente(rs);
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente: " + e.getMessage());
        }
    }

    public void actualizar(int dni) {
        System.out.println("Ingrese nuevos datos para el cliente (DNI: " + dni + ")");
        String primerNombre = Input.leerTexto("Primer nombre: ");
        String segundoNombre = Input.leerTexto("Segundo nombre: ");
        String primerApellido = Input.leerTexto("Primer apellido: ");
        String segundoApellido = Input.leerTexto("Segundo apellido: ");
        String calle = Input.leerTexto("Calle: ");
        String carrera = Input.leerTexto("Carrera: ");
        String numero = Input.leerTexto("Número: ");

        String sql = "UPDATE Cliente SET primerNombre=?, segundoNombre=?, primerApellido=?, segundoApellido=?, calle=?, carrera=?, numero=? WHERE DNI=?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, primerNombre);
            ps.setString(2, segundoNombre.isEmpty() ? null : segundoNombre);
            ps.setString(3, primerApellido);
            ps.setString(4, segundoApellido);
            ps.setString(5, calle);
            ps.setString(6, carrera);
            ps.setString(7, numero);
            ps.setInt(8, dni);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Cliente actualizado.");
            } else {
                System.out.println("No se encontró el cliente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
        }
    }

    public void eliminar(int dni) {
        String sql = "DELETE FROM Cliente WHERE DNI = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dni);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Cliente eliminado.");
            } else {
                System.out.println("No se encontró el cliente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
    }

    private void mostrarCliente(ResultSet rs) throws SQLException {
        System.out.printf("DNI: %d | Nombre: %s %s | Apellido: %s %s | Dirección: %s %s #%s\n",
            rs.getInt("DNI"),
            rs.getString("primerNombre"),
            rs.getString("segundoNombre") == null ? "" : rs.getString("segundoNombre"),
            rs.getString("primerApellido"),
            rs.getString("segundoApellido"),
            rs.getString("calle"),
            rs.getString("carrera"),
            rs.getString("numero"));
    }
}


