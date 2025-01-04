/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tiendadeciclismo.mantenimiento.ParteGrafica;

import com.mycompany.tiendadeciclismo.RegistroClientesForm;
import com.mycompany.tiendadeciclismo.ServicioMantenimiento;
import com.mycompany.tiendadeciclismo.mantenimiento.GestorMantenimiento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

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
        CodigoServicio.setEditable(false);
        CodigoCliente.setEditable(true);
        CodigoCliente.setEnabled(true);
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
        
        for (ActionListener al : CodigoCliente.getActionListeners()) {
            CodigoCliente.removeActionListener(al);
        }
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
        }else{
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

            CodigoCliente.setEditable(true);
            CodigoCliente.setText(String.valueOf(servicioEditar.getCodigoCliente()));

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

        CodigoCliente.setText("");
        Bicicleta.setText("");
        Descripcion.setText("");
        Precio.setText("");
        FechaRecibo.setText("");
        FechaEntrega.setText("");
        Observaciones.setText("");
        Estado.setEditable(false);
        Estado.setText("Abierto");
    }
    
    
    private boolean validarCampos() {
        GestorMantenimiento gestor = GestorMantenimiento.getInstancia();

        if (CodigoCliente.getText().equals("Ingrese el codigo del cliente")) {
            mostrarError("El codigo del cliente es obligatorio", CodigoCliente);
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
            
        String CodCliente = CodigoCliente.getText().trim();
        if (CodCliente.isEmpty()) {
            mostrarError("El codigo de cliente es obligatorio", CodigoCliente);
            return false;
        }

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

        try {
            Integer exceptoCodigo = modoEdicion ? servicioEditar.getCodigoServicio() : null;

        } catch (Exception e) {
            mostrarError("Error al validar duplicados: " + e.getMessage(), null);
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

        CodigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (CodigoCliente.getText().equals("Ingrese el codigo de cliente")) {
                    CodigoCliente.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (CodigoCliente.getText().isEmpty()) {
                    CodigoCliente.setText("Ingrese el codigo de cliente");
                }
            }
        });

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
        CodigoCliente = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Cancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Observaciones");

        Agregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Agregar.setText("Agregar");
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

        CodigoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CodigoCliente.setText("Ingrese el codigo de cliente");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CodigoCliente)
                                .addComponent(CodigoServicio)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Observaciones))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(Estado))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(FechaEntrega))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Bicicleta))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(14, 14, 14)
                                    .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(FechaRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(6, 6, 6))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addComponent(Agregar)
                                    .addGap(94, 94, 94)
                                    .addComponent(Cancelar))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(94, 94, 94)
                                    .addComponent(mensajeDialog)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CodigoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(mensajeDialog)
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Agregar)
                        .addComponent(Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
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

            String codigoCliente =CodigoCliente.getText().trim();
            int codCliente=Integer.parseInt(codigoCliente);
            String bicicleta = Bicicleta.getText().trim();
            String descripcion = Descripcion.getText().trim();
            String precioX = Precio.getText().trim();
            int precio=Integer.parseInt(precioX);
            String fechaRecibido = FechaRecibo.getText().trim();
            String fechaEntrega = FechaEntrega.getText().trim();
            String observaciones =Observaciones.getText().trim();
            String estado=Estado.getText().trim();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaRecib = sdf.parse(fechaRecibido);
            Date fechaEntreg = sdf.parse(fechaEntrega);
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
            mensajeDialog.setText("Error al " + (modoEdicion ? "modificar" : "guardar") + " el cliente: " + e.getMessage());
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
    private javax.swing.JTextField CodigoCliente;
    private javax.swing.JTextField CodigoServicio;
    private javax.swing.JTextField Descripcion;
    private javax.swing.JTextField Estado;
    private javax.swing.JTextField FechaEntrega;
    private javax.swing.JTextField FechaRecibo;
    private javax.swing.JTextField Observaciones;
    private javax.swing.JTextField Precio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel mensajeDialog;
    // End of variables declaration//GEN-END:variables
}
