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
    private LocalDateTime fechaLlegada;
    private int DNI;
    private int idHabitacion;
    private LocalDateTime fechaUso;
    

    public Consume(int idServicio, LocalDateTime fechaLlegada, int DNI, int idHabitación, LocalDateTime fechaUso) {
        this.idServicio = idServicio;
        this.fechaLlegada = fechaLlegada;
        this.DNI = DNI;
        this.idHabitacion = idHabitación;
        this.fechaUso = fechaUso;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public LocalDateTime getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(LocalDateTime fechaUso) {
        this.fechaUso = fechaUso;
    }


}

