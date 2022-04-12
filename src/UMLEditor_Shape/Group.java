package UMLEditor_Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;




public class Group extends Base{
	private ArrayList<Base> groupmember=new ArrayList<Base>();
	private Rectangle bound=new Rectangle();
	public Group(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
		// TODO Auto-generated constructor stub
	}
	public void add(Base object) {
		groupmember.add(object);
	}
	public Base remove(int i) {
		Base temp=groupmember.get(i);
		groupmember.remove(i);
		return temp;
	}
	public void setbounds() {
		int i;
		int leftx1=Integer.MAX_VALUE;
		int upy1=Integer.MAX_VALUE;
		int rightx2=Integer.MIN_VALUE;
		int downy2=Integer.MIN_VALUE;
		for(i=0;i<groupmember.size();i++) {
			Base b=groupmember.get(i);
			if(b.getx1()<leftx1) leftx1=b.getx1();
			if(b.getx2()> rightx2) rightx2=b.getx2();
			if(b.gety1()<upy1) upy1=b.gety1();
			if(b.gety2()> downy2) downy2=b.gety2();
		}
		bound.setBounds(leftx1, upy1, Math.abs(leftx1-rightx2), Math.abs(upy1-downy2));
		this.x1=bound.x;
		this.y1=bound.y;
		this.x2 = bound.x + bound.width;
		this.y2 = bound.y + bound.height;
	}
	public int get_group_size() {
		return groupmember.size();
	}

	public void move(int movex,int movey) {
		int i;
		for(i=0;i<groupmember.size();i++) {
			Base member=groupmember.get(i);
			member.move(movex, movey);
		}
		this.x1=this.x1+movex;
		this.y1=this.y1+movey;
		this.x2=this.x1+bound.width;
		this.y2=this.y1+bound.height;
		bound.setBounds(this.x1,this.y1,bound.width,bound.height);

	}
	public void show(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(x1, y1, bound.width, bound.height);
	}
	public void draw(Graphics g) {
		int i;
		for(i=0;i<groupmember.size();i++) {
			Base member=groupmember.get(i);
			member.draw(g);
		}
		show(g);
		
	}
	
}
