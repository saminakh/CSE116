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

public class CommercialProperty extends Property{

	private int _mode;
	private boolean _food = false;
	private boolean _resAlso = false;
	private boolean _parking = false;
	private JFrame _frame;
	private int _id;
	private JTextField modeField;


	public CommercialProperty(int id) {
		super(id);
		_id = super.getID();

		this.Initialize();
	}

	public void Initialize(){
		
		super.Initialize();
		
		//create frame, panel, set layout
		JFrame frame = new JFrame("New Commercial");
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(0, 1);
		frame.setLayout(layout);
		panel.setLayout(layout);
		frame.add(panel);

		//create buttons and labels
		JLabel title = new JLabel("ID: "+_id);
		panel.add(title);
		JPanel foodPanel = new JPanel();
		JPanel foodTitle = new JPanel();
		JLabel food = new JLabel("Serves food");
		JButton yesFood = new JButton("Yes");
		JButton noFood = new JButton("No");
		
		frame.add(foodTitle);
		foodTitle.add(food);
		foodPanel.add(yesFood);
		foodPanel.add(noFood);
		frame.add(foodPanel);
		
		JPanel resPanel = new JPanel();
		JPanel resTitle = new JPanel();
		JLabel res = new JLabel("Residence combined");
		JButton yesRes = new JButton("Yes");
		JButton noRes = new JButton("No");
		
		frame.add(resTitle);
		resTitle.add(res);
		resPanel.add(yesRes);
		resPanel.add(noRes);
		frame.add(resPanel);
		
		JPanel parkPanel = new JPanel();
		JPanel parkTitle = new JPanel();
		JLabel park = new JLabel("Parking available");
		JButton yesPark = new JButton("Yes");
		JButton noPark = new JButton("No");
		
		frame.add(parkTitle);
		parkTitle.add(park);
		parkPanel.add(yesPark);
		parkPanel.add(noPark);
		frame.add(parkPanel);
		
		JPanel finalPanel = new JPanel();
		finalPanel.setLayout(layout);
		modeField = new JTextField("Retail or office? (1 = retail, 0 = office)");
		JButton submitButton = new JButton("Submit");
		finalPanel.add(modeField);
		finalPanel.add(submitButton);
		frame.add(finalPanel);

		//pack frame, make visible
		_frame = frame;
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
		//food buttons
		noFood.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				_food = false;
			}
		});	
		yesFood.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				_food = true;
			}
		});

		//residential buttons
		noRes.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				_resAlso = false;
			}
		});	
		yesRes.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				_resAlso = true;
			}
		});
		
		//parking buttons
		noPark.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				_parking = false;
			}
		});	
		yesPark.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				_parking = true;
			}
		});

		submitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
				try{
					_mode = Integer.parseInt(modeField.getText());
					if(_mode != 1 && _mode !=0){
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
		JFrame frame = new JFrame("Commercial Info");
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(0, 1);
		panel.setLayout(layout);
		frame.add(panel);
		JLabel info = new JLabel("ID: "+_id);
		JLabel mode = new JLabel("Office or retail (0=office, 1=retail): "+_mode);
		JLabel food = new JLabel("Food service:  "+_food);
		JLabel resAlso = new JLabel("Also a residence: "+_resAlso);
		JLabel parking = new JLabel("Parking available: "+_parking);
		
		panel.add(info);
		panel.add(mode);
		panel.add(food);
		panel.add(resAlso);
		panel.add(parking);
		
		frame.pack();
		frame.setVisible(true);


	}

}
