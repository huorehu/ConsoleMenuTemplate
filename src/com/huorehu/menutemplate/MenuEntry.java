package com.huorehu.menutemplate;

/** Abstract menu item. */
public abstract class MenuEntry {

    /** The serial number of the menu in the list. */
    private int menuIndex;
    /** Title of the menu item. */
    private String title;

    public MenuEntry(String title) {
        this.title = title;
    }

    /** Actions to be performed when this menu item is selected in the list. */
    public abstract void run();

    /** Set particular serial number for menu item.
     *  @param menuIndex the serial number for current menu item.
     */
    public void setMenuIndex(int menuIndex) {
        this.menuIndex = menuIndex;
    }

    /** Returns current menu item as a string represented as serial number and title. */
    @Override
    public String toString() {
        return menuIndex + ". " + title;
    }

}
