package UMLEditor_mode;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import UMLEditor_Shape.BasicObject;
import UMLEditor_Shape.ClassObject;
import UMLEditor_Shape.UsecaseObject;

public class CreateobjMode extends Mode{
	private String objecttype;
	private Basefactory Create_Object=new Basefactory();
public CreateobjMode(String type) {
	objecttype=type;
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	BasicObject basicobject = Create_Object.createbasicobject(objecttype,e.getX(),e.getY());;
	mypanel.add(basicobject);
	mypanel.repaint();
}

}
