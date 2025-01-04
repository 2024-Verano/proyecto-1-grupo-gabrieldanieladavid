/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tiendadeciclismo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author dnlal
 */
public class MantenimientoClienteForm extends javax.swing.JFrame {
    private DivisionTerritorial divisionTerritorial;
    private boolean modoEdicion = false;
    private Cliente clienteEditar = null;

    /**
     * Creates new form MantenimientoClienteForm
     */
    public MantenimientoClienteForm() {
        this(null);
    }

    public MantenimientoClienteForm(Cliente cliente) {
        initComponents();

        // Forzar que los campos sean editables y habilitados inmediatamente después de initComponents
        txtNombre.setEditable(true);
        txtNombre.setEnabled(true);
        txtApellidos.setEditable(true);
        txtApellidos.setEnabled(true);
        txtTelefono.setEditable(true);
        txtTelefono.setEnabled(true);
        txtCorreo.setEditable(true);
        txtCorreo.setEnabled(true);
        txtFechaNacimiento.setEditable(true);
        txtFechaNacimiento.setEnabled(true);

        // Eliminar los ActionListeners existentes
        for (ActionListener al : txtNombre.getActionListeners()) {
            txtNombre.removeActionListener(al);
        }
        for (ActionListener al : txtApellidos.getActionListeners()) {
            txtApellidos.removeActionListener(al);
        }
        for (ActionListener al : txtTelefono.getActionListeners()) {
            txtTelefono.removeActionListener(al);
        }
        for (ActionListener al : txtCorreo.getActionListeners()) {
            txtCorreo.removeActionListener(al);
        }
        for (ActionListener al : txtFechaNacimiento.getActionListeners()) {
            txtFechaNacimiento.removeActionListener(al);
        }

        divisionTerritorial = DivisionTerritorial.getInstancia();
        inicializarCombos();
        configurarListeners();
        setLocationRelativeTo(null);
        lblMensajes.setText("");

        if (cliente != null) {
            modoEdicion = true;
            clienteEditar = cliente;
            setTitle("Modificar Cliente - " + cliente.getNombre());
            cargarDatosCliente();
        } else {
            setTitle("Nuevo Cliente");
            configurarComponentes();
            configurarEventosCampos();
        }
    }
    
    private void cargarDatosCliente() {
        if (clienteEditar != null) {
            setTitle("Modificar Cliente - " + clienteEditar.getNombre());

            txtCodigo.setEditable(false);
            txtCodigo.setText(String.valueOf(clienteEditar.getCodigo()));

            txtNombre.setEditable(true);
            txtNombre.setEnabled(true);
            txtNombre.setText(clienteEditar.getNombre());

            txtApellidos.setEditable(true);
            txtApellidos.setEnabled(true);
            txtApellidos.setText(clienteEditar.getApellidos());

            txtTelefono.setEditable(true);
            txtTelefono.setEnabled(true);
            txtTelefono.setText(clienteEditar.getTelefono());

            txtCorreo.setEditable(true);
            txtCorreo.setEnabled(true);
            txtCorreo.setText(clienteEditar.getCorreo());

            cmbProvincia.setSelectedItem(clienteEditar.getProvincia());

            try {
                Thread.sleep(100);
                cmbCanton.setSelectedItem(clienteEditar.getCanton());
                Thread.sleep(100);
                cmbDistrito.setSelectedItem(clienteEditar.getDistrito());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            txtFechaNacimiento.setEditable(true);
            txtFechaNacimiento.setEnabled(true);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            txtFechaNacimiento.setText(sdf.format(clienteEditar.getFechaNacimiento()));

            btnGuardar.setText("Guardar");
            txtNombre.requestFocus();
            lblMensajes.setText("");
        }
    }
    
    
     private void configurarComponentes() {
        txtCodigo.setEditable(false);
        txtCodigo.setText(String.valueOf(GestorClientes.getInstancia().obtenerSiguienteCodigo()));

        txtNombre.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtFechaNacimiento.setText("");
    }
    
    private void inicializarCombos() {

        cmbProvincia.removeAllItems();
        cmbCanton.removeAllItems();
        cmbDistrito.removeAllItems();

        for (Division provincia : divisionTerritorial.getProvincias()) {
            cmbProvincia.addItem(provincia.getNombre());
        }

        cmbProvincia.setSelectedItem("San José");

        actualizarCantones();
    }

    private void configurarListeners() {
        cmbProvincia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCantones();
            }
        });

        cmbCanton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDistritos();
            }
        });
    }

    private void actualizarCantones() {
        String provinciaNombre = (String) cmbProvincia.getSelectedItem();
        Division provincia = divisionTerritorial.getProvincia(provinciaNombre);

        cmbCanton.removeAllItems();
        cmbDistrito.removeAllItems();

        if (provincia != null) {
            for (Division canton : provincia.getSubdivisiones()) {
                cmbCanton.addItem(canton.getNombre());
            }

            if (cmbCanton.getItemCount() > 0) {
                cmbCanton.setSelectedIndex(0);
                actualizarDistritos();
            }
        }
    }

    private void actualizarDistritos() {
        String provinciaNombre = (String) cmbProvincia.getSelectedItem();
        String cantonNombre = (String) cmbCanton.getSelectedItem();

        Division provincia = divisionTerritorial.getProvincia(provinciaNombre);
        Division canton = null;

        if (provincia != null && cantonNombre != null) {
            for (Division c : provincia.getSubdivisiones()) {
                if (c.getNombre().equals(cantonNombre)) {
                    canton = c;
                    break;
                }
            }
        }

        cmbDistrito.removeAllItems();

        if (canton != null) {
            for (Division distrito : canton.getSubdivisiones()) {
                cmbDistrito.addItem(distrito.getNombre());
            }

            if (cmbDistrito.getItemCount() > 0) {
                cmbDistrito.setSelectedIndex(0);
            }
        }
    }
    
    private boolean validarCampos() {
        GestorClientes gestor = GestorClientes.getInstancia();

        if (txtNombre.getText().equals("Ingrese el nombre")) {
            mostrarError("El nombre es obligatorio", txtNombre);
            return false;
        }

        if (txtApellidos.getText().equals("Ingrese los apellidos")) {
            mostrarError("Los apellidos son obligatorios", txtApellidos);
            return false;
        }

        if (txtTelefono.getText().equals("Ingrese el teléfono")) {
            mostrarError("El teléfono es obligatorio", txtTelefono);
            return false;
        }

        if (txtCorreo.getText().equals("Ingrese el correo")) {
            mostrarError("El correo es obligatorio", txtCorreo);
            return false;
        }

        if (txtFechaNacimiento.getText().equals("Fecha")) {
            mostrarError("La fecha de nacimiento es obligatoria", txtFechaNacimiento);
            return false;
        }

        String nombre = txtNombre.getText().trim();
        if (nombre.isEmpty()) {
            mostrarError("El nombre es obligatorio", txtNombre);
            return false;
        }

        String apellidos = txtApellidos.getText().trim();
        if (apellidos.isEmpty()) {
            mostrarError("Los apellidos son obligatorios", txtApellidos);
            return false;
        }

        String telefono = txtTelefono.getText().trim();
        if (telefono.isEmpty()) {
            mostrarError("El teléfono es obligatorio", txtTelefono);
            return false;
        }

        String correo = txtCorreo.getText().trim();
        if (correo.isEmpty()) {
            mostrarError("El correo electrónico es obligatorio", txtCorreo);
            return false;
        }

        if (!gestor.validarTelefono(telefono)) {
            mostrarError("El teléfono debe tener 8 dígitos y empezar con 2, 4, 6 u 8", txtTelefono);
            return false;
        }

        if (!gestor.validarCorreo(correo)) {
            mostrarError("El correo electrónico no tiene un formato válido", txtCorreo);
            return false;
        }

        try {
            Integer exceptoCodigo = modoEdicion ? clienteEditar.getCodigo() : null;

            if (gestor.existeCorreo(correo, exceptoCodigo)) {
                mostrarError("Ya existe un cliente con ese correo electrónico", txtCorreo);
                return false;
            }

            if (gestor.existeTelefono(telefono, exceptoCodigo)) {
                mostrarError("Ya existe un cliente con ese número de teléfono", txtTelefono);
                return false;
            }
        } catch (Exception e) {
            mostrarError("Error al validar duplicados: " + e.getMessage(), null);
            return false;
        }
        
        if (cmbProvincia.getSelectedIndex() == -1) {
            mostrarError("Debe seleccionar una provincia", cmbProvincia);
            return false;
        }

        if (cmbCanton.getSelectedIndex() == -1) {
            mostrarError("Debe seleccionar un cantón", cmbCanton);
            return false;
        }

        if (cmbDistrito.getSelectedIndex() == -1) {
            mostrarError("Debe seleccionar un distrito", cmbDistrito);
            return false;
        }

        String fechaNacimiento = txtFechaNacimiento.getText().trim();
        if (!gestor.validarFechaNacimiento(fechaNacimiento)) {
            mostrarError("La fecha debe tener el formato DD/MM/YYYY", txtFechaNacimiento);
            return false;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            Date fecha = sdf.parse(fechaNacimiento);
            if (fecha.after(new Date())) {
                mostrarError("La fecha de nacimiento no puede ser futura", txtFechaNacimiento);
                return false;
            }
        } catch (ParseException e) {
            mostrarError("Error al validar la fecha: " + e.getMessage(), txtFechaNacimiento);
            return false;
        }

        return true;
    }

    private void mostrarError(String mensaje, javax.swing.JComponent componente) {
        lblMensajes.setText(mensaje);
        lblMensajes.setForeground(new java.awt.Color(204, 0, 0)); // Rojo para errores
        if (componente != null) {
            componente.requestFocus();
        }
    }
    
  
    void configurarEventosCampos() {

        txtCodigo.setEditable(false);
        txtCodigo.setText(String.valueOf(GestorClientes.getInstancia().obtenerSiguienteCodigo()));

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtNombre.getText().equals("Ingrese el nombre")) {
                    txtNombre.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtNombre.getText().isEmpty()) {
                    txtNombre.setText("Ingrese el nombre");
                }
            }
        });

        txtApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtApellidos.getText().equals("Ingrese los apellidos")) {
                    txtApellidos.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtApellidos.getText().isEmpty()) {
                    txtApellidos.setText("Ingrese los apellidos");
                }
            }
        });

        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtTelefono.getText().equals("Ingrese el teléfono")) {
                    txtTelefono.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtTelefono.getText().isEmpty()) {
                    txtTelefono.setText("Ingrese el teléfono");
                }
            }
        });

        
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtCorreo.getText().equals("Ingrese el correo")) {
                    txtCorreo.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtCorreo.getText().isEmpty()) {
                    txtCorreo.setText("Ingrese el correo");
                }
            }
        });

        
        txtFechaNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtFechaNacimiento.getText().equals("Fecha")) {
                    txtFechaNacimiento.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtFechaNacimiento.getText().isEmpty()) {
                    txtFechaNacimiento.setText("Fecha");
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

        jTextField3 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        cmbProvincia = new javax.swing.JComboBox<>();
        cmbCanton = new javax.swing.JComboBox<>();
        cmbDistrito = new javax.swing.JComboBox<>();
        txtFechaNacimiento = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblMensajes = new javax.swing.JLabel();

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setText("Ingrese el código");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField7.setText("Ingrese el código");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitulo.setText("Cliente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Código:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Apellidos:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Teléfono:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Correo:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Provincia:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Cantón:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Distrito:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Fecha Nacimiento (DD/MM/YYYY):");

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCodigo.setText("Ingrese el código");
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombre.setText("Ingrese el nombre");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtApellidos.setText("Ingrese los apellidos");
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTelefono.setText("Ingrese el teléfono");
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCorreo.setText("Ingrese el correo");
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        cmbProvincia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbCanton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbCanton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDistrito.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDistritoActionPerformed(evt);
            }
        });

        txtFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFechaNacimiento.setText("Fecha");
        txtFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(51, 153, 0));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setActionCommand("Modificar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblMensajes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMensajes.setText("jLabel11");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCorreo)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblMensajes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbDistrito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbCanton, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombre))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtApellidos)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(lblTitulo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(lblMensajes)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void txtFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacimientoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!validarCampos()) {
            return;
        }

        try {
            GestorClientes gestor = GestorClientes.getInstancia();

            String nombre = txtNombre.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            String telefono = txtTelefono.getText().trim();
            String correo = txtCorreo.getText().trim();
            String provincia = (String) cmbProvincia.getSelectedItem();
            String canton = (String) cmbCanton.getSelectedItem();
            String distrito = (String) cmbDistrito.getSelectedItem();
            String fechaNacimiento = txtFechaNacimiento.getText().trim();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(fechaNacimiento);

            Cliente cliente;
            if (modoEdicion) {

                cliente = new Cliente(
                        clienteEditar.getCodigo(), 
                        nombre,
                        apellidos,
                        telefono,
                        correo,
                        provincia,
                        canton,
                        distrito,
                        fecha
                );
                gestor.modificarCliente(cliente);
                lblMensajes.setText("Cliente modificado exitosamente");
            } else {

                cliente = new Cliente(
                        gestor.obtenerSiguienteCodigo(),
                        nombre,
                        apellidos,
                        telefono,
                        correo,
                        provincia,
                        canton,
                        distrito,
                        fecha
                );
                gestor.agregarCliente(cliente);
                lblMensajes.setText("Cliente guardado exitosamente");
            }

            RegistroClientesForm registroClientes = new RegistroClientesForm();
            registroClientes.setVisible(true);
            this.dispose();

        } catch (ParseException e) {
            lblMensajes.setText("Error en el formato de la fecha");
        } catch (Exception e) {
            lblMensajes.setText("Error al " + (modoEdicion ? "modificar" : "guardar") + " el cliente: " + e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        RegistroClientesForm registroClientes = new RegistroClientesForm();
        registroClientes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDistritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDistritoActionPerformed

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
            java.util.logging.Logger.getLogger(MantenimientoClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoClienteForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbCanton;
    private javax.swing.JComboBox<String> cmbDistrito;
    private javax.swing.JComboBox<String> cmbProvincia;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblMensajes;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
