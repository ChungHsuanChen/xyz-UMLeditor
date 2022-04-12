package UMLEditor_Shape;

import java.awt.Graphics;
import java.awt.Point;

public class BasicObject extends Base{
	protected String name;
	protected Port port[]=new Port[4];
	
	private int  width;
	private int height;
	public BasicObject(int x1, int y1,int x2,int y2) {
		super(x1, y1,x2,y2);
		is_selected=false;
		initialboundary();
		width=x2-x1;
		height=y2-y1;
		name="Enter Name";
		// TODO Auto-generated constructor stub
	}
	public void initialboundary() {
		int i;
		port[0]=new Port(x1+(x2-x1)/2,y1);
		port[1]=new Port(x2,y1+(y2-y1)/2);
		port[2]=new Port(x1+(x2-x1)/2,y2);
		port[3]=new Port(x1,y1+(y2-y1)/2);
	
	
	}
	public void resetboundary() {
		int i;
		port[0].reset(x1+(x2-x1)/2, y1);
		port[1].reset(x2, y1+(y2-y1)/2);
		port[2].reset(x1+(x2-x1)/2,y2);
		port[3].reset(x1,y1+(y2-y1)/2);
	}
	public void move(int movex,int movey) {
		this.x1=this.x1+movex;
		this.y1=this.y1+movey;
		this.x2=this.x1+width;
		this.y2=this.y1+height;
		resetboundary();
		int i;

	}
	public void drawboundary(Graphics g) {
	
		int i;
		for(i=0;i<4;i++) {
			port[i].draw(g);
		}
	}
	
	
	public int check_area(int m,int n) {
		if(equation1(m,n)&&equation2(m,n)) return 1;
		else if(equation1(m,n)&&!equation2(m,n)) return 0;
		else if(!equation1(m,n)&&equation2(m,n)) return 2;
		else if (!equation1(m,n)&&!equation2(m,n)) return 3;
		else return -1;
	}
	public boolean equation1(int m,int n) {


		float t=(5*m/4)+n;
		if(t>=0) return true;
		else return false;
	}
	public boolean equation2(int m,int n) {

		float t=(5*m/4)-n-100;
		if(t>=0) return true;
		else return false;
	}

	public Port getport(int i) {
		return port[i];
	}
	public void changename(String input) {
		this.name=input;
	}
}
