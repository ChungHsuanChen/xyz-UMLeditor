package UMLEditor_Shape;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class AssociationLine extends Line{

	public AssociationLine(Port p1,Port p2) {
		super(p1,p2);
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g) {
		reset_line();
		Graphics2D g2 = (Graphics2D)g; 
		//g2.setStroke(new BasicStroke(3.0f));
		g2.drawLine(x1, y1, x2, y2);
		
		 double phi=Math.toRadians(40);
		 int barb=20;
		double dy=y2-y1;
		double dx=x2-x1;
		 double theta = Math.atan2(dy, dx);
		double xx,yy,rho=theta+phi;
		 for(int j = 0; j < 2; j++)
	     {
	         xx = x2- barb * Math.cos(rho);
	         yy = y2 - barb * Math.sin(rho);
	         g2.draw(new Line2D.Double(x2, y2, xx, yy));
	         rho = theta - phi;
	     }
	}
}
