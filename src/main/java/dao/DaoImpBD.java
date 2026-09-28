/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Usuario;
/**
 *
 * @author Lenneth
 */


public class DaoImpBD implements Dao {

    @Override
    public Usuario iniciarSesion(String username, String password) throws Exception {
        if ("admin".equalsIgnoreCase(username) && "1234".equals(password)) {
            return new Usuario(
                "00000000X", "admin", "1234", "Administrador Sistema BD",
                "admin@empresa.com", "600000000", "Plaza Moyúa 1, Bilbao",
                "JEFE", "08:00 - 15:00", "N/A"
            );
        }
        return null;
    }

    @Override
    public void actualizarDatosPersonales(String username, String email, String telefono, String direccion) throws Exception {
        System.out.println("[DAO BD] UPDATE usuarios SET email='" + email + "', telefono='" + telefono + "', direccion='" + direccion + "' WHERE username='" + username + "'");
    }

    @Override
    public void actualizarHorario(String username, String nuevoHorario) throws Exception {
        System.out.println("[DAO BD] UPDATE horarios SET horario='" + nuevoHorario + "' WHERE username='" + username + "'");
    }

    @Override
    public void enviarNotificacion(String usernameDestino, String mensaje) throws Exception {
        System.out.println("[DAO BD] INSERT INTO notificaciones (destino, mensaje) VALUES ('" + usernameDestino + "', '" + mensaje + "')");
    }
}
