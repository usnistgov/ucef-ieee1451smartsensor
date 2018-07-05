package IEEE1451SmartSensorSimulator;

public class ChannelIDTEDS {

	private _String manufacturerID;
	private _String modelNo;
	private _String versionCode;
	private _String serialNo;
	private _String channelDescription;
	
	public ChannelIDTEDS() {
		setManufacturerID(new _String());
		setModelNo(new _String());
		setVersionCode(new _String());
		setSerialNo(new _String());
		setChannelDescription(new _String());
	}

	public _String getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(_String manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public _String getModelNo() {
		return modelNo;
	}

	public void setModelNo(_String modelNo) {
		this.modelNo = modelNo;
	}

	public _String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(_String versionCode) {
		this.versionCode = versionCode;
	}

	public _String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(_String serialNo) {
		this.serialNo = serialNo;
	}

	public _String getChannelDescription() {
		return channelDescription;
	}

	public void setChannelDescription(_String channelDescription) {
		this.channelDescription = channelDescription;
	}
	
	@Override
	public String toString() {
		return manufacturerID + "," + modelNo + "," + versionCode + "," + serialNo + ","
				+ channelDescription;
	}
}
