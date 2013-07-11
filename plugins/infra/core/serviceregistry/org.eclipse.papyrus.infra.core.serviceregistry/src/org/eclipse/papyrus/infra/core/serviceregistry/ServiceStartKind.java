/**
 * 
 */
package org.eclipse.papyrus.infra.core.serviceregistry;

/**
 * Kind of possible start method for a service. LAZY - The service start when it
 * is requested for the first time. STARTUP - The service start as soon as the
 * registry is started, or when the service is added is the registry is already
 * started.
 * 
 * @author dumoulin
 * 
 */
public enum ServiceStartKind {

	LAZY, STARTUP;
}
