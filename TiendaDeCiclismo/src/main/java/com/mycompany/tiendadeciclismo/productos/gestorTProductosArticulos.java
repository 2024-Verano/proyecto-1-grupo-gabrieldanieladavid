/**
 * Clase que gestiona los tipos de productos y artículos en la tienda de ciclismo.
 * Proporciona métodos para cargar, guardar, buscar y manipular tipos de productos
 * y artículos desde archivos y en memoria.
 */
package com.mycompany.tiendadeciclismo.productos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class gestorTProductosArticulos {

    /////////////////// Atributos //////////////////////

    /**
     * Lista de tipos de productos existentes en la tienda.
     */
    private ArrayList<TProducto> ListaTProductos;

    /**
     * Lista de artículos existentes en la tienda.
     */
    private ArrayList<Articulo> ListaArticulos;

    /**
     * Nombre del archivo donde se almacenan los tipos de productos.
     */
    private static final String ARCHIVO_TPRODUCTO = "tproductos.txt";

    /**
     * Nombre del archivo donde se almacenan los artículos.
     */
    private static final String ARCHIVO_ARTICULOS = "articulos.txt";

    /////////////////// Métodos ////////////////////////

    /**
     * Constructor que inicializa las listas de tipos de productos y artículos,
     * cargando los datos desde los archivos correspondientes.
     */
    public gestorTProductosArticulos() {
        ListaTProductos = new ArrayList<>();
        cargarTProductos();
        ListaArticulos = new ArrayList<>();
        cargarArticulos();
    }

    /**
     * Método para cargar los artículos desde el archivo correspondiente.
     * Agrega los artículos leídos a la lista de artículos.
     */
    private void cargarArticulos() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ARTICULOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 8) {
                    ListaArticulos.add(new Articulo(
                        Integer.parseInt(datos[0].trim()),
                        Integer.parseInt(datos[1].trim()),
                        datos[2].trim(),
                        datos[3].trim(),
                        Float.parseFloat(datos[4].trim()),
                        datos[5].trim(),
                        Integer.parseInt(datos[6].trim()),
                        Integer.parseInt(datos[7].trim())
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar productos: " + e.getMessage());
        }
    }

    /**
     * Método para cargar los tipos de productos desde el archivo correspondiente.
     * Agrega los tipos de productos leídos a la lista.
     */
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

    /**
     * Método para guardar los tipos de productos en el archivo correspondiente.
     */
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

    /**
     * Método para guardar los artículos en el archivo correspondiente.
     */
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

    /**
     * Obtiene la lista de tipos de productos.
     *
     * @return Lista de tipos de productos.
     */
    public ArrayList<TProducto> getListaTProducto() {
        if (ListaTProductos == null) {
            return new ArrayList<>(ListaTProductos);
        } else {
            return ListaTProductos;
        }
    }

    /**
     * Obtiene la lista de artículos.
     *
     * @return Lista de artículos.
     */
    public ArrayList<Articulo> getListaArticulos() {
        if (ListaArticulos == null) {
            return new ArrayList<>(ListaArticulos);
        } else {
            return ListaArticulos;
        }
    }

    /**
     * Método para imprimir en consola los tipos de productos existentes.
     */
    public void imprimirProductos() {
        for (TProducto x : ListaTProductos) {
            System.out.println("Codigo: " + x.getCodigo() + "   Nombre: " + x.getNombre());
        }
    }

    /**
     * Busca un tipo de producto por su código.
     *
     * @param codigo Código del tipo de producto a buscar.
     * @return El tipo de producto encontrado o null si no existe.
     */
    public TProducto buscarTProducto(int codigo) {
        for (TProducto x : ListaTProductos) {
            if (x.getCodigo() == codigo) {
                return x;
            }
        }
        return null;
    }

    /**
     * Verifica si existe un tipo de producto con un código específico.
     *
     * @param codigo Código del tipo de producto a verificar.
     * @return true si existe, false en caso contrario.
     */
    public Boolean verificarTProducto(int codigo) {
        for (TProducto x : ListaTProductos) {
            if (x.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un artículo por su código.
     *
     * @param codigo Código del artículo a buscar.
     * @return El artículo encontrado o null si no existe.
     */
    public Articulo buscarArticulo(int codigo) {
        for (Articulo x : ListaArticulos) {
            if (x.getCodigo() == codigo) {
                return x;
            }
        }
        return null;
    }

    /**
     * Busca un artículo por su nombre.
     *
     * @param nombre Nombre del artículo a buscar.
     * @return El artículo encontrado o null si no existe.
     */
    public Articulo buscarArticulo(String nombre) {
        for (Articulo x : ListaArticulos) {
            if (x.getNombre().equals(nombre.trim())) {
                return x;
            }
        }
        return null;
    }
}