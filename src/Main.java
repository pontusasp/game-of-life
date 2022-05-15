import com.pontusasp.game.core.Panel;
import com.pontusasp.game.core.Updater;
import com.pontusasp.game.core.Window;

/**
 * Created by Pontus on 2018-04-29.
 */
public class Main {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    public Main() {
        Updater updater = new Updater();
        Panel panel = new Panel(WIDTH, HEIGHT);
        Window window = new Window("Game of Life", panel);
        Grid grid = new Grid();
        Input input = new Input(grid);
        panel.addMouseMotionListener(input);
        panel.addMouseListener(input);
        window.addKeyListener(input);

        panel.addDrawable(grid);
        updater.addToQueue(grid);

        updater.start();
    }

    public static void main(String[] args) {
        new Main();
    }

}
