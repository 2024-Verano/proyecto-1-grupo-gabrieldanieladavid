package com.mycompany.tiendadeciclismo;

public class DetalleFactura {
    private int numeroFactura;
    private int codigoArticulo;
    private int cantidad;
    private double precioUnitario;
    private double total;
    
    public DetalleFactura(int numeroFactura, int codigoArticulo, int cantidad, double precioUnitario) {
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
    public double getPrecioUnitario() { return precioUnitario; }
    public double getTotal() { return total; }
    
    @Override
    public String toString() {
        return String.format("%d,%d,%d,%.2f,%.2f", 
            numeroFactura, codigoArticulo, cantidad, precioUnitario, total);
    }
}