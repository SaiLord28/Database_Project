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



public class Atiende {
    private int DNI;
    private int DNIEmpleado;
    private int idArea;
    private int idHabitacion;
    private int idServicio;
    private LocalDateTime fechaLlegada;
    private LocalDateTime fechaUso;

    public Atiende(int DNI, int DNIEmpleado, int idArea, int idHabitacion, int idServicio,
                   LocalDateTime fechaLlegada, LocalDateTime fechaUso) {
        this.DNI = DNI;
        this.DNIEmpleado = DNIEmpleado;
        this.idArea = idArea;
        this.idHabitacion = idHabitacion;
        this.idServicio = idServicio;
        this.fechaLlegada = fechaLlegada;
        this.fechaUso = fechaUso;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getDNIEmpleado() {
        return DNIEmpleado;
    }

    public void setDNIEmpleado(int DNIEmpleado) {
        this.DNIEmpleado = DNIEmpleado;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
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

    public LocalDateTime getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(LocalDateTime fechaUso) {
        this.fechaUso = fechaUso;
    }


}

