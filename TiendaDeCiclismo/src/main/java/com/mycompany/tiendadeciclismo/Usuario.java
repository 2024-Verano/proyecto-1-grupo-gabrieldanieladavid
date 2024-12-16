/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendadeciclismo;

/**
 *
 * @author dnlal
 */
public class Usuario {
    private String nombreUsuario;
    private String contraseña;
    
    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public String getContraseña() {
        return contraseña;
    }
    
    public boolean validarCredenciales(String nombreUsuario, String contraseña) {
        return this.nombreUsuario.equals(nombreUsuario) && 
               this.contraseña.equals(contraseña);
    }
    
}
