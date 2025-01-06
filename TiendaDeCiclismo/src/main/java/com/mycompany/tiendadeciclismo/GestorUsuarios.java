package com.mycompany.tiendadeciclismo;

import java.io.*;
import java.util.ArrayList;
/**
 * 
 * Gestor que maneja los usuarios, los guarda o los lee desde un archivo llamado usuarios.acc .
 */
public class GestorUsuarios {
    /**
     * Nombre del archivo donde se guardan los archivos.
     */
    private static final String ARCHIVO_USUARIOS = "usuarios.acc";
    /**
     * Una lista con los usuarios del programa.
     */
    private ArrayList<Usuario> usuarios;
    
    /**
     * Constructor de la clase, al llamarla inicia una lista vacia y luego carga los usuarios en esta.
     */
    public GestorUsuarios() {
        usuarios = new ArrayList<>();
        cargarUsuarios();
    }
    
    /**
     * Metodo que carga los usuarios a una lista llamada usuarios.
     */
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
    
    /**
     * Valida que el usuario ingresado sea uno existente.
     * @param nombreUsuario nombre del usuario.
     * @param contraseña contraseña del usuario.
     * @return retorna true si existe y false si no existe.
     */
    public boolean validarUsuario(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.validarCredenciales(nombreUsuario, contraseña)) {
                return true;
            }
        }
        return false;
    }
}