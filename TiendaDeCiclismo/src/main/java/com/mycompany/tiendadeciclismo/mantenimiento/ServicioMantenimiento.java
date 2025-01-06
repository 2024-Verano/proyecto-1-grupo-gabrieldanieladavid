/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendadeciclismo;

import java.util.Date;
/**
 *
 * @author GGarro
 * Clase ServicioMantenimiento, crea objetos para representar Servicios de Mantenimiento que se 
 * que manejara la tienda de Bicicletas, maneja atributos que representan el codigo de los clientes,
 * el codigo del servicio, la marca de la bicicleta, una descripción de la Bici, el precio que tendra el servicio,
 * la fecha en la que se inicia o recibe el servicio, la fecha donde se entrega la Bici al dueño, observaciones y
 * el estado del servicio.
 */
public class ServicioMantenimiento {
    //Atributos de la clase
    /**Codigo exclusivo del Servicio, se va incrementando mediante a los servicios de 1 en 1. */
    private int codigoDeServicio;
    /**Codigo del Cliente que pide el Servicio, con este posteriormente se conseguira el nombre de este.  */
    private int codigoCliente;
    /** La marca de la bicicleta que recibira el servicio de mantenimiento.*/
    private String marcaBicicleta;
    /**Una pequeña descripción de la bicicleta que recibira el servicio.*/
    private String descripcionBicicleta;   
    /**Precio del servicio de mantenimiento.*/
    private int precio;
    /**Fecha en la que se recibe la bicicleta e inicia el servicio de mantenimiento.*/
    private Date fechaRecibido;
    /**Fecha aproximada maxima en la que se le devuelve la bicicleta al dueño.*/
    private Date fechaEntrega;    
    /**Observaciones de la bicicleta o servicio*/
    private String observaciones;
    /**Estado del servicio, seria Abierto cuando este en proceso o Cerrado cuando finalice*/
    private String estado;    

    /**
     * Metodo Constructor para crear un nuevo Servicio de Mantenimiento.
     * @param codigoDeServicio codigo unico del servicio.
     * @param codigoCliente codigo del cliente que pide el servicio.
     * @param marcaBicicleta marca de la bicicleta.
     * @param descripcionBicicleta descripcion de la bicicleta.
     * @param precio precio del servicio.
     * @param fechaRecibido fecha en la que se recibe la bicicleta para recibir el servicio.
     * @param fechaEntrega fecha en la que se devuelve la bicicleta al cliente tras el servicio.
     * @param observaciones observaciones de la bicicleta o del servicio de mantenimiento.
     * @param estado estado del servicio.
    */
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

    /**Getters 
     * @return el codigo exclusivo del cliente.
     */
        public int getCodigoServicio(){ return codigoDeServicio;}
    /**
     * @return el codigo del cliente.
     */
        public int getCodigoCliente(){ return codigoCliente;}
    /**
     * @return la marca de la bicicleta.
     */
        public String getMarcaBicicleta(){return marcaBicicleta;}
    /**
     * @return descripcion de la bicicleta.
     */
        public String getDescripcionBicicleta(){return descripcionBicicleta;}    
    /**
     * @return El precio.
     */
        public int getPrecio(){return precio;}
    /**
     * @return Observaciones.
     */
        public String getObservaciones(){return observaciones;}
    /**
     * @return Fecha en la que se recibio la bici.
     */
        public Date getFechaRecibido(){return fechaRecibido;}
    /**
     * @return Fecha en la que se entrego o devolvio la bici.
     */
        public Date getFechaEntrega(){return fechaEntrega;}        
    /**
     * @return Estado del servicio. 
     */
        public String getEstado(){return estado;}

        
    
    /** Setters
     *
     * Establece el código del cliente.
     * @param codigoCliente el nuevo código del cliente.
     */
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
                            }
    /**
     * Establece el precio del servicio.
     * @param precio el nuevo precio del servicio.
     */
    public void setPrecio(int precio) {
        this.precio = precio;
                            }
    /**
     * Establece la marca de la bicicleta.
     * @param marcaBicicleta la nueva marca de la bicicleta.
     */
    public void setMarcaBicicleta(String marcaBicicleta) {
        this.marcaBicicleta = marcaBicicleta;
                            }
    /**
     * Establece la descripción de la bicicleta.
     * @param descripcionBicicleta la nueva descripción de la bicicleta.
     */
    public void setDescripcionBicicleta(String descripcionBicicleta) {
        this.descripcionBicicleta = descripcionBicicleta;
                            }
    /**
     * Establece las observaciones adicionales.
     * @param observaciones las nuevas observaciones.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
                            }
    /**
     * Establece el estado del servicio.
     * @param estado el nuevo estado del servicio.
     */
    public void setEstado(String estado) {
        this.estado = estado;
                            }
    /**
     * Obtiene el nombre completo del cliente según su código.
     * @param codigoCliente el código del cliente.
     * @return el nombre completo del cliente o "Cliente no encontrado" si no existe.
     */
    public String obtenerNombreCliente(int codigoCliente){
        GestorClientes gestorClientes = GestorClientes.getInstancia();
        Cliente cliente = gestorClientes.obtenerClientePorCodigo(codigoCliente);
        if (cliente != null) {
        String nombreCompleto = cliente.getNombre() + " " + cliente.getApellidos();
            return nombreCompleto;}
        else{return "Cliente no encontrado";}
                
    }
    /**
     * Devuelve una representación en formato de texto de los detalles del servicio.
     * @return una cadena con los detalles del servicio.
     */
    @Override
    public String toString(){
        String nombreCliente=obtenerNombreCliente(codigoCliente);
        return String.format("%d,%d,%s,%s,%s,%d,%tF,%tF,%s,%s",codigoDeServicio,codigoCliente,nombreCliente,
                marcaBicicleta,descripcionBicicleta,precio,fechaRecibido,fechaEntrega,observaciones,estado);
            
    }
    
}