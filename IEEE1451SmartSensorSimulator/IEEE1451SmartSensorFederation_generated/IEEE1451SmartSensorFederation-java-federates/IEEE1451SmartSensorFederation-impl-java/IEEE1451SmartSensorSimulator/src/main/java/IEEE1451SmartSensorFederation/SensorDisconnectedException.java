package IEEE1451SmartSensorFederation;

public class SensorDisconnectedException extends Exception {
	
	private static final long serialVersionUID = 7310808469422499565L;

	public String toString() {
		return "Sensor isn't connected to the network";
	}

}