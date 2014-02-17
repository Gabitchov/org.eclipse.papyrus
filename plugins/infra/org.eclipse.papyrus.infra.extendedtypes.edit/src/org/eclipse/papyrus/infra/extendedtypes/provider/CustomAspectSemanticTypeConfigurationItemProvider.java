/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.provider;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.Activator;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.IActionConfigurationModelCreation;
import org.eclipse.papyrus.infra.extendedtypes.IAspectTypeExtensionPoint;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage;
import org.osgi.framework.Bundle;

/**
 *  Specific Item provider for {@link InvariantSemanticTypeConfiguration} to add new childs given by extension points
 * 
 */
public class CustomAspectSemanticTypeConfigurationItemProvider extends AspectSemanticTypeConfigurationItemProvider {

	protected Map<String, IActionConfigurationModelCreation<ActionConfiguration>> configurationToFactory = new HashMap<String, IActionConfigurationModelCreation<ActionConfiguration>>();
	
	public CustomAspectSemanticTypeConfigurationItemProvider(
			AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		addFromExtensionPoints(newChildDescriptors, object);
		
	}

	/**
	 * @param newChildDescriptors
	 * @param object
	 */
	protected void addFromExtensionPoints(Collection<Object> newChildDescriptors, Object object) {
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IAspectTypeExtensionPoint.EXTENSION_POINT_ID);
		// for each element, parses and retrieve the model file. then loads it and returns the root element 
		for(IConfigurationElement configurationElement : elements) {
			// contributor will always be the same, but implementation could be different.  
			

			String configurationModelCreationClassName = configurationElement.getAttribute(IAspectTypeExtensionPoint.CONFIGURATION_MODEL_CREATION);
			if(configurationModelCreationClassName !=null) {
				String contributorName = configurationElement.getContributor().getName();
				IActionConfigurationModelCreation<ActionConfiguration> configurationModelCreation = configurationToFactory.get(configurationModelCreationClassName);
				if(configurationModelCreation == null) {
					Class<IActionConfigurationModelCreation<ActionConfiguration>> configurationClass = null;
					try {
						configurationClass = loadAspectActionConfigurationModelCreationClass(configurationModelCreationClassName, contributorName);
					} catch (ClassNotFoundException e1) {
						Activator.log.error(e1);
					}
					if(configurationClass != null) {
						// instantiate class
						try {
							configurationModelCreation = configurationClass.newInstance();
							configurationToFactory.put(configurationModelCreationClassName, configurationModelCreation);
						} catch (InstantiationException e) {
							Activator.log.error(e);
						} catch (IllegalAccessException e) {
							Activator.log.error(e);
						}
					}
				}
				
				if(configurationModelCreation !=null) {
					newChildDescriptors.add(createChildParameter(
						ExtendedtypesPackage.eINSTANCE.getAspectSemanticTypeConfiguration_ActionConfiguration(),
						configurationModelCreation.createConfigurationModel()));
	
				}
			}
		}
	}

	
	@SuppressWarnings("unchecked")
	protected Class<IActionConfigurationModelCreation<ActionConfiguration>> loadAspectActionConfigurationModelCreationClass(String className, String bundleId) throws ClassNotFoundException {
		Class<IActionConfigurationModelCreation<ActionConfiguration>> found = null;
		Bundle bundle = basicGetBundle(bundleId);
		if (bundle!=null){
            int state = bundle.getState();
            if ( state == org.osgi.framework.Bundle.ACTIVE || state == org.osgi.framework.Bundle.STARTING ){
            	found = (Class<IActionConfigurationModelCreation<ActionConfiguration>>)bundle.loadClass(className);
            	return found;
            }
		}
		return null;
	}
	
	 private static Bundle basicGetBundle(String bundleId) {
	        return Platform.getBundle(bundleId);   
	    }
}
