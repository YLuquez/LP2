import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class EllipseApp {
    public static void main (String[] args) {
        EllipseFrame frame = new EllipseFrame();
    }
}

class EllipseFrame extends JFrame {
    public EllipseFrame () {
        this.addWindowListener (
                new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        this.setTitle("Java2D - Paint");
        this.setSize(350, 350);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(48, 52, 63));
        g2d.draw(new Ellipse2D.Double(20, 50, 250, 130));
        g2d.setColor(new Color(49, 59, 114));
        g2d.fillOval(20,50,250, 130);

        g2d.setColor(new Color(98, 168, 124));
        g2d.draw(new Ellipse2D.Double(20, 150, 150, 130));
        g2d.setColor(new Color(98, 124, 168));
        g2d.fillOval(20, 150, 150, 130);

        g2d.setColor(new Color(0, 255, 0));
        g2d.draw(new Ellipse2D.Double(20, 250, 40, 90));
        g2d.setColor(new Color(90, 40, 90));
        g2d.fillOval(20, 250, 40, 90);

    }
}
