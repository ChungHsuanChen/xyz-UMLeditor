package UMLEditor_mode;

import java.awt.Graphics;
import java.awt.Point;

import UMLEditor_Shape.AssociationLine;
import UMLEditor_Shape.BasicObject;
import UMLEditor_Shape.ClassObject;
import UMLEditor_Shape.CompositionLine;
import UMLEditor_Shape.GeneralizeLine;
import UMLEditor_Shape.Line;
import UMLEditor_Shape.Port;
import UMLEditor_Shape.UsecaseObject;

public class Basefactory {
	public BasicObject createbasicobject(String objecttype,int x1,int y1) {
		if(objecttype=="class") {
			return new ClassObject(x1,y1);

		}
		else if(objecttype=="use case") {
			return new UsecaseObject(x1,y1);
	
		}
		return null;
	}
	public Line createline(Port p1,Port p2,String linetype) {
	
		if(linetype=="association") {
			return new AssociationLine(p1,p2);
			
			
		}
		else if(linetype=="generalize") {
			return new GeneralizeLine(p1,p2);
		
		}
		else if(linetype=="composite") {
			return new CompositionLine(p1,p2);
		
		}
		return null;
	}
}
