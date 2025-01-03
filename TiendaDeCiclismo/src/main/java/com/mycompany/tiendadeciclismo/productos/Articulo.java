/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendadeciclismo.productos;
import java.util.ArrayList;
/**
 *
 * @author david
 */
public class Articulo {
    ///////////////// Atributos //////////////////////
    private int codigo;
    private int codigoTipoProducto;
    private String nombre;
    private String tipo;
    private int tamano;
    private String marca;
    private int precio;
    private int cantidad;
    
 //////////////////// Metodos ////////////////////////
    public Articulo(ArrayList<Articulo> ListaArticulos, int TPcodigo, String nombre, String tipo, int tamano, String marca, int precio, int cantidad){
        int contador = 0; 
        for (Articulo x : ListaArticulos ){
            contador = contador + 1;
        }
        
        codigoTipoProducto = TPcodigo;
        
        this.nombre = nombre;
        this.tipo = tipo;
        this.tamano = tamano;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
        
        
     
    }
    
    
    
    // Getters
    public int getCodigo() {
        return codigo;
    }

    public int getCodigoTipoProducto() {
        return codigoTipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getTamano() {
        return tamano;
    }

    public String getMarca() {
        return marca;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    
    //////////////// Setters /////////////////////////
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCodigoTipoProducto(int codigoTipoProducto) {
        this.codigoTipoProducto = codigoTipoProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}


