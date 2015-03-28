package lab10;

import java.awt.event.ActionEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main extends JApplet {
	
	public Main(){
		
		//create the applet
		add(new ElusiveBall());
		
	}
	
	 public static void main(String[] args){
		 //timer
		 Timer timer = new Timer(10, new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 
			 }
		 });
		
		 //make into application, turn into a pretty frame
		JFrame frame = new JFrame("Cool game");
		
		Main applet = new Main();
		frame.add(applet);
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} 
}
