package com.pontusasp.game.core;

import javax.swing.*;

/**
 * Created by Pontus on 2018-04-29.
 */
public class Window extends JFrame {

    public Window(String title, Panel panel) {
        add(panel);

        setTitle(title);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
