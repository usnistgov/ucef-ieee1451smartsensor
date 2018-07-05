package IEEE1451SmartSensorFederation;

public class SensorNonOperableException extends Exception {

	private static final long serialVersionUID = -3845873929413496686L;
	
	public String toString() {
		return "Sensor isn't operable";
	}

}
