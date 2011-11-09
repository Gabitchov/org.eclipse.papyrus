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
package org.eclipse.papyrus.infra.extendedtypes.providers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.service.ExecutionStrategy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.core.service.Service;
import org.eclipse.gmf.runtime.common.ui.services.util.ActivityFilterProviderDescriptor;
import org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.Activator;


/**
 * Service to retrieve the provider giving the command for a specific {@link ActionConfiguration}
 */
public class ExtendedElementTypeActionService extends Service {

	/** singleton instance of this service */
	protected final static ExtendedElementTypeActionService instance = new ExtendedElementTypeActionService();

	/**
	 * initialize the service
	 */
	static {
		instance.configureProviders(Activator.PLUGIN_ID, "extendedElementTypeActionProvider"); //$NON-NLS-1$
	}
	
	/**
	 * Default constructor.
	 */
	protected ExtendedElementTypeActionService() {

	}

	/**
	 * Returns the singleton instance of this service
	 * 
	 * @return the singleton instance of this service
	 */
	synchronized public static ExtendedElementTypeActionService getInstance() {
		return instance;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.core.service.Service#newProviderDescriptor(org.eclipse.core.runtime.IConfigurationElement)
	 */
	protected Service.ProviderDescriptor newProviderDescriptor(IConfigurationElement element) {
		return new ProviderDescriptor(element);
	}

	/**
	 * Returns all providers in the service
	 * 
	 * @return the list of providers found or an empty list.
	 */
	public List<IExtendedElementTypeActionProvider> getProviders() {
		List<IExtendedElementTypeActionProvider> providers = new ArrayList<IExtendedElementTypeActionProvider>();
		execute(ExecutionStrategy.REVERSE, new GetAllExtendedElementTypeActionProvidersOperation(providers));
		return providers;
	}

	/**
	 * Returns the provider with the given identifier
	 * 
	 * @param actionConfiguration
	 *        the actionConfiguration for the provider to retrieve
	 * @return the provider found or <code>null</code>.
	 */
	public IExtendedElementTypeActionProvider getProvider(ActionConfiguration actionConfiguration) {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<IExtendedElementTypeActionProvider> providers = (List)execute(ExecutionStrategy.REVERSE, new GetExtendedElementTypeActionProviderOperation(actionConfiguration));
		Iterator<IExtendedElementTypeActionProvider> it = providers.iterator();
		while(it.hasNext()) {
			IExtendedElementTypeActionProvider aspectActionProvider = (IExtendedElementTypeActionProvider)it.next();
			if(aspectActionProvider != null) {
				return aspectActionProvider;
			}
		}
		return null; // backward compatibility
	}

	/**
	 * Returns the command for the given {@link ActionConfiguration}.
	 * 
	 * @param elementsToEdit
	 *        list of elements to edit
	 * 
	 * @param configuration
	 *        the configuration of the action
	 * @return the {@link ICommand} configured by the parameter or <code>null</code>.
	 * @throws ProviderNotFoundException
	 *         exception thrown when the provider was not found for this configuration
	 */
	public ICommand getICommand(List<? extends Object> elementsToEdit, ActionConfiguration configuration) throws ProviderNotFoundException {
		IExtendedElementTypeActionProvider provider = getProvider(configuration);
		if(provider != null) {
			return provider.getICommand(elementsToEdit, configuration);
		}
		throw new ProviderNotFoundException(configuration);
	}
	
	/**
	 * Returns the command for the given {@link ActionConfiguration}.
	 * 
	 * @param elementsToEdit
	 *        list of elements to edit
	 * 
	 * @param configuration
	 *        the configuration of the action
	 * @return the {@link ICommand} configured by the parameter or <code>null</code>.
	 * @throws ProviderNotFoundException
	 *         exception thrown when the provider was not found for this configuration
	 */
	public ICommand getPreValidationCommand(List<? extends Object> elementsToEdit, ActionConfiguration configuration) throws ProviderNotFoundException {
		IExtendedElementTypeActionProvider provider = getProvider(configuration);
		if(provider != null) {
			return provider.getBeforeCreateValidationCommand(elementsToEdit, configuration);
		}
		throw new ProviderNotFoundException(configuration);
	}

	/**
	 * A descriptor for aspect tool providers defined by a configuration element.
	 */
	protected static class ProviderDescriptor extends ActivityFilterProviderDescriptor {

		/** the provider configuration parsed from XML */
		protected ExtentedElementTypeActionProviderConfiguration providerConfiguration;

		/**
		 * Constructs a <code>ISemanticProvider</code> descriptor for
		 * the specified configuration element.
		 * 
		 * @param element
		 *        The configuration element describing the provider.
		 */
		public ProviderDescriptor(IConfigurationElement element) {
			super(element);
			this.providerConfiguration = ExtentedElementTypeActionProviderConfiguration.parse(element);
			Assert.isNotNull(providerConfiguration);
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
		 */
		public boolean provides(IOperation operation) {
			if(!super.provides(operation)) {
				return false;
			}
			if(operation instanceof GetAllExtendedElementTypeActionProvidersOperation) {
				return true;
			}
			if(operation instanceof GetExtendedElementTypeActionProviderOperation) {
				String providerConfigurationClassName = providerConfiguration.getConfigurationClassName();
				if(providerConfigurationClassName == null) {
					Activator.log.error("Error during the parsing of the action configuration extension point", null);
					return false;
				}
				String configurationClassName = ((GetExtendedElementTypeActionProviderOperation)operation).getActionConfiguration().eClass().getInstanceClassName();
				return providerConfigurationClassName.equals(configurationClassName);
			}
			return false;
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.core.service.Service.ProviderDescriptor#getProvider()
		 */
		public IProvider getProvider() {
			if(provider == null) {
				IProvider newProvider = super.getProvider();
				if(provider instanceof IExtendedElementTypeActionProvider) {
					IExtendedElementTypeActionProvider defaultProvider = (IExtendedElementTypeActionProvider)newProvider;
					defaultProvider.setConfiguration(getElement());
				}
				return newProvider;
			}
			return super.getProvider();
		}
	}

}
