package com.mycompany.tiendadeciclismo.productos;

import com.mycompany.tiendadeciclismo.DetalleFactura;
import com.mycompany.tiendadeciclismo.Factura;
import com.mycompany.tiendadeciclismo.GestorFacturas;
import java.util.List;

public class ValidadorArticulo {
    /**
     * Verifica si un artículo puede ser eliminado basado en si está presente en alguna factura
     * @param codigoArticulo El código del artículo a verificar
     * @return true si el artículo puede ser eliminado (no está en ninguna factura), false en caso contrario
     */
    public static boolean puedeEliminarArticulo(int codigoArticulo) {
        GestorFacturas gestorFacturas = GestorFacturas.getInstancia();
        List<Factura> facturas = gestorFacturas.getFacturas();
        
        for (Factura factura : facturas) {
            for (DetalleFactura detalle : factura.getDetalles()) {
                if (detalle.getCodigoArticulo() == codigoArticulo) {
                    
                    return false;
                }
            }
        }
        
        return true;
    }
}