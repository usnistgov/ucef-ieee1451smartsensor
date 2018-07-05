package IEEE1451SmartSensorFederation;

public class UInt32 {
	
	private long value;
	
	public UInt32() {
		setValue(0);
	}
	
	public UInt32(long val) {
		setValue(val);
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		if (value >= 0 && value <= 4294967295l)
			this.value = value;
		else
			throw new RuntimeException("UInt32 supports only values from 0 to 4294967295");
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
}
