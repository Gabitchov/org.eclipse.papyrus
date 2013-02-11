package org.eclipse.papyrus.infra.gmfdiag.css.service;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;

/**
 * This service enables to retrieve the pseudo selector associated with a particular marker kind.
 * This pseudo selector is interpreted by the Papyrus CSS Engine, so that a particular CSS style can applied in the case where a marker is applied.
 * Pseudo selectors are associated with marker kinds by contributing to extension point org.eclipse.papyrus.infra.gmfdiag.css.markertopseudoselectormappingprovider
 *
 */
public class MarkerToPseudoSelectorMappingService implements IService {

	/**
	 * The services registry
	 */
	protected ServicesRegistry servicesRegistry ;

	/**
	 * A map between marker types and pseudo selectors
	 */
	protected Map<String, String> markerToPseudoSelectorMap ;

	/** 
	 * Initializes the markerToPseudoSelectorMap by retrieving all contributors to the "Marker To Pseudo Selectors Mapping Provider" extension point, and merging all the mappings they define
	 * 
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.servicesRegistry = servicesRegistry ;
		this.markerToPseudoSelectorMap = this.getRegisteredMarkerToPseudoSelectorsMappingProviders() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.services.IService#startService()
	 */
	public void startService() throws ServiceException {
		// nothing to be done
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.services.IService#disposeService()
	 */
	public void disposeService() throws ServiceException {
		// nothing to be done
	}

	/**
	 * Return the pseudo selectors for the given marker kind
	 * 
	 * @param markerKind The marker kind for which the corresponding pseudo selector has to be retrieved
	 * @return
	 */
	public String getPseudoSelector(String markerKind) {
		String pseudoSelector = this.markerToPseudoSelectorMap.get(markerKind) ;
		return pseudoSelector != null ? pseudoSelector : "" ;
	}

	/** 
	 * Utility methods which collects all the contributors to the "Marker To Pseudo Selectors Mapping Provider" extension point, and return the merge of all the mappings they define.
	 * In the case where multiple pseudo selectors are defined for a single marker kind, only one pseudo selector is kept (this is not deterministic).
	 * 
	 * @return The merge of all the mappings defined by contributors to the "Marker To Pseudo Selectors Mapping Provider" extension point 
	 * @see org.eclipse.papyrus.infra.core.services.IService#init(org.eclipse.papyrus.infra.core.services.ServicesRegistry)
	 */
	protected Map<String, String> getRegisteredMarkerToPseudoSelectorsMappingProviders() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(IMarkerToPseudoSelectorMappingProvider.MARKER_TO_PSEUDO_SELECTOR_MAPPING_PROVIDER_EXTENSION_POINT_ID) ;
		Map<String, String> providers = new HashMap<String, String>() ;
		for (int i = 0 ; i < config.length ; i++) {
			IMarkerToPseudoSelectorMappingProvider provider;
			try {
				provider = (IMarkerToPseudoSelectorMappingProvider)config[i].createExecutableExtension("class");
				Map<String, String> mappings = provider.getMappings() ;
				for (String markerKind : mappings.keySet()) {
					if (providers.containsKey(markerKind))
						Activator.log.warn("Multiple pseudo selectors registered for " + markerKind) ;
					providers.put(markerKind, mappings.get(markerKind)) ;
				}
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		}
		return providers ;
	}

}
