/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.service.ExecutionStrategy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.core.service.Service;
import org.eclipse.gmf.runtime.common.ui.services.util.ActivityFilterProviderDescriptor;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.w3c.dom.Node;

/**
 * Service that manages aspect tool providers
 */
public class AspectToolService extends Service implements IAspectToolProviderService {

	/** the singleton instance of the aspect tool provider service */
	protected final static AspectToolService instance = new AspectToolService();

	/**
	 * initialize the service
	 */
	static {
		instance.configureProviders(Activator.ID, "aspectToolProvider"); //$NON-NLS-1$
	}

	/**
	 * Returns the singleton instance of this service
	 * 
	 * @return the singleton instance of this service
	 */
	public static AspectToolService getInstance() {
		return instance;
	}

	/**
	 * Creates a new instance of the aspect tool provider Service
	 */
	protected AspectToolService() {
		super();
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.core.service.Service#newProviderDescriptor(org.eclipse.core.runtime.IConfigurationElement)
	 */
	protected Service.ProviderDescriptor newProviderDescriptor(IConfigurationElement element) {
		return new ProviderDescriptor(element);
	}

	/**
	 * @{inheritDoc
	 */
	public List<IAspectActionProvider> getProviders() {
		List<IAspectActionProvider> providers = new ArrayList<IAspectActionProvider>();
		execute(ExecutionStrategy.REVERSE, new GetAllAspectToolProvidersOperation(providers));
		return providers;
	}

	/**
	 * @{inheritDoc
	 */
	public IAspectActionProvider getProvider(String id) {
		List<IAspectActionProvider> providers = (List)execute(ExecutionStrategy.REVERSE, new GetAspectToolProviderOperation(id));
		if(providers == null) {
			return new StereotypeAspectActionProvider(); // backward
															// compatibility
		}
		Iterator<IAspectActionProvider> it = providers.iterator();
		while(it.hasNext()) {
			IAspectActionProvider aspectActionProvider = (IAspectActionProvider)it.next();
			if(aspectActionProvider != null) {
				return aspectActionProvider;
			}
		}
		return new StereotypeAspectActionProvider(); // backward compatibility
	}

	/**
	 * A descriptor for aspect tool providers defined by a configuration
	 * element.
	 */
	protected static class ProviderDescriptor extends ActivityFilterProviderDescriptor {

		/** the provider configuration parsed from XML */
		protected AspectToolProviderConfiguration providerConfiguration;

		/**
		 * Constructs a <code>ISemanticProvider</code> descriptor for the
		 * specified configuration element.
		 * 
		 * @param element
		 *        The configuration element describing the provider.
		 */
		public ProviderDescriptor(IConfigurationElement element) {
			super(element);
			this.providerConfiguration = AspectToolProviderConfiguration.parse(element);
			Assert.isNotNull(providerConfiguration);
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
		 */
		public boolean provides(IOperation operation) {
			if(!super.provides(operation)) {
				return false;
			}
			if(operation instanceof GetAllAspectToolProvidersOperation) {
				return true;
			}
			if(operation instanceof GetAspectToolProviderOperation) {
				return providerConfiguration.getId().equals(((GetAspectToolProviderOperation)operation).getIdentifier());
			}
			return false;
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.core.service.Service.ProviderDescriptor#getProvider()
		 */
		public IProvider getProvider() {
			if(provider == null) {
				IProvider newProvider = super.getProvider();
				if(provider instanceof IAspectActionProvider) {
					IAspectActionProvider defaultProvider = (IAspectActionProvider)newProvider;
					defaultProvider.setConfiguration(getElement());
				}
				return newProvider;
			}
			return super.getProvider();
		}
	}

	/**
	 * Returns the id of the provider in charge of the specified node
	 * 
	 * @param actionNode
	 *        the node that handles the configuration for the post action
	 * @return the id of the factory in charge of the node
	 */
	public static String getProviderId(Node actionNode) {
		String id = "";
		Node node = actionNode.getAttributes().getNamedItem(IPapyrusPaletteConstant.ID);
		if(node == null) {
			return StereotypeAspectActionProvider.FACTORY_ID; // backward
																// compatibility
		} else {
			id = node.getNodeValue();
		}
		return id;
	}
}
