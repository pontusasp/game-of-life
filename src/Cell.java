import com.pontusasp.game.shapes.Shape;

import java.awt.*;

public class Cell extends Shape {

    protected boolean alive = false;
    protected boolean resurrect = false;
    protected boolean kill = false;

    public int stable = 0;

    public int r = 255 / 3;
    public int g = 255 / 2;
    public int b = 255 / 5;

    public Cell(float x, float y) {
        setPosition(x, y);
    }

    public void draw(Graphics g) {
        if (!Grid.SHOWDEAD == alive || alive) {
        //if ((Grid.SHOWDEAD || !alive) && !alive) {
            g.setColor(new Color( 20 + this.r % 200, 50 + this.g % 150, this.b % 255));
            g.fillRect((int) (x * Main.WIDTH), (int) (y * Main.HEIGHT),
                    Grid.cellWidth, Grid.cellHeight);
        }
    }

}
