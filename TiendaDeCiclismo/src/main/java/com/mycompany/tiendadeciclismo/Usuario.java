/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendadeciclismo;

/**
 * Clase que crea objetos con el valor de usuarios para el programa, contiene el nombre de usuario 
 * y la contraseña para ingresar al programa.
 * @author dnlal
 */
public class Usuario {
    /**
     * El nombre de usuario para ingresar al programa.
     */
    private String nombreUsuario;
    /**
     * Contraseña del usuario para ingresar al programa.
     */
    private String contraseña;
    
    /**
     * Constructor que genera los usuarios de el programa con la información proporcionada.
     * @param nombreUsuario Nombre de usuario.
     * @param contraseña Contraseña del usuario.
     */
    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }
    
    /**getters
     * 
     * getter del nombre de usuario.
     * @return nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    /**
     * getter de la contraseña.
     * @return contraseña.
     */
    public String getContraseña() {
        return contraseña;
    }
    
    /**
     * Metodó para validar las credenciales de el usuario.
     * @param nombreUsuario nombre de usuario ingresado.
     * @param contraseña contraseña ingresada.
     * @return retorna un booleano como true si las credenciales ingresadas son validas como un 
     * usuario valido y false si no existe.
     */
    public boolean validarCredenciales(String nombreUsuario, String contraseña) {
        return this.nombreUsuario.equals(nombreUsuario) && 
               this.contraseña.equals(contraseña);
    }
    
}
