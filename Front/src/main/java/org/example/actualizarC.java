package org.example;

public class actualizarC extends javax.swing.JFrame {
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        telefono = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        Inventario = new javax.swing.JLabel();
        Actualizar = new javax.swing.JLabel();
        Historial = new javax.swing.JLabel();
        Facturas = new javax.swing.JLabel();
        Proveedores = new javax.swing.JLabel();
        Producto = new javax.swing.JLabel();
        Empleados = new javax.swing.JLabel();
        Clientes1 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        telefono.setBackground(new java.awt.Color(255, 255, 255));
        telefono.setForeground(new java.awt.Color(0, 0, 0));
        telefono.setBorder(null);
        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });
        jLayeredPane1.add(telefono);
        telefono.setBounds(700, 320, 190, 20);

        nombre.setBackground(new java.awt.Color(255, 255, 255));
        nombre.setForeground(new java.awt.Color(0, 0, 0));
        nombre.setBorder(null);
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        jLayeredPane1.add(nombre);
        nombre.setBounds(260, 230, 190, 20);

        direccion.setBackground(new java.awt.Color(255, 255, 255));
        direccion.setForeground(new java.awt.Color(0, 0, 0));
        direccion.setBorder(null);
        direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionActionPerformed(evt);
            }
        });
        jLayeredPane1.add(direccion);
        direccion.setBounds(260, 320, 190, 16);

        correo.setBackground(new java.awt.Color(255, 255, 255));
        correo.setForeground(new java.awt.Color(0, 0, 0));
        correo.setBorder(null);
        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });
        jLayeredPane1.add(correo);
        correo.setBounds(700, 230, 190, 20);

        Inventario.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        Inventario.setForeground(new java.awt.Color(255, 255, 51));
        Inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InventarioMouseClicked(evt);
            }
        });
        jLayeredPane1.add(Inventario);
        Inventario.setBounds(40, 126, 90, 20);

        Actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActualizarMouseClicked(evt);
            }
        });
        jLayeredPane1.add(Actualizar);
        Actualizar.setBounds(550, 370, 100, 30);

        Historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HistorialMouseClicked(evt);
            }
        });
        jLayeredPane1.add(Historial);
        Historial.setBounds(30, 160, 90, 30);

        Facturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FacturasMouseClicked(evt);
            }
        });
        jLayeredPane1.add(Facturas);
        Facturas.setBounds(30, 200, 90, 30);

        Proveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProveedoresMouseClicked(evt);
            }
        });
        jLayeredPane1.add(Proveedores);
        Proveedores.setBounds(30, 240, 120, 30);

        Producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductoMouseClicked(evt);
            }
        });
        jLayeredPane1.add(Producto);
        Producto.setBounds(30, 280, 120, 30);

        Empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmpleadosMouseClicked(evt);
            }
        });
        jLayeredPane1.add(Empleados);
        Empleados.setBounds(30, 320, 120, 30);

        Clientes1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Clientes1MouseClicked(evt);
            }
        });
        jLayeredPane1.add(Clientes1);
        Clientes1.setBounds(20, 360, 120, 30);

        fecha.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fecha.setForeground(new java.awt.Color(163, 58, 175));
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fecha.setText("Fecha-hora");
        jLayeredPane1.add(fecha);
        fecha.setBounds(1080, 30, 140, 19);

        nombreUsuario.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(163, 58, 175));
        nombreUsuario.setText("Nombre usuario");
        jLayeredPane1.add(nombreUsuario);
        nombreUsuario.setBounds(1150, 10, 100, 19);

        fondo.setIcon(new javax.swing.ImageIcon("Imagenes\\Actualizar clientes.jpg")); // NOI18N
        fondo.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jLayeredPane1.add(fondo);
        fondo.setBounds(0, 0, 1260, 630);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void direccionActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void InventarioMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void ActualizarMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void HistorialMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void FacturasMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void ProveedoresMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void ProductoMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void EmpleadosMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void Clientes1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

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
            java.util.logging.Logger.getLogger(actualizarC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(actualizarC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(actualizarC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(actualizarC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new actualizarC().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify
    private javax.swing.JLabel Actualizar;
    private javax.swing.JLabel Clientes1;
    private javax.swing.JLabel Empleados;
    private javax.swing.JLabel Facturas;
    private javax.swing.JLabel Historial;
    private javax.swing.JLabel Inventario;
    private javax.swing.JLabel Producto;
    private javax.swing.JLabel Proveedores;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField direccion;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel fondo;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombreUsuario;
    private javax.swing.JTextField telefono;
    // End of variables declaration
    public actualizarC() {
        initComponents();

        jLayeredPane1.setBounds(0, 0,getWidth(), getHeight());

    }
}
