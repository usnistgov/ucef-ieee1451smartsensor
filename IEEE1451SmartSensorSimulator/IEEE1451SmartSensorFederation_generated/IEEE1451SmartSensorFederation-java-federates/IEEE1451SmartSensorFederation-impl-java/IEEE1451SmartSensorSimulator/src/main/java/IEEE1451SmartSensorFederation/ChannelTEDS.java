package IEEE1451SmartSensorFederation;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ChannelTEDS {

	private UInt8[] TEDSID;
	private UInt8 CalKey;
	private UInt8 ChanType;
	private UNITS PhyUnits;
	private Float32 LowLimit;
	private Float32 HiLimit;
	private Float32 OError;
	private UInt8 SelfTest;
	private UInt8 DatModel;
	private UInt8 ModLength;
	private UInt16 SigBits;
	private Float32 UpdateT;
	private Float32 RSetupT;
	private Float32 SPeriod;
	private Float32 WarmUpT;
	private Float32 RDelayT;
	private Float32 TestTime;
	private UInt8 SampMode;
	
	@Override
	public String toString() {
		String msg = ToStringBuilder.reflectionToString(this);
		msg = msg.substring(msg.indexOf("[")+1, msg.lastIndexOf("]"));
		msg = msg.replace(",", "\n");
		return msg;
	}

	public static ChannelTEDS getLM35AChannelTEDS() {
		ChannelTEDS teds = new ChannelTEDS();
		UInt8[] id = {new UInt8(0), new UInt8(3), new UInt8(1), new UInt8(1)};
		teds.setTEDSID(id);
		teds.setCalKey(new UInt8(1));
		teds.setChanType(new UInt8(0));
		teds.setPhyUnits(UNITS.getTemperatureUNITS());
		teds.setLowLimit(new Float32(218));
		teds.setHiLimit(new Float32(423));
		teds.setOError(new Float32(1));
		teds.setSelfTest(new UInt8(1));
		teds.setDatModel(new UInt8(0));
		teds.setModLength(new UInt8(2));
		teds.setSigBits(new UInt16(12));
		teds.setUpdateT(new Float32(0.1f));
		teds.setRSetupT(new Float32(.000025f));
		teds.setSPeriod(new Float32(0.1f));
		teds.setWarmUpT(new Float32(180));
		teds.setRDelayT(new Float32(.000025f));
		teds.setTestTime(new Float32(5));
		teds.setSampMode(new UInt8(2));
		return teds;
		
	}
	
	public ChannelTEDS() {
		setTEDSID(new UInt8[4]);
		setCalKey(new UInt8());
		setChanType(new UInt8());
		setPhyUnits(new UNITS());
		setLowLimit(new Float32());
		setHiLimit(new Float32());
		setOError(new Float32());
		setSelfTest(new UInt8());
		setDatModel(new UInt8());
		setModLength(new UInt8());
		setSigBits(new UInt16());
		setUpdateT(new Float32());
		setRSetupT(new Float32());
		setSPeriod(new Float32());
		setWarmUpT(new Float32());
		setRDelayT(new Float32());
		setTestTime(new Float32());
	}

	/**
	 * @return the tEDSID
	 */
	public UInt8[] getTEDSID() {
		return TEDSID;
	}

	/**
	 * @param tEDSID the tEDSID to set
	 */
	public void setTEDSID(UInt8[] tEDSID) {
		TEDSID = tEDSID;
	}

	/**
	 * @return the calKey
	 */
	public UInt8 getCalKey() {
		return CalKey;
	}

	/**
	 * @param calKey the calKey to set
	 */
	public void setCalKey(UInt8 calKey) {
		CalKey = calKey;
	}

	/**
	 * @return the chanType
	 */
	public UInt8 getChanType() {
		return ChanType;
	}

	/**
	 * @param chanType the chanType to set
	 */
	public void setChanType(UInt8 chanType) {
		ChanType = chanType;
	}

	/**
	 * @return the phyUnits
	 */
	public UNITS getPhyUnits() {
		return PhyUnits;
	}

	/**
	 * @param phyUnits the phyUnits to set
	 */
	public void setPhyUnits(UNITS phyUnits) {
		PhyUnits = phyUnits;
	}

	/**
	 * @return the lowLimit
	 */
	public Float32 getLowLimit() {
		return LowLimit;
	}

	/**
	 * @param lowLimit the lowLimit to set
	 */
	public void setLowLimit(Float32 lowLimit) {
		LowLimit = lowLimit;
	}

	/**
	 * @return the hiLimit
	 */
	public Float32 getHiLimit() {
		return HiLimit;
	}

	/**
	 * @param hiLimit the hiLimit to set
	 */
	public void setHiLimit(Float32 hiLimit) {
		HiLimit = hiLimit;
	}

	/**
	 * @return the oError
	 */
	public Float32 getOError() {
		return OError;
	}

	/**
	 * @param oError the oError to set
	 */
	public void setOError(Float32 oError) {
		OError = oError;
	}

	/**
	 * @return the selfTest
	 */
	public UInt8 getSelfTest() {
		return SelfTest;
	}

	/**
	 * @param selfTest the selfTest to set
	 */
	public void setSelfTest(UInt8 selfTest) {
		SelfTest = selfTest;
	}

	/**
	 * @return the datModel
	 */
	public UInt8 getDatModel() {
		return DatModel;
	}

	/**
	 * @param datModel the datModel to set
	 */
	public void setDatModel(UInt8 datModel) {
		DatModel = datModel;
	}

	/**
	 * @return the modLength
	 */
	public UInt8 getModLength() {
		return ModLength;
	}

	/**
	 * @param modLength the modLength to set
	 */
	public void setModLength(UInt8 modLength) {
		ModLength = modLength;
	}

	/**
	 * @return the sigBits
	 */
	public UInt16 getSigBits() {
		return SigBits;
	}

	/**
	 * @param sigBits the sigBits to set
	 */
	public void setSigBits(UInt16 sigBits) {
		SigBits = sigBits;
	}

	/**
	 * @return the updateT
	 */
	public Float32 getUpdateT() {
		return UpdateT;
	}

	/**
	 * @param updateT the updateT to set
	 */
	public void setUpdateT(Float32 updateT) {
		UpdateT = updateT;
	}
	/**
	 * @return the rSetupT
	 */
	public Float32 getRSetupT() {
		return RSetupT;
	}

	/**
	 * @param rSetupT the rSetupT to set
	 */
	public void setRSetupT(Float32 rSetupT) {
		RSetupT = rSetupT;
	}

	/**
	 * @return the warmUpT
	 */
	public Float32 getWarmUpT() {
		return WarmUpT;
	}

	/**
	 * @param warmUpT the warmUpT to set
	 */
	public void setWarmUpT(Float32 warmUpT) {
		WarmUpT = warmUpT;
	}

	/**
	 * @return the rDelayT
	 */
	public Float32 getRDelayT() {
		return RDelayT;
	}

	/**
	 * @param rDelayT the rDelayT to set
	 */
	public void setRDelayT(Float32 rDelayT) {
		RDelayT = rDelayT;
	}

	/**
	 * @return the testTime
	 */
	public Float32 getTestTime() {
		return TestTime;
	}

	/**
	 * @param testTime the testTime to set
	 */
	public void setTestTime(Float32 testTime) {
		TestTime = testTime;
	}

	/**
	 * @return the sPeriod
	 */
	public Float32 getSPeriod() {
		return SPeriod;
	}

	/**
	 * @param sPeriod the sPeriod to set
	 */
	public void setSPeriod(Float32 sPeriod) {
		SPeriod = sPeriod;
	}

	/**
	 * @return the sampMode
	 */
	public UInt8 getSampMode() {
		return SampMode;
	}

	/**
	 * @param sampMode the sampMode to set
	 */
	public void setSampMode(UInt8 sampMode) {
		SampMode = sampMode;
	}
}