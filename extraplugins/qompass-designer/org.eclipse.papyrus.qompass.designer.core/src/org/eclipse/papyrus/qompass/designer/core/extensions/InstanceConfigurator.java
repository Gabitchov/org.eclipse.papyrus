/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.FCM.UseInstanceConfigurator;
import org.eclipse.papyrus.qompass.designer.core.Activator;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.transformations.ContainerContext;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * Support for the configuration of instances via the Eclipse extension mechanism
 */
public class InstanceConfigurator {

	public static final String IINSTANCE_CONFIG_ID = Activator.PLUGIN_ID + ".instanceConfig"; //$NON-NLS-1$

	/**
	 * Configure an instance. The configurator is selected by means of a stereotype on the classifier of
	 * the passed instance. 
	 * 
	 * @see org.eclipse.papyrus.qompass.designer.core.extensions.IInstanceConfigurator
	 * @param instance
	 *        the specification of instance that should be configured
	 * @param componentPart
	 *        the part representing the instance (before container expansion)
	 * @param port
	 *        a port within the context of container
	 */
	public static void configureInstance(InstanceSpecification instance, Property componentPart, ContainerContext containerContext) {
		Classifier component = DepUtils.getClassifier(instance);
		UseInstanceConfigurator useInstanceConfigurator = UMLUtil.getStereotypeApplication(component, UseInstanceConfigurator.class);
		configureInstance(useInstanceConfigurator, instance, componentPart, containerContext);
	}

	/**
	 * Configure an instance. The configurator is selected by means of a stereotype on the passed container rule.
	 * 
	 * @see org.eclipse.papyrus.qompass.designer.core.extensions.IInstanceConfigurator
	 * @param rule
	 * 		  the applied container rule
	 * @param instance
	 *        the specification of instance that should be configured
	 * @param componentPart
	 *        the part representing the instance (before container expansion)
	 * @param port
	 *        a port within the context of container
	 */
	public static void configureInstance(ContainerRule rule, InstanceSpecification instance, Property componentPart, ContainerContext containerContext) {
		UseInstanceConfigurator useInstanceConfigurator = UMLUtil.getStereotypeApplication(rule.getBase_Class(), UseInstanceConfigurator.class);
		configureInstance(useInstanceConfigurator, instance, componentPart, containerContext);
	}

	/**
	 * Configure an instance with a given configurator
	 * 
	 * @param useInstanceConfigurator
	 * @param instance
	 * @param componentPart
	 * @param containerContext
	 */
	public static void configureInstance(UseInstanceConfigurator useInstanceConfigurator, InstanceSpecification instance, Property componentPart, ContainerContext containerContext) {
		if(useInstanceConfigurator != null) {
			org.eclipse.papyrus.FCM.InstanceConfigurator instanceConfigurator = useInstanceConfigurator.getConfigurator();
			if(instanceConfigurator != null) {
				String id = instanceConfigurator.getBase_Class().getName();
				IInstanceConfigurator iConfigurator = getInstanceConfigurator(id);
				if(iConfigurator != null) {
					iConfigurator.configureInstance(instance, componentPart, containerContext);

				}
			}
		}
	}

	protected static IInstanceConfigurator getInstanceConfigurator(String iConfiguratorID) {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = reg.getConfigurationElementsFor(IINSTANCE_CONFIG_ID);
		for(IConfigurationElement configElement : configElements) {
			try {
				final String iConfiguratorIDext = configElement.getAttribute("configuratorID"); //$NON-NLS-1$
				if(iConfiguratorIDext.equals(iConfiguratorID)) {
					// TODO: cache returned instance (avoid creating a new instance each time => more efficient, no need for static attributes)
					final Object obj = configElement.createExecutableExtension("class"); //$NON-NLS-1$
					if(obj instanceof IInstanceConfigurator) {
						return (IInstanceConfigurator)obj;
					}
				}
			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}
		return null;
	}
}
