package com.mycompany.tiendadeciclismo;

import java.util.ArrayList;
import java.util.List;

public class Division {
    private String nombre;
    private List<Division> subdivisiones;
    
    public Division(String nombre) {
        this.nombre = nombre;
        this.subdivisiones = new ArrayList<>();
    }
    
    public void agregarSubdivision(Division subdivision) {
        subdivisiones.add(subdivision);
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public List<Division> getSubdivisiones() {
        return subdivisiones;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}