/**
 * 
 */
package org.eclipse.papyrus.infra.core.serviceregistry;

import java.util.Collections;
import java.util.List;

/**
 * Descriptor of a service. This descriptor describe a service.
 * 
 * @author cedirc dumoulin
 * 
 */
public class ServiceDescriptor {

	/**
	 * Possible kind for service types.
	 * 
	 */
	public enum ServiceTypeKind {
		service, serviceFactory, pojo, alias
	}

	/** Classname of the service. USed to start the service */
	private String serviceClassname;

	/** Kind of start for this service */
	private ServiceStartKind serviceStartKind;

	/** Kind of service */
	private ServiceTypeKind serviceTypeKind = ServiceTypeKind.service;

	/**
	 * Service priority. If two service are registered under the same key, only
	 * the one with the higher priority is started.
	 */
	private int priority;

	/**
	 * Key used to register the service.
	 */
	private String key;

	/**
	 * Id of the bundle owning the .class that is referenced by
	 * serviceClassname. Requested when instanciating the class.
	 */
	private String classBundleID;

	/**
	 * If set to true, the service is anonymous : it is not registered and can't
	 * be retrieved with getService().
	 */
	private boolean isAnonymous = false;

	/**
	 * List of keys of Services required by this service.
	 */
	private List<String> requiredServices = Collections.emptyList();

	/**
	 * Empty list.
	 */
	private static List<String> EMPTY_LIST_STRING = Collections.emptyList();

	/**
	 * Constructor.
	 * 
	 * @param key
	 * @param serviceClassname
	 * @param serviceStartKind
	 * @param priority
	 * @param requiredServices
	 */
	public ServiceDescriptor(String key, String serviceClassname, ServiceStartKind serviceStartKind, int priority, List<String> requiredServices) {
		this.key = key;
		this.serviceClassname = serviceClassname;
		this.serviceStartKind = serviceStartKind;
		this.priority = priority;
		this.requiredServices = requiredServices;
	}

	/**
	 * Constructor.
	 * 
	 * @param key
	 *        A class used as key. The classname is used as key.
	 * @param serviceClassname
	 * @param serviceStartKind
	 * @param priority
	 * @param requiredServices
	 */
	public ServiceDescriptor(Class<?> key, String serviceClassname, ServiceStartKind serviceStartKind, int priority, List<String> requiredServices) {
		this(key.getName(), serviceClassname, serviceStartKind, priority, requiredServices);
	}

	/**
	 * Constructor.
	 * 
	 * @param key
	 *        A class used as key. The classname is used as key.
	 * @param serviceClassname
	 * @param serviceStartKind
	 * @param priority
	 * @param isAnonymous
	 * @param requiredServices
	 */
	public ServiceDescriptor(String key, String serviceClassname, ServiceStartKind serviceStartKind, int priority, boolean isAnonymous, List<String> requiredServices) {
		this.key = key;
		this.serviceClassname = serviceClassname;
		this.serviceStartKind = serviceStartKind;
		this.priority = priority;
		this.isAnonymous = isAnonymous;
		this.requiredServices = requiredServices;
	}

	/**
	 * Constructor.
	 * 
	 * @param key
	 *        A class used as key. The classname is used as key.
	 * @param serviceClassname
	 * @param serviceStartKind
	 * @param priority
	 * @param isAnonymous
	 * @param requiredServices
	 */
	public ServiceDescriptor(Class<?> key, String serviceClassname, ServiceStartKind serviceStartKind, int priority, boolean isAnonymous, List<String> requiredServices) {
		this(key.getName(), serviceClassname, serviceStartKind, priority, isAnonymous, requiredServices);
	}

	/**
	 * Constructor.
	 * 
	 * @param key
	 * @param serviceClassname
	 * @param serviceStartKind
	 * @param priority
	 */
	public ServiceDescriptor(String key, String serviceClassname, ServiceStartKind serviceStartKind, int priority) {
		this(key, serviceClassname, serviceStartKind, priority, EMPTY_LIST_STRING);
	}

	/**
	 * Constructor.
	 * 
	 * @param key
	 *        A class used as key. The classname is used as key.
	 * @param serviceClassname
	 * @param serviceStartKind
	 * @param priority
	 */
	public ServiceDescriptor(Class<?> key, String serviceClassname, ServiceStartKind serviceStartKind, int priority) {
		this(key.getName(), serviceClassname, serviceStartKind, priority, EMPTY_LIST_STRING);
	}

	/**
	 * Constructor.
	 * 
	 * @param serviceClassname
	 * @param serviceStartKind
	 * @param priority
	 * @param requiredServices
	 */
	public ServiceDescriptor(String serviceClassname, ServiceStartKind serviceStartKind, int priority, List<String> requiredServices) {
		this(serviceClassname, serviceClassname, serviceStartKind, priority, requiredServices);
	}

	/**
	 * Constructor.
	 * 
	 * @param serviceClassname
	 * @param serviceStartKind
	 * @param priority
	 */
	public ServiceDescriptor(String serviceClassname, ServiceStartKind serviceStartKind, int priority, boolean isAnonymous) {
		this(serviceClassname, serviceClassname, serviceStartKind, priority, isAnonymous, EMPTY_LIST_STRING);
	}

	/**
	 * Constructor.
	 * 
	 * @param serviceClassname
	 * @param serviceStartKind
	 * @param priority
	 */
	public ServiceDescriptor(String serviceClassname, ServiceStartKind serviceStartKind, int priority) {
		this(serviceClassname, serviceClassname, serviceStartKind, priority, EMPTY_LIST_STRING);
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
	public String getKey() {
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
	 * @param classBundleId
	 *        the classBundleID to set
	 */
	public void setClassBundleID(String classBundleId) {
		classBundleID = classBundleId;
	}

	/**
	 * Get the keys of all the required services
	 * 
	 * @return the requiredServices
	 */
	public List<String> getRequiredServiceKeys() {
		return requiredServices;
	}

	/**
	 * @param requiredServices
	 *        the requiredServices to set
	 */
	public void setRequiredServiceKeys(List<String> requiredServices) {
		this.requiredServices = requiredServices;
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

	/**
	 * @return the isAnonymous
	 */
	public boolean isAnonymous() {
		return isAnonymous;
	}

	/**
	 * @param isAnonymous
	 *        the isAnonymous to set
	 */
	public void setAnonymous(boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	/**
	 * @return the serviceTypeKind
	 */
	public ServiceTypeKind getServiceTypeKind() {
		return serviceTypeKind;
	}

	/**
	 * @param serviceTypeKind
	 *        the serviceTypeKind to set
	 */
	public void setServiceTypeKind(ServiceTypeKind serviceTypeKind) {
		this.serviceTypeKind = serviceTypeKind;
	}

}
