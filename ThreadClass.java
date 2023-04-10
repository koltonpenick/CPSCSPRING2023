

public class ThreadClass extends Thread {
	private int range;
	private int startIndex;
	private int[] array;
	private int result = 0;
	private int end;
	
	public int getResult() {
		return result;
	}
	public ThreadClass (int [] array, int arraySize, int numThreads, int threadIndex) {
		range = arraySize/numThreads;
		startIndex = threadIndex*range;
		end =((threadIndex + 1) * range ) - 1;
		this.array = array;
	}
	public void run() {
	for(int i = startIndex;i<end;i++) {
		result += array[i];	
		}
	}
}


