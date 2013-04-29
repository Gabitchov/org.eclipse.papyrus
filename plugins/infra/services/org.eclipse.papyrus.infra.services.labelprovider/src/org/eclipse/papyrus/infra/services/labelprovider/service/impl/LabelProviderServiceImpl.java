/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.labelprovider.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.labelprovider.Activator;
import org.eclipse.papyrus.infra.services.labelprovider.service.ContextualLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.ExtensibleLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;

/**
 * Default implementation for the LabelProviderService
 * 
 * It relies on an ExtensibleLabelProvider. Different label providers can be contributed via
 * an extension point.
 * 
 * @author Camille Letavernier
 * 
 */
public class LabelProviderServiceImpl implements LabelProviderService {

	private final Map<String, SharedExtensibleLabelProvider> labelProviders = new HashMap<String, SharedExtensibleLabelProvider>();

	public static final String EXTENSION_ID = Activator.PLUGIN_ID + ".labelProvider";

	public LabelProviderServiceImpl() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		readContexts(config);
		readLabelProviders(config);
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		//Nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public void startService() throws ServiceException {
		//Nothing
	}

	/**
	 * Parses the available contexts from the extension point
	 * 
	 * @param config
	 *        The extension point IConfigurationElements
	 */
	private void readContexts(IConfigurationElement[] config) {
		for(IConfigurationElement e : config) {
			try {
				if("context".equals(e.getName())) {
					String contextId = e.getAttribute("id");
					if(contextId == null) {
						Activator.log.warn("The plug-in " + e.getContributor() + " contributed an invalid extension for " + EXTENSION_ID + ". The context id must be set");
						continue;
					}

					if(labelProviders.containsKey(contextId)) {
						Activator.log.warn("The context " + contextId + " is already contributed");
						continue;
					}

					/** Associates an empty LabelProvider to the context */
					labelProviders.put(contextId, new SharedExtensibleLabelProvider());
				}
			} catch (Exception ex) {
				Activator.log.error("The plugin " + e.getContributor() + " contributed an invalid extension for " + EXTENSION_ID, ex); //$NON-NLS-1$//$NON-NLS-2$
			}
		}

		/**
		 * THe default label provider context may have been registered via an extension. Otherwise, we force its creation.
		 */
		if(!labelProviders.containsKey(DEFAULT_LABEL_PROVIDER)) {
			labelProviders.put(DEFAULT_LABEL_PROVIDER, new SharedExtensibleLabelProvider());
		}
	}

	/**
	 * Parses the available label providers from the extension point
	 * 
	 * @param config
	 *        The extension point IConfigurationElements
	 */
	private void readLabelProviders(IConfigurationElement[] config) {
		for(IConfigurationElement e : config) {
			try {
				if("labelProvider".equals(e.getName())) {
					IFilteredLabelProvider provider = (IFilteredLabelProvider)e.createExecutableExtension("provider");
					if(provider == null) {
						Activator.log.warn("The labelProvider class is required");
						continue;
					}

					int priority = Integer.parseInt(e.getAttribute("priority"));

					IConfigurationElement[] contextElements = e.getChildren("labelProviderContext");

					//No context means all contexts
					if(contextElements.length == 0) {
						for(ExtensibleLabelProvider labelProvider : labelProviders.values()) {
							labelProvider.registerProvider(priority, provider);
						}
					} else {
						for(IConfigurationElement contextElement : contextElements) {
							String context = contextElement.getAttribute("context");
							if(context != null) {
								ExtensibleLabelProvider labelProvider = labelProviders.get(context);
								if(labelProvider == null) {
									Activator.log.warn("Unknown label provider context: " + context);
									continue;
								}

								labelProvider.registerProvider(priority, provider);
							} else {
								Activator.log.warn("The context for label provider " + e.getAttribute("provider") + " is null");
							}
						}
					}
				}
			} catch (ClassCastException ex) {
				Activator.log.warn("The plug-in " + e.getContributor() + " contributed an invalid extension for " + EXTENSION_ID + ". The labelProvider must implement IFilteredLabelProvider");
			} catch (Exception ex) {
				Activator.log.error("The plugin " + e.getContributor() + " contributed an invalid extension for " + EXTENSION_ID, ex); //$NON-NLS-1$//$NON-NLS-2$
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void disposeService() throws ServiceException {
		for(SharedExtensibleLabelProvider provider : labelProviders.values()) {
			provider.doDispose();
		}
		this.labelProviders.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getLabelProvider() {
		return getLabelProvider(DEFAULT_LABEL_PROVIDER);
	}

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getLabelProvider(String context) {
		if(context == null) {
			return getLabelProvider();
		}

		if(!labelProviders.containsKey(context)) {
			Activator.log.warn("Unknown label provider context: " + context + ". The default label provider will be used");

			//The default label provider has been unregistered (or is not registered yet)
			if(DEFAULT_LABEL_PROVIDER.equals(context)) {
				return new LabelProvider();
			}

			return getLabelProvider();
		}
		return labelProviders.get(context);
	}

	/**
	 * {@inheritDoc}
	 */
	private class SharedExtensibleLabelProvider extends ExtensibleLabelProvider {

		@Override
		public void dispose() {
			//Nothing. The LabelProvider is shared, and JFace viewers dispose their providers
			//when they are disposed.
			//The providers should be disposed only when the service is disposed.
		}

		public void doDispose() {
			super.dispose(); //Disposed only when the service is disposed
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getLabelProvider(String context, Object contextElement) {
		ILabelProvider provider = getLabelProvider(context);
		if(provider instanceof ContextualLabelProvider) {
			((ContextualLabelProvider)provider).setContext(contextElement);
		}
		return provider;
	}

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getLabelProvider(Object contextElement) {
		ILabelProvider provider = getLabelProvider();
		if(provider instanceof ContextualLabelProvider) {
			((ContextualLabelProvider)provider).setContext(contextElement);
		}
		return provider;
	}

}
