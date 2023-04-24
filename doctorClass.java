import java.util.ArrayList;

public class doctorClass extends Thread {
	private ArrayList<equipmentClass> equipment;
	private ArrayList<patientClass> patients;
	
	public doctorClass(ArrayList <patientClass> patients, ArrayList<equipmentClass> equipment) {
		this.equipment = equipment;
		this.patients = patients;

	}

	public void run() {
		//doctor gets patients
		patientClass currentPatient = patients.get(0);
		currentPatient = patients.remove(0);
		for(int j=0;j<currentPatient.getTools().size();j++) {
			String currentItem = currentPatient.getTools().get(j);
			for(int i=0;i<=equipment.size();i++) {
				equipmentClass currentEquipment = equipment.get(i);
				if(currentEquipment.getName() == currentItem) {
					currentEquipment.get();
				}	
			}
		}
		 long startTime = System.currentTimeMillis();
		    try {
		        Thread.sleep(currentPatient.getTime());
		        } 
		    catch (InterruptedException e) {
		        long elapsedTime = System.currentTimeMillis() - startTime;
		        while (elapsedTime < currentPatient.getTime()) {
		            long remainingTime = currentPatient.getTime() - elapsedTime;
		            try {
		                Thread.sleep(remainingTime);
		            } catch (InterruptedException ex) {
		            	
		            }
		            elapsedTime = System.currentTimeMillis() - startTime;
		        }
		    }
		
		for(int j=0;j<currentPatient.getTools().size();j++) {
			String currentItem = currentPatient.getTools().get(j);
			for(int i=0;i<=equipment.size();i++) {
				equipmentClass currentEquipment = equipment.get(i);
				if(currentEquipment.getName() == currentItem) {
					currentEquipment.add(1);
				}
			}
		}
	}	
}


	



