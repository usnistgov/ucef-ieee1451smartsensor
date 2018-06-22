package DigitalTwin;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

public class Tester {

	public static void main(String args[]) {
		TemperatureSensor sensor = new TemperatureSensor();
		File file = new File("output.csv");
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		output.println("Real Temperature,Measured Temperature");
		
		sensor.setInputVoltage(5);
		for (int i = -55; i <= 150; i++){
			int rand = ThreadLocalRandom.current().nextInt(-55, 150);
			sensor.setRealTemperature(i);
			
			try {
				sensor.calcVolt();
				output.println(i + "," + sensor.getMeasuredTemperature());
			} 
			catch (Exception e) {
				System.out.println(e.getMessage() + " at this temperature: " + rand);
			}
			
//			try {
//				Thread.sleep(1000);
//			} 
//			catch (InterruptedException e) {
//				e.printStackTrace();
//				break;
//			}
		}
		System.out.println("Done!");
		output.flush();
	}
	
	
}
