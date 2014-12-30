package com.camcecil.lanternaexamples; /**
 * Main.java
 *
 * @author Cam Cecil (github/scrapcode)
 */
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;

public class Main {
    public static void main(String[] args) {
        GUIScreen gui = TerminalFacade.createGUIScreen();
        gui.getScreen().startScreen();
        MainWindow w = new MainWindow();
        gui.showWindow(w, GUIScreen.Position.NEW_CORNER_WINDOW);
        gui.getScreen().stopScreen();
    }
}
