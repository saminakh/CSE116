package lab6;

public class InsertionSort {
	
	public static void insertionSort(int[] list){
		
		int temp;
		
		for(int i = 1; i < list.length; i++){	
			//compare value at index j to index i
			for(int j = i; j > 0; j--){
				//switch values if the R one is larger than the L
				if(list[j] < list[j-1]){
					temp = list[j];
					list[j] = list[j-1];
					list[j-1] = temp;
				}
			}
		}
	}

	public static void main(String[] args){
		
		int n = 100000;
		
		//make the array
		int[] list = new int[n];
		
		//fill it with random numbers
		for(int i = 0; i < n; i++){
			double temp = Math.random() * 100;
			list[i] = (int) temp;
			// System.out.print(list[i]+" ");
		}
		
		//sorting, start timer
		long currentTime = System.nanoTime();
	
		//do the sorting
		insertionSort(list);
				
		
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
