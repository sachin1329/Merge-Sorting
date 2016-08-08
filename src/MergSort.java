import java.util.Random;

public class MergSort {
	
	  private int[] array;
	    private int[] tempMergArr;
	    private int length;
	    static Random r = new Random();
	    private static long firstTime = System.nanoTime();
	 
	    public static void main(String a[]){
	         
	    	
	        int[] inputArr = new int[1000];
	        for(int i = 0; i < inputArr.length;i++) {
	        	inputArr[i] = r.nextInt(1000);
	        }
	        MergSort mms = new MergSort();
	        mms.sort(inputArr);
	        for(int i:inputArr){
	            System.out.print(i);
	            System.out.println(" ");
	        }
	        
	        long lastTime = System.nanoTime();
	        long totalTime = lastTime-firstTime;
	        System.out.println(totalTime);
	        System.out.println("Merge Sort");
	    }
	     
	    public void sort(int inputArr[]) {
	        this.array = inputArr;
	        this.length = inputArr.length;
	        this.tempMergArr = new int[length];
	        doMergeSort(0, length - 1);
	    }
	 
	    private void doMergeSort(int lowerIndex, int higherIndex) {
	         
	        if (lowerIndex < higherIndex) {
	            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
	            // Below step sorts the left side of the array
	            doMergeSort(lowerIndex, middle);
	            // Below step sorts the right side of the array
	            doMergeSort(middle + 1, higherIndex);
	            // Now merge both sides
	            mergeParts(lowerIndex, middle, higherIndex);
	        }
	    }
	 
	    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
	 
	        for (int i = lowerIndex; i <= higherIndex; i++) {
	            tempMergArr[i] = array[i];
	        }
	        int i = lowerIndex;
	        int j = middle + 1;
	        int k = lowerIndex;
	        while (i <= middle && j <= higherIndex) {
	            if (tempMergArr[i] <= tempMergArr[j]) {
	                array[k] = tempMergArr[i];
	                i++;
	            } else {
	                array[k] = tempMergArr[j];
	                j++;
	            }
	            k++;
	        }
	        while (i <= middle) {
	            array[k] = tempMergArr[i];
	            k++;
	            i++;
	        }
	 
	    }
	    
}
	

