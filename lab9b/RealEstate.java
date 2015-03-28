package lab9b;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RealEstate {

	private static Property[] database = new Property[64];
	private static JFrame _tempFrame;

	public static void main(String[] args){

		//create frame, panel, set layout
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		BorderLayout layout = new BorderLayout();
		panel.setLayout(layout);
		frame.add(panel);

		//create buttons and labels
		JLabel title = new JLabel("Real Estate", JLabel.CENTER);
		JButton newButton = new JButton("New");
		JButton oldButton = new JButton("Old");
		JButton endButton = new JButton("End");

		//add buttons and labels to frame, set layout
		panel.add(title, BorderLayout.NORTH);
		panel.add(newButton, BorderLayout.WEST);
		panel.add(oldButton, BorderLayout.EAST);
		panel.add(endButton, BorderLayout.SOUTH);
	

		//new button
		newButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame tempFrame = new JFrame();
				JPanel tempPanel = new JPanel();
				JButton resButton = new JButton("Residential");
				JButton comButton = new JButton("Commercial");

				//add buttons to frame
				tempFrame.add(tempPanel);
				tempPanel.add(resButton);
				tempPanel.add(comButton);

				//pack frame, make visible
				tempFrame.pack();
				tempFrame.setVisible(false);
				_tempFrame = tempFrame;
				_tempFrame.setVisible(true);
				
				//have buttons create new properties
				resButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e){
						_tempFrame.setVisible(false);

						int nextAvail = nextAvailable(database);

						ResidentialProperty resProp = new ResidentialProperty(nextAvail);
						database[nextAvail] = resProp;
					}
				});

				comButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e){
						_tempFrame.setVisible(false);

						int nextAvail = nextAvailable(database);

						CommercialProperty comProp = new CommercialProperty(nextAvail);
						database[nextAvail] = comProp;
					}
				});	

			}			
		});

		//old button
		oldButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame tempFrame = new JFrame("Old");
				JPanel tempPanel = new JPanel();
				tempPanel.setLayout(new GridLayout(0, 1));
				final JTextField tempField = new JTextField("Enter ID");
				JButton tempButton = new JButton("Submit");
				tempButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e){
						try{
							int oldId = Integer.parseInt(tempField.getText());
							try{
								if(oldId < 0){
									throw new ArrayIndexOutOfBoundsException();
								}
								else{
									try{
										find(oldId).Display();
									}
									catch(NullPointerException E){
										JOptionPane.showMessageDialog(null, "No entry with that ID");
									}

								}
							}
							catch(ArrayIndexOutOfBoundsException F){
								JOptionPane.showMessageDialog(null, "Please enter a valid input");
							}
						}
						catch(NumberFormatException E){
							JOptionPane.showMessageDialog(null, "Please input a valid number");
						}

					}
				});


				tempFrame.add(tempPanel);
				tempPanel.add(tempField);
				tempPanel.add(tempButton);
				tempFrame.pack();
				tempFrame.setVisible(true);

			}			
		});

		//end button
		endButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}			
		});

		//pack frame, make visible
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


	}

	private static Property find(int ID){
		return database[ID];
	}

	private static int nextAvailable(Property[] propDatabase){

		for(int i = 0; i < 64; i++){
			if(propDatabase[i] == null){
				return i;
			}
		}
		return 0;
	}

}
