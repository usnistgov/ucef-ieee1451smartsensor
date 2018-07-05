package IEEE1451SmartSensorSimulator;

public class UInt16 {
	
	private int value;
	
	public UInt16() {
		setValue(0);
	}
	
	public UInt16(int val) {
		setValue(val);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		if (value >= 0 && value <= 65535)
			this.value = value;
		else
			throw new RuntimeException("UInt16 supports only values from 0 to 65535");
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
}
