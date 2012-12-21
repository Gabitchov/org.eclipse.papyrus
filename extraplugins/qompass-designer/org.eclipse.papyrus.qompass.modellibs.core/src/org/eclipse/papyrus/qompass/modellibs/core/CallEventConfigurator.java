package org.eclipse.papyrus.qompass.modellibs.core;

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;

import org.eclipse.papyrus.qompass.designer.core.acceleo.UMLTool;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepPlanUtils;
import org.eclipse.papyrus.qompass.designer.core.extensions.IInstanceConfigurator;
import org.eclipse.papyrus.qompass.designer.core.transformations.ContainerContext;

/**
 * Configurator of a call event (for a state machine): it sets the
 * portIndex attribute of the call event interceptor. The interceptor uses this
 * attribute to initialize the portIndex attribute within the produced CallEvent
 * data structure.
 * 
 * @author ansgar
 * 
 */
public class CallEventConfigurator implements IInstanceConfigurator {

	public final static String portAttribute = "portIndex";

	/**
	 * Configure the instance of a CallEvent interceptor. The configuration parameter is the
	 * index of the port which gets intercepted. It is obtained via an enumeration
	 * 
	 * @see org.eclipse.papyrus.qompass.designer.core.extensions.IInstanceConfigurator#configureInstance(org.eclipse.uml2.uml.InstanceSpecification,
	 *      org.eclipse.uml2.uml.InstanceSpecification, org.eclipse.uml2.uml.Port)
	 * 
	 * @param instance
	 *        the instance that should be configured
	 * @param componentPart
	 *        the part representing this instance
	 * @param context
	 *        container context
	 */
	public void configureInstance(InstanceSpecification instance, Property componentPart, ContainerContext context)
	{
		if(context != null) {
			// make sure that there is an enum par port
			String literalName = "port_" + UMLTool.varName(context.port);
			// the associated enumeration is declared by the statemachine (which is included by the bootloader as well)

			DepPlanUtils.configureProperty(instance, portAttribute, literalName);
		}
	}

}
