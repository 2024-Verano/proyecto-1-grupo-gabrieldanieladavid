package com.mycompany.tiendadeciclismo;

import java.util.ArrayList;
import java.util.List;
    
    /**
     * Clase que maneja las divisiones territoriales para cuando se va a agregar un cliente.
     * @author dnlal
     */
public class Division {
    /**
     * Atributos
     * Nombre de la divicion territorial.
     */
    private String nombre;
    /**
     * Lista de las subdivisiones que pertenecen a la division.
     */
    private List<Division> subdivisiones;
    
    /**
     * Constructor que inicia el nombre de la division y crea una lista vacia con las subdivisiones.
     * @param nombre el nombre de la division territorial.
     */
    public Division(String nombre) {
        this.nombre = nombre;
        this.subdivisiones = new ArrayList<>();
    }
    
    /**
     * Agrega una subdivisión a la lista de subdivisiones de esta división.
     * 
     * @param subdivision La subdivisión que se va a agregar.
     */
    public void agregarSubdivision(Division subdivision) {
        subdivisiones.add(subdivision);
    }

        /**
     * Obtiene el nombre de la división.
     * 
     * @return El nombre de la división.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtiene la lista de subdivisiones de la división.
     * 
     * @return La lista de subdivisiones.
     */

    public List<Division> getSubdivisiones() {
        return subdivisiones;
    }
    
    /**
     * Retorna una representación en cadena del nombre de la división.
     * 
     * @return El nombre de la división.
     */
    @Override
    public String toString() {
        return nombre;
    }
}