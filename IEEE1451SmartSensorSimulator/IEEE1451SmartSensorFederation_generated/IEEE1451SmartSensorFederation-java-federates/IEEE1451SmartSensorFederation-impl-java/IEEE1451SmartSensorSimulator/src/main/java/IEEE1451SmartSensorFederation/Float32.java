package IEEE1451SmartSensorFederation;

public class Float32 {
	
	private float value;
	
	public Float32() {
		setValue(0);
	}
	
	public Float32(float val) {
		setValue(val);
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		if (value >= -1*Math.pow(2, 255) && value < Math.pow(2, 255))
			this.value = value;
		else
			value = 0x7FFFFFFF;
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
}
