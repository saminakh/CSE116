package lab3;

import java.io.*;

import javax.swing.JOptionPane;

public class Main {
	
	//20 records total
	final private static int MAX_RECORD_NUMBER =20;
	//size of each record (string characters)
	final private static int RECORD_LENGTH = 71;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException{
		
		//add queue
		MTQueue queue = new MTQueue();
		//add file thread
		FileThread thread1 = new FileThread(queue);
		boolean threadPaused = true;
		
		String buffer = " ";
		boolean badInput = true;
		boolean badInput2 = true;
		String idNum = "";
		String skill = "";
		int skillInt = 0;
				
		//prompt user for a command
		String cmd = "start";
		int recLocation = 0;
		while(cmd.compareToIgnoreCase("end")!=0){ //stay in program (loop) until end command is given
			cmd = JOptionPane.showInputDialog(null, "Please input a command (new or end): ");
			if(cmd.compareToIgnoreCase("end")==0){
				
				thread1.stop();
			}
			
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
				
				
				//put record string into queue
				queue.MTPut(fullRecord);	
				if(threadPaused){
					thread1.start();
					threadPaused = false;
				}
				
				//reset booleans
				badInput = true;
				badInput2 = true;				
			}
		}
	
	}
}

