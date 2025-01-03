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
   
   public gestorTProductosArticulos(){
       ListaTProductos = new ArrayList<>();
       cargarTProductos();
       ListaArticulos = new ArrayList<>();
       
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
                System.out.println("se guardo");
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
   public void imprimirProductos(){
       for (TProducto x : ListaTProductos){
           System.out.println("Codigo: " + x.getCodigo() + "   Nombre: " + x.getNombre());
       }
   }
   
   public TProducto buscarTProducto(int codigo){
       for (TProducto x : ListaTProductos){
           if (x.getCodigo() == codigo){
               return x;
           }
       }
       return null;
   }
   
}
