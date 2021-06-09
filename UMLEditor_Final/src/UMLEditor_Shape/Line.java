package UMLEditor_Shape;

public class Line extends Base{
	protected Port[] ports = new Port[2];
	public Line(Port p1,Port p2) {
		super(p1.get_port().x, p1.get_port().y, p2.get_port().x, p2.get_port().y);
		this.ports[0]=p1;
		this.ports[1]=p2;
		// TODO Auto-generated constructor stub
	}
	public void reset_line() {
	
		this.x1=ports[0].get_port().x;
		this.y1=ports[0].get_port().y;
		this.x2=ports[1].get_port().x;
		this.y2=ports[1].get_port().y;
	}
	
}
