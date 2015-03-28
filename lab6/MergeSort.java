package lab6;

public class MergeSort {
	
	public static int[] mergeSort(int[] list){
		
		if(list.length <=1){
			
			//return list if only has one element
			return list;
		}
		
		//make new arrays for L half and R half
		int[] leftHalf = new int[list.length / 2];
		int[] rightHalf = new int[list.length - leftHalf.length];
		
		//copy original list into the new half-size lists
		System.arraycopy(list, 0, leftHalf, 0, leftHalf.length);
		System.arraycopy(list,  leftHalf.length, rightHalf, 0, rightHalf.length);
		
		//recursion; tell it to keep splitting and sorting
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		
		//merge the lists
		merge(leftHalf, rightHalf, list);
		return list;
		
	}
	
	public static void merge(int[] leftHalf, int[] rightHalf, int[] result){
		
		//next element in left half
		int lCounter = 0;
		//next element in right half
		int rCounter = 0;
		//next open position in result array
		int i = 0;
		
		//check to see which element from L and R is smaller
		while(lCounter < leftHalf.length && rCounter < rightHalf.length){
			
			//left is smaller, put left element first into result
			if(leftHalf[lCounter] < rightHalf[rCounter]){
				result[i] = leftHalf[lCounter];
				lCounter++;
			}
			
			//right is smaller, put right element first into result
			else{
				result[i] = rightHalf[rCounter];
				rCounter++;
			}
			i++;
		}		
	}
	
	public static void main(String[] args){
			
		int n = 1000000;
		
		//make the array
		int[] list = new int[n];
		
		//fill it with random numbers
		for(int i = 0; i < n; i++){
			double temp = Math.random() * 100;
			list[i] = (int) temp;
			System.out.print(list[i]+" ");
		}
		
		MergeSort sorter = new MergeSort();
		//start timer
		long currentTime = System.nanoTime();
		//sort using mergesort
		sorter.mergeSort(list);		
		//stop timer
		long elapsed = System.nanoTime() - currentTime;
		
		System.out.println();
		//check sorting
		for(int i = 0; i < n; i ++){
			System.out.print(list[i]+" ");
		}
		
		//print out total time elapsed
		System.out.println();
		System.out.println("Total time elapsed: "+elapsed);
	}
}
