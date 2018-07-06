package IEEE1451SmartSensorFederation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Tester {
	private static String data = "";
	/*public static void main(String args[]) {
		TemperatureSensor sensor = new TemperatureSensor();
		File file = new File("output.csv");
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

		service.scheduleAtFixedRate(new Runnable() {
			int count = 0;
			@Override
			public void run() {
				count++;
				try {
					if (count >= 5)
					{
						data += sensor.getMeasuredTemperature();
						System.out.println(data);
						System.out.println("Done!");
						service.shutdown();
					}


					data += sensor.getMeasuredTemperature()+ "\n";
				} catch (SensorNonOperableException e) {
					e.printStackTrace();
				}
			}
		}, 0, 1, TimeUnit.SECONDS);

		//		output.println("Real Temperature,Measured Temperature");
		//		
		//		sensor.setInputVoltage(5);
		//		for (int i = -55; i <= 150; i++){
		//			int rand = ThreadLocalRandom.current().nextInt(-55, 150);
		//			sensor.setRealTemperature(i);
		//			
		//			try {
		//				sensor.getMeasuredTemperature();
		//				output.println(i + "," + sensor.getMeasuredTemperature());
		//			} 
		//			catch (Exception e) {
		//				System.out.println(e.getMessage() + " at this temperature: " + rand);
		//			}
		//		}
		//		System.out.println("Done!");
		output.flush();
	}*/
	
	public static void main(String[] args) {
		ChannelIDTEDS channelIDTEDS = ChannelIDTEDS.getLM35AChannelIDTEDS();
		channelIDTEDS.setChannelDescription(new _String("Hello"));
		String msg = channelIDTEDS.toString();
		msg = msg.substring(msg.indexOf("[")+1, msg.lastIndexOf("]"));
		msg = msg.replace(",", "\n");
		System.out.println(msg);
	}


}
