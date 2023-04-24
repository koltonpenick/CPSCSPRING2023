import java.util.ArrayList;
import java.util.Scanner;

public class patientClass {
	private int patientTime;
	private String equipName;
	private ArrayList<String> equipment;
	
	public  patientClass(int patientTime, String equipName) {
		this.patientTime = patientTime;
		this.equipName = equipName;
		Scanner s = new Scanner(equipName);
		while(s.hasNext()){
			String tool = s.next();
			equipment.add(tool);
			
			
		}
		
	}
	public int getTime() {
		return patientTime;	
	}
	public ArrayList<String> getTools() {
		return equipment;

	}
	

}
