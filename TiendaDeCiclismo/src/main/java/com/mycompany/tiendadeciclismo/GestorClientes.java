/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendadeciclismo;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author dnlal
 */
public class GestorClientes {
    private static final String ARCHIVO_CLIENTES = "clientes.txt";
    private ArrayList<Cliente> clientes;
    private static GestorClientes instancia;
    
    private GestorClientes() {
        clientes = new ArrayList<>();
        crearArchivoSiNoExiste();
        cargarClientes();
       
    }
    
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
    
    public static GestorClientes getInstancia() {
        if (instancia == null) {
            instancia = new GestorClientes();
        }
        return instancia;
    }
    
    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes); // Retorna una copia de la lista
    }
    
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
    
    public int obtenerSiguienteCodigo() {
        if (clientes.isEmpty()) {
            return 1;
        }
        return clientes.stream()
                      .mapToInt(Cliente::getCodigo)
                      .max()
                      .getAsInt() + 1;
    }
    
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

    public Cliente obtenerClientePorCodigo(int codigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                return cliente;
            }
        }
        return null;
    }
    
    public boolean validarTelefono(String telefono) {
        return telefono.matches("^[2468]\\d{7}$");
    }
    
    public boolean validarCorreo(String correo) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(correo).matches();
    }
    
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
    
    public boolean existeCorreo(String correo, Integer exceptoCodigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCorreo().equalsIgnoreCase(correo)
                    && (exceptoCodigo == null || cliente.getCodigo() != exceptoCodigo)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeTelefono(String telefono, Integer exceptoCodigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getTelefono().equals(telefono)
                    && (exceptoCodigo == null || cliente.getCodigo() != exceptoCodigo)) {
                return true;
            }
        }
        return false;
    }
    
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