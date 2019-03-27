package b4.advancedgui.menu;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class AccordionItem extends JLabel implements Comparable {

    /** Boolean parameter binds state of element. SELECTED or NOT. */
    protected boolean selected = false;
    /** <code>IconImage</code> used when item is not selected. */
    protected ImageIcon normalIcon;
    /** <code>IconImage</code> used when item is selected. */
    protected ImageIcon selectedIcon;
    /** Index value for ordering items in menu tree */
    protected int index;

    /**
     * Default Constructor with defualt Title string.
     *
     * @param text Title String displayed.
     */
    public AccordionItem(String text) {
        super(text);
        setOpaque(false);
        addMouseListener(getDefaultMouseActions());
        setNormalIcon(getDefaultNormalIcon());
        setSelectedIcon(getDefaultSelectedIcon());
        setSelected(false);
    }

    /**
     * Derived classes must implement Mouse events.
     * @return {@link MouseAdapter} with only used events.
     */
    public abstract MouseAdapter getDefaultMouseActions();

    /**
     * Derived classes have to create {@link ImageIcon} displayed when item is not selected.
     * @return <code>ImageIcon</code> object.
     */
    public abstract ImageIcon getDefaultNormalIcon();

    /**
     * Derived classes have to create {@link ImageIcon} displayed when item is selected.
     * @return <code>ImageIcon</code> object.
     */
    public abstract ImageIcon getDefaultSelectedIcon();

    /**
     * Derived classes have to create a {@link Paint} object drawn in background. Like {@link GradientPaint}.
     * @return <code>Paint</code> object.
     */
    public abstract Paint getDefaultBackgroundPaint();

    /**
     * Simple switch of state. TRUE to FALSE, FALSE to TRUE.
     */
    public final void switchState() {
        setSelected(!isSelected());
    }

    /**
     *
     * @return <code>TRUE</code> if item is selected; <code>FALSE</code> otherwise.
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Changes state of object. If <code>TRUE</code> sets the appropriate image and BOLD font. The same thing otherwise.
     * @param state Boolean state of object.
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected) {
            setIcon(selectedIcon);
            setFont(getFont().deriveFont(Font.BOLD));
        } else {
            setIcon(normalIcon);
            setFont(getFont().deriveFont(Font.PLAIN));
        }
    }

    /**
     * Draws {@link Paint} object on background if any.
     * @param g <code>Graphics</code> object of JComponent.
     */
    @Override
    protected void paintComponent(Graphics g) {
        if (getDefaultBackgroundPaint() != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(getDefaultBackgroundPaint());
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(g);
    }

    /**
     * @return <code>ImageIcon</code> object of Unselected image status.
     */
    public ImageIcon getNormalIcon() {
        return normalIcon;
    }

    /**
     * Sets <code>ImageIcon</code> object for Unselected status.
     */
    public void setNormalIcon(ImageIcon normalIcon) {
        this.normalIcon = normalIcon;
        setSelected(selected);
    }

    /**
     * @return <code>ImageIcon</code> object of Selected image status.
     */
    public ImageIcon getSelectedIcon() {
        return selectedIcon;
    }

    /**
     * Sets <code>ImageIcon</code> object for Selected status.
     */
    public void setSelectedIcon(ImageIcon selectedIcon) {
        this.selectedIcon = selectedIcon;
         setSelected(selected);
    }

    /**
     * 
     * @return Position in menu tree.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets position in menu tree.
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Implements <code>Comparable</code> interface. Items are ordered by their index value.
     * @param o Target AccordionItem to compare.
     * @return See {@link Comparable} usage.
     */
    public int compareTo(Object o) {
        AccordionItem target = (AccordionItem) o;
        if (getIndex() == target.getIndex()) {
            return 0;
        } else if (getIndex() > target.getIndex()) {
            return 1;
        } else {
            return -1;
        }
    }
}
