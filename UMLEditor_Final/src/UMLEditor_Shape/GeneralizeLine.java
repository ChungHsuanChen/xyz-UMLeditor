package UMLEditor_Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class GeneralizeLine extends Line{

	public GeneralizeLine(Port p1,Port p2) {
		super(p1, p2);
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g) {
		reset_line();
		Graphics2D g2 = (Graphics2D)g; 
		 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		            RenderingHints.VALUE_ANTIALIAS_ON);// to smooth out the jaggies
		g2.drawLine(x1, y1, x2, y2);
		
		 double phi=Math.toRadians(40);
		 int barb=20;
		double dy=y2-y1;
		double dx=x2-x1;
		 double theta = Math.atan2(dy, dx);
		double xx,yy,rho=theta+phi;
		double[][] tri=new double[2][2];
	
		 for(int j = 0; j < 2; j++)
	     {
	         xx = x2- barb * Math.cos(rho);
	         yy = y2 - barb * Math.sin(rho);
	         g2.drawLine(x2, y2, (int)xx, (int)yy);
	        tri[j][0]=xx;
	        tri[j][1]=yy;
	         rho = theta - phi;
	     }

	
		 g2.drawLine((int)tri[0][0], (int)tri[0][1], (int)tri[1][0], (int)tri[1][1]);
		 g2.setColor(g2.getBackground());
		 g2.fillPolygon(new int[] {x2,(int)tri[0][0],(int)tri[1][0]},new int[] {y2,(int)tri[0][1],(int)tri[1][1]},3);
		 g2.setColor(Color.black);
	}
}
