package com.mycompany.tiendadeciclismo;

import java.util.Date;
import java.util.ArrayList;

public class Factura {
    private int numeroFactura;
    private int codigoCliente;
    private Date fecha;
    private String estado; // "Válido" o "Anulado"
    private int subtotal;
    private int iva;
    private int total;
    private ArrayList<DetalleFactura> detalles;
    
    public Factura(int numeroFactura, int codigoCliente, Date fecha) {
        this.numeroFactura = numeroFactura;
        this.codigoCliente = codigoCliente;
        this.fecha = fecha;
        this.estado = "Válido";
        this.subtotal = 0;
        this.iva = 0;
        this.total = 0;
        this.detalles = new ArrayList<>();
    }
    
    public int getNumeroFactura() { return numeroFactura; }
    public int getCodigoCliente() { return codigoCliente; }
    public Date getFecha() { return fecha; }
    public String getEstado() { return estado; }
    public int getSubtotal() {
        return subtotal;
    }

    public int getIva() {
        return iva;
    }

    public int getTotal() {
        return total;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public ArrayList<DetalleFactura> getDetalles() { return detalles; }
    
    public void setEstado(String estado) { this.estado = estado; }
    
    public void calcularTotales() {
        subtotal = 0;
        for (DetalleFactura detalle : detalles) {
            subtotal += detalle.getTotal();
        }
        iva = (int) (subtotal * 0.13); 
        total = subtotal + iva;
    }
    
    @Override
    public String toString() {
        return String.format("%d,%d,%tF,%s,%d,%d,%d", // Cambiar %.2f a %d
                numeroFactura, codigoCliente, fecha, estado, subtotal, iva, total);
    }
    
    
}