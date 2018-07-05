package IEEE1451SmartSensorFederation;

import hla.rti.EventRetractionHandle;
import hla.rti.LogicalTime;
import hla.rti.ReceivedInteraction;

import org.cpswt.hla.C2WInteractionRoot;
import org.cpswt.hla.InteractionRoot;
import org.cpswt.hla.SubscribedInteractionFilter;
import org.cpswt.hla.SynchronizedFederate;

import org.cpswt.config.FederateConfig;

import org.cpswt.*;

public class IEEE1451SmartSensorSimulatorBase extends SynchronizedFederate {

	private SubscribedInteractionFilter _subscribedInteractionFilter = new SubscribedInteractionFilter();
	
	// constructor
	public IEEE1451SmartSensorSimulatorBase(FederateConfig config) throws Exception {
		super(config);

		super.createLRC();
		super.joinFederation();

		enableTimeConstrained();

		enableTimeRegulation(getLookAhead());
		enableAsynchronousDelivery();
        // interaction pubsub
        
        ReadTransducerChannelTEDSResponse.publish(getLRC());
        ReadTransducerSampleDataFromAChannelOfATIMResponse.publish(getLRC());
        ReadTransducerChannelIdTEDSResponse.publish(getLRC());
        ReadTransducerBlockDataFromAChannelOfATIMResponse.publish(getLRC());
        
        ReadTransducerBlockDataFromAChannelOfATIMRequest.subscribe(getLRC());
        _subscribedInteractionFilter.setFedFilters( 
			ReadTransducerBlockDataFromAChannelOfATIMRequest.get_handle(), 
			SubscribedInteractionFilter.OriginFedFilter.ORIGIN_FILTER_DISABLED, 
			SubscribedInteractionFilter.SourceFedFilter.SOURCE_FILTER_DISABLED 
		);
        ReadTransducerSampleDataFromAChannelOfATIMRequest.subscribe(getLRC());
        _subscribedInteractionFilter.setFedFilters( 
			ReadTransducerSampleDataFromAChannelOfATIMRequest.get_handle(), 
			SubscribedInteractionFilter.OriginFedFilter.ORIGIN_FILTER_DISABLED, 
			SubscribedInteractionFilter.SourceFedFilter.SOURCE_FILTER_DISABLED 
		);
        ReadTransducerChannelTEDSRequest.subscribe(getLRC());
        _subscribedInteractionFilter.setFedFilters( 
			ReadTransducerChannelTEDSRequest.get_handle(), 
			SubscribedInteractionFilter.OriginFedFilter.ORIGIN_FILTER_DISABLED, 
			SubscribedInteractionFilter.SourceFedFilter.SOURCE_FILTER_DISABLED 
		);
        ReadTransducerChannelIdTEDSRequest.subscribe(getLRC());
        _subscribedInteractionFilter.setFedFilters( 
			ReadTransducerChannelIdTEDSRequest.get_handle(), 
			SubscribedInteractionFilter.OriginFedFilter.ORIGIN_FILTER_DISABLED, 
			SubscribedInteractionFilter.SourceFedFilter.SOURCE_FILTER_DISABLED 
		);
        FaultInjection.subscribe(getLRC());
        _subscribedInteractionFilter.setFedFilters( 
			FaultInjection.get_handle(), 
			SubscribedInteractionFilter.OriginFedFilter.ORIGIN_FILTER_DISABLED, 
			SubscribedInteractionFilter.SourceFedFilter.SOURCE_FILTER_DISABLED 
		);
        InitializeSensor.subscribe(getLRC());
        _subscribedInteractionFilter.setFedFilters( 
			InitializeSensor.get_handle(), 
			SubscribedInteractionFilter.OriginFedFilter.ORIGIN_FILTER_DISABLED, 
			SubscribedInteractionFilter.SourceFedFilter.SOURCE_FILTER_DISABLED 
		);		
		// object pubsub
                	}
        
	
	public ReadTransducerChannelTEDSResponse create_ReadTransducerChannelTEDSResponse() {
	   ReadTransducerChannelTEDSResponse interaction = new ReadTransducerChannelTEDSResponse();
	   interaction.set_sourceFed( getFederateId() );
	   interaction.set_originFed( getFederateId() );
	   return interaction;
	}
	public ReadTransducerSampleDataFromAChannelOfATIMResponse create_ReadTransducerSampleDataFromAChannelOfATIMResponse() {
	   ReadTransducerSampleDataFromAChannelOfATIMResponse interaction = new ReadTransducerSampleDataFromAChannelOfATIMResponse();
	   interaction.set_sourceFed( getFederateId() );
	   interaction.set_originFed( getFederateId() );
	   return interaction;
	}
	public ReadTransducerChannelIdTEDSResponse create_ReadTransducerChannelIdTEDSResponse() {
	   ReadTransducerChannelIdTEDSResponse interaction = new ReadTransducerChannelIdTEDSResponse();
	   interaction.set_sourceFed( getFederateId() );
	   interaction.set_originFed( getFederateId() );
	   return interaction;
	}
	public ReadTransducerBlockDataFromAChannelOfATIMResponse create_ReadTransducerBlockDataFromAChannelOfATIMResponse() {
	   ReadTransducerBlockDataFromAChannelOfATIMResponse interaction = new ReadTransducerBlockDataFromAChannelOfATIMResponse();
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
