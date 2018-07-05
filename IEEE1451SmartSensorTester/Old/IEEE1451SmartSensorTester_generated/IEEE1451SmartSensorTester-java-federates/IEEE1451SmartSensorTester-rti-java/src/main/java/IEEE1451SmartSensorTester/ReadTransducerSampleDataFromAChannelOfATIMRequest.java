
package IEEE1451SmartSensorTester;

import java.util.HashSet;
import java.util.Set;

import hla.rti.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cpswt.utils.CpswtUtils;


import org.cpswt.hla.*;

/**
* The ReadTransducerSampleDataFromAChannelOfATIMRequest class implements the ReadTransducerSampleDataFromAChannelOfATIMRequest interaction in the
* IEEE1451SmartSensorTester simulation.
*/
public class ReadTransducerSampleDataFromAChannelOfATIMRequest extends C2WInteractionRoot {

	private static final Logger logger = LogManager.getLogger(ReadTransducerSampleDataFromAChannelOfATIMRequest.class);

	/**
	* Default constructor -- creates an instance of the ReadTransducerSampleDataFromAChannelOfATIMRequest interaction
	* class with default parameter values.
	*/
	public ReadTransducerSampleDataFromAChannelOfATIMRequest() { }

	
	
	private static int _CheckSum_handle;
	private static int _Length_handle;
	private static int _MessageID_handle;
	private static int _MessageType_handle;
	private static int _Priority_handle;
	private static int _SequenceNo_handle;
	private static int _SessionNo_handle;
	private static int _Status_handle;
	private static int _channelId_handle;
	private static int _ncapId_handle;
	private static int _samplingMode_handle;
	private static int _timId_handle;
	private static int _timeoutNsecs_handle;
	private static int _timeoutSecs_handle;
	
	
	/**
	* Returns the handle (RTI assigned) of the "CheckSum" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "CheckSum" parameter
	*/
	public static int get_CheckSum_handle() { return _CheckSum_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "Length" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "Length" parameter
	*/
	public static int get_Length_handle() { return _Length_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "MessageID" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "MessageID" parameter
	*/
	public static int get_MessageID_handle() { return _MessageID_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "MessageType" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "MessageType" parameter
	*/
	public static int get_MessageType_handle() { return _MessageType_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "Priority" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "Priority" parameter
	*/
	public static int get_Priority_handle() { return _Priority_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "SequenceNo" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "SequenceNo" parameter
	*/
	public static int get_SequenceNo_handle() { return _SequenceNo_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "SessionNo" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "SessionNo" parameter
	*/
	public static int get_SessionNo_handle() { return _SessionNo_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "Status" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "Status" parameter
	*/
	public static int get_Status_handle() { return _Status_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "channelId" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "channelId" parameter
	*/
	public static int get_channelId_handle() { return _channelId_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "ncapId" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "ncapId" parameter
	*/
	public static int get_ncapId_handle() { return _ncapId_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "samplingMode" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "samplingMode" parameter
	*/
	public static int get_samplingMode_handle() { return _samplingMode_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "timId" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "timId" parameter
	*/
	public static int get_timId_handle() { return _timId_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "timeoutNsecs" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "timeoutNsecs" parameter
	*/
	public static int get_timeoutNsecs_handle() { return _timeoutNsecs_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "timeoutSecs" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "timeoutSecs" parameter
	*/
	public static int get_timeoutSecs_handle() { return _timeoutSecs_handle; }
	
	
	
	private static boolean _isInitialized = false;

	private static int _handle;

	/**
	* Returns the handle (RTI assigned) of the ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class.
	* Note: As this is a static method, it is NOT polymorphic, and so, if called on
	* a reference will return the handle of the class pertaining to the reference,\
	* rather than the handle of the class for the instance referred to by the reference.
	* For the polymorphic version of this method, use {@link #getClassHandle()}.
	*/
	public static int get_handle() { return _handle; }

	/**
	* Returns the fully-qualified (dot-delimited) name of the ReadTransducerSampleDataFromAChannelOfATIMRequest
	* interaction class.
	* Note: As this is a static method, it is NOT polymorphic, and so, if called on
	* a reference will return the name of the class pertaining to the reference,\
	* rather than the name of the class for the instance referred to by the reference.
	* For the polymorphic version of this method, use {@link #getClassName()}.
	*/
	public static String get_class_name() { return "InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest"; }

	/**
	* Returns the simple name (the last name in the dot-delimited fully-qualified
	* class name) of the ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class.
	*/
	public static String get_simple_class_name() { return "ReadTransducerSampleDataFromAChannelOfATIMRequest"; }

	private static Set< String > _datamemberNames = new HashSet< String >();
	private static Set< String > _allDatamemberNames = new HashSet< String >();

	/**
	* Returns a set containing the names of all of the non-hidden parameters in the
	* ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class.
	* Note: As this is a static method, it is NOT polymorphic, and so, if called on
	* a reference will return a set of parameter names pertaining to the reference,\
	* rather than the parameter names of the class for the instance referred to by
	* the reference.  For the polymorphic version of this method, use
	* {@link #getParameterNames()}.
	*/
	public static Set< String > get_parameter_names() {
		return new HashSet< String >(_datamemberNames);
	}


	/**
	* Returns a set containing the names of all of the parameters in the
	* ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class.
	* Note: As this is a static method, it is NOT polymorphic, and so, if called on
	* a reference will return a set of parameter names pertaining to the reference,\
	* rather than the parameter names of the class for the instance referred to by
	* the reference.  For the polymorphic version of this method, use
	* {@link #getParameterNames()}.
	*/
	public static Set< String > get_all_parameter_names() {
		return new HashSet< String >(_allDatamemberNames);
	}


	

	static {
		_classNameSet.add("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest");
		_classNameClassMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest", ReadTransducerSampleDataFromAChannelOfATIMRequest.class);
		
		_datamemberClassNameSetMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest", _datamemberNames);
		_allDatamemberClassNameSetMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest", _allDatamemberNames);

		
		
		_datamemberNames.add("CheckSum");
		_datamemberNames.add("Length");
		_datamemberNames.add("MessageID");
		_datamemberNames.add("MessageType");
		_datamemberNames.add("Priority");
		_datamemberNames.add("SequenceNo");
		_datamemberNames.add("SessionNo");
		_datamemberNames.add("Status");
		
		_datamemberNames.add("channelId");
		
		_datamemberNames.add("ncapId");
		
		_datamemberNames.add("samplingMode");
		
		_datamemberNames.add("timId");
		_datamemberNames.add("timeoutNsecs");
		_datamemberNames.add("timeoutSecs");
		
		
		_allDatamemberNames.add("CheckSum");
		_allDatamemberNames.add("Length");
		_allDatamemberNames.add("MessageID");
		_allDatamemberNames.add("MessageType");
		_allDatamemberNames.add("Priority");
		_allDatamemberNames.add("SequenceNo");
		_allDatamemberNames.add("SessionNo");
		_allDatamemberNames.add("Status");
		_allDatamemberNames.add("actualLogicalGenerationTime");
		_allDatamemberNames.add("channelId");
		_allDatamemberNames.add("federateFilter");
		_allDatamemberNames.add("ncapId");
		_allDatamemberNames.add("originFed");
		_allDatamemberNames.add("samplingMode");
		_allDatamemberNames.add("sourceFed");
		_allDatamemberNames.add("timId");
		_allDatamemberNames.add("timeoutNsecs");
		_allDatamemberNames.add("timeoutSecs");
		
		
		_datamemberTypeMap.put("CheckSum", "short");
		_datamemberTypeMap.put("Length", "short");
		_datamemberTypeMap.put("MessageID", "short");
		_datamemberTypeMap.put("MessageType", "byte");
		_datamemberTypeMap.put("Priority", "byte");
		_datamemberTypeMap.put("SequenceNo", "short");
		_datamemberTypeMap.put("SessionNo", "byte");
		_datamemberTypeMap.put("Status", "byte");
		_datamemberTypeMap.put("channelId", "int");
		_datamemberTypeMap.put("ncapId", "int");
		_datamemberTypeMap.put("samplingMode", "int");
		_datamemberTypeMap.put("timId", "int");
		_datamemberTypeMap.put("timeoutNsecs", "long");
		_datamemberTypeMap.put("timeoutSecs", "long");
	
	

	}


	private static String initErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest:  could not initialize:  ";
	protected static void init(RTIambassador rti) {
		if (_isInitialized) return;
		_isInitialized = true;
		
		C2WInteractionRoot.init(rti);
		
		boolean isNotInitialized = true;
		while(isNotInitialized) {
			try {
				_handle = rti.getInteractionClassHandle("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest");
				isNotInitialized = false;
			} catch (FederateNotExecutionMember f) {
				logger.error("{} Federate Not Execution Member", initErrorMessage);
				logger.error(f);
				return;				
			} catch (NameNotFound n) {
				logger.error("{} Name Not Found", initErrorMessage);
				logger.error(n);
				return;				
			} catch (Exception e) {
				logger.error(e);
				CpswtUtils.sleepDefault();
			}
		}

		_classNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest", get_handle());
		_classHandleNameMap.put(get_handle(), "InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest");
		_classHandleSimpleNameMap.put(get_handle(), "ReadTransducerSampleDataFromAChannelOfATIMRequest");

		
		isNotInitialized = true;
		while(isNotInitialized) {
			try {
							
				_CheckSum_handle = rti.getParameterHandle("CheckSum", get_handle());			
				_Length_handle = rti.getParameterHandle("Length", get_handle());			
				_MessageID_handle = rti.getParameterHandle("MessageID", get_handle());			
				_MessageType_handle = rti.getParameterHandle("MessageType", get_handle());			
				_Priority_handle = rti.getParameterHandle("Priority", get_handle());			
				_SequenceNo_handle = rti.getParameterHandle("SequenceNo", get_handle());			
				_SessionNo_handle = rti.getParameterHandle("SessionNo", get_handle());			
				_Status_handle = rti.getParameterHandle("Status", get_handle());			
				_channelId_handle = rti.getParameterHandle("channelId", get_handle());			
				_ncapId_handle = rti.getParameterHandle("ncapId", get_handle());			
				_samplingMode_handle = rti.getParameterHandle("samplingMode", get_handle());			
				_timId_handle = rti.getParameterHandle("timId", get_handle());			
				_timeoutNsecs_handle = rti.getParameterHandle("timeoutNsecs", get_handle());			
				_timeoutSecs_handle = rti.getParameterHandle("timeoutSecs", get_handle());
				isNotInitialized = false;
			} catch (FederateNotExecutionMember f) {
				logger.error("{} Federate Not Execution Member", initErrorMessage);
				logger.error(f);
				return;
			} catch (InteractionClassNotDefined i) {
				logger.error("{} Interaction Class Not Defined", initErrorMessage);
				logger.error(i);
				return;
			} catch (NameNotFound n) {
				logger.error("{} Name Not Found", initErrorMessage);
				logger.error(n);
				return;
			} catch (Exception e) {
				logger.error(e);
				CpswtUtils.sleepDefault();
			}
		}
			
			
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,CheckSum", get_CheckSum_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,Length", get_Length_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,MessageID", get_MessageID_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,MessageType", get_MessageType_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,Priority", get_Priority_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,SequenceNo", get_SequenceNo_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,SessionNo", get_SessionNo_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,Status", get_Status_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,channelId", get_channelId_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,ncapId", get_ncapId_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,samplingMode", get_samplingMode_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,timId", get_timId_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,timeoutNsecs", get_timeoutNsecs_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest,timeoutSecs", get_timeoutSecs_handle());
			
			
		_datamemberHandleNameMap.put(get_CheckSum_handle(), "CheckSum");
		_datamemberHandleNameMap.put(get_Length_handle(), "Length");
		_datamemberHandleNameMap.put(get_MessageID_handle(), "MessageID");
		_datamemberHandleNameMap.put(get_MessageType_handle(), "MessageType");
		_datamemberHandleNameMap.put(get_Priority_handle(), "Priority");
		_datamemberHandleNameMap.put(get_SequenceNo_handle(), "SequenceNo");
		_datamemberHandleNameMap.put(get_SessionNo_handle(), "SessionNo");
		_datamemberHandleNameMap.put(get_Status_handle(), "Status");
		_datamemberHandleNameMap.put(get_channelId_handle(), "channelId");
		_datamemberHandleNameMap.put(get_ncapId_handle(), "ncapId");
		_datamemberHandleNameMap.put(get_samplingMode_handle(), "samplingMode");
		_datamemberHandleNameMap.put(get_timId_handle(), "timId");
		_datamemberHandleNameMap.put(get_timeoutNsecs_handle(), "timeoutNsecs");
		_datamemberHandleNameMap.put(get_timeoutSecs_handle(), "timeoutSecs");
		
	}

	private static boolean _isPublished = false;
	private static String publishErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest:  could not publish:  ";

	/**
	* Publishes the ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class for a federate.
	*
	* @param rti handle to the Local RTI Component
	*/
	public static void publish(RTIambassador rti) {
		if (_isPublished) return;
		
		init(rti);

	

		synchronized(rti) {
			boolean isNotPublished = true;
			while(isNotPublished) {
				try {
					rti.publishInteractionClass(get_handle());
					isNotPublished = false;
				} catch (FederateNotExecutionMember f) {
					logger.error("{} Federate Not Execution Member", publishErrorMessage);
					logger.error(f);
					return;
				} catch (InteractionClassNotDefined i) {
					logger.error("{} Interaction Class Not Defined", publishErrorMessage);
					logger.error(i);
					return;
				} catch (Exception e) {
					logger.error(e);
					CpswtUtils.sleepDefault();
				}
			}
		}
		
		_isPublished = true;
	}

	private static String unpublishErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest:  could not unpublish:  ";
	/**
	* Unpublishes the ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class for a federate.
	*
	* @param rti handle to the Local RTI Component
	*/
	public static void unpublish(RTIambassador rti) {
		if (!_isPublished) return;
		
		init(rti);
		synchronized(rti) {
			boolean isNotUnpublished = true;
			while(isNotUnpublished) {
				try {
					rti.unpublishInteractionClass(get_handle());
					isNotUnpublished = false;
				} catch (FederateNotExecutionMember f) {
					logger.error("{} Federate Not Execution Member", unpublishErrorMessage);
					logger.error(f);
					return;
				} catch (InteractionClassNotDefined i) {
					logger.error("{} Interaction Class Not Defined", unpublishErrorMessage);
					logger.error(i);
					return;
				} catch (InteractionClassNotPublished i) {
					logger.error("{} Interaction Class Not Published", unpublishErrorMessage);
					logger.error(i);
					return;
				} catch (Exception e) {
					logger.error(e);
					CpswtUtils.sleepDefault();
				}
			}
		}
		
		_isPublished = false;
	}

	private static boolean _isSubscribed = false;
	private static String subscribeErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest:  could not subscribe:  ";
	/**
	* Subscribes a federate to the ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class.
	*
	* @param rti handle to the Local RTI Component
	*/
	public static void subscribe(RTIambassador rti) {
		if (_isSubscribed) return;
		
		init(rti);
	
		
		synchronized(rti) {
			boolean isNotSubscribed = true;
			while(isNotSubscribed) {
				try {
					rti.subscribeInteractionClass(get_handle());
					isNotSubscribed = false;
				} catch (FederateNotExecutionMember f) {
					logger.error("{} Federate Not Execution Member", subscribeErrorMessage);
					logger.error(f);
					return;
				} catch (InteractionClassNotDefined i) {
					logger.error("{} Interaction Class Not Defined", subscribeErrorMessage);
					logger.error(i);
					return;
				} catch (Exception e) {
					logger.error(e);
					CpswtUtils.sleepDefault();
				}
			}
		}
		
		_isSubscribed = true;
	}

	private static String unsubscribeErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.ReadTransducerSampleDataFromAChannelOfATIMRequest:  could not unsubscribe:  ";
	/**
	* Unsubscribes a federate from the ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class.
	*
	* @param rti handle to the Local RTI Component
	*/
	public static void unsubscribe(RTIambassador rti) {
		if (!_isSubscribed) return;

		init(rti);
		synchronized(rti) {
			boolean isNotUnsubscribed = true;
			while(isNotUnsubscribed) {
				try {
					rti.unsubscribeInteractionClass(get_handle());
					isNotUnsubscribed = false;
				} catch (FederateNotExecutionMember f) {
					logger.error("{} Federate Not Execution Member", unsubscribeErrorMessage);
					logger.error(f);
					return;
				} catch (InteractionClassNotDefined i) {
					logger.error("{} Interaction Class Not Defined", unsubscribeErrorMessage);
					logger.error(i);
					return;
				} catch (InteractionClassNotSubscribed i) {
					logger.error("{} Interaction Class Not Subscribed", unsubscribeErrorMessage);
					logger.error(i);
					return;
				} catch (Exception e) {
					logger.error(e);
					CpswtUtils.sleepDefault();
				}
			}
		}
		
		_isSubscribed = false;
	}

	/**
	* Return true if "handle" is equal to the handle (RTI assigned) of this class
	* (that is, the ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class).
	*
	* @param handle handle to compare to the value of the handle (RTI assigned) of
	* this class (the ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class).
	* @return "true" if "handle" matches the value of the handle of this class
	* (that is, the ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class).
	*/
	public static boolean match(int handle) { return handle == get_handle(); }

	/**
	* Returns the handle (RTI assigned) of this instance's interaction class .
	* 
	* @return the handle (RTI assigned) if this instance's interaction class
	*/
	public int getClassHandle() { return get_handle(); }

	/**
	* Returns the fully-qualified (dot-delimited) name of this instance's interaction class.
	* 
	* @return the fully-qualified (dot-delimited) name of this instance's interaction class
	*/
	public String getClassName() { return get_class_name(); }

	/**
	* Returns the simple name (last name in its fully-qualified dot-delimited name)
	* of this instance's interaction class.
	* 
	* @return the simple name of this instance's interaction class 
	*/
	public String getSimpleClassName() { return get_simple_class_name(); }

	/**
	* Returns a set containing the names of all of the non-hiddenparameters of an
	* interaction class instance.
	*
	* @return set containing the names of all of the parameters of an
	* interaction class instance
	*/
	public Set< String > getParameterNames() { return get_parameter_names(); }

	/**
	* Returns a set containing the names of all of the parameters of an
	* interaction class instance.
	*
	* @return set containing the names of all of the parameters of an
	* interaction class instance
	*/
	public Set< String > getAllParameterNames() { return get_all_parameter_names(); }

	/**
	* Publishes the interaction class of this instance of the class for a federate.
	*
	* @param rti handle to the Local RTI Component
	*/
	public void publishInteraction(RTIambassador rti) { publish(rti); }

	/**
	* Unpublishes the interaction class of this instance of this class for a federate.
	*
	* @param rti handle to the Local RTI Component
	*/
	public void unpublishInteraction(RTIambassador rti) { unpublish(rti); }

	/**
	* Subscribes a federate to the interaction class of this instance of this class.
	*
	* @param rti handle to the Local RTI Component
	*/
	public void subscribeInteraction(RTIambassador rti) { subscribe(rti); }

	/**
	* Unsubscribes a federate from the interaction class of this instance of this class.
	*
	* @param rti handle to the Local RTI Component
	*/
	public void unsubscribeInteraction(RTIambassador rti) { unsubscribe(rti); }

	

	public String toString() {
		return "ReadTransducerSampleDataFromAChannelOfATIMRequest("
			
			
			+ "CheckSum:" + get_CheckSum()
			+ "," + "Length:" + get_Length()
			+ "," + "MessageID:" + get_MessageID()
			+ "," + "MessageType:" + get_MessageType()
			+ "," + "Priority:" + get_Priority()
			+ "," + "SequenceNo:" + get_SequenceNo()
			+ "," + "SessionNo:" + get_SessionNo()
			+ "," + "Status:" + get_Status()
			+ "," + "channelId:" + get_channelId()
			+ "," + "ncapId:" + get_ncapId()
			+ "," + "samplingMode:" + get_samplingMode()
			+ "," + "timId:" + get_timId()
			+ "," + "timeoutNsecs:" + get_timeoutNsecs()
			+ "," + "timeoutSecs:" + get_timeoutSecs()
			+ ")";
	}
	



	
	
	private short _CheckSum = 0;
	
	private short _Length = 0;
	
	private short _MessageID = 0;
	
	private byte _MessageType = 0;
	
	private byte _Priority = 0;
	
	private short _SequenceNo = 0;
	
	private byte _SessionNo = 0;
	
	private byte _Status = 0;
	
	private int _channelId = 0;
	
	private int _ncapId = 0;
	
	private int _samplingMode = 0;
	
	private int _timId = 0;
	
	private long _timeoutNsecs = 0;
	
	private long _timeoutSecs = 0;

	
	
	/**
	* Set the value of the "CheckSum" parameter to "value" for this parameter.
	*
	* @param value the new value for the "CheckSum" parameter
	*/
	public void set_CheckSum( short value ) { _CheckSum = value; }
	
	/**
	* Returns the value of the "CheckSum" parameter of this interaction.
	*
	* @return the value of the "CheckSum" parameter
	*/
	public short get_CheckSum() { return _CheckSum; }
	
	
	/**
	* Set the value of the "Length" parameter to "value" for this parameter.
	*
	* @param value the new value for the "Length" parameter
	*/
	public void set_Length( short value ) { _Length = value; }
	
	/**
	* Returns the value of the "Length" parameter of this interaction.
	*
	* @return the value of the "Length" parameter
	*/
	public short get_Length() { return _Length; }
	
	
	/**
	* Set the value of the "MessageID" parameter to "value" for this parameter.
	*
	* @param value the new value for the "MessageID" parameter
	*/
	public void set_MessageID( short value ) { _MessageID = value; }
	
	/**
	* Returns the value of the "MessageID" parameter of this interaction.
	*
	* @return the value of the "MessageID" parameter
	*/
	public short get_MessageID() { return _MessageID; }
	
	
	/**
	* Set the value of the "MessageType" parameter to "value" for this parameter.
	*
	* @param value the new value for the "MessageType" parameter
	*/
	public void set_MessageType( byte value ) { _MessageType = value; }
	
	/**
	* Returns the value of the "MessageType" parameter of this interaction.
	*
	* @return the value of the "MessageType" parameter
	*/
	public byte get_MessageType() { return _MessageType; }
	
	
	/**
	* Set the value of the "Priority" parameter to "value" for this parameter.
	*
	* @param value the new value for the "Priority" parameter
	*/
	public void set_Priority( byte value ) { _Priority = value; }
	
	/**
	* Returns the value of the "Priority" parameter of this interaction.
	*
	* @return the value of the "Priority" parameter
	*/
	public byte get_Priority() { return _Priority; }
	
	
	/**
	* Set the value of the "SequenceNo" parameter to "value" for this parameter.
	*
	* @param value the new value for the "SequenceNo" parameter
	*/
	public void set_SequenceNo( short value ) { _SequenceNo = value; }
	
	/**
	* Returns the value of the "SequenceNo" parameter of this interaction.
	*
	* @return the value of the "SequenceNo" parameter
	*/
	public short get_SequenceNo() { return _SequenceNo; }
	
	
	/**
	* Set the value of the "SessionNo" parameter to "value" for this parameter.
	*
	* @param value the new value for the "SessionNo" parameter
	*/
	public void set_SessionNo( byte value ) { _SessionNo = value; }
	
	/**
	* Returns the value of the "SessionNo" parameter of this interaction.
	*
	* @return the value of the "SessionNo" parameter
	*/
	public byte get_SessionNo() { return _SessionNo; }
	
	
	/**
	* Set the value of the "Status" parameter to "value" for this parameter.
	*
	* @param value the new value for the "Status" parameter
	*/
	public void set_Status( byte value ) { _Status = value; }
	
	/**
	* Returns the value of the "Status" parameter of this interaction.
	*
	* @return the value of the "Status" parameter
	*/
	public byte get_Status() { return _Status; }
	
	
	/**
	* Set the value of the "channelId" parameter to "value" for this parameter.
	*
	* @param value the new value for the "channelId" parameter
	*/
	public void set_channelId( int value ) { _channelId = value; }
	
	/**
	* Returns the value of the "channelId" parameter of this interaction.
	*
	* @return the value of the "channelId" parameter
	*/
	public int get_channelId() { return _channelId; }
	
	
	/**
	* Set the value of the "ncapId" parameter to "value" for this parameter.
	*
	* @param value the new value for the "ncapId" parameter
	*/
	public void set_ncapId( int value ) { _ncapId = value; }
	
	/**
	* Returns the value of the "ncapId" parameter of this interaction.
	*
	* @return the value of the "ncapId" parameter
	*/
	public int get_ncapId() { return _ncapId; }
	
	
	/**
	* Set the value of the "samplingMode" parameter to "value" for this parameter.
	*
	* @param value the new value for the "samplingMode" parameter
	*/
	public void set_samplingMode( int value ) { _samplingMode = value; }
	
	/**
	* Returns the value of the "samplingMode" parameter of this interaction.
	*
	* @return the value of the "samplingMode" parameter
	*/
	public int get_samplingMode() { return _samplingMode; }
	
	
	/**
	* Set the value of the "timId" parameter to "value" for this parameter.
	*
	* @param value the new value for the "timId" parameter
	*/
	public void set_timId( int value ) { _timId = value; }
	
	/**
	* Returns the value of the "timId" parameter of this interaction.
	*
	* @return the value of the "timId" parameter
	*/
	public int get_timId() { return _timId; }
	
	
	/**
	* Set the value of the "timeoutNsecs" parameter to "value" for this parameter.
	*
	* @param value the new value for the "timeoutNsecs" parameter
	*/
	public void set_timeoutNsecs( long value ) { _timeoutNsecs = value; }
	
	/**
	* Returns the value of the "timeoutNsecs" parameter of this interaction.
	*
	* @return the value of the "timeoutNsecs" parameter
	*/
	public long get_timeoutNsecs() { return _timeoutNsecs; }
	
	
	/**
	* Set the value of the "timeoutSecs" parameter to "value" for this parameter.
	*
	* @param value the new value for the "timeoutSecs" parameter
	*/
	public void set_timeoutSecs( long value ) { _timeoutSecs = value; }
	
	/**
	* Returns the value of the "timeoutSecs" parameter of this interaction.
	*
	* @return the value of the "timeoutSecs" parameter
	*/
	public long get_timeoutSecs() { return _timeoutSecs; }
	


	protected ReadTransducerSampleDataFromAChannelOfATIMRequest( ReceivedInteraction datamemberMap, boolean initFlag ) {
		super( datamemberMap, false );
		if ( initFlag ) setParameters( datamemberMap );
	}
	
	protected ReadTransducerSampleDataFromAChannelOfATIMRequest( ReceivedInteraction datamemberMap, LogicalTime logicalTime, boolean initFlag ) {
		super( datamemberMap, logicalTime, false );
		if ( initFlag ) setParameters( datamemberMap );
	}


	/**
	* Creates an instance of the ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class, using
	* "datamemberMap" to initialize its parameter values.
	* "datamemberMap" is usually acquired as an argument to an RTI federate
	* callback method, such as "receiveInteraction".
	*
	* @param datamemberMap data structure containing initial values for the
	* parameters of this new ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class instance
	*/
	public ReadTransducerSampleDataFromAChannelOfATIMRequest( ReceivedInteraction datamemberMap ) {
		this( datamemberMap, true );
	}
	
	/**
	* Like {@link #ReadTransducerSampleDataFromAChannelOfATIMRequest( ReceivedInteraction datamemberMap )}, except this
	* new ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class instance is given a timestamp of
	* "logicalTime".
	*
	* @param datamemberMap data structure containing initial values for the
	* parameters of this new ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class instance
	* @param logicalTime timestamp for this new ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class
	* instance
	*/
	public ReadTransducerSampleDataFromAChannelOfATIMRequest( ReceivedInteraction datamemberMap, LogicalTime logicalTime ) {
		this( datamemberMap, logicalTime, true );
	}

	/**
	* Creates a new ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class instance that is a duplicate
	* of the instance referred to by ReadTransducerSampleDataFromAChannelOfATIMRequest_var.
	*
	* @param ReadTransducerSampleDataFromAChannelOfATIMRequest_var ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class instance of which
	* this newly created ReadTransducerSampleDataFromAChannelOfATIMRequest interaction class instance will be a
	* duplicate
	*/
	public ReadTransducerSampleDataFromAChannelOfATIMRequest( ReadTransducerSampleDataFromAChannelOfATIMRequest ReadTransducerSampleDataFromAChannelOfATIMRequest_var ) {
		super( ReadTransducerSampleDataFromAChannelOfATIMRequest_var );
		
		
		set_CheckSum( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_CheckSum() );
		set_Length( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_Length() );
		set_MessageID( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_MessageID() );
		set_MessageType( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_MessageType() );
		set_Priority( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_Priority() );
		set_SequenceNo( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_SequenceNo() );
		set_SessionNo( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_SessionNo() );
		set_Status( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_Status() );
		set_channelId( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_channelId() );
		set_ncapId( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_ncapId() );
		set_samplingMode( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_samplingMode() );
		set_timId( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_timId() );
		set_timeoutNsecs( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_timeoutNsecs() );
		set_timeoutSecs( ReadTransducerSampleDataFromAChannelOfATIMRequest_var.get_timeoutSecs() );
	}


	/**
	* Returns the value of the parameter whose name is "datamemberName"
	* for this interaction.
	*
	* @param datamemberName name of parameter whose value is to be
	* returned
	* @return value of the parameter whose name is "datamemberName"
	* for this interaction
	*/
	public Object getParameter( String datamemberName ) {
		
		
		
		if (  "CheckSum".equals( datamemberName )  ) return new Short(get_CheckSum());
		else if (  "Length".equals( datamemberName )  ) return new Short(get_Length());
		else if (  "MessageID".equals( datamemberName )  ) return new Short(get_MessageID());
		else if (  "MessageType".equals( datamemberName )  ) return new Byte(get_MessageType());
		else if (  "Priority".equals( datamemberName )  ) return new Byte(get_Priority());
		else if (  "SequenceNo".equals( datamemberName )  ) return new Short(get_SequenceNo());
		else if (  "SessionNo".equals( datamemberName )  ) return new Byte(get_SessionNo());
		else if (  "Status".equals( datamemberName )  ) return new Byte(get_Status());
		else if (  "channelId".equals( datamemberName )  ) return new Integer(get_channelId());
		else if (  "ncapId".equals( datamemberName )  ) return new Integer(get_ncapId());
		else if (  "samplingMode".equals( datamemberName )  ) return new Integer(get_samplingMode());
		else if (  "timId".equals( datamemberName )  ) return new Integer(get_timId());
		else if (  "timeoutNsecs".equals( datamemberName )  ) return new Long(get_timeoutNsecs());
		else if (  "timeoutSecs".equals( datamemberName )  ) return new Long(get_timeoutSecs());
		else return super.getParameter( datamemberName );
	}
	
	/**
	* Returns the value of the parameter whose handle (RTI assigned)
	* is "datamemberHandle" for this interaction.
	*
	* @param datamemberHandle handle (RTI assigned) of parameter whose
	* value is to be returned
	* @return value of the parameter whose handle (RTI assigned) is
	* "datamemberHandle" for this interaction
	*/
	public Object getParameter( int datamemberHandle ) {
		
				
		
		if ( get_CheckSum_handle() == datamemberHandle ) return new Short(get_CheckSum());
		else if ( get_Length_handle() == datamemberHandle ) return new Short(get_Length());
		else if ( get_MessageID_handle() == datamemberHandle ) return new Short(get_MessageID());
		else if ( get_MessageType_handle() == datamemberHandle ) return new Byte(get_MessageType());
		else if ( get_Priority_handle() == datamemberHandle ) return new Byte(get_Priority());
		else if ( get_SequenceNo_handle() == datamemberHandle ) return new Short(get_SequenceNo());
		else if ( get_SessionNo_handle() == datamemberHandle ) return new Byte(get_SessionNo());
		else if ( get_Status_handle() == datamemberHandle ) return new Byte(get_Status());
		else if ( get_channelId_handle() == datamemberHandle ) return new Integer(get_channelId());
		else if ( get_ncapId_handle() == datamemberHandle ) return new Integer(get_ncapId());
		else if ( get_samplingMode_handle() == datamemberHandle ) return new Integer(get_samplingMode());
		else if ( get_timId_handle() == datamemberHandle ) return new Integer(get_timId());
		else if ( get_timeoutNsecs_handle() == datamemberHandle ) return new Long(get_timeoutNsecs());
		else if ( get_timeoutSecs_handle() == datamemberHandle ) return new Long(get_timeoutSecs());
		else return super.getParameter( datamemberHandle );
	}
	
	protected boolean setParameterAux( int param_handle, String val ) {
		boolean retval = true;		
		
			
		
		if ( param_handle == get_CheckSum_handle() ) set_CheckSum( Short.parseShort(val) );
		else if ( param_handle == get_Length_handle() ) set_Length( Short.parseShort(val) );
		else if ( param_handle == get_MessageID_handle() ) set_MessageID( Short.parseShort(val) );
		else if ( param_handle == get_MessageType_handle() ) set_MessageType( Byte.parseByte(val) );
		else if ( param_handle == get_Priority_handle() ) set_Priority( Byte.parseByte(val) );
		else if ( param_handle == get_SequenceNo_handle() ) set_SequenceNo( Short.parseShort(val) );
		else if ( param_handle == get_SessionNo_handle() ) set_SessionNo( Byte.parseByte(val) );
		else if ( param_handle == get_Status_handle() ) set_Status( Byte.parseByte(val) );
		else if ( param_handle == get_channelId_handle() ) set_channelId( Integer.parseInt(val) );
		else if ( param_handle == get_ncapId_handle() ) set_ncapId( Integer.parseInt(val) );
		else if ( param_handle == get_samplingMode_handle() ) set_samplingMode( Integer.parseInt(val) );
		else if ( param_handle == get_timId_handle() ) set_timId( Integer.parseInt(val) );
		else if ( param_handle == get_timeoutNsecs_handle() ) set_timeoutNsecs( Long.parseLong(val) );
		else if ( param_handle == get_timeoutSecs_handle() ) set_timeoutSecs( Long.parseLong(val) );
		else retval = super.setParameterAux( param_handle, val );
		
		return retval;
	}
	
	protected boolean setParameterAux( String datamemberName, String val ) {
		boolean retval = true;
		
			
		
		if (  "CheckSum".equals( datamemberName )  ) set_CheckSum( Short.parseShort(val) );
		else if (  "Length".equals( datamemberName )  ) set_Length( Short.parseShort(val) );
		else if (  "MessageID".equals( datamemberName )  ) set_MessageID( Short.parseShort(val) );
		else if (  "MessageType".equals( datamemberName )  ) set_MessageType( Byte.parseByte(val) );
		else if (  "Priority".equals( datamemberName )  ) set_Priority( Byte.parseByte(val) );
		else if (  "SequenceNo".equals( datamemberName )  ) set_SequenceNo( Short.parseShort(val) );
		else if (  "SessionNo".equals( datamemberName )  ) set_SessionNo( Byte.parseByte(val) );
		else if (  "Status".equals( datamemberName )  ) set_Status( Byte.parseByte(val) );
		else if (  "channelId".equals( datamemberName )  ) set_channelId( Integer.parseInt(val) );
		else if (  "ncapId".equals( datamemberName )  ) set_ncapId( Integer.parseInt(val) );
		else if (  "samplingMode".equals( datamemberName )  ) set_samplingMode( Integer.parseInt(val) );
		else if (  "timId".equals( datamemberName )  ) set_timId( Integer.parseInt(val) );
		else if (  "timeoutNsecs".equals( datamemberName )  ) set_timeoutNsecs( Long.parseLong(val) );
		else if (  "timeoutSecs".equals( datamemberName )  ) set_timeoutSecs( Long.parseLong(val) );	
		else retval = super.setParameterAux( datamemberName, val );
		
		return retval;
	}
	
	protected boolean setParameterAux( String datamemberName, Object val ) {
		boolean retval = true;
		
		
		
		if (  "CheckSum".equals( datamemberName )  ) set_CheckSum( (Short)val );
		else if (  "Length".equals( datamemberName )  ) set_Length( (Short)val );
		else if (  "MessageID".equals( datamemberName )  ) set_MessageID( (Short)val );
		else if (  "MessageType".equals( datamemberName )  ) set_MessageType( (Byte)val );
		else if (  "Priority".equals( datamemberName )  ) set_Priority( (Byte)val );
		else if (  "SequenceNo".equals( datamemberName )  ) set_SequenceNo( (Short)val );
		else if (  "SessionNo".equals( datamemberName )  ) set_SessionNo( (Byte)val );
		else if (  "Status".equals( datamemberName )  ) set_Status( (Byte)val );
		else if (  "channelId".equals( datamemberName )  ) set_channelId( (Integer)val );
		else if (  "ncapId".equals( datamemberName )  ) set_ncapId( (Integer)val );
		else if (  "samplingMode".equals( datamemberName )  ) set_samplingMode( (Integer)val );
		else if (  "timId".equals( datamemberName )  ) set_timId( (Integer)val );
		else if (  "timeoutNsecs".equals( datamemberName )  ) set_timeoutNsecs( (Long)val );
		else if (  "timeoutSecs".equals( datamemberName )  ) set_timeoutSecs( (Long)val );		
		else retval = super.setParameterAux( datamemberName, val );
		
		return retval;
	}

	protected SuppliedParameters createSuppliedDatamembers() {
		SuppliedParameters datamembers = super.createSuppliedDatamembers();

	
		
		
			datamembers.add( get_CheckSum_handle(), Short.toString(get_CheckSum()).getBytes() );
		
			datamembers.add( get_Length_handle(), Short.toString(get_Length()).getBytes() );
		
			datamembers.add( get_MessageID_handle(), Short.toString(get_MessageID()).getBytes() );
		
			datamembers.add( get_MessageType_handle(), Byte.toString(get_MessageType()).getBytes() );
		
			datamembers.add( get_Priority_handle(), Byte.toString(get_Priority()).getBytes() );
		
			datamembers.add( get_SequenceNo_handle(), Short.toString(get_SequenceNo()).getBytes() );
		
			datamembers.add( get_SessionNo_handle(), Byte.toString(get_SessionNo()).getBytes() );
		
			datamembers.add( get_Status_handle(), Byte.toString(get_Status()).getBytes() );
		
			datamembers.add( get_channelId_handle(), Integer.toString(get_channelId()).getBytes() );
		
			datamembers.add( get_ncapId_handle(), Integer.toString(get_ncapId()).getBytes() );
		
			datamembers.add( get_samplingMode_handle(), Integer.toString(get_samplingMode()).getBytes() );
		
			datamembers.add( get_timId_handle(), Integer.toString(get_timId()).getBytes() );
		
			datamembers.add( get_timeoutNsecs_handle(), Long.toString(get_timeoutNsecs()).getBytes() );
		
			datamembers.add( get_timeoutSecs_handle(), Long.toString(get_timeoutSecs()).getBytes() );
		
	
		return datamembers;
	}

	
	public void copyFrom( Object object ) {
		super.copyFrom( object );
		if ( object instanceof ReadTransducerSampleDataFromAChannelOfATIMRequest ) {
			ReadTransducerSampleDataFromAChannelOfATIMRequest data = (ReadTransducerSampleDataFromAChannelOfATIMRequest)object;
			
			
				_CheckSum = data._CheckSum;
				_Length = data._Length;
				_MessageID = data._MessageID;
				_MessageType = data._MessageType;
				_Priority = data._Priority;
				_SequenceNo = data._SequenceNo;
				_SessionNo = data._SessionNo;
				_Status = data._Status;
				_channelId = data._channelId;
				_ncapId = data._ncapId;
				_samplingMode = data._samplingMode;
				_timId = data._timId;
				_timeoutNsecs = data._timeoutNsecs;
				_timeoutSecs = data._timeoutSecs;
			
		}
	}
}
