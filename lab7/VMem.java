package lab7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class VMem {
	
	private long[] list;
	private int currentSection;
	private int sectionSize;
	private RandomAccessFile _store;
	
	public VMem(int arraySize, int ratio) throws FileNotFoundException, IOException{
		
		//create file
		RandomAccessFile store = new RandomAccessFile("VMem.txt", "rw");
		_store = store;
		
		//write dummy values to file
		for(int i = 0; i < arraySize*2; i++){
			store.writeLong(10);
		}
		
		
		sectionSize = arraySize/ratio;
		list = new long[sectionSize];
		currentSection = 0;
		
		_store.seek(0);
		//read first file section into list
		for(int i = 0; i < sectionSize; i++){
			list[i] = _store.readLong();
		}
	}

	public void put(int index, long value) throws IOException {
	
		if(index/sectionSize != currentSection){
			
			//write old array into file
			_store.seek(currentSection*sectionSize*8);
			for(int i=0; i < sectionSize; i++){
				_store.writeLong(list[i]);
			}
			
			//write new section into array
			_store.seek((index/sectionSize) * sectionSize*8);
			for(int i = 0; i < sectionSize; i++){
				list[i] = _store.readLong();
			}
			
			//change section
			currentSection = index/sectionSize;
			
			//update value in array
			list[index%sectionSize] = value; 			
		}
		
		else{
			//update value in array
			list[index%sectionSize] = value;
		}	
	}

	public long get(int index) throws IOException {

		if(index/sectionSize != currentSection){
			
			//write new section into array
			_store.seek((index/sectionSize) * sectionSize*8);
			for(int i = 0; i < sectionSize; i++){
				list[i] = _store.readLong();
			}
			
			//change section
			currentSection = index/sectionSize;
			
			//retrieve value in array
			return list[index%sectionSize];
			
		}
		
		else{
			
			//retrieve value in array
			return list[index%sectionSize];
			
			
		}
	}
	
	public void finalizeData() throws IOException{
		_store.seek(currentSection*sectionSize*8);
		for(int i = 0; i < sectionSize; i++){
			_store.writeLong(list[i]);
		}
	}
}
