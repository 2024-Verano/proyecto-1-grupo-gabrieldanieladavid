/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tiendadeciclismo;

/**
 *
 * @author dnlal
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Tienda de Ciclismo - Menú Principal");
    }
    
    private void cerrarSesion() {
        LoginForm login = new LoginForm();
        login.setVisible(true);
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnRegistroCliente = new javax.swing.JButton();
        btnRegistroProductos = new javax.swing.JButton();
        btnServicioMantenimiento = new javax.swing.JButton();
        btnFacturacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Menu Principal");

        btnRegistroCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistroCliente.setText("Registro de cliente");
        btnRegistroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroClienteActionPerformed(evt);
            }
        });

        btnRegistroProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistroProductos.setText("Registro bicicletas y accesorios");
        btnRegistroProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroProductosActionPerformed(evt);
            }
        });

        btnServicioMantenimiento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnServicioMantenimiento.setText("Registro de servicio de taller");
        btnServicioMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicioMantenimientoActionPerformed(evt);
            }
        });

        btnFacturacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFacturacion.setText("Facturación de productos");
        btnFacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistroProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistroCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnServicioMantenimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFacturacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel2)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnRegistroProductos)
                .addGap(18, 18, 18)
                .addComponent(btnRegistroCliente)
                .addGap(18, 18, 18)
                .addComponent(btnServicioMantenimiento)
                .addGap(18, 18, 18)
                .addComponent(btnFacturacion)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroClienteActionPerformed
        System.out.println("Registro de clientes");
    }//GEN-LAST:event_btnRegistroClienteActionPerformed

    private void btnRegistroProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroProductosActionPerformed
        System.out.println("Registro de productos");
    }//GEN-LAST:event_btnRegistroProductosActionPerformed

    private void btnServicioMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicioMantenimientoActionPerformed
        System.out.println("Servicio de mantenimiento");
    }//GEN-LAST:event_btnServicioMantenimientoActionPerformed

    private void btnFacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturacionActionPerformed
        System.out.println("Facturación");
    }//GEN-LAST:event_btnFacturacionActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFacturacion;
    private javax.swing.JButton btnRegistroCliente;
    private javax.swing.JButton btnRegistroProductos;
    private javax.swing.JButton btnServicioMantenimiento;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
