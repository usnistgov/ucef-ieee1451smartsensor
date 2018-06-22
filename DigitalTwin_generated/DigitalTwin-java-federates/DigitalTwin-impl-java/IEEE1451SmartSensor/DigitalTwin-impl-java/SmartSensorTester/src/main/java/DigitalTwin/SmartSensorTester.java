package DigitalTwin;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cpswt.config.FederateConfig;
import org.cpswt.config.FederateConfigParser;
import org.cpswt.hla.InteractionRoot;
import org.cpswt.hla.base.AdvanceTimeRequest;

/**
 * The SmartSensorTester type of federate for the federation designed in WebGME.
 *
 */
public class SmartSensorTester extends SmartSensorTesterBase {

    private final static Logger log = LogManager.getLogger(SmartSensorTester.class);
    
    public static final String TITLE = "Smart_Sensor_Tester";
	public static final int WIDTH = 540;
	public static final int HEIGHT = 360;
	public static final Dimension dim = new Dimension(540,360);

	private JFrame frame;
	private JButton readTransducerSampleDataFromAChannelOfATIMButton;
	private JButton readTransducerBlockDataFromAChannelOfATIMButton;
	private JButton readTransducerChannelIdTEDSButton;
	private JButton readTransducerChannelTEDSButton;
	private BoxLayout layout;
	private JLabel outputLabel;
	private JTextArea output;

    double currentTime = 0;

    public SmartSensorTester(FederateConfig params) throws Exception {
        super(params);
    }

    private void CheckReceivedSubscriptions(String s) {

        InteractionRoot interaction = null;
        while ((interaction = getNextInteractionNoWait()) != null) {
            if (interaction instanceof ReadTransducerSampleDataFromAChannelOfATIMResponse) {
                handleInteractionClass((ReadTransducerSampleDataFromAChannelOfATIMResponse) interaction);
            }
            else if (interaction instanceof ReadTransducerChannelIdTEDSResponse) {
                handleInteractionClass((ReadTransducerChannelIdTEDSResponse) interaction);
            }
            else if (interaction instanceof ReadTransducerChannelTEDSResponse) {
                handleInteractionClass((ReadTransducerChannelTEDSResponse) interaction);
            }
            else if (interaction instanceof ReadTransducerBlockDataFromAChannelOfATIMResponse) {
                handleInteractionClass((ReadTransducerBlockDataFromAChannelOfATIMResponse) interaction);
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
        
        // instantiations
 		frame = new JFrame(TITLE);
 		readTransducerSampleDataFromAChannelOfATIMButton = new JButton("ReadTransducerSampleDataFromAChannelOfATIMRequest");
 		readTransducerSampleDataFromAChannelOfATIMButton.setAlignmentX(Component.LEFT_ALIGNMENT);
 		readTransducerBlockDataFromAChannelOfATIMButton = new JButton("ReadTransducerBlockDataFromAChannelOfATIMRequest");
 		readTransducerBlockDataFromAChannelOfATIMButton.setAlignmentX(Component.LEFT_ALIGNMENT);
 		readTransducerChannelTEDSButton = new JButton("ReadTransducerChannelTEDSRequest");
 		readTransducerChannelTEDSButton.setAlignmentX(Component.LEFT_ALIGNMENT);
 		readTransducerChannelIdTEDSButton = new JButton("ReadTransducerChannelIdTEDSRequest");
 		readTransducerChannelIdTEDSButton.setAlignmentX(Component.LEFT_ALIGNMENT);
 		
 		layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
 		outputLabel = new JLabel("Output");
 		output = new JTextArea();
 		output.setWrapStyleWord(true);
 		output.setEditable(false);

 		// JFrame setup
 		frame.setMinimumSize(dim);
     	frame.getContentPane().setLayout(layout);
 		frame.setLocationRelativeTo(null);

 		frame.getContentPane().add(readTransducerSampleDataFromAChannelOfATIMButton);
 		frame.getContentPane().add(readTransducerBlockDataFromAChannelOfATIMButton);
 		frame.getContentPane().add(readTransducerChannelTEDSButton);
 		frame.getContentPane().add(readTransducerChannelIdTEDSButton);
 		frame.getContentPane().add(outputLabel);
 		frame.getContentPane().add(output);

 		frame.setVisible(true);

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

        readTransducerSampleDataFromAChannelOfATIMButton.addActionListener(e -> {
        	ReadTransducerSampleDataFromAChannelOfATIMRequest vReadTransducerSampleDataFromAChannelOfATIMRequest = create_ReadTransducerSampleDataFromAChannelOfATIMRequest();
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_CheckSum((short) 1);
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_Length((short) 1);
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_MessageID((short) 1);
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_MessageType((byte) 1);
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_Priority((byte) 1);
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_SequenceNo((short) 1);
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_SessionNo((byte) 1);
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_Status((byte) 1);
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_channelId(1);
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_ncapId(1);
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_samplingMode(1);
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_timId(1);
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_timeoutNsecs(1);
            vReadTransducerSampleDataFromAChannelOfATIMRequest.set_timeoutSecs(1);
            try {
				vReadTransducerSampleDataFromAChannelOfATIMRequest.sendInteraction(getLRC(), currentTime);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        
        });
        
        while (true) {
            currentTime += super.getStepSize();

            atr.requestSyncStart();
            enteredTimeGrantedState();

            ////////////////////////////////////////////////////////////////////////////////////////
            // TODO send interactions that must be sent every logical time step below.
            // Set the interaction's parameters.
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

    private void handleInteractionClass(ReadTransducerSampleDataFromAChannelOfATIMResponse interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    	
    	log.info(interaction.get_transducerSampleData());
    	output.setText(output.getText()+interaction.get_transducerSampleData()+"\n");
    }

    private void handleInteractionClass(ReadTransducerChannelIdTEDSResponse interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    private void handleInteractionClass(ReadTransducerChannelTEDSResponse interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    private void handleInteractionClass(ReadTransducerBlockDataFromAChannelOfATIMResponse interaction) {
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