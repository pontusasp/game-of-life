package com.pontusasp.game.shapes;

import com.pontusasp.game.core.Drawable;
import com.pontusasp.game.core.Panel;

import java.awt.*;

/**
 * Created by Pontus on 2018-04-29.
 */
public abstract class Shape implements Drawable {
    protected float x, y;
    protected Color color = Color.BLACK;

    public void setColor(Color color) {
        this.color = color;
    }

    public void move(float offsetX, float offsetY) {
        x += offsetX;
        y += offsetY;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(Shape shape) {
        if (shape == null) {
            this.x = Panel.width / 2f;
            this.y = Panel.height / 2f;
        } else {
            this.x = shape.x;
            this.y = shape.y;
        }
    }
}
