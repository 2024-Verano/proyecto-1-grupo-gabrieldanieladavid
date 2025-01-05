package com.mycompany.tiendadeciclismo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorFacturas {
    private static final String ARCHIVO_FACTURAS = "facturas.txt";
    private static final String ARCHIVO_DETALLES = "detalles_factura.txt";
    private ArrayList<Factura> facturas;
    private ArrayList<DetalleFactura> detalles;
    private static GestorFacturas instancia;
    
    private GestorFacturas() {
        facturas = new ArrayList<>();
        detalles = new ArrayList<>();
        crearArchivosSiNoExisten();
        cargarFacturas();
    }
    
    public static GestorFacturas getInstancia() {
        if (instancia == null) {
            instancia = new GestorFacturas();
        }
        return instancia;
    }
    
    private void crearArchivosSiNoExisten() {
        File archivoFacturas = new File(ARCHIVO_FACTURAS);
        File archivoDetalles = new File(ARCHIVO_DETALLES);
        
        try {
            if (!archivoFacturas.exists()) {
                archivoFacturas.createNewFile();
            }
            if (!archivoDetalles.exists()) {
                archivoDetalles.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al crear archivos: " + e.getMessage());
        }
    }
    
    public int obtenerSiguienteNumero() {
        if (facturas.isEmpty()) {
            return 1;
        }
        return facturas.get(facturas.size() - 1).getNumeroFactura() + 1;
    }
    
    private void cargarFacturas() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_FACTURAS))) {
            String linea;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while ((linea = br.readLine()) != null && !linea.isEmpty()) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    Factura factura = new Factura(
                        Integer.parseInt(datos[0]),
                        Integer.parseInt(datos[1]),
                        sdf.parse(datos[2])
                    );
                    factura.setEstado(datos[3]);
                    facturas.add(factura);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al cargar facturas: " + e.getMessage());
        }
    }
    
    public void agregarFactura(Factura factura) {
        facturas.add(factura);

        try {
            // Guardar la factura
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_FACTURAS, true))) {
                bw.write(factura.toString());
                bw.newLine();
            }

            // Guardar los detalles
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_DETALLES, true))) {
                for (DetalleFactura detalle : factura.getDetalles()) {
                    bw.write(detalle.toString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar la factura: " + e.getMessage());
        }
    }
    
}