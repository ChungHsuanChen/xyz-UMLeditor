package UMLEditor_Final;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.*;

import UMLEditor_Shape.Base;
import UMLEditor_Shape.BasicObject;
import UMLEditor_Shape.Group;
import UMLEditor_mode.Mode;
public class MyPanel extends JPanel{
	private static MyPanel instance=null;
	private EventListener listener = null;
	private Button button[]=new Button[6];
	private Menu Editbar;
	private Base selected;
	private ArrayList<Base> objects=new ArrayList<Base>();
	private Mode currentmode;
	private MyPanel() {}

	public static MyPanel getinstance() {
		if(instance==null) {
			instance=new MyPanel();
		}
	    return instance;
	}
	public void createButton() {
		button[0]=new selectButton();
		button[1]=new associationButton();
		button[2]=new GeneralizeButton();
		button[3]=new CompositeButton();
		button[4]=new ClassButton();	
		button[5]=new UsecaseButton();
		Editbar=new Menu();
		int i;
		for(i=0;i<6;i++) add(button[i]);
		add(Editbar);
	}
	public void resetButtoncolor(int index) {
		int i;
		for(i=0;i<6;i++) {
			if(i!=index) button[i].setBackground(null);
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int i;
		for(i=objects.size()-1;i>=0;i--) {
			Base cur=objects.get(i);
			cur.draw(g);
			if(cur.select_or_not()) cur.drawboundary(g);
		}
	}
	public void setMode(Mode mode) {
		removeMouseListener((MouseListener)listener);
		removeMouseMotionListener((MouseMotionListener)listener);
		listener=mode;
		addMouseListener((MouseListener)listener);
		addMouseMotionListener((MouseMotionListener)listener);
	}
	public void set_selected(Base object) {
		selected=object;
	}
	public void add(Base object) {
		objects.add(object);
		
	}

	public int get_size() {
		return objects.size();
	}
	public void group() {
		Group group=new Group(0,0,0,0);
		int i;
		for(i=objects.size()-1;i>=0;i--) {
			Base cur=objects.get(i);
			if(cur.select_or_not()) {
				group.add(cur);
				objects.remove(cur);
			}
		}
		group.setbounds();
		objects.add(group);
		group.show(getGraphics());
	}
	public void ungroup() {
		if(selected==null ) return;
		int i;
		for(i=0;i<selected.get_group_size();i++) {
			Base temp=selected.remove(i);
			temp.unselect();
			objects.add(temp);
			i--;
		}
		objects.remove(selected);
		repaint();
	}
	public void changename(String input) {
		selected.changename(input);
		repaint();
	}
	public Base getmember(int i) {return objects.get(i);}
	
}
