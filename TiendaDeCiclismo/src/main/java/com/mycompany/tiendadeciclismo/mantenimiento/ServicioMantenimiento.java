/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendadeciclismo;

import java.util.Date;
/**
 *
 * @author GGarro
 */
public class ServicioMantenimiento {
    //Atributos de la clase
    private int codigoDeServicio;
    private int codigoCliente;
    private String marcaBicicleta;
    private String descripcionBicicleta;   
    private int precio;    
    private Date fechaRecibido;
    private Date fechaEntrega;    
    private String observaciones;
    private String estado;    
    public String obtenerNombreCliente(int codigoCliente){
        GestorClientes gestorClientes = GestorClientes.getInstancia();
        Cliente cliente = gestorClientes.obtenerClientePorCodigo(codigoCliente);
        if (cliente != null) {
        String nombreCompleto = cliente.getNombre() + " " + cliente.getApellidos();
            return nombreCompleto;}
        else{return "Cliente no encontrado";}
                
    }

    // Metodo Constructor
    public ServicioMantenimiento(int codigoDeServicio,int codigoCliente,String marcaBicicleta, String descripcionBicicleta,
        int precio,Date fechaRecibido, Date fechaEntrega,String observaciones, String estado){                                      
        this.codigoDeServicio = codigoDeServicio;
        this.codigoCliente = codigoCliente;
        this.precio = precio;
        this.marcaBicicleta = marcaBicicleta;
        this.descripcionBicicleta = descripcionBicicleta;
        this.observaciones = observaciones;
        this.estado = estado;
        this.fechaRecibido = fechaRecibido;
        this.fechaEntrega = fechaEntrega;
    }

    //Getters
        public int getCodigoServicio(){ return codigoDeServicio;}
        public int getCodigoCliente(){ return codigoCliente;}
        public int getPrecio(){return precio;}
        public String getMarcaBicicleta(){return marcaBicicleta;}
        public String getDescripcionBicicleta(){return descripcionBicicleta;}
        public String getObservaciones(){return observaciones;}
        public String getEstado(){return estado;}
        public Date getFechaRecibido(){return fechaRecibido;}
        public Date getFechaEntrega(){return fechaEntrega;}
        
    
    // Setters
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
                            }

    public void setPrecio(int precio) {
        this.precio = precio;
                            }

    public void setMarcaBicicleta(String marcaBicicleta) {
        this.marcaBicicleta = marcaBicicleta;
                            }

    public void setDescripcionBicicleta(String descripcionBicicleta) {
        this.descripcionBicicleta = descripcionBicicleta;
                            }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
                            }

    public void setEstado(String estado) {
        this.estado = estado;
                            }
    @Override
    public String toString(){
        String nombreCliente=obtenerNombreCliente(codigoCliente);
        return String.format("%d,%d,%s,%s,%s,%d,%tF,%tF,%s,%s",codigoDeServicio,codigoCliente,nombreCliente,
                marcaBicicleta,descripcionBicicleta,precio,fechaRecibido,fechaEntrega,observaciones,estado);
            
    }
    
}