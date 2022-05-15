import javax.swing.*;
import java.awt.event.*;

public class Input implements MouseMotionListener, MouseListener, KeyListener {

    private Grid grid;

    public Input(Grid grid) {
        this.grid = grid;
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        grid.click(e.getX(), e.getY(), SwingUtilities.isLeftMouseButton(e)?
                MouseEvent.BUTTON1 : SwingUtilities.isRightMouseButton(e)? MouseEvent.BUTTON3 : MouseEvent.NOBUTTON);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        grid.click(e.getX(), e.getY(), e.getButton());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        char c = e.getKeyChar();
        if (c == ' ')
            Grid.PAUSED = !Grid.PAUSED;
        else if(c <= '9' && c > '0')
            grid.size = c - '0';
        else if(c == '0')
            grid.size = 10;
        else if(c == '+')
            grid.size++;
        else if(c == '-' && grid.size > 1)
            grid.size--;
        else if(c == 'x')
            Grid.SHOWDEAD = !Grid.SHOWDEAD;
    }
}
