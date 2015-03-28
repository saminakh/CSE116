package lab9b;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Property {

	private int _id;
	private String _address;
	private int _numberStories;
	private int _age;
	private JFrame _frame;
	private JTextField addField;
	private JTextField numField;
	private JTextField ageField;

	public Property(int id){
		
		_id = id;
	}

	public void Initialize(){
		//create frame, panel, set layout
		JFrame frame = new JFrame("New Property");
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(0, 1);
		panel.setLayout(layout);
		frame.add(panel);
		_frame = frame;

		//create buttons and labels
		JLabel idLabel = new JLabel("ID: "+_id);
		addField = new JTextField("Address");
		numField = new JTextField("Stories");
		ageField = new JTextField("Age");
		JButton submitButton = new JButton("Submit");
		panel.add(idLabel);
		panel.add(addField);
		panel.add(numField);
		panel.add(ageField);	
		panel.add(submitButton);

		submitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try{
					_address = addField.getText();
					_numberStories = Integer.parseInt(numField.getText());
					_age = Integer.parseInt(ageField.getText());
					if(_numberStories < 0 || _age < 0){
						throw new IndexOutOfBoundsException();
					}
					_frame.setVisible(false);
		
				}
				catch(NumberFormatException E){
					JOptionPane.showMessageDialog(null, "Please enter valid inputs");
				}
				catch(IndexOutOfBoundsException F){
					JOptionPane.showMessageDialog(null, "Please enter valid inputs");
				}
				
			}

		});

		//pack frame, make visible
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public void Display(){
		
		//create frame, panel, set layout
		JFrame frame = new JFrame("Property Info");
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(0, 1);
		panel.setLayout(layout);
		frame.add(panel);
		JLabel info = new JLabel("ID: "+_id);
		JLabel address = new JLabel(_address);
		JLabel stories = new JLabel("The total stories are "+_numberStories+".");
		JLabel age = new JLabel("The age of the property is "+_age+" years.");
		
		panel.add(info);
		panel.add(address);
		panel.add(stories);
		panel.add(age);
		
		frame.pack();
		frame.setVisible(true);

	}

	public int getID(){
		return _id;
	}
}
