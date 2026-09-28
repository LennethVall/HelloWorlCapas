/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import model.Usuario;

/**
 *
 * @author Lenneth
 */
public interface Dao {
    
   Usuario iniciarSesion(String username, String password) throws Exception;
    void actualizarDatosPersonales(String username, String email, String telefono, String direccion) throws Exception;
    void actualizarHorario(String username, String nuevoHorario) throws Exception;
    void enviarNotificacion(String usernameDestino, String mensaje) throws Exception;
}