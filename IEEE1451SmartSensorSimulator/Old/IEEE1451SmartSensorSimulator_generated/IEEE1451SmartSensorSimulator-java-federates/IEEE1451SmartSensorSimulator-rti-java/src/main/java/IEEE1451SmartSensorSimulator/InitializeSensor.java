
package IEEE1451SmartSensorSimulator;

import java.util.HashSet;
import java.util.Set;

import hla.rti.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cpswt.utils.CpswtUtils;


import org.cpswt.hla.*;

/**
* The InitializeSensor class implements the InitializeSensor interaction in the
* IEEE1451SmartSensorSimulator simulation.
*/
public class InitializeSensor extends C2WInteractionRoot {

	private static final Logger logger = LogManager.getLogger(InitializeSensor.class);

	/**
	* Default constructor -- creates an instance of the InitializeSensor interaction
	* class with default parameter values.
	*/
	public InitializeSensor() { }

	
	
	private static int _inputVoltage_handle;
	private static int _realTemperature_handle;
	
	
	/**
	* Returns the handle (RTI assigned) of the "inputVoltage" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "inputVoltage" parameter
	*/
	public static int get_inputVoltage_handle() { return _inputVoltage_handle; }
	
	/**
	* Returns the handle (RTI assigned) of the "realTemperature" parameter of
	* its containing interaction class.
	*
	* @return the handle (RTI assigned) of the "realTemperature" parameter
	*/
	public static int get_realTemperature_handle() { return _realTemperature_handle; }
	
	
	
	private static boolean _isInitialized = false;

	private static int _handle;

	/**
	* Returns the handle (RTI assigned) of the InitializeSensor interaction class.
	* Note: As this is a static method, it is NOT polymorphic, and so, if called on
	* a reference will return the handle of the class pertaining to the reference,\
	* rather than the handle of the class for the instance referred to by the reference.
	* For the polymorphic version of this method, use {@link #getClassHandle()}.
	*/
	public static int get_handle() { return _handle; }

	/**
	* Returns the fully-qualified (dot-delimited) name of the InitializeSensor
	* interaction class.
	* Note: As this is a static method, it is NOT polymorphic, and so, if called on
	* a reference will return the name of the class pertaining to the reference,\
	* rather than the name of the class for the instance referred to by the reference.
	* For the polymorphic version of this method, use {@link #getClassName()}.
	*/
	public static String get_class_name() { return "InteractionRoot.C2WInteractionRoot.InitializeSensor"; }

	/**
	* Returns the simple name (the last name in the dot-delimited fully-qualified
	* class name) of the InitializeSensor interaction class.
	*/
	public static String get_simple_class_name() { return "InitializeSensor"; }

	private static Set< String > _datamemberNames = new HashSet< String >();
	private static Set< String > _allDatamemberNames = new HashSet< String >();

	/**
	* Returns a set containing the names of all of the non-hidden parameters in the
	* InitializeSensor interaction class.
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
	* InitializeSensor interaction class.
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
		_classNameSet.add("InteractionRoot.C2WInteractionRoot.InitializeSensor");
		_classNameClassMap.put("InteractionRoot.C2WInteractionRoot.InitializeSensor", InitializeSensor.class);
		
		_datamemberClassNameSetMap.put("InteractionRoot.C2WInteractionRoot.InitializeSensor", _datamemberNames);
		_allDatamemberClassNameSetMap.put("InteractionRoot.C2WInteractionRoot.InitializeSensor", _allDatamemberNames);

		
		
		
		
		_datamemberNames.add("inputVoltage");
		
		_datamemberNames.add("realTemperature");
		
		
		
		_allDatamemberNames.add("actualLogicalGenerationTime");
		_allDatamemberNames.add("federateFilter");
		_allDatamemberNames.add("inputVoltage");
		_allDatamemberNames.add("originFed");
		_allDatamemberNames.add("realTemperature");
		_allDatamemberNames.add("sourceFed");
		
		
		_datamemberTypeMap.put("inputVoltage", "int");
		_datamemberTypeMap.put("realTemperature", "int");
	
	

	}


	private static String initErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.InitializeSensor:  could not initialize:  ";
	protected static void init(RTIambassador rti) {
		if (_isInitialized) return;
		_isInitialized = true;
		
		C2WInteractionRoot.init(rti);
		
		boolean isNotInitialized = true;
		while(isNotInitialized) {
			try {
				_handle = rti.getInteractionClassHandle("InteractionRoot.C2WInteractionRoot.InitializeSensor");
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

		_classNameHandleMap.put("InteractionRoot.C2WInteractionRoot.InitializeSensor", get_handle());
		_classHandleNameMap.put(get_handle(), "InteractionRoot.C2WInteractionRoot.InitializeSensor");
		_classHandleSimpleNameMap.put(get_handle(), "InitializeSensor");

		
		isNotInitialized = true;
		while(isNotInitialized) {
			try {
							
				_inputVoltage_handle = rti.getParameterHandle("inputVoltage", get_handle());			
				_realTemperature_handle = rti.getParameterHandle("realTemperature", get_handle());
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
			
			
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.InitializeSensor,inputVoltage", get_inputVoltage_handle());
		_datamemberNameHandleMap.put("InteractionRoot.C2WInteractionRoot.InitializeSensor,realTemperature", get_realTemperature_handle());
			
			
		_datamemberHandleNameMap.put(get_inputVoltage_handle(), "inputVoltage");
		_datamemberHandleNameMap.put(get_realTemperature_handle(), "realTemperature");
		
	}

	private static boolean _isPublished = false;
	private static String publishErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.InitializeSensor:  could not publish:  ";

	/**
	* Publishes the InitializeSensor interaction class for a federate.
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

	private static String unpublishErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.InitializeSensor:  could not unpublish:  ";
	/**
	* Unpublishes the InitializeSensor interaction class for a federate.
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
	private static String subscribeErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.InitializeSensor:  could not subscribe:  ";
	/**
	* Subscribes a federate to the InitializeSensor interaction class.
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

	private static String unsubscribeErrorMessage = "Error:  InteractionRoot.C2WInteractionRoot.InitializeSensor:  could not unsubscribe:  ";
	/**
	* Unsubscribes a federate from the InitializeSensor interaction class.
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
	* (that is, the InitializeSensor interaction class).
	*
	* @param handle handle to compare to the value of the handle (RTI assigned) of
	* this class (the InitializeSensor interaction class).
	* @return "true" if "handle" matches the value of the handle of this class
	* (that is, the InitializeSensor interaction class).
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
		return "InitializeSensor("
			
			
			+ "inputVoltage:" + get_inputVoltage()
			+ "," + "realTemperature:" + get_realTemperature()
			+ ")";
	}
	



	
	
	private int _inputVoltage = 0;
	
	private int _realTemperature = 0;

	
	
	/**
	* Set the value of the "inputVoltage" parameter to "value" for this parameter.
	*
	* @param value the new value for the "inputVoltage" parameter
	*/
	public void set_inputVoltage( int value ) { _inputVoltage = value; }
	
	/**
	* Returns the value of the "inputVoltage" parameter of this interaction.
	*
	* @return the value of the "inputVoltage" parameter
	*/
	public int get_inputVoltage() { return _inputVoltage; }
	
	
	/**
	* Set the value of the "realTemperature" parameter to "value" for this parameter.
	*
	* @param value the new value for the "realTemperature" parameter
	*/
	public void set_realTemperature( int value ) { _realTemperature = value; }
	
	/**
	* Returns the value of the "realTemperature" parameter of this interaction.
	*
	* @return the value of the "realTemperature" parameter
	*/
	public int get_realTemperature() { return _realTemperature; }
	


	protected InitializeSensor( ReceivedInteraction datamemberMap, boolean initFlag ) {
		super( datamemberMap, false );
		if ( initFlag ) setParameters( datamemberMap );
	}
	
	protected InitializeSensor( ReceivedInteraction datamemberMap, LogicalTime logicalTime, boolean initFlag ) {
		super( datamemberMap, logicalTime, false );
		if ( initFlag ) setParameters( datamemberMap );
	}


	/**
	* Creates an instance of the InitializeSensor interaction class, using
	* "datamemberMap" to initialize its parameter values.
	* "datamemberMap" is usually acquired as an argument to an RTI federate
	* callback method, such as "receiveInteraction".
	*
	* @param datamemberMap data structure containing initial values for the
	* parameters of this new InitializeSensor interaction class instance
	*/
	public InitializeSensor( ReceivedInteraction datamemberMap ) {
		this( datamemberMap, true );
	}
	
	/**
	* Like {@link #InitializeSensor( ReceivedInteraction datamemberMap )}, except this
	* new InitializeSensor interaction class instance is given a timestamp of
	* "logicalTime".
	*
	* @param datamemberMap data structure containing initial values for the
	* parameters of this new InitializeSensor interaction class instance
	* @param logicalTime timestamp for this new InitializeSensor interaction class
	* instance
	*/
	public InitializeSensor( ReceivedInteraction datamemberMap, LogicalTime logicalTime ) {
		this( datamemberMap, logicalTime, true );
	}

	/**
	* Creates a new InitializeSensor interaction class instance that is a duplicate
	* of the instance referred to by InitializeSensor_var.
	*
	* @param InitializeSensor_var InitializeSensor interaction class instance of which
	* this newly created InitializeSensor interaction class instance will be a
	* duplicate
	*/
	public InitializeSensor( InitializeSensor InitializeSensor_var ) {
		super( InitializeSensor_var );
		
		
		set_inputVoltage( InitializeSensor_var.get_inputVoltage() );
		set_realTemperature( InitializeSensor_var.get_realTemperature() );
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
		
		
		
		if (  "inputVoltage".equals( datamemberName )  ) return new Integer(get_inputVoltage());
		else if (  "realTemperature".equals( datamemberName )  ) return new Integer(get_realTemperature());
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
		
				
		
		if ( get_inputVoltage_handle() == datamemberHandle ) return new Integer(get_inputVoltage());
		else if ( get_realTemperature_handle() == datamemberHandle ) return new Integer(get_realTemperature());
		else return super.getParameter( datamemberHandle );
	}
	
	protected boolean setParameterAux( int param_handle, String val ) {
		boolean retval = true;		
		
			
		
		if ( param_handle == get_inputVoltage_handle() ) set_inputVoltage( Integer.parseInt(val) );
		else if ( param_handle == get_realTemperature_handle() ) set_realTemperature( Integer.parseInt(val) );
		else retval = super.setParameterAux( param_handle, val );
		
		return retval;
	}
	
	protected boolean setParameterAux( String datamemberName, String val ) {
		boolean retval = true;
		
			
		
		if (  "inputVoltage".equals( datamemberName )  ) set_inputVoltage( Integer.parseInt(val) );
		else if (  "realTemperature".equals( datamemberName )  ) set_realTemperature( Integer.parseInt(val) );	
		else retval = super.setParameterAux( datamemberName, val );
		
		return retval;
	}
	
	protected boolean setParameterAux( String datamemberName, Object val ) {
		boolean retval = true;
		
		
		
		if (  "inputVoltage".equals( datamemberName )  ) set_inputVoltage( (Integer)val );
		else if (  "realTemperature".equals( datamemberName )  ) set_realTemperature( (Integer)val );		
		else retval = super.setParameterAux( datamemberName, val );
		
		return retval;
	}

	protected SuppliedParameters createSuppliedDatamembers() {
		SuppliedParameters datamembers = super.createSuppliedDatamembers();

	
		
		
			datamembers.add( get_inputVoltage_handle(), Integer.toString(get_inputVoltage()).getBytes() );
		
			datamembers.add( get_realTemperature_handle(), Integer.toString(get_realTemperature()).getBytes() );
		
	
		return datamembers;
	}

	
	public void copyFrom( Object object ) {
		super.copyFrom( object );
		if ( object instanceof InitializeSensor ) {
			InitializeSensor data = (InitializeSensor)object;
			
			
				_inputVoltage = data._inputVoltage;
				_realTemperature = data._realTemperature;
			
		}
	}
}
