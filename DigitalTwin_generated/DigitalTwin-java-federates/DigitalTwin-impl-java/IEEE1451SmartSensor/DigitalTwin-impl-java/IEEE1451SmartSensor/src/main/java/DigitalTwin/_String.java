package DigitalTwin;

public class _String {
	
	private String value;
	
	public _String() {
		set("");
	}
	
	public _String(String val) {
		set(val);
	}

	/**
	 * @return returns the String
	 */
	public String get() {
		return value;
	}

	/**
	 * @param value sets the _String to value
	 */
	public void set(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
}
