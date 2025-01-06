package com.mycompany.tiendadeciclismo;

public class DetalleFactura {
    private int numeroFactura;
    private int codigoArticulo;
    private int cantidad;
    private int precioUnitario;
    private int total;
    
    public DetalleFactura(int numeroFactura, int codigoArticulo, int cantidad, int precioUnitario) {
        this.numeroFactura = numeroFactura;
        this.codigoArticulo = codigoArticulo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.total = cantidad * precioUnitario;
    }
    
    // Getters
    public int getNumeroFactura() { return numeroFactura; }
    public int getCodigoArticulo() { return codigoArticulo; }
    public int getCantidad() { return cantidad; }
    public int getPrecioUnitario() { return precioUnitario; }
    public int getTotal() { return total; }
    
    @Override
    public String toString() {
        return String.format("%d,%d,%d,%d,%d",
                numeroFactura,
                codigoArticulo,
                cantidad,
                precioUnitario,
                total);
    }
}