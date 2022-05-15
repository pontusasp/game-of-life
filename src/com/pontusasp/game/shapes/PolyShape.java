package com.pontusasp.game.shapes;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Pontus on 2018-04-29.
 */
public class PolyShape extends com.pontusasp.game.shapes.Shape {

    private ArrayList<com.pontusasp.game.shapes.Shape> shapes = new ArrayList<>();

    @Override
    public void draw(Graphics g) {
        for (com.pontusasp.game.shapes.Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public void addShape(com.pontusasp.game.shapes.Shape shape) {
        shape.move(x, y);
        shape.setColor(color);
        shapes.add(shape);
    }

    @Override
    public void setColor(Color color) {
        for (com.pontusasp.game.shapes.Shape shape : shapes) {
            shape.setColor(color);
        }
    }

    @Override
    public void move(float offsetX, float offsetY) {
        super.move(offsetX, offsetY);
        for (com.pontusasp.game.shapes.Shape shape : shapes) {
            shape.move(offsetX, offsetY);
        }
    }

    @Override
    public void setPosition(float x, float y) {
        for (com.pontusasp.game.shapes.Shape shape : shapes) {
            shape.move(x - this.x, y - this.y);
        }
        super.setPosition(x, y);
    }

    @Override
    public void setPosition(com.pontusasp.game.shapes.Shape shape) {
        float tx = this.x;
        float ty = this.y;
        super.setPosition(shape);
        for (com.pontusasp.game.shapes.Shape sh : shapes) {
            sh.setPosition(x - tx, y - ty);
        }
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public void removeShape(int index) {
        shapes.remove(index);
    }

}
