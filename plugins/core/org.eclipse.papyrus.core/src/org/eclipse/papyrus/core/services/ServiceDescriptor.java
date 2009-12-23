/**
 * 
 */
package org.eclipse.papyrus.core.services;



/**
 * Descriptor of a service.
 * This descriptor describe a service. 
 * 
 * @author dumoulin
 * 
 */
public class ServiceDescriptor {

	/** Classname of the service. USed to start the service */
	private String serviceClassname;

	/** Kind of start for this service */
	private ServiceStartKind serviceStartKind;

	/**
	 * Service priority. If two service are registered under the same key, only the one with the
	 * higher priority is started.
	 */
	private int priority;

	/**
	 * Key used to register the service.
	 */
	private Object key;

	/**
	 * Id of the bundle owning the .class that is referenced by serviceClassname.
	 * Requested when instanciating the class.
	 */
	private String classBundleID;


	/**
	 * If set to true, use the classType as key.
	 */
	private boolean useClassTypeAsKey = false;

	/**
	 * Constructor.
	 * 
	 * @param serviceClassname
	 * @param serviceStartKind
	 * @param priority
	 */
	public ServiceDescriptor(String serviceClassname, ServiceStartKind serviceStartKind, int priority) {
		this.key = serviceClassname;
		this.serviceClassname = serviceClassname;
		this.serviceStartKind = serviceStartKind;
		this.priority = priority;
	}

	/**
	 * Constructor.
	 * 
	 * @param key
	 * @param serviceClassname
	 * @param serviceStartKind
	 * @param priority
	 */
	public ServiceDescriptor(Object key, String serviceClassname, ServiceStartKind serviceStartKind, int priority) {
		this.key = key;
		this.serviceClassname = serviceClassname;
		this.serviceStartKind = serviceStartKind;
		this.priority = priority;
	}

	/**
	 * @return the serviceStartKind
	 */
	public ServiceStartKind getServiceStartKind() {
		return serviceStartKind;
	}

	/**
	 * Return true if StartKind is 'always'.
	 * 
	 * @return
	 */
	public boolean isStartAtStartup() {
		return serviceStartKind == ServiceStartKind.STARTUP;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}


	/**
	 * @return the key
	 */
	public Object getKey() {
		return key;
	}


	/**
	 * @return the serviceClassname
	 */
	public String getServiceClassname() {
		return serviceClassname;
	}


	/**
	 * @return the classBundleID
	 */
	public String getClassBundleID() {
		return classBundleID;
	}


	/**
	 * @return the useClassTypeAsKey
	 */
	public boolean isUseClassTypeAsKey() {
		return useClassTypeAsKey;
	}

	/**
	 * @param classBundleId
	 *        the classBundleID to set
	 */
	public void setClassBundleID(String classBundleId) {
		classBundleID = classBundleId;
	}


	/**
	 * @param useClassTypeAsKey
	 *        the useClassTypeAsKey to set
	 */
	public void setUseClassTypeAsKey(boolean useClassTypeAsKey) {
		this.useClassTypeAsKey = useClassTypeAsKey;
	}


	/**
	 * @see java.lang.Object#toString()
	 * @return
	 * 
	 */
	@Override
	public String toString() {
		return "ServiceDescriptor [key=" + key + ", serviceClassname=" + serviceClassname + ", serviceStartKind=" + serviceStartKind + ", priority=" + priority + "]";
	}


}
