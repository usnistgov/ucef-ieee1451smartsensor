package IEEE1451SmartSensorTester;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cpswt.config.FederateConfig;
import org.cpswt.config.FederateConfigParser;
import org.cpswt.hla.InteractionRoot;
import org.cpswt.hla.base.AdvanceTimeRequest;

/**
 * The IEEE1451SmartSensorTester type of federate for the federation designed in WebGME.
 *
 */
public class IEEE1451SmartSensorTester extends IEEE1451SmartSensorTesterBase {

    private final static Logger log = LogManager.getLogger(IEEE1451SmartSensorTester.class);

    private final static int RESET_SENSOR = 0;
	private final static int INPUT_VOLTAGE_OUT_OF_BOUNDS = 1;
	private final static int TEMPERATURE_OUT_OF_BOUNDS = 2;
	private static final int DISCONNECT_FROM_NETWORK = 3;

	public static final String TITLE = "Smart_Sensor_Tester";
	public static final int WIDTH = 540;
	public static final int HEIGHT = 360;
	public static final Dimension dim = new Dimension(540,360);

	private JFrame frame;
	private JButton readTransducerSampleDataFromAChannelOfATIMButton;
	private JButton readTransducerBlockDataFromAChannelOfATIMButton;
	private JButton readTransducerChannelIdTEDSButton;
	private JButton readTransducerChannelTEDSButton;
	private JButton initializeSensor;
	private JButton injectFault;
	private JButton clearOutput;
	private BoxLayout layout;
	private JLabel outputLabel;
	private JTextArea output;
	private JScrollPane sp;
    
    double currentTime = 0;

    public IEEE1451SmartSensorTester(FederateConfig params) throws Exception {
        super(params);
    }

    private void CheckReceivedSubscriptions(String s) {

        InteractionRoot interaction = null;
        while ((interaction = getNextInteractionNoWait()) != null) {
            if (interaction instanceof ReadTransducerBlockDataFromAChannelOfATIMResponse) {
                handleInteractionClass((ReadTransducerBlockDataFromAChannelOfATIMResponse) interaction);
            }
            else if (interaction instanceof ReadTransducerChannelTEDSResponse) {
                handleInteractionClass((ReadTransducerChannelTEDSResponse) interaction);
            }
            else if (interaction instanceof ReadTransducerChannelIdTEDSResponse) {
                handleInteractionClass((ReadTransducerChannelIdTEDSResponse) interaction);
            }
            else if (interaction instanceof ReadTransducerSampleDataFromAChannelOfATIMResponse) {
                handleInteractionClass((ReadTransducerSampleDataFromAChannelOfATIMResponse) interaction);
            }
            log.info("Interaction received and handled: " + s);
        }
     }

    private void execute() throws Exception {
        if(super.isLateJoiner()) {
            currentTime = super.getLBTS() - super.getLookAhead();
            super.disableTimeRegulation();
        }

        frame = new JFrame(TITLE);
		readTransducerSampleDataFromAChannelOfATIMButton = new JButton("ReadTransducerSampleDataFromAChannelOfATIMRequest");
		readTransducerSampleDataFromAChannelOfATIMButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		readTransducerBlockDataFromAChannelOfATIMButton = new JButton("ReadTransducerBlockDataFromAChannelOfATIMRequest");
		readTransducerBlockDataFromAChannelOfATIMButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		readTransducerChannelTEDSButton = new JButton("ReadTransducerChannelTEDSRequest");
		readTransducerChannelTEDSButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		readTransducerChannelIdTEDSButton = new JButton("ReadTransducerChannelIdTEDSRequest");
		readTransducerChannelIdTEDSButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		initializeSensor = new JButton("Initialize Sensor");
		initializeSensor.setAlignmentX(Component.LEFT_ALIGNMENT);
		injectFault = new JButton("Inject Fault");
		injectFault.setAlignmentX(Component.LEFT_ALIGNMENT);
		clearOutput = new JButton("Clear Output Window");
		clearOutput.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		outputLabel = new JLabel("Output");
		output = new JTextArea();
		output.setWrapStyleWord(true);
		output.setEditable(false);
		sp = new JScrollPane(output);

		// JFrame setup
		frame.setMinimumSize(dim);
		frame.getContentPane().setLayout(layout);
		frame.setLocationRelativeTo(null);

		frame.getContentPane().add(readTransducerSampleDataFromAChannelOfATIMButton);
		frame.getContentPane().add(readTransducerBlockDataFromAChannelOfATIMButton);
		frame.getContentPane().add(readTransducerChannelTEDSButton);
		frame.getContentPane().add(readTransducerChannelIdTEDSButton);
		frame.getContentPane().add(initializeSensor);
		frame.getContentPane().add(injectFault);
		frame.getContentPane().add(clearOutput);
		frame.getContentPane().add(outputLabel);
		frame.getContentPane().add(sp);

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
			vReadTransducerSampleDataFromAChannelOfATIMRequest.set_timeoutNsecs(0);
			vReadTransducerSampleDataFromAChannelOfATIMRequest.set_timeoutSecs(5);
			try {
				vReadTransducerSampleDataFromAChannelOfATIMRequest.sendInteraction(getLRC(), currentTime);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});
		
		readTransducerBlockDataFromAChannelOfATIMButton.addActionListener(e -> {
			ReadTransducerBlockDataFromAChannelOfATIMRequest request = create_ReadTransducerBlockDataFromAChannelOfATIMRequest();
			request.set_CheckSum((short) 1);
			request.set_Length((short) 1);
			request.set_MessageID((short) 1);
			request.set_MessageType((byte) 1);
			request.set_Priority((byte) 1);
			request.set_SequenceNo((short) 1);
			request.set_SessionNo((byte) 1);
			request.set_Status((byte) 1);
			request.set_channelId(1);
			request.set_ncapId(1);
			request.set_numberOfSamples(5);
			request.set_sampleIntervalNsecs(0);
			request.set_sampleIntervalSecs(5);
			request.set_startTimeNsecs(0);
			request.set_startTimeSecs(0);
			request.set_timId(1);
			request.set_timeoutNsecs(0);
			request.set_timeoutSecs(20);
			try {
				request.sendInteraction(getLRC(), currentTime);
			} catch (Exception e1) {
				log.error(e1);
			}
		});

		initializeSensor.addActionListener(e -> {
			InitializeSensor vInitializeSensor = create_InitializeSensor();
			JPanel jp = new JPanel();
			JLabel iv = new JLabel("Input Voltage");
			JLabel temp = new JLabel("Temperature");
			JTextField ivt = new JTextField("5");
			JTextField tempt = new JTextField("70");
			jp.add(iv);
			jp.add(ivt);
			jp.add(temp);
			jp.add(tempt);
			JOptionPane.showConfirmDialog(frame, jp, "Initialize Sensor: ", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
			try {
				vInitializeSensor.set_inputVoltage(Integer.parseInt(ivt.getText()));
			}
			catch (NumberFormatException e1) {
				vInitializeSensor.set_inputVoltage(5);
			}
			
			try {
				vInitializeSensor.set_realTemperature(Integer.parseInt(tempt.getText()));
			}
			catch (NumberFormatException e1) {
				vInitializeSensor.set_realTemperature(70);
			}

			try {
				vInitializeSensor.sendInteraction(getLRC(), currentTime);
			} catch (Exception e1) {
				log.error(e1);
			}
		});
		
		injectFault.addActionListener(e -> {
			FaultInjection vFaultInjection = create_FaultInjection();
			JPanel jp = new JPanel();
			JRadioButton reset = new JRadioButton("Reset Sensor", true);
			JRadioButton volt = new JRadioButton("Input Voltage Out Of Bounds");
			JRadioButton temp = new JRadioButton("Temperature Out Of Bounds");
			JRadioButton disconnect = new JRadioButton("Disconnect sensor from network");
			ButtonGroup bg = new ButtonGroup();
			bg.add(reset);
			bg.add(volt);
			bg.add(temp);
			bg.add(disconnect);
			jp.add(reset);
			jp.add(volt);
			jp.add(temp);
			jp.add(disconnect);
			JOptionPane.showConfirmDialog(frame, jp, "Inject Fault", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (reset.isSelected())
				vFaultInjection.set_FaultCode(RESET_SENSOR);
			else if (volt.isSelected())
				vFaultInjection.set_FaultCode(INPUT_VOLTAGE_OUT_OF_BOUNDS);
			else if (temp.isSelected())
				vFaultInjection.set_FaultCode(TEMPERATURE_OUT_OF_BOUNDS);
			else if (disconnect.isSelected())
				vFaultInjection.set_FaultCode(DISCONNECT_FROM_NETWORK);
				
		    try {
				vFaultInjection.sendInteraction(getLRC(), currentTime);
			} catch (Exception e1) {
				log.error(e1);
			}
		});
		
		clearOutput.addActionListener(e -> {
			output.setText("");
		});

        while (true) {
            currentTime += super.getStepSize();

            atr.requestSyncStart();
            enteredTimeGrantedState();

            ////////////////////////////////////////////////////////////////////////////////////////
            // TODO send interactions that must be sent every logical time step below.
            // Set the interaction's parameters.
            //
            //    InitializeSensor vInitializeSensor = create_InitializeSensor();
            //    vInitializeSensor.set_inputVoltage( < YOUR VALUE HERE > );
            //    vInitializeSensor.set_realTemperature( < YOUR VALUE HERE > );
            //    vInitializeSensor.sendInteraction(getLRC(), currentTime);
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
    	log.info("Received Reply: " + interaction.get_transducerSampleData());
		output.append("Sample Data:\n" + interaction.get_transducerSampleData() +"\n");
    }

    private void handleInteractionClass(ReadTransducerBlockDataFromAChannelOfATIMResponse interaction) {
    	String data = interaction.get_transducerBlockData();
		output.append("BlockData:\n" + data);
		log.info(data);
    }

    private void handleInteractionClass(ReadTransducerChannelTEDSResponse interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    private void handleInteractionClass(ReadTransducerChannelIdTEDSResponse interaction) {
        //////////////////////////////////////////////////////////////////////////
        // TODO implement how to handle reception of the interaction            //
        //////////////////////////////////////////////////////////////////////////
    }

    public static void main(String[] args) {
        try {
            FederateConfigParser federateConfigParser = new FederateConfigParser();
            FederateConfig federateConfig = federateConfigParser.parseArgs(args, FederateConfig.class);
            IEEE1451SmartSensorTester federate = new IEEE1451SmartSensorTester(federateConfig);
            federate.execute();

            System.exit(0);
        } catch (Exception e) {
            log.error("There was a problem executing the IEEE1451SmartSensorTester federate: {}", e.getMessage());
            log.error(e);

            System.exit(1);
        }
    }
}
