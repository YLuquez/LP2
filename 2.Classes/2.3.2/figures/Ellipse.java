package figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ellipse {
    private int x, y;
    private int w, h;
    private Color borderColor;
    private Color fillColor;

    public Ellipse(int x, int y, int w, int h, Color borderColor, Color fillColor) {
        this.x = x; // Posição
        this.y = y; // Posição
        this.w = w; // Largura
        this.h = h; // Altura
        this.borderColor = borderColor; // Cor da borda
        this.fillColor = fillColor; // Cor do preenchimento
    }

    public void print () {
        System.out.format("Circulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(borderColor);
        g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));

        g2d.setColor(fillColor);
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
    }
}