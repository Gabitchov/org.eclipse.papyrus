/*******************************************************************import java.util.HashMap;
import java.util.Map;

import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;
s distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.transformations;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;


public abstract class AbstractContainerTrafo {

	public static void init() {
		containers = new HashMap<Class, AbstractContainerTrafo>();
	}

	/**
	 * return the container trafo associated with the tmComponent
	 * 
	 * @param tmComponent
	 * @return Container-trafo instance of null
	 */
	public static AbstractContainerTrafo get(Class tmComponent) {
		return containers.get(tmComponent);
	}

	/**
	 * Hash map used to identify for which components we already created a container.
	 * Indexed with components in target model (but before container expansion)
	 */
	protected static Map<Class, AbstractContainerTrafo> containers;

	public abstract void createContainer(Class smComponent, Class tmComponent) throws TransformationException;

	/**
	 * Create an instance of the container (UML instance specification)
	 * 
	 * @param tmComponent
	 *        the component within the target model for which we want to create an instance
	 * 
	 * @param tmIS
	 *        the existing instance specification for the component before container expansion.
	 * @param context
	 *        Additional information about the container that is used by instance configurators
	 */
	public abstract InstanceSpecification createContainerInstance(Class tmComponent, InstanceSpecification tmIS, ContainerContext context)
		throws TransformationException;

	/**
	 * apply a container rule, i.e. add either a container extension or an
	 * interceptor to the container
	 * 
	 * @param smContainerRule
	 *        An container rule
	 * @param smComponent
	 *        the application component in the source model
	 * @param tmComponent
	 *        the application component in the target model
	 * @throws TransformationException
	 */
	public abstract void applyRule(ContainerRule smContainerRule, Class smComponent, Class tmComponent)
		throws TransformationException;

	/**
	 * The instance specification of the created container
	 */
	// protected InstanceSpecification containerIS;

	/**
	 * Copy class from source to target model
	 */
	protected Copy copy;


	/**
	 * Is called after a set of rule applications.
	 * Does nothing by default
	 */
	public void finalize() {
	}

	
	/**
	 * The created container implementation (prefixed with sm, since part of
	 * source model)
	 */
	protected Class smClass;

	/**
	 * The created container implementation (prefixed with tm, since part of
	 * target model)
	 */
	protected Class tmClass;

	/**
	 * deployment plan within source model
	 */
	protected Package smCDP;
	
	/**
	 * deployment plan within target model
	 */
	protected Package tmCDP;
}
