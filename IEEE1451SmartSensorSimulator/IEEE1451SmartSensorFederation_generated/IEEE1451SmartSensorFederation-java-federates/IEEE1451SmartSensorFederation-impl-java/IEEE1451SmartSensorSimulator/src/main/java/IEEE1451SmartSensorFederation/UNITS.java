package IEEE1451SmartSensorFederation;

public class UNITS {
	
	private UInt8 interpretation;
	private UInt8 radians;
	private UInt8 sterradians;
	private UInt8 meters;
	private UInt8 kilograms;
	private UInt8 seconds;
	private UInt8 amperes;
	private UInt8 kelvins;
	private UInt8 moles;
	private UInt8 candelas;
	private UInt8 UnitsExtensionTEDSAccessCode;
	
	public UNITS() {
		setInterpretation(new UInt8());
		setRadians(new UInt8());
		setSterradians(new UInt8());
		setMeters(new UInt8());
		setKilograms(new UInt8());
		setSeconds(new UInt8());
		setAmperes(new UInt8());
		setKelvins(new UInt8());
		setMoles(new UInt8());
		setCandelas(new UInt8());
		setUnitsExtensionTEDSAccessCode(new UInt8());
	}

	public UInt8 getInterpretation() {
		return interpretation;
	}

	public void setInterpretation(UInt8 interpretation) {
		this.interpretation = interpretation;
	}

	public UInt8 getRadians() {
		return radians;
	}

	public void setRadians(UInt8 radians) {
		this.radians = radians;
	}

	public UInt8 getSterradians() {
		return sterradians;
	}

	public void setSterradians(UInt8 sterradians) {
		this.sterradians = sterradians;
	}

	public UInt8 getMeters() {
		return meters;
	}

	public void setMeters(UInt8 meters) {
		this.meters = meters;
	}

	public UInt8 getKilograms() {
		return kilograms;
	}

	public void setKilograms(UInt8 kilograms) {
		this.kilograms = kilograms;
	}

	public UInt8 getSeconds() {
		return seconds;
	}

	public void setSeconds(UInt8 seconds) {
		this.seconds = seconds;
	}

	public UInt8 getAmperes() {
		return amperes;
	}

	public void setAmperes(UInt8 amperes) {
		this.amperes = amperes;
	}

	public UInt8 getKelvins() {
		return kelvins;
	}

	public void setKelvins(UInt8 kelvins) {
		this.kelvins = kelvins;
	}

	public UInt8 getMoles() {
		return moles;
	}

	public void setMoles(UInt8 moles) {
		this.moles = moles;
	}

	public UInt8 getCandelas() {
		return candelas;
	}

	public void setCandelas(UInt8 candelas) {
		this.candelas = candelas;
	}

	public UInt8 getUnitsExtensionTEDSAccessCode() {
		return UnitsExtensionTEDSAccessCode;
	}

	public void setUnitsExtensionTEDSAccessCode(UInt8 unitsExtensionTEDSAccessCode) {
		UnitsExtensionTEDSAccessCode = unitsExtensionTEDSAccessCode;
	}
}
