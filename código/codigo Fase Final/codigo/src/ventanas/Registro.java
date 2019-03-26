package ventanas;

import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class Registro extends javax.swing.JFrame {
    JFrame vAnterior;
    CapaLogica acciones =  new CapaLogica();
    
    public Registro(JFrame vAnterior) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.vAnterior=vAnterior;
    }
    
    public String getNombre(){
        return tf_nombre.getText();
    }
    
    public String getApellido(){
        return tf_apellido.getText();
    }
    
    public String getTelefono(){
        return tf_telefono.getText();
    }
    
    public String getCI(){
        return tfF_ci.getText();
    }
    
    public String getEmail(){
        return tf_email.getText();
    }
    
    public char[] getContrasenia(){
        return pf_contrasenia.getPassword();
    }
    
    public char[] getRepContra(){
        return pf_repContra.getPassword();
    }
    
    public JPasswordField getCampoContraseña(){
        return pf_contrasenia;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_apellido = new javax.swing.JTextField();
        tfF_ci = new javax.swing.JFormattedTextField();
        tf_telefono = new javax.swing.JFormattedTextField();
        pf_repContra = new javax.swing.JPasswordField();
        pf_contrasenia = new javax.swing.JPasswordField();
        bt_volver = new javax.swing.JButton();
        bt_confirmar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        tf_email = new javax.swing.JTextField();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SysTurno v1.0.0 Alpha");
        setIconImage(getIconImage());
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario de Registro a SysTurno");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 430, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Repita Contraseña: *");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 180, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos: *");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 170, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Teléfono: *");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 110, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("C.I.: *");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 80, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contraseña: *");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 140, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("(*) Campos Obligatorios.");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 160, 20));

        tf_apellido.setBackground(new java.awt.Color(0, 0, 0));
        tf_apellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_apellido.setForeground(new java.awt.Color(255, 255, 255));
        tf_apellido.setCaretColor(new java.awt.Color(255, 255, 255));
        tf_apellido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(tf_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 260, 30));

        tfF_ci.setBackground(java.awt.Color.black);
        tfF_ci.setForeground(new java.awt.Color(255, 255, 255));
        tfF_ci.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        tfF_ci.setCaretColor(new java.awt.Color(255, 255, 255));
        tfF_ci.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tfF_ci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfF_ciActionPerformed(evt);
            }
        });
        getContentPane().add(tfF_ci, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 260, 30));

        tf_telefono.setBackground(java.awt.Color.black);
        tf_telefono.setForeground(new java.awt.Color(255, 255, 255));
        tf_telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        tf_telefono.setCaretColor(new java.awt.Color(255, 255, 255));
        tf_telefono.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tf_telefono.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(tf_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 260, 30));

        pf_repContra.setBackground(java.awt.Color.black);
        pf_repContra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pf_repContra.setForeground(new java.awt.Color(255, 255, 255));
        pf_repContra.setCaretColor(new java.awt.Color(255, 255, 255));
        pf_repContra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pf_repContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_repContraActionPerformed(evt);
            }
        });
        getContentPane().add(pf_repContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 260, 30));

        pf_contrasenia.setBackground(java.awt.Color.black);
        pf_contrasenia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pf_contrasenia.setForeground(new java.awt.Color(255, 255, 255));
        pf_contrasenia.setToolTipText("La contraseña debe ser alfanumérica de por lo menos 6 caracteres de longitud.");
        pf_contrasenia.setCaretColor(new java.awt.Color(255, 255, 255));
        pf_contrasenia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(pf_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 260, 30));

        bt_volver.setBackground(new java.awt.Color(0, 0, 51));
        bt_volver.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bt_volver.setForeground(new java.awt.Color(255, 255, 255));
        bt_volver.setText("<< Volver");
        bt_volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_volverMouseClicked(evt);
            }
        });
        bt_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_volverActionPerformed(evt);
            }
        });
        getContentPane().add(bt_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        bt_confirmar.setBackground(new java.awt.Color(0, 0, 51));
        bt_confirmar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bt_confirmar.setForeground(new java.awt.Color(255, 255, 255));
        bt_confirmar.setText("Confirmar");
        bt_confirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_confirmarMouseClicked(evt);
            }
        });
        bt_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("E-Mail: *");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 80, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombre : *");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 170, 30));

        tf_nombre.setBackground(new java.awt.Color(0, 0, 0));
        tf_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_nombre.setForeground(new java.awt.Color(255, 255, 255));
        tf_nombre.setCaretColor(new java.awt.Color(255, 255, 255));
        tf_nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(tf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 260, 30));

        tf_email.setBackground(new java.awt.Color(0, 0, 0));
        tf_email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_email.setForeground(new java.awt.Color(255, 255, 255));
        tf_email.setCaretColor(new java.awt.Color(255, 255, 255));
        tf_email.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(tf_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 260, 30));

        jLabelFondo.setBackground(java.awt.Color.black);
        jLabelFondo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoAzul.png"))); // NOI18N
        jLabelFondo.setMaximumSize(new java.awt.Dimension(800, 600));
        jLabelFondo.setMinimumSize(new java.awt.Dimension(800, 600));
        jLabelFondo.setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfF_ciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfF_ciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfF_ciActionPerformed

    private void bt_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_volverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_volverActionPerformed

    private void pf_repContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_repContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf_repContraActionPerformed

    private void bt_volverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_volverMouseClicked
        // TODO add your handling code here:
        vAnterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bt_volverMouseClicked

    private void bt_confirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_confirmarMouseClicked
        
    }//GEN-LAST:event_bt_confirmarMouseClicked

    private void bt_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bt_confirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirmar;
    private javax.swing.JButton bt_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPasswordField pf_contrasenia;
    private javax.swing.JPasswordField pf_repContra;
    private javax.swing.JFormattedTextField tfF_ci;
    private javax.swing.JTextField tf_apellido;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JFormattedTextField tf_telefono;
    // End of variables declaration//GEN-END:variables
}