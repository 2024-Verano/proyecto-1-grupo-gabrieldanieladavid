package com.mycompany.tiendadeciclismo;

import java.util.Date;
import java.util.ArrayList;

public class Factura {
    private int numeroFactura;
    private int codigoCliente;
    private Date fecha;
    private String estado; // "Válido" o "Anulado"
    private double subtotal;
    private double iva;
    private double total;
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
    
    // Getters y setters
    public int getNumeroFactura() { return numeroFactura; }
    public int getCodigoCliente() { return codigoCliente; }
    public Date getFecha() { return fecha; }
    public String getEstado() { return estado; }
    public double getSubtotal() { return subtotal; }
    public double getIva() { return iva; }
    public double getTotal() { return total; }
    public ArrayList<DetalleFactura> getDetalles() { return detalles; }
    
    public void setEstado(String estado) { this.estado = estado; }
    
    public void calcularTotales() {
        subtotal = 0;
        for (DetalleFactura detalle : detalles) {
            subtotal += detalle.getTotal();
        }
        iva = subtotal * 0.13;
        total = subtotal + iva;
    }
    
    @Override
    public String toString() {
        return String.format("%d,%d,%tF,%s,%.2f,%.2f,%.2f", 
            numeroFactura, codigoCliente, fecha, estado, subtotal, iva, total);
    }
}