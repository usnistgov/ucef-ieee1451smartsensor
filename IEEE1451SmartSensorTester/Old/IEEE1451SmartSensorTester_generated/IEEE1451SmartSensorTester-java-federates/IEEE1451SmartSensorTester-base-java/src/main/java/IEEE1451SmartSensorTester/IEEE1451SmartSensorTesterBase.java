package IEEE1451SmartSensorTester;

import hla.rti.EventRetractionHandle;
import hla.rti.LogicalTime;
import hla.rti.ReceivedInteraction;

import org.cpswt.hla.C2WInteractionRoot;
import org.cpswt.hla.InteractionRoot;
import org.cpswt.hla.SubscribedInteractionFilter;
import org.cpswt.hla.SynchronizedFederate;

import org.cpswt.config.FederateConfig;

import org.cpswt.*;

public class IEEE1451SmartSensorTesterBase extends SynchronizedFederate {

	private SubscribedInteractionFilter _subscribedInteractionFilter = new SubscribedInteractionFilter();
	
	// constructor
	public IEEE1451SmartSensorTesterBase(FederateConfig config) throws Exception {
		super(config);

		super.createLRC();
		super.joinFederation();

		enableTimeConstrained();

		enableTimeRegulation(getLookAhead());
		enableAsynchronousDelivery();
        // interaction pubsub
        
        InitializeSensor.publish(getLRC());
        ReadTransducerBlockDataFromAChannelOfATIMRequest.publish(getLRC());
        ReadTransducerChannelTEDSRequest.publish(getLRC());
        FaultInjection.publish(getLRC());
        ReadTransducerChannelIdTEDSRequest.publish(getLRC());
        ReadTransducerSampleDataFromAChannelOfATIMRequest.publish(getLRC());
        
        ReadTransducerBlockDataFromAChannelOfATIMResponse.subscribe(getLRC());
        _subscribedInteractionFilter.setFedFilters( 
			ReadTransducerBlockDataFromAChannelOfATIMResponse.get_handle(), 
			SubscribedInteractionFilter.OriginFedFilter.ORIGIN_FILTER_DISABLED, 
			SubscribedInteractionFilter.SourceFedFilter.SOURCE_FILTER_DISABLED 
		);
        ReadTransducerChannelTEDSResponse.subscribe(getLRC());
        _subscribedInteractionFilter.setFedFilters( 
			ReadTransducerChannelTEDSResponse.get_handle(), 
			SubscribedInteractionFilter.OriginFedFilter.ORIGIN_FILTER_DISABLED, 
			SubscribedInteractionFilter.SourceFedFilter.SOURCE_FILTER_DISABLED 
		);
        ReadTransducerChannelIdTEDSResponse.subscribe(getLRC());
        _subscribedInteractionFilter.setFedFilters( 
			ReadTransducerChannelIdTEDSResponse.get_handle(), 
			SubscribedInteractionFilter.OriginFedFilter.ORIGIN_FILTER_DISABLED, 
			SubscribedInteractionFilter.SourceFedFilter.SOURCE_FILTER_DISABLED 
		);
        ReadTransducerSampleDataFromAChannelOfATIMResponse.subscribe(getLRC());
        _subscribedInteractionFilter.setFedFilters( 
			ReadTransducerSampleDataFromAChannelOfATIMResponse.get_handle(), 
			SubscribedInteractionFilter.OriginFedFilter.ORIGIN_FILTER_DISABLED, 
			SubscribedInteractionFilter.SourceFedFilter.SOURCE_FILTER_DISABLED 
		);		
		// object pubsub
                	}
        
	
	public InitializeSensor create_InitializeSensor() {
	   InitializeSensor interaction = new InitializeSensor();
	   interaction.set_sourceFed( getFederateId() );
	   interaction.set_originFed( getFederateId() );
	   return interaction;
	}
	public ReadTransducerBlockDataFromAChannelOfATIMRequest create_ReadTransducerBlockDataFromAChannelOfATIMRequest() {
	   ReadTransducerBlockDataFromAChannelOfATIMRequest interaction = new ReadTransducerBlockDataFromAChannelOfATIMRequest();
	   interaction.set_sourceFed( getFederateId() );
	   interaction.set_originFed( getFederateId() );
	   return interaction;
	}
	public ReadTransducerChannelTEDSRequest create_ReadTransducerChannelTEDSRequest() {
	   ReadTransducerChannelTEDSRequest interaction = new ReadTransducerChannelTEDSRequest();
	   interaction.set_sourceFed( getFederateId() );
	   interaction.set_originFed( getFederateId() );
	   return interaction;
	}
	public FaultInjection create_FaultInjection() {
	   FaultInjection interaction = new FaultInjection();
	   interaction.set_sourceFed( getFederateId() );
	   interaction.set_originFed( getFederateId() );
	   return interaction;
	}
	public ReadTransducerChannelIdTEDSRequest create_ReadTransducerChannelIdTEDSRequest() {
	   ReadTransducerChannelIdTEDSRequest interaction = new ReadTransducerChannelIdTEDSRequest();
	   interaction.set_sourceFed( getFederateId() );
	   interaction.set_originFed( getFederateId() );
	   return interaction;
	}
	public ReadTransducerSampleDataFromAChannelOfATIMRequest create_ReadTransducerSampleDataFromAChannelOfATIMRequest() {
	   ReadTransducerSampleDataFromAChannelOfATIMRequest interaction = new ReadTransducerSampleDataFromAChannelOfATIMRequest();
	   interaction.set_sourceFed( getFederateId() );
	   interaction.set_originFed( getFederateId() );
	   return interaction;
	}
	@Override
	public void receiveInteraction(
	 int interactionClass, ReceivedInteraction theInteraction, byte[] userSuppliedTag
	) {
		InteractionRoot interactionRoot = InteractionRoot.create_interaction( interactionClass, theInteraction );
		if ( interactionRoot instanceof C2WInteractionRoot ) {
			
			C2WInteractionRoot c2wInteractionRoot = (C2WInteractionRoot)interactionRoot;

	        // Filter interaction if src/origin fed requirements (if any) are not met
	        if (  _subscribedInteractionFilter.filterC2WInteraction( getFederateId(), c2wInteractionRoot )  ) {
	        	return;
	        } 
		}
		
		super.receiveInteraction( interactionClass, theInteraction, userSuppliedTag );			
	}

	@Override
	public void receiveInteraction(
	 int interactionClass,
	 ReceivedInteraction theInteraction,
	 byte[] userSuppliedTag,
	 LogicalTime theTime,
	 EventRetractionHandle retractionHandle
	) {
		InteractionRoot interactionRoot = InteractionRoot.create_interaction( interactionClass, theInteraction, theTime );
		if ( interactionRoot instanceof C2WInteractionRoot ) {

			C2WInteractionRoot c2wInteractionRoot = (C2WInteractionRoot)interactionRoot;

	        // Filter interaction if src/origin fed requirements (if any) are not met
	        if (  _subscribedInteractionFilter.filterC2WInteraction( getFederateId(), c2wInteractionRoot )  ) {
	        	return;
	        } 
		}

		super.receiveInteraction( interactionClass, theInteraction, userSuppliedTag, theTime, retractionHandle );			
	}
}
