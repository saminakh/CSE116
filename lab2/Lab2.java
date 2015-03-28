package lab2;


import java.io.*;

import javax.swing.JOptionPane;

public class Lab2 {
	
	//20 records total
	final private static int MAX_RECORD_NUMBER =20;
	//size of each record (string characters)
	final private static int RECORD_LENGTH = 71;
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		String buffer = " ";
		boolean badInput = true;
		boolean badInput2 = true;
		String idNum = "";
		String skill = "";
		int skillInt = 0;
		
		//prompt user for file location
		File loc = new File(JOptionPane.showInputDialog(null, "Please provide the file location: "));
		RandomAccessFile store = new RandomAccessFile(loc, "rw");
		
		//prompt user for a command
		String cmd = "start";
		int recLocation = 0;
		while(cmd.compareToIgnoreCase("end")!=0){ //stay in program (loop) until end command is given
			cmd = JOptionPane.showInputDialog(null, "Please input a command (new, old or end): ");
			
			//creating new entry
			if(cmd.compareToIgnoreCase("new")==0){
				while(badInput){ //keep them in loop until they give the input in the right format
					idNum = JOptionPane.showInputDialog(null, "Please input an ID number (1 through 20): ");
					try{
						//corresponding int for ID number, which becomes the record location
						recLocation = Integer.parseInt(idNum);
						if(recLocation<1 || recLocation>20){
							System.out.println("Please check that your number is between 1 and 20.");
						}else{
							badInput = false;
							break;	
						}
						
					}
					catch(NumberFormatException NF){
						System.out.println("Please check that your number is in the correct format.");
					}
				}
				
				//ask for names
				String pName = JOptionPane.showInputDialog(null, "Please input a player name: ");
				String tName = JOptionPane.showInputDialog(null, "Please input a team name: ");
				
				//ask for skill level
				while(badInput2){ //keep them in the loop until they give the input in the right format
					skill = JOptionPane.showInputDialog(null, "Please input a skill level (0 through 99): ");
					try{
						//corresponding int for skill number, to check if in the right format
						skillInt = Integer.parseInt(skill);
						if(skillInt<0 || skillInt>99){
							System.out.println("Please check that your number is between 0 and 99.");
						}else{
							badInput2 = false;
							break;	
						}
						
					}
					catch(NumberFormatException NF){
						System.out.println("Please check that your number is in the correct format.");
					}
				}
				
				String date = JOptionPane.showInputDialog(null, "Please input today's date (ex: 25Jun2014): ");
				
				//formatting id number
				if (idNum.length() < 2){
					idNum = idNum+buffer;
				}
				//formatting player name
				if (pName.length() > 26){
					pName = pName.substring(0, 26);
				} else {
					while(pName.length() < 26){
						pName = pName+buffer;
					}
				}
				
				//formatting team name
				if (tName.length() > 26){
					tName = tName.substring(0, 26);
				} else {
					while(tName.length() < 26){
						tName = tName+buffer;
					}
				}
				//formatting date
				if (date.length() > 9){
					date = date.substring(0, 9);
				} else {
					while(date.length() < 9){
						date = date+buffer;
					}
				}
				//formatting skill
				if (skill.length() < 2){
					skill = skill+buffer;
				}
				//create full, identifying string
				String fullRecord = idNum + "   " + pName + tName + skill + "   " + date;
				store.seek((RECORD_LENGTH+2) * (recLocation-1));
				store.writeUTF(fullRecord);
				
				//reset booleans
				badInput = true;
				badInput2 = true;
				
			}
			
			//accessing old entry
			if(cmd.compareToIgnoreCase("old")==0){
				idNum = JOptionPane.showInputDialog(null, "Please input an ID number (1 through 20): ");		
				recLocation = Integer.parseInt(idNum);
				store.seek((RECORD_LENGTH+2)*(recLocation-1));
				String fullRecord = store.readUTF();
				
				//interpret information from full string
				try
				{idNum = fullRecord.substring(0, 5);
				String pName = fullRecord.substring(5, 31);
				String tName = fullRecord.substring(31, 57);
				skill = fullRecord.substring(57, 62);
				String date = fullRecord.substring(62, 71);
				System.out.println("ID: "+idNum+" NAME: "+pName+" TEAM: "+tName+" SKILL: "+skill+" DATE: "+date);
				}
				catch(StringIndexOutOfBoundsException S){
					System.out.println("No record found at that location.");
				}
			}
		}
		
	}

}
