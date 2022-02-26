package figures;

import java.awt.*;

public class Triangle {
    private int[] xP;
    private int[] yP;
    private int p;

    public Triangle (int[] xP, int[] yP, int p) {
        this.xP = xP;
        this.yP = yP;
        this.p = p;
    }

    public void print () {
        System.out.format("Triangulo de pontos x: (%d,%d,%d) y: (%d,%d,%d) na posicao (%d,%d).\n",
           this.xP[0],  this.xP[1], this.xP[2], this.yP[0], this.yP[1], this.yP[2]);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(this.xP, this.yP, this.p);
    }
}