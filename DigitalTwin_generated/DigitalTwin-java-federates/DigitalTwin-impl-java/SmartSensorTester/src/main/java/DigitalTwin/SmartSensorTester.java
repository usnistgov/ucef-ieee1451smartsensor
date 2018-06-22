package DigitalTwin;

import org.cpswt.config.FederateConfig;
import org.cpswt.config.FederateConfigParser;
import org.cpswt.hla.InteractionRoot;
import org.cpswt.hla.base.AdvanceTimeRequest;
import org.cpswt.utils.CpswtDefaults;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The SmartSensorTester type of federate for the federation designed in WebGME.
 *
 */
public class SmartSensorTester extends SmartSensorTesterBase {

    private final static Logger log = LogManager.getLogger(SmartSensorTester.class);

    double currentTime = 0;

    public SmartSensorTester(FederateConfig params) throws Exception {
        super(params);
    }

    private void CheckReceivedSubscriptions(String s) {

        InteractionRoot interaction = null;
        while ((interaction = getNextInteractionNoWait()) != null) {
            if (interaction instanceof ReadTransducerChannelIdTEDSResponse) {
                handleInteractionClass((ReadTransducerChannelIdTEDSResponse) interaction);
            }
            else if (interaction instanceof ReadTransducerSampleDataFromAChannelOfATIMResponse) {
                handleInteractionClass((ReadTransducerSampleDataFromAChannelOfATIMResponse) interaction);
            }
            else if (interaction instanceof ReadTransducerBlockDataFromAChannelOfATIMResponse) {
                handleInteractionClass((ReadTransducerBlockDataFromAChannelOfATIMResponse) interaction);
            }
            else if (interaction instanceof ReadTransducerChannelTEDSResponse) {
                handleInteractionClass((ReadTransducerChannelTEDSResponse) interaction);
            }
            log.info("Interaction received and handled: " + s);
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
            //    ReadTransducerSampleDataFromAChannelOfATIMRequest vReadTransducerSampleDataFromAChannelOfATIMRequest = create_ReadTransducerSampleDataFromAChannelOfATIMRequest();
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_CheckSum( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_Length( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_MessageID( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_MessageType( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_Priority( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_SequenceNo( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_SessionNo( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_Status( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_channelId( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_ncapId( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_samplingMode( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_timId( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_timeoutNsecs( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.set_timeoutSecs( < YOUR VALUE HERE > );
            //    vReadTransducerSampleDataFromAChannelOfATIMRequest.sendInteraction(getLRC(), currentTime);
            //
            //    ReadTransducerChannelIdTEDSRequest vReadTransducerChannelIdTEDSRequest = create_ReadTransducerChannelIdTEDSRequest();
            //    vReadTransducerChannelIdTEDSRequest.set_CheckSum( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSRequest.set_Length( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSRequest.set_MessageID( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSRequest.set_MessageType( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSRequest.set_Priority( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSRequest.set_SequenceNo( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSRequest.set_SessionNo( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSRequest.set_Status( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSRequest.set_channelId( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSRequest.set_ncapId( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSRequest.set_timId( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSRequest.set_timeoutNsecs( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSRequest.set_timeoutSecs( < YOUR VALUE HERE > );
            //    vReadTransducerChannelIdTEDSRequest.sendInteraction(getLRC(), currentTime);
            //
            //    ReadTransducerChannelTEDSRequest vReadTransducerChannelTEDSRequest = create_ReadTransducerChannelTEDSRequest();
            //    vReadTransducerChannelTEDSRequest.set_CheckSum( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSRequest.set_Length( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSRequest.set_MessageID( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSRequest.set_MessageType( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSRequest.set_Priority( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSRequest.set_SequenceNo( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSRequest.set_SessionNo( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSRequest.set_Status( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSRequest.set_channelId( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSRequest.set_ncapId( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSRequest.set_timId( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSRequest.set_timeoutNsecs( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSRequest.set_timeoutSecs( < YOUR VALUE HERE > );
            //    vReadTransducerChannelTEDSRequest.sendInteraction(getLRC(), currentTime);
            //
            //    FaultInjection vFaultInjection = create_FaultInjection();
            //    vFaultInjection.set_FaultCode( < YOUR VALUE HERE > );
            //    vFaultInjection.sendInteraction(getLRC(), currentTime);
            //
            //    ReadTransducerBlockDataFromAChannelOfATIMRequest vReadTransducerBlockDataFromAChannelOfATIMRequest = create_ReadTransducerBlockDataFromAChannelOfATIMRequest();
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_CheckSum( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_Length( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_MessageID( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_MessageType( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_Priority( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_SequenceNo( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_SessionNo( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_Status( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_channelId( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_ncapId( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_numberOfSamples( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_sampleIntervalNsecs( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_sampleIntervalSecs( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_startTimeNsecs( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_startTimeSecs( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_timId( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_timeoutNsecs( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.set_timeoutSecs( < YOUR VALUE HERE > );
            //    vReadTransducerBlockDataFromAChannelOfATIMRequest.sendInteraction(getLRC(), currentTime);
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

    private void handleInteractionClass(ReadTransducerChannelIdTEDSResponse interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    private void handleInteractionClass(ReadTransducerSampleDataFromAChannelOfATIMResponse interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    private void handleInteractionClass(ReadTransducerBlockDataFromAChannelOfATIMResponse interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    private void handleInteractionClass(ReadTransducerChannelTEDSResponse interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    public static void main(String[] args) {
        try {
            FederateConfigParser federateConfigParser = new FederateConfigParser();
            FederateConfig federateConfig = federateConfigParser.parseArgs(args, FederateConfig.class);
            SmartSensorTester federate = new SmartSensorTester(federateConfig);
            federate.execute();

            System.exit(0);
        } catch (Exception e) {
            log.error("There was a problem executing the SmartSensorTester federate: {}", e.getMessage());
            log.error(e);

            System.exit(1);
        }
    }
}
