import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setPaint(Color.blue);
        int w = getWidth();
        int h = getHeight();
        int squareSize = 350;

        g.setColor(Color.cyan);
        g.fillRect(0, 0, w, h);

        g2d.setPaint(Color.orange);
        g2d.fillRect(188, 70, 10, 140);

        g2d.setPaint(Color.MAGENTA);
        g2d.fillOval(155, 55, 75, 100);

        g2d.setPaint(Color.RED);
        g2d.drawString("Ola mundo", 75, 100);
    }
}
