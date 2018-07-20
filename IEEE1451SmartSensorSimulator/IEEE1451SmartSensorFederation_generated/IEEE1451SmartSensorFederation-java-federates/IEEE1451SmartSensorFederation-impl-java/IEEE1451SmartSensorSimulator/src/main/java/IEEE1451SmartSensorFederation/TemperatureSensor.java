package IEEE1451SmartSensorFederation;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

public class TemperatureSensor {

	private final static double MIN_OPERATING_TEMP = -55;
	private final static double MAX_OPERATING_TEMP = 150;
	private final static double MIN_OPERATING_VOLTAGE = 4;
	private final static double MAX_OPERATING_VOLTAGE = 30;
	private final static double NONLINEARITY = 0.18;
	private final static double OUT_OF_BOUNDS_INPUT_VOLTAGE = 100;
	private final static double OUT_OF_BOUNDS_TEMPERATURE = 500;
	
	private double inputVoltage;
	private double outputVoltage;
	private double realTemperature;
	private double measuredTemperature;
	
	private boolean voltOutOfBounds;
	private boolean tempOutOfBounds;
	private boolean disconnected;
	
	public TemperatureSensor() {
		inputVoltage = 5;
		realTemperature = 70;
		voltOutOfBounds = false;
		tempOutOfBounds = false;
		disconnected = false;
	}

	/**
	 * @param inputVoltage the inputVoltage to set
	 */
	public void setInputVoltage(double inputVoltage) {
		if (isBetween(inputVoltage, MIN_OPERATING_VOLTAGE, MAX_OPERATING_VOLTAGE))
			this.inputVoltage = inputVoltage;
		else
			voltOutOfBounds = true;
	}
	
	/**
	 * @return the outputVoltage
	 */
	public double getOutputVoltage() {
		return outputVoltage;
	}
	
	/**
	 * @param realTemperature the realTemperature to set
	 */
	public void setRealTemperature(double realTemperature) {
		if (isBetween(realTemperature, MIN_OPERATING_TEMP, MAX_OPERATING_TEMP))
			this.realTemperature = realTemperature;
		else
			tempOutOfBounds = true;
	}

	/**
	 * @return the measuredTemperature
	 * @throws SensorNonOperableException 
	 * @throws SensorDisconnectedException
	 */
	public double getMeasuredTemperature() throws SensorNonOperableException, SensorDisconnectedException {
		
		if (disconnected) {
			throw new SensorDisconnectedException();
		}
		
		if (isOperable()) {
			if (isBetween(realTemperature, MIN_OPERATING_TEMP, -10))
				measuredTemperature = realTemperature + plusMinus() * (.3 - (realTemperature+10)/450.0);
			
			else if (isBetween(realTemperature, -10, 25))
				measuredTemperature = realTemperature + plusMinus() * (.2 - (realTemperature-25)/350.0);
			
			else if (isBetween(realTemperature, 25, 150))
				measuredTemperature = realTemperature + plusMinus() * (.2 + 2*(realTemperature-25)/1250.0);
		}
		else {
			measuredTemperature = Double.POSITIVE_INFINITY;
			throw new SensorNonOperableException();
		}
		measuredTemperature = Double.parseDouble(String.format("%.2f", measuredTemperature));
		return measuredTemperature;
	}
	
	private double plusMinus() {
		double rand = ThreadLocalRandom.current().nextDouble(-1, 1);
		return rand;
	}
	
	/**
	 * @param val the value to be tested
	 * @param lowLimit lower limit of the range
	 * @param upLimit upper limit of the range
	 * @return
	 */
	private boolean isBetween(double val, double lowLimit, double highLimit) {
		return (val >= lowLimit && val <= highLimit);
	}
	
	/**
	 * @return determines if the sensor is operable based on the given constrains
	 */
	private boolean isOperable() {
		return (!tempOutOfBounds && !voltOutOfBounds && !disconnected);
	}	
	
	public void reset() {
		voltOutOfBounds = false;
		tempOutOfBounds = false;
		disconnected = false;		
	}

	public void disconnect() {
		disconnected = true;
	}
	
	public boolean isDisconnected() {
		return disconnected;
	}
}
