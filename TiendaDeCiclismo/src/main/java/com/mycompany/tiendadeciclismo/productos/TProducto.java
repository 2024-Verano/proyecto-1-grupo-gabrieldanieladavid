
package com.mycompany.tiendadeciclismo.productos;
import java.util.ArrayList;
/**
 *
 * Clase de el tipo de producto, para seguidamente ser agregado a los articulos de la tienda. 
 */
public class TProducto {
    private int codigo; //Codigo del producto,  se incrementa automáticamente de 1 en 1 
    private String nombre; //Nombre del Producto, cadena de texto no vacía y sin espacios en blanco en sus extremos 
    
    public TProducto(ArrayList<TProducto> ListaTipoProductos, String Pnombre){ //Recibe la lista de los productos creados, para asi asignar el codigo
        int contador = 0; //Crea un contador para asignar el codigo del tipo de producto
       
        //Ciclo para agregar el codigo a el tipo de producto
        for (TProducto x : ListaTipoProductos ){
            contador = contador + 1;
        }
        codigo = contador; 
        
        nombre = Pnombre;
    }
    public TProducto(String codigo, String nombre){
        
        this.codigo = Integer.parseInt(codigo);
        this.nombre = nombre;
        
        
    }
    //Funcion para verificar que el nombre no contenga espacios. 
    public static boolean verificarNombre(String nombre) {
        // Se usa trim para quitar los espacios en los extremos
        String copiaString = nombre;
        copiaString = copiaString.trim();
        //Ahora se comparan los strings para verificar que ambos no tengan espacios en los extremos.
        if (nombre.equals(copiaString)) {
           return true;
        } else {
           return false; 
        }
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

