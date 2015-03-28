package lab7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class VMemTest {

	private final static int _arraySize = 1000;
	private final static int _virtRatio = 100;


	public static void main(String[] args) throws FileNotFoundException, IOException{

		//make array
		VMem array = new VMem(_arraySize, _arraySize/_virtRatio);

		Random random = new Random();

		int index;
		long value;
		long gotten = 0;
		long startTime = System.nanoTime();

		for(int i = 0; i < _arraySize*_arraySize; i++){

			//pick random index and value to put in
			index = random.nextInt(_arraySize);
			value = random.nextLong();

			try{

				array.put(index, value);
				gotten = array.get(index);
			}
			catch(IndexOutOfBoundsException e){

				long upper = _arraySize - 1;
				System.out.println("The value " + index + " is outside 0.." + upper);
			}


			//check for error
			if(gotten != value){
				System.out.println("error at " +i);
				return;
			}
		}  

		long endTime = System.nanoTime();
		System.out.println("Elapsed time (ms) is "+ (endTime - startTime)/1000000);
		System.out.println("Test 1 complete");

		for(int i = 0; i < _arraySize; i++){
			array.put(i, 1000-i);
		}
		array.finalizeData();

		//check for errors in sorting
		int countErrors = 0;
		for(int j = 0; j < _arraySize-1; j = j+1){
			if(array.get(j) < array.get(j+1)){
				System.out.println("Out of order at index: "+j+", value: "+array.get(j));
				countErrors++;
			}
		}
		if(countErrors <=0){
			System.out.println("Test 2 complete");
		}
		else{
			System.out.println(countErrors+" values out of order");
		}
	}

}
