package UMLEditor_mode;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import UMLEditor_Shape.Base;
import UMLEditor_Shape.BasicObject;

public class SelectMode extends Mode{
	Point current=new Point();
	Point release=new Point();
	Base drag_item;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int i;
		Graphics g=mypanel.getGraphics();
		for(i=mypanel.get_size()-1;i>=0;i--) {
			Base cur=mypanel.getmember(i);
			if(cur.check(e.getX(), e.getY())) {
				cur.select();
				mypanel.set_selected(cur); 
			}
			else cur.unselect();
		}
		mypanel.repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int i;
		drag_item=null;
		Graphics g=mypanel.getGraphics();
		for(i=mypanel.get_size()-1;i>=0;i--) {
			Base cur=mypanel.getmember(i);
			if(cur.check(e.getX(), e.getY())) {
				drag_item=cur;
				current.x=e.getX();
				current.y=e.getY();
				break;
			}
		}
		if(drag_item==null) {
			
			current.x=e.getX();
			current.y=e.getY();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(drag_item!=null) return ;
		int i;
		release.x=e.getX();
		release.y=e.getY();
		if(current.x==release.x&&current.y==release.y) return;
		if(current.x>release.x) {
			int temp=current.x;
			current.x=release.x;
			release.x=temp;
		}
		if(current.y>release.y) {
			int temp=current.y;
			current.y=release.y;
			release.y=temp;
		}
		for(i=mypanel.get_size()-1;i>=0;i--) {
			Base cur=mypanel.getmember(i);
			if(cur.selectmany(current, release)) {
				cur.select();
			}
			else cur.unselect();
		}
		mypanel.repaint();
		drag_item=null;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(drag_item==null) return;
		Point move=new Point();
		move.x=e.getX()-current.x;
		move.y=e.getY()-current.y;
		drag_item.move(move.x, move.y);
		current.x=e.getX();
		current.y=e.getY();
		mypanel.repaint();
		
	}

}
