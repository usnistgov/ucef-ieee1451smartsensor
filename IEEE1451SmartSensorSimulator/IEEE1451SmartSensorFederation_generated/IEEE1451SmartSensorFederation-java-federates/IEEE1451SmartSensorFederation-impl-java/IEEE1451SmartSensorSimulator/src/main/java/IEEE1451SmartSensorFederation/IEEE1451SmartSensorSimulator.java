package IEEE1451SmartSensorFederation;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cpswt.config.FederateConfig;
import org.cpswt.config.FederateConfigParser;
import org.cpswt.hla.InteractionRoot;
import org.cpswt.hla.base.AdvanceTimeRequest;

/**
 * The IEEE1451SmartSensor type of federate for the federation designed in WebGME.
 *
 */
public class IEEE1451SmartSensorSimulator extends IEEE1451SmartSensorSimulatorBase {

	private final static Logger log = LogManager.getLogger(IEEE1451SmartSensorSimulator.class);
	private final static String NAN = "" + 0.0/0.0;
	private final static int RESET_SENSOR = 0;
	private final static int INPUT_VOLTAGE_OUT_OF_BOUNDS = 1;
	private final static int TEMPERATURE_OUT_OF_BOUNDS = 2;
	private static final int DISCONNECT_FROM_NETWORK = 3;

	private final static int NO_ERROR = 0;
	private final static int SENSOR_NON_OPERABLE = 1;
	
	private static final String DISCONNETED_MESSAGE = "Sensor isn't connected to the network";
	private static final String FAILED_INTERACTION_MESSAGE = "Interaction Failed!";

	private TemperatureSensor sensor = new TemperatureSensor();
	private ChannelTEDS channelTEDS = ChannelTEDS.getLM35AChannelTEDS();
	private ChannelIDTEDS channelIDTEDS = ChannelIDTEDS.getLM35AChannelIDTEDS();
	private String data = "";

	double currentTime = 0;

	public IEEE1451SmartSensorSimulator(FederateConfig params) throws Exception {
		super(params);
	}

	private void CheckReceivedSubscriptions(String s) {

		InteractionRoot interaction = null;
		while ((interaction = getNextInteractionNoWait()) != null) {
			if (interaction instanceof ReadTransducerSampleDataFromAChannelOfATIMRequest) {
				handleInteractionClass((ReadTransducerSampleDataFromAChannelOfATIMRequest) interaction);
			}
			else if (interaction instanceof ReadTransducerChannelIdTEDSRequest) {
				handleInteractionClass((ReadTransducerChannelIdTEDSRequest) interaction);
			}
			else if (interaction instanceof ReadTransducerChannelTEDSRequest) {
				handleInteractionClass((ReadTransducerChannelTEDSRequest) interaction);
			}
			else if (interaction instanceof InitializeSensor) {
				handleInteractionClass((InitializeSensor) interaction);
			}
			else if (interaction instanceof FaultInjection) {
				handleInteractionClass((FaultInjection) interaction);
			}
			else if (interaction instanceof ReadTransducerBlockDataFromAChannelOfATIMRequest) {
				handleInteractionClass((ReadTransducerBlockDataFromAChannelOfATIMRequest) interaction);
			}
			log.info("Interaction received and handled: " + s);
		}
	}

	private void execute() throws Exception {
		if(super.isLateJoiner()) {
			currentTime = super.getLBTS() - super.getLookAhead();
			super.disableTimeRegulation();
		}
		sensor.setInputVoltage(5);
		sensor.setRealTemperature(70);

		AdvanceTimeRequest atr = new AdvanceTimeRequest(currentTime);
		putAdvanceTimeRequest(atr);

		if(!super.isLateJoiner()) {
			readyToPopulate();
		}

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
		ReadTransducerSampleDataFromAChannelOfATIMResponse vReadTransducerSampleDataFromAChannelOfATIMResponse = create_ReadTransducerSampleDataFromAChannelOfATIMResponse();
		vReadTransducerSampleDataFromAChannelOfATIMResponse.set_channelId(interaction.get_channelId());
		vReadTransducerSampleDataFromAChannelOfATIMResponse.set_errorCode(NO_ERROR);
		vReadTransducerSampleDataFromAChannelOfATIMResponse.set_ncapId(interaction.get_ncapId());
		vReadTransducerSampleDataFromAChannelOfATIMResponse.set_timId(interaction.get_timId());


		try {
			vReadTransducerSampleDataFromAChannelOfATIMResponse.set_transducerSampleData("" + sensor.getMeasuredTemperature());
		} catch (SensorNonOperableException e1) {
			vReadTransducerSampleDataFromAChannelOfATIMResponse.set_errorCode(SENSOR_NON_OPERABLE);
			vReadTransducerSampleDataFromAChannelOfATIMResponse.set_transducerSampleData(NAN);
		} catch (SensorDisconnectedException e) {
			log.error(DISCONNETED_MESSAGE);
		}

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
			log.error(FAILED_INTERACTION_MESSAGE);
		}

		log.info("Sending data");
	}

	private void handleInteractionClass(ReadTransducerBlockDataFromAChannelOfATIMRequest interaction) {
		ReadTransducerBlockDataFromAChannelOfATIMResponse vReadTransducerBlockDataFromAChannelOfATIMResponse = create_ReadTransducerBlockDataFromAChannelOfATIMResponse();
		vReadTransducerBlockDataFromAChannelOfATIMResponse.set_channelId(interaction.get_channelId());
		vReadTransducerBlockDataFromAChannelOfATIMResponse.set_errorCode(NO_ERROR);
		vReadTransducerBlockDataFromAChannelOfATIMResponse.set_ncapId(interaction.get_ncapId());
		vReadTransducerBlockDataFromAChannelOfATIMResponse.set_timId(interaction.get_timId());
		vReadTransducerBlockDataFromAChannelOfATIMResponse.set_CheckSum((short) 1);
		vReadTransducerBlockDataFromAChannelOfATIMResponse.set_Length((short) 1);
		vReadTransducerBlockDataFromAChannelOfATIMResponse.set_MessageID((short) 1);
		vReadTransducerBlockDataFromAChannelOfATIMResponse.set_MessageType((byte) 1);
		vReadTransducerBlockDataFromAChannelOfATIMResponse.set_Priority((byte) 1);
		vReadTransducerBlockDataFromAChannelOfATIMResponse.set_SequenceNo((byte) 1);
		vReadTransducerBlockDataFromAChannelOfATIMResponse.set_SessionNo((byte) 1);
		vReadTransducerBlockDataFromAChannelOfATIMResponse.set_Status((byte) 1);

		long rate = (long)(interaction.get_sampleIntervalSecs() + interaction.get_sampleIntervalNsecs() * Math.pow(10, -9)) / interaction.get_numberOfSamples();
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

		service.scheduleAtFixedRate(new Runnable() {
			int count = 0;
			@Override
			public void run() {
				count++;
				try {
					if (count >= interaction.get_numberOfSamples()) {
						data += sensor.getMeasuredTemperature() + "\n";
						log.info("Temperature: " + data);
						vReadTransducerBlockDataFromAChannelOfATIMResponse.set_transducerBlockData(data);
						vReadTransducerBlockDataFromAChannelOfATIMResponse.sendInteraction(getLRC(), currentTime);
						data = "";
						service.shutdown();
					}

					data += sensor.getMeasuredTemperature() + "\n";
				} catch (SensorNonOperableException e) {
					vReadTransducerBlockDataFromAChannelOfATIMResponse.set_errorCode(SENSOR_NON_OPERABLE);
					vReadTransducerBlockDataFromAChannelOfATIMResponse.set_transducerBlockData(NAN);
					try {
						vReadTransducerBlockDataFromAChannelOfATIMResponse.sendInteraction(getLRC(), currentTime);
					} catch (Exception e1) {
						log.error(FAILED_INTERACTION_MESSAGE);
						service.shutdown();
					}
					service.shutdown();
				} catch (SensorDisconnectedException e) {
					log.error(DISCONNETED_MESSAGE);
					service.shutdown();
				} catch (Exception e) {
					log.error(FAILED_INTERACTION_MESSAGE);
					service.shutdown();
				}
			}
		}, 0, rate, TimeUnit.SECONDS);
		log.info("Sending data");
    }

	private void handleInteractionClass(ReadTransducerChannelIdTEDSRequest interaction) {
		ReadTransducerChannelIdTEDSResponse vReadTransducerChannelIdTEDSResponse = create_ReadTransducerChannelIdTEDSResponse();
		vReadTransducerChannelIdTEDSResponse.set_errorCode(NO_ERROR);
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

	private void handleInteractionClass(ReadTransducerChannelTEDSRequest interaction) {
		ReadTransducerChannelTEDSResponse vReadTransducerChannelTEDSResponse = create_ReadTransducerChannelTEDSResponse();
		vReadTransducerChannelTEDSResponse.set_errorCode(NO_ERROR);
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

	private void handleInteractionClass(InitializeSensor interaction) {
		sensor.setInputVoltage(interaction.get_inputVoltage());
		sensor.setRealTemperature(interaction.get_realTemperature());
	}

	private void handleInteractionClass(FaultInjection interaction) {
		switch(interaction.get_FaultCode()) {

		case RESET_SENSOR: 
			sensor.reset();
			break;
		case INPUT_VOLTAGE_OUT_OF_BOUNDS:
			sensor.setInputVoltage(100);
			break;
		case TEMPERATURE_OUT_OF_BOUNDS:
			sensor.setRealTemperature(500);
			break;
		case DISCONNECT_FROM_NETWORK:
			sensor.disconnect();
		}
	}

	public static void main(String[] args) {
		try {
			FederateConfigParser federateConfigParser = new FederateConfigParser();
			FederateConfig federateConfig = federateConfigParser.parseArgs(args, FederateConfig.class);
			IEEE1451SmartSensorSimulator federate = new IEEE1451SmartSensorSimulator(federateConfig);
			federate.execute();

			System.exit(0);
		} catch (Exception e) {
			log.error("There was a problem executing the IEEE1451SmartSensor federate: {}", e.getMessage());
			log.error(e);

			System.exit(1);
		}
	}
}
