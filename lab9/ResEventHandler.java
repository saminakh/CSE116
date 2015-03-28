package lab9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResEventHandler implements ActionListener{
	
	private JPanel _panel;
	private JFrame _frame;
	
	public ResEventHandler(JPanel panel, JFrame frame){
		
		_panel = panel;
		_frame = frame;
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		ResidentialProperty resProp = new ResidentialProperty();
		
		JTextField inputAddress = new JTextField("Address");
		_panel.add(inputAddress);
		
		JTextField inputStories = new JTextField("Number of stories");
		_panel.add(inputStories);
		
		JTextField inputAge = new JTextField("Age in years");
		_panel.add(inputAge);
		
		JTextField inputMultiple = new JTextField("Multiple dwelling (true/false)");
		_panel.add(inputMultiple);
		
		JTextField inputWater = new JTextField("External water (true/false)");
		_panel.add(inputWater);
		
		JTextField inputPorch = new JTextField("Porch size (sqft)");
		_panel.add(inputPorch);
		
		JTextField inputYard = new JTextField("Yard size (sqft)");
		_panel.add(inputYard);
		
		JButton endButton = new JButton("Submit");
		_panel.add(endButton);
		
		
		_frame.pack();
		
	}

}
