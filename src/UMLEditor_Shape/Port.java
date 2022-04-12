package UMLEditor_Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Port {
	private int x1;
	private int y1;

	public Port(int x1,int y1) {
		this.x1=x1;
		this.y1=y1;
	}
	public Point get_port() {
		return new Point(x1,y1);
	}
	
	public void reset(int x1,int y1) {
		this.x1=x1;
		this.y1=y1;
	}

	public void draw(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(x1-5, y1-5, 10, 10);
		
	}
}
