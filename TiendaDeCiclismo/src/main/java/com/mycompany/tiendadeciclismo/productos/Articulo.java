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
/**
 * La clase Articulo representa un artículo con diversas propiedades como código,
 * tipo, nombre, tamaño, marca, precio y cantidad. Permite inicializar y gestionar
 * los datos de un artículo.
 */
public class Articulo {

    /////////////////// Atributos //////////////////////

    /**
     * Código único del artículo.
     */
    private int codigo;

    /**
     * Código del tipo de producto al que pertenece el artículo.
     */
    private int codigoTipoProducto;

    /**
     * Nombre del artículo.
     */
    private String nombre;

    /**
     * Tipo o categoría del artículo.
     */
    private String tipo;

    /**
     * Tamaño del artículo.
     */
    private float tamano;

    /**
     * Marca del artículo.
     */
    private String marca;

    /**
     * Precio del artículo.
     */
    private int precio;

    /**
     * Cantidad disponible del artículo.
     */
    private int cantidad;

    /////////////////// Métodos ////////////////////////

    /**
     * Constructor que inicializa un objeto Articulo basado en una lista de artículos.
     * Genera automáticamente el código del artículo en función de la cantidad
     * de artículos en la lista proporcionada.
     *
     * @param listaArticulos Lista de artículos existentes.
     * @param TPcodigo Código del tipo de producto.
     * @param nombre Nombre del artículo.
     * @param tipo Tipo o categoría del artículo.
     * @param tamano Tamaño del artículo.
     * @param marca Marca del artículo.
     * @param precio Precio del artículo.
     * @param cantidad Cantidad disponible del artículo.
     */
    public Articulo(ArrayList<Articulo> listaArticulos, int TPcodigo, String nombre, String tipo, float tamano, String marca, int precio, int cantidad) {
        int contador = 0;
        for (Articulo x : listaArticulos) {
            contador = contador + 1;
        }
        this.codigo = contador;
        this.codigoTipoProducto = TPcodigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tamano = tamano;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * Constructor que inicializa un objeto Articulo con todos los parámetros específicos.
     *
     * @param codigo Código único del artículo.
     * @param TPcodigo Código del tipo de producto.
     * @param nombre Nombre del artículo.
     * @param tipo Tipo o categoría del artículo.
     * @param tamano Tamaño del artículo.
     * @param marca Marca del artículo.
     * @param precio Precio del artículo.
     * @param cantidad Cantidad disponible del artículo.
     */
    public Articulo(int codigo, int TPcodigo, String nombre, String tipo, float tamano, String marca, int precio, int cantidad) {
        this.codigo = codigo;
        this.codigoTipoProducto = TPcodigo;
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

    public float getTamano() {
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

    public void setTamano(float tamano) {
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
    
    @Override
    public String toString(){
        return "" + codigo + "," + codigoTipoProducto + "," + nombre + "," + tipo + "," + tamano + "," + marca + "," + precio + "," + cantidad; 
    }
}


