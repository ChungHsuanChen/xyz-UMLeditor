package UMLEditor_Shape;

import java.awt.Graphics;

public class UsecaseObject extends BasicObject{
	public UsecaseObject(int x1,int y1) {
		super(x1,y1,x1+100,y1+80);
	}
public void draw(Graphics g) {
		
		g.drawOval(x1, y1, 100, 80);
		g.drawString(this.name, x1+15, y1+30);
		int i;
		
	}
}
