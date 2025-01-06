/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tiendadeciclismo.mantenimiento.ParteGrafica;


import com.mycompany.tiendadeciclismo.Cliente;
import com.mycompany.tiendadeciclismo.GestorClientes;
import com.mycompany.tiendadeciclismo.ServicioMantenimiento;
import com.mycompany.tiendadeciclismo.mantenimiento.GestorMantenimiento;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Gabriel Garro
 */
public class PantallaServicioMantenimiento extends javax.swing.JFrame {
        private boolean modoEdicion = false;
        private ServicioMantenimiento servicioEditar = null;
    /**
     * Creates new form PantallaServicioMantenimiento
     */
    public PantallaServicioMantenimiento() {
        this(null);
    }
    public PantallaServicioMantenimiento(ServicioMantenimiento servicio){
        initComponents();
        setLocationRelativeTo(null);
        cargarClientes();
        CodigoServicio.setEditable(false);
        Bicicleta.setEditable(true);
        Bicicleta.setEnabled(true);
        Descripcion.setEditable(true);
        Descripcion.setEnabled(true);
        FechaRecibo.setEditable(true);
        FechaRecibo.setEnabled(true);
        FechaEntrega.setEditable(true);
        FechaEntrega.setEnabled(true);
        Observaciones.setEditable(true);
        Observaciones.setEnabled(true);
        

        for (ActionListener al : Bicicleta.getActionListeners()) {
            Bicicleta.removeActionListener(al);
        }
        for (ActionListener al : Descripcion.getActionListeners()) {
            Descripcion.removeActionListener(al);
        }
        for (ActionListener al : FechaRecibo.getActionListeners()) {
            FechaRecibo.removeActionListener(al);
        }
        for (ActionListener al : FechaEntrega.getActionListeners()) {
            FechaEntrega.removeActionListener(al);
        }
        for (ActionListener al : Observaciones.getActionListeners()) {
            Observaciones.removeActionListener(al);
        }
        mensajeDialog.setText("");
        if (servicio != null) {
            modoEdicion = true;
            servicioEditar = servicio;
            setTitle("Modificar Servicio");
            cargarDatosServicio();
        } else {
            setTitle("Nuevo Servicio");
            configurarComponentes();
            configurarEventosCampos();
        }}
        
    private void cargarDatosServicio(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (servicioEditar != null) {
            setTitle("Modificar Servicio");

            CodigoServicio.setEditable(false);
            CodigoServicio.setText(String.valueOf(servicioEditar.getCodigoServicio()));

            for (int i = 0; i < cmbClientes.getItemCount(); i++) {
                String item = cmbClientes.getItemAt(i);
                int codigo = Integer.parseInt(item.split(" - ")[0]);
                if (codigo == servicioEditar.getCodigoCliente()) {
                    cmbClientes.setSelectedIndex(i);
                    break;
                }
            }
            Bicicleta.setEditable(true);
            Bicicleta.setEnabled(true);
            Bicicleta.setText(servicioEditar.getMarcaBicicleta());

            Descripcion.setEditable(true);
            Descripcion.setEnabled(true);
            Descripcion.setText(servicioEditar.getDescripcionBicicleta());

            Precio.setEditable(true);
            Precio.setText(String.valueOf(servicioEditar.getPrecio()));

            FechaRecibo.setEditable(true);
            FechaRecibo.setEnabled(true);
            FechaRecibo.setText(sdf.format(servicioEditar.getFechaRecibido()));
            
            FechaEntrega.setEditable(true);
            FechaEntrega.setEnabled(true);
            FechaEntrega.setText(sdf.format(servicioEditar.getFechaEntrega()));
            
            Observaciones.setEditable(true);
            Observaciones.setEnabled(true);
            Observaciones.setText(servicioEditar.getObservaciones());
            
            Estado.setEditable(true);
            Estado.setEnabled(true);
            Estado.setText(servicioEditar.getEstado());


            Agregar.setText("Agregar");
            mensajeDialog.setText("");
        }
}
        private void configurarComponentes() {
        CodigoServicio.setEditable(false);
        CodigoServicio.setText(String.valueOf(GestorMantenimiento.getInstancia().obtenerSiguienteCodigo()));

        Bicicleta.setText("");
        Descripcion.setText("");
        Precio.setText("");
        FechaRecibo.setText("");
        FechaEntrega.setText("");
        Observaciones.setText("");
        Estado.setEditable(false);
        Estado.setText("Abierto");
    }
        
        private void cargarClientes() {
        cmbClientes.removeAllItems(); // Limpia el combobox

        // Obtiene la instancia del gestor de clientes
        GestorClientes gestorClientes = GestorClientes.getInstancia();

        // Obtiene la lista de clientes y los agrega al combobox
        for (Cliente cliente : gestorClientes.getClientes()) {
            cmbClientes.addItem(cliente.getCodigo() + " - "
                    + cliente.getNombre() + " "
                    + cliente.getApellidos());
        }
    }
    
    
    private boolean validarCampos() {
        GestorMantenimiento gestor = GestorMantenimiento.getInstancia();
        
        if (cmbClientes.getSelectedItem() == null) {
            mostrarError("Debe seleccionar un cliente", cmbClientes);
            return false;
        }


        if (Bicicleta.getText().equals("Ingrese la marca de Bici")) {
            mostrarError("La marca de la bici es obligatorios", Bicicleta);
            return false;
        }

        if (Descripcion.getText().equals("Ingrese una pequeña descripcion de la Bici")) {
            mostrarError("La descripcion es obligatoria", Descripcion);
            return false;
        }

        if (Precio.getText().equals("Ingrese el precio")) {
            mostrarError("El precio es obligatorio", Precio);
            return false;
        }

        if (FechaRecibo.getText().equals("Fecha de Recibido")) {
            mostrarError("La fecha de recibido es obligatoria", FechaRecibo);
            return false;
        }
        if (FechaEntrega.getText().equals("Fecha de Entrega")) {
            mostrarError("La fecha de entrega es obligatoria", FechaEntrega);
            return false;
        }
        if (Observaciones.getText().equals("Observaciones")) {
            mostrarError("Las observaciones son obligatorias", Observaciones);
            return false;}
            

        String NomBicicleta = Bicicleta.getText().trim();
        if (NomBicicleta.isEmpty()) {
            mostrarError("La marca de la bici es obligatoria",Bicicleta);
            return false;
        }

        String DescripcionBici = Descripcion.getText().trim();
        if (DescripcionBici.isEmpty()) {
            mostrarError("La descripcion es obligatoria", Descripcion);
            return false;
        }

        String PrecioServ = Precio.getText().trim();
        if (PrecioServ.isEmpty()) {
            mostrarError("El precio es obligatorio", Precio);
            return false;
        }

        return true;
    }
    
    
        private void mostrarError(String mensaje, javax.swing.JComponent componente) {
        mensajeDialog.setText(mensaje);
        mensajeDialog.setForeground(new java.awt.Color(204, 0, 0)); // Rojo para errores
        if (componente != null) {
            componente.requestFocus();
        }
    }
    
    void configurarEventosCampos() {
        CodigoServicio.setEditable(false);
        CodigoServicio.setText(String.valueOf(GestorMantenimiento.getInstancia().obtenerSiguienteCodigo()));


        Bicicleta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (Bicicleta.getText().equals("Ingrese la marca de bicicleta")) {
                    Bicicleta.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (Bicicleta.getText().isEmpty()) {
                    Bicicleta.setText("Ingrese la marca de bicicleta");
                }
            }
        });

        Descripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (Descripcion.getText().equals("Ingrese descripcion de la bici")) {
                    Descripcion.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (Descripcion.getText().isEmpty()) {
                    Descripcion.setText("Ingrese descripcion de la bici");
                }
            }
        });

        
        Precio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (Precio.getText().equals("Ingrese precio del servicio de mantenimiento")) {
                    Precio.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (Precio.getText().isEmpty()) {
                    Precio.setText("Ingrese precio del servicio de mantenimiento");
                }
            }
        });

        
        FechaRecibo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (FechaRecibo.getText().equals("Fecha")) {
                    FechaRecibo.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (FechaRecibo.getText().isEmpty()) {
                    FechaRecibo.setText("Fecha");
                }
            }
        });
                FechaEntrega.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (FechaEntrega.getText().equals("Fecha")) {
                    FechaEntrega.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (FechaEntrega.getText().isEmpty()) {
                    FechaEntrega.setText("Fecha");
                }
            }
        });
        
            Observaciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (Observaciones.getText().equals("Observaciones")) {
                    Observaciones.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (Observaciones.getText().isEmpty()) {
                    Observaciones.setText("Observaciones del mantenimiento");
                }
            }
            });}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Agregar = new javax.swing.JButton();
        mensajeDialog = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CodigoServicio = new javax.swing.JTextField();
        Descripcion = new javax.swing.JTextField();
        Precio = new javax.swing.JTextField();
        Bicicleta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        FechaRecibo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Observaciones = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Estado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        FechaEntrega = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        cmbClientes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Cancelar.setBackground(new java.awt.Color(204, 0, 0));
        Cancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Observaciones");

        Agregar.setBackground(new java.awt.Color(51, 153, 0));
        Agregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Agregar.setText("Guardar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        mensajeDialog.setText("jLabel13");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Estado:");

        CodigoServicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CodigoServicio.setText("Codigo del servicio");
        CodigoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoServicioActionPerformed(evt);
            }
        });

        Descripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Descripcion.setText("Ingrese descripcion de la bici");
        Descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescripcionActionPerformed(evt);
            }
        });

        Precio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Precio.setText("Ingrese precio del servicio de mantenimiento");

        Bicicleta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Bicicleta.setText("Ingrese la marca de bicicleta");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Marca de Bicicleta:");

        FechaRecibo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FechaRecibo.setText("Fecha");
        FechaRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaReciboActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Codigo de Cliente:");

        Observaciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Observaciones.setText("Observaciones del mantenimiento");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Codigo de Servicio:");

        Estado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Estado.setText("Estado del servicio(abierto/cerrado)");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Descripcion de Bicicleta:");

        FechaEntrega.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FechaEntrega.setText("Fecha");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Precio:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Fecha Recibido(DD/MM/YYYY)");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Fecha de Entrega(DD/MM/YYYY)");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitulo.setText("Servicio");

        cmbClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mensajeDialog)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Observaciones))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(Estado))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(FechaEntrega))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Bicicleta))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(14, 14, 14)
                        .addComponent(Precio, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FechaRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CodigoServicio)
                            .addComponent(cmbClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(167, 167, 167))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodigoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bicicleta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Agregar)
                    .addComponent(Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(mensajeDialog)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        ServicioMantenimientoForm registroServicios = new ServicioMantenimientoForm();
        registroServicios.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_CancelarActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        if (!validarCampos()) {
            return;
        }

        try {
            GestorMantenimiento gestor = GestorMantenimiento.getInstancia();

            String selectedItem = (String) cmbClientes.getSelectedItem();
            if (selectedItem == null) {
                mostrarError("Debe seleccionar un cliente", cmbClientes);
                return;
            }
            int codCliente = Integer.parseInt(selectedItem.split(" - ")[0]);

            String bicicleta = Bicicleta.getText().trim();
            String descripcion = Descripcion.getText().trim();
            String precioX = Precio.getText().trim();
            int precio = Integer.parseInt(precioX);
            String fechaRecibido = FechaRecibo.getText().trim();
            String fechaEntrega = FechaEntrega.getText().trim();
            String observaciones =Observaciones.getText().trim();
            String estado=Estado.getText().trim();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaRecib = sdf.parse(fechaRecibido);
            Date fechaEntreg = sdf.parse(fechaEntrega);
            
            if (fechaEntreg.before(fechaRecib)) {
                mostrarError("Error: Fecha de entrega no puede ser anterior a fecha de recibo.",FechaEntrega);
            return; 
            }
            if (precio<0){
                mostrarError("El precio tiene que ser mayor o igual a 0",Precio);
                    return;
            }
            ServicioMantenimiento servicio;
            if (modoEdicion) {

                servicio = new ServicioMantenimiento(
                    servicioEditar.getCodigoServicio(),
                    codCliente,
                    bicicleta,
                    descripcion,
                    precio,
                    fechaRecib,
                    fechaEntreg,
                    observaciones,
                    estado
                );
                
                gestor.modificarServicio(servicio);
                mensajeDialog.setText("Servicio modificado exitosamente");
            } else {

                servicio = new ServicioMantenimiento(
                    gestor.obtenerSiguienteCodigo(),
                    codCliente,
                    bicicleta,
                    descripcion,
                    precio,
                    fechaRecib,
                    fechaEntreg,
                    observaciones,
                    estado

                );
              
                gestor.agregarServicio(servicio);
                mensajeDialog.setText("Servicio guardado exitosamente");
            }ServicioMantenimientoForm registroServicios = new ServicioMantenimientoForm();
            registroServicios.setVisible(true);
            this.dispose();

        } catch (ParseException e) {
            mensajeDialog.setText("Error en el formato de la fecha");
        } catch (Exception e) {
            mensajeDialog.setText("Error al " + (modoEdicion ? "modificar" : "guardar") + " el servicio: " + e.getMessage());
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void CodigoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoServicioActionPerformed

    private void DescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionActionPerformed

    private void FechaReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaReciboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaReciboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaServicioMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaServicioMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaServicioMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaServicioMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaServicioMantenimiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JTextField Bicicleta;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField CodigoServicio;
    private javax.swing.JTextField Descripcion;
    private javax.swing.JTextField Estado;
    private javax.swing.JTextField FechaEntrega;
    private javax.swing.JTextField FechaRecibo;
    private javax.swing.JTextField Observaciones;
    private javax.swing.JTextField Precio;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel mensajeDialog;
    // End of variables declaration//GEN-END:variables
}
