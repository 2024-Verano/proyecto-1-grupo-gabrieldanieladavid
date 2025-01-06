package com.mycompany.tiendadeciclismo;

public class ValidadorCliente {
    /**
     * Verifica si un cliente puede ser eliminado basado en si está presente en alguna factura
     * @param codigoCliente El código del cliente a verificar
     * @return true si el cliente puede ser eliminado (no está en ninguna factura), false en caso contrario
     */
    public static boolean puedeEliminarCliente(int codigoCliente) {
        GestorFacturas gestorFacturas = GestorFacturas.getInstancia();
        
        for (Factura factura : gestorFacturas.getFacturas()) {
            if (factura.getCodigoCliente() == codigoCliente) {
                return false;
            }
        }
        
        return true;
    }
}