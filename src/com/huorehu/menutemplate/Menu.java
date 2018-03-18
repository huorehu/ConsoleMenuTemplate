package com.huorehu.menutemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/** Template of a simple console menu. */
public class Menu {

    /** List of the menu items. */
    private List<MenuEntry> entries = new ArrayList<>();
    /** Flag allowing exit from application menu. */
    private boolean isExit = false;

    public Menu() {
        entries.add(new MenuEntry("Exit") {
            @Override
            public void run() {
                isExit = true;
                System.out.println("Exiting...");
            }
        });

        int lastElementIndex = entries.size() - 1;
        entries.get(lastElementIndex).setMenuIndex(lastElementIndex);
    }

    /** Run application menu. */
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!isExit) {
            printMenu();
            try {
                String line = reader.readLine();
                int choice;
                // Validate user choice and 'go to the menu item' (run entry menu method).
                if (line.matches("\\d+") && (choice = Integer.parseInt(line)) >= 0 && choice < entries.size()) {
                    entries.get(choice).run();
                } else {
                    System.out.println("Such menu item does not exist");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Added in menu list new menu item and resorted it indexes.
     * @param menuEntry the menu item.
     */
    public void addMenuEntry(MenuEntry menuEntry) {
        entries.add(menuEntry);
        for (int i = 0; i < entries.size(); i++) {
            entries.get(i).setMenuIndex(i);
        }
    }

    /** Printing item index and it title. */
    private void printMenu() {
        System.out.println("Select the menu item:\n");
        entries.forEach(System.out::println);
    }

}
