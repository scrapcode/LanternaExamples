package com.camcecil.lanternaexamples;

/**
 * MainWindow.java
 *
 * @author Cam Cecil (github/scrapcode)
 */
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.TerminalSize;

public class MainWindow extends Window {
    public MainWindow() {
        super("Main Window!");


        /**
         * Panel Initializations
         */
        Panel inputPanel = new Panel(new Border.Bevel(true), Panel.Orientation.HORISONTAL);
        Panel contentPanel = new Panel(new Border.Standard(), Panel.Orientation.VERTICAL);
        Panel mainPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);

        /**
         * Initialize Dynamic Components
         */
        final Label statusLabel = new Label("", 40);

        /**
         * Input Panel Components
         */
        inputPanel.addComponent(new Label("Enter Your First Name:"));
        final TextBox txtFirstName = new TextBox();
        inputPanel.addComponent(txtFirstName);
        inputPanel.addComponent(new Button("Greet Me", new Action() {
            @Override
            public void doAction() {
                statusLabel.setText("Welcome, " + txtFirstName.getText() + "!");
            }
        }));

        /**
         * Content Panel Components
         */
        contentPanel.setPreferredSize(new TerminalSize(50, 10));
        contentPanel.addComponent(new Label("This is a content panel with a fixed size of\n 50x10."));

        /**
         * Main Panel's
         * Sub Panels
         */
        Panel leftPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
        Panel middlePanel = new Panel(new Border.Invisible(), Panel.Orientation.VERTICAL);
        Panel rightPanel = new Panel(new Border.Invisible(), Panel.Orientation.VERTICAL);

        /**
         * Main Panel's
         * Sub Panel Components
         */

        // Status Bar
        leftPanel.addComponent(new Label("Status:"));
        leftPanel.addComponent(statusLabel);

        // About Button
        middlePanel.addComponent(new Button("About", new Action() {
            @Override
            public void doAction() {
                statusLabel.setText("Clicked About");
                MessageBox.showMessageBox(getOwner(), "About Lanterna Examples",
                        "This is a reference showing examples of the\n" +
                                "Google Lanterna GUI Library (v2.1.9)\n\n" +
                                "By: Cameron Cecil\n" +
                                "github.com/scrapcode");
            }
        }));

        // Exit Button
        rightPanel.addComponent(new Button("Exit", new Action() {
            @Override
            public void doAction() {
                System.exit(0);
            }
        }));

        /**
         * Add Left, Middle, and Right panels to the Main Panel
         */
        mainPanel.addComponent(leftPanel);
        mainPanel.addComponent(middlePanel);
        mainPanel.addComponent(rightPanel);

        /**
         * Add Panels to the Window
         */
        addComponent(inputPanel);
        addComponent(contentPanel);
        addComponent(mainPanel);

    }
}
