import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.util.ArrayList;

public class fileClass {
	private ArrayList<equipmentClass> equipment;
	private ArrayList<patientClass> patients;

	
	private File file = null;
	
	public void getFile() {
		JFileChooser chooser = new JFileChooser();
		int chosenfile = chooser.showOpenDialog(null);
		if(chosenfile == JFileChooser.APPROVE_OPTION) {	
			file = chooser.getSelectedFile();
		}
	}
	
	public void create() {
		equipment = new ArrayList<equipmentClass>();
		patients = new ArrayList<patientClass>();

		Scanner in = null;
		getFile();
		while(in==null) {
			try {
			    in = new Scanner(file);
			} catch (FileNotFoundException e) {
			    e.printStackTrace();
			}
		int numEquip=in.nextInt();
		for(int i=0;i<numEquip;i++) {
			String equipName =in.next();
			int equipQuantity = in.nextInt(); 
			equipmentClass ec = new equipmentClass(equipName, equipQuantity);
			equipment.add(ec);
		}
		int numPatients = in.nextInt();
		for(int j=0;j<numPatients;j++) {
			int patientTime = in.nextInt();
			in.nextLine();
			String patientEquip = in.nextLine();
			patientClass pc = new patientClass(patientTime, patientEquip);
			patients.add(pc);
		}
		}	
	}

	public void time(int numDocs, ArrayList<patientClass> patients) {
		doctorClass[] docs = new doctorClass[numDocs];
		doctorClass dc = new doctorClass(patients, equipment);
		
		for(int i=0;i<numDocs;i++) {
			docs[i] = new doctorClass(patients, equipment);
			
		}
		
		long startTime = System.currentTimeMillis();

		for(doctorClass i:docs) {
			i.start();
		}
		for(int i=0;i<numDocs;i++) {
			try {
				dc.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		dc.run();
		
		
	
		long endTime = System.currentTimeMillis();
		long elapsed = endTime - startTime;
		System.out.println(patients.size());
		System.out.println("Number of doctors: "+ numDocs);
		System.out.println("Time: "+ elapsed + " ms" );
		System.out.println();
	
	}
	public void lastMethodOfTheYear() {
		ArrayList<patientClass> patientsCopy1 = new ArrayList<>(patients);
		time(1,patientsCopy1);
		
		ArrayList<patientClass> patientsCopy2 = new ArrayList<>(patients);
		time(2,patientsCopy2);
		
		ArrayList<patientClass> patientsCopy3 = new ArrayList<>(patients);
		time(4,patientsCopy3);
		
		ArrayList<patientClass> patientsCopy4 = new ArrayList<>(patients);
		time(8,patientsCopy4);

	}
	
	public static void main(String [] args) {
		fileClass fc = new fileClass();
		fc.create();
		fc.lastMethodOfTheYear();
		
		
	}
}

