package lab5b;

public class MergeSort {
	
	public int[] resultArray;
	public int[] tempArray;
	public int listLength;
	
	public static void main(String[] args){
		int n = 100;
		
		//make the array
		int[] list = new int[n];
		
		//fill it with random numbers
		for(int i = 0; i < n; i++){
			double temp = Math.random() * 100;
			list[i] = (int) temp;
		}
		
		//sort using mergesort
		MergeSort sorter = new MergeSort();
		sorter.sort(list);
		
		//check sorting
		boolean sortingError = false;
		for(int i = 0; i < n-1; i++){
			if(list[i] > list[i+1]){
				System.out.println("Error at index: "+i);
				sortingError = true;
				break;	
			}
		}
		if(sortingError==false){
			System.out.println("No errors!");
		}
	}
	
	public void sort(int[] list){
		
		resultArray = list;
		listLength = list.length;
		tempArray = new int[listLength];
		mergeSort(0, listLength - 1);
		
	}

	public void mergeSort(int low, int high){
		
		if(low < high){
			//set midpoint for cutting array in half
			int middle = low + (high - low) / 2;
			
			//sort left half
			mergeSort(low, middle);
			
			//sort right half
			mergeSort(middle + 1, high);
			
			//merge two halves back together
			merge(low, middle, high);
		}
	}
	
	public void merge(int low, int middle, int high){
		
		//copy into temp array
		for(int i = low; i <= high; i++){
			tempArray[i] = resultArray[i];
		}
		
		//set starting, middle and end points to define left half and right half of array
		int i = low; 
		int j = middle+1;
		int k = low;
		
		//choose smallest values from either list to put into array
		while(i <= middle && j <= high){
			if(tempArray[i] <=tempArray[j]){
				resultArray[k] = tempArray[i];
				i++;
			}
			else{
				resultArray[k] = tempArray[j];
				j++;
			}
			k++;
		}
		
		while(i <=middle){
			resultArray[k] = tempArray[i];
			k++;
			i++;
		}
	}
	
}
