package UMLEditor_Final;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton {
	protected MyPanel mypanel;
	public Button(String name) {
		mypanel=MyPanel.getinstance();
		
		setText(name);
		setVisible(true);

	}
	
}
