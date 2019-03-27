package b4.advancedgui.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;

public final class AccordionMenu extends JPanel {

    /** Menu Root Item default minimum size.*/
    public static int MINIMUM_SIZE = 25;
    /** Menu Root Item height.*/
    private int menusSize = MINIMUM_SIZE;
    /** Menu item count */
    private int menuCount;
    /** This parameters stores the value of free vertical space that can be used to display a menu branch */
    private int branchAvaiableSpace;
    /** This parameters counts how many rows is void in a menu branch */
    private int freeAvaiableRows;
    /** Animation time pause. Higher value -> Slower animation */
    private int timeStep = 10;
    /** Color of item HIGHLIGHT on <code>mouseover</code>. NULL is allowed. */
    private Color selectionColor = null;
    /** Handle to selected menu. It is the menu with the opened branch. */
    private AccordionRootItem selectedMenu;
    /** Handle to the last selected Menu Item. Used for animation. */
    private AccordionRootItem lastSelectedMenu;
    /** Handle to selected Leaf Item. */
    private AccordionLeafItem selectedLeaf;
    /** It is value of vertical size of branch that is opening. It is simply <code>(branchAvaiableSpace - hidingSize)</code>.*/
    private int showingSize;
    /** It is value of vertical size of branch that is closing. It is simply <code>(branchAvaiableSpace - showingSize)</code>. */
    private int hidingSize;
    /** A Map representig the menu tree with handle to each menu items. */
    private TreeMap<AccordionRootItem, List<AccordionLeafItem>> leafMap;

    /**
     * Default basic constructor. Creates tree map of menu. And prepares layout and events.
     */
    public AccordionMenu() {
        this.addComponentListener(getDefaultComponentAdapter());
        this.setLayout(null);
        this.leafMap = new TreeMap<AccordionRootItem, List<AccordionLeafItem>>();
    }

    /**
     * Creates a menu with a predefined structure passed by <code>String</code>.
     * The stucture for example is like:
     * <br><br>
     * <code>"Menu One,menu1:Sub Menu1,submenu1;Sub Menu2,submenu2;Sub Menu 3,submenu3!Menu Two:Sub Menu1,submenu1;Sub Menu2,submenu2;Sub Menu 3,submenu3!"</code>
     * <br><br>
     * Each element is a couple <code>itemName,itemTitle</code> like (Menu One,menu1).<br>
     * <code>itemName</code> is used as handle to menu item.<br>
     * The ":" regex is used to separate Menu Root Item to its Leafs. The "," separates leafs.
     * And "!" regex is used to separate each Menu Root from others.
     * @param menuDescriptor String representing structure of menu.
     */
    public AccordionMenu(String menuDescriptor) {
        this();
        createMenusFromDescriptor(menuDescriptor);
    }

    /**
     * The stucture for example is like:
     * <br><br>
     * <code>"Menu One,menu1:Sub Menu1,submenu1;Sub Menu2,submenu2;Sub Menu 3,submenu3!Menu Two:Sub Menu1,submenu1;Sub Menu2,submenu2;Sub Menu 3,submenu3!"</code>
     * <br><br>
     * Each element is a couple <code>itemName,itemTitle</code> like (Menu One,menu1).<br>
     * <code>itemName</code> is used as handle to menu item.<br>
     * The ":" regex is used to separate Menu Root Item to its Leafs. The "," separates leafs.
     * And "!" regex is used to separate each Menu Root from others.
     *
     * @param menuDescriptor String representing structure of menu.
     */
    public void createMenusFromDescriptor(String menuDescriptor) {
        this.leafMap = new TreeMap<AccordionRootItem, List<AccordionLeafItem>>();
        String[] menus = menuDescriptor.split("!");
        boolean first = true;
        menuCount = 0;
        for (String menu : menus) {
            String name = menu.split(":")[0];
            AccordionRootItem menuItem = createRootItem(name.split(",")[0], name.split(",")[1]);
            menuItem.addMouseListener(getDefaultMenuMouseAdapter());

            if (first) {
                menuItem.setSelected(true);
//                lastSelectedMenu = menuItem;
                first = false;
            }
            String leafs = menu.split(":")[1];
            List<AccordionLeafItem> leafList = new ArrayList<AccordionLeafItem>();
            for (String leaf : leafs.split(";")) {
                AccordionLeafItem leafItem = createLeafItem(leaf.split(",")[0], leaf.split(",")[1]);
                menuItem.getBranchPanel().addItem(leafItem);
                leafItem.addMouseListener(getDefaultLeafMouseAdapter());
                leafList.add(leafItem);
            }
            menuItem.setIndex(menuCount);
            menuCount++;
            leafMap.put(menuItem, leafList);
            this.add(menuItem.getBranchPanel());
        }
        menuCount = leafMap.keySet().size();
        calculateAvaiableSpace();
    }

    /**
     *
     * @return {@link MouseAdapter} object with implementation of events of mouse on Leaf Menu Items.
     */
    public MouseAdapter getDefaultLeafMouseAdapter() {
        return new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                AccordionLeafItem item = (AccordionLeafItem) e.getSource();
                for (AccordionLeafItem leaf : getAllLeafs()) {
                    leaf.setSelected(false);
                    leaf.repaint();
                }
                item.setSelected(true);
            }
        };
    }

    /**
     *
     * @return {@link MouseAdapter} object with implementation of events of mouse on Root Menu Items.
     */
    private MouseAdapter getDefaultMenuMouseAdapter() {
        return new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                AccordionRootItem item = (AccordionRootItem) e.getSource();
                for (AccordionRootItem menu : getMenus()) {
                    if (menu.isSelected()) {
                        lastSelectedMenu = menu;
                        menu.setSelected(false);
                    }
                }
                item.setSelected(true);
                if (lastSelectedMenu == item) {
                    return;
                }
                startAnimation();
            }
        };
    }

    /**
     * Begin animation of Closing/Opening of new menu branch. It divides the <code>branchAvaiableSpace</code>
     * in two parts <code>showingSize</code> and <code>hidingSize</code>, the first one grow up and the second one
     * goes to zero with a certain time step. Pixel step is fixed to 30 but is not a charge.
     */
    private void startAnimation() {
        Thread thread = new Thread(new Runnable() {

            public void run() {
                showingSize = 0;
                hidingSize = branchAvaiableSpace;
                int step = 30;
                while (hidingSize > 0) {
                    showingSize += step;
                    hidingSize -= step;
                    update();
                    repaint();
                    try {
                        Thread.sleep(timeStep);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AccordionMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                showingSize = branchAvaiableSpace;
                hidingSize = 0;

                update();
                repaint();
            }
        });
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    /**
     * Updates UI of each menu branch. Used to fix some visual problems.
     */
    public void update() {
        for (AccordionRootItem menu : getMenus()) {
            menu.getBranchPanel().updateUI();
        }
    }

    /**
     * Updates UI of each menu leaf. Used to fix some visual problems.
     */
    public void updateLeafs() {
        for (AccordionLeafItem leaf : getAllLeafs()) {
            leaf.repaint();
        }
    }

    /**
     * The core dispplay engine is in this function. The algorithm is very simple:
     * each Menu Root Item is displayed with 100% width and one behind others,
     * with fixed menuSize height. In case that Menu is selected,
     * it starts to displays the menuBranch of selected menu and it starts to hide the menuBranch of previous selected menu.
     * This function ignores the animation function; it just displays, with some parameters,
     * the current and previous selected menues. So the animation function changes parameters at runtime to give an animation effect.
     * @param g  Graphics object of this component.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int currentY = 0;
        for (AccordionRootItem menu : getMenus()) {
            menu.setSize(this.getWidth(), this.menusSize);
            menu.setLocation(0, currentY);

            if (menu == lastSelectedMenu && !menu.isSelected()) {
                currentY += this.menusSize;
                menu.getBranchPanel().setSize(this.getWidth(), this.hidingSize);
                menu.getBranchPanel().setLocation(0, currentY);
                currentY += this.hidingSize;
            }
            if (menu.isSelected()) {
                currentY += this.menusSize;
                menu.getBranchPanel().adjustItems(freeAvaiableRows);
                menu.getBranchPanel().setSize(this.getWidth(), this.showingSize);
                menu.getBranchPanel().setLocation(0, currentY);
                currentY += this.showingSize;
            } else if (!menu.isSelected() && menu != lastSelectedMenu) {
                menu.getBranchPanel().setSize(0, 0);
                currentY += this.menusSize;
            }
        }
        update();
    }

    /**
     * @return List of {@link AccordionRootItem}, handles to Menu Root Items.
     */
    public List<AccordionRootItem> getMenus() {
        return new ArrayList<AccordionRootItem>(leafMap.keySet());
    }

    /**
     *
     * @param name Name of target menu.
     * @return {@link AccordionRootItem} object with selected name if any.
     */
    public AccordionRootItem getMenu(String name) {
        for (AccordionRootItem menu : leafMap.keySet()) {
            if (menu.getName().equals(name)) {
                return menu;
            }
        }
        return null;
    }

    /**
     *
     * @return List of {@link AccordionLeafItem}, handles to Menu Leaf Items of all menu.
     */
    public List<AccordionLeafItem> getAllLeafs() {
        List<AccordionLeafItem> leafs = new ArrayList<AccordionLeafItem>();
        for (AccordionRootItem menu : leafMap.keySet()) {
            leafs.addAll(leafMap.get(menu));
        }
        return leafs;
    }

    /**
     *
     * @param menuName Target menu name.
     * @return List of {@link AccordionLeafItem} of choosen menu if any.
     */
    public List<AccordionLeafItem> getLeafsOf(String menuName) {
        List<AccordionLeafItem> leafs = new ArrayList<AccordionLeafItem>();
        for (AccordionRootItem menu : leafMap.keySet()) {
            if (menu.getName().equals(menuName)) {
                leafs.addAll(leafMap.get(menu));
            }
        }
        return leafs;
    }

    /**
     *
     * @param name Target leaf name.
     * @return {@link AccordionLeafItem} object with selected name if any.
     */
    public AccordionLeafItem getLeaf(String name) {
        for (AccordionLeafItem leaf : getAllLeafs()) {
            if (leaf.getName().equals(name)) {
                return leaf;
            }
        }
        return null;
    }

    /**
     *
     * @return {@link ComponentAdapter} object that implements resizing event.
     */
    public ComponentAdapter getDefaultComponentAdapter() {
        return new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                calculateAvaiableSpace();
            }
        };
    }

    /**
     * Calculates some parameters. Usally called after a resize event because it calculate
     * some parameters depending of Size of this component.
     */
    public void calculateAvaiableSpace() {
        int height = getHeight();
        double scale = menusSize / 20;
        branchAvaiableSpace = height - (menuCount * menusSize);
        freeAvaiableRows = (int) (Math.ceil(height / (menusSize)) * scale) - menuCount;
        showingSize = branchAvaiableSpace;
        hidingSize = 0;
        update();
    }

    /**
     * Creates a Root Menu Item of accordion menu with selected title and name.
     * It creates <code>AccordionRootItem</code> and add it to container.
     *
     * @param title Displayed title.
     * @param name Binding name.
     * @return <code>AccordionRootItem</code> object created.
     */
    private AccordionRootItem createRootItem(String title, String name) {
        AccordionRootItem menu = new AccordionRootItem(title);
        menu.setName(name);
        add(menu);
        return menu;
    }

    /**
     * Creates a Leaf Menu Item of accordion menu with selected title and name.
     * It creates <code>AccordionLeafItem</code>.
     *
     * @param title Displayed title.
     * @param name Binding name.
     * @return <code>AccordionLeafItem</code> object created.
     */
    private AccordionLeafItem createLeafItem(String title, String name) {
        AccordionLeafItem leaf = new AccordionLeafItem(title);
        leaf.setName(name);
        //add(leaf);
        return leaf;
    }

    /**
     * Add a new Leaf to selected Menu.
     *
     * @param menuName Father menu of new leaf.
     * @param leafTitle Displayed title.
     * @param leafName Binding name.
     */
    public void addNewLeafTo(String menuName, String leafName, String leafTitle) {
        for (AccordionRootItem menu : getMenus()) {
            if (menu.getName().equals(menuName)) {
                AccordionLeafItem item = createLeafItem(leafTitle, leafName);
                item.addMouseListener(getDefaultLeafMouseAdapter());
                this.leafMap.get(menu).add(item);
                menu.getBranchPanel().addItem(item);
                return;
            }
        }
    }

    /**
     * Add a new Root menu.
     *
     * @param menuName Displayed name.
     * @param menuTitle Binding name.
     */
    public void addNewMenu(String menuName, String menuTitle) {
        List<AccordionLeafItem> leafs = new ArrayList<AccordionLeafItem>();
        AccordionRootItem menu = createRootItem(menuTitle, menuName);
        menu.addMouseListener(getDefaultMenuMouseAdapter());
        menu.setIndex(menuCount);
        if (menuCount == 0) {
            menu.setSelected(true);
//            lastSelectedMenu = menu;
        }
        menuCount++;
        this.leafMap.put(menu, leafs);
        this.add(menu.getBranchPanel());
    }

    /**
     * Changes background <code>Color</code> of each item of menu.
     * @param back Selected <code>Color</code>.
     */
    @Override
    public void setBackground(Color back) {
        if (this.leafMap == null) {
            return;
        }
        for (AccordionRootItem menu : leafMap.keySet()) {
            menu.setBackground(back);
            menu.getBranchPanel().setBackground(back);
            if (selectionColor == null) {
                for (AccordionLeafItem leaf : leafMap.get(menu)) {
                    leaf.setBackground(back);
                }
            }
        }
    }

    /**
     * Sets icons to Menu Root Items. Accepts null value if you want to change
     * only one icon type.
     * @param normal Normal {@link ImageIcon}.
     * @param selected Selected {@link ImageIcon}.
     */
    public void setMenuIcons(ImageIcon normal, ImageIcon selected) {
        if (normal != null) {
            for (AccordionRootItem menu : getMenus()) {
                menu.setNormalIcon(normal);
            }
        }
        if (selected != null) {
            for (AccordionRootItem menu : getMenus()) {
                menu.setSelectedIcon(selected);
            }
        }
        updateLeafs();
    }

    /**
     * Sets icons to all Menu Leaf Items. Accepts null value if you want to change
     * only one icon type.
     * @param normal Normal {@link ImageIcon}.
     * @param selected Selected {@link ImageIcon}.
     */
    public void setAllLeafIcons(ImageIcon normal, ImageIcon selected) {
        if (normal != null) {
            for (AccordionLeafItem leaf : getAllLeafs()) {
                leaf.setNormalIcon(normal);
            }
        }
        if (selected != null) {
            for (AccordionLeafItem leaf : getAllLeafs()) {
                leaf.setSelectedIcon(selected);
            }
        }
        updateLeafs();
    }

    /**
     * Sets icons to Menu Leaf Items of selected Menu Root Item if any. Accepts null value if you want to change
     * only one icon type.
     * @param menuName Target Menu Root Item.
     * @param normal Normal {@link ImageIcon}.
     * @param selected Selected {@link ImageIcon}.
     */
    public void setLeafIcons(String menuName, ImageIcon normal, ImageIcon selected) {
        for (AccordionRootItem menu : getMenus()) {
            if (menu.getName().equals(menuName)) {
                if (normal != null) {
                    for (AccordionLeafItem leaf : getLeafsOf(menuName)) {
                        leaf.setNormalIcon(normal);
                    }
                }
                if (selected != null) {
                    for (AccordionLeafItem leaf : getLeafsOf(menuName)) {
                        leaf.setSelectedIcon(selected);
                    }
                }
            }
        }
        updateLeafs();
    }

    /**
     * Sets border to all Menu Root Items.
     * @param border {@link Border} object.
     */
    public void setMenuBorders(Border border) {
        for (AccordionRootItem menu : getMenus()) {
            menu.setBorder(border);
        }
    }

    /**
     * Sets alignment for Menu Root Items.
     * @param align Alignment value. es. use <code>AccordionItem.CENTER</code>.
     */
    public void setMenuHorizontalAlignment(int alignment) {
        if (this.leafMap == null) {
            return;
        }
        for (AccordionRootItem menu : leafMap.keySet()) {
            menu.setHorizontalAlignment(alignment);
        }
    }

    /**
     * Sets alignment for Menu Leaf Items.
     * @param Alignment value. es. use <code>AccordionItem.CENTER</code>.
     */
    public void setLeafHorizontalAlignment(int alignment) {
        if (this.leafMap == null) {
            return;
        }
        for (AccordionLeafItem leaf : getAllLeafs()) {
            leaf.setHorizontalAlignment(alignment);
        }
    }

    /**
     *
     * @return Color of HIGHLIGHT on mouseover event on items.
     */
    public Color getSelectionColor() {
        return selectionColor;
    }

    /**
     * Sets Color of HIGHLIGHT on mouseover event on items of menu.
     * @param selectionColor Selected Color. Allow NULL.
     */
    public void setSelectionColor(Color selectionColor) {
        this.selectionColor = selectionColor;
        for (AccordionRootItem menu : leafMap.keySet()) {
            for (AccordionLeafItem leaf : leafMap.get(menu)) {
                leaf.setBackground(selectionColor);
            }
        }
    }

    /**
     * Changes Font to each menu item.
     * @param font Selected Font.
     */
    public void setFont(Font font) {
        if (this.leafMap == null) {
            return;
        }
        for (AccordionRootItem menu : getMenus()) {
            menu.setFont(font);
            for (AccordionLeafItem leaf : getLeafsOf(menu.getName())) {
                leaf.setFont(font);
            }
        }
    }

    /**
     * Sets Foreground Color to each menu item.
     * @param fg Selected Color.
     */
    @Override
    public void setForeground(Color fg) {
        if (this.leafMap == null) {
            return;
        }
        for (AccordionRootItem menu : getMenus()) {
            menu.setForeground(fg);
            for (AccordionLeafItem leaf : getLeafsOf(menu.getName())) {
                leaf.setForeground(fg);
            }
        }
    }

    /**
     *
     * @return Number of Root Menu Items.
     */
    public int getMenuCount() {
        return menuCount;
    }

    /**
     *
     * @return Value of height size of Root Menu Items.
     */
    public int getMenusSize() {
        return menusSize;
    }

    /**
     * Sets Value of height size of Root Menu Items. Tests show that 30 is minimum for a better view
     * @param menusSize
     */
    public void setMenusSize(int menusSize) {
        if (menusSize < MINIMUM_SIZE) {
            setMenusSize(MINIMUM_SIZE);
        }
        this.menusSize = menusSize;
        calculateAvaiableSpace();
        repaint();
    }

    /**
     *
     * @return Time step value of animations.
     */
    public int getTimeStep() {
        return timeStep;
    }

    /**
     * Sets value for animation steps. Higher values -> slower animations.
     * @param timeStep Selected value.
     */
    public void setTimeStep(int timeStep) {
        this.timeStep = timeStep;
    }

    /**
     *
     * @return {@link AccordionLeafItem} handle to selected Leaf Item.
     */
    public AccordionLeafItem getSelectedLeaf() {
        return selectedLeaf;
    }

    /**
     *
     * @return {@link AccordionLeafItem} handle to selected Menu Item.
     */
    public AccordionRootItem getSelectedMenu() {
        return selectedMenu;
    }
}
