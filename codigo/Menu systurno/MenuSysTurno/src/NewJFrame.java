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

public final class NewJFrame extends javax.swing.JFrame {

    private AccordionMenu menu1;
    private AccordionMenu menu2;
    private AccordionMenu menu3;

    public NewJFrame() {
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
            setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("b4/advancedgui/menu/resources/green_arrow_right.png")));
        } catch (Exception ex ) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        setSize(600, 600);

        //menu 1. Creates a standard menu, gray background, Center Alignment of Roots and Leafs, small monospaced font.
        menu1 = new AccordionMenu(getSampleMenuDescriptor());

        //menu 3. Creates a simple menu, white bacground and dark blue foreground, a lightGray selection backgroun on mouseover, Right Alignment for leafs
        //two icon for all Root Items, and two icon for Leaf of second menu only
        menu3 = new AccordionMenu();
        createSampleMenuStructure(menu3);
        menu3.setBackground(Color.white);
        menu3.setForeground(Color.blue.darker().darker().darker());
        menu3.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 15));
        menu3.setSelectionColor(Color.lightGray);
        menu3.setLeafHorizontalAlignment(AccordionItem.RIGHT);
        ImageIcon icon3 = new ImageIcon(this.getClass().getResource("b4/advancedgui/menu/resources/blu_arrow_right.png"));
        ImageIcon icon4 = new ImageIcon(this.getClass().getResource("b4/advancedgui/menu/resources/blu_arrow_down.png"));
        menu3.setMenuIcons(icon3, icon4);
        setMouseAdapter(menu3);
        cont3.add(menu3);
        //------------------------------------------------------------------------------------------------------------------------

        setExitButton();
    }

    /**
     * Simple bind of an action to a single Menu Leaf Item. This is the most important aspect of menu.
     */
    public void setExitButton() {
        menu1.getLeaf("exit").addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(1);
            }
        });
    }

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
                + "Sub Menu 2,submenu4.2;"
                + "Sub Menu 3,submenu4.3;";
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
        
        target.addNewMenu("menu3", "HISTORIAL");
        
        target.addNewMenu("menu4", "TELS. Y DIR. ÚTILES");
        
        target.addNewMenu("menu5", "SOBRE LA APP");
        target.addNewLeafTo("menu5", "submenu4.1", "Sugerencias");
        target.addNewLeafTo("menu5", "submenu4.2", "Terms. y Condiciones");
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
                //message.setText("Source name: " + item.getName() + "; Source Title: " + item.getText());
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cont3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setPreferredSize(new java.awt.Dimension(450, 800));
        setResizable(false);

        jPanel1.setOpaque(false);

        cont3.setBackground(new java.awt.Color(153, 153, 153));
        cont3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        cont3.setLayout(new javax.swing.BoxLayout(cont3, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cont3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cont3, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cont3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
