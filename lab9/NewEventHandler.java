package lab9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewEventHandler implements ActionListener{
	
	private JPanel _panel;
	private JFrame _frame;
	
	public NewEventHandler(JPanel panel, JFrame frame) {
		
		_panel = panel;
		_frame = frame;
	}

	
	public void actionPerformed(ActionEvent e){
		
		GridLayout inputLayout = new GridLayout(0, 1);
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(inputLayout);
		_frame.add(inputPanel, BorderLayout.SOUTH);

		
		JButton res = new JButton("Residential");
		res.addActionListener(new ResEventHandler(inputPanel, _frame));
		JButton comm = new JButton("Commercial");
		

		
		_panel.add(res);
		_panel.add(comm);
		
		_frame.pack();
		
		
	}
	

}
