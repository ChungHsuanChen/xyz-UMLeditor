package UMLEditor_Final;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UMLEditor_Final.selectButton.btnlistener;
import UMLEditor_mode.CreateLineMode;
import UMLEditor_mode.SelectMode;

public class associationButton extends Button{
	private final int INDEX_OF_BUTTON=1;
	public associationButton() {
		super("Association");
		setBounds(0,100,80,80);
		setBackground(null);	
		addActionListener(new btnlistener());
	}
	class btnlistener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			setBackground(Color.BLACK);
			mypanel.resetButtoncolor(INDEX_OF_BUTTON);
			mypanel.setMode(new CreateLineMode("association"));
	}
	}
}
