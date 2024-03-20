/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Database.Database;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Database.JBackupController;
/**
 *
 * @author PC
 */
public class ventanaPrincipal extends javax.swing.JFrame {

    private final String USER;
    
    private final String PASS;
    
    private final Database db;
    /**
     * Creates new form ventanaPrincipal
     * @param db
     * @param USER
     * @param PASS
     */
    public ventanaPrincipal(Database db,String USER,String PASS) {
        this.db = db;
        this.USER = USER;
        this.PASS = PASS;
        
        initComponents();
        buildCombo();
        setLocationRelativeTo(null);
    }
    
    private void buildCombo() {
        final String sql = "SELECT datname FROM pg_database";
        ResultSet rs = null;
        try {
            // Enviar consulta a la base de datos
            rs = db.query(sql);
            while (rs.next()) {
                
                //obtenemos los datos de la base de datos
                String nombre = rs.getString(1);
                
                comboBoxBaseDeDatos.addItem(nombre);
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
        jLabel1 = new javax.swing.JLabel();
        comboBoxBaseDeDatos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        textFieldNivelCompresion = new javax.swing.JTextField();
        botonGuardarAchivo = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 230));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Base de datos:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        comboBoxBaseDeDatos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(comboBoxBaseDeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 280, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nivel de compresion:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        textFieldNivelCompresion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(textFieldNivelCompresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 280, -1));

        botonGuardarAchivo.setText("Guardar archivo");
        botonGuardarAchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarAchivoActionPerformed(evt);
            }
        });
        jPanel1.add(botonGuardarAchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nivel: 0 - 9");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarAchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarAchivoActionPerformed
        //preguntamos si estamos en windows
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        
        //si estamos en windows
        if (isWindows) {
            if (!textFieldNivelCompresion.getText().isBlank()) {
                
                //obtenemos el nivel de compresion
                String nivelCompresion = textFieldNivelCompresion.getText();
                int nivel = Integer.parseInt(nivelCompresion);
                
                if (nivel<10 && nivel > -1) {//El rango de compresion debe de estar del 0 al 9
                    //creamos la ventana para seleccionar los archivos
                    JFileChooser seleccionarCarpeta = new JFileChooser();
                    seleccionarCarpeta.setCurrentDirectory(new File("."));                              //empezará desde la carpeta de la aplicacion
                    seleccionarCarpeta.setDialogTitle("Seleccione la carpeta para guardar el archivo"); //modificamos el titulo a aparecer
                    seleccionarCarpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);             //solo aceptara direcciones
                    seleccionarCarpeta.setAcceptAllFileFilterUsed(false);                               //no se pueden seleccionar archivos

                    if (seleccionarCarpeta.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {       //si la opcion fue la de abrir

                        String dataBaseName = comboBoxBaseDeDatos.getSelectedItem().toString();         //obtenemos el nombre de la base de datos seleccionada

                        File carpetaSeleccionada = seleccionarCarpeta.getSelectedFile();                //obtenemos la ruta de la carpeta de donde estamos

                        String direccion = carpetaSeleccionada.getAbsolutePath();                       //cambiamos el path a texto

                        //hacemos el Backup
                        JBackupController jb = new JBackupController();
                        jb.executeCommand(dataBaseName, PASS, "backup", direccion, USER,nivel);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El nivel de compresion es entre 0 y 9, porfavor de ingresar algun numero entre esos valores");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Se recomienda dar un nivel de compresion");
            }
        }
        
    }//GEN-LAST:event_botonGuardarAchivoActionPerformed

    
    
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardarAchivo;
    private javax.swing.JButton botonSalir;
    private javax.swing.JComboBox<String> comboBoxBaseDeDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textFieldNivelCompresion;
    // End of variables declaration//GEN-END:variables
}
