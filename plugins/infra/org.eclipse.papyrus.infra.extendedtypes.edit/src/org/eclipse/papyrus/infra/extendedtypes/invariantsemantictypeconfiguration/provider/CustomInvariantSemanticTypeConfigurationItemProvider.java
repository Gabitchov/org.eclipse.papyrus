/**
 * 
 */
package org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.provider;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.papyrus.infra.extendedtypes.Activator;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.IConfigurationModelCreation;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.IInvariantRuleExtensionPoint;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantRuleConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.InvariantSemanticTypeConfigurationPackage;
import org.osgi.framework.Bundle;

/**
 *  Specific Item provider for {@link InvariantSemanticTypeConfiguration} to add new childs given by extension points
 * 
 */
public class CustomInvariantSemanticTypeConfigurationItemProvider extends
		InvariantSemanticTypeConfigurationItemProvider {

	protected Map<String, IConfigurationModelCreation<InvariantRuleConfiguration>> configurationToFactory = new HashMap<String,IConfigurationModelCreation<InvariantRuleConfiguration>>();
	
	public CustomInvariantSemanticTypeConfigurationItemProvider(
			AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

//		// TODO try to implement this using the extension points => this should
//		// be added automatically by each extension
//		newChildDescriptors.add(createChildParameter(
//				InvariantSemanticTypeConfigurationPackage.eINSTANCE.getInvariantSemanticTypeConfiguration_InvariantRuleConfiguration(),
//				InvariantContainerConfigurationFactory.eINSTANCE.createInvariantContainerConfiguration()));
//		
		addFromExtensionPoints(newChildDescriptors, object);
		
	}

	/**
	 * @param newChildDescriptors
	 * @param object
	 */
	protected void addFromExtensionPoints(Collection<Object> newChildDescriptors, Object object) {
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IInvariantRuleExtensionPoint.EXTENSION_POINT_ID);
		// for each element, parses and retrieve the model file. then loads it and returns the root element 
		for(IConfigurationElement configurationElement : elements) {
			// contributor will always be the same, but implementation could be different.  
			

			String configurationModelCreationClassName = configurationElement.getAttribute(IInvariantRuleExtensionPoint.CONFIGURATION_MODEL_CREATION);
			if(configurationModelCreationClassName !=null) {
				String contributorName = configurationElement.getContributor().getName();
				IConfigurationModelCreation<InvariantRuleConfiguration> configurationModelCreation = configurationToFactory.get(configurationModelCreationClassName);
				if(configurationModelCreation == null) {
					Class<IConfigurationModelCreation<InvariantRuleConfiguration>> configurationClass = null;
					try {
						configurationClass = loadInvariantRulecModelCreationClass(configurationModelCreationClassName, contributorName);
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
						InvariantSemanticTypeConfigurationPackage.eINSTANCE.getInvariantSemanticTypeConfiguration_InvariantRuleConfiguration(),
						configurationModelCreation.createConfigurationModel()));
	
				}
			}
		}
	}

	
	protected Class<IConfigurationModelCreation<InvariantRuleConfiguration>> loadInvariantRulecModelCreationClass(String className, String bundleId) throws ClassNotFoundException {
		Class<IConfigurationModelCreation<InvariantRuleConfiguration>> found = null;
		Bundle bundle = basicGetBundle(bundleId);
		if (bundle!=null){
            int state = bundle.getState();
            if ( state == org.osgi.framework.Bundle.ACTIVE || state == org.osgi.framework.Bundle.STARTING ){
            	found = (Class<IConfigurationModelCreation<InvariantRuleConfiguration>>)bundle.loadClass(className);
            	return found;
            }
		}
		return null;
	}
	
	 private static Bundle basicGetBundle(String bundleId) {
	        return Platform.getBundle(bundleId);   
	    }
}
