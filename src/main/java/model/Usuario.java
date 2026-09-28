/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenneth
 */
public class Usuario {

    private String dni;
    private String username;
    private String password;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String rol; // "EMPLEADO", "ENCARGADO", "GERENTE", "JEFE"
    private String horario;
    private String jefeDirecto;
    private List<Usuario> subordinados;
    private List<String> notificaciones;

    public Usuario() {
        this.subordinados = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    public Usuario(String dni, String username, String password, String nombre, String email, String telefono, String direccion, String rol, String horario, String jefeDirecto) {
        this.dni = dni;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rol = rol;
        this.horario = horario;
        this.jefeDirecto = jefeDirecto;
        this.subordinados = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public String getJefeDirecto() { return jefeDirecto; }
    public void setJefeDirecto(String jefeDirecto) { this.jefeDirecto = jefeDirecto; }

    public List<Usuario> getSubordinados() { return subordinados; }
    public void setSubordinados(List<Usuario> subordinados) { this.subordinados = subordinados; }

    public void addSubordinado(Usuario subordinado) {
        this.subordinados.add(subordinado);
    }

    public List<String> getNotificaciones() { return notificaciones; }
    public void addNotificacion(String mensaje) {
        this.notificaciones.add(mensaje);
    }

    @Override
    public String toString() {
        return nombre + " (" + rol + ")";
    }
}