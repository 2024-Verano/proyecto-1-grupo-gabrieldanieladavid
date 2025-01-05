/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendadeciclismo.productos;
import com.mycompany.tiendadeciclismo.productos.TProducto;
import com.mycompany.tiendadeciclismo.productos.Articulo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author david
 */
public class gestorTProductosArticulos {
   private ArrayList<TProducto> ListaTProductos;
   private ArrayList<Articulo> ListaArticulos;
   private static final String ARCHIVO_TPRODUCTO = "tproductos.txt"; 
   private static final String ARCHIVO_ARTICULOS = "articulos.txt"; 
   
   public gestorTProductosArticulos(){
       ListaTProductos = new ArrayList<>();
       cargarTProductos();
       ListaArticulos = new ArrayList<>();
       cargarArticulos();
   }
   
   private void cargarArticulos(){
       try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ARTICULOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 8) {
                    ListaArticulos.add(new Articulo(Integer.parseInt(datos[0].trim()), Integer.parseInt(datos[1].trim()), datos[2].trim(), datos[3].trim(), Float.parseFloat(datos[4].trim()), datos[5].trim(), Integer.parseInt(datos[6].trim()), Integer.parseInt(datos[7].trim())));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar productos: " + e.getMessage());
        }
   }
   
   
   
   private void cargarTProductos() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_TPRODUCTO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    ListaTProductos.add(new TProducto(datos[0].trim(), datos[1].trim()));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar productos: " + e.getMessage());
        }
    }
   
   public void guardarTProductos() {
      
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_TPRODUCTO))) {
            for (TProducto producto : ListaTProductos) {
                bw.write(producto.toString());
                bw.newLine();
               
            }
        } catch (IOException e) {
            System.err.println("Error al guardar productos: " + e.getMessage());
        }
    
   }
   
   public void guardarArticulos() {
      
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ARTICULOS))) {
            for (Articulo x : ListaArticulos) {
                bw.write(x.toString());
                bw.newLine();
               
            }
        } catch (IOException e) {
            System.err.println("Error al guardar productos: " + e.getMessage());
        }
    
   }
   
   public ArrayList<TProducto> getListaTProducto(){
       if (ListaTProductos == null){
           return new ArrayList<>(ListaTProductos);
       }
       else{
           return ListaTProductos;
       }
   }
   public ArrayList<Articulo> getListaArticulos(){
       if (ListaArticulos == null){
           return new ArrayList<>(ListaArticulos);
       }
       else{
           return ListaArticulos;
       }
   }
   
   //Funcion para imprimir los productos
   public void imprimirProductos(){
       for (TProducto x : ListaTProductos){
           System.out.println("Codigo: " + x.getCodigo() + "   Nombre: " + x.getNombre());
       }
   }
   
   
   //Funcion para buscar por codigo en los tipos de productos
   public TProducto buscarTProducto(int codigo){
       for (TProducto x : ListaTProductos){
           if (x.getCodigo() == codigo){
               return x;
           }
       }
       return null;
   }
   
   public Boolean verificarTProducto(int codigo){
       for (TProducto x : ListaTProductos){
           if (x.getCodigo() == codigo){
               return true;
           }
       }
       return false;
   }
   
   
   
   //Metodo para buscar por codigo en los articulos:
   public Articulo buscarArticulo(int codigo) {
        for (Articulo x : ListaArticulos) {
            if (x.getCodigo() == codigo) { // Compara el código
                return x; // Retorna el artículo encontrado
            }
        }
        return null; // Retorna null si no encuentra el artículo
    }
   
   // Método para buscar un artículo por nombre
    public Articulo buscarArticulo(String nombre) {
        for (Articulo x : ListaArticulos) {
            if (x.getNombre().equals(nombre.trim())) { 
                return x; // Retorna el artículo encontrado
            }
        }
        return null; // Retorna null si no encuentra el artículo
    }
   
   
}
