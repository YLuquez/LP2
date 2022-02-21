import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectApp {
	public static void main (String[] args) {
		Rect r1 = new Rect(1,1, 5,5);
		r1.print();
		r1.drag(6,4);
		r1.printdrag();
    }
}
class Rect {
   	int x, y;
   	int w, h;
	Rect (int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	int Area (){
		int area;
		area = this.w*this.h;
		return area;
	}

	void drag(int dx,int dy){
		this.x = this.x + dx;
		this.y = this.y + dy;
		
	}

	void print () {
		System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
		this.w, this.h, this.x, this.y);
		System.out.format("Area do retangulo: %d\n",Area());
	}
	void printdrag (){
		System.out.format("Nova posicao: (%d,%d)\n",this.x,this.y);
	}

}
