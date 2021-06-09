package UMLEditor_mode;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import UMLEditor_Shape.AssociationLine;
import UMLEditor_Shape.Base;
import UMLEditor_Shape.BasicObject;
import UMLEditor_Shape.ClassObject;
import UMLEditor_Shape.CompositionLine;
import UMLEditor_Shape.GeneralizeLine;
import UMLEditor_Shape.Line;
import UMLEditor_Shape.Port;
import UMLEditor_Shape.UsecaseObject;

public class CreateLineMode extends Mode{
	private Basefactory Create_Object=new Basefactory();
	private String Linetype;
	private Port press;
	private Port release;
	private int startportnum;
	private int endportnum;
	private Base start;
	private Base end;
	public CreateLineMode(String type) {
		Linetype=type;
		start=null;
		end=null;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int i;
		Point p;
		Graphics g=mypanel.getGraphics();
		int temp=-1;
		for(i=mypanel.get_size()-1;i>=0;i--) {
			Base cur=mypanel.getmember(i);
			if(cur.check(e.getX(), e.getY())) {
				int t1=e.getX()-cur.getx1();
				int t2=cur.gety1()-e.getY();
				temp=cur.check_area(t1, t2);
				if(temp!=-1) {
					press=cur.getport(temp);
					start=cur;
					startportnum=temp;
					break;
				}
				
			}
		}
	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int i;
		Point p;
		int temp=-1;
		Graphics g=mypanel.getGraphics();
		for(i=mypanel.get_size()-1;i>=0;i--) {
			Base cur=mypanel.getmember(i);
			if(cur.check(e.getX(), e.getY())) {
				int t1=e.getX()-cur.getx1();
				int t2=cur.gety1()-e.getY();
				temp=cur.check_area(t1, t2);
				if(temp!=-1) {
					release=cur.getport(temp);
					end=cur;
					endportnum=temp;
					break;
				}
				
			}
		}
		
		if(temp==-1||press==null||release==null) return;
		Line line=null;
		line=Create_Object.createline(press,release,Linetype);
		
		mypanel.add(line);
		mypanel.repaint();

	}
}
