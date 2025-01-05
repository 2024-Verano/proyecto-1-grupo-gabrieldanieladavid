package com.mycompany.tiendadeciclismo;

import com.mycompany.tiendadeciclismo.productos.Articulo;
import com.mycompany.tiendadeciclismo.productos.gestorTProductosArticulos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class SeleccionArticuloDialog extends JDialog {
    private gestorTProductosArticulos gestorArticulos;
    private JTable tablaArticulos;
    private JTextField txtCantidad;
    private JButton btnAgregar;
    private JButton btnCancelar;
    private boolean articuloSeleccionado = false;
    private Articulo articuloElegido = null;
    private int cantidadElegida = 0;

    public SeleccionArticuloDialog(Frame parent) {
        super(parent, "Seleccionar Artículo", true); // true para modal
        gestorArticulos = new gestorTProductosArticulos();
        initComponents();
        cargarArticulos();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setSize(800, 500);
        setLocationRelativeTo(getOwner());

        // Panel de búsqueda
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField txtBuscar = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        searchPanel.add(new JLabel("Buscar: "));
        searchPanel.add(txtBuscar);
        searchPanel.add(btnBuscar);
        add(searchPanel, BorderLayout.NORTH);

        // Tabla de artículos
        String[] columnas = {"Código", "Nombre", "Tipo", "Marca", "Precio", "Disponible"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaArticulos = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tablaArticulos);
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior para cantidad y botones
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField(5);
        bottomPanel.add(txtCantidad);
        btnAgregar = new JButton("Agregar");
        btnCancelar = new JButton("Cancelar");
        bottomPanel.add(btnAgregar);
        bottomPanel.add(btnCancelar);
        add(bottomPanel, BorderLayout.SOUTH);

        // Configurar eventos
        btnBuscar.addActionListener(e -> buscarArticulos(txtBuscar.getText()));
        btnAgregar.addActionListener(e -> agregarArticulo());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void cargarArticulos() {
        DefaultTableModel model = (DefaultTableModel) tablaArticulos.getModel();
        model.setRowCount(0);

        for (Articulo articulo : gestorArticulos.getListaArticulos()) {
            model.addRow(new Object[]{
                articulo.getCodigo(),
                articulo.getNombre(),
                articulo.getTipo(),
                articulo.getMarca(),
                articulo.getPrecio(),
                articulo.getCantidad()
            });
        }
    }

    private void buscarArticulos(String criterio) {
        DefaultTableModel model = (DefaultTableModel) tablaArticulos.getModel();
        model.setRowCount(0);

        for (Articulo articulo : gestorArticulos.getListaArticulos()) {
            if (articulo.getNombre().toLowerCase().contains(criterio.toLowerCase()) ||
                String.valueOf(articulo.getCodigo()).contains(criterio)) {
                model.addRow(new Object[]{
                    articulo.getCodigo(),
                    articulo.getNombre(),
                    articulo.getTipo(),
                    articulo.getMarca(),
                    articulo.getPrecio(),
                    articulo.getCantidad()
                });
            }
        }
    }

    private void agregarArticulo() {
        int selectedRow = tablaArticulos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, seleccione un artículo",
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int cantidad = Integer.parseInt(txtCantidad.getText());
            int disponible = Integer.parseInt(tablaArticulos.getValueAt(selectedRow, 5).toString());

            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, 
                    "La cantidad debe ser mayor a 0",
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cantidad > disponible) {
                JOptionPane.showMessageDialog(this, 
                    "No hay suficiente existencia",
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            int codigo = Integer.parseInt(tablaArticulos.getValueAt(selectedRow, 0).toString());
            articuloElegido = gestorArticulos.buscarArticulo(codigo);
            cantidadElegida = cantidad;
            articuloSeleccionado = true;
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "La cantidad debe ser un número válido",
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isArticuloSeleccionado() {
        return articuloSeleccionado;
    }

    public Articulo getArticuloElegido() {
        return articuloElegido;
    }

    public int getCantidadElegida() {
        return cantidadElegida;
    }
}