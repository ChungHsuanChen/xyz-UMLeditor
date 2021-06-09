package UMLEditor_Final;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UMLEditor_Final.ClassButton.btnlistener;
import UMLEditor_mode.CreateobjMode;
import UMLEditor_mode.SelectMode;

public class selectButton extends Button{
	private final int INDEX_OF_BUTTON=0;
	public selectButton() {
		super("select");
		setBounds(0, 20, 80, 80);
		setBackground(null);	
		addActionListener(new btnlistener());
	}
	class btnlistener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			setBackground(Color.BLACK);
			mypanel.resetButtoncolor(INDEX_OF_BUTTON);
			mypanel.setMode(new SelectMode());
		}
	}
}
