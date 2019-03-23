/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor Neves
 */
public class Reserva extends javax.swing.JFrame {
    CapaLogica acciones = new CapaLogica();
    DatosSesion infoSesion;
    MenuNuevo menu;

    /**
     * Creates new form Terms
     */
    public Reserva(MenuNuevo menu, DatosSesion sesion) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.menu = menu;
        this.infoSesion = sesion;
        
        jTable1.setFont(new FontUIResource("SansSerif", Font.PLAIN, 14));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setRowHeight(25);
        UIManager.put("ToolTip.font",
           new FontUIResource("SansSerif", Font.BOLD, 18));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfF_numeroTurno = new javax.swing.JFormattedTextField();
        tfF_fechaTurno = new javax.swing.JFormattedTextField();
        jfF_horaTurno = new javax.swing.JFormattedTextField();
        bt_solTurno = new javax.swing.JButton();
        bt_volver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SysTurno v1.0.0 Alpha");
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 640, 190));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hora:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 60, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Próximo turno disponible en sistema:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 400, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 60, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Reserva de Turno");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 250, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Medicamentos");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 110, 40));

        tfF_numeroTurno.setEditable(false);
        tfF_numeroTurno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(tfF_numeroTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 80, -1));

        tfF_fechaTurno.setEditable(false);
        tfF_fechaTurno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        getContentPane().add(tfF_fechaTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 80, -1));

        jfF_horaTurno.setEditable(false);
        jfF_horaTurno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        getContentPane().add(jfF_horaTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 80, -1));

        bt_solTurno.setBackground(new java.awt.Color(0, 0, 51));
        bt_solTurno.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bt_solTurno.setForeground(new java.awt.Color(255, 255, 255));
        bt_solTurno.setText("Solicitar Turno");
        bt_solTurno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_solTurnoMouseClicked(evt);
            }
        });
        bt_solTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_solTurnoActionPerformed(evt);
            }
        });
        getContentPane().add(bt_solTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, -1, -1));

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
        getContentPane().add(bt_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, -1, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Condiciones Generales:\n\n- Solo se podrá retirar medicamentos presentando cédula de identidad original del paciente.\n- Los medicamentos de venta bajo receta solo se entregarán contra presentación de la misma.");
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 640, 100));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Número:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 70, 40));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoAzul.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_volverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_volverActionPerformed

    private void bt_volverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_volverMouseClicked
        // TODO add your handling code here:
        menu.setVisible(true);
        this.dispose();
       
    }//GEN-LAST:event_bt_volverMouseClicked

    private void bt_solTurnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_solTurnoMouseClicked

        
        

    }//GEN-LAST:event_bt_solTurnoMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        acciones.mostrarMedicamentosRecetados(infoSesion, jTable1);
        acciones.mostrarTurnosDisponibles(tfF_numeroTurno, tfF_fechaTurno, jfF_horaTurno);
        acciones.buscarTurnosConfirmados(infoSesion, bt_solTurno);
        
    }//GEN-LAST:event_formWindowOpened

    private void bt_solTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_solTurnoActionPerformed
        // TODO add your handling code here:
        boolean opcion = acciones.seleccionarMedicamentosDisponibles(this,
                                                    jTable1,
                                                    tfF_numeroTurno,
                                                    tfF_fechaTurno,
                                                    jfF_horaTurno);
        if(opcion){
            acciones.reservarTurno(infoSesion);
        }
    }//GEN-LAST:event_bt_solTurnoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_solTurno;
    private javax.swing.JButton bt_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JFormattedTextField jfF_horaTurno;
    private javax.swing.JFormattedTextField tfF_fechaTurno;
    private javax.swing.JFormattedTextField tfF_numeroTurno;
    // End of variables declaration//GEN-END:variables
}
