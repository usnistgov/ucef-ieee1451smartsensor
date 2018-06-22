package DigitalTwin;

import org.cpswt.config.FederateConfig;
import org.cpswt.config.FederateConfigParser;
import org.cpswt.hla.InteractionRoot;
import org.cpswt.hla.base.AdvanceTimeRequest;
import org.cpswt.utils.CpswtDefaults;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The IEEE1451SmartSensor type of federate for the federation designed in WebGME.
 *
 */
public class IEEE1451SmartSensor extends IEEE1451SmartSensorBase {

    private final static Logger log = LogManager.getLogger(IEEE1451SmartSensor.class);
    
    private final static UInt16 NO_ERROR = new UInt16(0);
    private final static UInt16 INVALID_COMMID = new UInt16(1);
    private final static UInt16 UNKNOWN_DESTID = new UInt16(2);
    private final static UInt16 TIMEOUT = new UInt16(3);
    private final static UInt16 NETWORK_FAILURE = new UInt16(4);
    private final static UInt16 NETWORK_CORRUPTION = new UInt16(5);
    private final static UInt16 MEMORY = new UInt16(6);
    private final static UInt16 QOS_FAILURE = new UInt16(7);
    private final static UInt16 MCAST_NOT_SUPPORTED = new UInt16(8);
    private final static UInt16 UNKNOWN_GROUP_ID = new UInt16(9);
    private final static UInt16 UNKNOWN_MODULEID = new UInt16(10);
    private final static UInt16 UNKNOWN_MSGID = new UInt16(11);
    private final static UInt16 NOT_GROUP_MEMBER = new UInt16(12);
    private final static UInt16 ILLEGAL_MODE = new UInt16(13);
    private final static UInt16 LOCKED_RESOURSCE = new UInt16(14);
    private final static UInt16 FATAL_TEDS_ERROR = new UInt16(15);
    private final static UInt16 NON_FATAL_TEDS_ERROR = new UInt16(16);
    private final static UInt16 CLOSE_ON_LOCKED_RESOURCE = new UInt16(17);
    private final static UInt16 LOCK_BROKEN = new UInt16(18);
    private final static UInt16 NETWORK_RESOURCE_EXCEEDED = new UInt16(19);
    private final static UInt16 MEMORY_RESOURCE_EXCEEDED = new UInt16(20);

    private TemperatureSensor sensor = new TemperatureSensor();
    private ChannelTEDS channelTEDS = new ChannelTEDS();
    private ChannelIDTEDS channelIDTEDS = new ChannelIDTEDS();

    double currentTime = 0;

    public IEEE1451SmartSensor(FederateConfig params) throws Exception {
        super(params);
    }

    private void CheckReceivedSubscriptions(String s) {

        InteractionRoot interaction = null;
        while ((interaction = getNextInteractionNoWait()) != null) {
            if (interaction instanceof ReadTransducerSampleDataFromAChannelOfATIMRequest) {
                handleInteractionClass((ReadTransducerSampleDataFromAChannelOfATIMRequest) interaction);
            }
            else if (interaction instanceof ReadTransducerBlockDataFromAChannelOfATIMRequest) {
                handleInteractionClass((ReadTransducerBlockDataFromAChannelOfATIMRequest) interaction);
            }
            else if (interaction instanceof ReadTransducerChannelTEDSRequest) {
                handleInteractionClass((ReadTransducerChannelTEDSRequest) interaction);
            }
            else if (interaction instanceof ReadTransducerChannelIdTEDSRequest) {
                handleInteractionClass((ReadTransducerChannelIdTEDSRequest) interaction);
            }
//            log.info("Interaction received and handled: " + s);
        }
     }

    private void execute() throws Exception {
        if(super.isLateJoiner()) {
            currentTime = super.getLBTS() - super.getLookAhead();
            super.disableTimeRegulation();
        }

        /////////////////////////////////////////////
        // TODO perform basic initialization below //
        /////////////////////////////////////////////
        channelIDTEDS.setManufacturerID(new _String("Texas Instruments"));
        channelIDTEDS.setModelNo(new _String("LM35A"));
        channelIDTEDS.setSerialNo(new _String("115445125146"));
        channelIDTEDS.setVersionCode(new _String("35A"));
        channelIDTEDS.setChannelDescription(new _String("Precision Centigrade Temperature Sensors"));
        sensor.setInputVoltage(5);
        sensor.setRealTemperature(70);
        
        AdvanceTimeRequest atr = new AdvanceTimeRequest(currentTime);
        putAdvanceTimeRequest(atr);

        if(!super.isLateJoiner()) {
            readyToPopulate();
        }

        ///////////////////////////////////////////////////////////////////////
        // Call CheckReceivedSubscriptions(<message>) here to receive
        // subscriptions published before the first time step.
        ///////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////
        // TODO perform initialization that depends on other federates below //
        ///////////////////////////////////////////////////////////////////////

        if(!super.isLateJoiner()) {
            readyToRun();
        }

        startAdvanceTimeThread();

        // this is the exit condition of the following while loop
        // it is used to break the loop so that latejoiner federates can
        // notify the federation manager that they left the federation
        boolean exitCondition = false;

        while (true) {
            currentTime += super.getStepSize();

            atr.requestSyncStart();
            enteredTimeGrantedState();

            ////////////////////////////////////////////////////////////////////////////////////////
            // TODO send interactions that must be sent every logical time step below.
            // Set the interaction's parameters.
            //
            //    ReadTransducerBlockDataFromAChannelOfATIMResponse vReadTransducerBlockDataFromAChannelOfATIMResponse = create_ReadTransducerBlockDataFromAChannelOfATIMResponse();
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.set_CheckSum( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.set_Length( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.set_MessageID( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.set_MessageType( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.set_Priority( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.set_SequenceNo( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.set_SessionNo( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.set_Status( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.set_channelId( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.set_errorCode( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.set_ncapId( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.set_timId( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.set_transducerBlockData( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMResponse.sendInteraction(getLRC(), currentTime);
            //
            //    ReadTransducerChannelIdTEDSResponse vReadTransducerChannelIdTEDSResponse = create_ReadTransducerChannelIdTEDSResponse();
            //    vReadTransducerChannelIdTEDSResponse.set_CheckSum( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSResponse.set_Length( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSResponse.set_MessageID( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSResponse.set_MessageType( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSResponse.set_Priority( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSResponse.set_SequenceNo( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSResponse.set_SessionNo( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSResponse.set_Status( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSResponse.set_errorCode( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSResponse.set_transducerChannelIdTEDS( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSResponse.sendInteraction(getLRC(), currentTime);
            //
            //    ReadTransducerSampleDataFromAChannelOfATIMResponse vReadTransducerSampleDataFromAChannelOfATIMResponse = create_ReadTransducerSampleDataFromAChannelOfATIMResponse();
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.set_CheckSum( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.set_Length( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.set_MessageID( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.set_MessageType( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.set_Priority( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.set_SequenceNo( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.set_SessionNo( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.set_Status( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.set_channelId( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.set_errorCode( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.set_ncapId( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.set_timId( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.set_transducerSampleData( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMResponse.sendInteraction(getLRC(), currentTime);
            //
            //    ReadTransducerChannelTEDSResponse vReadTransducerChannelTEDSResponse = create_ReadTransducerChannelTEDSResponse();
            //    vReadTransducerChannelTEDSResponse.set_CheckSum( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSResponse.set_Length( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSResponse.set_MessageID( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSResponse.set_MessageType( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSResponse.set_Priority( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSResponse.set_SequenceNo( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSResponse.set_SessionNo( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSResponse.set_Status( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSResponse.set_errorCode( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSResponse.set_transducerChannelTEDS( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSResponse.sendInteraction(getLRC(), currentTime);
            //
            ////////////////////////////////////////////////////////////////////////////////////////

            CheckReceivedSubscriptions("Main Loop");

            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            // DO NOT MODIFY FILE BEYOND THIS LINE
            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            AdvanceTimeRequest newATR = new AdvanceTimeRequest(currentTime);
            putAdvanceTimeRequest(newATR);
            atr.requestSyncEnd();
            atr = newATR;

            if(exitCondition) {
                break;
            }
        }

        // while loop finished, notify FederationManager about resign
        super.notifyFederationOfResign();
    }

    private void handleInteractionClass(ReadTransducerSampleDataFromAChannelOfATIMRequest interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    	
    	ReadTransducerSampleDataFromAChannelOfATIMResponse vReadTransducerSampleDataFromAChannelOfATIMResponse = create_ReadTransducerSampleDataFromAChannelOfATIMResponse();
        vReadTransducerSampleDataFromAChannelOfATIMResponse.set_channelId(interaction.get_channelId());
        vReadTransducerSampleDataFromAChannelOfATIMResponse.set_errorCode(NO_ERROR.getValue());
        vReadTransducerSampleDataFromAChannelOfATIMResponse.set_ncapId(interaction.get_ncapId());
        vReadTransducerSampleDataFromAChannelOfATIMResponse.set_timId(interaction.get_timId());
        vReadTransducerSampleDataFromAChannelOfATIMResponse.set_transducerSampleData("" + sensor.getMeasuredTemperature());
        vReadTransducerSampleDataFromAChannelOfATIMResponse.set_CheckSum((short) 1);
        vReadTransducerSampleDataFromAChannelOfATIMResponse.set_Length((short) 1);
        vReadTransducerSampleDataFromAChannelOfATIMResponse.set_MessageID((short) 1);
        vReadTransducerSampleDataFromAChannelOfATIMResponse.set_MessageType((byte) 1);
        vReadTransducerSampleDataFromAChannelOfATIMResponse.set_Priority((byte) 1);
        vReadTransducerSampleDataFromAChannelOfATIMResponse.set_SequenceNo((byte) 1);
        vReadTransducerSampleDataFromAChannelOfATIMResponse.set_SessionNo((byte) 1);
        vReadTransducerSampleDataFromAChannelOfATIMResponse.set_Status((byte) 1);
        
        try {
			vReadTransducerSampleDataFromAChannelOfATIMResponse.sendInteraction(getLRC(), currentTime);
		} catch (Exception e) {
			log.error("Error occured during interaction");
		}
        log.info("Sending data");
    }

    private void handleInteractionClass(ReadTransducerBlockDataFromAChannelOfATIMRequest interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    	
    	ReadTransducerBlockDataFromAChannelOfATIMResponse vReadTransducerBlockDataFromAChannelOfATIMResponse = create_ReadTransducerBlockDataFromAChannelOfATIMResponse();
        vReadTransducerBlockDataFromAChannelOfATIMResponse.set_channelId(interaction.get_channelId());
        vReadTransducerBlockDataFromAChannelOfATIMResponse.set_errorCode(NO_ERROR.getValue());
        vReadTransducerBlockDataFromAChannelOfATIMResponse.set_ncapId(interaction.get_ncapId());
        vReadTransducerBlockDataFromAChannelOfATIMResponse.set_timId(interaction.get_timId());
        vReadTransducerBlockDataFromAChannelOfATIMResponse.set_transducerBlockData("");
        vReadTransducerBlockDataFromAChannelOfATIMResponse.set_CheckSum((short) 1);
        vReadTransducerBlockDataFromAChannelOfATIMResponse.set_Length((short) 1);
        vReadTransducerBlockDataFromAChannelOfATIMResponse.set_MessageID((short) 1);
        vReadTransducerBlockDataFromAChannelOfATIMResponse.set_MessageType((byte) 1);
        vReadTransducerBlockDataFromAChannelOfATIMResponse.set_Priority((byte) 1);
        vReadTransducerBlockDataFromAChannelOfATIMResponse.set_SequenceNo((byte) 1);
        vReadTransducerBlockDataFromAChannelOfATIMResponse.set_SessionNo((byte) 1);
        vReadTransducerBlockDataFromAChannelOfATIMResponse.set_Status((byte) 1);
        try {
			vReadTransducerBlockDataFromAChannelOfATIMResponse.sendInteraction(getLRC(), currentTime);
		} catch (Exception e) {
			log.error("Error occured during interaction");
		}
        log.info("Sending data");
    }

    private void handleInteractionClass(ReadTransducerChannelTEDSRequest interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    	
    	ReadTransducerChannelTEDSResponse vReadTransducerChannelTEDSResponse = create_ReadTransducerChannelTEDSResponse();
        vReadTransducerChannelTEDSResponse.set_errorCode(NO_ERROR.getValue());
        vReadTransducerChannelTEDSResponse.set_transducerChannelTEDS(channelTEDS.toString());
        vReadTransducerChannelTEDSResponse.set_CheckSum((short) 1);
        vReadTransducerChannelTEDSResponse.set_Length((short) 1);
        vReadTransducerChannelTEDSResponse.set_MessageID((short) 1);
        vReadTransducerChannelTEDSResponse.set_MessageType((byte) 1);
        vReadTransducerChannelTEDSResponse.set_SequenceNo((byte) 1);
        vReadTransducerChannelTEDSResponse.set_SessionNo((byte) 1);
        vReadTransducerChannelTEDSResponse.set_Status((byte) 1);
        try {
			vReadTransducerChannelTEDSResponse.sendInteraction(getLRC(), currentTime);
		} catch (Exception e) {
			log.error("An error occured");
		}
    }

    private void handleInteractionClass(ReadTransducerChannelIdTEDSRequest interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    	
    	ReadTransducerChannelIdTEDSResponse vReadTransducerChannelIdTEDSResponse = create_ReadTransducerChannelIdTEDSResponse();
        vReadTransducerChannelIdTEDSResponse.set_errorCode(NO_ERROR.getValue());
        vReadTransducerChannelIdTEDSResponse.set_transducerChannelIdTEDS(channelIDTEDS.toString());
        vReadTransducerChannelIdTEDSResponse.set_CheckSum((short) 1);
        vReadTransducerChannelIdTEDSResponse.set_Length((short) 1);
        vReadTransducerChannelIdTEDSResponse.set_MessageID((short) 1);
        vReadTransducerChannelIdTEDSResponse.set_SequenceNo((byte) 1);
        vReadTransducerChannelIdTEDSResponse.set_SessionNo((byte) 1);
        vReadTransducerChannelIdTEDSResponse.set_Status((byte) 1);
        try {
			vReadTransducerChannelIdTEDSResponse.sendInteraction(getLRC(), currentTime);
		} catch (Exception e) {
			log.error("An error occured");
		}
    }

    public static void main(String[] args) {
        try {
            FederateConfigParser federateConfigParser = new FederateConfigParser();
            FederateConfig federateConfig = federateConfigParser.parseArgs(args, FederateConfig.class);
            IEEE1451SmartSensor federate = new IEEE1451SmartSensor(federateConfig);
            federate.execute();
            System.exit(0);
        } catch (Exception e) {
            log.error("There was a problem executing the IEEE1451SmartSensor federate: {}", e.getMessage());
            log.error(e);

            System.exit(1);
        }
    }
}
