package com.pontusasp.game.core;

/**
 * Created by Pontus on 2018-04-29.
 */
public abstract class Interactive implements Dynamic, Drawable {

    public float x, y;

    public int getX() {
        return Math.round(x);
    }

    public int getY() {
        return Math.round(y);
    }

}
