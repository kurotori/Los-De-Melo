/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

/**
 *
 * @author Victor Neves
 */
public class TelsDir extends javax.swing.JFrame {

    /**
     * Creates new form Terms
     */
    public TelsDir() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jButton1Volver = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SysTurno v1.0.0 Alpha");
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Hospital de Melo", "46422156", "Treinta y tres 37000"},
                {"Sanatorio Camcel", "46428686", "Agustín de la Rosa 576"},
                {"Policlinica Acegua", "46409201", "M. Isabel Rodríguez Mattos 776"},
                {"Policlinica Fraile Muerto", "46889012", "Av. Blanca Castro y Gral. Artigas"},
                {"Policlínica de Noblía", "46409144", "Calle No. 4 S/N"},
            },
            new String [] {
                "Centro de Atención", "Teléfonos", "Direcciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 600, 190));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Teléfonos y Direcciones");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 300, 40));

        jButton1Volver.setBackground(new java.awt.Color(0, 0, 51));
        jButton1Volver.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1Volver.setForeground(new java.awt.Color(255, 255, 255));
        jButton1Volver.setText("<< Volver");
        jButton1Volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1VolverMouseClicked(evt);
            }
        });
        jButton1Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1VolverActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, -1, -1));

        jLabelFondo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoAzul.png"))); // NOI18N
        jLabelFondo.setMaximumSize(new java.awt.Dimension(800, 600));
        jLabelFondo.setMinimumSize(new java.awt.Dimension(800, 600));
        jLabelFondo.setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1VolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1VolverActionPerformed

    private void jButton1VolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1VolverMouseClicked
        MenuNuevo menu= new MenuNuevo();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1VolverMouseClicked

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
