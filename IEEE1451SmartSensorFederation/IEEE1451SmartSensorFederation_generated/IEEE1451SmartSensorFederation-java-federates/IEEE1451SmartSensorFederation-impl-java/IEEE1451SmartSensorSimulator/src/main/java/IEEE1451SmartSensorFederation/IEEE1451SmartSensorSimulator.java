package IEEE1451SmartSensorFederation;

import org.cpswt.config.FederateConfig;
import org.cpswt.config.FederateConfigParser;
import org.cpswt.hla.InteractionRoot;
import org.cpswt.hla.base.AdvanceTimeRequest;
import org.cpswt.utils.CpswtDefaults;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The IEEE1451SmartSensorSimulator type of federate for the federation designed in WebGME.
 *
 */
public class IEEE1451SmartSensorSimulator extends IEEE1451SmartSensorSimulatorBase {

    private final static Logger log = LogManager.getLogger(IEEE1451SmartSensorSimulator.class);

    double currentTime = 0;

    public IEEE1451SmartSensorSimulator(FederateConfig params) throws Exception {
        super(params);
    }

    private void CheckReceivedSubscriptions(String s) {

        InteractionRoot interaction = null;
        while ((interaction = getNextInteractionNoWait()) != null) {
            if (interaction instanceof ReadTransducerBlockDataFromAChannelOfATIMRequest) {
                handleInteractionClass((ReadTransducerBlockDataFromAChannelOfATIMRequest) interaction);
            }
            else if (interaction instanceof ReadTransducerSampleDataFromAChannelOfATIMRequest) {
                handleInteractionClass((ReadTransducerSampleDataFromAChannelOfATIMRequest) interaction);
            }
            else if (interaction instanceof ReadTransducerChannelTEDSRequest) {
                handleInteractionClass((ReadTransducerChannelTEDSRequest) interaction);
            }
            else if (interaction instanceof ReadTransducerChannelIdTEDSRequest) {
                handleInteractionClass((ReadTransducerChannelIdTEDSRequest) interaction);
            }
            else if (interaction instanceof FaultInjection) {
                handleInteractionClass((FaultInjection) interaction);
            }
            else if (interaction instanceof InitializeSensor) {
                handleInteractionClass((InitializeSensor) interaction);
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

    private void handleInteractionClass(ReadTransducerBlockDataFromAChannelOfATIMRequest interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    private void handleInteractionClass(ReadTransducerSampleDataFromAChannelOfATIMRequest interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    private void handleInteractionClass(ReadTransducerChannelTEDSRequest interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    private void handleInteractionClass(ReadTransducerChannelIdTEDSRequest interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    private void handleInteractionClass(FaultInjection interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    private void handleInteractionClass(InitializeSensor interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    public static void main(String[] args) {
        try {
            FederateConfigParser federateConfigParser = new FederateConfigParser();
            FederateConfig federateConfig = federateConfigParser.parseArgs(args, FederateConfig.class);
            IEEE1451SmartSensorSimulator federate = new IEEE1451SmartSensorSimulator(federateConfig);
            federate.execute();

            System.exit(0);
        } catch (Exception e) {
            log.error("There was a problem executing the IEEE1451SmartSensorSimulator federate: {}", e.getMessage());
            log.error(e);

            System.exit(1);
        }
    }
}
