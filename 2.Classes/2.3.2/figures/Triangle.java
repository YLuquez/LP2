package figures;

import java.awt.*;

public class Triangle {
    private int[] xP;
    private int[] yP;
    private int p;
    private Color borderColor;
    private Color fillColor;

    public Triangle (int[] xP, int[] yP, int p, Color borderColor, Color fillColor) {
        this.xP = xP;
        this.yP = yP;
        this.p = p;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public void print () {
        System.out.format("Triangulo de pontos x: (%d,%d,%d) y: (%d,%d,%d) na posicao (%d,%d).\n",
           this.xP[0],  this.xP[1], this.xP[2], this.yP[0], this.yP[1], this.yP[2]);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(this.xP, this.yP, this.p);

        g2d.setColor(borderColor); 
        
        int x[] = {this.xP[0], this.xP[1], this.xP[2]};
        int y[] = {this.yP[0], this.yP[1], this.yP[2]};

        Polygon TriangleInterior = new Polygon(x, y, 3);

        g2d.setColor(fillColor);
        g2d.fillPolygon(TriangleInterior);
    }
}