import com.pontusasp.game.core.Interactive;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Grid extends Interactive {

    //public static Dimension dimension = new Dimension(Main.WIDTH / 4 - 1, Main.HEIGHT / 4 - 1);
    public static Dimension dimension = new Dimension(Main.WIDTH - 1, Main.HEIGHT - 1);
    public static int cellWidth = Main.WIDTH / Grid.dimension.width;
    public static int cellHeight = Main.WIDTH / Grid.dimension.height;

    public Cell[][] cells = new Cell[dimension.width][];

    public float updateTime = 0.1f;
    public float waitTime = 0;

    public static boolean PAUSED = false;
    public static boolean SHOWDEAD = false;

    public Grid() {
        boolean ddd = false;

        for (int x = 0; x < cells.length; x++) {
            cells[x] = new Cell[dimension.height];
            for (int y = 0; y < cells[0].length; y++) {
                cells[x][y] = new Cell((float) x / cells.length, (float) y / cells[0].length);
                cells[x][y].alive = ddd;
                ddd = !ddd;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        //g.setColor(Color.GREEN);
        for (Cell[] cells : this.cells) {
            for (Cell cell : cells) {
                cell.draw(g);
            }
        }
    }

    @Override
    public void update(float delta) {
        if (!PAUSED)
            waitTime += delta;
        if (waitTime > updateTime) {
            waitTime = 0;
            for (int x = 0; x < cells.length; x++) {
                for (int y = 0; y < cells[0].length; y++) {
                    if (cells[x][y].alive) {
                        if (cells[x][y].kill) {
                            cells[x][y].alive = false;

                        }
                    } else {
                        if(cells[x][y].resurrect) {
                            cells[x][y].r += 30/2;
                            cells[x][y].g += 10/2;
                            cells[x][y].b += 20/2;
                        }
                        cells[x][y].alive = cells[x][y].resurrect;
                    }
                    cells[x][y].kill = false;
                    cells[x][y].resurrect = false;
                }
            }
            for (int x = 0; x < cells.length; x++) {
                for (int y = 0; y < cells[0].length; y++) {
                    int adj = aliveAdjacent(x, y);
                    if (adj == 3) {
                        cells[x][y].resurrect = true;
                    } else if (adj < 2 || adj > 3) {
                        cells[x][y].kill = true;
                    }
                }
            }
        }
    }

    public int aliveAdjacent(int x, int y) {
        x--;
        y--;
        int alive = 0;
        for (int i = 0; i < 3; i++) {
            if (x + i < cells.length && x + i >= 0) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) continue;
                    if (y + j < cells[0].length && y + j >= 0) {
                        if (cells[x + i][y + j].alive) {
                            alive++;
                        }
                    }
                }
            }
        }
        return alive;
    }

    int size = 10;

    public void click(int x, int y, int button) {
        if (button == MouseEvent.BUTTON1 || button == MouseEvent.BUTTON3) {
            int px = (int) ((double) x / Main.WIDTH * cells.length);
            int py = (int) ((double) y / Main.HEIGHT * cells[0].length);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int ppx = px - size / 2 + i;
                    int ppy = py - size / 2 + j;
                    if(ppx >= 0 && ppx < cells.length
                    && ppy >= 0 && ppy < cells[0].length) {
                        cells[ppx][ppy].alive = button == MouseEvent.BUTTON1;
                        cells[ppx][ppy].resurrect = false;
                        cells[ppx][ppy].kill = false;
                    }
                }
            }
        } else {
            System.out.println("Mouse button " + button + " clicked!");
        }
    }
}
