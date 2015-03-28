package lab6;

public class QuickSort2  {
	
	private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
         
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
  public static void main(String[] args){
	  		
		int n = 100000;

		QuickSort2 sorter = new QuickSort2();
		
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
		sorter.sort(list);	
		
		long elapsed = System.nanoTime() - currentTime;
		//print out total time
		System.out.println();
		//check sorting
		for(int i = 0; i < n - 1; i ++){
			System.out.println(list[i]);
			if(list[i] > list[i+1]){
				System.out.println("Not in order at index: "+i);
				break;
			}
		}
		System.out.println(); 
		System.out.println("Total time elapsed: "+elapsed);	
	}
} 