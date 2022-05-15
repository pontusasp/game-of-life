package com.pontusasp.game.shapes;

import java.awt.*;

/**
 * Created by Pontus on 2018-04-29.
 */
public class Line extends Shape {

    protected float x2, y2;

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(Math.round(x), Math.round(y),
                Math.round(x2), Math.round(y2));
    }

    public void setOrigin(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setEndPoint(int x, int y) {
        this.x2 = x;
        this.y2 = y;
    }

    @Override
    public void move(float offsetX, float offsetY) {
        super.move(offsetX, offsetY);
        x2 += offsetX;
        y2 += offsetY;
    }

}
