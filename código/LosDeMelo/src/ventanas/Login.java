package ventanas;

import java.awt.Font;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import losdemelo.login.*;
import losdemelo.misc.Herramientas;

public class Login extends javax.swing.JFrame {
    losdemelo.login.Login login;
    Herramientas herramientas;
    CapaLogica acciones = new CapaLogica();
    
    public DatosSesion nuevaSesion;
    
    public Login( DatosSesion datosSesion ) {
        initComponents();
        this.setLocationRelativeTo(null);
        login = new losdemelo.login.Login();
        herramientas = new Herramientas();
        nuevaSesion = datosSesion;
        
        UIManager.put("ToolTip.font",
           new FontUIResource("SansSerif", Font.BOLD, 18));
        
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabelIcono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_ci = new javax.swing.JTextField();
        pf_contrasenia = new javax.swing.JPasswordField();
        bt_ingresar = new javax.swing.JButton();
        bt_nuevoReg = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SysTurno v1.0.0 Alpha");
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 80, 30));

        jLabelIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/User1.png"))); // NOI18N
        getContentPane().add(jLabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 120, 130));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("C.I.:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 120, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bienvenido a SysTurno");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 380, 40));

        tf_ci.setBackground(new java.awt.Color(0, 0, 51));
        tf_ci.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_ci.setForeground(new java.awt.Color(255, 255, 255));
        tf_ci.setToolTipText("Ingrese su cédula de identidad sin puntos ni guión.");
        tf_ci.setCaretColor(new java.awt.Color(255, 255, 255));
        tf_ci.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(tf_ci, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 220, 30));

        pf_contrasenia.setBackground(new java.awt.Color(0, 0, 51));
        pf_contrasenia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pf_contrasenia.setForeground(new java.awt.Color(255, 255, 255));
        pf_contrasenia.setToolTipText("Ingrese su contraseña, debe ser alfanumérica de por lo menos 6 caractéres.");
        pf_contrasenia.setCaretColor(new java.awt.Color(255, 255, 255));
        pf_contrasenia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(pf_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 220, 30));

        bt_ingresar.setBackground(new java.awt.Color(0, 0, 51));
        bt_ingresar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bt_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        bt_ingresar.setText("Ingresar");
        bt_ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_ingresarMouseClicked(evt);
            }
        });
        bt_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        bt_nuevoReg.setBackground(new java.awt.Color(0, 0, 51));
        bt_nuevoReg.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bt_nuevoReg.setForeground(new java.awt.Color(255, 255, 255));
        bt_nuevoReg.setText("Nuevo Registro");
        bt_nuevoReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_nuevoRegMouseClicked(evt);
            }
        });
        getContentPane().add(bt_nuevoReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 160, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoAzul.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 466, 503));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ingresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_ingresarActionPerformed

    private void bt_ingresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_ingresarMouseClicked
        acciones.iniciarSesion(this, tf_ci, pf_contrasenia);
    }//GEN-LAST:event_bt_ingresarMouseClicked

    private void bt_nuevoRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nuevoRegMouseClicked
        // TODO add your handling code here:
        Registro vRegistro = new Registro(this);
        this.setVisible(false);
        vRegistro.setVisible(true);
    }//GEN-LAST:event_bt_nuevoRegMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ingresar;
    private javax.swing.JButton bt_nuevoReg;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JPasswordField pf_contrasenia;
    private javax.swing.JTextField tf_ci;
    // End of variables declaration//GEN-END:variables
}