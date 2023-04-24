public class equipmentClass extends Thread {
	private String nameEquip;
	private int numEquip;
	
	public equipmentClass(String nameEquip, int numEquip ) {
		this.nameEquip = nameEquip;
		this.numEquip = numEquip;

	}

	public synchronized void get() {
		while(numEquip==0) {
			try {
				wait();
			} catch(InterruptedException e) {
				
			}
			
		}
		numEquip += -1;
	}
	
	public synchronized void add(int i) {
		numEquip += 1;
		notify();
	}
	
}
