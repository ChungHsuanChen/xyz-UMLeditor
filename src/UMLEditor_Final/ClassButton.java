package UMLEditor_Final;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import UMLEditor_mode.CreateobjMode;
public class ClassButton extends Button{
	private final int INDEX_OF_BUTTON=4;
	public ClassButton() { 
		super("Class");
		setBounds(0,340,80,80);
		setBackground(null);
		
		addActionListener(new btnlistener());
	}
	class btnlistener implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mypanel.setMode(new CreateobjMode("class"));
		setBackground(Color.BLACK);
		mypanel.resetButtoncolor(INDEX_OF_BUTTON);
		}
	}
}
