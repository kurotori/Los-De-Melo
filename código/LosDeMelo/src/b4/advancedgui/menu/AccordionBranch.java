package b4.advancedgui.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class AccordionBranch extends javax.swing.JPanel {

    /** Number of items in branch. */
    private int count = 0;
    /** Fake void elements used to fill blank spaces.*/
    private List<JLabel> fooItems;

    /**
     * Default constructor. Sets transparent container
     */
    public AccordionBranch() {
        initComponents();
        container.setOpaque(false);
        container.setLayout(new GridLayout(0, 1, 0,5));
        this.fooItems = new ArrayList<JLabel>();
    }

    /**
     * Add an {@link AccordionItem} to this branch panel.
     * @param item Target item to insert in.
     */
    public void addItem(AccordionItem item) {
        container.add(item);
        count++;
    }

    /**
     * By a reference number it fills blank space with void <code>JLabel</code>s
     * @param max Number of desidered elements. It creates (<code>max - count</code>) fake elements.
     */
    public void adjustItems(int max) {
        for (JLabel l : this.fooItems) {
            container.remove(l);
        }
        this.fooItems.clear();
        for (int i = max; i > getCount(); i--) {
            JLabel lab = new JLabel("");
            lab.setBackground(Color.green);
            container.add(lab);
            this.fooItems.add(lab);
        }
    }

    /**
     *
     * @return Number of items of branch.
     */
    public int getCount() {
        return count;
    }

    /**
     * Automatic Layout code generation with NETBEANS. It uses a GroupLayout for
     * a panel with Margin around. It is more simple do that with a visual editor like
     * netbeans one that writing code from blank page.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();

        container.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    // End of variables declaration//GEN-END:variables
}
