package lab9b;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResidentialProperty extends Property {

	private boolean _multiple = false;
	private boolean _water = false;
	private int _porch;
	private int _yard;
	private JFrame _frame;
	private int _id;
	private JTextField porchField;
	private JTextField yardField;

	public ResidentialProperty(int id) {

		super(id);
		_id = super.getID();

		this.Initialize();

	}

	public void Initialize(){
		
		super.Initialize();
		//create frame, panel, set layout
		JFrame frame = new JFrame("New Residential");
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(0, 1);
		frame.setLayout(layout);
		panel.setLayout(layout);
		frame.add(panel);

		//create buttons and labels
		JLabel title = new JLabel("ID: "+_id);

		JPanel multiplePanel = new JPanel();
		JLabel multiple = new JLabel("Multiple dwelling");
		JButton yesMult = new JButton("Yes");
		JButton noMult = new JButton("No");

		panel.add(title);
		panel.add(multiple);
		frame.add(multiplePanel);
		multiplePanel.add(yesMult);
		multiplePanel.add(noMult);

		JPanel waterPanel = new JPanel();
		JLabel water = new JLabel("External water");
		JButton yesWat = new JButton("Yes");
		JButton noWat = new JButton("No");
		JPanel titleWater = new JPanel();

		titleWater.add(water);
		frame.add(titleWater);
		frame.add(waterPanel);
		waterPanel.add(yesWat);
		waterPanel.add(noWat);

		JPanel finalPanel = new JPanel();
		finalPanel.setLayout(layout);
		porchField = new JTextField("Porch size in sqft");
		yardField = new JTextField("Yard size in sqft");
		JButton submitButton = new JButton("Submit");

		finalPanel.add(porchField);
		finalPanel.add(yardField);
		finalPanel.add(submitButton);
		frame.add(finalPanel);

		//pack frame, make visible
		_frame = frame;
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


		//multiple dwelling buttons
		noMult.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				_multiple = false;
			}
		});	
		yesMult.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				_multiple = true;
			}
		});

		//external water buttons
		noWat.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				_water = false;
			}
		});
		yesWat.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				_water = true;
			}
		});

		submitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try{
					_porch = Integer.parseInt(porchField.getText());
					_yard = Integer.parseInt(yardField.getText());
					if(_porch < 0 || _yard < 0){
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
	}

	public void Display(){

		super.Display();

		//create frame, panel, set layout
		JFrame frame = new JFrame("Residential Info");
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(0, 1);
		panel.setLayout(layout);
		frame.add(panel);
		JLabel info = new JLabel("ID: "+_id);
		JLabel mult = new JLabel("Multiple dwelling: "+_multiple);
		JLabel wat = new JLabel("External water:  "+_water);
		JLabel porch = new JLabel("The porch size is "+_porch+" sqft.");
		JLabel yard = new JLabel("The yard size is " +_yard+" sqft.");

		panel.add(info);
		panel.add(mult);
		panel.add(wat);
		panel.add(porch);
		panel.add(yard);

		frame.pack();
		frame.setVisible(true);
	}
}
