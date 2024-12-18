/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendadeciclismo;


import java.util.Date;

/**
 *
 * @author dnlal
 */
public class Cliente {
    private int codigo;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correo;
    private String provincia;
    private String canton;
    private String distrito;
    private Date fechaNacimiento;
    
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
    
    // Getters y setters
    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getProvincia() { return provincia; }
    public String getCanton() { return canton; }
    public String getDistrito() { return distrito; }
    public Date getFechaNacimiento() { return fechaNacimiento; }
    
    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%tF", 
            codigo, nombre, apellidos, telefono, correo, 
            provincia, canton, distrito, fechaNacimiento);
    }
}
