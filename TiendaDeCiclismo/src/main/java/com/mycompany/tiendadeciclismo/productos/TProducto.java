
package com.mycompany.tiendadeciclismo.productos;
import java.util.ArrayList;
/**
 * Clase que representa un tipo de producto para los artículos de la tienda.
 * Proporciona funcionalidad para asignar un código único a cada tipo de producto
 * y verificar la validez de su nombre.
 */
public class TProducto {

    /////////////////// Atributos //////////////////////

    /**
     * Código único del tipo de producto, se incrementa automáticamente de 1 en 1.
     */
    private int codigo;

    /**
     * Nombre del tipo de producto. Debe ser una cadena de texto no vacía
     * y sin espacios en blanco en los extremos.
     */
    private String nombre;

    /////////////////// Métodos ////////////////////////

    /**
     * Constructor que inicializa un objeto TProducto basado en una lista existente de tipos de productos.
     * Asigna automáticamente el código en función de la cantidad de productos en la lista.
     *
     * @param listaTipoProductos Lista de los tipos de productos ya creados.
     * @param Pnombre Nombre del tipo de producto.
     */
    public TProducto(ArrayList<TProducto> listaTipoProductos, String Pnombre) {
        int contador = 0;

        // Ciclo para contar los productos existentes y asignar el código.
        for (TProducto x : listaTipoProductos) {
            contador = contador + 1;
        }
        this.codigo = contador;
        this.nombre = Pnombre;
    }

    /**
     * Constructor que inicializa un objeto TProducto con parámetros específicos.
     *
     * @param codigo Código único del tipo de producto (como cadena de texto).
     * @param nombre Nombre del tipo de producto.
     */
    public TProducto(String codigo, String nombre) {
        this.codigo = Integer.parseInt(codigo);
        this.nombre = nombre;
    }

    /**
     * Método estático para verificar que el nombre del producto no contenga
     * espacios en blanco en sus extremos.
     *
     * @param nombre Nombre del tipo de producto a verificar.
     * @return true si el nombre no tiene espacios en los extremos; false en caso contrario.
     */
    public static boolean verificarNombre(String nombre) {
        // Se usa trim para eliminar los espacios en blanco en los extremos.
        String copiaString = nombre.trim();

        // Se compara la cadena original con su versión sin espacios en los extremos.
        return nombre.equals(copiaString);
    }
     // Getters y Setters
    public int getCodigo() {
        return codigo;
    }


    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nuevoNombre) {
        if (nuevoNombre.isEmpty()) {
            return false;
        } else if (!verificarNombre(nuevoNombre)) {
            return false;
        } else {
            this.nombre = nuevoNombre;
            return true;
        }
    }
    
    
    
    
    @Override
    public String toString(){
        return codigo + "," + nombre;
    }
}

