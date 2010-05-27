/*****************************************************************************
 * Copyright (c) 2010 Atos Origin
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigator.providers;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.papyrus.core.extension.ExtensionException;
import org.eclipse.papyrus.core.extension.ExtensionUtils;

public class ProviderAdapterFactoryReader extends ExtensionUtils{

	/** singleton eINSTANCE of this class */
	public final static ProviderAdapterFactoryReader eINSTANCE = new ProviderAdapterFactoryReader();

	public final static String PROVIDER_ADAPTER_FACTORY_EXTENSIONPOINT = "providerAdapterFactory";

	public final static String ADAPTER_FACTORY_CLASS_ATTR = "adapterFactoryClass";
	
	/**
	 * @return the eINSTANCE
	 */
	public static ProviderAdapterFactoryReader getInstance() {
		return eINSTANCE;
	}

	/**
	 * Create a factory instance corresponding to the ConfigurationElement.
	 * 
	 * @param element
	 *        an {@link IConfigurationElement} see eclipse extension point
	 * @return an instance of the factory
	 * @throws ExtensionException
	 **/
	@SuppressWarnings("unchecked")
	public AdapterFactory createProviderAdapterFactory(IConfigurationElement element) throws ExtensionException {
		checkTagName(element, PROVIDER_ADAPTER_FACTORY_EXTENSIONPOINT);
		
		Class<AdapterFactory> adapterFactoryClass = (Class<AdapterFactory>)parseClass(element, ADAPTER_FACTORY_CLASS_ATTR,
				PROVIDER_ADAPTER_FACTORY_EXTENSIONPOINT);
		try {
			return adapterFactoryClass.newInstance();
		} catch (Exception e) {
			throw new ExtensionException(e.getLocalizedMessage());
		}
	}
}