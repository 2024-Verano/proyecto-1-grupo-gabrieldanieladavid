/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendadeciclismo.mantenimiento;


import com.mycompany.tiendadeciclismo.ServicioMantenimiento;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase GestorMantenimiento, permite gestionar los Servicios de mantenimiento y hacer con ellos las principales
 * funciones de un CRUD, ya sean crear, modificar, buscar y eliminar y almacenarlos en un archivo.
 * 
 * @author Gabriel Garro
 */
public class GestorMantenimiento {
    /**
     * Atributos
     * Nombre del archivo donde se almacenan los servicios de mantenimiento.*/
    public final String ArchivoServicioMantenimiento = "Mantenimiento.txt";
    /**Lista donde se guardaran los servicios de mantenimiento cargados del archivo.*/
    private ArrayList<ServicioMantenimiento> servicios;
    /**Instancia unica en Singleton del Gestor*/
    private static GestorMantenimiento instancia;
    
    /**
     * Constructor privado de la clase GestorMantenimiento.
     * Inicializa la lista de servicios y carga los datos desde el archivo.
     */
    private GestorMantenimiento() {
        servicios = new ArrayList<>();
        crearArchivoSiNoExiste();
        cargarServicios();
    }

    /**
     * Crea el archivo de mantenimiento si no existe.
     */
    private void crearArchivoSiNoExiste() {
        File archivo = new File(ArchivoServicioMantenimiento);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e){
                System.err.println("Error al crear el archivo de mantenimiento: " + e.getMessage());
            }
        }
    }

    /**
     * Obtiene la instancia única de GestorMantenimiento.
     * 
     * @return instancia única del Gestor.
     */
    public static GestorMantenimiento getInstancia() {
        if (instancia == null) {
            instancia = new GestorMantenimiento();
        }
        return instancia;
    }

    /**
     * Obtiene una copia de la lista de servicios de mantenimiento.
     * 
     * @return lista de servicios de mantenimiento.
     */
    public List<ServicioMantenimiento> getServicios() {
        return new ArrayList<>(servicios);
    }

    /**
     * Carga los servicios de mantenimiento desde el archivo.
     */
 public void cargarServicios() {
    try (BufferedReader br = new BufferedReader(new FileReader(ArchivoServicioMantenimiento))) {
        String linea;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos.length == 10) {
                try {
                    // Asegurando que los índices sean correctos
                    ServicioMantenimiento servicio = new ServicioMantenimiento(
                            Integer.parseInt(datos[0]),  
                            Integer.parseInt(datos[1]),  
                            datos[3],                    
                            datos[4],                    
                            Integer.parseInt(datos[5]),  
                            sdf.parse(datos[6]),         
                            sdf.parse(datos[7]),         
                            datos[8],                    
                            datos[9]                     
                    );
                    servicios.add(servicio);
                } catch (ParseException e) {
                    System.err.println("Error al parsear la fecha: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.err.println("Error al convertir número: " + e.getMessage());
                }
            }
        }
    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
    }
}

    /**
     * Obtiene el siguiente código disponible para un nuevo servicio de mantenimiento.
     * 
     * @return el siguiente código de servicio disponible.
     */
    public int obtenerSiguienteCodigo() {
        if (servicios.isEmpty()) {
            return 1;
        }
        return servicios.stream()
                      .mapToInt(ServicioMantenimiento::getCodigoServicio)
                      .max()
                      .getAsInt() + 1;
    }
    
    /**
     * Guarda la lista de servicios de mantenimiento en el archivo.
     */
    public void guardarServicio(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ArchivoServicioMantenimiento))) {
            for(ServicioMantenimiento servicio: servicios){
                bw.write(servicio.toString());
                bw.newLine();
            }
        }
        catch (IOException e){
                System.err.println("Error al guardar clientes: " + e.getMessage());
            }
    }
    
    /**
     * Agrega un nuevo servicio de mantenimiento a la lista y lo guarda en el archivo.
     * 
     * @param servicio el servicio de mantenimiento a agregar.
     * @throws Exception si ocurre un error al guardar el servicio.
     */
    public void agregarServicio(ServicioMantenimiento servicio)throws Exception{
        servicios.add(servicio);
        guardarServicio();
    }
    
    /**
     * Modifica un servicio de mantenimiento existente en la lista y guarda los cambios en el archivo.
     * 
     * @param servicio el servicio de mantenimiento a modificar.
     * @throws Exception si no se encuentra el servicio a modificar.
     */
    public void modificarServicio(ServicioMantenimiento servicio) throws Exception {
        for (int i = 0; i < servicios.size(); i++) {
            if (servicios.get(i).getCodigoServicio() == servicio.getCodigoServicio()) {
                servicios.set(i, servicio);
                guardarServicio();
                return;
            }
        }
        throw new Exception("No se encontró el servicio a modificar");
    }
    
    /**
     * Elimina un servicio de mantenimiento de la lista y actualiza el archivo.
     * 
     * @param codigo el código del servicio a eliminar.
     * @throws Exception si no se encuentra el servicio a eliminar.
     */
    public void eliminarServicio(int codigo)throws Exception{
        ServicioMantenimiento eliminarServicio= null;
        for(ServicioMantenimiento servicio:servicios){
            if(servicio.getCodigoServicio()==codigo){
                eliminarServicio=servicio;
                break;
            }
        }   
        if (eliminarServicio==null){
            throw new Exception("No se encontro servicio a eliminar");
        }
        servicios.remove(eliminarServicio);
        guardarServicio();
    }
    
    /**
     * Busca servicios de mantenimiento por el nombre del cliente asociado.
     * 
     * @param nombre el nombre del cliente a buscar.
     * @return una lista de servicios cuyo cliente coincida con el nombre buscado.
     */
    public List<ServicioMantenimiento> buscarPorNombre(String nombre){
        List<ServicioMantenimiento> resultados= new ArrayList<>();
        String nombreLower= nombre.toLowerCase();
        
        for(ServicioMantenimiento servicio: servicios){
            int codigoCliente=servicio.getCodigoCliente();
            String nombreCliente=(servicio.obtenerNombreCliente(codigoCliente)).toLowerCase();
            if(nombreCliente.contains(nombreLower)){
                resultados.add(servicio);
                }
            }
        return resultados;
    }
  
    /**
     * Busca un servicio de mantenimiento por su código único.
     * 
     * @param codigo el código del servicio a buscar.
     * @return el servicio de mantenimiento si se encuentra, o null en caso contrario.
     */
    public ServicioMantenimiento buscarPorCodigo(int codigo){
        for (ServicioMantenimiento servicio:servicios){
            if(servicio.getCodigoServicio()==codigo){
                return servicio;
            }
        }
    return null;
    }
    
    /**
     * Busca un servicio de mantenimiento por su código y devuelve una lista con el resultado.
     * 
     * @param codigo el código del servicio a buscar.
     * @return una lista con el servicio encontrado, o una lista vacía si no se encuentra.
     */
    public List<ServicioMantenimiento> buscarServicioPorCodigo(int codigo){
        List<ServicioMantenimiento> resultados = new ArrayList<>();
        for (ServicioMantenimiento servicio : servicios) {
            if (servicio.getCodigoServicio() == codigo) {
                resultados.add(servicio);
                break;
            }
        }
        return resultados;
}
}
