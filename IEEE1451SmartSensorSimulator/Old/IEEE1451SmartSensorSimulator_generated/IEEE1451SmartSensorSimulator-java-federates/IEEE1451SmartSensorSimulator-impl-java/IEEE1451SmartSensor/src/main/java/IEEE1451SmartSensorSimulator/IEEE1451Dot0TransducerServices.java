package IEEE1451SmartSensorSimulator;

public class IEEE1451Dot0TransducerServices {
	
	private TemperatureSensor sensor;
	
	
	public IEEE1451Dot0TransducerServices() {
		sensor = new TemperatureSensor();
		sensor.setInputVoltage(5);
		sensor.setRealTemperature(80);
	}
	
	public UInt8[] readTransducerChannelDataSetSegment(UInt32 dataSetOffset) {
		UInt8[] reply = new UInt8[8];
		return null;
	}
	
	public UInt16 readTeds(UInt16 transCommId, TimeDuration timeout, UInt8 tedsType) {
		return transCommId;
	}

}
