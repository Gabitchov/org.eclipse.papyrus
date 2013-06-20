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

	/**
	 * Only configure the instances, i.e. avoid re-creating elements of the container, but create
	 * the UML instance specifications
	 */
	public void configureOnly() {
		configureOnly = true;
	}

	protected boolean configureOnly;

	public abstract void createContainer(Class smComponent, Class tmComponent) throws TransformationException;

	public abstract void createContainerInstance(Class tmComponent, InstanceSpecification tmIS, ContainerContext context);

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
	 * @param tmIS
	 *        the instance specification for the application component in the target model
	 * @throws TransformationException
	 */
	public abstract void applyRule(ContainerRule smContainerRule, Class smComponent, Class tmComponent, InstanceSpecification tmIS)
		throws TransformationException;

	/**
	 * Move a slot from the executor instance specification to an instance
	 * specification of an extension/interceptor This is required, since the
	 * users cannot configure containers directly. The modification is done in
	 * the target model, i.e. the user model is not affected.
	 * 
	 * Default implementation is empty
	 */
	public void moveSlots() {
	}

	/**
	 * The instance specification of the created container
	 */
	protected InstanceSpecification containerIS;

	/**
	 * Store source and target model
	 */
	protected Copy copy;


	/**
	 * @return the instance specification of the created container
	 */
	public InstanceSpecification getContainerIS() {
		return containerIS;
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
	 * deployment plan within target model
	 */
	protected Package tmCDP;

	/**
	 * Additional information about the container that is used by instance configurators
	 */
	protected ContainerContext context;
}
