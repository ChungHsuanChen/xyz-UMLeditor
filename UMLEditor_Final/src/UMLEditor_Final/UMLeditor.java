package UMLEditor_Final;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class UMLeditor extends JFrame{
	private MyPanel mypanel;

	public UMLeditor() {
		int i;
		mypanel=MyPanel.getinstance();
		getContentPane().add(mypanel);
		mypanel.createButton();
		mypanel.setLayout(null);

		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		UMLeditor umleditor=new UMLeditor();
		umleditor.setTitle("UML Editor");
		umleditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		umleditor.setSize(1200,700);
		umleditor.setVisible(true);
	
		
	}

}
