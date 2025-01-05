/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tiendadeciclismo.mantenimiento.ParteGrafica;
import com.mycompany.tiendadeciclismo.Cliente;
import com.mycompany.tiendadeciclismo.GestorClientes;
import com.mycompany.tiendadeciclismo.MantenimientoClienteForm;
import com.mycompany.tiendadeciclismo.MenuPrincipal;
import com.mycompany.tiendadeciclismo.ServicioMantenimiento;
import com.mycompany.tiendadeciclismo.mantenimiento.GestorMantenimiento;
import com.mycompany.tiendadeciclismo.mantenimiento.ParteGrafica.PantallaServicioMantenimiento;


     
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author GGarro
 */
public class ServicioMantenimientoForm extends javax.swing.JFrame {

    /**
     * Creates new form ServicioMantenimientoPanel
     */
    public ServicioMantenimientoForm() {
        initComponents();
        setLocationRelativeTo(null); 
        setTitle("Servicio de Mantenimiento"); 
        mensajes.setText("");
        Tabla();
        configurarCamposBusqueda(); 
        cargarTabla();
        limpiarMensaje();
    }
    public void limpiarMensaje(){
        mensajes.setText("");}

    public void Tabla(){
        String[] columnNames = {
            "Codigo Servicio","Codigo Cliente","Nombre Cliente","Bicicleta","Descripcion Bicicleta",
            "Precio","Fecha Recibida","Fecha Entrega","Observaciones","Estado"
        };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        jTable2.setModel(model);
    }            
    private void mostrarMensaje(String mensaje, boolean exito) {
        mensajes.setText(mensaje);
        mensajes.setForeground(exito ? new java.awt.Color(0, 153, 0) : new java.awt.Color(204, 0, 0));
    }

    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (ServicioMantenimiento servicio : GestorMantenimiento.getInstancia().getServicios()) {       
            model.addRow(new Object[]{
                servicio.getCodigoServicio(),
                servicio.getCodigoCliente(),
                servicio.obtenerNombreCliente(servicio.getCodigoCliente()),
                servicio.getMarcaBicicleta(), 
                servicio.getDescripcionBicicleta(),
                servicio.getPrecio(),
                sdf.format(servicio.getFechaRecibido()),
                sdf.format(servicio.getFechaEntrega()),
                servicio.getObservaciones(),
                servicio.getEstado(),
            });
        }
    }
    
    public void ActualizarTabla(List<ServicioMantenimiento>servicios){
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (ServicioMantenimiento servicio : servicios) {       
            model.addRow(new Object[]{
                servicio.getCodigoServicio(),
                servicio.getCodigoCliente(),
                servicio.obtenerNombreCliente(servicio.getCodigoCliente()),
                servicio.getMarcaBicicleta(), 
                servicio.getDescripcionBicicleta(),
                servicio.getPrecio(),
                sdf.format(servicio.getFechaRecibido()),
                sdf.format(servicio.getFechaEntrega()),
                servicio.getObservaciones(),
                servicio.getEstado(),
            });
        }
    }
        private void configurarCamposBusqueda() {
        buscarCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (buscarCodigo.getText().equals("Ingrese el código de servicio")) {
                    buscarCodigo.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (buscarCodigo.getText().isEmpty()) {
                    buscarCodigo.setText("Ingrese el código de servicio");
                }
            }
        });

        buscarNombreApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (buscarNombreApellidos.getText().equals("Ingrese el nombre/apellidos")) {
                    buscarNombreApellidos.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (buscarNombreApellidos.getText().isEmpty()) {
                    buscarNombreApellidos.setText("Ingrese el nombre/apellidos");
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buscarCodigo = new javax.swing.JTextField();
        buscarNombreApellidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mensajes = new javax.swing.JLabel();
        Agregar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Servicio", "Codigo Cliente", "Nombre Cliente", "Marca Bicicleta", "Descripcion Bicicleta", "Precio", "Fecha Recibido", "Fecha Entrega", "Observaciones", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Servicio de Mantenimiento");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        buscarCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buscarCodigo.setText("Ingrese el código de servicio");
        buscarCodigo.setPreferredSize(new java.awt.Dimension(237, 31));
        buscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCodigoActionPerformed(evt);
            }
        });

        buscarNombreApellidos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buscarNombreApellidos.setText("Ingrese el nombre/apellidos");
        buscarNombreApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarNombreApellidosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Buscar por nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Buscar por codigo:");

        mensajes.setText("jLabel4");

        Agregar.setBackground(new java.awt.Color(51, 153, 0));
        Agregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Agregar.setText("Agregar Servicio");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Modificar.setBackground(new java.awt.Color(0, 102, 204));
        Modificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        Eliminar.setBackground(new java.awt.Color(204, 0, 0));
        Eliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Regresar.setBackground(new java.awt.Color(204, 204, 204));
        Regresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Regresar.setForeground(new java.awt.Color(0, 0, 0));
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regresar)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(buscarNombreApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(mensajes))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jButton1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buscarNombreApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Agregar)
                            .addComponent(Modificar)
                            .addComponent(Eliminar))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Regresar)
                        .addGap(4, 4, 4)))
                .addComponent(mensajes)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarNombreApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarNombreApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarNombreApellidosActionPerformed

    private void buscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCodigoActionPerformed

    }//GEN-LAST:event_buscarCodigoActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
    PantallaServicioMantenimiento form = new PantallaServicioMantenimiento();
    form.setVisible(true);
    this.dispose();
     
    }//GEN-LAST:event_AgregarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow == -1) {
            mostrarMensaje("Por favor, seleccione un servicio para modificar", false);
            return;
        }

        try {
            int codigo = Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString());
            ServicioMantenimiento servicio = GestorMantenimiento.getInstancia().buscarPorCodigo(codigo);

            if (servicio != null) {
                PantallaServicioMantenimiento modificarServicio = new PantallaServicioMantenimiento(servicio);
                modificarServicio.setVisible(true);
                this.dispose();
            } else {
                mostrarMensaje("Error: No se pudo encontrar el servicio seleccionado", false);
            }
        } catch (Exception e) {
            mostrarMensaje("Error al cargar el servicio para modificar: " + e.getMessage(), false);
        }
    }//GEN-LAST:event_ModificarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow == -1) {
            mostrarMensaje("Por favor, seleccione un servicio a eliminar", false);
            return;
        }

        int codigo = Integer.parseInt(jTable2.getValueAt(selectedRow, 0).toString());
        String nombre = jTable2.getValueAt(selectedRow, 2).toString();
        String estado = jTable2.getValueAt(selectedRow, 9).toString();
        if(estado.equals("Cerrado")){
            mostrarMensaje("No se puede eliminar un servicio que ya ha sido cerrado",false);}
        else{int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar el servicio de " + nombre + "?",
                "Confirmar eliminación",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE
        );

        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            try {
                GestorMantenimiento gestor = GestorMantenimiento.getInstancia();
                ServicioMantenimiento servicio =gestor.buscarPorCodigo(codigo);

                if (servicio != null) {
                    gestor.eliminarServicio(codigo);
                    cargarTabla(); // Actualiza la tabla después de eliminar
                    mostrarMensaje("Servicio eliminado exitosamente", true);
                }
            } catch (Exception e) {
                mostrarMensaje("Error al eliminar el servicio: " + e.getMessage(), false);
                }
            }
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String codigoServicio = buscarCodigo.getText().trim();
        String nombreApellidos = buscarNombreApellidos.getText().trim();
        if (codigoServicio.equals("Ingrese el código de servicio")||codigoServicio.isEmpty()) {
            codigoServicio = "";
        }
        if (nombreApellidos.equals("Ingrese el nombre/apellidos")) {
            nombreApellidos = "";
        }

        if ((codigoServicio.isEmpty()) && nombreApellidos.isEmpty()) {
            cargarTabla();
            return;
        }
        try {
            Set<ServicioMantenimiento> serviciosEncontrados = new HashSet<>(); // Usamos Set para evitar duplicados
            GestorMantenimiento gestor = GestorMantenimiento.getInstancia();
            
            if (!nombreApellidos.isEmpty()) {
                serviciosEncontrados.addAll(gestor.buscarPorNombre(nombreApellidos));
            }
            // Buscar por código si se ingresó uno
            if (!codigoServicio.isEmpty()){
                int codigo= Integer.parseInt(codigoServicio);
                serviciosEncontrados.addAll(gestor.buscarServicioPorCodigo(codigo));
            }

            // Buscar por nombre/apellidos si se ingresó algo


            // Convertir el Set a List para mantener la compatibilidad con el método actualizarTabla
            List<ServicioMantenimiento> resultados = new ArrayList<>(serviciosEncontrados);
            ActualizarTabla(resultados);

            if (resultados.isEmpty()) {
                mostrarMensaje("No se encontraron servicios con los criterios especificados", false);
            } else {
                mostrarMensaje("", true);
            }

        }catch (NumberFormatException e) {
            mostrarMensaje("El código debe ser un número válido", false);
        }
         catch (Exception e) {
            mostrarMensaje("Error al buscar servicios: " + e.getMessage(), false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

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
            java.util.logging.Logger.getLogger(ServicioMantenimientoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServicioMantenimientoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServicioMantenimientoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServicioMantenimientoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServicioMantenimientoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton Regresar;
    private javax.swing.JTextField buscarCodigo;
    private javax.swing.JTextField buscarNombreApellidos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel mensajes;
    // End of variables declaration//GEN-END:variables
}
