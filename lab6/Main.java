package lab6;

public class Main {
	
public static void main(String[] args){
	
		QuickSort sorter = new QuickSort();
		
		int n = 1000000;
		
		//make the array
		int[] list = new int[n];
		
		//fill it with random numbers
		for(int i = 0; i < n; i++){
			double temp = Math.random() * 100;
			list[i] = (int) temp;
		}
		
		//sorting, start timer
		long currentTime = System.nanoTime();
	
		//do the sorting
		sorter.quickSort(list);
		
		
		
		long elapsed = System.nanoTime() - currentTime;
		//print out total time
		System.out.println();
		//check sorting
		for(int i = 0; i < n - 1; i ++){
			if(list[i] > list[i+1]){
				System.out.println("Not in order at index: "+i);
				break;
			}
		}
		System.out.println(); 
		System.out.println("Total time elapsed: "+elapsed);
		
	}

}
