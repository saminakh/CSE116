package lab6;

public class BubbleSort {

	public static void main(String[] args){
		
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
		for(int k = n; k > 0; k = k -1){ //change pairs
			for(int i = 0; i < k - 1; i++){ //run through all pairs
				int temp;
				if(list[i] > list[i+1]){ //check pairs, swap if needed
					temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
				}
			}
		}
		
		long elapsed = System.nanoTime() - currentTime;
		//print out total time
		System.out.println();
		System.out.println("Total time elapsed: "+elapsed);
	}
}
