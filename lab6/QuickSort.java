package lab6;

public class QuickSort {
	
	private static int[] list = new int[1000000];
		
	public static void quickSort(int[] passedList)
	{
		for (int i=0; i<list.length;++i)
		{
			list[i] = passedList[i];
		}
		quickSort( 0, list.length - 1);
	}

	public static void quickSort(int first, int last){
		
		//recursive call
		if(last > first){
			int pivot = partition(first, last);
			quickSort(first, pivot - 1);
			quickSort(pivot + 1, last);
		}
	}
	
	public static int partition(int first, int last){
		
		//select pivot from first value in list
		int pivot = list[first];
		int low = first + 1;
		int high = last;
		
		while(high > low){
			
			//traverse array, keep values that are on correct side of pivot
			while(low <= high && list[low] <= pivot){
				low++;
			}
			while(low <=high && list[high] > pivot){
				high--;
			}
			
			//swap values that are on wrong side of pivot
			if(high > low){
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		//traverse right side of array
		while(high > first && list[high] >=pivot){
			high--;
		}
		
		//update pivot
		if(pivot > list[high]){
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else{
			return first;
		}
	}
	
	
}
