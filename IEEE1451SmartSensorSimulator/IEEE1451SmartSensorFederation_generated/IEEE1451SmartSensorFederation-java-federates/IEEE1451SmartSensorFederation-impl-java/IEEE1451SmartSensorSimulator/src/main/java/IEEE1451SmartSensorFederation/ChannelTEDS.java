package IEEE1451SmartSensorFederation;

import java.util.Properties;

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
	private UInt8 MRange;
	private UInt8 DatModel;
	private UInt8 ModLength;
	private UInt16 SigBits;
	private UInt16 Repeats;
	private Float32 SOrigin;
	private Float32 StepSize;
	private UNITS SUnits;
	private UInt16 PreTrigg;
	private Float32 UpdateT;;
	private Float32 WSetupT;
	private Float32 RSetupT;
	private Float32 SPeriod;
	private Float32 WarmUpT;
	private Float32 RDelayT;
	private Float32 TestTime;
	private UInt8 TimeSrc;
	private Float32 InPropDl;
	private Float32 OutPropD;
	private Float32 TSError;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public static ChannelTEDS getLM35AChannelTEDS() {
		ChannelTEDS teds = new ChannelTEDS();
		UInt8[] id = {new UInt8(0), new UInt8(3), new UInt8(1), new UInt8(1)};
		teds.setTEDSID(id);
		teds.setCalKey(new UInt8(1));
		teds.ChanType = new UInt8(0);
		teds.PhyUnits = UNITS.getTemperatureUNITS();
		teds.setLowLimit(new Float32(218));
		teds.setHiLimit(new Float32(423));
		teds.setOError(new Float32(1));
		teds.setSelfTest(new UInt8(1));
		teds.setModLength(new UInt8(2));
		teds.setSigBits(new UInt16(12));
		
		teds.setUpdateT(new Float32(0.1f));
		
		teds.setRSetupT(new Float32(.000025f));
		teds.setWarmUpT(new Float32(180));
		teds.setRSetupT(new Float32(.000025f));
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
		setMRange(new UInt8());
		setDatModel(new UInt8());
		setModLength(new UInt8());
		setSigBits(new UInt16());
		setRepeats(new UInt16());
		setSOrigin(new Float32());
		setStepSize(new Float32());
		setSUnits(new UNITS());
		setPreTrigg(new UInt16());
		setUpdateT(new Float32());
		setWSetupT(new Float32());
		setRSetupT(new Float32());
		setSPeriod(new Float32());
		setWarmUpT(new Float32());
		setRDelayT(new Float32());
		setTestTime(new Float32());
		setTimeSrc(new UInt8());
		setInPropDl(new Float32());
		setOutPropD(new Float32());
		setTSError(new Float32());
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
	 * @return the mRange
	 */
	public UInt8 getMRange() {
		return MRange;
	}

	/**
	 * @param mRange the mRange to set
	 */
	public void setMRange(UInt8 mRange) {
		MRange = mRange;
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
	 * @return the repeats
	 */
	public UInt16 getRepeats() {
		return Repeats;
	}

	/**
	 * @param repeats the repeats to set
	 */
	public void setRepeats(UInt16 repeats) {
		Repeats = repeats;
	}

	/**
	 * @return the sOrigin
	 */
	public Float32 getSOrigin() {
		return SOrigin;
	}

	/**
	 * @param sOrigin the sOrigin to set
	 */
	public void setSOrigin(Float32 sOrigin) {
		SOrigin = sOrigin;
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
	 * @return the stepSize
	 */
	public Float32 getStepSize() {
		return StepSize;
	}

	/**
	 * @param stepSize the stepSize to set
	 */
	public void setStepSize(Float32 stepSize) {
		StepSize = stepSize;
	}

	/**
	 * @return the sUnits
	 */
	public UNITS getSUnits() {
		return SUnits;
	}

	/**
	 * @param sUnits the sUnits to set
	 */
	public void setSUnits(UNITS sUnits) {
		SUnits = sUnits;
	}

	/**
	 * @return the preTrigg
	 */
	public UInt16 getPreTrigg() {
		return PreTrigg;
	}

	/**
	 * @param preTrigg the preTrigg to set
	 */
	public void setPreTrigg(UInt16 preTrigg) {
		PreTrigg = preTrigg;
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
	 * @return the wSetupT
	 */
	public Float32 getWSetupT() {
		return WSetupT;
	}

	/**
	 * @param wSetupT the wSetupT to set
	 */
	public void setWSetupT(Float32 wSetupT) {
		WSetupT = wSetupT;
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
	 * @return the timeSrc
	 */
	public UInt8 getTimeSrc() {
		return TimeSrc;
	}

	/**
	 * @param timeSrc the timeSrc to set
	 */
	public void setTimeSrc(UInt8 timeSrc) {
		TimeSrc = timeSrc;
	}

	/**
	 * @return the inPropDl
	 */
	public Float32 getInPropDl() {
		return InPropDl;
	}

	/**
	 * @param inPropDl the inPropDl to set
	 */
	public void setInPropDl(Float32 inPropDl) {
		InPropDl = inPropDl;
	}

	/**
	 * @return the outPropD
	 */
	public Float32 getOutPropD() {
		return OutPropD;
	}

	/**
	 * @param outPropD the outPropD to set
	 */
	public void setOutPropD(Float32 outPropD) {
		OutPropD = outPropD;
	}

	/**
	 * @return the tSError
	 */
	public Float32 getTSError() {
		return TSError;
	}

	/**
	 * @param tSError the tSError to set
	 */
	public void setTSError(Float32 tSError) {
		TSError = tSError;
	}
}