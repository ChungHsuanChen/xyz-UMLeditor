package UMLEditor_Final;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UMLEditor_Final.ClassButton.btnlistener;
import UMLEditor_mode.CreateobjMode;

public class UsecaseButton extends Button{
	private final int INDEX_OF_BUTTON=5;
	public UsecaseButton() {
		super("Use Case");
		setBounds(0,420,80,80);
		setBackground(null);
		addActionListener(new btnlistener());
		
	}
	class btnlistener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			mypanel.setMode(new CreateobjMode("use case"));
			setBackground(Color.BLACK);
			mypanel.resetButtoncolor(INDEX_OF_BUTTON);
		}
	}
}
