package ventanas;

import b4.advancedgui.menu.AccordionItem;
import b4.advancedgui.menu.AccordionLeafItem;
import b4.advancedgui.menu.AccordionMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.FontUIResource;

public final class MenuNuevo extends javax.swing.JFrame {

    private AccordionMenu menu1;
    private AccordionMenu menu2;
    private AccordionMenu menu3;
    
    private MenuNuevo vt_menu;
    static DatosSesion infoSesion;

    public MenuNuevo(DatosSesion datosSesion) {
        
        /**
         * Changes Look & Feel to Nimbus. And sets icon for JFrame.
         */
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../b4/advancedgui/menu/resources/green_arrow_right.png")));
        } catch (Exception ex ) {
            Logger.getLogger(MenuNuevo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        setSize(460, 460);
        vt_menu = this;
        infoSesion = datosSesion;
        //menu 1. Creates a standard menu, gray background, Center Alignment of Roots and Leafs, small monospaced font.
        //menu1 = new AccordionMenu(getSampleMenuDescriptor());

        //menu 3. Creates a simple menu, white bacground and dark blue foreground, a lightGray selection backgroun on mouseover, Right Alignment for leafs
        //two icon for all Root Items, and two icon for Leaf of second menu only
        menu3 = new AccordionMenu();
        createSampleMenuStructure(menu3);
        menu3.setBackground(Color.white);
        menu3.setForeground(Color.blue.darker().darker().darker());
        menu3.setFont(new FontUIResource("Calibri", Font.BOLD, 18));
        //menu3.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 15));
        menu3.setSelectionColor(Color.lightGray);
        menu3.setLeafHorizontalAlignment(AccordionItem.LEFT);
        ImageIcon icon3 = new ImageIcon(this.getClass().getResource("../b4/advancedgui/menu/resources/blu_arrow_right.png"));
        ImageIcon icon4 = new ImageIcon(this.getClass().getResource("../b4/advancedgui/menu/resources/blu_arrow_down.png"));
        menu3.setMenuIcons(icon3, icon4);
        setMouseAdapter(menu3);
        cont3.add(menu3);
        //------------------------------------------------------------------------------------------------------------------------

        lbl_IdSesion.setText("Sesión:"+infoSesion.getIdSesion());
        //setExitButton();
    }
    
    public MenuNuevo() {
        
        /**
         * Changes Look & Feel to Nimbus. And sets icon for JFrame.
         */
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("../b4/advancedgui/menu/resources/green_arrow_right.png")));
        } catch (Exception ex ) {
            Logger.getLogger(MenuNuevo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        setSize(460, 460);
        vt_menu = this;
        
        //menu 1. Creates a standard menu, gray background, Center Alignment of Roots and Leafs, small monospaced font.
        menu1 = new AccordionMenu(getSampleMenuDescriptor());

        //menu 3. Creates a simple menu, white bacground and dark blue foreground, a lightGray selection backgroun on mouseover, Right Alignment for leafs
        //two icon for all Root Items, and two icon for Leaf of second menu only
        menu3 = new AccordionMenu();
        createSampleMenuStructure(menu3);
        menu3.setBackground(Color.white);
        menu3.setForeground(Color.blue.darker().darker().darker());
        menu3.setFont(new FontUIResource("Calibri", Font.BOLD, 18));
        //menu3.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 15));
        menu3.setSelectionColor(Color.lightGray);
        menu3.setLeafHorizontalAlignment(AccordionItem.LEFT);
        ImageIcon icon3 = new ImageIcon(this.getClass().getResource("../b4/advancedgui/menu/resources/blu_arrow_right.png"));
        ImageIcon icon4 = new ImageIcon(this.getClass().getResource("../b4/advancedgui/menu/resources/blu_arrow_down.png"));
        menu3.setMenuIcons(icon3, icon4);
        setMouseAdapter(menu3);
        cont3.add(menu3);
        //------------------------------------------------------------------------------------------------------------------------

        //setExitButton();
    }

    /**
     * Simple bind of an action to a single Menu Leaf Item. This is the most important aspect of menu.
     
    public void setExitButton() {
        menu1.getLeaf("exit").addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(1);
            }
        });
    }
*/
    /**
     * <code>First method to create an AccordionMenu: create a description string of menu tree.</code>
     * It creates a Standard Description String to create an AccordionMenu. This is
     * the full structure of a correct description string. 
     * @return description String.
     */
    public String getSampleMenuDescriptor() {
        String menuDescriptor = ""
                + "Menu One,menu1:"
                + "Sub Menu 1,submenu1.1;"
                + "Sub Menu 2,submenu1.2;"
                + "Exit Button,exit;"
                + "!"
                + "Menu Two,menu2:"
                + "Sub Menu 1,submenu2.1;"
                + "Sub Menu 2,submenu2.2;"
                + "Sub Menu 3,submenu2.3;"
                + "!"
                + "Menu Three,menu3:"
                + "Sub Menu 1,submenu3.1;"
                + "Sub Menu 2,submenu3.2;"
                + "Sub Menu 3,submenu3.3;"
                + "!"
                + "Menu Four,menu4:"
                + "Sub Menu 1,submenu4.1;"
                + "Sub Menu 2,submenu4.2;";
                //+ "Sub Menu 3,submenu4.3;";
        return menuDescriptor;
    }

    /**
     * <code>Second method to create an AccordionMenu: add manually each menu with its leafs to AccordionMenu.</code>
     * It creates manually a structure like one created before with a description String. First method is better when
     * menu structure is static. Use this method instead if you want to create structure dinamically.
     * @param target Target AccordionMenu to modify.
     */
    public void createSampleMenuStructure(AccordionMenu target) {
        target.addNewMenu("menu1", "RESERVAS");
        target.addNewLeafTo("menu1", "submenu1.1", "Reservar Turno");
        target.addNewLeafTo("menu1", "submenu1.2", "Cancelar Turno");
        
        target.addNewMenu("menu2", "RECORDATORIOS");
        target.addNewLeafTo("menu2", "submenu2.1", "Config. Recordatorios");
        
        target.addNewMenu("menu3", "HISTORIAL");
        target.addNewLeafTo("menu3", "submenu3.1", "Ver Historial");
        
        target.addNewMenu("menu4", "TELS. Y DIR. ÚTILES");
        target.addNewLeafTo("menu4", "submenu4.1", "Ver Tels. y Dirs. útiles");
        
        target.addNewMenu("menu5", "SOBRE LA APP");
        target.addNewLeafTo("menu5", "submenu5.1", "Sugerencias");
        target.addNewLeafTo("menu5", "submenu5.2", "Terms. y Condiciones");
        target.calculateAvaiableSpace();
    }

    /**
     * Simple example to browse all Leaf of menu. In this case for each leaf it adds a new Mouse Adapter.
     * @param menu Target Menu to modify.
     */
    public void setMouseAdapter(AccordionMenu menu) {
        for (AccordionLeafItem leaf : menu.getAllLeafs()) {
            leaf.addMouseListener(getSimpleMouseAdapter());
        }
    }

    /**
     * Creates a simple MouseAdapter binded to an AccordionItem. On mouse Pressed it writes on a textBox the source of event.
     * @return {@link MouseAdapter} object.
     */
    public MouseAdapter getSimpleMouseAdapter() {
        return new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                AccordionItem item = (AccordionItem) e.getSource();
                System.out.println("Source name: " + item.getName() + "; Source Title: " + item.getText());
                
                if(item.getName().equals("submenu1.1")){
                  Reserva reserva = new Reserva();
                  reserva.setVisible(true);
                  vt_menu.setVisible(false);
                }
                
                if(item.getName().equals("submenu1.2")){
                  Cancelar cancelar = new Cancelar();
                  cancelar.setVisible(true);
                  vt_menu.setVisible(false);
                }
                
                if(item.getName().equals("submenu2.1")){
                  Recordatorio recordatorio = new Recordatorio();
                  recordatorio.setVisible(true);
                  vt_menu.setVisible(false);
                }
                
                if(item.getName().equals("submenu3.1")){
                  Historial historial =  new Historial();
                  historial.setVisible(true);
                  vt_menu.setVisible(false);
                }
                
                if(item.getName().equals("submenu4.1")){
                  TelsDir TelsDir =  new TelsDir();
                  TelsDir.setVisible(true);
                  vt_menu.setVisible(false);
                }
                
                if(item.getName().equals("submenu5.1")){
                  Sugerencias sugerencias = new Sugerencias();
                  sugerencias.setVisible(true);
                  vt_menu.setVisible(false);
                }
                
                if(item.getName().equals("submenu5.2")){
                  Terms terms = new Terms();
                  terms.setVisible(true);
                  vt_menu.setVisible(false);
                }
                
                
                //message.setText("Source name: " + item.getName() + "; Source Title: " + item.getText());
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cont3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_IdSesion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SysTurno v1.0.0 Alpha");
        setBackground(new java.awt.Color(255, 204, 204));
        setResizable(false);
        setSize(new java.awt.Dimension(200, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);

        cont3.setBackground(new java.awt.Color(153, 153, 153));
        cont3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        cont3.setLayout(new javax.swing.BoxLayout(cont3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("- Los De Melo -");

        lbl_IdSesion.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cont3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_IdSesion))
                .addGap(0, 377, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cont3, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_IdSesion))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 788, 405));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoAzul.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuNuevo(infoSesion).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cont3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_IdSesion;
    // End of variables declaration//GEN-END:variables
}
