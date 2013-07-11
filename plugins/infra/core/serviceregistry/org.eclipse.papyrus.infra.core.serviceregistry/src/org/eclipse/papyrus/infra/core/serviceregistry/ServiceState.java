/**
 * 
 */
package org.eclipse.papyrus.infra.core.serviceregistry;

/**
 * The different states that a service can have.
 * 
 * @author dumoulin
 * 
 */
public enum ServiceState {
	registered, created, initialized, starting, started, disposed, error
}
