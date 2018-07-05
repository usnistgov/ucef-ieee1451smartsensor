package IEEE1451SmartSensorSimulator;

public class UInt8 {
	
	private int value;
	
	public UInt8() {
		setValue(0);
	}
	
	public UInt8(int val) {
		setValue(val);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		if (value >= 0 && value <= 255)
			this.value = value;
		else
			throw new RuntimeException("UInt8 supports only values from 0 to 255");
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
}
