/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Dao;
import dao.DaoImpBD;
import dao.DaoImpFichero;
import java.io.InputStream;
import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Sesion;
import model.Usuario;

/**
 *
 * @author Lenneth
 */
public class LoginController {
   

    @FXML private TextField txtUser;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblError;

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = txtUser.getText().trim();
        String password = txtPassword.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            lblError.setText("Por favor, introduce usuario y contraseña.");
            return;
        }

        try {
            // Lectura directa de propiedades
            Properties prop = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
            
            Dao dao;
            if (input != null) {
                prop.load(input);
                String tipo = prop.getProperty("dao.type", "fichero");
                if ("bd".equalsIgnoreCase(tipo)) {
                    dao = new DaoImpBD();
                } else {
                    dao = new DaoImpFichero();
                }
            } else {
                dao = new DaoImpFichero();
            }

            // Validar login
            Usuario usuario = dao.iniciarSesion(username, password);

            if (usuario != null) {
                // Guardar en el Singleton de Sesion
                Sesion.getInstancia().setUsuarioLogueado(usuario);

                // Cargar vista principal
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainView.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) txtUser.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Gestión de Usuarios y Horarios - " + usuario.getRol());
            } else {
                lblError.setText("Usuario o contraseña incorrectos.");
            }
        } catch (Exception e) {
            lblError.setText("Error al conectar con la fuente de datos.");
            e.printStackTrace();
        }
    }
}