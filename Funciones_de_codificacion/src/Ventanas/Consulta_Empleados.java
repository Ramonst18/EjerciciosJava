/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Database.Database;
import Database.trabajador;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.Hashtable;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Consulta_Empleados extends javax.swing.JDialog {

    Hashtable<Integer,trabajador> trabajadores = new Hashtable<Integer, trabajador>();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    /**
     * Creates new form Consulta_usuarios
     */
    private Database db;
    public Consulta_Empleados(java.awt.Frame parent, boolean modal,Database db) {
        super(parent, modal);
        this.db = db;
        initComponents();
        agregarColumnas();
        obtenerDatos();
        setLocationRelativeTo(null);
    }
    
    private void agregarColumnas(){
        modeloTabla.addColumn("Nombre");
        
        modeloTabla.addColumn("Direccion");
        
        modeloTabla.addColumn("Telefono");
        
        modeloTabla.addColumn("Posicion");
    }
    
    private void obtenerDatos(){
        String sql = "SELECT \"Nombre\", PGP_SYM_DECRYPT(\"Direccion\"::bytea, 'AES_KEY'), PGP_SYM_DECRYPT(\"Telefono\"::bytea, 'AES_KEY'), \"posicionTrabajo\"\n FROM public.\"Empleados\";";
        ResultSet rs = null;
        
        //Consultamos la base de datos
        try {
            int i = 0;
            // Enviar consulta a la base de datos
            rs = db.query(sql);
            while (rs.next()) {
                // 1: nombre  2: Direccion  3: Telefono 4: posicion Trabajo
                //obtenemos los datos de la base de datos
                String[] datos = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                trabajador t = new trabajador(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                trabajadores.put(i, t);
                modeloTabla.addRow(datos);
                i++;
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
        botonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsers = new javax.swing.JTable();
        botonBorrarSeleccion = new javax.swing.JButton();
        botonActualizarSeleccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        tablaUsers.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablaUsers.setModel(modeloTabla);
        jScrollPane1.setViewportView(tablaUsers);

        botonBorrarSeleccion.setText("Borrar seleccionado");
        botonBorrarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarSeleccionActionPerformed(evt);
            }
        });

        botonActualizarSeleccion.setText("Actualizar seleccion");
        botonActualizarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarSeleccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(botonActualizarSeleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonBorrarSeleccion)
                .addGap(60, 60, 60)
                .addComponent(botonSalir)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir)
                    .addComponent(botonBorrarSeleccion)
                    .addComponent(botonActualizarSeleccion))
                .addContainerGap())
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

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonBorrarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarSeleccionActionPerformed
        if (tablaUsers.getSelectedRow() !=-1) {//si el numero de columna es distinto a -1, se realizara el borrado
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea borar al trabajador de la fila numero:" + (tablaUsers.getSelectedRow()+1) + " ?");
            if (respuesta == 0) {
                String nombre = (String) modeloTabla.getValueAt(tablaUsers.getSelectedRow(), 0);//obtenemos el nombre del usuario de la fila seleccionada

                String Sql = "DELETE FROM public.\"Empleados\"\n WHERE \"Empleados\".\"Nombre\" = \'" + nombre + "\';";

                modeloTabla.removeRow(tablaUsers.getSelectedRow());//se borra la fila seleccionada
                trabajadores.remove(tablaUsers.getSelectedRow());
                //se realiza la actualizacion de la base de datos
                try {
                    db.update(Sql);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe de seleccionar una fila de la tabla primero");
        }
    }//GEN-LAST:event_botonBorrarSeleccionActionPerformed

    private void botonActualizarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarSeleccionActionPerformed
        System.out.println(tablaUsers.getSelectedRow());
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Quiere modificar la fila numero:" + (tablaUsers.getSelectedRow() + 1) + " ?");
        if (respuesta == 0) {
            String nombreM = (String) modeloTabla.getValueAt(tablaUsers.getSelectedRow(), 0);
            String direccionM = (String) modeloTabla.getValueAt(tablaUsers.getSelectedRow(), 1);
            String telefonoM = (String) modeloTabla.getValueAt(tablaUsers.getSelectedRow(), 2);
            String lugarTrabajoM = (String) modeloTabla.getValueAt(tablaUsers.getSelectedRow(), 3);

            trabajador t = new trabajador(nombreM, direccionM, telefonoM, direccionM);

            String nombreA = trabajadores.get(tablaUsers.getSelectedRow()).getNombre();//obtenemos el nombre
            String posicionA = trabajadores.get(tablaUsers.getSelectedRow()).getPosicion();//obtenemos la posicion

            String sql = "UPDATE public.\"Empleados\"\n"
                    + "	SET \"Nombre\"=\'" + nombreM + "\', \"Direccion\"=PGP_SYM_ENCRYPT(\'" + direccionM + "\','AES_KEY'), \"Telefono\"=PGP_SYM_ENCRYPT(\'" + telefonoM + "\','AES_KEY'), \"posicionTrabajo\"=\'" + lugarTrabajoM + "\'\n"
                    + "	WHERE \"Empleados\".\"Nombre\" = \'" + nombreA + "\' AND \"Empleados\".\"posicionTrabajo\" = \'" + posicionA + "\';";

            trabajadores.replace(tablaUsers.getSelectedRow(), t);//remplazamos los datos
            System.out.println(sql);

            try {
                db.update(sql);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }//GEN-LAST:event_botonActualizarSeleccionActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarSeleccion;
    private javax.swing.JButton botonBorrarSeleccion;
    private javax.swing.JButton botonSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsers;
    // End of variables declaration//GEN-END:variables
}
