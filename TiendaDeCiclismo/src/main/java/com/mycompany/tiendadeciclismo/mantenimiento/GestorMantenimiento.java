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
import java.util.Date;
import java.util.List;

public class GestorMantenimiento {
    public final String ArchivoServicioMantenimiento = "Mantenimiento.txt";
    private ArrayList<ServicioMantenimiento> servicios;
    private static GestorMantenimiento instancia;
    
    private GestorMantenimiento() {
        servicios = new ArrayList<>();
        crearArchivoSiNoExiste();
        cargarServicios();
    }

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

    public static GestorMantenimiento getInstancia() {
        if (instancia == null) {
            instancia = new GestorMantenimiento();
        }
        return instancia;
    }

    public List<ServicioMantenimiento> getServicios() {
        return new ArrayList<>(servicios);
    }

    
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

    public int obtenerSiguienteCodigo() {
        if (servicios.isEmpty()) {
            return 1;
        }
        return servicios.stream()
                      .mapToInt(ServicioMantenimiento::getCodigoServicio)
                      .max()
                      .getAsInt() + 1;
    }
    
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
    public void agregarServicio(ServicioMantenimiento servicio)throws Exception{
        servicios.add(servicio);
        guardarServicio();
    }
    
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
    
    public ServicioMantenimiento buscarPorCodigo(int codigo){
        for (ServicioMantenimiento servicio:servicios){
            if(servicio.getCodigoServicio()==codigo){
                return servicio;
            }
        }
    return null;
    }
    public List<ServicioMantenimiento> buscarServicioPorCodigo(int codigo){
        List<ServicioMantenimiento> resultados = new ArrayList<>();
        for (ServicioMantenimiento servicio : servicios) {
            if (servicio.getCodigoServicio() == codigo) {
                resultados.add(servicio);
                break; // Como el código es único, podemos romper el ciclo al encontrarlo
            }
        }
        return resultados;
}
}
