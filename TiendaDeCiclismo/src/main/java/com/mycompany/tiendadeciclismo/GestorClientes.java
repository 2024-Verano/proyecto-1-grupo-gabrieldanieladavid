/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendadeciclismo;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * La clase de GestorClientes se encarga de gestionar los clientes que se vayan a crear y el manejo
 * de estos a traves de un archivo .txt, maneja las funciones CRUD de crear, bsucar, modificar y eliminar.
 * @author dnlal
 */
public class GestorClientes {
    /**Atributos
     * Nombre del archivo donde se guardan los clientes.
     */
    private static final String ARCHIVO_CLIENTES = "clientes.txt";
    /**
     * Lista con los clientes leidos.
     */
    private ArrayList<Cliente> clientes;
    
    /**
     * Instancia unica de la clase GestorClientes.
     */
    private static GestorClientes instancia;
    
    /**
     * Constructor que inicia la lista de clientes y se asegura que el archivo clientes.txt existe.
     */
    private GestorClientes() {
        clientes = new ArrayList<>();
        crearArchivoSiNoExiste();
        cargarClientes();
       
    }
    
    /**
     * Crea el archivo clientes.txt si no existe.
     */
    private void crearArchivoSiNoExiste() {
    File archivo = new File(ARCHIVO_CLIENTES);
    if (!archivo.exists()) {
        try {
            archivo.createNewFile();
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de clientes: " + e.getMessage());
        }
    }
}
    
    /**
     * Obtiene la instancia única de la clase GestorClientes.
     * 
     * @return La instancia única de GestorClientes.
     */
    public static GestorClientes getInstancia() {
        if (instancia == null) {
            instancia = new GestorClientes();
        }
        return instancia;
    }
    
    /**
     * Obtiene la lista de clientes.
     * 
     * @return Una nueva lista que contiene todos los clientes registrados.
     */
    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes); // Retorna una copia de la lista
    }
    
    /**
     * Carga la lista de clientes desde el archivo.
     */
    private void cargarClientes() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CLIENTES))) {
            String linea;
            while ((linea = br.readLine()) != null && !linea.isEmpty()) {
                String[] datos = linea.split(",");
                if (datos.length == 9) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Cliente cliente = new Cliente(
                            Integer.parseInt(datos[0]),
                            datos[1],
                            datos[2],
                            datos[3],
                            datos[4],
                            datos[5],
                            datos[6],
                            datos[7],
                            sdf.parse(datos[8])
                    );
                    clientes.add(cliente);
                }
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error al cargar clientes: " + e.getMessage());
        }
    }
    
    /**
     * Guarda la lista de clientes en el archivo.
     */
    public void guardarClientes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES))) {
            for (Cliente cliente : clientes) {
                bw.write(cliente.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar clientes: " + e.getMessage());
        }
    }
    
    /**
     * Obtiene el siguiente código disponible para un nuevo cliente.
     * 
     * @return El siguiente código disponible.
     */
    public int obtenerSiguienteCodigo() {
        if (clientes.isEmpty()) {
            return 1;
        }
        return clientes.stream()
                      .mapToInt(Cliente::getCodigo)
                      .max()
                      .getAsInt() + 1;
    }
    
    /**
     * Agrega un nuevo cliente a la lista, validando que no exista otro cliente con el mismo
     * correo o teléfono.
     * 
     * @param cliente El cliente a agregar.
     * @throws Exception Si ya existe un cliente con el mismo correo o teléfono.
     */
    public void agregarCliente(Cliente cliente) throws Exception {
        if (existeCorreo(cliente.getCorreo(), null)) {
            throw new Exception("Ya existe un cliente con ese correo electrónico");
        }
        if (existeTelefono(cliente.getTelefono(), null)) {
            throw new Exception("Ya existe un cliente con ese número de teléfono");
        }
        clientes.add(cliente);
        guardarClientes();
    }

   /**
     * Modifica los datos de un cliente existente, validando que no exista otro
     * cliente con el mismo correo o teléfono.
     * 
     * @param cliente El cliente a modificar.
     * @throws Exception Si no se encuentra el cliente o ya existe otro cliente con el mismo correo o teléfono.
     */
    public void modificarCliente(Cliente cliente) throws Exception {
        if (existeCorreo(cliente.getCorreo(), cliente.getCodigo())) {
            throw new Exception("Ya existe otro cliente con ese correo electrónico");
        }
        if (existeTelefono(cliente.getTelefono(), cliente.getCodigo())) {
            throw new Exception("Ya existe otro cliente con ese número de teléfono");
        }

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCodigo() == cliente.getCodigo()) {
                clientes.set(i, cliente);
                guardarClientes();
                return;
            }
        }
        throw new Exception("No se encontró el cliente a modificar");
    }

    /**
     * Obtiene un cliente según su código.
     * 
     * @param codigo El código del cliente.
     * @return El cliente con el código especificado, o null si no existe.
     */
    public Cliente obtenerClientePorCodigo(int codigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                return cliente;
            }
        }
        return null;
    }
    
    /**
     * Valida si un número de teléfono es válido según el formato específico.
     * 
     * @param telefono El número de teléfono a validar.
     * @return true si el teléfono es válido, false si no lo es.
     */
    public boolean validarTelefono(String telefono) {
        return telefono.matches("^[2468]\\d{7}$");
    }
    
    /**
     * Valida si una dirección de correo electrónico es válida.
     * 
     * @param correo La dirección de correo electrónico a validar.
     * @return true si el correo es válido, false si no lo es.
     */
    public boolean validarCorreo(String correo) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(correo).matches();
    }
    
    /**
     * Valida si una fecha de nacimiento tiene el formato correcto.
     * 
     * @param fecha La fecha de nacimiento a validar.
     * @return true si la fecha es válida, false si no lo es.
     */
    public boolean validarFechaNacimiento(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    /**
     * Verifica si ya existe un cliente con el correo proporcionado, excluyendo un cliente con un código especificado.
     * 
     * @param correo El correo a verificar.
     * @param exceptoCodigo El código del cliente que se debe excluir de la búsqueda.
     * @return true si ya existe un cliente con el correo, false si no.
     */
    public boolean existeCorreo(String correo, Integer exceptoCodigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCorreo().equalsIgnoreCase(correo)
                    && (exceptoCodigo == null || cliente.getCodigo() != exceptoCodigo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si ya existe un cliente con el teléfono proporcionado, excluyendo un cliente con un código especificado.
     * 
     * @param telefono El teléfono a verificar.
     * @param exceptoCodigo El código del cliente que se debe excluir de la búsqueda.
     * @return true si ya existe un cliente con el teléfono, false si no.
     */
    public boolean existeTelefono(String telefono, Integer exceptoCodigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getTelefono().equals(telefono)
                    && (exceptoCodigo == null || cliente.getCodigo() != exceptoCodigo)) {
                return true;
            }
        }
        return false;
    }

        /**
     * Elimina un cliente de la lista según su código.
     * 
     * @param codigo El código del cliente a eliminar.
     * @throws Exception Si no se encuentra el cliente.
     */
    public void eliminarCliente(int codigo) throws Exception {
        Cliente clienteAEliminar = null;
    
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                clienteAEliminar = cliente;
                break;
            }
        }

        if (clienteAEliminar == null) {
            throw new Exception("No se encontró el cliente a eliminar");
        }

        clientes.remove(clienteAEliminar);
        guardarClientes();
    }
    
    /**
     * Busca clientes por su código.
     * 
     * @param codigo El código del cliente a buscar.
     * @return Una lista con los clientes que coincidan con el código.
     */
    public List<Cliente> buscarClientesPorCodigo(int codigo) {
        List<Cliente> resultados = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                resultados.add(cliente);
                break; // Como el código es único, podemos romper el ciclo al encontrarlo
            }
        }
        return resultados;
    }

        /**
     * Busca clientes por su nombre o apellidos.
     * 
     * @param busqueda El nombre o apellido a buscar.
     * @return Una lista con los clientes que coincidan con la búsqueda.
     */
    public List<Cliente> buscarClientesPorNombreApellidos(String busqueda) {
        List<Cliente> resultados = new ArrayList<>();
        String busquedaLower = busqueda.toLowerCase();

        for (Cliente cliente : clientes) {
            String nombreCompleto = (cliente.getNombre() + " " + cliente.getApellidos()).toLowerCase();
            if (nombreCompleto.contains(busquedaLower)) {
                resultados.add(cliente);
                
            }
        }
        return resultados;
    }
}