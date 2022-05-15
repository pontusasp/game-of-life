package com.pontusasp.game.shapes;

import java.awt.*;

/**
 * Created by Pontus on 2018-04-29.
 */
public class Rectangle extends Shape {

    public int width, height;
    public boolean hollow = false;

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        if(hollow) g.drawRect(Math.round(x), Math.round(y), width, height);
        else g.fillRect(Math.round(x), Math.round(y), width, height);
    }
}
