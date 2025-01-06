/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendadeciclismo;


import java.util.Date;

/**
 * Representa un cliente de una tienda de ciclismo.
 * Esta clase almacena información personal y de contacto del cliente,
 * así como su ubicación y fecha de nacimiento.
 * @author dnlal
 */
public class Cliente {
    /**
     * Atributos
     * Código único que identifica al cliente.
     */
    private int codigo;
    /**
     * Nombre del cliente.
     */
    private String nombre;
    /**
     * Apellidos del cliente.
     */
    private String apellidos;
    /**
     * Número de teléfono del cliente.
     */
    private String telefono;
    /**
     * Dirección de correo electrónico del cliente.
     */
    private String correo;
    /**
     * Provincia donde reside el cliente.
     */
    private String provincia;
    /**
     * Cantón donde reside el cliente.
     */
    private String canton;
    /**
     * Distrito donde reside el cliente.
     */
    private String distrito;
    /**
     * Fecha de nacimiento del cliente.
     */
    private Date fechaNacimiento;

        /**
     * Constructor que inicializa un nuevo cliente con la información proporcionada.
     * 
     * @param codigo Código exclusivo del cliente.
     * @param nombre Nombre del cliente.
     * @param apellidos Apellidos del cliente.
     * @param telefono Número de teléfono del cliente.
     * @param correo Correo electrónico del cliente.
     * @param provincia Provincia donde reside el cliente.
     * @param canton Cantón donde reside el cliente.
     * @param distrito Distrito donde reside el cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     */
    public Cliente(int codigo, String nombre, String apellidos, String telefono, 
                  String correo, String provincia, String canton, String distrito, 
                  Date fechaNacimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.fechaNacimiento = fechaNacimiento;
    }
    
        // Métodos getter
    /**
     * Obtiene el código del cliente.
     * 
     * @return El código del cliente.
     */
    public int getCodigo() { return codigo; }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return El nombre del cliente.
     */
    public String getNombre() { return nombre; }
    
    /**
     * Obtiene los apellidos del cliente.
     * 
     * @return Los apellidos del cliente.
     */
    public String getApellidos() { return apellidos; }
    
    /**
     * Obtiene el número de teléfono del cliente.
     * 
     * @return El número de teléfono del cliente.
     */
    public String getTelefono() { return telefono; }
   
    /**
     * Obtiene el correo electrónico del cliente.
     * 
     * @return El correo electrónico del cliente.
     */
    public String getCorreo() { return correo; }
    
    /**
     * Obtiene la provincia de residencia del cliente.
     * 
     * @return La provincia de residencia del cliente.
     */
    public String getProvincia() { return provincia; }
    
    /**
     * Obtiene el cantón de residencia del cliente.
     * 
     * @return El cantón de residencia del cliente.
     */
    public String getCanton() { return canton; }
    
    /**
     * Obtiene el distrito de residencia del cliente.
     * 
     * @return El distrito de residencia del cliente.
     */
    public String getDistrito() { return distrito; }
    
    /**
     * Obtiene la fecha de nacimiento del cliente.
     * 
     * @return La fecha de nacimiento del cliente.
     */
    public Date getFechaNacimiento() { return fechaNacimiento; }
    
    /**
     * Retorna una representación en cadena del cliente, con sus datos
     * separados por comas.
     * 
     * @return Una cadena con la información del cliente en formato CSV.
     */
    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%tF", 
            codigo, nombre, apellidos, telefono, correo, 
            provincia, canton, distrito, fechaNacimiento);
    }
}
