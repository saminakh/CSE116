package lab9;

import java.awt.*;

import javax.swing.*;

public class RealEstate {
	
	private static Property[] database = new Property[64];
	
	public static void main(String[] args){
		
		//make frame and layouts
		JFrame frame = new JFrame("Real Estate");
		BorderLayout layout = new BorderLayout();
		GridLayout layout1 = new GridLayout(0, 1);
		GridLayout layout2 = new GridLayout(0, 1);
		FlowLayout titleLayout = new FlowLayout();
		
		//make frame with layout, make visible
		frame.setLayout(layout);
		frame.setVisible(true);
		
		//make components, set layouts
		JPanel panel = new JPanel();
		panel.setLayout(layout1);
		JPanel panel2 = new JPanel();
		panel2.setLayout(layout2);
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(titleLayout);
		
		
		JButton newButton = new JButton("New");
		JButton oldButton = new JButton("Old");
		JButton endButton = new JButton("Go fuck yerself");
		JLabel titleLabel = new JLabel("Real Estate Manager");
		
		//make stuff happen with buttons!
		endButton.addActionListener(new EndEventHandler());
		newButton.addActionListener(new NewEventHandler(panel2, frame));
		
		//add components
		frame.add(titlePanel, BorderLayout.NORTH);
		titlePanel.add(titleLabel);
		frame.add(panel, BorderLayout.WEST);
		frame.add(panel2, BorderLayout.EAST);
		panel.add(newButton);
		panel.add(oldButton);
		panel.add(endButton);
		
		//pack frame
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}
	
	private static Property find(int id){
		
		Property poop = new Property(id);
		return poop;
	}
}
