/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.time.LocalDateTime;

/**
 *
 * @author NIKO
 */



public class Consume {
    private int idServicio;
    private LocalDateTime fechaReserva;
    private int dni;
    private int numHabitacion;
    private LocalDateTime fechaHoraConsumo;
    

    public Consume(int idServicio, LocalDateTime fechaReserva, int dni, int numHabitacion, LocalDateTime fechaHoraConsumo) {
        this.idServicio = idServicio;
        this.fechaReserva = fechaReserva;
        this.dni = dni;
        this.numHabitacion = numHabitacion;
        this.fechaHoraConsumo = fechaHoraConsumo;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public LocalDateTime getFechaHoraConsumo() {
        return fechaHoraConsumo;
    }

    public void setFechaHoraConsumo(LocalDateTime fechaHoraConsumo) {
        this.fechaHoraConsumo = fechaHoraConsumo;
    }


}

