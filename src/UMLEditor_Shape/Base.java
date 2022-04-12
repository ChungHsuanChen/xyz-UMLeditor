package UMLEditor_Shape;

import java.awt.Graphics;
import java.awt.Point;

public class Base {
protected int x1;
protected int x2;
protected int y1;
protected int y2;
protected boolean is_selected;
public Base(int x1,int y1,int x2,int y2) {
	this.x1=x1;
	this.x2=x2;
	this.y1=y1;
	this.y2=y2;
}
public boolean selectmany(Point cur,Point pos) {
	if(this.x1>cur.x&&this.y1>cur.y&&this.x2<pos.x&&this.y2<pos.y&&this.x1<pos.x&&this.y1<pos.y&&cur.x<this.x2&&cur.y<this.y2) return true;
	return false;
}
public void select() {
	this.is_selected=true;
}
public void unselect() {
	this.is_selected=false;
}
public boolean select_or_not() {
	return is_selected==true ? true:false;
}
public boolean check(int x1,int y1) {
	if(x1>=this.x1&&x1<=this.x2&&y1>=this.y1&&y1<=this.y2) {
		return true;
	}
		return false;
}
public int getx1() {return x1;}
public int gety1() {return y1;}
public int getx2() {return x2;}
public int gety2() {return y2;}
public void draw(Graphics g) {
	// TODO Auto-generated method stub
	
}
public void move(int movex,int movey) {
	// TODO Auto-generated method stub
}

public void drawboundary(Graphics g) {
	// TODO Auto-generated method stub
	
}
public Port getport(int temp) {
	// TODO Auto-generated method stub
	return null;
}
public int check_area(int t1, int t2) {
	// TODO Auto-generated method stub
	return 0;
}
public int get_group_size() {
	// TODO Auto-generated method stub
	return 1;
}
public Base remove(int i) {
	// TODO Auto-generated method stub
	return null;
}
public void changename(String input) {
	// TODO Auto-generated method stub
	
}
}
