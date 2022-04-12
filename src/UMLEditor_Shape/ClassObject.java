package UMLEditor_Shape;

import java.awt.Color;
import java.awt.Graphics;

public class ClassObject extends BasicObject{


	public ClassObject(int x1,int y1) {
	super(x1,y1,x1+80,y1+100);
	}
	public void draw(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.drawRect(x1, y1, 80, 100);
		g.drawLine(x1, y1+33, x1+80, y1+33);
		g.drawLine(x1, y1+66, x1+80, y1+66);
		g.drawString(this.name, x1+5, y1+17);
		int i;
		
	}

}
