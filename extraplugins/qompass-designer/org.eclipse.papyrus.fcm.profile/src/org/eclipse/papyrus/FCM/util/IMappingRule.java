package org.eclipse.papyrus.FCM.util;

import org.eclipse.papyrus.FCM.Port;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;

/**
 * Interface used by extension point for evaluation of interface mappings
 *
 */
public interface IMappingRule {		
	/**
	 * Return a list of provided interfaces for a given p (and in
	 * the context of a configuration c)
	 * @param p the port
	 * @param config the configuration
	 * @param update if true, make model updates during calculation of derived interface
	 * @return the list of provided interfaces
	 */
	public Interface getProvided(Port p, InstanceSpecification config, boolean update);

	/**
	 * Return a list of provided interfaces for a given p (and in
	 * the context of a configuration c)
	 * @param p the port
	 * @param config the configuration
	 * @param update if true, make model updates during calculation of derived interface
	 * @return the list of provided interfaces
	 */	
	public Interface getRequired(Port p, InstanceSpecification config, boolean update);
}
