import java.util.Random;
public class Main {
	public int[] createArray(int n) {
		int[] array = new int[n];
		Random r = new Random();
		for(int i=0; i<n; i++ ) {
		
			array[i] = (int) r.nextInt(1,101);
		}
		return array;
	}
	public void go() {
		int n= 10;
		
		int []array = createArray(10);
		doSum(array,1);
		doSum(array,2);
		doSum(array,4);
		doSum(array,10);
		
		int []array2 = createArray(100);
		doSum(array2,1);
		doSum(array2,2);
		doSum(array2,4);
		doSum(array2,10);
		
		int []array3 = createArray(1000);
		doSum(array3,1);
		doSum(array3,2);
		doSum(array3,4);
		doSum(array3,10);
		
		int []array4 = createArray(1000);
		doSum(array4,1);
		doSum(array4,2);
		doSum(array4,4);
		doSum(array4,10);
		

	

		
	}
	public void doSum( int [] array, int numThreads) 
	{
		ThreadClass [] threads = new ThreadClass[numThreads];

		
		for (int i=0; i<numThreads; i++)
			threads[i] = new ThreadClass(array, array.length, numThreads, i);
		
		long start = System.nanoTime();
		
		for (int i = 0; i < numThreads; i++) {
		    threads[i].start();
		}

		//join all threads
		for (int i = 0; i < numThreads; i++) {
		    try {
		        threads[i].join();
		    } catch (InterruptedException e) {
		        //handle the exception
		    }
		}
		int sum = 0;
		for (int i = 0; i < numThreads; i++) {
			 sum += threads[i].getResult();
		}

	
		
		
		long end = System.nanoTime();
		long elapsed = end - start;
		
		System.out.println("Threads: " + numThreads);
		System.out.println ("Size of array: " + array.length);
		System.out.println("Elapsed time = " + elapsed + " nanoseconds");
		System.out.println("Calculation: " + sum  );

		System.out.println();

	
	}

	public static void main(String [] args) {
		Main m = new Main();
		m.go();
	}
}
