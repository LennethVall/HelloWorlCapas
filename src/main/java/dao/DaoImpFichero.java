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


public class DaoImpFichero implements Dao {

    @Override
    public Usuario iniciarSesion(String username, String password) throws Exception {
        Usuario empleado = new Usuario(
            "12345678A", "empleado", "1234", "Jon Ander",
            "jon.ander@empresa.com", "600111222", "Calle Mayor 12, Erandio",
            "EMPLEADO", "09:00 - 17:00", "Marta Gómez"
        );

        Usuario encargado = new Usuario(
            "87654321B", "encargado", "1234", "Marta Gómez",
            "marta.gomez@empresa.com", "600333444", "Avenida Ribera 5, Bilbao",
            "ENCARGADO", "08:00 - 16:00", "Carlos Ruiz"
        );
        encargado.addSubordinado(empleado);

        Usuario gerente = new Usuario(
            "11223344C", "gerente", "1234", "Carlos Ruiz",
            "carlos.ruiz@empresa.com", "600555666", "Gran Vía 45, Bilbao",
            "GERENTE", "08:00 - 16:00", "Inés Carrasco"
        );
        gerente.addSubordinado(encargado);

        Usuario jefe = new Usuario(
            "99887766D", "jefe", "1234", "Inés Carrasco",
            "ines.carrasco@empresa.com", "600777888", "Alameda Mazarredo 1, Bilbao",
            "JEFE", "08:00 - 15:00", "N/A"
        );
        jefe.addSubordinado(gerente);

        if ("empleado".equalsIgnoreCase(username) && "1234".equals(password)) return empleado;
        if ("encargado".equalsIgnoreCase(username) && "1234".equals(password)) return encargado;
        if ("gerente".equalsIgnoreCase(username) && "1234".equals(password)) return gerente;
        if ("jefe".equalsIgnoreCase(username) && "1234".equals(password)) return jefe;

        return null;
    }

    @Override
    public void actualizarDatosPersonales(String username, String email, String telefono, String direccion) throws Exception {
        System.out.println("[DAO Fichero] Datos modificados para " + username + ": " + email + ", " + telefono + ", " + direccion);
    }

    @Override
    public void actualizarHorario(String username, String nuevoHorario) throws Exception {
        System.out.println("[DAO Fichero] Horario actualizado para " + username + ": " + nuevoHorario);
    }

    @Override
    public void enviarNotificacion(String usernameDestino, String mensaje) throws Exception {
        System.out.println("[DAO Fichero - Notificación a " + usernameDestino + "]: " + mensaje);
    }
}

