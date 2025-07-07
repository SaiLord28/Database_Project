/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Hotel;

import DAO.AtiendeDAO;
import DAO.ClienteDAO;
import DAO.ConsumeDAO;
import DAO.EmailClienteDAO;
import DAO.EmailEmpleadoDAO;
import DAO.EmpleadoDAO;
import DAO.HabitacionDAO;
import DAO.ReservaDAO;
import DAO.ServicioDAO;
import DAO.TelefonoClienteDAO;
import DAO.TelefonoEmpleadoDAO;
import static Hotel.Input.leerTexto;
import static Hotel.Input.leerEntero;
import Modelo.Atiende;
import Modelo.Cliente;
import Modelo.Consume;
import Modelo.Empleado;
import Modelo.Habitacion;
import Modelo.Reserva;
import Modelo.Servicio;
import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;
import java.sql.*;
import java.time.LocalDateTime;

/**
 *
 * @author NIKO
 */


public class Main {
    
public static void main(String[] args) {
        while (true) {
            System.out.println("\n========== SISTEMA DE GESTIÓN HOTELERA ==========");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Empleados");
            System.out.println("3. Gestión de Habitaciones");
            System.out.println("4. Gestión de Reservas");
            System.out.println("5. Gestión de Servicios");
            System.out.println("6. Gestión de Consumos");
            System.out.println("7. Gestión de Atenciones");
            System.out.println("8. Gestión de Contactos");
            System.out.println("9. Consultas (vistas)");
            System.out.println("0. Salir");
            System.out.println("==============================================");
            int opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> menuCliente();
                case 2 -> menuEmpleado();
                case 3 -> menuHabitacion();
                case 4 -> menuReserva();
                case 5 -> menuServicio();
                case 6 -> menuConsumo();
                case 7 -> menuAtiende();
                case 8 -> menuContacto();
                case 9 -> menuConsulta();
                case 0 -> {
                    System.out.println("¡Hasta luego!");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
    

public static void menuCliente() {
    ClienteDAO dao = new ClienteDAO();
    while (true) {
        System.out.println("\n=== Gestión de Clientes ===");
        System.out.println("1. Insertar cliente");
        System.out.println("2. Listar todos los clientes");
        System.out.println("3. Buscar cliente por DNI");
        System.out.println("4. Actualizar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("0. Volver");
        int op = leerEntero("Seleccione una opción: ");

        switch (op) {
            case 1 -> dao.insertar();
            case 2 -> dao.listarTodos();
            case 3 -> {
                int dni = leerEntero("Ingrese DNI del cliente: ");
                dao.buscarPorDNI(dni);
            }
            case 4 -> {
                int dni = leerEntero("Ingrese DNI del cliente a actualizar: ");
                dao.actualizar(dni);
            }
            case 5 -> {
                int dni = leerEntero("Ingrese DNI del cliente a eliminar: ");
                dao.eliminar(dni);
            }
            case 0 -> {
                return;
            }
            default -> System.out.println("Opción inválida.");
        }
    }
}

    public static void menuEmpleado() {
        
        
    EmpleadoDAO dao = new EmpleadoDAO();
    while (true) {
        System.out.println("\n=== GESTIÓN DE EMPLEADOS ===");
        System.out.println("1. Insertar empleado");
        System.out.println("2. Listar empleados");
        System.out.println("3. Eliminar empleado");
        System.out.println("0. Volver");
        int op = Input.leerEntero("Opción: ");
        switch (op) {
            case 1:
                int dni = Input.leerEntero("DNI: ");
                String nombre = Input.leerTexto("Nombre: ");
                String segundoNombre = Input.leerTexto("Segundo Nombre2: ");
                String apellido1 = Input.leerTexto("Primer Apellido: ");
                String apellido2 = Input.leerTexto("Segundo Apellido: ");
                String calle = Input.leerTexto("Calle: ");
                String carrera = Input.leerTexto("Carrera: ");
                String numero = Input.leerTexto("Número: ");
                String cargo = Input.leerTexto("Cargo: ");
                int idArea = Input.leerEntero("ID Área: ");
                Empleado e = new Empleado(dni, nombre, segundoNombre, apellido1, apellido2, calle, carrera, numero, cargo, idArea);
                dao.insertar(e);
                break;
            case 2:
                dao.listar();
                break;
            case 3:
                int eliminarDni = Input.leerEntero("DNI del empleado a eliminar: ");
                dao.eliminar(eliminarDni);
                break;
            case 0:
                return;
            default:
                System.out.println("Opción inválida.");
        }
    }
}
    
    public static void menuServicio() {
    ServicioDAO dao = new ServicioDAO();
    while (true) {
        System.out.println("\n=== GESTIÓN DE SERVICIOS ===");
        System.out.println("1. Insertar servicio");
        System.out.println("2. Listar servicios");
        System.out.println("3. Actualizar servicio");
        System.out.println("4. Eliminar servicio");
        System.out.println("0. Volver");
        int op = Input.leerEntero("Opción: ");
        switch (op) {
            case 1:
                int id = Input.leerEntero("ID: ");
                String nombre = Input.leerTexto("Nombre: ");
                String detalle = Input.leerTexto("Detalle: ");
                int precio = Input.leerEntero("Precio: ");
                Servicio nuevo = new Servicio(id, nombre, detalle, precio);
                dao.insertar(nuevo);
                break;
            case 2:
                dao.listar();
                break;
            case 3:
                int idAct = Input.leerEntero("ID del servicio a actualizar: ");
                String nuevoNombre = Input.leerTexto("Nuevo nombre: ");
                String nuevoDetalle = Input.leerTexto("Nuevo detalle: ");
                int nuevoPrecio = Input.leerEntero("Nuevo precio: ");
                Servicio actualizado = new Servicio(idAct, nuevoNombre, nuevoDetalle, nuevoPrecio);
                dao.actualizar(actualizado);
                break;
            case 4:
                int eliminarId = Input.leerEntero("ID a eliminar: ");
                dao.eliminar(eliminarId);
                break;
            case 0:
                return;
            default:
                System.out.println("Opción inválida.");
        }
    }
}
    
    public static void menuReserva() {
    ReservaDAO dao = new ReservaDAO();

    while (true) {
        System.out.println("\n=== GESTIÓN DE RESERVAS ===");
        System.out.println("1. Insertar reserva");
        System.out.println("2. Listar reservas");
        System.out.println("3. Eliminar reserva");
        System.out.println("0. Volver");
        int op = Input.leerEntero("Opción: ");
        switch (op) {
            case 1:
                int dni = Input.leerEntero("DNI Cliente: ");
                int habitacion = Input.leerEntero("Número de habitación: ");
                String fechaEntradaStr = Input.leerTexto("Fecha entrada (yyyy-MM-dd HH:mm): ");
                String fechaSalidaStr = Input.leerTexto("Fecha salida (yyyy-MM-dd HH:mm): ");
                LocalDateTime entrada = LocalDateTime.parse(fechaEntradaStr.replace(" ", "T"));
                LocalDateTime salida = LocalDateTime.parse(fechaSalidaStr.replace(" ", "T"));
                Reserva r = new Reserva(dni, habitacion, entrada, salida);
                dao.insertar(r);
                break;
            case 2:
                dao.listar();
                break;
            case 3:
                int dniE = Input.leerEntero("DNI Cliente: ");
                int habitacionE = Input.leerEntero("Número de habitación: ");
                String fechaE = Input.leerTexto("Fecha entrada (yyyy-MM-dd HH:mm): ");
                LocalDateTime fechaEntradaE = LocalDateTime.parse(fechaE.replace(" ", "T"));
                dao.eliminar(dniE, habitacionE, fechaEntradaE);
                break;
            case 0:
                return;
            default:
                System.out.println("Opción inválida.");
        }
    }
}
    
    public static void menuHabitacion() {
    HabitacionDAO dao = new HabitacionDAO();
    while (true) {
        System.out.println("\n=== GESTIÓN DE HABITACIONES ===");
        System.out.println("1. Insertar habitación");
        System.out.println("2. Listar habitaciones");
        System.out.println("3. Eliminar habitación");
        System.out.println("0. Volver");
        int op = Input.leerEntero("Opción: ");
        switch (op) {
            case 1:
                int numero = Input.leerEntero("Número de habitación: ");
                int idCategoria = Input.leerEntero("ID de la categoría: ");
                Habitacion h = new Habitacion(numero, idCategoria);
                dao.insertar(h);
                break;
            case 2:
                dao.listar();
                break;
            case 3:
                int eliminarNum = Input.leerEntero("Número a eliminar: ");
                dao.eliminar(eliminarNum);
                break;
            case 0:
                return;
            default:
                System.out.println("Opción inválida.");
        }
    }
}

public static void menuConsumo() {
    ConsumeDAO dao = new ConsumeDAO();

    while (true) {
        System.out.println("\n=== REGISTRO DE CONSUMOS ===");
        System.out.println("1. Registrar consumo");
        System.out.println("2. Listar consumos");
        System.out.println("3. Eliminar consumo");
        System.out.println("0. Volver");
        int op = Input.leerEntero("Opción: ");
        switch (op) {
            case 1:
                int idServ = Input.leerEntero("ID del servicio: ");
                String fechaReservaStr = Input.leerTexto("Fecha de la reserva (yyyy-MM-dd HH:mm): ");
                int dni = Input.leerEntero("DNI del cliente: ");
                int habitacion = Input.leerEntero("Número de habitación: ");
                String fechaConsumoStr = Input.leerTexto("Fecha del consumo (yyyy-MM-dd HH:mm): ");
                LocalDateTime fechaReserva = LocalDateTime.parse(fechaReservaStr.replace(" ", "T"));
                LocalDateTime fechaConsumo = LocalDateTime.parse(fechaConsumoStr.replace(" ", "T"));
                Consume nuevo = new Consume(idServ, fechaReserva, dni, habitacion, fechaConsumo);
                dao.insertar(nuevo);
                break;
            case 2:
                dao.listar();
                break;
            case 3:
                int idEliminar = Input.leerEntero("ID del servicio: ");
                String fechaReservaE = Input.leerTexto("Fecha de la reserva (yyyy-MM-dd HH:mm): ");
                int dniE = Input.leerEntero("DNI del cliente: ");
                int habitacionE = Input.leerEntero("Habitación: ");
                LocalDateTime fechaReservaDel = LocalDateTime.parse(fechaReservaE.replace(" ", "T"));
                dao.eliminar(idEliminar, fechaReservaDel, dniE, habitacionE);
                break;
            case 0:
                return;
            default:
                System.out.println("Opción inválida.");
        }
    }
}

public static void menuAtiende() {
    AtiendeDAO dao = new AtiendeDAO();
    while (true) {
        System.out.println("\n=== GESTIÓN DE ATENCIONES ===");
        System.out.println("1. Registrar atención");
        System.out.println("2. Listar atenciones");
        System.out.println("3. Eliminar atención");
        System.out.println("0. Volver");
        int op = Input.leerEntero("Opción: ");
        switch (op) {
            case 1:
                int dniC = Input.leerEntero("DNI del cliente: ");
                int dniE = Input.leerEntero("DNI del empleado: ");
                int area = Input.leerEntero("ID del área: ");
                int hab = Input.leerEntero("Número de habitación: ");
                int serv = Input.leerEntero("ID del servicio: ");
                String fInicio = Input.leerTexto("Fecha inicio (yyyy-MM-dd HH:mm): ");
                String fFin = Input.leerTexto("Fecha fin (yyyy-MM-dd HH:mm): ");
                LocalDateTime inicio = LocalDateTime.parse(fInicio.replace(" ", "T"));
                LocalDateTime fin = LocalDateTime.parse(fFin.replace(" ", "T"));
                Atiende a = new Atiende(dniC, dniE, area, hab, serv, inicio, fin);
                dao.insertar(a);
                break;
            case 2:
                dao.listar();
                break;
            case 3:
                int dniCE = Input.leerEntero("DNI del cliente: ");
                int dniEE = Input.leerEntero("DNI del empleado: ");
                String fechaIE = Input.leerTexto("Fecha inicio (yyyy-MM-dd HH:mm): ");
                LocalDateTime fechaInicioE = LocalDateTime.parse(fechaIE.replace(" ", "T"));
                dao.eliminar(dniCE, dniEE, fechaInicioE);
                break;
            case 0:
                return;
            default:
                System.out.println("Opción inválida.");
        }
    }
}

public static void menuContacto() {
    while (true) {
        System.out.println("\n=== Gestión de Contactos ===");
        System.out.println("1. Email de Cliente");
        System.out.println("2. Teléfono de Cliente");
        System.out.println("3. Email de Empleado");
        System.out.println("4. Teléfono de Empleado");
        System.out.println("0. Volver");
        int op = leerEntero("Seleccione una opción: ");

        switch (op) {
            case 1 -> menuEmailCliente();
            case 2 -> menuTelefonoCliente();
            case 3 -> menuEmailEmpleado();
            case 4 -> menuTelefonoEmpleado();
            case 0 -> {
                return;
            }
            default -> System.out.println("Opción inválida.");
        }
    }
}

public static void menuEmailCliente() {
    EmailClienteDAO dao = new EmailClienteDAO();
    while (true) {
        System.out.println("\n--- Email de Cliente ---");
        System.out.println("1. Agregar email");
        System.out.println("2. Listar emails por DNI");
        System.out.println("3. Eliminar email");
        System.out.println("0. Volver");
        int op = leerEntero("Opción: ");

        switch (op) {
            case 1 -> {
                int dni = leerEntero("DNI del cliente: ");
                String email = leerTexto("Email: ");
                dao.insertar(dni, email);
            }
            case 2 -> {
                int dni = leerEntero("DNI del cliente: ");
                dao.listarPorDNI(dni);
            }
            case 3 -> {
                int dni = leerEntero("DNI del cliente: ");
                String email = leerTexto("Email a eliminar: ");
                dao.eliminar(dni, email);
            }
            case 0 -> { return; }
            default -> System.out.println("Opción inválida.");
        }
    }
}

public static void menuTelefonoCliente() {
    TelefonoClienteDAO dao = new TelefonoClienteDAO();
    while (true) {
        System.out.println("\n--- Teléfono de Cliente ---");
        System.out.println("1. Agregar teléfono");
        System.out.println("2. Listar teléfonos por DNI");
        System.out.println("3. Eliminar teléfono");
        System.out.println("0. Volver");
        int op = leerEntero("Opción: ");

        switch (op) {
            case 1 -> {
                int dni = leerEntero("DNI del cliente: ");
                String tel = leerTexto("Teléfono: ");
                dao.insertar(dni, tel);
            }
            case 2 -> {
                int dni = leerEntero("DNI del cliente: ");
                dao.listarPorDNI(dni);
            }
            case 3 -> {
                int dni = leerEntero("DNI del cliente: ");
                String tel = leerTexto("Teléfono a eliminar: ");
                dao.eliminar(dni, tel);
            }
            case 0 -> { return; }
            default -> System.out.println("Opción inválida.");
        }
    }
}
    
    public static void menuEmailEmpleado() {
    EmailEmpleadoDAO dao = new EmailEmpleadoDAO();
    while (true) {
        System.out.println("\n--- Email de Empleado ---");
        System.out.println("1. Agregar email");
        System.out.println("2. Listar emails por DNI");
        System.out.println("3. Eliminar email");
        System.out.println("0. Volver");
        int op = leerEntero("Opción: ");

        switch (op) {
            case 1 -> {
                int dni = leerEntero("DNI del empleado: ");
                String email = leerTexto("Email: ");
                dao.insertar(dni, email);
            }
            case 2 -> {
                int dni = leerEntero("DNI del empleado: ");
                dao.listarPorDNI(dni);
            }
            case 3 -> {
                int dni = leerEntero("DNI del empleado: ");
                String email = leerTexto("Email a eliminar: ");
                dao.eliminar(dni, email);
            }
            case 0 -> { return; }
            default -> System.out.println("Opción inválida.");
        }
    }
}
    
 public static void menuTelefonoEmpleado() {
    TelefonoEmpleadoDAO dao = new TelefonoEmpleadoDAO();
    while (true) {
        System.out.println("\n--- Teléfono de Empleado ---");
        System.out.println("1. Agregar teléfono");
        System.out.println("2. Listar teléfonos por DNI");
        System.out.println("3. Eliminar teléfono");
        System.out.println("0. Volver");
        int op = leerEntero("Opción: ");

        switch (op) {
            case 1 -> {
                int dni = leerEntero("DNI del empleado: ");
                String tel = leerTexto("Teléfono: ");
                dao.insertar(dni, tel);
            }
            case 2 -> {
                int dni = leerEntero("DNI del empleado: ");
                dao.listarPorDNI(dni);
            }
            case 3 -> {
                int dni = leerEntero("DNI del empleado: ");
                String tel = leerTexto("Teléfono a eliminar: ");
                dao.eliminar(dni, tel);
            }
            case 0 -> { return; }
            default -> System.out.println("Opción inválida.");
        }
    }
}
   
 public static void menuConsulta() {
    while (true) {
        System.out.println("\n=== Consultas del Sistema ===");
        System.out.println("1. Ver reservas y su límite para cancelar (Cancelacion)");
        System.out.println("2. Ver tipo de cliente (VistaTipoCliente)");
        System.out.println("3. Ver estado y disponibilidad de habitaciones (HabitacionConEstado)");
        System.out.println("4. Ver datos precio y noches de la reserva");
        System.out.println("5. Ver consumos registrados (Ver consumos)");
        System.out.println("6. Actualizar y eliminar empleado");
        System.out.println("7. Actualizar y eliminar servicio");
        System.out.println("8. Ver consumo por cliente (ConsumoCliente)");
        System.out.println("0. Volver");
        int op = leerEntero("Seleccione una opción: ");

        switch (op) {
            case 1 -> mostrarVista("Cancelacion");
            case 2 -> mostrarVista("VistaTipoCliente");
            case 3 -> mostrarVista("HabitacionConEstado");
            case 4 -> mostrarConsultaPrecioReserva();
            case 5 -> mostrarVista("Consume");
            case 6 -> mostrarVista("Empleado");
            case 7 -> mostrarVista("Servicio");
            case 8 -> mostrarVista("ConsumoCliente");
            case 0 -> {
                return;
            }
            default -> System.out.println("Opción inválida.");
        }
    }
}
 
 public static void mostrarVista(String nombreVista) {
    String sql = "SELECT * FROM " + nombreVista;
    try (java.sql.Connection conn = Conexion.getConexion();
         java.sql.Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        ResultSetMetaData meta = rs.getMetaData();
        int columnas = meta.getColumnCount();

        System.out.println("\n--- Resultados de " + nombreVista + " ---");
        while (rs.next()) {
            for (int i = 1; i <= columnas; i++) {
                System.out.print(meta.getColumnLabel(i) + ": " + rs.getString(i) + "\t");
            }
            System.out.println();
        }

    } catch (SQLException e) {
        System.out.println("Error al consultar " + nombreVista + ": " + e.getMessage());
    }
}

public static void mostrarConsultaPrecioReserva() {
    String sql = """
        SELECT 
            R.DNI AS cliente,
            R.idHabitacion,
            R.precioReserva,
            R.fechaLlegada,
            R.fechaSalida,
            (fechaSalida::date - fechaLlegada::date) AS cantidadNoches,
            ((fechaSalida::date - fechaLlegada::date) * R.precioReserva) AS totalEstimado
        FROM Reserva R;
    """;

    try (java.sql.Connection conn = Conexion.getConexion();
         java.sql.Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        System.out.println("\n--- Noches y precio estimado por reserva ---");
        while (rs.next()) {
            System.out.printf("Cliente: %d, Habitación: %d, Precio/Noche: %d, Noches: %d, Total: %d%n",
                    rs.getInt("cliente"),
                    rs.getInt("idHabitacion"),
                    rs.getInt("precioReserva"),
                    rs.getInt("cantidadNoches"),
                    rs.getInt("totalEstimado"));
        }

    } catch (SQLException e) {
        System.out.println("Error en consulta personalizada: " + e.getMessage());
    }
}


}





