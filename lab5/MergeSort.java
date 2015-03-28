package lab5;

public class MergeSort {
	
	public static int[] mergeSort(int[] list){
		
		if(list.length <=1){
			//if list is already small enough, return it
			return list;
		}
		
		//make new arrays for L half and R half
		int[] leftHalf = new int[list.length / 2];
		int[] rightHalf = new int[list.length - leftHalf.length];
		
		//copy original list into the new half-size lists
		System.arraycopy(list, 0, leftHalf, 0, list.length/2);
		System.arraycopy(list,  leftHalf.length, rightHalf, 0, list.length/2);
		
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
		
		int n = 100;
		
		//make the array
		int[] list = new int[n];
		
		//fill it with random numbers
		for(int i = 0; i < n; i++){
			double temp = Math.random() * 100;
			list[i] = (int) temp;
			System.out.print(list[i]+" ");
		}
		
		//sort using mergesort
		mergeSort(list);		
		
		System.out.println();
		//check sorting
		for(int i = 0; i < n-1; i ++){
			if(list[i] > list[i+1]){
				System.out.println("Error at index: "+i);
				break;
			}
		}
	}

}
