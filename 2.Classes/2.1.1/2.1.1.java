import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OvalApp{
	public static void main(String[] args){
	Oval o1 = new Oval(1,1,5,5);
	o1.print();
	}
}


class Oval {
	int x,y,w,h;
	Oval (int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}


	void print() {
		System.out.format("Circulo de tamanho (%d,%d) na posicao (%d,%d).",this.w,this.h,this.x,this.y);
	}
}
