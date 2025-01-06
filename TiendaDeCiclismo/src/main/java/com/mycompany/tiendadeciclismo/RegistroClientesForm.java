/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tiendadeciclismo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 *Pantalla del registro de los clientes.
 * @author dnlal
 */
public class RegistroClientesForm extends javax.swing.JFrame {

    /**
     * Constructor del Form, configura y carga la tabla.
     */
    public RegistroClientesForm() {
        initComponents();
        setLocationRelativeTo(null); 
        setTitle("Registro de Clientes"); 
        lblMensajes.setText("");
        configurarTabla();
        configurarCamposBusqueda(); 
        cargarTabla();
        limpiarMensaje();
    }
    /**
     * Metodo para que el texto con el que daremos mensajes de exito o error inicie vacio y no se vea 
     * en un inicio hasta que ocurra uno de estos.
     */
    private void limpiarMensaje() {
        lblMensajes.setText("");
    }
    
    /**
     * Metodo que configura la tabla donde se mostraran los servicios.
     */
    private void configurarTabla() {
        String[] columnNames = {
            "Código", "Nombre", "Apellidos", "Teléfono", "Correo",
            "Provincia", "Cantón", "Distrito", "Fecha Nacimiento"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        jTable1.setModel(model);
    }
    
        /**
     * Metodo que carga los Clientes desde la lista de clientes de GestorClientes
     * y los muestra en la tabla.
     */
    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar tabla

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Cliente cliente : GestorClientes.getInstancia().getClientes()) {
            model.addRow(new Object[]{
                cliente.getCodigo(),
                cliente.getNombre(),
                cliente.getApellidos(), 
                cliente.getTelefono(),
                cliente.getCorreo(),
                cliente.getProvincia(),
                cliente.getCanton(),
                cliente.getDistrito(),
                sdf.format(cliente.getFechaNacimiento())
            });
        }
    }
    
    /**
     * Metodo que muestra los mensajes al usuario.
     * @param mensaje Mensaje que enseñaremos.
     * @param exito Si es un mensaje de exito(true) se mostrara en verde, si es de fracaso(false) 
     * sera en rojo.
     */
    private void mostrarMensaje(String mensaje, boolean exito) {
        lblMensajes.setText(mensaje);
        lblMensajes.setForeground(exito ? new java.awt.Color(0, 153, 0) : new java.awt.Color(204, 0, 0));
    }
    
    /**
     * Metodo que actualice la tabla para tener los datos mas nuevos luego de actualizar,
     * modificar o eliminar un cliente.
     * @param clientes La lista con los clientes cargada en memoria.
     */
    private void actualizarTabla(List<Cliente> clientes) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Cliente cliente : clientes) {
            model.addRow(new Object[]{
                cliente.getCodigo(),
                cliente.getNombre(),
                cliente.getApellidos(),
                cliente.getTelefono(),
                cliente.getCorreo(),
                cliente.getProvincia(),
                cliente.getCanton(),
                cliente.getDistrito(),
                sdf.format(cliente.getFechaNacimiento())
            });
        }
    }
    
    /**
     * Metodo para configurar los campos de busqueda de clientes, ya sea por nombre o 
     * por codigo de cliente.
     */
    private void configurarCamposBusqueda() {
        txtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtCodigo.getText().equals("Ingrese el código")) {
                    txtCodigo.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtCodigo.getText().isEmpty()) {
                    txtCodigo.setText("Ingrese el código");
                }
            }
        });

        txtNombreApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtNombreApellido.getText().equals("Ingrese el nombre/apellidos")) {
                    txtNombreApellido.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtNombreApellido.getText().isEmpty()) {
                    txtNombreApellido.setText("Ingrese el nombre/apellidos");
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombreApellido = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnNuevoCliente = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblMensajes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Registro de Clientes");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Código:");

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCodigo.setText("Ingrese el código");
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nombre/Apellidos:");

        txtNombreApellido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreApellido.setText("Ingrese el nombre/apellidos");
        txtNombreApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreApellidoActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(51, 153, 0));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Apellidos", "Teléfono", "Correo", "Provincia", "Cantón", "Distrito", "Fecha Nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnNuevoCliente.setBackground(new java.awt.Color(51, 153, 0));
        btnNuevoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNuevoCliente.setText("Nuevo Cliente");
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(0, 102, 204));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setActionCommand("Modificar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(153, 153, 153));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setActionCommand("Modificar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblMensajes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMensajes.setText("jLabel4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMensajes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoCliente)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnRegresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensajes)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(349, 349, 349))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreApellidoActionPerformed
    /**
     * Boton para buscar los clientes por codigo o nombre.
    */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String codigoText = txtCodigo.getText().trim();
        String nombreApellidos = txtNombreApellido.getText().trim();

        if (codigoText.equals("Ingrese el código")) {
            codigoText = "";
        }
        if (nombreApellidos.equals("Ingrese el nombre/apellidos")) {
            nombreApellidos = "";
        }

        if (codigoText.isEmpty() && nombreApellidos.isEmpty()) {
            cargarTabla();
            return;
        }

        try {
            Set<Cliente> clientesEncontrados = new HashSet<>(); // Usamos Set para evitar duplicados
            GestorClientes gestor = GestorClientes.getInstancia();

            // Buscar por código si se ingresó uno
            if (!codigoText.isEmpty()) {
                int codigo = Integer.parseInt(codigoText);
                clientesEncontrados.addAll(gestor.buscarClientesPorCodigo(codigo));
            }

            // Buscar por nombre/apellidos si se ingresó algo
            if (!nombreApellidos.isEmpty()) {
                clientesEncontrados.addAll(gestor.buscarClientesPorNombreApellidos(nombreApellidos));
            }

            // Convertir el Set a List para mantener la compatibilidad con el método actualizarTabla
            List<Cliente> resultados = new ArrayList<>(clientesEncontrados);
            actualizarTabla(resultados);

            if (resultados.isEmpty()) {
                mostrarMensaje("No se encontraron clientes con los criterios especificados", false);
            } else {
                mostrarMensaje("", true);
            }

        } catch (NumberFormatException e) {
            mostrarMensaje("El código debe ser un número válido", false);
        } catch (Exception e) {
            mostrarMensaje("Error al buscar clientes: " + e.getMessage(), false);
        }
   
    }//GEN-LAST:event_btnBuscarActionPerformed
    /**
     * Boton que llama a la pantalla para agregar un nuevo cliente.
     * @param evt 
     */
    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        MantenimientoClienteForm mantenimientoCliente = new MantenimientoClienteForm();
        mantenimientoCliente.setTitle("Nuevo Cliente");
        mantenimientoCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    /**
     * Boton que llama la pantalla para modificar un cliente seleccionado.
     * @param evt 
     */
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            mostrarMensaje("Por favor, seleccione un cliente para modificar", false);
            return;
        }

        try {
            int codigo = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
            Cliente cliente = GestorClientes.getInstancia().obtenerClientePorCodigo(codigo);

            if (cliente != null) {
                MantenimientoClienteForm mantenimientoCliente = new MantenimientoClienteForm(cliente);
                mantenimientoCliente.setVisible(true);
                this.dispose();
            } else {
                mostrarMensaje("Error: No se pudo encontrar el cliente seleccionado", false);
            }
        } catch (Exception e) {
            mostrarMensaje("Error al cargar el cliente para modificar: " + e.getMessage(), false);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * Boton para eliminar un cliente seleccionado.
     * @param evt 
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            mostrarMensaje("Por favor, seleccione un cliente para eliminar", false);
            return;
        }

        int codigo = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
        String nombre = jTable1.getValueAt(selectedRow, 1).toString();

        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar al cliente " + nombre + "?",
                "Confirmar eliminación",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE
        );

        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            try {
                GestorClientes gestor = GestorClientes.getInstancia();
                Cliente cliente = gestor.obtenerClientePorCodigo(codigo);

                if (cliente != null) {
                    gestor.eliminarCliente(codigo);
                    cargarTabla(); // Actualiza la tabla después de eliminar
                    mostrarMensaje("Cliente eliminado exitosamente", true);
                }
            } catch (Exception e) {
                mostrarMensaje("Error al eliminar el cliente: " + e.getMessage(), false);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Boton para regresar a la pantalla de Menu Principal.
     * @param evt 
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroClientesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroClientesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroClientesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroClientesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroClientesForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblMensajes;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombreApellido;
    // End of variables declaration//GEN-END:variables
}
