package DigitalTwin;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

public class TemperatureSensor {

	private final static double MIN_OPERATING_TEMP = -55;
	private final static double MAX_OPERATING_TEMP = 150;
	private final static double MIN_OPERATING_VOLTAGE = 4;
	private final static double MAX_OPERATING_VOLTAGE = 30;
	private final static double NONLINEARITY = 0.18;
	
	private double inputVoltage = -1;
	private double outputVoltage = -1;
	private double realTemperature = -100;
	private double measuredTemperature = -100;

	/**
	 * @param inputVoltage the inputVoltage to set
	 */
	public void setInputVoltage(double inputVoltage) {
		this.inputVoltage = inputVoltage;
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
		this.realTemperature = realTemperature;
	}

	/**
	 * @return the measuredTemperature
	 * @throws Exception 
	 */
	public double getMeasuredTemperature(){
		calcVolt();
		return measuredTemperature;
	}
	
	private double plusMinus() {
		double rand = ThreadLocalRandom.current().nextDouble(-1, 1);
		return rand;
	}
	
	public void calcVolt(){
		if (isOperable()) {
			if (isBetween(realTemperature, MIN_OPERATING_TEMP, -10))
				measuredTemperature = realTemperature + plusMinus() * (.3 - (realTemperature+10)/450.0);
			
			else if (isBetween(realTemperature, -10, 25))
				measuredTemperature = realTemperature + plusMinus() * (.2 - (realTemperature-25)/350.0);
			
			else if (isBetween(realTemperature, 25, 150))
				measuredTemperature = realTemperature + plusMinus() * (.2 + 2*(realTemperature-25)/1250.0);
		}
		else
			measuredTemperature = Double.POSITIVE_INFINITY;
//			throw new Exception("Sensor isn't operable");
	}
	
	public void applyLinearity() {
		
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
		return (isBetween(realTemperature, MIN_OPERATING_TEMP, MAX_OPERATING_TEMP) 
				&& isBetween(inputVoltage, MIN_OPERATING_VOLTAGE, MAX_OPERATING_VOLTAGE));
	}
	
	

}
