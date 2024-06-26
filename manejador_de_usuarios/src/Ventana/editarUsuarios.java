/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Database.Database;
import Database.Usuarios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JOptionPane;

/**
 *  clase ventana que nos servira para modificar los roles de los usuarios y 
 *  ademas permite la eliminacion del usuario.
 * @author Ramon Lopez
 */
public class editarUsuarios extends javax.swing.JDialog {
    private Hashtable<String,Usuarios> usuarios;
    public final Database db;
    
    /**
     * Creates new form editarUsuarios
     */
    public editarUsuarios(java.awt.Frame parent, boolean modal, Database db) {
        super(parent, modal);
        this.db = db;
        this.usuarios = new Hashtable<String, Usuarios>();
        initComponents();
        buildCombo();
        setLocationRelativeTo(null);
    }

    /**
     * Realizara la consulta en la base de datos y se obtendran los usuarios que
     * puedan iniciar sesión.
     * Estos usuarios seran añadidos al comboBox comboName
     */
    private void buildCombo() {
        final String sql = "SELECT * FROM \"pg_authid\" WHERE rolcanlogin = true;";
        ResultSet rs = null;
        try {
            // Enviar consulta a la base de datos
            rs = db.query(sql);
            while (rs.next()) {
                //2 = nombre    3 = rolsuper    4 = rolinherit
                //5 = rolcreaterole     6 = rolcreatedb     8 rolreplication
               
                //obtenemos los datos de la base de datos
                String nombre = rs.getString(2);
                
                Usuarios usuario = new Usuarios(nombre, rs.getBoolean(3), rs.getBoolean(4), rs.getBoolean(5), rs.getBoolean(6), rs.getBoolean(8));
                usuarios.put(nombre, usuario);
                // Agregar nombre del proveedor al combo
                if (!nombre.equals("postgres")) {
                    comboName.addItem(nombre);
                }
                //System.out.println(label);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        comboName = new javax.swing.JComboBox<>();
        botonEliminar = new javax.swing.JButton();
        botonEditarRoles = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        checkBoxRoles = new javax.swing.JCheckBox();
        checkBoxCreateDataBases = new javax.swing.JCheckBox();
        checkBoxCreateRoles = new javax.swing.JCheckBox();
        checkBoxBackups = new javax.swing.JCheckBox();
        checkBoxSuperUser = new javax.swing.JCheckBox();
        botonRolesActuales = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        setResizable(false);

        comboName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonEditarRoles.setText("Editar roles de usuario");
        botonEditarRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarRolesActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        checkBoxRoles.setText("Derecho de modificar roles");
        checkBoxRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxRolesActionPerformed(evt);
            }
        });

        checkBoxCreateDataBases.setText("Crear base de datos");

        checkBoxCreateRoles.setText("Puede crear roles");

        checkBoxBackups.setText("Puede iniciar la replicación y las copias de seguridad");

        checkBoxSuperUser.setText("Super usuario");

        botonRolesActuales.setText("Mostrar roles actuales");
        botonRolesActuales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRolesActualesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nombre del usuario:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(checkBoxBackups)
                                .addGap(181, 185, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(checkBoxSuperUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkBoxCreateDataBases)
                                .addGap(77, 77, 77))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(checkBoxCreateRoles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkBoxRoles)
                                .addGap(46, 46, 46)))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonEditarRoles)
                                .addGap(18, 18, 18)
                                .addComponent(botonRolesActuales))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(botonCancelar)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(botonEliminar)
                                .addGap(54, 54, 54))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxCreateDataBases)
                    .addComponent(checkBoxSuperUser))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxCreateRoles)
                    .addComponent(checkBoxRoles))
                .addGap(18, 18, 18)
                .addComponent(checkBoxBackups)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEditarRoles)
                    .addComponent(botonCancelar)
                    .addComponent(botonRolesActuales))
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        String usuario = comboName.getSelectedItem().toString();
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar a " + usuario + " de la base de datos?");
        System.out.println(confirmacion);
        
        //verificamos la opcion
        if (confirmacion == 0) {//eliminaremos al usuario
            try {
                String name = comboName.getSelectedItem().toString();
                String sql = String.format("DROP USER " + name);
                //System.out.println(sql);
                db.update(sql);           
                usuarios.remove(name);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());            
            }
            
            //actualizamos el comboName
            comboName.removeAllItems();
            buildCombo();
        }
        
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonEditarRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarRolesActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Deseas realizar esta modificacion?");
        if (confirmacion == 0) {
            //obtenemos los datos del nombre seleccionado en el comboBox
            String nombreKey = comboName.getSelectedItem().toString();
            
            String sql = "ALTER ROLE " + nombreKey + "\n";
            Usuarios usuario = usuarios.get(nombreKey);
            
            
            boolean superUser = checkBoxSuperUser.isSelected();
            boolean createDataBases = checkBoxCreateDataBases.isSelected();
            boolean createRoles = checkBoxCreateRoles.isSelected();
            boolean roles = checkBoxRoles.isSelected();
            boolean backups = checkBoxBackups.isSelected();
            
            //superUser
            if (usuario.isRolSuper() != superUser) {
                if (superUser == true) {
                    sql += "\tSUPERUSER";
                }else{
                    sql += "\tNOSUPERUSER";
                }
            }
            
            //createDataBases
            if (usuario.isRolCreateDB() != createDataBases) {
                if (createDataBases == true) {
                    sql += "\n\tCREATEDB";
                }else{
                    sql += "\n\tNOCREATEDB";
                }
            }
            
            //CreateRoles
            if (usuario.isRolCreateRole() != createRoles) {
                if (createRoles == true) {
                    sql += "\n\tCREATEROLE";
                }else{
                    sql += "\n\tNOCREATEROLE";
                }
            }
            
            //rolInherit
            if (usuario.isRolInherit() != roles) {
                if (roles == true) {
                    sql += "\n\tINHERIT";
                }else{
                    sql += "\n\tNOINHERIT";
                }
            }
            
            //backups
            if (usuario.isRolReplication() != backups) {
                if (backups == true) {
                    sql += "\n\tREPLICATION";
                }else{
                    sql += "\n\tNOREPLICATION";
                }
            }
            
            sql += ";";
            
            //mandamos la orden a la base de datos
            try {
                db.update(sql);  
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());            
            }
        }
    }//GEN-LAST:event_botonEditarRolesActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonRolesActualesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRolesActualesActionPerformed
        //obtenemos los datos del usuario seleccionado
        String seleccion = comboName.getSelectedItem().toString();
        Usuarios usuario = usuarios.get(seleccion);
        
        //mostramos los roles establecidos
        checkBoxSuperUser.setSelected(usuario.isRolSuper());
        checkBoxRoles.setSelected(usuario.isRolInherit());
        checkBoxBackups.setSelected(usuario.isRolReplication());
        checkBoxCreateDataBases.setSelected(usuario.isRolCreateDB());
        checkBoxCreateRoles.setSelected(usuario.isRolCreateRole());
    }//GEN-LAST:event_botonRolesActualesActionPerformed

    private void checkBoxRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxRolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxRolesActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEditarRoles;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonRolesActuales;
    private javax.swing.JCheckBox checkBoxBackups;
    private javax.swing.JCheckBox checkBoxCreateDataBases;
    private javax.swing.JCheckBox checkBoxCreateRoles;
    private javax.swing.JCheckBox checkBoxRoles;
    private javax.swing.JCheckBox checkBoxSuperUser;
    private javax.swing.JComboBox<String> comboName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
