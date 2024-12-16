package com.mycompany.tiendadeciclismo;

import java.io.*;
import java.util.ArrayList;

public class GestorUsuarios {
    private static final String ARCHIVO_USUARIOS = "usuarios.acc";
    private ArrayList<Usuario> usuarios;
    
    public GestorUsuarios() {
        usuarios = new ArrayList<>();
        cargarUsuarios();
    }
    
    private void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    usuarios.add(new Usuario(datos[0].trim(), datos[1].trim()));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
        }
    }
    
    public boolean validarUsuario(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.validarCredenciales(nombreUsuario, contraseña)) {
                return true;
            }
        }
        return false;
    }
}