package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileThread extends Thread{
	
	final private static int RECORD_LENGTH = 71;
	MTQueue  _queue;
	RandomAccessFile _store;
	String recLocation;
	int intRecLocation;
	String fullRecord = "";
	
	public FileThread(MTQueue queue)
	{
		_queue = queue;
	}
	
	public void run(){
	
		//making file location
		
		File loc = new File("lab3.txt");
		try{
			_store = new RandomAccessFile(loc, "rw");		
		}
		catch (FileNotFoundException e){
			System.out.println("No file found");
		}
		for(int x=0; x<142; x++){
			try {
				_store.seek(0);
				_store.writeUTF("          ");
			} 
			catch (IOException e) {
			}
		}
		
		//get fullRecord string
		while(true){
			fullRecord = _queue.MTGet();
			if(fullRecord != null){
			
				try{
					recLocation = fullRecord.substring(0, 2);
					intRecLocation = Integer.parseInt(recLocation);
				}
				catch(NumberFormatException e){
					try{
						recLocation = fullRecord.substring(0, 1);
						intRecLocation = Integer.parseInt(recLocation);
					}
					catch(NumberFormatException f){
						System.out.println("Ruh roh!");
					}
				}
				
				try {
					_store.seek((RECORD_LENGTH + 2) * (intRecLocation-1));
					_store.writeUTF(fullRecord);
					_store.seek((RECORD_LENGTH + 2) * (intRecLocation-1));
					String fullRecord2 = _store.readUTF();
					
					String idNum = fullRecord2.substring(0, 5);
					String pName = fullRecord2.substring(5, 31);
					String tName = fullRecord2.substring(31, 57);
					String skill = fullRecord2.substring(57, 62);
					String date = fullRecord2.substring(62, 71);
					System.out.println("ID: "+idNum+" NAME: "+pName+" TEAM: "+tName+" SKILL: "+skill+" DATE: "+date);
					
				} catch (IOException e) {	
					System.out.println("IO Exception");
				}
				fullRecord = null;
			}

		}
		
	}
}
